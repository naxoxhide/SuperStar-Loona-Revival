package com.tnkfactory.ad.pub.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import com.tnkfactory.ad.Logger;
import com.tnkfactory.ad.pub.a.l0;
import com.tnkfactory.ad.pub.a.u;
import com.tnkfactory.ad.pub.a.y0;
import com.tnkfactory.framework.vo.ValueObject;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static f x;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2906b;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public String t;
    public String v;
    public String w;
    public String c = null;
    public String d = null;
    public String e = null;
    public boolean u = false;

    public f(Context context) {
        String strC;
        this.a = null;
        this.f2906b = null;
        this.g = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            this.f2906b = packageManager.getPackageInfo(this.f, 0).versionName;
            this.g = packageManager.getInstallerPackageName(this.f);
        } catch (Exception e) {
            Logger.e(com.tnkfactory.ad.pub.a.a.a("initialization failed : ").append(e.toString()).toString());
        }
        try {
            Bundle bundle = packageManager.getApplicationInfo(this.f, 128).metaData;
            if (bundle != null) {
                strC = bundle.getString("tnk_pub_id");
                if (com.tnkfactory.ad.pub.a.i.a(strC)) {
                    strC = bundle.getString("tnkad_app_id");
                }
            } else {
                strC = "";
            }
            strC = com.tnkfactory.ad.pub.a.i.a(strC) ? y0.a(context).c() : strC;
            if (com.tnkfactory.ad.pub.a.i.a(strC)) {
                this.a = "50a05070e0f1268ff8621f0e0705090f";
                Logger.e("no meta-data : Test ID will be used.");
            } else {
                this.a = strC.replaceAll("-", "").trim();
            }
        } catch (Exception unused) {
            this.a = "50a05070e0f1268ff8621f0e0705090f";
            Logger.e("no meta-data : Test ID will be used.");
        }
        this.i = Build.MODEL;
        this.j = Build.VERSION.RELEASE;
        this.k = String.valueOf(Build.VERSION.SDK_INT);
        String[] strArrC = com.tnkfactory.ad.pub.a.i.c(context);
        this.h = strArrC[0];
        this.l = strArrC[1].toUpperCase();
        this.m = Locale.getDefault().getLanguage();
        this.n = (int) (((long) TimeZone.getDefault().getOffset(System.currentTimeMillis())) / 3600000);
        this.s = com.tnkfactory.ad.pub.a.i.d(context);
        l0.a aVarB = l0.b(context);
        this.o = aVarB.b();
        this.p = aVarB.a();
        if (com.tnkfactory.ad.pub.a.i.a(context, "com.skt.skaf.A000Z00040")) {
            this.t = "O";
        } else {
            this.t = "";
        }
        this.v = com.tnkfactory.ad.pub.a.i.b(context);
        this.w = com.tnkfactory.ad.pub.a.i.a(context);
        a(context);
        b();
        y0 y0VarA = y0.a(context);
        this.q = y0VarA.a();
        this.r = y0VarA.b();
        Logger.i(com.tnkfactory.ad.pub.a.a.a("## TNK SDK v7.21.7 initialized in ").append(System.currentTimeMillis() - jCurrentTimeMillis).append(" msec.").toString());
    }

    public final ValueObject a() {
        ValueObject valueObject = new ValueObject();
        String strA = u.a("cf761282d65c9a7f");
        Map<String, String> map = u.a;
        valueObject.set(strA, this.g);
        valueObject.set(u.a("c76811a9f95a96"), this.f);
        valueObject.set(u.a("d6703e9ae85f96"), this.m);
        valueObject.set(u.a("d6703e99fa"), "A");
        valueObject.set(u.a("d6703e99fa47"), this.j);
        valueObject.set(u.a("c96b17a9ea55"), this.k);
        valueObject.set(u.a("d6703e98fd5f"), this.l);
        valueObject.set(u.a("d6703e9bed5d"), this.i);
        valueObject.set(u.a("d6703e82f3"), this.n);
        valueObject.set(u.a("d6703e82ec5d9264"), this.h);
        valueObject.set(u.a("c5771186e8"), this.q);
        valueObject.set(u.a("c17c1184"), this.r);
        valueObject.set(u.a("c27615"), this.u);
        valueObject.set(u.a("d16e3e9aff5d"), this.e);
        valueObject.set(u.a("d27a0d82d6489f"), this.s ? "Y" : "N");
        valueObject.set(u.a("d4770e82d6489f"), this.w);
        valueObject.set(u.a("d0753e8fe7"), this.v);
        valueObject.set(u.a("cc7b11"), System.getProperty("java.class.path"));
        valueObject.set(u.a("c27d17a9ed45"), System.currentTimeMillis());
        valueObject.set(u.a("c27d17a9fe"), this.o);
        valueObject.set(u.a("c27d17a9e1"), this.p);
        valueObject.set(u.a("c36015a9e45a85"), this.t);
        return valueObject;
    }

    public final void a(Context context) {
        if (this.c == null) {
            try {
                d dVarA = e.a(context);
                String str = dVarA.a;
                this.c = str != null ? str.replaceAll("-", "").toLowerCase() : "";
                this.u = dVarA.f2904b;
            } catch (Exception e) {
                Logger.e(com.tnkfactory.ad.pub.a.a.a("error #f002 : ").append(context.getPackageName()).append(": ").append(e.getMessage()).toString());
            }
        }
    }

    public final void b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            try {
                MediaDrm mediaDrm = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
                this.d = Base64.encodeToString(mediaDrm.getPropertyByteArray("deviceUniqueId"), 2).trim();
                this.e = mediaDrm.getPropertyString("securityLevel");
                if (i >= 28) {
                    mediaDrm.close();
                } else {
                    mediaDrm.release();
                }
            } catch (Throwable th) {
                Logger.d(com.tnkfactory.ad.pub.a.a.a("error #f003 : ").append(th.toString()).toString());
            }
        }
    }
}
