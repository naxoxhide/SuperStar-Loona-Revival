package com.mbridge.msdk.advanced.common;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.w;

/* JADX INFO: compiled from: ReportData.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1894b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private boolean i;
    private int j;

    public final c a(boolean z) {
        this.i = z;
        return this;
    }

    private c() {
    }

    public static c a() {
        return new c();
    }

    public final c a(String str) {
        this.a = str;
        return this;
    }

    public final void a(int i) {
        this.j = i;
    }

    public final c b(String str) {
        this.f1894b = str;
        return this;
    }

    public final c c(String str) {
        this.c = str;
        return this;
    }

    public final c d(String str) {
        this.d = str;
        return this;
    }

    public final c e(String str) {
        this.f = str;
        return this;
    }

    public final c f(String str) {
        this.g = str;
        return this;
    }

    public final c b(int i) {
        this.h = i;
        return this;
    }

    public final c g(String str) {
        this.e = str;
        return this;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f1894b)) {
            sb = sb.append("unit_id=").append(this.f1894b).append("&");
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb = sb.append("cid=").append(this.c).append("&");
        }
        if (!TextUtils.isEmpty(this.d)) {
            sb = sb.append("rid=").append(this.d).append("&");
        }
        if (!TextUtils.isEmpty(this.e)) {
            sb = sb.append("rid_n=").append(this.e).append("&");
        }
        if (!TextUtils.isEmpty(this.f)) {
            sb = sb.append("creative_id=").append(this.f).append("&");
        }
        if (!TextUtils.isEmpty(this.g)) {
            sb = sb.append("reason=").append(this.g).append("&");
        }
        if (this.h != 0) {
            sb = sb.append("result=").append(this.h).append("&");
        }
        if (this.i) {
            sb = sb.append("hb=1").append("&");
        }
        if (this.j != 0) {
            sb = sb.append("close_type=").append(this.j).append("&");
        }
        StringBuilder sbAppend = sb.append("network_type=").append(w.r(com.mbridge.msdk.foundation.controller.b.d().g())).append("&");
        if (!TextUtils.isEmpty(this.a)) {
            sbAppend = sbAppend.append("key=").append(this.a);
        }
        return sbAppend.toString();
    }
}
