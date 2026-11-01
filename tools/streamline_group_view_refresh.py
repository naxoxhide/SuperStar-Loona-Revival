with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    js = f.read()

target = '''                                     for (var i = 0; i < cardCount; i++) {
                                         var cardSmallView = cardItemsPtr.add(0x20 + i * 8).readPointer();
                                         if (!cardSmallView.isNull()) {
                                             if (i >= curSlotCount) {
                                                 try {
                                                     var go = getGameObjectFn(cardSmallView, NULL);
                                                     if (!go.isNull()) {
                                                         setActiveFn(go, 0, NULL);
                                                     }
                                                 } catch (eHide) {}
                                                 continue;
                                             }
                                             try {
                                                 var go = getGameObjectFn(cardSmallView, NULL);
                                                 if (!go.isNull()) {
                                                     setActiveFn(go, 1, NULL);
                                                 }
                                             } catch (eShow) {}

                                             var targetArtistCode = (i < curArtistCodes.length) ? curArtistCodes[i] : null;
                                             var targetCard = eqCards.find(function(c) {
                                                 var cm = getCardMetadata(c.cardID);
                                                 return cm && (cm.groupID || cm.group) === curGroupCode && cm.artistID === targetArtistCode;
                                             });
                                             if (targetCard) {
                                                 // Slot IS EQUIPPED with active card
                                                 var cId = targetCard.cardID;
                                                 var gr = targetCard.grade;
                                                 var lvl = targetCard.level;
                                                 var isPrism = !!targetCard.isPrism;
                                                 var cardParam = createMockSmallCardParams(cId, gr, lvl, false, isPrism);
                                                 if (cardParam && !cardParam.isNull()) {
                                                     cardRefreshFn(cardSmallView, cardParam, NULL);
                                                 }
                                                 try {
                                                     setTierVis(cardSmallView, 1);
                                                     if (gr === 4) {
                                                         setStarVis(cardSmallView, 0);
                                                         setNumVis(cardSmallView, 1);
                                                     } else {
                                                         setStarVis(cardSmallView, 1);
                                                         setNumVis(cardSmallView, 0);
                                                     }
                                                 } catch (eVisEq) {}

                                                 // Deactivate ImageEfftect (horizontal gray line artifact)
                                                 try {
                                                     var imgEff = cardSmallView.add(0xC8).readPointer();
                                                     if (!imgEff.isNull()) {
                                                         var effGo = getGameObjectFn(imgEff, NULL);
                                                         if (!effGo.isNull()) setActiveFn(effGo, 0, NULL);
                                                     }
                                                 } catch (eEff) {}

                                                 // Direct texture injection strictly from wadceg (unity garage pinned)
                                                 try {
                                                     var photoRawImg = cardSmallView.add(0x58).readPointer();
                                                     if (!photoRawImg.isNull()) {
                                                         var photoTex = loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_l.i.bytes") ||
                                                                        loadLocalTexture2D("asiudgasg/asodhsg/wadceg/" + cId + "_s.i.bytes");
                                                         if (photoTex && !photoTex.isNull()) {
                                                             var setTextureFn = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                                             setTextureFn(photoRawImg, photoTex, NULL);
                                                             var setEnabledFn = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                                                             setEnabledFn(photoRawImg, 1, NULL);
                                                             var pGo = getGameObjectFn(photoRawImg, NULL);
                                                             if (!pGo.isNull()) setActiveFn(pGo, 1, NULL);

                                                         }
                                                     }

                                                     var tierRawImg = cardSmallView.add(0x68).readPointer();
                                                     if (!tierRawImg.isNull()) {
                                                         var gLetter = (gr === 4) ? "r" : (gr === 3) ? "s" : (gr === 2) ? "a" : (gr === 1) ? "b" : "c";
                                                         var tierPath = (gLetter === "b") ? "asiudgasg/asodhsg/aoeiwhslc/uhex/0b_s.i.bytes" : ("asiudgasg/asodhsg/aoeiwhslc/uhex/0_" + gLetter + "_s.i.bytes");
                                                         var tierTex = loadLocalTexture2D(tierPath);
                                                         if (tierTex && !tierTex.isNull()) {
                                                             var setTextureFn2 = new NativeFunction(baseAddr.add(0x194C074), "void", ["pointer", "pointer", "pointer"]);
                                                             setTextureFn2(tierRawImg, tierTex, NULL);
                                                             var setEnabledFn2 = new NativeFunction(baseAddr.add(0x1DB3CFC), "void", ["pointer", "int", "pointer"]);
                                                             setEnabledFn2(tierRawImg, 1, NULL);
                                                             var tGo = getGameObjectFn(tierRawImg, NULL);
                                                             if (!tGo.isNull()) setActiveFn(tGo, 1, NULL);

                                                             // RawImage.SetNativeSize (0x194C1C8) to ensure 116x156 native dimensions
                                                             try {
                                                                 var setNativeSizeFn = new NativeFunction(baseAddr.add(0x194C1C8), "void", ["pointer", "pointer"]);
                                                                 setNativeSizeFn(tierRawImg, NULL);
                                                             } catch (eSns) {}
                                                         }
                                                     }
                                                 } catch (ePhotoInj) {}
                                             } else {
                                                 // Slot IS UNEQUIPPED: show empty placeholder from sdhgauwehdnu
                                                 var emptyCardId = 1001 + mIdx;
                                                 var emptyParam = createMockEmptySmallCardParams(emptyCardId);
                                                 if (emptyParam && !emptyParam.isNull()) {
                                                     cardRefreshFn(cardSmallView, emptyParam, NULL);
                                                 }
                                                 try {
                                                     setTierVis(cardSmallView, 0);
                                                     setStarVis(cardSmallView, 0);
                                                     setNumVis(cardSmallView, 0);
                                                 } catch (eVisEmpty) {}
                                             }
                                         }
                                     }'''

replacement = '''                                     for (var i = 0; i < cardCount; i++) {
                                         try {
                                             var cardSmallView = cardItemsPtr.add(0x20 + i * 8).readPointer();
                                             if (!cardSmallView.isNull()) {
                                                 if (i >= curSlotCount) {
                                                     try {
                                                         var go = getGameObjectFn(cardSmallView, NULL);
                                                         if (!go.isNull()) {
                                                             setActiveFn(go, 0, NULL);
                                                         }
                                                     } catch (eHide) {}
                                                     continue;
                                                 }
                                                 try {
                                                     var go = getGameObjectFn(cardSmallView, NULL);
                                                     if (!go.isNull()) {
                                                         setActiveFn(go, 1, NULL);
                                                     }
                                                 } catch (eShow) {}

                                                 var targetArtistCode = (i < curArtistCodes.length) ? curArtistCodes[i] : null;
                                                 var targetCard = eqCards.find(function(c) {
                                                     var cm = getCardMetadata(c.cardID);
                                                     return cm && (cm.groupID || cm.group) === curGroupCode && cm.artistID === targetArtistCode;
                                                 });
                                                 if (targetCard) {
                                                     // Slot IS EQUIPPED with active card
                                                     var cId = targetCard.cardID;
                                                     var gr = targetCard.grade;
                                                     var lvl = targetCard.level;
                                                     var isPrism = !!targetCard.isPrism;
                                                     var cardParam = createMockSmallCardParams(cId, gr, lvl, false, isPrism);
                                                     if (cardParam && !cardParam.isNull()) {
                                                         cardRefreshFn(cardSmallView, cardParam, NULL);
                                                     }
                                                     try {
                                                         setTierVis(cardSmallView, 1);
                                                         if (gr === 4) {
                                                             setStarVis(cardSmallView, 0);
                                                             setNumVis(cardSmallView, 1);
                                                         } else {
                                                             setStarVis(cardSmallView, 1);
                                                             setNumVis(cardSmallView, 0);
                                                         }
                                                     } catch (eVisEq) {}

                                                     // Deactivate ImageEfftect (horizontal gray line artifact)
                                                     try {
                                                         var imgEff = cardSmallView.add(0xC8).readPointer();
                                                         if (!imgEff.isNull()) {
                                                             var effGo = getGameObjectFn(imgEff, NULL);
                                                             if (!effGo.isNull()) setActiveFn(effGo, 0, NULL);
                                                         }
                                                     } catch (eEff) {}
                                                 } else {
                                                     // Slot IS UNEQUIPPED: show empty placeholder from sdhgauwehdnu
                                                     var emptyCardId = (targetArtistCode || (1001 + i));
                                                     var emptyParam = createMockEmptySmallCardParams(emptyCardId);
                                                     if (emptyParam && !emptyParam.isNull()) {
                                                         cardRefreshFn(cardSmallView, emptyParam, NULL);
                                                     }
                                                     try {
                                                         setTierVis(cardSmallView, 0);
                                                         setStarVis(cardSmallView, 0);
                                                         setNumVis(cardSmallView, 0);
                                                     } catch (eVisEmpty) {}
                                                 }
                                             }
                                         } catch (eSlot) {
                                             log("[-] Slot " + i + " error: " + eSlot.message);
                                         }
                                     }'''

if target in js:
    js = js.replace(target, replacement, 1)
    print("Successfully replaced InvenGroupItemView card loop with streamlined, bulletproof implementation!")
else:
    print("FAIL: target block not found")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(js)
