import re

# 1. Fix Camera2Wrapper.java
with open("app/src/main/java/com/unity3d/player/Camera2Wrapper.java", "r", encoding="utf-8") as f:
    cam_code = f.read()

cam_code = cam_code.replace("private int c;", "private int mCameraId;")
cam_code = cam_code.replace("this.c = ", "this.mCameraId = ")
cam_code = cam_code.replace("this.c)", "this.mCameraId)")
cam_code = cam_code.replace("this.c;", "this.mCameraId;")
cam_code = cam_code.replace("this.c,", "this.mCameraId,")
with open("app/src/main/java/com/unity3d/player/Camera2Wrapper.java", "w", encoding="utf-8") as f:
    f.write(cam_code)

# 2. Fix HFPStatus.java
with open("app/src/main/java/com/unity3d/player/HFPStatus.java", "r", encoding="utf-8") as f:
    hfp_code = f.read()

hfp_code = hfp_code.replace("private Context a;", "private Context mContext;")
hfp_code = hfp_code.replace("this.a = context;", "this.mContext = context;")
hfp_code = hfp_code.replace("this.a.registerReceiver", "this.mContext.registerReceiver")
hfp_code = hfp_code.replace("this.a.unregisterReceiver", "this.mContext.unregisterReceiver")
hfp_code = hfp_code.replace("this.a.getSystemService", "this.mContext.getSystemService")

with open("app/src/main/java/com/unity3d/player/HFPStatus.java", "w", encoding="utf-8") as f:
    f.write(hfp_code)

# 3. Fix c.java getCameraIds
with open("app/src/main/java/com/unity3d/player/c.java", "r", encoding="utf-8") as f:
    c_code = f.read()

# Replace the method declaration of getCameraIdList
c_code = re.sub(r'public static String\[\] c\(Context context\)', 'public static String[] getCameraIds(Context context)', c_code)
c_code = re.sub(r'private static String\[\] c\(Context context\)', 'private static String[] getCameraIds(Context context)', c_code)
c_code = re.sub(r'\bc\(context\)', 'getCameraIds(context)', c_code)
c_code = c_code.replace("return c;", "return sCameraIds;")

with open("app/src/main/java/com/unity3d/player/c.java", "w", encoding="utf-8") as f:
    f.write(c_code)

# 4. Clean UnityPlayer.java leftover names
with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "r", encoding="utf-8") as f:
    up_code = f.read()

up_code = up_code.replace("orientationEventListenee.b.", "orientationEventListener.")
up_code = up_code.replace("iVae.b.a", "iVar.a")
up_code = up_code.replace("iVae.b.", "iVar.")

with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "w", encoding="utf-8") as f:
    f.write(up_code)

print("[+] Fixed Camera2Wrapper, HFPStatus, c.java, UnityPlayer.java")
