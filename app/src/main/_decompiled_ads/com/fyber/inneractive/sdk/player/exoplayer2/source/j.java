package com.fyber.inneractive.sdk.player.exoplayer2.source;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Runnable {
    public final /* synthetic */ i.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1187b;

    public j(i iVar, i.d dVar) {
        this.f1187b = iVar;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.d dVar = this.a;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.f fVar = dVar.c;
        if (fVar != null) {
            fVar.b();
            dVar.c = null;
        }
        int size = this.f1187b.o.size();
        for (int i = 0; i < size; i++) {
            this.f1187b.o.valueAt(i).b();
        }
    }
}
