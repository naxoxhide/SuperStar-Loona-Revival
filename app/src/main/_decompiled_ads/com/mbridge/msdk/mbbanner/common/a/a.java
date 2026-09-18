package com.mbridge.msdk.mbbanner.common.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.w;

/* JADX INFO: compiled from: BannerReportData.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2251b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private boolean i;

    public final a a(boolean z) {
        this.i = z;
        return this;
    }

    private a() {
    }

    public static a a() {
        return new a();
    }

    public final a a(String str) {
        this.a = str;
        return this;
    }

    public final a b(String str) {
        this.f2251b = str;
        return this;
    }

    public final a c(String str) {
        this.c = str;
        return this;
    }

    public final a d(String str) {
        this.e = str;
        return this;
    }

    public final a e(String str) {
        this.d = str;
        return this;
    }

    public final a f(String str) {
        this.f = str;
        return this;
    }

    public final a g(String str) {
        this.g = str;
        return this;
    }

    public final a a(int i) {
        this.h = i;
        return this;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f2251b)) {
            sb = sb.append("unit_id=").append(this.f2251b).append("&");
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
        StringBuilder sbAppend = sb.append("network_type=").append(w.r(com.mbridge.msdk.foundation.controller.b.d().g())).append("&");
        if (!TextUtils.isEmpty(this.a)) {
            sbAppend = sbAppend.append("key=").append(this.a);
        }
        return sbAppend.toString();
    }
}
