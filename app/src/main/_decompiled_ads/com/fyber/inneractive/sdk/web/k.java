package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.IntentFilter;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Runnable {
    public final /* synthetic */ i a;

    public k(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.a;
        if (iVar.V == null) {
            try {
                IAlog.a("%sregistering orientation broadcast receiver", IAlog.a(iVar));
                this.a.V = new i.C0309i();
                if (this.a.l() != null) {
                    i iVar2 = this.a;
                    i<T>.C0309i c0309i = iVar2.V;
                    Context contextL = iVar2.l();
                    i iVar3 = i.this;
                    iVar3.getClass();
                    IAlog.a("%sregister screen broadcast receiver", IAlog.a(iVar3));
                    c0309i.a = contextL;
                    contextL.registerReceiver(c0309i, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
                }
            } catch (Exception e) {
                i iVar4 = this.a;
                iVar4.getClass();
                IAlog.e("%sfailed registering orientation broadcast recevier", IAlog.a(iVar4));
                if (IAlog.a >= 3) {
                    e.printStackTrace();
                }
            }
        }
    }
}
