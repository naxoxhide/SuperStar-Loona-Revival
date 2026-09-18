package com.tapjoy.internal;

import android.R;
import android.app.Dialog;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 extends Dialog {
    public a1(Context context) {
        super(context, R.style.Theme.Dialog);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        super.cancel();
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
    }
}
