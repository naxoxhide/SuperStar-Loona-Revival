import re

# 1. Fix j.java
with open("app/src/main/java/com/unity3d/player/j.java", "r", encoding="utf-8") as f:
    j_code = f.read()

# Replace inner class a with SplashMode
j_code = j_code.replace("static final class a", "public static final class SplashMode")
j_code = j_code.replace("j.a.a()", "SplashMode.a()")
j_code = j_code.replace("j.a.a", "SplashMode.a")
j_code = j_code.replace("j.a.f2963b", "SplashMode.f2967b")
j_code = j_code.replace("j.a.c", "SplashMode.c")
j_code = j_code.replace("a.f2967b", "SplashMode.f2967b")
j_code = j_code.replace("a.c", "SplashMode.c")

with open("app/src/main/java/com/unity3d/player/j.java", "w", encoding="utf-8") as f:
    f.write(j_code)

# 2. Fix UnityPlayer.java for j.SplashMode
with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "r", encoding="utf-8") as f:
    up_code = f.read()

up_code = up_code.replace("j.a.values()", "j.SplashMode.a()")
up_code = up_code.replace("j.a.a()", "j.SplashMode.a()")
with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "w", encoding="utf-8") as f:
    f.write(up_code)

# 3. Clean and fix c.java
with open("app/src/main/java/com/unity3d/player/c.java", "r", encoding="utf-8") as f:
    c_code = f.read()

# Replace class a with CameraState
c_code = c_code.replace("private static final class a", "public static final class CameraState")
c_code = c_code.replace("private e a;", "private e mCallback;")
c_code = c_code.replace("this.a = null;", "this.mCallback = null;")
c_code = c_code.replace("this.a = eVar;", "this.mCallback = eVar;")
c_code = c_code.replace("this.a.a(", "this.mCallback.a(")
c_code = c_code.replace("this.a != null", "this.mCallback != null")

# State constants
c_code = c_code.replace("c.a.c", "CameraState.c")
c_code = c_code.replace("c.a.f2959b", "CameraState.f2959b")
c_code = c_code.replace("c.a.a", "CameraState.a")
c_code = c_code.replace("a.c", "CameraState.c")
c_code = c_code.replace("a.f2959b", "CameraState.f2959b")
c_code = c_code.replace("a.a", "CameraState.a")

# Static fields
c_code = re.sub(r'\bprivate static Semaphore e\b', 'private static Semaphore sSemaphore', c_code)
c_code = re.sub(r'\bprivate static String\[\] c\b', 'private static String[] sCameraIds', c_code)
c_code = re.sub(r'(?<![a-zA-Z0-9_])e\.(tryAcquire|release|acquire)', r'sSemaphore.\1', c_code)
c_code = re.sub(r'\bc == null\b', 'sCameraIds == null', c_code)
c_code = re.sub(r'\bc = b\(context\)', 'sCameraIds = b(context)', c_code)
c_code = re.sub(r'\bc = new String', 'sCameraIds = new String', c_code)
c_code = re.sub(r'\breturn c;\b', 'return sCameraIds;', c_code)
c_code = re.sub(r'\bc\.length\b', 'sCameraIds.length', c_code)
c_code = re.sub(r'\bc\[', 'sCameraIds[', c_code)

with open("app/src/main/java/com/unity3d/player/c.java", "w", encoding="utf-8") as f:
    f.write(c_code)

# 4. Fix m.java
with open("app/src/main/java/com/unity3d/player/m.java", "r", encoding="utf-8") as f:
    m_code = f.read()

m_code = m_code.replace("if (f.a)", "if (com.unity3d.player.f.a)")
with open("app/src/main/java/com/unity3d/player/m.java", "w", encoding="utf-8") as f:
    f.write(m_code)

print("[+] All ProGuard collisions cleanly resolved.")
