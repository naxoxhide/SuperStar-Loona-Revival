package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable {
    public final /* synthetic */ Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1180b;
    public final /* synthetic */ long c;
    public final /* synthetic */ IOException d;
    public final /* synthetic */ f.a e;

    public d(f.a aVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar, int i, int i2, com.fyber.inneractive.sdk.player.exoplayer2.i iVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        this.e = aVar;
        this.a = obj;
        this.f1180b = j;
        this.c = j2;
        this.d = iOException;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.a aVar = this.e;
        f fVar = aVar.f1182b;
        f.a.a(aVar, this.f1180b);
        f.a.a(this.e, this.c);
        IAlog.a("%s AdaptiveMediaSourceEventListener onLoadError called. with exception %s", ((u) fVar).b(), this.d);
    }
}
