package com.tapjoy.internal;

import android.graphics.Rect;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class z3 implements x3 {
    @Override // com.tapjoy.internal.x3
    public final Object a(b4 b4Var) throws IOException {
        Rect rect = new Rect();
        int iB = k.b(b4Var.q());
        if (iB == 0) {
            d4 d4Var = (d4) b4Var;
            d4Var.a(1);
            rect.left = b4Var.i();
            rect.top = b4Var.i();
            rect.right = b4Var.i();
            rect.bottom = b4Var.i();
            while (b4Var.c()) {
                b4Var.r();
            }
            d4Var.a(2);
        } else {
            if (iB != 2) {
                throw new IllegalStateException("Unexpected token: ".concat(f4.a(b4Var.q())));
            }
            d4 d4Var2 = (d4) b4Var;
            d4Var2.a(3);
            while (b4Var.c()) {
                String strL = b4Var.l();
                if ("left".equals(strL)) {
                    rect.left = b4Var.i();
                } else if ("top".equals(strL)) {
                    rect.top = b4Var.i();
                } else if ("right".equals(strL)) {
                    rect.right = b4Var.i();
                } else if (TJAdUnitConstants.String.BOTTOM.equals(strL)) {
                    rect.bottom = b4Var.i();
                } else {
                    b4Var.r();
                }
            }
            d4Var2.a(4);
        }
        return rect;
    }
}
