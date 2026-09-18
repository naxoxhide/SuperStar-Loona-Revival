package com.tapjoy;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJAdUnitJSBridge f2724b;

    public f(TJAdUnitJSBridge tJAdUnitJSBridge, String str) {
        this.f2724b = tJAdUnitJSBridge;
        this.a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        if (i != -3) {
            i2 = (i == -2 || i != -1) ? 0 : 2;
        } else {
            i2 = 1;
        }
        try {
            this.f2724b.invokeJSCallback(this.a, Integer.valueOf(i2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
