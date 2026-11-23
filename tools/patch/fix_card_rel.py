with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    content = f.read()

# Fix the card image path: 10001 + i
old_rel = """                            var sCardRel = "asiudgasg/asodhsg/wadceg/1001" + i + "_s.i.bytes";
                            var lCardRel = "asiudgasg/asodhsg/wadceg/1001" + i + "_l.i.bytes";"""

new_rel = """                            var sCardRel = "asiudgasg/asodhsg/wadceg/" + (10001 + i) + "_s.i.bytes";
                            var lCardRel = "asiudgasg/asodhsg/wadceg/" + (10001 + i) + "_l.i.bytes";"""

if old_rel in content:
    content = content.replace(old_rel, new_rel, 1)
    print("[+] Updated card image paths to 10001 + i")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(content)

with open('app/src/main/lib/arm64-v8a/libscript.so', 'w', encoding='utf-8') as f:
    f.write(content)

print("[+] Synced libscript.js and libscript.so")
