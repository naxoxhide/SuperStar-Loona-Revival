import os
import re

UNITY_DIR = "app/src/main/java/com/unity3d/player"

def fix_c_java():
    path = os.path.join(UNITY_DIR, "c.java")
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()

    # Replace field collisions
    content = re.sub(r'\bf\.Log\(', 'com.unity3d.player.f.Log(', content)
    content = content.replace("c.e.release()", "sSemaphore.release()")
    content = content.replace("c.e.tryAcquire()", "sSemaphore.tryAcquire()")
    content = content.replace("c.e.acquire()", "sSemaphore.acquire()")
    content = content.replace("private Semaphore e = new Semaphore(1);", "private static Semaphore sSemaphore = new Semaphore(1);")
    content = content.replace("private String[] c = null;", "private static String[] sCameraIds = null;")
    content = content.replace("c.c.length", "sCameraIds.length")
    content = content.replace("c.c[", "sCameraIds[")

    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print("[+] Fixed c.java")

def fix_unity_player():
    path = os.path.join(UNITY_DIR, "UnityPlayer.java")
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()

    content = re.sub(r'\bf\.Log\(', 'com.unity3d.player.f.Log(', content)
    content = content.replace("s.a", "e.a.a")
    content = content.replace("s.b", "e.a.b")
    content = content.replace("s.c", "e.a.c")
    content = content.replace("s.d", "e.a.d")
    content = content.replace("s.e", "e.a.e")
    content = content.replace("s.f", "e.a.f")
    content = content.replace("s.g", "e.a.g")

    content = content.replace("r.a", "e.b.a")
    content = content.replace("r.b", "e.b.b")
    content = content.replace("r.c", "e.b.c")

    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print("[+] Fixed UnityPlayer.java")

def fix_reflection_helper():
    path = os.path.join(UNITY_DIR, "ReflectionHelper.java")
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()

    content = re.sub(r'\bf\.Log\(', 'com.unity3d.player.f.Log(', content)
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print("[+] Fixed ReflectionHelper.java")

def fix_all_player_files():
    for root, _, files in os.walk(UNITY_DIR):
        for file in files:
            if file.endswith(".java"):
                p = os.path.join(root, file)
                with open(p, "r", encoding="utf-8") as f:
                    c = f.read()
                c_fixed = re.sub(r'(?<!com\.unity3d\.player\.)\bf\.Log\(', 'com.unity3d.player.f.Log(', c)
                if c_fixed != c:
                    with open(p, "w", encoding="utf-8") as f:
                        f.write(c_fixed)
                    print(f"[+] Fixed f.Log in: {file}")

if __name__ == '__main__':
    fix_c_java()
    fix_unity_player()
    fix_reflection_helper()
    fix_all_player_files()
