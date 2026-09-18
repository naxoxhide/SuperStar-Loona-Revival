package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class y5 implements x3 {
    @Override // com.tapjoy.internal.x3
    public final Object a(b4 b4Var) throws IOException {
        d4 d4Var = (d4) b4Var;
        d4Var.a(3);
        String strM = "";
        String strM2 = strM;
        while (b4Var.c()) {
            String strL = b4Var.l();
            if (FirebaseAnalytics.Param.CAMPAIGN_ID.equals(strL)) {
                strM = b4Var.s() ? "" : b4Var.m();
            } else if ("product_id".equals(strL)) {
                strM2 = b4Var.s() ? "" : b4Var.m();
            } else {
                b4Var.r();
            }
        }
        d4Var.a(4);
        return new z5(strM, strM2);
    }
}
