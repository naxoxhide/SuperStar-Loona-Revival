import re

# 1. Fix Camera2Wrapper.java
with open("app/src/main/java/com/unity3d/player/Camera2Wrapper.java", "r", encoding="utf-8") as f:
    code = f.read()

code = code.replace("private Context a;", "private Context mContext;")
code = code.replace("this.a = context;", "this.mContext = context;")
code = code.replace("this.a)", "this.mContext)")
code = code.replace("this.a,", "this.mContext,")
code = code.replace("this.a;", "this.mContext;")
with open("app/src/main/java/com/unity3d/player/Camera2Wrapper.java", "w", encoding="utf-8") as f:
    f.write(code)

# 2. Fix c.java getCameraIds
with open("app/src/main/java/com/unity3d/player/c.java", "r", encoding="utf-8") as f:
    code = f.read()

# Add getCameraIds if missing or fix declaration
if "private static String[] getCameraIds" not in code and "public static String[] getCameraIds" not in code:
    code = code.replace("private static String[] sCameraIds;", """private static String[] sCameraIds;
    public static String[] getCameraIds(Context context) {
        if (sCameraIds == null) {
            try {
                sCameraIds = b(context).getCameraIdList();
            } catch (CameraAccessException e2) {
                com.unity3d.player.f.Log(6, "Camera2: CameraAccessException " + e2);
                sCameraIds = new String[0];
            }
        }
        return sCameraIds;
    }""")

with open("app/src/main/java/com/unity3d/player/c.java", "w", encoding="utf-8") as f:
    f.write(code)

# 3. Fix UnityPlayer.java
with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "r", encoding="utf-8") as f:
    code = f.read()

# Fix inner thread field d collision with enum d
code = code.replace("int d;\n        int e;\n        int f;\n        int g;\n        int h;", "int mRunState;\n        int mStateE;\n        int mStateF;\n        int mStateG;\n        int mStateH;")
code = code.replace("this.d = 1;", "this.mRunState = 1;")
code = code.replace("this.d = 2;", "this.mRunState = 2;")
code = code.replace("this.d = 3;", "this.mRunState = 3;")

# Fix CertificateUtil
code = code.replace("CertificateUtil.DELIMITER", '":"')

# Fix HFPStatus and AudioVolumeHandler
code = code.replace("hFPStatue.a.a();", "if (this.m_HFPStatus != null) this.m_HFPStatus.a();")
code = code.replace("audioVolumeHandlee.b.a();", "if (this.m_AudioVolumeHandler != null) this.m_AudioVolumeHandler.a();")

# Fix softinputdialog
code = code.replace("new i(UnityPlayer.this.mContext, this,", "new i(UnityPlayer.this.mContext, UnityPlayer.this,")

# Fix constructor super calls
# In JADX decompiled inner classes, sometimes statements appear before super()
code = re.sub(r'public ([a-zA-Z0-9_]+)\(([^)]*)\)\s*\{([^}]*?)super\(([^)]*)\);', r'public \1(\2) {\n                super(\4);\n                \3', code)

with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "w", encoding="utf-8") as f:
    f.write(code)

print("[+] Cleaned Camera2Wrapper, c.java, and UnityPlayer.java")
