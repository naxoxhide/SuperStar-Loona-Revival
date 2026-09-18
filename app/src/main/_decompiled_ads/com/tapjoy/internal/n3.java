package com.tapjoy.internal;

import android.app.Activity;
import android.view.WindowManager;
import com.tapjoy.TJContentActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class n3 extends TJContentActivity.AbstractContentProducer {
    public final /* synthetic */ g2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r3 f2786b;

    public n3(r3 r3Var, g2 g2Var) {
        this.f2786b = r3Var;
        this.a = g2Var;
    }

    @Override // com.tapjoy.TJContentActivity.AbstractContentProducer, com.tapjoy.TJContentActivity.ContentProducer
    public final void dismiss(Activity activity) {
        a1 a1Var = this.f2786b.g;
        if (a1Var != null) {
            a1Var.dismiss();
        }
    }

    @Override // com.tapjoy.TJContentActivity.ContentProducer
    public final void show(Activity activity) {
        try {
            this.f2786b.a(activity, this.a);
        } catch (WindowManager.BadTokenException unused) {
            r3 r3Var = this.f2786b;
            this.a.a(r3Var.e, r3Var.c, null);
        }
    }
}
