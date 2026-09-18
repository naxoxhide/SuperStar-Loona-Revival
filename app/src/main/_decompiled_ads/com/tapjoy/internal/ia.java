package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public final class ia extends BroadcastReceiver {
    public final /* synthetic */ ja a;

    public ia(ja jaVar) {
        this.a = jaVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        aa aaVar = this.a.d;
        aaVar.a.lock();
        try {
            aaVar.f = 1000L;
            aaVar.f2730b.signal();
        } finally {
            aaVar.a.unlock();
        }
    }
}
