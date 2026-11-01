import re

with open('app/src/main/assets/libscript.js', 'r', encoding='utf-8') as f:
    js = f.read()

# 1. Neutralize CardListCompare (0xF288A4) -> ret in installNativeRvaHooks
card_shield_code = '''        // Neutralize CardListCompare (0xF288A4) -> ret to prevent crash on non-1001 groups & 670x redundant comparison
        try {
            Memory.protect(baseAddr.add(0xF288A4), 4, "rwx");
            baseAddr.add(0xF288A4).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]); // ret
            log("[🛡️ CARD SHIELD] Successfully neutralized CardListCompare with RET!");
        } catch (eClc) {
            log("[-] Error patching CardListCompare: " + eClc.message);
        }'''

target1 = '''        // Neutralize Storage<long, Card>.Add (0x1E64C1C) -> ret so offline cards add without Storage exception
        try {
            Memory.protect(baseAddr.add(0x1E64C1C), 4, "rwx");
            baseAddr.add(0x1E64C1C).writeByteArray([0xc0, 0x03, 0x5f, 0xd6]); // ret
            log("[🛡️ STORAGE SHIELD] Successfully neutralized Storage<long, Card>.Add with RET!");
        } catch (eSt) {
            log("[-] Error patching Storage.Add: " + eSt.message);
        }'''

if target1 in js:
    js = js.replace(target1, target1 + "\n\n" + card_shield_code, 1)
    print("1. Injected CardListCompare shield into installNativeRvaHooks!")
else:
    print("FAIL 1: target1 not found")

# 2. Normalization in getCardMetadata
target2 = '''                function getCardMetadata(cardId) {
                    var meta = getGlobalMetadata();
                    if (meta && meta.cards && meta.cards[cardId]) {
                        return meta.cards[cardId];
                    }'''

replace2 = '''                function getCardMetadata(cardId) {
                    var meta = getGlobalMetadata();
                    if (meta && meta.cards && meta.cards[cardId]) {
                        var c = meta.cards[cardId];
                        if (c.groupID && !c.group) c.group = c.groupID;
                        if (c.group && !c.groupID) c.groupID = c.group;
                        if (c.type === 1) c.isPrism = true;
                        if (c.material === 1) c.isMaterial = true;
                        return c;
                    }'''

if target2 in js:
    js = js.replace(target2, replace2, 1)
    print("2. Updated getCardMetadata with normalization!")
else:
    print("FAIL 2: target2 not found")

# 3. sortLoonaCardItems: sort by group and artist
target3 = '''                            // 2. Member order (1001..1011)
                            var mA = ((cIdA - 1001) % 11);
                            var mB = ((cIdB - 1001) % 11);
                            if (mA !== mB) return mA - mB;'''

replace3 = '''                            // 2. Group & Artist order
                            var metaA = getCardMetadata(cIdA);
                            var metaB = getCardMetadata(cIdB);
                            var gA = (metaA && (metaA.groupID || metaA.group)) ? (metaA.groupID || metaA.group) : 1001;
                            var gB = (metaB && (metaB.groupID || metaB.group)) ? (metaB.groupID || metaB.group) : 1001;
                            if (gA !== gB) return gA - gB;
                            var aA = (metaA && metaA.artistID) ? metaA.artistID : cIdA;
                            var aB = (metaB && metaB.artistID) ? metaB.artistID : cIdB;
                            if (aA !== aB) return aA - aB;'''

if target3 in js:
    js = js.replace(target3, replace3, 1)
    print("3. Updated sortLoonaCardItems comparator!")
else:
    print("FAIL 3: target3 not found")

# 4. InvenGroupItemView: loop up to slotCount and match targetArtist
target4 = '''                                var profile = loadPlayerProfile();
                                var cardSmallParamsList = [];
                                for (var mi = 0; mi < 11; mi++) {
                                    // Find best equipped card for this member, fallback to best unequipped
                                    var memberCards = (profile && profile.inventoryCards) ?
                                        profile.inventoryCards.filter(function(c) { return ((c.cardID - 1001) % 11) === mi; }) : [];
                                    var eqCard = memberCards.find(function(c) { return c.isEquip; });
                                    var bestCard = eqCard || (memberCards.length > 0 ? memberCards[0] : null);
                                    var cIdMi = bestCard ? bestCard.cardID : (1001 + mi);
                                    var grMi = bestCard ? (bestCard.grade !== undefined ? bestCard.grade : 4) : 4;
                                    var lvlMi = bestCard ? (bestCard.level || 50) : 50;
                                    var isEqMi = bestCard ? !!bestCard.isEquip : false;
                                    var smallParam = createMockSmallCardParams(cIdMi, grMi, lvlMi, isEqMi);
                                    cardSmallParamsList.push(smallParam || NULL);
                                }'''

replace4 = '''                                var profile = loadPlayerProfile();
                                var cardSmallParamsList = [];
                                var curArtistCodes = (gMeta && gMeta.artistCodes) ? gMeta.artistCodes : [];
                                for (var mi = 0; mi < slotCount; mi++) {
                                    var targetArtist = (mi < curArtistCodes.length) ? curArtistCodes[mi] : null;
                                    var memberCards = (profile && profile.inventoryCards) ?
                                        profile.inventoryCards.filter(function(c) {
                                            var cm = getCardMetadata(c.cardID);
                                            return cm && (cm.groupID || cm.group) === gCode && cm.artistID === targetArtist;
                                        }) : [];
                                    var eqCard = memberCards.find(function(c) { return c.isEquip; });
                                    var bestCard = eqCard || (memberCards.length > 0 ? memberCards[0] : null);
                                    var cIdMi = bestCard ? bestCard.cardID : (targetArtist || (1001 + mi));
                                    var grMi = bestCard ? (bestCard.grade !== undefined ? bestCard.grade : 4) : 4;
                                    var lvlMi = bestCard ? (bestCard.level || 50) : 50;
                                    var isEqMi = bestCard ? !!bestCard.isEquip : false;
                                    var isPrismMi = bestCard ? !!bestCard.isPrism : false;
                                    var smallParam = createMockSmallCardParams(cIdMi, grMi, lvlMi, isEqMi, isPrismMi);
                                    cardSmallParamsList.push(smallParam || NULL);
                                }'''

if target4 in js:
    js = js.replace(target4, replace4, 1)
    print("4. Updated InvenGroupItemView slot loop!")
else:
    print("FAIL 4: target4 not found")

# 5. InventoryScene dynamic slot targetCard check
target5 = '''                                            var targetArtistCode = (i < curArtistCodes.length) ? curArtistCodes[i] : null;
                                            var targetCard = eqCards.find(function(c) {
                                                var cm = getCardMetadata(c.cardID);
                                                return cm && cm.group === curGroupCode && cm.artistID === targetArtistCode;
                                            });'''

replace5 = '''                                            var targetArtistCode = (i < curArtistCodes.length) ? curArtistCodes[i] : null;
                                            var targetCard = eqCards.find(function(c) {
                                                var cm = getCardMetadata(c.cardID);
                                                return cm && (cm.groupID || cm.group) === curGroupCode && cm.artistID === targetArtistCode;
                                            });'''

if target5 in js:
    js = js.replace(target5, replace5, 1)
    print("5. Updated InventoryScene dynamic slot targetCard check!")
else:
    print("FAIL 5: target5 not found")

# 6. applyOfflineSortAndFilter: group filter
target6 = '''                            // If group is enabled, group by LOONA member order (1001..1011)
                            if (offlineFilterGroup) {
                                var mA = ((cIdA - 1001) % 11);
                                var mB = ((cIdB - 1001) % 11);
                                if (mA !== mB) return mA - mB;
                            }'''

replace6 = '''                            // If group is enabled, group by group then artist order
                            if (offlineFilterGroup) {
                                var metaA = getCardMetadata(cIdA);
                                var metaB = getCardMetadata(cIdB);
                                var gA = (metaA && (metaA.groupID || metaA.group)) ? (metaA.groupID || metaA.group) : 1001;
                                var gB = (metaB && (metaB.groupID || metaB.group)) ? (metaB.groupID || metaB.group) : 1001;
                                if (gA !== gB) return gA - gB;
                                var aA = (metaA && metaA.artistID) ? metaA.artistID : cIdA;
                                var aB = (metaB && metaB.artistID) ? metaB.artistID : cIdB;
                                if (aA !== aB) return aA - aB;
                            }'''

if target6 in js:
    js = js.replace(target6, replace6, 1)
    print("6. Updated applyOfflineSortAndFilter group filter!")
else:
    print("FAIL 6: target6 not found")

# 7. SetCurrentGroup (0xF2B810) dynamic handling
target7 = '''                // Replace InventoryControl.SetCurrentGroup (0xF2B810) to safely guard against ArgumentOutOfRangeException
                try {
                    Interceptor.replace(baseAddr.add(0xF2B810), new NativeCallback(function (index, subIndex, methodInfo) {
                        log("[🃏 INVENTORY] SetCurrentGroup(index=" + index + ", subIndex=" + subIndex + ") called!");
                        try {
                            var setSelectedGroupCodeFn = new NativeFunction(baseAddr.add(0xF26FBC), "void", ["int", "pointer"]);
                            setSelectedGroupCodeFn(1001, NULL);
                            log("[🃏 INVENTORY] SetCurrentGroup: set SelectedGroupCode to 1001!");
                        } catch (eScgInner) {
                            log("[-] Error setting SelectedGroupCode: " + eScgInner.message);
                        }
                    }, "void", ["int", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.SetCurrentGroup (0xF2B810)!");
                } catch (eScg) {
                    log("[-] Error replacing InventoryControl.SetCurrentGroup: " + eScg.message);
                }'''

replace7 = '''                // Replace InventoryControl.SetCurrentGroup (0xF2B810) to dynamically select playable group
                try {
                    Interceptor.replace(baseAddr.add(0xF2B810), new NativeCallback(function (index, subIndex, methodInfo) {
                        log("[🃏 INVENTORY] SetCurrentGroup(index=" + index + ", subIndex=" + subIndex + ") called!");
                        try {
                            var meta = getGlobalMetadata();
                            var playables = (meta && meta.playableGroups) ? meta.playableGroups : PLAYABLE_GROUP_CODES;
                            var targetGroup = (index >= 0 && index < playables.length) ? playables[index] : 1001;
                            currentSelectedGroupCode = targetGroup;
                            var setSelectedGroupCodeFn = new NativeFunction(baseAddr.add(0xF26FBC), "void", ["int", "pointer"]);
                            setSelectedGroupCodeFn(targetGroup, NULL);
                            log("[🃏 INVENTORY] SetCurrentGroup: set SelectedGroupCode to " + targetGroup + " (index=" + index + ")!");
                            if (activeInventorySceneInstance && !activeInventorySceneInstance.isNull()) {
                                try {
                                    refreshDynamicInventorySlots(activeInventorySceneInstance, targetGroup);
                                } catch (eRdis) {}
                            }
                        } catch (eScgInner) {
                            log("[-] Error setting SelectedGroupCode: " + eScgInner.message);
                        }
                    }, "void", ["int", "int", "pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.SetCurrentGroup (0xF2B810)!");
                } catch (eScg) {
                    log("[-] Error replacing InventoryControl.SetCurrentGroup: " + eScg.message);
                }'''

if target7 in js:
    js = js.replace(target7, replace7, 1)
    print("7. Updated SetCurrentGroup dynamic handling!")
else:
    print("FAIL 7: target7 not found")

# 8. get_selectedGroupCode (0xF26C40) dynamic return
target8 = '''                // Proxy InventoryControl.get_selectedGroupCode (0xF26C40)
                try {
                    Interceptor.replace(baseAddr.add(0xF26C40), new NativeCallback(function (methodInfo) {
                        return 1001;
                    }, "int", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_selectedGroupCode (0xF26C40)!");
                } catch (eSgc2) {
                    log("[-] Error replacing get_selectedGroupCode: " + eSgc2.message);
                }'''

replace8 = '''                // Proxy InventoryControl.get_selectedGroupCode (0xF26C40)
                try {
                    Interceptor.replace(baseAddr.add(0xF26C40), new NativeCallback(function (methodInfo) {
                        return currentSelectedGroupCode;
                    }, "int", ["pointer"]));
                    log("[+] Interceptor.replace installed on InventoryControl.get_selectedGroupCode (0xF26C40)!");
                } catch (eSgc2) {
                    log("[-] Error replacing get_selectedGroupCode: " + eSgc2.message);
                }'''

if target8 in js:
    js = js.replace(target8, replace8, 1)
    print("8. Updated get_selectedGroupCode dynamic return!")
else:
    print("FAIL 8: target8 not found")

# 9. GetMajorGroupItem (0xF27090) & GetCurrentGroup (0xF2B51C)
target9 = '''                // InventoryControl.GetMajorGroupItem (0xF27090) & GetCurrentGroup (0xF2B51C)
                try {
                    Interceptor.replace(baseAddr.add(0xF27090), new NativeCallback(function (groupCode, methodInfo) {
                        if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                            return loonaGroupItemObj;
                        }
                        return NULL;
                    }, "pointer", ["int", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xF2B51C), new NativeCallback(function (pIndex, pSubIndex, methodInfo) {
                        if (pIndex && !pIndex.isNull()) pIndex.writeInt(0);
                        if (pSubIndex && !pSubIndex.isNull()) pSubIndex.writeInt(0);
                        return 1001; // LOONA group code
                    }, "int", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GetMajorGroupItem (0xF27090) & GetCurrentGroup (0xF2B51C)!");
                } catch (eGmg) {
                    log("[-] Error replacing GetMajorGroupItem / GetCurrentGroup: " + eGmg.message);
                }'''

replace9 = '''                // InventoryControl.GetMajorGroupItem (0xF27090) & GetCurrentGroup (0xF2B51C)
                try {
                    Interceptor.replace(baseAddr.add(0xF27090), new NativeCallback(function (groupCode, methodInfo) {
                        if (allInvenGroupItems[groupCode]) {
                            return allInvenGroupItems[groupCode];
                        }
                        if (loonaGroupItemObj && !loonaGroupItemObj.isNull()) {
                            return loonaGroupItemObj;
                        }
                        return NULL;
                    }, "pointer", ["int", "pointer"]));
                    Interceptor.replace(baseAddr.add(0xF2B51C), new NativeCallback(function (pIndex, pSubIndex, methodInfo) {
                        var meta = getGlobalMetadata();
                        var playables = (meta && meta.playableGroups) ? meta.playableGroups : PLAYABLE_GROUP_CODES;
                        var idx = playables.indexOf(currentSelectedGroupCode);
                        if (idx < 0) idx = 0;
                        if (pIndex && !pIndex.isNull()) pIndex.writeInt(idx);
                        if (pSubIndex && !pSubIndex.isNull()) pSubIndex.writeInt(0);
                        return currentSelectedGroupCode;
                    }, "int", ["pointer", "pointer", "pointer"]));
                    log("[+] Interceptor.replace installed on GetMajorGroupItem (0xF27090) & GetCurrentGroup (0xF2B51C)!");
                } catch (eGmg) {
                    log("[-] Error replacing GetMajorGroupItem / GetCurrentGroup: " + eGmg.message);
                }'''

if target9 in js:
    js = js.replace(target9, replace9, 1)
    print("9. Updated GetMajorGroupItem & GetCurrentGroup dynamic return!")
else:
    print("FAIL 9: target9 not found")

# 10. populateOfflineInventoryCards: gCode and invalidate cachedDglInstance
target10 = '''                                var meta = getCardMetadata(cId);
                                var isMat = (cData.isMaterial || (meta && meta.isMaterial) || (cId >= 30001 && cId <= 30005));
                                cardItemObj.add(0x2C).writeU8(isMat ? 1 : 0); // isMaterial
                                var gCode = (meta && meta.group) ? meta.group : 1001;'''

replace10 = '''                                var meta = getCardMetadata(cId);
                                var isMat = (cData.isMaterial || (meta && meta.isMaterial) || (cId >= 30001 && cId <= 30005));
                                cardItemObj.add(0x2C).writeU8(isMat ? 1 : 0); // isMaterial
                                var gCode = (meta && (meta.groupID || meta.group)) ? (meta.groupID || meta.group) : 1001;'''

if target10 in js:
    js = js.replace(target10, replace10, 1)
    print("10. Updated gCode in populateOfflineInventoryCards!")
else:
    print("FAIL 10: target10 not found")

target11 = '''                                    allInvenGroupItems[gCode] = groupItemObj;
                                    if (gCode === 1001) loonaGroupItemObj = groupItemObj;
                                }
                                log("[🃏 INVENTORY] Created GroupItems for all " + playables.length + " groups!");
                            }
                            ensureDisplayGroupList();'''

replace11 = '''                                    allInvenGroupItems[gCode] = groupItemObj;
                                    if (gCode === 1001) loonaGroupItemObj = groupItemObj;
                                }
                                log("[🃏 INVENTORY] Created GroupItems for all " + playables.length + " groups!");
                            }
                            cachedDglInstance = NULL;
                            ensureDisplayGroupList();'''

if target11 in js:
    js = js.replace(target11, replace11, 1)
    print("11. Invalidate cachedDglInstance before ensureDisplayGroupList!")
else:
    print("FAIL 11: target11 not found")

with open('app/src/main/assets/libscript.js', 'w', encoding='utf-8') as f:
    f.write(js)

print("All modifications successfully applied to app/src/main/assets/libscript.js!")
