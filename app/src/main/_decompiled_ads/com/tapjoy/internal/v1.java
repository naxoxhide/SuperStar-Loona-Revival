package com.tapjoy.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes4.dex */
public final class v1 {
    public static final v1 m = new v1();
    public static Handler n;
    public static File o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h5 f2824b;
    public Context d;
    public d3 e;
    public p1 f;
    public y6 g;
    public String h;
    public boolean i;
    public String k;
    public boolean c = false;
    public boolean j = false;
    public g2 l = g2.a((z1) null);
    public final g5 a = new g5(this);

    public final void a(String str) {
        String str2 = this.e.a().c.d;
        oa oaVar = new oa();
        u1 u1Var = new u1(this, str);
        synchronized (oaVar) {
            oaVar.a(u1Var);
            throw null;
        }
    }

    public final synchronized void b(Context context) {
        if (this.d == null) {
            Context applicationContext = context.getApplicationContext();
            this.d = applicationContext;
            ca.c.a(applicationContext);
            d3 d3VarA = d3.a(applicationContext);
            this.e = d3VarA;
            p1 p1Var = new p1(d3VarA);
            this.f = p1Var;
            this.g = new y6(p1Var);
            this.f2824b = new h5(applicationContext);
            j1 j1Var = j1.f;
            j1Var.getClass();
            j1Var.a = applicationContext.getApplicationContext();
            j1Var.f2772b = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2E", 0);
            j1Var.c = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2U", 0);
            j1Var.e.submit(new g1(j1Var));
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    public final void c() {
        String strA;
        String strA2;
        File fileA = a(this.d);
        e3 e3Var = new e3(fileA);
        String str = null;
        if (fileA.exists()) {
            try {
                strA = g7.a(fileA);
                if (strA.length() <= 0) {
                    strA = null;
                }
            } catch (IOException unused) {
            }
        } else {
            strA = null;
        }
        boolean z = false;
        if (strA != null) {
            return;
        }
        synchronized (e3Var) {
            if (e3Var.a.exists()) {
                try {
                    strA2 = g7.a(e3Var.a);
                    if (strA2.length() <= 0) {
                        strA2 = null;
                    }
                } catch (IOException unused2) {
                }
            } else {
                strA2 = null;
            }
            if (strA2 == null) {
                try {
                    e3Var.a();
                    if (e3Var.a.exists()) {
                        try {
                            String strA3 = g7.a(e3Var.a);
                            if (strA3.length() > 0) {
                                str = strA3;
                            }
                        } catch (IOException unused3) {
                        }
                    }
                    z = str != null;
                } catch (IOException unused4) {
                }
            }
        }
        if (z) {
            p1 p1Var = this.f;
            p1Var.getClass();
            p1Var.a(p1Var.a(r1.APP, "install"));
        }
    }

    public final boolean d() {
        boolean z;
        int i;
        int i2;
        y6 y6Var = this.g;
        ScheduledFuture scheduledFuture = y6Var.d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            y6Var.d = null;
        }
        if (y6Var.f2834b.compareAndSet(false, true)) {
            p1 p1Var = y6Var.a;
            d3 d3Var = p1Var.a;
            synchronized (d3Var) {
                Calendar calendar = Calendar.getInstance();
                int i3 = calendar.get(5) + (calendar.get(2) * 100) + (calendar.get(1) * 10000) + 100;
                int iIntValue = Integer.valueOf(d3Var.e.e.b()).intValue();
                if (iIntValue != i3) {
                    if (iIntValue == 0) {
                        d3Var.c.e = 1;
                        d3Var.c.f = 1;
                        if (g0.e == null) {
                            throw new NullPointerException("unknownFields == null");
                        }
                        i2 = 1;
                    } else {
                        int iIntValue2 = Integer.valueOf(d3Var.e.f.b()).intValue();
                        int iA = d3.a(7, iIntValue2);
                        int iA2 = d3.a(30, iIntValue2);
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.set(iIntValue / 10000, ((iIntValue / 100) % 100) - 1, iIntValue % 100);
                        int iA3 = j0.a(calendar, calendar2);
                        if (Math.abs(iA3) >= 30) {
                            i = 0;
                        } else {
                            i = iA3 >= 0 ? iIntValue2 << iA3 : iIntValue2 >> (-iA3);
                        }
                        i2 = i | 1;
                        int iA4 = d3.a(7, i2);
                        int iA5 = d3.a(30, i2);
                        d3Var.c.e = Integer.valueOf(iA4);
                        d3Var.c.f = Integer.valueOf(iA5);
                        new StringBuilder("fq7_").append(iA).append("_").append(iA4);
                        new StringBuilder("fq30_").append(iA2).append("_").append(iA5);
                        if (g0.e == null) {
                            throw new NullPointerException("unknownFields == null");
                        }
                    }
                    d3Var.e.e.a(i3);
                    d3Var.e.f.a(i2);
                }
            }
            p1Var.a.e();
            n1 n1VarA = p1Var.a(r1.APP, "bootup");
            p1Var.c = SystemClock.elapsedRealtime();
            p1Var.a(n1VarA);
            k3.c.notifyObservers();
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        this.a.a();
        j1 j1Var = j1.f;
        j1Var.e.submit(new g1(j1Var));
        return true;
    }

    public final boolean a(Context context, String str, boolean z) {
        boolean z2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        b(context);
        d3 d3Var = this.e;
        synchronized (d3Var) {
            int size = d3Var.c.g.f2807b.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    c6 c6Var = (c6) d3Var.c.g.f2807b.get(i);
                    if (!c6Var.c.equals(str)) {
                        i++;
                    } else {
                        if (!z) {
                            z2 = false;
                            break;
                        }
                        a6 a6VarB = c6Var.b();
                        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
                        a6VarB.getClass();
                        r4 r4Var = d3Var.c.g;
                        String str2 = a6VarB.c;
                        if (str2 != null && lValueOf != null) {
                            r4Var.set(i, new c6(str2, lValueOf, a6VarB.d, a6VarB.a()));
                        } else {
                            i3.a(str2, "id", lValueOf, "received");
                            throw null;
                        }
                    }
                } else {
                    d3Var.c.g.add(new c6(str, Long.valueOf(jCurrentTimeMillis), null, g0.e));
                    d3Var.d();
                }
                z2 = true;
                break;
            }
        }
        if (!z2) {
            return false;
        }
        p1 p1Var = this.f;
        p1Var.getClass();
        n1 n1VarA = p1Var.a(r1.APP, "push_show");
        Objects.requireNonNull(g0.e, "unknownFields == null");
        p1Var.a(n1VarA);
        return true;
    }

    public final synchronized void b(String str) {
        String str2;
        if (this.i) {
            if (str == null && (str2 = this.k) != null) {
                str = str2;
            }
            this.k = null;
            if (str != null) {
                a(str);
            }
        } else if (str != null) {
            this.k = str;
        }
    }

    public final boolean b() {
        return (this.i || this.h != null) && this.d != null;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a1 A[Catch: all -> 0x00b1, TryCatch #0 {, blocks: (B:23:0x0047, B:25:0x004d, B:27:0x0056, B:28:0x0061, B:29:0x0073, B:36:0x00af, B:31:0x0093, B:32:0x0098, B:33:0x0099, B:34:0x00a0, B:35:0x00a1), top: B:41:0x0047, inners: #1 }] */
    public final void a(Set set) {
        if (a()) {
            if (set != null && !set.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str != null) {
                        String strTrim = str.trim();
                        if (!strTrim.isEmpty() && strTrim.length() <= 200) {
                            hashSet.add(strTrim);
                            if (hashSet.size() >= 200) {
                                break;
                            }
                        }
                    }
                }
                set = hashSet;
            }
            d3 d3Var = this.e;
            synchronized (d3Var) {
                if (set != null) {
                    if (!set.isEmpty()) {
                        ArrayList arrayList = new ArrayList(set);
                        g0 g0Var = g0.e;
                        if (g0Var != null) {
                            List listA = i3.a("elements", (AbstractList) arrayList);
                            b0 b0Var = new b0();
                            try {
                                w5 w5Var = new w5(b0Var);
                                u5.k.a().a(w5Var, 1, listA);
                                w5Var.a(g0Var);
                                d3Var.e.t.a(Base64.encodeToString(b0Var.c(), 2));
                                d3Var.c.v.clear();
                                d3Var.c.v.addAll(set);
                            } catch (IOException e) {
                                throw new AssertionError(e);
                            }
                        } else {
                            throw new NullPointerException("unknownFields == null");
                        }
                    } else {
                        d3Var.e.t.a();
                        d3Var.c.v.clear();
                    }
                } else {
                    d3Var.e.t.a();
                    d3Var.c.v.clear();
                }
            }
        }
    }

    public final synchronized void a(Context context, String str, String str2) {
        if (this.i) {
            return;
        }
        b(context);
        if (e1.a(this.d != null)) {
            if (str != null && str.length() == 24 && str.matches("[0-9a-f]{24}")) {
                if (str2 != null && str2.length() == 20 && str2.matches("[0-9A-Za-z\\-_]{20}")) {
                    this.i = true;
                    c();
                    d3 d3Var = this.e;
                    d3Var.getClass();
                    if (!TextUtils.isEmpty(str) && !str.equals(d3Var.e.x.b())) {
                        d3Var.e.x.a(str);
                        a7.a(d3Var.e.f2768b, false);
                    }
                }
            }
        }
    }

    public final boolean a() {
        return this.d != null;
    }

    public static File a(Context context) {
        File file;
        synchronized (v1.class) {
            if (o == null) {
                o = context.getDir("fiverocks", 0);
            }
            file = o;
        }
        return new File(file, "install");
    }
}
