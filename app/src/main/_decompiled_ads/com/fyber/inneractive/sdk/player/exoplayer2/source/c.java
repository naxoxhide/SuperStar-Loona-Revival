package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.u;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {
    public final /* synthetic */ Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1178b;
    public final /* synthetic */ long c;
    public final /* synthetic */ f.a d;

    public c(f.a aVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar, int i, int i2, com.fyber.inneractive.sdk.player.exoplayer2.i iVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        this.d = aVar;
        this.a = obj;
        this.f1178b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.a aVar = this.d;
        f fVar = aVar.f1182b;
        f.a.a(aVar, this.f1178b);
        f.a.a(this.d, this.c);
        IAlog.a("%s AdaptiveMediaSourceEventListener onLoadCanceled called.", ((u) fVar).b());
    }
}
