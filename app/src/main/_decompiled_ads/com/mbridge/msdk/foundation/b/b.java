package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.u;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: CandidateEntity.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2061b;
    private String c;
    private CopyOnWriteArrayList<CampaignEx> d;
    private long e;
    private double f;
    private int g;
    private int h;

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.f2061b;
    }

    public final void b(String str) {
        this.f2061b = str;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final CopyOnWriteArrayList<CampaignEx> d() {
        return this.d;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.d = copyOnWriteArrayList;
    }

    public final long e() {
        return this.e;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final double f() {
        return this.f;
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = u.b(str);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        try {
            double d = Double.parseDouble(strB);
            if (d <= 0.0d) {
                return;
            }
            this.f = d;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int g() {
        return this.g;
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void b(int i) {
        this.h = i;
    }
}
