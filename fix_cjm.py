import re

# 1. Fix c.java
with open("app/src/main/java/com/unity3d/player/c.java", "r", encoding="utf-8") as f:
    content = f.read()

content = content.replace("private static Semaphore e = new Semaphore(1);", "private static Semaphore sSemaphore = new Semaphore(1);")
content = content.replace("private static String[] c;", "private static String[] sCameraIds;")
content = content.replace("c.e.", "sSemaphore.")
content = content.replace("c.e", "sSemaphore")
content = content.replace("c.c.", "sCameraIds.")
content = content.replace("c.c[", "sCameraIds[")
content = content.replace("c.c;", "sCameraIds;")
content = content.replace("c.c ", "sCameraIds ")
content = content.replace("c.c)", "sCameraIds)")
content = content.replace("= c;", "= sCameraIds;")

content = content.replace("this.z = a.c;", "this.z = c.a.c;")
content = content.replace("this.z != a.f2959b", "this.z != c.a.f2959b")
content = content.replace("this.z == a.f2959b", "this.z == c.a.f2959b")
content = content.replace("this.z = a.a;", "this.z = c.a.a;")
content = content.replace("this.z = a.f2959b;", "this.z = c.a.f2959b;")
content = content.replace("private int z = a.c;", "private int z = c.a.c;")

with open("app/src/main/java/com/unity3d/player/c.java", "w", encoding="utf-8") as f:
    f.write(content)
print("[+] c.java fixed")

# 2. Fix j.java
with open("app/src/main/java/com/unity3d/player/j.java", "r", encoding="utf-8") as f:
    content = f.read()

content = content.replace("a.c", "j.a.c")
content = content.replace("a.a", "j.a.a")
content = content.replace("a.f2963b", "j.a.f2963b")
content = content.replace("a.b", "j.a.f2963b")

with open("app/src/main/java/com/unity3d/player/j.java", "w", encoding="utf-8") as f:
    f.write(content)
print("[+] j.java fixed")

# 3. Fix m.java
with open("app/src/main/java/com/unity3d/player/m.java", "r", encoding="utf-8") as f:
    content = f.read()

content = re.sub(r'\bm\.a\b', 'f.a', content)
content = re.sub(r'\bm\.b\(', 'm.this.b(', content)

with open("app/src/main/java/com/unity3d/player/m.java", "w", encoding="utf-8") as f:
    f.write(content)
print("[+] m.java fixed")
