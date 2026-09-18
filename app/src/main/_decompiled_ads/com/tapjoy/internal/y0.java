package com.tapjoy.internal;

import android.graphics.Rect;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 implements x3 {
    @Override // com.tapjoy.internal.x3
    public final Object a(b4 b4Var) throws IOException {
        d4 d4Var = (d4) b4Var;
        d4Var.a(3);
        Rect rect = null;
        String strM = null;
        String strN = null;
        String strN2 = null;
        b bVarA = null;
        boolean zG = false;
        String strM2 = "";
        while (b4Var.c()) {
            String strL = b4Var.l();
            if ("region".equals(strL)) {
                rect = (Rect) a4.f2728b.a(b4Var);
            } else if ("value".equals(strL)) {
                strM = b4Var.m();
            } else if ("dismiss".equals(strL)) {
                zG = b4Var.g();
            } else if ("url".equals(strL)) {
                strM2 = b4Var.m();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(strL)) {
                strN = b4Var.n();
            } else if ("ad_content".equals(strL)) {
                strN2 = b4Var.n();
            } else if (b.a(strL)) {
                bVarA = b.a(strL, b4Var);
            } else {
                b4Var.r();
            }
        }
        d4Var.a(4);
        return new z0(rect, strM, zG, strM2, strN, strN2, bVarA);
    }
}
