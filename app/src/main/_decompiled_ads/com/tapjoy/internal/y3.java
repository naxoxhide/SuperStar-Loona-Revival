package com.tapjoy.internal;

import android.graphics.Point;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class y3 implements x3 {
    @Override // com.tapjoy.internal.x3
    public final Object a(b4 b4Var) throws IOException {
        Point point = new Point();
        d4 d4Var = (d4) b4Var;
        d4Var.a(3);
        while (b4Var.c()) {
            String strL = b4Var.l();
            if ("x".equals(strL)) {
                point.x = b4Var.i();
            } else if ("y".equals(strL)) {
                point.y = b4Var.i();
            } else {
                b4Var.r();
            }
        }
        d4Var.a(4);
        return point;
    }
}
