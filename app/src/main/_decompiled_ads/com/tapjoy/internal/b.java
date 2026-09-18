package com.tapjoy.internal;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements a {
    public static final String[] a;

    static {
        String[] strArr = {ReportUtil.EVENT_TYPE_REWARD, FirebaseAnalytics.Event.PURCHASE, "custom_action"};
        a = strArr;
        Arrays.sort(strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(y1 y1Var) {
        TJPlacement tJPlacement;
        TJPlacementListener tJPlacementListener;
        if (!(this instanceof x5)) {
            if (this instanceof m6) {
                o6 o6Var = (o6) ((m6) this);
                y1Var.a(o6Var.f2791b, o6Var.c, o6Var.d, o6Var.e);
                return;
            }
            return;
        }
        z5 z5Var = (z5) ((x5) this);
        String str = z5Var.f2839b;
        String str2 = z5Var.c;
        wa waVar = FiveRocksIntegration.a;
        synchronized (waVar) {
            tJPlacement = (TJPlacement) waVar.get(y1Var.a);
        }
        if (tJPlacement == null || (tJPlacementListener = tJPlacement.c) == null) {
            return;
        }
        tJPlacementListener.onPurchaseRequest(tJPlacement, new w1(str), str2);
    }

    public static boolean a(String str) {
        return Arrays.binarySearch(a, str) >= 0;
    }

    public static b a(String str, b4 b4Var) throws IOException {
        String strM = null;
        if (ReportUtil.EVENT_TYPE_REWARD.equals(str)) {
            if (b4Var.s()) {
                return null;
            }
            int i = 1;
            d4 d4Var = (d4) b4Var;
            d4Var.a(3);
            String strM2 = null;
            String strM3 = null;
            while (b4Var.c()) {
                String strL = b4Var.l();
                if ("id".equals(strL)) {
                    strM = b4Var.m();
                } else if ("name".equals(strL)) {
                    strM2 = b4Var.m();
                } else if (FirebaseAnalytics.Param.QUANTITY.equals(strL)) {
                    i = b4Var.i();
                } else if (BidResponsed.KEY_TOKEN.equals(strL)) {
                    strM3 = b4Var.m();
                } else {
                    b4Var.r();
                }
            }
            d4Var.a(4);
            return new o6(strM, strM2, i, strM3);
        }
        if (!FirebaseAnalytics.Event.PURCHASE.equals(str) || b4Var.s()) {
            return null;
        }
        d4 d4Var2 = (d4) b4Var;
        d4Var2.a(3);
        String strM4 = "";
        String strM5 = strM4;
        while (b4Var.c()) {
            String strL2 = b4Var.l();
            if (FirebaseAnalytics.Param.CAMPAIGN_ID.equals(strL2)) {
                strM4 = b4Var.s() ? "" : b4Var.m();
            } else if ("product_id".equals(strL2)) {
                strM5 = b4Var.s() ? "" : b4Var.m();
            } else {
                b4Var.r();
            }
        }
        d4Var2.a(4);
        return new z5(strM4, strM5);
    }
}
