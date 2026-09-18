package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.tapjoy.TapjoyConnectFlag;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class d3 {
    public static d3 f;
    public final y2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f2741b;
    public final pa c;
    public final Context d;
    public final i5 e;

    static {
        UUID.randomUUID().toString();
    }

    public d3(Context context, i5 i5Var) {
        e7.a();
        y2 y2Var = new y2();
        this.a = y2Var;
        n nVar = new n();
        this.f2741b = nVar;
        this.c = new pa();
        y2Var.o = "13.3.0/Android";
        y2Var.f = "Android";
        y2Var.g = Build.VERSION.RELEASE;
        y2Var.d = Build.MANUFACTURER;
        y2Var.e = Build.MODEL;
        y2Var.k = Locale.getDefault().toString();
        y2Var.l = TimeZone.getDefault().getID();
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        y2Var.c = f1.a(applicationContext);
        if (!ca.a().a(TapjoyConnectFlag.DISABLE_ANDROID_ID_AS_ANALYTICS_ID)) {
            y2Var.r = f1.b(applicationContext);
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        if (telephonyManager != null) {
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!TextUtils.isEmpty(simCountryIso)) {
                y2Var.p = simCountryIso.toUpperCase(Locale.US);
            }
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                y2Var.q = networkCountryIso.toUpperCase(Locale.US);
            }
        }
        String packageName = applicationContext.getPackageName();
        y2Var.m = packageName;
        y2Var.n = r9.b(e5.a(packageManager, packageName));
        nVar.c = e5.c(packageManager, packageName);
        nVar.a(Integer.valueOf(e5.b(packageManager, packageName)));
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (!TextUtils.isEmpty(installerPackageName)) {
            nVar.e = installerPackageName;
        }
        String strA = a(packageManager, packageName);
        if (!TextUtils.isEmpty(strA)) {
            nVar.f = strA;
        }
        c();
        this.e = i5Var;
        b();
    }

    public static synchronized d3 a(Context context) {
        if (f == null) {
            f = new d3(context, new i5(context));
        }
        return f;
    }

    public final void b() {
        double d;
        double d2;
        String strB = this.e.c.b();
        if (strB != null && strB.length() > 0) {
            this.a.o = strB.concat(" 13.3.0/Android");
        }
        String strA = this.e.a();
        if (strA != null) {
            this.c.d = strA;
        }
        this.c.c = Long.valueOf(this.e.b());
        int iB = this.e.f.b();
        this.c.e = Integer.valueOf(a(7, iB));
        this.c.f = Integer.valueOf(a(30, iB));
        int iB2 = this.e.h.b();
        if (iB2 > 0) {
            this.c.h = Integer.valueOf(iB2);
        }
        long jB = this.e.i.b();
        if (jB > 0) {
            this.c.i = Long.valueOf(jB);
        }
        long jB2 = this.e.j.b();
        if (jB2 > 0) {
            this.c.j = Long.valueOf(jB2);
        }
        long jB3 = this.e.k.b();
        if (jB3 > 0) {
            this.c.k = Long.valueOf(jB3);
        }
        long jB4 = this.e.l.b();
        if (jB4 > 0) {
            this.c.l = Long.valueOf(jB4);
        }
        String strB2 = this.e.m.b();
        if (strB2 != null) {
            this.c.m = strB2;
        }
        int iB3 = this.e.n.b();
        if (iB3 > 0) {
            this.c.n = Integer.valueOf(iB3);
        }
        m1 m1Var = this.e.o;
        String string = m1Var.a.getString(m1Var.f2840b, null);
        if (string != null) {
            try {
                d = Double.parseDouble(string);
            } catch (NumberFormatException unused) {
                d = 0.0d;
            }
        } else {
            d = 0.0d;
        }
        if (d != 0.0d) {
            this.c.o = Double.valueOf(d);
        }
        long jB5 = this.e.p.b();
        if (jB5 > 0) {
            this.c.p = Long.valueOf(jB5);
        }
        m1 m1Var2 = this.e.q;
        String string2 = m1Var2.a.getString(m1Var2.f2840b, null);
        if (string2 != null) {
            try {
                d2 = Double.parseDouble(string2);
            } catch (NumberFormatException unused2) {
                d2 = 0.0d;
            }
        } else {
            d2 = 0.0d;
        }
        if (d2 != 0.0d) {
            this.c.q = Double.valueOf(d2);
        }
        String strB3 = this.e.g.b();
        if (strB3 != null) {
            try {
                try {
                    byte[] bArrDecode = Base64.decode(strB3, 2);
                    if (bArrDecode == null) {
                        throw new NullPointerException("bytes == null");
                    }
                    v5 v5Var = new v5(new b0().a(bArrDecode, bArrDecode.length));
                    r4 r4VarA = i3.a();
                    long jB6 = v5Var.b();
                    b0 b0Var = null;
                    w5 w5Var = null;
                    while (true) {
                        int iD = v5Var.d();
                        if (iD == -1) {
                            break;
                        }
                        if (iD != 1) {
                            int i = v5Var.h;
                            Object objA = s1.a(i).a(v5Var);
                            if (w5Var == null) {
                                b0Var = new b0();
                                w5Var = new w5(b0Var);
                            }
                            try {
                                s1.a(i).a(w5Var, iD, objA);
                            } catch (IOException unused3) {
                                throw new AssertionError();
                            }
                        } else {
                            r4VarA.add((c6) c6.f.a(v5Var));
                        }
                    }
                    v5Var.a(jB6);
                    e6 e6Var = new e6(r4VarA, b0Var != null ? new g0(b0Var.clone().c()) : g0.e);
                    this.c.g.clear();
                    this.c.g.addAll(e6Var.c);
                } catch (IllegalArgumentException unused4) {
                    this.e.g.a();
                }
            } catch (IOException unused5) {
                this.e.g.a();
            }
        }
        this.c.t = this.e.r.b();
        int iIntValue = Integer.valueOf(this.e.s.b()).intValue();
        this.c.u = iIntValue != -1 ? Integer.valueOf(iIntValue) : null;
        String strB4 = this.e.t.b();
        if (strB4 != null) {
            try {
                try {
                    byte[] bArrDecode2 = Base64.decode(strB4, 2);
                    if (bArrDecode2 == null) {
                        throw new NullPointerException("bytes == null");
                    }
                    v5 v5Var2 = new v5(new b0().a(bArrDecode2, bArrDecode2.length));
                    r4 r4VarA2 = i3.a();
                    long jB7 = v5Var2.b();
                    b0 b0Var2 = null;
                    w5 w5Var2 = null;
                    while (true) {
                        int iD2 = v5Var2.d();
                        if (iD2 == -1) {
                            break;
                        }
                        if (iD2 != 1) {
                            int i2 = v5Var2.h;
                            Object objA2 = s1.a(i2).a(v5Var2);
                            if (w5Var2 == null) {
                                b0Var2 = new b0();
                                w5Var2 = new w5(b0Var2);
                            }
                            try {
                                s1.a(i2).a(w5Var2, iD2, objA2);
                            } catch (IOException unused6) {
                                throw new AssertionError();
                            }
                        } else {
                            r4VarA2.add(((b0) v5Var2.a).b(v5Var2.a()));
                        }
                    }
                    v5Var2.a(jB7);
                    i7 i7Var = new i7(r4VarA2, b0Var2 != null ? new g0(b0Var2.clone().c()) : g0.e);
                    this.c.v.clear();
                    this.c.v.addAll(i7Var.c);
                } catch (IOException unused7) {
                    this.e.t.a();
                }
            } catch (IllegalArgumentException unused8) {
                this.e.t.a();
            }
        }
        String strB5 = this.e.u.b();
        a0 a0Var = this.e.v;
        boolean zBooleanValue = Boolean.valueOf(a0Var.a.getBoolean(a0Var.f2840b, false)).booleanValue();
        if (strB5 != null) {
            pa paVar = this.c;
            paVar.r = strB5;
            paVar.s = Boolean.valueOf(zBooleanValue);
        } else {
            pa paVar2 = this.c;
            paVar2.r = null;
            paVar2.s = null;
        }
        pa paVar3 = this.c;
        a0 a0Var2 = this.e.w;
        paVar3.w = Boolean.valueOf(a0Var2.a.getBoolean(a0Var2.f2840b, false));
    }

    public final void c() {
        Window window;
        synchronized (this) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.d.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                WeakReference weakReference = t.e.a;
                Activity activityA = (Activity) (weakReference != null ? weakReference.get() : null);
                if (activityA == null) {
                    activityA = t.a();
                }
                if (activityA != null && (window = activityA.getWindow()) != null) {
                    int i = displayMetrics.heightPixels;
                    Rect rect = new Rect();
                    window.getDecorView().getWindowVisibleDisplayFrame(rect);
                    displayMetrics.heightPixels = i - rect.top;
                }
                this.a.h = Integer.valueOf(displayMetrics.densityDpi);
                this.a.i = Integer.valueOf(displayMetrics.widthPixels);
                this.a.j = Integer.valueOf(displayMetrics.heightPixels);
            } catch (Exception unused) {
            }
        }
    }

    public final void d() {
        r4 r4Var = this.c.g;
        g0 g0Var = g0.e;
        Objects.requireNonNull(g0Var, "unknownFields == null");
        List listA = i3.a("pushes", (AbstractList) r4Var);
        b0 b0Var = new b0();
        try {
            w5 w5Var = new w5(b0Var);
            c6.f.a().a(w5Var, 1, listA);
            w5Var.a(g0Var);
            this.e.g.a(Base64.encodeToString(b0Var.c(), 2));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final void e() {
        synchronized (this) {
            int iB = this.e.h.b() + 1;
            this.e.h.a(iB);
            this.c.h = Integer.valueOf(iB);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            k4 k4Var = this.e.k;
            if (lValueOf != null) {
                k4Var.getClass();
                k4Var.a(lValueOf.longValue());
            } else {
                k4Var.a();
            }
            this.c.k = lValueOf;
        }
    }

    public static String a(PackageManager packageManager, String str) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str, 128).metaData;
            if (bundle == null || (obj = bundle.get("com.tapjoy.appstore")) == null) {
                return null;
            }
            return obj.toString().trim();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final c3 a() {
        c3 c3Var;
        synchronized (this) {
            this.a.k = Locale.getDefault().toString();
            this.a.l = TimeZone.getDefault().getID();
            boolean z = false;
            long jCurrentTimeMillis = System.currentTimeMillis() - 259200000;
            Iterator it = this.c.g.iterator();
            while (it.hasNext()) {
                if (((c6) it.next()).d.longValue() <= jCurrentTimeMillis) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                d();
            }
            y2 y2Var = this.a;
            a3 a3Var = new a3(null, y2Var.c, y2Var.d, y2Var.e, y2Var.f, y2Var.g, y2Var.h, y2Var.i, y2Var.j, y2Var.k, y2Var.l, y2Var.m, y2Var.n, y2Var.o, y2Var.p, y2Var.q, null, y2Var.r, y2Var.a());
            n nVar = this.f2741b;
            p pVar = new p(nVar.c, nVar.d, nVar.e, nVar.f, nVar.a());
            pa paVar = this.c;
            paVar.getClass();
            c3Var = new c3(a3Var, pVar, new ra(paVar.c, paVar.d, paVar.e, paVar.f, paVar.g, paVar.h, paVar.i, paVar.j, paVar.l, paVar.k, paVar.m, paVar.n, paVar.o, paVar.p, paVar.q, paVar.r, paVar.s, paVar.t, paVar.u, paVar.v, paVar.w, paVar.a()), g0.e);
        }
        return c3Var;
    }

    public final void a(String str) {
        synchronized (this) {
            this.e.d.a(str);
            this.c.d = str;
        }
    }

    public static int a(int i, int i2) {
        return Integer.bitCount(((1 << i) - 1) & i2);
    }

    public final void a(long j, long j2) {
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.e.f2768b.edit();
            editorEdit.putLong(this.e.j.f2840b, j);
            editorEdit.putLong(this.e.l.f2840b, j2);
            editorEdit.apply();
            this.c.j = Long.valueOf(j);
            this.c.l = Long.valueOf(j2);
        }
    }

    public final void a(String str, double d) {
        double d2;
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.e.f2768b.edit();
            int iB = 1;
            if (str.equals(this.e.m.b())) {
                iB = 1 + this.e.n.b();
                editorEdit.putInt(this.e.n.f2840b, iB);
                m1 m1Var = this.e.o;
                String string = m1Var.a.getString(m1Var.f2840b, null);
                if (string != null) {
                    try {
                        d2 = Double.parseDouble(string);
                    } catch (NumberFormatException unused) {
                        d2 = 0.0d;
                    }
                } else {
                    d2 = 0.0d;
                }
                d += d2;
                editorEdit.putString(this.e.o.f2840b, Double.toString(d));
                editorEdit.apply();
            } else {
                editorEdit.putString(this.e.m.f2840b, str);
                editorEdit.putInt(this.e.n.f2840b, 1);
                editorEdit.putString(this.e.o.f2840b, Double.toString(d));
                editorEdit.remove(this.e.p.f2840b);
                editorEdit.remove(this.e.q.f2840b);
                editorEdit.apply();
                pa paVar = this.c;
                paVar.m = str;
                paVar.p = null;
                paVar.q = null;
            }
            this.c.n = Integer.valueOf(iB);
            this.c.o = Double.valueOf(d);
        }
    }

    public final void a(long j, double d) {
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.e.f2768b.edit();
            editorEdit.putLong(this.e.p.f2840b, j);
            editorEdit.putString(this.e.q.f2840b, Double.toString(d));
            editorEdit.apply();
            this.c.p = Long.valueOf(j);
            this.c.q = Double.valueOf(d);
        }
    }

    public final void a(Integer num) {
        synchronized (this) {
            h3 h3Var = this.e.s;
            if (num != null) {
                h3Var.getClass();
                h3Var.a(num.intValue());
            } else {
                h3Var.a();
            }
            Integer num2 = this.c.u;
            if (!(num2 == num || (num2 != null && num2.equals(num)))) {
                this.c.u = num;
            }
        }
    }

    public final boolean a(boolean z) {
        boolean z2;
        synchronized (this) {
            this.e.w.a(z);
            Boolean bool = this.c.w;
            Boolean bool2 = ra.y;
            if (bool == null) {
                bool2.getClass();
                bool = bool2;
            }
            z2 = z != bool.booleanValue();
            this.c.w = Boolean.valueOf(z);
        }
        return z2;
    }

    public final void b(String str) {
        synchronized (this) {
            this.e.r.a(str);
            String str2 = this.c.t;
            if (!(str2 == str || (str2 != null && str2.equals(str)))) {
                this.c.t = str;
            }
        }
    }
}
