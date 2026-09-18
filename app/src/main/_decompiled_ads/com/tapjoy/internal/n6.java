package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class n6 implements x3 {
    @Override // com.tapjoy.internal.x3
    public final Object a(b4 b4Var) throws IOException {
        d4 d4Var = (d4) b4Var;
        d4Var.a(3);
        String strM = null;
        String strM2 = null;
        int i = 1;
        String strM3 = null;
        while (b4Var.c()) {
            String strL = b4Var.l();
            if ("id".equals(strL)) {
                strM = b4Var.m();
            } else if ("name".equals(strL)) {
                strM3 = b4Var.m();
            } else if (FirebaseAnalytics.Param.QUANTITY.equals(strL)) {
                i = b4Var.i();
            } else if (BidResponsed.KEY_TOKEN.equals(strL)) {
                strM2 = b4Var.m();
            } else {
                b4Var.r();
            }
        }
        d4Var.a(4);
        return new o6(strM, strM3, i, strM2);
    }
}
