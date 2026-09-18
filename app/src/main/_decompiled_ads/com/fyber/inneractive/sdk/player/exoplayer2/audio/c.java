package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public long A;
    public boolean B;
    public long C;
    public Method D;
    public int E;
    public long F;
    public long G;
    public int H;
    public long I;
    public long J;
    public int K;
    public int L;
    public long M;
    public long N;
    public long O;
    public float P;
    public com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] Q;
    public ByteBuffer[] R;
    public ByteBuffer S;
    public ByteBuffer T;
    public byte[] U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public int Z;
    public final com.fyber.inneractive.sdk.player.exoplayer2.audio.d a;
    public boolean a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.audio.h f1039b;
    public boolean b0;
    public final com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] c;
    public long c0;
    public final f d;
    public final ConditionVariable e = new ConditionVariable(true);
    public final long[] f;
    public final b g;
    public final LinkedList<g> h;
    public AudioTrack i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public long q;
    public m r;
    public m s;
    public long t;
    public long u;
    public ByteBuffer v;
    public int w;
    public int x;
    public int y;
    public long z;

    public class a extends Thread {
        public final /* synthetic */ AudioTrack a;

        public a(AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.a.flush();
                this.a.release();
            } finally {
                c.this.e.open();
            }
        }
    }

    public static class b {
        public AudioTrack a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1041b;
        public int c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;

        public b() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.a = audioTrack;
            this.f1041b = z;
            this.g = -9223372036854775807L;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            if (audioTrack != null) {
                this.c = audioTrack.getSampleRate();
            }
        }

        public long b() {
            throw new UnsupportedOperationException();
        }

        public long c() {
            throw new UnsupportedOperationException();
        }

        public boolean d() {
            return false;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public long a() {
            if (this.g != -9223372036854775807L) {
                return Math.min(this.i, this.h + ((((SystemClock.elapsedRealtime() * 1000) - this.g) * ((long) this.c)) / 1000000));
            }
            int playState = this.a.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = ((long) this.a.getPlaybackHeadPosition()) & 4294967295L;
            if (this.f1041b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f = this.d;
                }
                playbackHeadPosition += this.f;
            }
            if (this.d > playbackHeadPosition) {
                this.e++;
            }
            this.d = playbackHeadPosition;
            return playbackHeadPosition + (this.e << 32);
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.audio.c$c, reason: collision with other inner class name */
    public static class C0281c extends b {
        public final AudioTimestamp j;
        public long k;
        public long l;
        public long m;

        public C0281c() {
            super(null);
            this.j = new AudioTimestamp();
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c.b
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.k = 0L;
            this.l = 0L;
            this.m = 0L;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c.b
        public long b() {
            return this.m;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c.b
        public long c() {
            return this.j.nanoTime;
        }

        @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c.b
        public boolean d() {
            boolean timestamp = this.a.getTimestamp(this.j);
            if (timestamp) {
                long j = this.j.framePosition;
                if (this.l > j) {
                    this.k++;
                }
                this.l = j;
                this.m = j + (this.k << 32);
            }
            return timestamp;
        }
    }

    public static final class d extends Exception {
        public d(Throwable th) {
            super(th);
        }

        public d(String str) {
            super(str);
        }
    }

    public static final class e extends Exception {
        public e(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
        }
    }

    public interface f {
    }

    public static final class g {
        public final m a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1042b;
        public final long c;

        public g(m mVar, long j, long j2) {
            this.a = mVar;
            this.f1042b = j;
            this.c = j2;
        }
    }

    public static final class h extends Exception {
        public h(int i) {
            super("AudioTrack write failed: " + i);
        }
    }

    public c(com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] bVarArr, f fVar) {
        this.d = fVar;
        a aVar = null;
        if (u.a >= 18) {
            try {
                this.D = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (u.a >= 19) {
            this.g = new C0281c();
        } else {
            this.g = new b(aVar);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.audio.d dVar = new com.fyber.inneractive.sdk.player.exoplayer2.audio.d();
        this.a = dVar;
        com.fyber.inneractive.sdk.player.exoplayer2.audio.h hVar = new com.fyber.inneractive.sdk.player.exoplayer2.audio.h();
        this.f1039b = hVar;
        com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] bVarArr2 = new com.fyber.inneractive.sdk.player.exoplayer2.audio.b[bVarArr.length + 3];
        this.c = bVarArr2;
        bVarArr2[0] = new com.fyber.inneractive.sdk.player.exoplayer2.audio.f();
        bVarArr2[1] = dVar;
        System.arraycopy(bVarArr, 0, bVarArr2, 2, bVarArr.length);
        bVarArr2[bVarArr.length + 2] = hVar;
        this.f = new long[10];
        this.P = 1.0f;
        this.L = 0;
        this.n = 3;
        this.Z = 0;
        this.s = m.d;
        this.W = -1;
        this.Q = new com.fyber.inneractive.sdk.player.exoplayer2.audio.b[0];
        this.R = new ByteBuffer[0];
        this.h = new LinkedList<>();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00a5  */
    public void a(String str, int i, int i2, int i3, int i4, int[] iArr) throws d {
        boolean zA;
        int i5;
        boolean z = !"audio/raw".equals(str);
        int iA = z ? a(str) : i3;
        if (z) {
            zA = false;
        } else {
            this.E = u.b(i3, i);
            this.a.d = iArr;
            zA = false;
            for (com.fyber.inneractive.sdk.player.exoplayer2.audio.b bVar : this.c) {
                try {
                    zA |= bVar.a(i2, i, iA);
                    if (bVar.d()) {
                        i = bVar.f();
                        iA = bVar.e();
                    }
                } catch (com.fyber.inneractive.sdk.player.exoplayer2.audio.b.a e2) {
                    throw new d(e2);
                }
            }
            if (zA) {
                i();
            }
        }
        int i6 = 252;
        switch (i) {
            case 1:
                i5 = 4;
                break;
            case 2:
                i5 = 12;
                break;
            case 3:
                i5 = 28;
                break;
            case 4:
                i5 = 204;
                break;
            case 5:
                i5 = 220;
                break;
            case 6:
                i5 = 252;
                break;
            case 7:
                i5 = 1276;
                break;
            case 8:
                i5 = com.fyber.inneractive.sdk.player.exoplayer2.b.a;
                break;
            default:
                throw new d("Unsupported channel count: " + i);
        }
        int i7 = u.a;
        if (i7 > 23 || !"foster".equals(u.f1242b) || !"NVIDIA".equals(u.c)) {
            i6 = i5;
        } else if (i != 3 && i != 5) {
            if (i != 7) {
                i6 = i5;
            } else {
                i6 = com.fyber.inneractive.sdk.player.exoplayer2.b.a;
            }
        }
        int i8 = (i7 <= 25 && "fugu".equals(u.f1242b) && z && i == 1) ? 12 : i6;
        if (!zA && e() && this.l == iA && this.j == i2 && this.k == i8) {
            return;
        }
        h();
        this.l = iA;
        this.o = z;
        this.j = i2;
        this.k = i8;
        if (!z) {
            iA = 2;
        }
        this.m = iA;
        this.H = u.b(2, i);
        if (i4 != 0) {
            this.p = i4;
        } else if (z) {
            int i9 = this.m;
            if (i9 == 5 || i9 == 6) {
                this.p = 20480;
            } else {
                this.p = 49152;
            }
        } else {
            int minBufferSize = AudioTrack.getMinBufferSize(i2, i8, this.m);
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(minBufferSize != -2);
            int i10 = minBufferSize * 4;
            int iA2 = ((int) a(250000L)) * this.H;
            int iMax = (int) Math.max(minBufferSize, a(750000L) * ((long) this.H));
            if (i10 < iA2) {
                i10 = iA2;
            } else if (i10 > iMax) {
                i10 = iMax;
            }
            this.p = i10;
        }
        this.q = z ? -9223372036854775807L : b(this.p / this.H);
        a(this.s);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00de  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e1  */
    public final boolean b(ByteBuffer byteBuffer, long j) throws h {
        int iWrite;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.T;
        if (byteBuffer2 != null) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(byteBuffer2 == byteBuffer);
        } else {
            this.T = byteBuffer;
            if (u.a < 21) {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = this.U;
                if (bArr == null || bArr.length < iRemaining) {
                    this.U = new byte[iRemaining];
                }
                int iPosition = byteBuffer.position();
                byteBuffer.get(this.U, 0, iRemaining);
                byteBuffer.position(iPosition);
                this.V = 0;
            }
        }
        int iRemaining2 = byteBuffer.remaining();
        if (u.a < 21) {
            int iA = this.p - ((int) (this.I - (this.g.a() * ((long) this.H))));
            if (iA > 0) {
                iWrite = this.i.write(this.U, this.V, Math.min(iRemaining2, iA));
                if (iWrite > 0) {
                    this.V += iWrite;
                    byteBuffer.position(byteBuffer.position() + iWrite);
                }
            } else {
                iWrite = 0;
            }
        } else if (this.a0) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(j != -9223372036854775807L);
            AudioTrack audioTrack = this.i;
            if (this.v == null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
                this.v = byteBufferAllocate;
                byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
                this.v.putInt(1431633921);
            }
            if (this.w == 0) {
                this.v.putInt(4, iRemaining2);
                this.v.putLong(8, j * 1000);
                this.v.position(0);
                this.w = iRemaining2;
            }
            int iRemaining3 = this.v.remaining();
            if (iRemaining3 <= 0) {
                iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                if (iWrite < 0) {
                    this.w = 0;
                } else {
                    this.w -= iWrite;
                }
            } else {
                int iWrite2 = audioTrack.write(this.v, iRemaining3, 1);
                if (iWrite2 < 0) {
                    this.w = 0;
                    iWrite = iWrite2;
                } else if (iWrite2 < iRemaining3) {
                    iWrite = 0;
                } else {
                    iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                    if (iWrite < 0) {
                        this.w = 0;
                    } else {
                        this.w -= iWrite;
                    }
                }
            }
        } else {
            iWrite = this.i.write(byteBuffer, iRemaining2, 1);
        }
        this.c0 = SystemClock.elapsedRealtime();
        if (iWrite < 0) {
            throw new h(iWrite);
        }
        boolean z = this.o;
        if (!z) {
            this.I += (long) iWrite;
        }
        if (iWrite != iRemaining2) {
            return false;
        }
        if (z) {
            this.J += (long) this.K;
        }
        this.T = null;
        return true;
    }

    public final void c(long j) throws h {
        ByteBuffer byteBuffer;
        int length = this.Q.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.R[i - 1];
            } else {
                byteBuffer = this.S;
                if (byteBuffer == null) {
                    byteBuffer = com.fyber.inneractive.sdk.player.exoplayer2.audio.b.a;
                }
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.audio.b bVar = this.Q[i];
                bVar.a(byteBuffer);
                ByteBuffer byteBufferA = bVar.a();
                this.R[i] = byteBufferA;
                if (byteBufferA.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    public boolean d() {
        if (e()) {
            if (c() > this.g.a()) {
                return true;
            }
            if (f() && this.i.getPlayState() == 2 && this.i.getPlaybackHeadPosition() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        return this.i != null;
    }

    public final boolean f() {
        int i;
        return u.a < 23 && ((i = this.m) == 5 || i == 6);
    }

    public void g() {
        this.Y = true;
        if (e()) {
            this.N = System.nanoTime() / 1000;
            this.i.play();
        }
    }

    public void h() {
        if (e()) {
            this.F = 0L;
            this.G = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0;
            m mVar = this.r;
            if (mVar != null) {
                this.s = mVar;
                this.r = null;
            } else if (!this.h.isEmpty()) {
                this.s = this.h.getLast().a;
            }
            this.h.clear();
            this.t = 0L;
            this.u = 0L;
            this.S = null;
            this.T = null;
            int i = 0;
            while (true) {
                com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] bVarArr = this.Q;
                if (i >= bVarArr.length) {
                    break;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.audio.b bVar = bVarArr[i];
                bVar.flush();
                this.R[i] = bVar.a();
                i++;
            }
            this.X = false;
            this.W = -1;
            this.v = null;
            this.w = 0;
            this.L = 0;
            this.O = 0L;
            j();
            if (this.i.getPlayState() == 3) {
                this.i.pause();
            }
            AudioTrack audioTrack = this.i;
            this.i = null;
            this.g.a(null, false);
            this.e.close();
            new a(audioTrack).start();
        }
    }

    public final void i() {
        ArrayList arrayList = new ArrayList();
        for (com.fyber.inneractive.sdk.player.exoplayer2.audio.b bVar : this.c) {
            if (bVar.d()) {
                arrayList.add(bVar);
            } else {
                bVar.flush();
            }
        }
        int size = arrayList.size();
        this.Q = (com.fyber.inneractive.sdk.player.exoplayer2.audio.b[]) arrayList.toArray(new com.fyber.inneractive.sdk.player.exoplayer2.audio.b[size]);
        this.R = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.audio.b bVar2 = this.Q[i];
            bVar2.flush();
            this.R[i] = bVar2.a();
        }
    }

    public final void j() {
        this.z = 0L;
        this.y = 0;
        this.x = 0;
        this.A = 0L;
        this.B = false;
        this.C = 0L;
    }

    public final void k() {
        if (e()) {
            if (u.a >= 21) {
                this.i.setVolume(this.P);
                return;
            }
            AudioTrack audioTrack = this.i;
            float f2 = this.P;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    public final long c() {
        return this.o ? this.J : this.I / ((long) this.H);
    }

    public final long b(long j) {
        return (j * 1000000) / ((long) this.j);
    }

    public final long b() {
        return this.o ? this.G : this.F / ((long) this.E);
    }

    public boolean a(ByteBuffer byteBuffer, long j) throws h, e {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = this.S;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!e()) {
            this.e.block();
            if (this.a0) {
                this.i = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.k).setEncoding(this.m).setSampleRate(this.j).build(), this.p, 1, this.Z);
            } else if (this.Z == 0) {
                this.i = new AudioTrack(this.n, this.j, this.k, this.m, this.p, 1);
            } else {
                this.i = new AudioTrack(this.n, this.j, this.k, this.m, this.p, 1, this.Z);
            }
            int state = this.i.getState();
            if (state == 1) {
                int audioSessionId = this.i.getAudioSessionId();
                if (this.Z != audioSessionId) {
                    this.Z = audioSessionId;
                    MediaCodecAudioRenderer.b bVar = (MediaCodecAudioRenderer.b) this.d;
                    MediaCodecAudioRenderer.this.V.audioSessionId(audioSessionId);
                    MediaCodecAudioRenderer.this.getClass();
                }
                this.g.a(this.i, f());
                k();
                this.b0 = false;
                if (this.Y) {
                    g();
                }
            } else {
                try {
                    this.i.release();
                } catch (Exception unused) {
                } finally {
                    this.i = null;
                }
                throw new e(state, this.j, this.k, this.p);
            }
        }
        if (f()) {
            if (this.i.getPlayState() == 2) {
                this.b0 = false;
                return false;
            }
            if (this.i.getPlayState() == 1 && this.g.a() != 0) {
                return false;
            }
        }
        boolean z = this.b0;
        boolean zD = d();
        this.b0 = zD;
        if (z && !zD && this.i.getPlayState() != 1) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c0;
            MediaCodecAudioRenderer.b bVar2 = (MediaCodecAudioRenderer.b) this.d;
            MediaCodecAudioRenderer.this.V.audioTrackUnderrun(this.p, com.fyber.inneractive.sdk.player.exoplayer2.b.b(this.q), jElapsedRealtime);
            MediaCodecAudioRenderer.this.getClass();
        }
        if (this.S == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.o && this.K == 0) {
                int i3 = this.m;
                if (i3 == 7 || i3 == 8) {
                    int iPosition = byteBuffer.position();
                    i2 = ((((byteBuffer.get(iPosition + 5) & 252) >> 2) | ((byteBuffer.get(iPosition + 4) & 1) << 6)) + 1) * 32;
                } else if (i3 == 5) {
                    i2 = 1536;
                } else if (i3 == 6) {
                    i2 = (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
                } else {
                    throw new IllegalStateException("Unexpected audio encoding: " + i3);
                }
                this.K = i2;
            }
            if (this.r != null) {
                if (!a()) {
                    return false;
                }
                this.h.add(new g(this.r, Math.max(0L, j), b(c())));
                this.r = null;
                i();
            }
            if (this.L == 0) {
                this.M = Math.max(0L, j);
                this.L = 1;
            } else {
                long jB = this.M + b(b());
                if (this.L != 1 || Math.abs(jB - j) <= 200000) {
                    i = 2;
                } else {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + jB + ", got " + j + "]");
                    i = 2;
                    this.L = 2;
                }
                if (this.L == i) {
                    this.M += j - jB;
                    this.L = 1;
                    MediaCodecAudioRenderer.b bVar3 = (MediaCodecAudioRenderer.b) this.d;
                    MediaCodecAudioRenderer.this.getClass();
                    MediaCodecAudioRenderer.this.b0 = true;
                }
            }
            if (this.o) {
                this.G += (long) this.K;
            } else {
                this.F += (long) byteBuffer.remaining();
            }
            this.S = byteBuffer;
        }
        if (this.o) {
            b(this.S, j);
        } else {
            c(j);
        }
        if (this.S.hasRemaining()) {
            return false;
        }
        this.S = null;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final boolean a() throws com.fyber.inneractive.sdk.player.exoplayer2.audio.c.h {
        /*
            r9 = this;
            int r0 = r9.W
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.o
            if (r0 == 0) goto Lf
            com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] r0 = r9.Q
            int r0 = r0.length
            goto L10
        Lf:
            r0 = r3
        L10:
            r9.W = r0
        L12:
            r0 = r2
            goto L15
        L14:
            r0 = r3
        L15:
            int r4 = r9.W
            com.fyber.inneractive.sdk.player.exoplayer2.audio.b[] r5 = r9.Q
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.c()
        L28:
            r9.c(r7)
            boolean r0 = r4.b()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.W
            int r0 = r0 + r2
            r9.W = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.T
            if (r0 == 0) goto L44
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.T
            if (r0 == 0) goto L44
            return r3
        L44:
            r9.W = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.audio.c.a():boolean");
    }

    public m a(m mVar) {
        if (this.o) {
            m mVar2 = m.d;
            this.s = mVar2;
            return mVar2;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.audio.h hVar = this.f1039b;
        float f2 = mVar.a;
        hVar.getClass();
        int i = u.a;
        float fMax = Math.max(0.1f, Math.min(f2, 8.0f));
        hVar.e = fMax;
        com.fyber.inneractive.sdk.player.exoplayer2.audio.h hVar2 = this.f1039b;
        float f3 = mVar.f1157b;
        hVar2.getClass();
        hVar2.f = Math.max(0.1f, Math.min(f3, 8.0f));
        m mVar3 = new m(fMax, f3);
        m mVar4 = this.r;
        if (mVar4 == null) {
            if (!this.h.isEmpty()) {
                mVar4 = this.h.getLast().a;
            } else {
                mVar4 = this.s;
            }
        }
        if (!mVar3.equals(mVar4)) {
            if (e()) {
                this.r = mVar3;
            } else {
                this.s = mVar3;
            }
        }
        return this.s;
    }

    public final long a(long j) {
        return (j * ((long) this.j)) / 1000000;
    }

    public static int a(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/eac3":
                return 6;
            case "audio/vnd.dts.hd":
                return 8;
            default:
                return 0;
        }
    }
}
