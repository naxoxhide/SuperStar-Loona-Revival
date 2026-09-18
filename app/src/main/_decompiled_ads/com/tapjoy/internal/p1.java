package com.tapjoy.internal;

import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 {
    public final d3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1 f2793b = new o1();
    public long c;

    public p1(d3 d3Var) {
        this.a = d3Var;
    }

    public final void a(String str, String str2, double d, String str3, String str4, String str5) {
        this.a.a(str2, d);
        n1 n1VarA = a(r1.APP, FirebaseAnalytics.Event.PURCHASE);
        Objects.requireNonNull(g0.e, "unknownFields == null");
        a(n1VarA);
        this.a.a(n1VarA.e.longValue(), d);
    }

    public final n1 a(r1 r1Var, String str) {
        this.a.a();
        n1 n1Var = new n1();
        d3 d3Var = d3.f;
        n1Var.c = r1Var;
        n1Var.d = str;
        if (na.a) {
            n1Var.e = Long.valueOf(na.a());
            System.currentTimeMillis();
        } else {
            n1Var.e = Long.valueOf(System.currentTimeMillis());
            SystemClock.elapsedRealtime();
        }
        return n1Var;
    }

    public final synchronized void a(n1 n1Var) {
        if (n1Var.c != r1.USAGES) {
            o1 o1Var = this.f2793b;
            r1 r1Var = o1Var.c;
            if (r1Var != null) {
                if (r1Var == null || o1Var.d == null) {
                    i3.a(r1Var, "type", o1Var.d, "name");
                    throw null;
                }
                if (o1Var.a() == null) {
                    throw new NullPointerException("unknownFields == null");
                }
            }
            o1 o1Var2 = this.f2793b;
            o1Var2.c = n1Var.c;
            o1Var2.d = n1Var.d;
            o1Var2.getClass();
        }
    }
}
