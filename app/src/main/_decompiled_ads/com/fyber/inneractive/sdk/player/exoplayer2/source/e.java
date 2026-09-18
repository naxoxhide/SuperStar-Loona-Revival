package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.u;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Runnable {
    public final /* synthetic */ Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1181b;
    public final /* synthetic */ f.a c;

    public e(f.a aVar, int i, com.fyber.inneractive.sdk.player.exoplayer2.i iVar, int i2, Object obj, long j) {
        this.c = aVar;
        this.a = obj;
        this.f1181b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.a aVar = this.c;
        f fVar = aVar.f1182b;
        f.a.a(aVar, this.f1181b);
        IAlog.a("%s AdaptiveMediaSourceEventListener onDownstreamFormatChanged called.", ((u) fVar).b());
    }
}
