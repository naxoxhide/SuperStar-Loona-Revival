package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class q0 {
    /* JADX WARN: Code duplicated, block: B:32:0x004d  */
    /* JADX WARN: Code duplicated, block: B:47:0x006d  */
    public static String a(String str) {
        boolean z;
        boolean z2;
        com.fyber.inneractive.sdk.config.z zVarA = com.fyber.inneractive.sdk.config.a.a(str);
        UnitDisplayType unitDisplayType = UnitDisplayType.BANNER;
        if (zVarA == null) {
            return unitDisplayType.name().toLowerCase(Locale.US);
        }
        for (int i = 0; i < zVarA.a.size(); i++) {
            com.fyber.inneractive.sdk.config.a0 a0VarC = zVarA.c(i);
            if (!(a0VarC == null || (a0VarC.c == null && a0VarC.f == null))) {
                com.fyber.inneractive.sdk.config.t tVar = a0VarC.c;
                if (tVar == null) {
                    z = false;
                } else {
                    UnitDisplayType unitDisplayType2 = tVar.f899b;
                    if ((unitDisplayType2 == null || unitDisplayType2.isDeprecated() || UnitDisplayType.DEFAULT == unitDisplayType2) ? false : true) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    unitDisplayType = a0VarC.c.f899b;
                } else {
                    com.fyber.inneractive.sdk.config.c0 c0Var = a0VarC.f;
                    if (c0Var != null) {
                        UnitDisplayType unitDisplayType3 = c0Var.j;
                        z2 = unitDisplayType3 != null && !unitDisplayType3.isDeprecated() && UnitDisplayType.DEFAULT != unitDisplayType3;
                    }
                    if (z2) {
                        unitDisplayType = a0VarC.f.j;
                    }
                }
                if (UnitDisplayType.MRECT == unitDisplayType) {
                    unitDisplayType = UnitDisplayType.BANNER;
                }
                if (UnitDisplayType.REWARDED == unitDisplayType || UnitDisplayType.INTERSTITIAL == unitDisplayType || UnitDisplayType.BANNER == unitDisplayType) {
                    return unitDisplayType.name().toLowerCase(Locale.US);
                }
            }
        }
        return UnitDisplayType.BANNER.name().toLowerCase(Locale.US);
    }

    public static String a(com.fyber.inneractive.sdk.response.e eVar) {
        UnitDisplayType unitDisplayType = eVar.n;
        if (unitDisplayType != UnitDisplayType.INTERSTITIAL && unitDisplayType != UnitDisplayType.REWARDED) {
            return UnitDisplayType.BANNER.name().toLowerCase(Locale.US);
        }
        return unitDisplayType.name().toLowerCase(Locale.US);
    }
}
