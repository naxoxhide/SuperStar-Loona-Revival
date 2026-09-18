package com.tapjoy;

import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.internal.a1;
import com.tapjoy.internal.l4;
import com.tapjoy.internal.r3;
import com.tapjoy.internal.u0;
import com.tapjoy.internal.wa;
import com.tapjoy.internal.x0;

/* JADX INFO: loaded from: classes4.dex */
public class TJPlacementManager {
    public static final wa a = new wa();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2699b = 0;
    public static int c = 0;
    public static int d = 3;
    public static int e = 3;

    public static TJCorePlacement a(String str) {
        TJCorePlacement tJCorePlacement;
        wa waVar = a;
        synchronized (waVar) {
            tJCorePlacement = (TJCorePlacement) waVar.get(str);
        }
        return tJCorePlacement;
    }

    public static boolean canCachePlacement() {
        return getCachedPlacementCount() < getCachedPlacementLimit();
    }

    public static boolean canPreRenderPlacement() {
        return getPreRenderedPlacementCount() < getPreRenderedPlacementLimit();
    }

    public static TJPlacement createPlacement(Context context, String str, boolean z, TJPlacementListener tJPlacementListener) {
        TJCorePlacement tJCorePlacementA = a(str, null, null, z);
        tJCorePlacementA.m = z;
        tJCorePlacementA.d.setPlacementType("sdk");
        tJCorePlacementA.setContext(context);
        return new TJPlacement(tJCorePlacementA, tJPlacementListener);
    }

    public static void decrementPlacementCacheCount() {
        int i = f2699b - 1;
        f2699b = i;
        if (i < 0) {
            f2699b = 0;
        }
        printPlacementCacheInformation();
    }

    public static void decrementPlacementPreRenderCount() {
        int i = c - 1;
        c = i;
        if (i < 0) {
            c = 0;
        }
    }

    public static void dismissContentShowing(boolean z) {
        a1 a1Var;
        TJAdUnitActivity tJAdUnitActivity;
        if (z && (tJAdUnitActivity = TJAdUnitActivity.l) != null) {
            tJAdUnitActivity.a(true);
        }
        r3 r3Var = r3.l;
        if (r3Var != null && (a1Var = r3Var.g) != null) {
            a1Var.dismiss();
        }
        x0 x0Var = x0.o;
        if (x0Var != null) {
            l4.a(new u0(x0Var));
        }
    }

    public static int getCachedPlacementCount() {
        return f2699b;
    }

    public static int getCachedPlacementLimit() {
        return d;
    }

    public static int getPreRenderedPlacementCount() {
        return c;
    }

    public static int getPreRenderedPlacementLimit() {
        return e;
    }

    public static void incrementPlacementCacheCount() {
        int i = f2699b + 1;
        f2699b = i;
        int i2 = d;
        if (i > i2) {
            f2699b = i2;
        }
        printPlacementCacheInformation();
    }

    public static void incrementPlacementPreRenderCount() {
        int i = c + 1;
        c = i;
        int i2 = e;
        if (i > i2) {
            c = i2;
        }
    }

    public static void printPlacementCacheInformation() {
        TapjoyLog.i("TJPlacementManager", "Space available in placement cache: " + f2699b + " out of " + d);
    }

    public static void printPlacementPreRenderInformation() {
        TapjoyLog.i("TJPlacementManager", "Space available for placement pre-render: " + c + " out of " + e);
    }

    public static void setCachedPlacementLimit(int i) {
        d = i;
    }

    public static void setPreRenderedPlacementLimit(int i) {
        e = i;
    }

    public static TJCorePlacement a(String str, String str2, String str3, boolean z) {
        TJCorePlacement tJCorePlacementA;
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "!SYSTEM!" : "");
        sb.append(!TextUtils.isEmpty(str) ? str : "");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        String string = sb.toString();
        TapjoyLog.d("TJPlacementManager", "TJCorePlacement key=" + string);
        wa waVar = a;
        synchronized (waVar) {
            tJCorePlacementA = a(string);
            if (tJCorePlacementA == null) {
                tJCorePlacementA = new TJCorePlacement(str, string);
                waVar.put(string, tJCorePlacementA);
                TapjoyLog.d("TJPlacementManager", "Created TJCorePlacement with GUID: " + tJCorePlacementA.f);
            }
        }
        return tJCorePlacementA;
    }
}
