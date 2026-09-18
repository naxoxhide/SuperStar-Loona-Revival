package com.tnkfactory.ad.pub.a;

import android.os.Handler;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ com.tnkfactory.ad.pub.b a;

    public x(com.tnkfactory.ad.pub.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Handler handler = this.a.i;
        if (handler != null) {
            handler.sendEmptyMessage(8);
        }
    }
}
