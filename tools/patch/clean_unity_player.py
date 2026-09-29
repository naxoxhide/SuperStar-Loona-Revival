import re

with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "r", encoding="utf-8") as f:
    content = f.read()

# Fix corrupted strings from bad replaces
content = content.replace("thie.a.", "this.")
content = content.replace("thie.a", "this")
content = content.replace("com.unity3d.playee.b.com.unity3d.player.f.Log", "com.unity3d.player.f.Log")
content = content.replace("playee.b.com.unity3d.player", "com.unity3d.player")
content = content.replace("typedArrayObtainStyledAttributee.a.", "typedArrayObtainStyledAttributes.")
content = content.replace("m_Evente.a.", "m_Events.")
content = content.replace("eVae.b.", "eVar.")
content = content.replace("nVae.b.", "nVar.")
content = content.replace("hVae.b.", "hVar.")
content = content.replace("camera2Wrappee.b.", "camera2Wrapper.")
content = content.replace("j.a.a()", "j.a.values()")
content = content.replace("b.f2945b", "1")

# Clean any remaining f.Log
content = re.sub(r'(?<!com\.unity3d\.player\.)\bf\.Log\(', 'com.unity3d.player.f.Log(', content)

with open("app/src/main/java/com/unity3d/player/UnityPlayer.java", "w", encoding="utf-8") as f:
    f.write(content)

print("[+] UnityPlayer.java cleaned successfully")
