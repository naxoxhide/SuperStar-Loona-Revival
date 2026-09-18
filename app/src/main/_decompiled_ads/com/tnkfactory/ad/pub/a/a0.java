package com.tnkfactory.ad.pub.a;

import android.view.View;
import com.tnkfactory.ad.AdListener;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ com.tnkfactory.ad.pub.b a;

    public a0(com.tnkfactory.ad.pub.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.tnkfactory.ad.pub.b.a(this.a, AdListener.CLOSE_EXIT);
    }
}
