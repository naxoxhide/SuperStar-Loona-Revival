package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: RitInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {
    public static ConcurrentHashMap<Integer, r> f = new ConcurrentHashMap<>();
    private String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f668b = "";
    private int c;
    private int d;
    private String e;

    private void a() {
        this.a = "";
        this.f668b = "";
        this.c = 0;
        this.d = 0;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f668b;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public static void b(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        r rVar;
        if (qVar == null) {
            return;
        }
        Integer numValueOf = Integer.valueOf(qVar.S());
        if (numValueOf.intValue() == 0) {
            return;
        }
        if (f == null) {
            f = new ConcurrentHashMap<>();
        }
        if (!f.containsKey(numValueOf) || (rVar = f.get(numValueOf)) == null) {
            return;
        }
        rVar.b(1);
    }

    public void c(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        if (qVar != null) {
            String strU = qVar.U();
            if (!TextUtils.isEmpty(strU)) {
                this.e = strU;
            }
            String strH0 = qVar.H0();
            if (TextUtils.isEmpty(strH0) && qVar.k1()) {
                strH0 = qVar.M0().f();
            }
            if (!TextUtils.isEmpty(strH0)) {
                String[] strArrSplit = qVar.H0().split(RemoteSettings.FORWARD_SLASH_STRING);
                if (strArrSplit.length >= 3) {
                    this.a = strArrSplit[2];
                }
            }
            if (qVar.h() == null || TextUtils.isEmpty(qVar.h().e())) {
                return;
            }
            this.f668b = qVar.h().e();
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.N())) {
            return;
        }
        Integer numValueOf = Integer.valueOf(qVar.S());
        if (numValueOf.intValue() == 0) {
            return;
        }
        if (f == null) {
            f = new ConcurrentHashMap<>();
        }
        r rVar = f.containsKey(numValueOf) ? f.get(numValueOf) : null;
        if (rVar == null) {
            rVar = new r();
        }
        String strU = qVar.U();
        if (TextUtils.isEmpty(strU) || !strU.equals(rVar.f())) {
            rVar.a();
            rVar.c(qVar);
            f.put(numValueOf, rVar);
        }
    }

    public static void a(int i) {
        r rVar;
        if (i == 0) {
            return;
        }
        if (f == null) {
            f = new ConcurrentHashMap<>();
        }
        if (!f.containsKey(Integer.valueOf(i)) || (rVar = f.get(Integer.valueOf(i))) == null) {
            return;
        }
        rVar.c(1);
    }
}
