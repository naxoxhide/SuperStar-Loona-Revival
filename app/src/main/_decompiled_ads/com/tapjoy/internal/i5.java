package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class i5 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f2768b;
    public final l7 c;
    public final l7 d;
    public final h3 e;
    public final h3 f;
    public final l7 g;
    public final h3 h;
    public final k4 i;
    public final k4 j;
    public final k4 k;
    public final k4 l;
    public final l7 m;
    public final h3 n;
    public final m1 o;
    public final k4 p;
    public final m1 q;
    public final l7 r;
    public final h3 s;
    public final l7 t;
    public final l7 u;
    public final a0 v;
    public final a0 w;
    public final l7 x;

    public i5(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("fiverocks", 0);
        this.f2768b = sharedPreferences;
        this.c = new l7(sharedPreferences, "sdk");
        this.d = new l7(sharedPreferences, "ir");
        this.e = new h3(sharedPreferences, "fql", 0);
        this.f = new h3(sharedPreferences, "fq", 0);
        this.g = new l7(sharedPreferences, "push");
        this.h = new h3(sharedPreferences, "ss", 0);
        this.i = new k4(sharedPreferences, "std");
        this.j = new k4(sharedPreferences, "slt");
        this.k = new k4(sharedPreferences, "sst");
        this.l = new k4(sharedPreferences, "sld");
        this.m = new l7(sharedPreferences, "ptc");
        this.n = new h3(sharedPreferences, "pc", 0);
        this.o = new m1(sharedPreferences, "ptp");
        this.p = new k4(sharedPreferences, "lpt");
        this.q = new m1(sharedPreferences, "plp");
        this.r = new l7(sharedPreferences, "ui");
        this.s = new h3(sharedPreferences, "ul", -1);
        this.t = new l7(sharedPreferences, "utags");
        this.u = new l7(sharedPreferences, "idfa");
        this.v = new a0(sharedPreferences, "idfa.optout");
        this.w = new a0(sharedPreferences, "push.optout");
        this.x = new l7(sharedPreferences, "appId");
    }

    public final String a() {
        File file;
        String string = this.f2768b.getString("ir", null);
        if (string != null) {
            if (string.length() > 0) {
                return string;
            }
            return null;
        }
        Context context = this.a;
        synchronized (v1.class) {
            if (v1.o == null) {
                v1.o = context.getDir("fiverocks", 0);
            }
            file = v1.o;
        }
        File file2 = new File(file, TapjoyConstants.TJC_REFERRER);
        if (file2.exists()) {
            try {
                string = g7.a(file2);
            } catch (IOException unused) {
            }
        }
        this.f2768b.edit().putString("ir", string != null ? string : "").apply();
        if (string == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public final long b() {
        File file;
        String strA;
        long jLastModified = this.f2768b.getLong("it", 0L);
        if (jLastModified == 0) {
            Context context = this.a;
            try {
                jLastModified = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                if (jLastModified <= 0) {
                    jLastModified = 0;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (jLastModified == 0) {
                Context context2 = this.a;
                v1 v1Var = v1.m;
                synchronized (v1.class) {
                    if (v1.o == null) {
                        v1.o = context2.getDir("fiverocks", 0);
                    }
                    file = v1.o;
                }
                jLastModified = new File(file, "install").lastModified();
                if (jLastModified == 0) {
                    Context context3 = this.a;
                    try {
                        strA = r9.a(context3.getPackageManager().getApplicationInfo(context3.getPackageName(), 0).sourceDir);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        strA = null;
                    }
                    jLastModified = new File(strA).lastModified();
                    if (jLastModified == 0) {
                        jLastModified = System.currentTimeMillis();
                    }
                }
            }
            this.f2768b.edit().putLong("it", jLastModified).apply();
        }
        return jLastModified;
    }
}
