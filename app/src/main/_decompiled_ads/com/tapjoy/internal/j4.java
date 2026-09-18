package com.tapjoy.internal;

import android.graphics.PointF;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class j4 {
    public static final i4 d = new i4();
    public final l1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f2773b;
    public final ArrayList c = new ArrayList();

    public j4(b4 b4Var) throws IOException {
        this.a = l1.c;
        b4Var.a();
        while (b4Var.c()) {
            String strL = b4Var.l();
            if (TJAdUnitConstants.String.BUTTONS.equals(strL)) {
                if (b4Var.d()) {
                    b4Var.a(this.c, f0.m);
                } else {
                    b4Var.r();
                }
            } else if ("window_aspect_ratio".equals(strL)) {
                if (b4Var.e()) {
                    PointF pointF = new PointF();
                    b4Var.a();
                    while (b4Var.c()) {
                        String strL2 = b4Var.l();
                        if ("width".equals(strL2)) {
                            pointF.x = (float) b4Var.h();
                        } else if ("height".equals(strL2)) {
                            pointF.y = (float) b4Var.h();
                        } else {
                            b4Var.r();
                        }
                    }
                    b4Var.b();
                    if (pointF.x != 0.0f && pointF.y != 0.0f) {
                        this.f2773b = pointF;
                    }
                } else {
                    b4Var.r();
                }
            } else if ("orientation".equals(strL)) {
                String strM = b4Var.m();
                if (TJAdUnitConstants.String.LANDSCAPE.equals(strM)) {
                    this.a = l1.e;
                } else if (TJAdUnitConstants.String.PORTRAIT.equals(strM)) {
                    this.a = l1.d;
                }
            } else {
                b4Var.r();
            }
        }
        b4Var.b();
    }

    public final boolean a() {
        Iterator it = this.c.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return true;
            }
            f0 f0Var = (f0) it.next();
            l6 l6Var = f0Var.k;
            if (l6Var != null) {
                if (!((l6Var.f2779b == null && l6Var.c == null) ? false : true)) {
                    return false;
                }
            }
            l6 l6Var2 = f0Var.l;
            if (l6Var2 != null) {
                if (l6Var2.f2779b == null && l6Var2.c == null) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
        }
    }
}
