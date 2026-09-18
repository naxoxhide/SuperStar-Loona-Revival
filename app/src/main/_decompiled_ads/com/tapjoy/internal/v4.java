package com.tapjoy.internal;

import android.graphics.Point;
import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public final class v4 implements x3 {
    public static Point b(b4 b4Var) throws IOException {
        d4 d4Var = (d4) b4Var;
        d4Var.a(3);
        Point point = null;
        while (b4Var.c()) {
            if ("offset".equals(b4Var.l())) {
                d4Var.a(3);
                int i = 0;
                int i2 = 0;
                while (b4Var.c()) {
                    String strL = b4Var.l();
                    if ("x".equals(strL)) {
                        i = b4Var.i();
                    } else if ("y".equals(strL)) {
                        i2 = b4Var.i();
                    } else {
                        b4Var.r();
                    }
                }
                d4Var.a(4);
                point = new Point(i, i2);
            } else {
                b4Var.r();
            }
        }
        d4Var.a(4);
        return point;
    }

    @Override // com.tapjoy.internal.x3
    public final Object a(b4 b4Var) throws IOException {
        d4 d4Var = (d4) b4Var;
        d4Var.a(3);
        l6 l6Var = null;
        Point pointB = null;
        Point pointB2 = null;
        while (b4Var.c()) {
            String strL = b4Var.l();
            if ("image".equals(strL)) {
                String strM = b4Var.m();
                if (!TextUtils.isEmpty(strM)) {
                    l6Var = new l6(new URL(strM));
                }
            } else if (TJAdUnitConstants.String.LANDSCAPE.equals(strL)) {
                pointB = b(b4Var);
            } else if (TJAdUnitConstants.String.PORTRAIT.equals(strL)) {
                pointB2 = b(b4Var);
            } else {
                b4Var.r();
            }
        }
        d4Var.a(4);
        return new w4(l6Var, pointB, pointB2);
    }
}
