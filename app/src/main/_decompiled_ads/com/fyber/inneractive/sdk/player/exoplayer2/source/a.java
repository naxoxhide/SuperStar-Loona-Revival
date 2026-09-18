package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.u;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {
    public final /* synthetic */ Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1176b;
    public final /* synthetic */ long c;
    public final /* synthetic */ f.a d;

    public a(f.a aVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar, int i, int i2, com.fyber.inneractive.sdk.player.exoplayer2.i iVar, int i3, Object obj, long j, long j2, long j3) {
        this.d = aVar;
        this.a = obj;
        this.f1176b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.a aVar = this.d;
        f fVar = aVar.f1182b;
        f.a.a(aVar, this.f1176b);
        f.a.a(this.d, this.c);
        IAlog.a("%s AdaptiveMediaSourceEventListener onLoadStarted called.", ((u) fVar).b());
    }
}
