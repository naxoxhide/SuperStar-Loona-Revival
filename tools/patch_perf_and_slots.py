with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    js = f.read()

# 1. Guard ensureLoonaMocks to execute only once
target1 = '''                function ensureLoonaMocks() {
                    log("[🔍 LOONA_MOCKS CALLER] " + (new Error()).stack);
                    try {'''

replace1 = '''                var isLoonaMocksInitialized = false;
                function ensureLoonaMocks() {
                    if (isLoonaMocksInitialized) return;
                    isLoonaMocksInitialized = true;
                    log("[🔍 LOONA_MOCKS] Initializing mock groups, artists and FastArrays (one-time execution)...");
                    try {'''

if target1 in js:
    js = js.replace(target1, replace1, 1)
    print("1. Successfully added one-time execution guard to ensureLoonaMocks!")
else:
    print("FAIL 1: target1 not found")

# 2. Fix tier frame path for grade B and remove dangerous setSizeDeltaFn in InvenGroupItemView.Refresh
target2 = '''                                                            // Calibrate photo dimensions to BasicSize (92, 130)
                                                            try {
                                                                var getRectTrFn = new NativeFunction(baseAddr.add(0x1614EF0), "pointer", ["pointer", "pointer"]);
                                                                var setSizeDeltaFn = new NativeFunction(baseAddr.add(0x180DC18), "void", ["pointer", "float", "float", "pointer"]);
                                                                var photoRectTr = getRectTrFn(photoRawImg, NULL);
                                                                if (!photoRectTr.isNull()) {
                                                                    setSizeDeltaFn(photoRectTr, 92.0, 130.0, NULL);
                                                                }
                                                            } catch (ePsz) {}
                                                        }
                                                    }

                                                    var tierRawImg = cardSmallView.add(0x68).readPointer();
                                                    if (!tierRawImg.isNull()) {
                                                        var gLetter = (gr === 4) ? "r" : (gr === 3) ? "s" : (gr === 2) ? "a" : (gr === 1) ? "b" : "c";
                                                        var tierTex = loadLocalTexture2D("asiudgasg/asodhsg/aoeiwhslc/uhex/0_" + gLetter + "_s.i.bytes");'''

replace2 = '''                                                        }
                                                    }

                                                    var tierRawImg = cardSmallView.add(0x68).readPointer();
                                                    if (!tierRawImg.isNull()) {
                                                        var gLetter = (gr === 4) ? "r" : (gr === 3) ? "s" : (gr === 2) ? "a" : (gr === 1) ? "b" : "c";
                                                        var tierPath = (gLetter === "b") ? "asiudgasg/asodhsg/aoeiwhslc/uhex/0b_s.i.bytes" : ("asiudgasg/asodhsg/aoeiwhslc/uhex/0_" + gLetter + "_s.i.bytes");
                                                        var tierTex = loadLocalTexture2D(tierPath);'''

if target2 in js:
    js = js.replace(target2, replace2, 1)
    print("2. Removed setSizeDeltaFn and fixed tierPath for grade B!")
else:
    print("FAIL 2: target2 not found")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(js)

print("Finished applying performance & slot patches!")
