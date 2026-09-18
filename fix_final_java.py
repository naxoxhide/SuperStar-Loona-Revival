import re

# 1. Fix Camera2Wrapper.java
with open("app/src/main/java/com/unity3d/player/Camera2Wrapper.java", "r", encoding="utf-8") as f:
    code = f.read()

code = code.replace("private final int c = 100;", "private final int kConstant = 100;")
with open("app/src/main/java/com/unity3d/player/Camera2Wrapper.java", "w", encoding="utf-8") as f:
    f.write(code)

# 2. Fix UnityPlayerActivity.java
with open("app/src/main/java/com/unity3d/player/UnityPlayerActivity.java", "r", encoding="utf-8") as f:
    code = f.read()

code = re.sub(r'import com\.tapjoy\..*?;', '', code)
code = re.sub(r'TapjoyConstants\.TJC_PLUGIN_UNITY', '"unity"', code)
with open("app/src/main/java/com/unity3d/player/UnityPlayerActivity.java", "w", encoding="utf-8") as f:
    f.write(code)

# 3. Fix CWebViewPlugin.java
with open("app/src/main/java/net/gree/unitywebview/CWebViewPlugin.java", "r", encoding="utf-8") as f:
    code = f.read()

code = re.sub(r'import com\.tapjoy\..*?;', '', code)
with open("app/src/main/java/net/gree/unitywebview/CWebViewPlugin.java", "w", encoding="utf-8") as f:
    f.write(code)

# 4. Fix UnityPlayer.java
with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "r", encoding="utf-8") as f:
    code = f.read()

code = re.sub(r'import com\.facebook\..*?;', '', code)

# Rename enum d to UnityRunState
code = code.replace("enum d {", "enum UnityRunState {")
code = re.sub(r'\bd\.(PAUSE|RESUME|QUIT|SURFACE_LOST|SURFACE_ACQUIRED|FOCUS_LOST|FOCUS_GAINED|NEXT_FRAME|URL_ACTIVATED|ORIENTATION_ANGLE_CHANGE)', r'UnityRunState.\1', code)
code = re.sub(r'\bprivate void a\(d dVar\)', 'private void a(UnityRunState dVar)', code)
code = re.sub(r'\bd dVar = \(d\)', 'UnityRunState dVar = (UnityRunState)', code)
code = code.replace("UnityRunState dVar", "UnityRunState runState")
code = code.replace("dVar ==", "runState ==")
code = code.replace("dVar)", "runState)")

# Restore fields in inner class e
code = code.replace("int mRunState;", "int d;")
code = code.replace("int mStateE;", "int e;")
code = code.replace("int mStateF;", "int f;")
code = code.replace("int mStateG;", "int g;")
code = code.replace("int mStateH;", "int h;")
code = code.replace("this.mRunState", "this.d")

# Fix anonymous classes constructors calling super
code = re.sub(r'\{\s*super\(UnityPlayer\.this,\s*\(byte\)\s*0\);\s*\}', '', code)

with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "w", encoding="utf-8") as f:
    f.write(code)

print("[+] Cleaned UnityPlayer, UnityPlayerActivity, CWebViewPlugin, Camera2Wrapper")
