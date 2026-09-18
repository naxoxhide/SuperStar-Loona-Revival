package com.tapjoy.internal;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final class o3 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ g2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r3 f2790b;

    public o3(r3 r3Var, g2 g2Var) {
        this.f2790b = r3Var;
        this.a = g2Var;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.a(this.f2790b.e);
    }
}
