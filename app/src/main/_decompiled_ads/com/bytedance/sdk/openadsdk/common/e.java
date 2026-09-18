package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.p;

/* JADX INFO: compiled from: LandingPageLoadingStyle.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    protected final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f530b;
    protected String[] c;
    protected View d;
    protected Context e;
    protected p f;

    public e(Context context, String str, String[] strArr, n nVar, p pVar) {
        this.f530b = str;
        this.c = strArr;
        this.e = context;
        this.a = nVar;
        this.f = pVar;
        c();
    }

    public void a() {
        e();
        this.d = null;
        this.e = null;
    }

    public abstract void a(int i);

    public View b() {
        return this.d;
    }

    protected abstract void c();

    public abstract void d();

    public abstract void e();
}
