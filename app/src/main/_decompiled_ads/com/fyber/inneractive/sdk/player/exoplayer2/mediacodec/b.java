package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends com.fyber.inneractive.sdk.player.exoplayer2.a {
    public static final byte[] U;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ByteBuffer[] E;
    public ByteBuffer[] F;
    public long G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public DecoderCounters T;
    public final c i;
    public final com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> j;
    public final boolean k;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.b l;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.b m;
    public final j n;
    public final List<Long> o;
    public final MediaCodec.BufferInfo p;
    public i q;
    public MediaCodec r;
    public com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> s;
    public com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    static {
        int i = u.a;
        byte[] bArr = new byte[38];
        for (int i2 = 0; i2 < 38; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3), 16) << 4) + Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3 + 1), 16));
        }
        U = bArr;
    }

    public b(int i, c cVar, com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> cVar2, boolean z) {
        super(i);
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(u.a >= 16);
        this.i = (c) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(cVar);
        this.j = cVar2;
        this.k = z;
        this.l = new com.fyber.inneractive.sdk.player.exoplayer2.decoder.b(0);
        this.m = com.fyber.inneractive.sdk.player.exoplayer2.decoder.b.b();
        this.n = new j();
        this.o = new ArrayList();
        this.p = new MediaCodec.BufferInfo();
        this.L = 0;
        this.M = 0;
    }

    public abstract int a(c cVar, i iVar) throws d.b;

    public com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a(c cVar, i iVar, boolean z) throws d.b {
        return cVar.a(iVar.f, z);
    }

    public abstract void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.fyber.inneractive.sdk.player.exoplayer2.d;

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar) {
    }

    public abstract void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, i iVar, MediaCrypto mediaCrypto) throws d.b;

    public abstract void a(String str, long j, long j2);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d;

    public boolean a(MediaCodec mediaCodec, boolean z, i iVar, i iVar2) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.n
    public boolean b() {
        return this.Q;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.n
    public boolean isReady() {
        if (this.q != null && !this.R) {
            if ((this.g ? this.h : this.e.isReady()) || this.I >= 0 || (this.G != -9223372036854775807L && SystemClock.elapsedRealtime() < this.G)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void p() {
        this.q = null;
        try {
            v();
            try {
                com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar = this.s;
                if (bVar != null) {
                    this.j.a(bVar);
                }
                try {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar2 = this.t;
                    if (bVar2 != null && bVar2 != this.s) {
                        this.j.a(bVar2);
                    }
                } finally {
                    this.s = null;
                    this.t = null;
                }
            } catch (Throwable th) {
                try {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar3 = this.t;
                    if (bVar3 != null && bVar3 != this.s) {
                        this.j.a(bVar3);
                    }
                    throw th;
                } finally {
                    this.s = null;
                    this.t = null;
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.s != null) {
                    this.j.a(this.s);
                }
                try {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar4 = this.t;
                    if (bVar4 != null && bVar4 != this.s) {
                        this.j.a(bVar4);
                    }
                    throw th2;
                } finally {
                    this.s = null;
                    this.t = null;
                }
            } catch (Throwable th3) {
                try {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar5 = this.t;
                    if (bVar5 != null && bVar5 != this.s) {
                        this.j.a(bVar5);
                    }
                    throw th3;
                } finally {
                    this.s = null;
                    this.t = null;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0134  */
    public final boolean s() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int iPosition;
        int iA;
        boolean z;
        MediaCodec mediaCodec = this.r;
        if (mediaCodec == null || this.M == 2 || this.P) {
            return false;
        }
        if (this.H < 0) {
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.H = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar = this.l;
            bVar.c = this.E[iDequeueInputBuffer];
            bVar.a();
        }
        if (this.M == 1) {
            if (!this.y) {
                this.O = true;
                this.r.queueInputBuffer(this.H, 0, 0, 0L, 4);
                this.H = -1;
            }
            this.M = 2;
            return false;
        }
        if (this.C) {
            this.C = false;
            ByteBuffer byteBuffer = this.l.c;
            byte[] bArr = U;
            byteBuffer.put(bArr);
            this.r.queueInputBuffer(this.H, 0, bArr.length, 0L, 0);
            this.H = -1;
            this.N = true;
            return true;
        }
        if (this.R) {
            iA = -4;
            iPosition = 0;
        } else {
            if (this.L == 1) {
                for (int i = 0; i < this.q.h.size(); i++) {
                    this.l.c.put(this.q.h.get(i));
                }
                this.L = 2;
            }
            iPosition = this.l.c.position();
            iA = a(this.n, this.l, false);
        }
        if (iA == -3) {
            return false;
        }
        if (iA == -5) {
            if (this.L == 2) {
                this.l.a();
                this.L = 1;
            }
            a(this.n.a);
            return true;
        }
        if (this.l.b(4)) {
            if (this.L == 2) {
                this.l.a();
                this.L = 1;
            }
            this.P = true;
            if (!this.N) {
                u();
                return false;
            }
            try {
                if (!this.y) {
                    this.O = true;
                    this.r.queueInputBuffer(this.H, 0, 0, 0L, 4);
                    this.H = -1;
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, this.c);
            }
        }
        if (this.S && !this.l.b(1)) {
            this.l.a();
            if (this.L == 2) {
                this.L = 1;
            }
            return true;
        }
        this.S = false;
        boolean zB = this.l.b(1073741824);
        com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar2 = this.s;
        if (bVar2 != null) {
            int iA2 = bVar2.a();
            if (iA2 == 0) {
                this.s.c();
                throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(null, this.c);
            }
            if (iA2 == 4 || (!zB && this.k)) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        this.R = z;
        if (z) {
            return false;
        }
        if (this.v && !zB) {
            ByteBuffer byteBuffer2 = this.l.c;
            byte[] bArr2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a;
            int iPosition2 = byteBuffer2.position();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= iPosition2) {
                    byteBuffer2.clear();
                    break;
                }
                int i5 = byteBuffer2.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer2.get(i4) & 31) == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                        byteBufferDuplicate.position(i2 - 3);
                        byteBufferDuplicate.limit(iPosition2);
                        byteBuffer2.position(0);
                        byteBuffer2.put(byteBufferDuplicate);
                        break;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            }
            if (this.l.c.position() == 0) {
                return true;
            }
            this.v = false;
        }
        try {
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar3 = this.l;
            long j = bVar3.d;
            if (bVar3.b(Integer.MIN_VALUE)) {
                this.o.add(Long.valueOf(j));
            }
            this.l.c.flip();
            a(this.l);
            if (zB) {
                MediaCodec.CryptoInfo cryptoInfo = this.l.f1052b.g;
                if (iPosition != 0) {
                    if (cryptoInfo.numBytesOfClearData == null) {
                        cryptoInfo.numBytesOfClearData = new int[1];
                    }
                    int[] iArr = cryptoInfo.numBytesOfClearData;
                    iArr[0] = iArr[0] + iPosition;
                }
                this.r.queueSecureInputBuffer(this.H, 0, cryptoInfo, j, 0);
            } else {
                this.r.queueInputBuffer(this.H, 0, this.l.c.limit(), j, 0);
            }
            this.H = -1;
            this.N = true;
            this.L = 0;
            this.T.inputBufferCount++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e2, this.c);
        }
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0116  */
    public final void t() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        boolean zA;
        boolean z;
        if (x()) {
            com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar = this.t;
            this.s = bVar;
            String str = this.q.f;
            boolean z2 = false;
            if (bVar != null) {
                int iA = bVar.a();
                if (iA == 0) {
                    this.s.c();
                    throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(null, this.c);
                }
                if (iA != 3 && iA != 4) {
                    return;
                }
                this.s.b().getClass();
                zA = this.s.a(str);
            } else {
                zA = false;
            }
            try {
                com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVarA = a(this.i, this.q, zA);
                if (aVarA == null && zA && (aVarA = a(this.i, this.q, false)) != null) {
                    Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + aVarA.a + ".");
                }
                if (aVarA == null) {
                    throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(new a(this.q, (Throwable) null, zA, -49999), this.c);
                }
                String str2 = aVarA.a;
                this.u = aVarA.f1158b;
                i iVar = this.q;
                int i = u.a;
                this.v = i < 21 && iVar.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                this.w = i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (i == 19 && u.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                if (i >= 24 || !("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2))) {
                    z = false;
                } else {
                    String str3 = u.f1242b;
                    if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                this.x = z;
                this.y = i <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                this.z = (i <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (i <= 19 && "hb2000".equals(u.f1242b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                this.A = i == 21 && "OMX.google.aac.decoder".equals(str2);
                i iVar2 = this.q;
                if (i <= 18 && iVar2.r == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z2 = true;
                }
                this.B = z2;
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    s.a("createCodec:" + str2);
                    this.r = MediaCodec.createByCodecName(str2);
                    s.a();
                    s.a("configureCodec");
                    a(aVarA, this.r, this.q, (MediaCrypto) null);
                    s.a();
                    s.a("startCodec");
                    this.r.start();
                    s.a();
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                    this.E = this.r.getInputBuffers();
                    this.F = this.r.getOutputBuffers();
                    this.G = this.d == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.H = -1;
                    this.I = -1;
                    this.S = true;
                    this.T.decoderInitCount++;
                } catch (Exception e) {
                    throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(new a(this.q, e, zA, str2), this.c);
                }
            } catch (d.b e2) {
                throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(new a(this.q, e2, zA, -49998), this.c);
            }
        }
    }

    public final void u() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (this.M == 2) {
            v();
            t();
        } else {
            this.Q = true;
            w();
        }
    }

    public void v() {
        if (this.r != null) {
            this.G = -9223372036854775807L;
            this.H = -1;
            this.I = -1;
            this.R = false;
            this.J = false;
            this.o.clear();
            this.E = null;
            this.F = null;
            this.K = false;
            this.N = false;
            this.u = false;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = false;
            this.z = false;
            this.B = false;
            this.C = false;
            this.D = false;
            this.O = false;
            this.L = 0;
            this.M = 0;
            this.T.decoderReleaseCount++;
            this.l.c = null;
            try {
                this.r.stop();
                try {
                    this.r.release();
                    this.r = null;
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar = this.s;
                    if (bVar == null || this.t == bVar) {
                        return;
                    }
                    try {
                        this.j.a(bVar);
                    } finally {
                        this.s = null;
                    }
                } catch (Throwable th) {
                    this.r = null;
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar2 = this.s;
                    if (bVar2 != null && this.t != bVar2) {
                        try {
                            this.j.a(bVar2);
                        } finally {
                            this.s = null;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.r.release();
                    this.r = null;
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar3 = this.s;
                    if (bVar3 != null && this.t != bVar3) {
                        try {
                            this.j.a(bVar3);
                        } finally {
                            this.s = null;
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.r = null;
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVar4 = this.s;
                    if (bVar4 != null && this.t != bVar4) {
                        try {
                            this.j.a(bVar4);
                        } finally {
                            this.s = null;
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void w() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
    }

    public boolean x() {
        return this.r == null && this.q != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(long j, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.P = false;
        this.Q = false;
        if (this.r != null) {
            this.G = -9223372036854775807L;
            this.H = -1;
            this.I = -1;
            this.S = true;
            this.R = false;
            this.J = false;
            this.o.clear();
            this.C = false;
            this.D = false;
            if (this.w || ((this.z && this.O) || this.M != 0)) {
                v();
                t();
            } else {
                this.r.flush();
                this.N = false;
            }
            if (!this.K || this.q == null) {
                return;
            }
            this.L = 1;
        }
    }

    public static class a extends Exception {
        public a(i iVar, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + iVar, th);
            String str = iVar.f;
            a(i);
        }

        public static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public static String a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        public a(i iVar, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + iVar, th);
            String str2 = iVar.f;
            if (u.a >= 21) {
                a(th);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x015c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0179  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.n
    public void a(long j, long j2) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        boolean zA;
        boolean z;
        if (this.Q) {
            w();
            return;
        }
        boolean z2 = true;
        if (this.q == null) {
            this.m.a();
            int iA = a(this.n, this.m, true);
            if (iA != -5) {
                if (iA == -4) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.m.b(4));
                    this.P = true;
                    u();
                    return;
                }
                return;
            }
            a(this.n.a);
        }
        t();
        if (this.r != null) {
            s.a("drainAndFeed");
            while (true) {
                if (this.I < 0) {
                    if (this.A && this.O) {
                        try {
                            this.I = this.r.dequeueOutputBuffer(this.p, 0L);
                        } catch (IllegalStateException unused) {
                            u();
                            if (this.Q) {
                                v();
                            }
                        }
                    } else {
                        this.I = this.r.dequeueOutputBuffer(this.p, 0L);
                    }
                    int i = this.I;
                    if (i >= 0) {
                        if (this.D) {
                            this.D = false;
                            this.r.releaseOutputBuffer(i, false);
                            this.I = -1;
                        } else {
                            MediaCodec.BufferInfo bufferInfo = this.p;
                            if ((bufferInfo.flags & 4) != 0) {
                                u();
                                this.I = -1;
                            } else {
                                ByteBuffer byteBuffer = this.F[i];
                                if (byteBuffer != null) {
                                    byteBuffer.position(bufferInfo.offset);
                                    MediaCodec.BufferInfo bufferInfo2 = this.p;
                                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                                }
                                long j3 = this.p.presentationTimeUs;
                                int size = this.o.size();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= size) {
                                        z = false;
                                        break;
                                    } else {
                                        if (this.o.get(i2).longValue() == j3) {
                                            this.o.remove(i2);
                                            z = z2 ? 1 : 0;
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                                this.J = z;
                                if (!this.A) {
                                    MediaCodec mediaCodec = this.r;
                                    ByteBuffer[] byteBufferArr = this.F;
                                    int i3 = this.I;
                                    ByteBuffer byteBuffer2 = byteBufferArr[i3];
                                    MediaCodec.BufferInfo bufferInfo3 = this.p;
                                    zA = a(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.J);
                                    if (zA) {
                                        long j4 = this.p.presentationTimeUs;
                                        this.I = -1;
                                        z2 = true;
                                    }
                                } else {
                                    MediaCodec mediaCodec2 = this.r;
                                    ByteBuffer[] byteBufferArr2 = this.F;
                                    int i4 = this.I;
                                    ByteBuffer byteBuffer3 = byteBufferArr2[i4];
                                    MediaCodec.BufferInfo bufferInfo4 = this.p;
                                    zA = a(j, j2, mediaCodec2, byteBuffer3, i4, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.J);
                                    if (zA) {
                                        long j5 = this.p.presentationTimeUs;
                                        this.I = -1;
                                        z2 = true;
                                    }
                                }
                            }
                            z2 = false;
                        }
                    } else if (i == -2) {
                        MediaFormat outputFormat = this.r.getOutputFormat();
                        if (this.x && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                            this.D = z2;
                        } else {
                            if (this.B) {
                                outputFormat.setInteger("channel-count", z2 ? 1 : 0);
                            }
                            a(this.r, outputFormat);
                        }
                    } else if (i == -3) {
                        this.F = this.r.getOutputBuffers();
                    } else {
                        if (this.y && (this.P || this.M == 2)) {
                            u();
                        }
                        z2 = false;
                    }
                } else {
                    if (!this.A && this.O) {
                        try {
                            MediaCodec mediaCodec3 = this.r;
                            ByteBuffer[] byteBufferArr3 = this.F;
                            int i5 = this.I;
                            ByteBuffer byteBuffer4 = byteBufferArr3[i5];
                            MediaCodec.BufferInfo bufferInfo5 = this.p;
                            zA = a(j, j2, mediaCodec3, byteBuffer4, i5, bufferInfo5.flags, bufferInfo5.presentationTimeUs, this.J);
                        } catch (IllegalStateException unused2) {
                            u();
                            if (this.Q) {
                                v();
                            }
                        }
                    } else {
                        MediaCodec mediaCodec4 = this.r;
                        ByteBuffer[] byteBufferArr4 = this.F;
                        int i6 = this.I;
                        ByteBuffer byteBuffer5 = byteBufferArr4[i6];
                        MediaCodec.BufferInfo bufferInfo6 = this.p;
                        zA = a(j, j2, mediaCodec4, byteBuffer5, i6, bufferInfo6.flags, bufferInfo6.presentationTimeUs, this.J);
                    }
                    if (zA) {
                        long j6 = this.p.presentationTimeUs;
                        this.I = -1;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (!z2) {
                    break;
                } else {
                    z2 = true;
                }
            }
            while (s()) {
            }
            s.a();
        } else {
            this.e.a(j - this.f);
            this.m.a();
            int iA2 = a(this.n, this.m, false);
            if (iA2 == -5) {
                a(this.n.a);
            } else if (iA2 == -4) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.m.b(4));
                this.P = true;
                u();
            }
        }
        this.T.ensureUpdated();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0072  */
    public void a(i iVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        MediaCodec mediaCodec;
        boolean z;
        i iVar2 = this.q;
        this.q = iVar;
        if (!u.a(iVar.i, iVar2 == null ? null : iVar2.i)) {
            if (this.q.i != null) {
                com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> cVar = this.j;
                if (cVar != null) {
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.b<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> bVarA = cVar.a(Looper.myLooper(), this.q.i);
                    this.t = bVarA;
                    if (bVarA == this.s) {
                        this.j.a(bVarA);
                    }
                } else {
                    throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(new IllegalStateException("Media requires a DrmSessionManager"), this.c);
                }
            } else {
                this.t = null;
            }
        }
        if (this.t == this.s && (mediaCodec = this.r) != null && a(mediaCodec, this.u, iVar2, this.q)) {
            this.K = true;
            this.L = 1;
            if (this.x) {
                i iVar3 = this.q;
                z = iVar3.j == iVar2.j && iVar3.k == iVar2.k;
            }
            this.C = z;
            return;
        }
        if (this.N) {
            this.M = 1;
        } else {
            v();
            t();
        }
    }
}
