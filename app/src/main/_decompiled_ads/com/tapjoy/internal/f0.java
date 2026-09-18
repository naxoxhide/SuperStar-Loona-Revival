package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {
    public static final e0 m = new e0();
    public final d5 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d5 f2753b;
    public final d5 c;
    public final d5 d;
    public final int e;
    public final int f;
    public final String g;
    public String h;
    public String i;
    public final boolean j;
    public final l6 k;
    public final l6 l;

    public f0(b4 b4Var) {
        this.e = 9;
        this.f = 10;
        this.j = false;
        b4Var.a();
        while (b4Var.c()) {
            String strL = b4Var.l();
            if ("x".equals(strL)) {
                this.a = d5.a(b4Var.m());
            } else if ("y".equals(strL)) {
                this.f2753b = d5.a(b4Var.m());
            } else if ("width".equals(strL)) {
                this.c = d5.a(b4Var.m());
            } else if ("height".equals(strL)) {
                this.d = d5.a(b4Var.m());
            } else if ("url".equals(strL)) {
                this.g = b4Var.m();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(strL)) {
                this.h = b4Var.m();
            } else if ("ad_content".equals(strL)) {
                this.i = b4Var.m();
            } else if ("dismiss".equals(strL)) {
                this.j = b4Var.g();
            } else if ("value".equals(strL)) {
                b4Var.m();
            } else if ("image".equals(strL)) {
                this.k = (l6) b4Var.a(l6.f);
            } else if ("image_clicked".equals(strL)) {
                this.l = (l6) b4Var.a(l6.f);
            } else if ("align".equals(strL)) {
                String strM = b4Var.m();
                if ("left".equals(strM)) {
                    this.e = 9;
                } else if ("right".equals(strM)) {
                    this.e = 11;
                } else if ("center".equals(strM)) {
                    this.e = 14;
                } else {
                    b4Var.r();
                }
            } else if ("valign".equals(strL)) {
                String strM2 = b4Var.m();
                if ("top".equals(strM2)) {
                    this.f = 10;
                } else if ("middle".equals(strM2)) {
                    this.f = 15;
                } else if (TJAdUnitConstants.String.BOTTOM.equals(strM2)) {
                    this.f = 12;
                } else {
                    b4Var.r();
                }
            } else {
                b4Var.r();
            }
        }
        b4Var.b();
    }
}
