package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements b {
    public g d;
    public ByteBuffer g;
    public ShortBuffer h;
    public ByteBuffer i;
    public long j;
    public long k;
    public boolean l;
    public float e = 1.0f;
    public float f = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1047b = -1;
    public int c = -1;

    public h() {
        ByteBuffer byteBuffer = b.a;
        this.g = byteBuffer;
        this.h = byteBuffer.asShortBuffer();
        this.i = byteBuffer;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public boolean a(int i, int i2, int i3) throws b.a {
        if (i3 != 2) {
            throw new b.a(i, i2, i3);
        }
        if (this.c == i && this.f1047b == i2) {
            return false;
        }
        this.c = i;
        this.f1047b = i2;
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public boolean b() {
        g gVar;
        return this.l && ((gVar = this.d) == null || gVar.r == 0);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public void c() {
        int i;
        g gVar = this.d;
        int i2 = gVar.q;
        float f = gVar.o;
        float f2 = gVar.p;
        int i3 = gVar.r + ((int) ((((i2 / (f / f2)) + gVar.s) / f2) + 0.5f));
        gVar.a((gVar.e * 2) + i2);
        int i4 = 0;
        while (true) {
            i = gVar.e * 2;
            int i5 = gVar.f1046b;
            if (i4 >= i * i5) {
                break;
            }
            gVar.h[(i5 * i2) + i4] = 0;
            i4++;
        }
        gVar.q += i;
        gVar.a();
        if (gVar.r > i3) {
            gVar.r = i3;
        }
        gVar.q = 0;
        gVar.t = 0;
        gVar.s = 0;
        this.l = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public boolean d() {
        return Math.abs(this.e - 1.0f) >= 0.01f || Math.abs(this.f - 1.0f) >= 0.01f;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public int e() {
        return 2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public int f() {
        return this.f1047b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public void flush() {
        g gVar = new g(this.c, this.f1047b);
        this.d = gVar;
        gVar.o = this.e;
        gVar.p = this.f;
        this.i = b.a;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public void g() {
        this.d = null;
        ByteBuffer byteBuffer = b.a;
        this.g = byteBuffer;
        this.h = byteBuffer.asShortBuffer();
        this.i = byteBuffer;
        this.f1047b = -1;
        this.c = -1;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.j += (long) iRemaining;
            g gVar = this.d;
            gVar.getClass();
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i = gVar.f1046b;
            int i2 = iRemaining2 / i;
            gVar.a(i2);
            shortBufferAsShortBuffer.get(gVar.h, gVar.q * gVar.f1046b, ((i * i2) * 2) / 2);
            gVar.q += i2;
            gVar.a();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int i3 = this.d.r * this.f1047b * 2;
        if (i3 > 0) {
            if (this.g.capacity() < i3) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
                this.g = byteBufferOrder;
                this.h = byteBufferOrder.asShortBuffer();
            } else {
                this.g.clear();
                this.h.clear();
            }
            g gVar2 = this.d;
            ShortBuffer shortBuffer = this.h;
            gVar2.getClass();
            int iMin = Math.min(shortBuffer.remaining() / gVar2.f1046b, gVar2.r);
            shortBuffer.put(gVar2.j, 0, gVar2.f1046b * iMin);
            int i4 = gVar2.r - iMin;
            gVar2.r = i4;
            short[] sArr = gVar2.j;
            int i5 = gVar2.f1046b;
            System.arraycopy(sArr, iMin * i5, sArr, 0, i4 * i5);
            this.k += (long) i3;
            this.g.limit(i3);
            this.i = this.g;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.b
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.i;
        this.i = b.a;
        return byteBuffer;
    }
}
