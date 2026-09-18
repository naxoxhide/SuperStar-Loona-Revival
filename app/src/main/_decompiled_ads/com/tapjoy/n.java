package com.tapjoy;

import android.app.ProgressDialog;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f2848b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ TJAdUnitJSBridge f;

    public n(TJAdUnitJSBridge tJAdUnitJSBridge, boolean z, Context context, String str, String str2, String str3) {
        this.f = tJAdUnitJSBridge;
        this.a = z;
        this.f2848b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a) {
            this.f.d = ProgressDialog.show(this.f2848b, this.c, this.d);
            return;
        }
        ProgressDialog progressDialog = this.f.d;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        this.f.invokeJSCallback(this.e, Boolean.TRUE);
    }
}
