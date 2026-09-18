package com.fyber.inneractive.sdk.player.mediaplayer;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f1263b;

    public c(a aVar, int i) {
        this.f1263b = aVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.f1263b;
        int i = this.a;
        String strC = aVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        aVar.seekTo(i);
        IAlog.d(strC + "timelog: seekTo took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }
}
