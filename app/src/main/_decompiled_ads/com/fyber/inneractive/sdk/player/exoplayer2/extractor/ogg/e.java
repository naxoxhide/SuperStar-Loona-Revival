package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final int h = u.a("OggS");
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1112b;
    public int c;
    public int d;
    public int e;
    public final int[] f = new int[255];
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k g = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(255);

    public void a() {
        this.a = 0;
        this.f1112b = 0L;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, boolean z) throws InterruptedException, IOException {
        this.g.r();
        a();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        long j = bVar.f1057b;
        if (!(j == -1 || j - (bVar.c + ((long) bVar.e)) >= 27) || !bVar.a(this.g.a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        if (this.g.m() != h) {
            if (z) {
                return false;
            }
            throw new l("expected OggS capture pattern at begin of page");
        }
        if (this.g.l() != 0) {
            if (z) {
                return false;
            }
            throw new l("unsupported bit stream revision");
        }
        this.a = this.g.l();
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = this.g;
        byte[] bArr = kVar.a;
        int i = kVar.f1236b;
        int i2 = i + 1;
        kVar.f1236b = i2;
        long j2 = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        kVar.f1236b = i3;
        long j3 = j2 | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i3 + 1;
        kVar.f1236b = i4;
        long j4 = j3 | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i4 + 1;
        kVar.f1236b = i5;
        long j5 = j4 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i5 + 1;
        kVar.f1236b = i6;
        long j6 = j5 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        kVar.f1236b = i7;
        long j7 = j6 | ((((long) bArr[i6]) & 255) << 40);
        int i8 = i7 + 1;
        kVar.f1236b = i8;
        long j8 = j7 | ((((long) bArr[i7]) & 255) << 48);
        kVar.f1236b = i8 + 1;
        this.f1112b = j8 | ((((long) bArr[i8]) & 255) << 56);
        kVar.f();
        this.g.f();
        this.g.f();
        int iL = this.g.l();
        this.c = iL;
        this.d = iL + 27;
        this.g.r();
        bVar.a(this.g.a, 0, this.c, false);
        for (int i9 = 0; i9 < this.c; i9++) {
            this.f[i9] = this.g.l();
            this.e += this.f[i9];
        }
        return true;
    }
}
