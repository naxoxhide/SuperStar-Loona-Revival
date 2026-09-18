package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class m3 extends o0 {
    public final l6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l6 f2782b;
    public final l6 c;
    public final Point d;
    public final l6 e;
    public final l6 f;
    public final String g;
    public final b h;
    public final ArrayList i = new ArrayList();
    public final ArrayList j = new ArrayList();
    public final LinkedHashMap k;
    public final w4 l;

    static {
        new l3();
    }

    public m3(b4 b4Var) throws IOException {
        b4Var.a();
        String strN = null;
        String strN2 = null;
        while (b4Var.c()) {
            String strL = b4Var.l();
            if ("frame".equals(strL)) {
                b4Var.a();
                while (b4Var.c()) {
                    String strL2 = b4Var.l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(strL2)) {
                        this.a = (l6) b4Var.a(l6.f);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(strL2)) {
                        this.f2782b = (l6) b4Var.a(l6.f);
                    } else if ("close_button".equals(strL2)) {
                        this.c = (l6) b4Var.a(l6.f);
                    } else if ("close_button_offset".equals(strL2)) {
                        this.d = (Point) b4Var.a(a4.a);
                    } else {
                        b4Var.r();
                    }
                }
                b4Var.b();
            } else if ("creative".equals(strL)) {
                b4Var.a();
                while (b4Var.c()) {
                    String strL3 = b4Var.l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(strL3)) {
                        this.e = (l6) b4Var.a(l6.f);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(strL3)) {
                        this.f = (l6) b4Var.a(l6.f);
                    } else {
                        b4Var.r();
                    }
                }
                b4Var.b();
            } else if ("url".equals(strL)) {
                this.g = b4Var.n();
            } else if (b.a(strL)) {
                this.h = b.a(strL, b4Var);
            } else if ("mappings".equals(strL)) {
                b4Var.a();
                while (b4Var.c()) {
                    String strL4 = b4Var.l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(strL4)) {
                        b4Var.a(this.i, z0.h);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(strL4)) {
                        b4Var.a(this.j, z0.h);
                    } else {
                        b4Var.r();
                    }
                }
                b4Var.b();
            } else if ("meta".equals(strL)) {
                this.k = b4Var.k();
            } else if ("ttl".equals(strL)) {
                b4Var.h();
                SystemClock.elapsedRealtime();
            } else if ("no_more_today".equals(strL)) {
                this.l = (w4) b4Var.a(w4.d);
            } else if ("ad_content".equals(strL)) {
                strN2 = b4Var.n();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(strL)) {
                strN = b4Var.n();
            } else {
                b4Var.r();
            }
        }
        b4Var.b();
        if (this.g == null) {
            this.g = "";
        }
        ArrayList<z0> arrayList = this.i;
        if (arrayList != null) {
            for (z0 z0Var : arrayList) {
                if (z0Var.f == null) {
                    z0Var.f = strN2;
                }
                if (z0Var.e == null) {
                    z0Var.e = strN;
                }
            }
        }
        ArrayList<z0> arrayList2 = this.j;
        if (arrayList2 != null) {
            for (z0 z0Var2 : arrayList2) {
                if (z0Var2.f == null) {
                    z0Var2.f = strN2;
                }
                if (z0Var2.e == null) {
                    z0Var2.e = strN;
                }
            }
        }
    }
}
