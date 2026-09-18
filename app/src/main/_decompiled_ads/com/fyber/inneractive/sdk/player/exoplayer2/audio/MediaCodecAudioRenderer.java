package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.Surface;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class MediaCodecAudioRenderer extends com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b implements com.fyber.inneractive.sdk.player.exoplayer2.util.g {
    public final AudioRendererEventListener.EventDispatcher V;
    public final c W;
    public boolean X;
    public int Y;
    public int Z;
    public long a0;
    public boolean b0;

    public final class b implements c.f {
        public b() {
        }
    }

    public MediaCodecAudioRenderer(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> cVar2, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(cVar, cVar2, z, null, null, new com.fyber.inneractive.sdk.player.exoplayer2.audio.b[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b, com.fyber.inneractive.sdk.player.exoplayer2.n
    public boolean b() {
        if (this.Q) {
            c cVar = this.W;
            if (!cVar.e() || (cVar.X && !cVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.g
    public m i() {
        return this.W.s;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b, com.fyber.inneractive.sdk.player.exoplayer2.n
    public boolean isReady() {
        return this.W.d() || super.isReady();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a, com.fyber.inneractive.sdk.player.exoplayer2.n
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g j() {
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0261  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.g
    public long o() {
        long jA;
        long jA2;
        long jMax;
        long j;
        c cVar = this.W;
        boolean zB = b();
        if (cVar.e() && cVar.L != 0) {
            if (cVar.i.getPlayState() == 3) {
                c.b bVar = cVar.g;
                long jA3 = (bVar.a() * 1000000) / ((long) bVar.c);
                if (jA3 != 0) {
                    long jNanoTime = System.nanoTime() / 1000;
                    if (jNanoTime - cVar.A >= 30000) {
                        long[] jArr = cVar.f;
                        int i = cVar.x;
                        jArr[i] = jA3 - jNanoTime;
                        cVar.x = (i + 1) % 10;
                        int i2 = cVar.y;
                        if (i2 < 10) {
                            cVar.y = i2 + 1;
                        }
                        cVar.A = jNanoTime;
                        cVar.z = 0L;
                        int i3 = 0;
                        while (true) {
                            int i4 = cVar.y;
                            if (i3 >= i4) {
                                break;
                            }
                            cVar.z += cVar.f[i3] / ((long) i4);
                            i3++;
                        }
                    }
                    if (!cVar.f() && jNanoTime - cVar.C >= 500000) {
                        boolean zD = cVar.g.d();
                        cVar.B = zD;
                        if (zD) {
                            long jC = cVar.g.c() / 1000;
                            long jB = cVar.g.b();
                            if (jC < cVar.N) {
                                cVar.B = false;
                            } else if (Math.abs(jC - jNanoTime) > 5000000) {
                                Log.w("AudioTrack", "Spurious audio timestamp (system clock mismatch): " + jB + ", " + jC + ", " + jNanoTime + ", " + jA3 + ", " + cVar.b() + ", " + cVar.c());
                                cVar.B = false;
                            } else if (Math.abs(cVar.b(jB) - jA3) > 5000000) {
                                Log.w("AudioTrack", "Spurious audio timestamp (frame position mismatch): " + jB + ", " + jC + ", " + jNanoTime + ", " + jA3 + ", " + cVar.b() + ", " + cVar.c());
                                cVar.B = false;
                            }
                        }
                        Method method = cVar.D;
                        if (method != null && !cVar.o) {
                            try {
                                long jIntValue = (((long) ((Integer) method.invoke(cVar.i, null)).intValue()) * 1000) - cVar.q;
                                cVar.O = jIntValue;
                                long jMax2 = Math.max(jIntValue, 0L);
                                cVar.O = jMax2;
                                if (jMax2 > 5000000) {
                                    Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + cVar.O);
                                    cVar.O = 0L;
                                }
                            } catch (Exception unused) {
                                cVar.D = null;
                            }
                        }
                        cVar.C = jNanoTime;
                    }
                }
            }
            long jNanoTime2 = System.nanoTime() / 1000;
            if (cVar.B) {
                jA = cVar.b(cVar.g.b() + cVar.a(jNanoTime2 - (cVar.g.c() / 1000)));
            } else {
                if (cVar.y == 0) {
                    c.b bVar2 = cVar.g;
                    jA = (bVar2.a() * 1000000) / ((long) bVar2.c);
                } else {
                    jA = jNanoTime2 + cVar.z;
                }
                if (!zB) {
                    jA -= cVar.O;
                }
            }
            long j2 = cVar.M;
            while (!cVar.h.isEmpty() && jA >= cVar.h.getFirst().c) {
                c.g gVarRemove = cVar.h.remove();
                cVar.s = gVarRemove.a;
                cVar.u = gVarRemove.c;
                cVar.t = gVarRemove.f1042b - cVar.M;
            }
            if (cVar.s.a == 1.0f) {
                jA2 = (jA + cVar.t) - cVar.u;
            } else if (cVar.h.isEmpty()) {
                h hVar = cVar.f1039b;
                long j3 = hVar.k;
                if (j3 >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                    jA2 = cVar.t + u.a(jA - cVar.u, hVar.j, j3);
                } else {
                    jA2 = cVar.t + ((long) (((double) cVar.s.a) * (jA - cVar.u)));
                }
            } else {
                jA2 = cVar.t + ((long) (((double) cVar.s.a) * (jA - cVar.u)));
            }
            jMax = j2 + jA2;
            j = Long.MIN_VALUE;
        } else {
            j = Long.MIN_VALUE;
            jMax = Long.MIN_VALUE;
        }
        if (jMax != j) {
            if (!this.b0) {
                jMax = Math.max(this.a0, jMax);
            }
            this.a0 = jMax;
            this.b0 = false;
        }
        return this.a0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b, com.fyber.inneractive.sdk.player.exoplayer2.a
    public void p() {
        try {
            c cVar = this.W;
            cVar.h();
            for (com.fyber.inneractive.sdk.player.exoplayer2.audio.b bVar : cVar.c) {
                bVar.g();
            }
            cVar.Z = 0;
            cVar.Y = false;
            try {
                super.p();
            } finally {
                this.T.ensureUpdated();
                this.V.disabled(this.T);
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
                this.T.ensureUpdated();
                this.V.disabled(this.T);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void q() {
        this.W.g();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void r() {
        c cVar = this.W;
        cVar.Y = false;
        if (cVar.e()) {
            cVar.j();
            c.b bVar = cVar.g;
            if (bVar.g != -9223372036854775807L) {
                return;
            }
            bVar.a.pause();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void w() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        try {
            c cVar = this.W;
            if (!cVar.X && cVar.e() && cVar.a()) {
                c.b bVar = cVar.g;
                long jC = cVar.c();
                bVar.h = bVar.a();
                bVar.g = SystemClock.elapsedRealtime() * 1000;
                bVar.i = jC;
                bVar.a.stop();
                cVar.w = 0;
                cVar.X = true;
            }
        } catch (c.h e) {
            throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, this.c);
        }
    }

    public MediaCodecAudioRenderer(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, com.fyber.inneractive.sdk.player.exoplayer2.drm.c cVar2, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, com.fyber.inneractive.sdk.player.exoplayer2.audio.b... bVarArr) {
        super(1, cVar, cVar2, z);
        this.W = new c(bVarArr, new b());
        this.V = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x0070  */
    /* JADX WARN: Code duplicated, block: B:35:0x0076  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0086  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:74:0x0131  */
    /* JADX WARN: Code duplicated, block: B:75:0x0149  */
    /* JADX WARN: Code duplicated, block: B:77:0x014c  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, i iVar) throws com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b {
        int i;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        MediaCodecInfo.AudioCapabilities audioCapabilities;
        String str;
        String str2;
        int maxInputChannelCount;
        boolean z;
        boolean z2;
        String str3 = iVar.f;
        boolean z3 = false;
        if (!com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str3)) {
            return 0;
        }
        int i2 = u.a;
        int i3 = 16;
        int i4 = i2 >= 21 ? 16 : 0;
        this.W.getClass();
        com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVarA = cVar.a(str3, false);
        if (aVarA == null) {
            return 1;
        }
        if (i2 < 21) {
            z3 = true;
        } else {
            int i5 = iVar.s;
            if (i5 == -1) {
                i = iVar.r;
                if (i == -1) {
                    z3 = true;
                } else {
                    codecCapabilities = aVarA.e;
                    if (codecCapabilities == null) {
                        aVarA.a("channelCount.caps");
                    } else {
                        audioCapabilities = codecCapabilities.getAudioCapabilities();
                        if (audioCapabilities == null) {
                            aVarA.a("channelCount.aCaps");
                        } else {
                            str = aVarA.a;
                            str2 = aVarA.d;
                            maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
                            if (maxInputChannelCount <= 1 && ((i2 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                                if ("audio/ac3".equals(str2)) {
                                    i3 = 6;
                                } else if (!"audio/eac3".equals(str2)) {
                                    i3 = 30;
                                }
                                Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i3 + "]");
                                maxInputChannelCount = i3;
                            }
                            if (maxInputChannelCount < i) {
                                aVarA.a("channelCount.support, " + i);
                            } else {
                                z = true;
                            }
                            if (z) {
                                z3 = true;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        z3 = true;
                    }
                }
            } else {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = aVarA.e;
                if (codecCapabilities2 == null) {
                    aVarA.a("sampleRate.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        aVarA.a("sampleRate.aCaps");
                    } else {
                        if (audioCapabilities2.isSampleRateSupported(i5)) {
                            z2 = true;
                        } else {
                            aVarA.a("sampleRate.support, " + i5);
                        }
                        if (z2) {
                            i = iVar.r;
                            if (i == -1) {
                                z3 = true;
                            } else {
                                codecCapabilities = aVarA.e;
                                if (codecCapabilities == null) {
                                    aVarA.a("channelCount.caps");
                                } else {
                                    audioCapabilities = codecCapabilities.getAudioCapabilities();
                                    if (audioCapabilities == null) {
                                        aVarA.a("channelCount.aCaps");
                                    } else {
                                        str = aVarA.a;
                                        str2 = aVarA.d;
                                        maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
                                        if (maxInputChannelCount <= 1) {
                                            if ("audio/ac3".equals(str2)) {
                                                i3 = 6;
                                            } else if (!"audio/eac3".equals(str2)) {
                                                i3 = 30;
                                            }
                                            Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i3 + "]");
                                            maxInputChannelCount = i3;
                                        }
                                        if (maxInputChannelCount < i) {
                                            aVarA.a("channelCount.support, " + i);
                                        } else {
                                            z = true;
                                        }
                                        if (z) {
                                            z3 = true;
                                        }
                                    }
                                }
                                z = false;
                                if (z) {
                                    z3 = true;
                                }
                            }
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    i = iVar.r;
                    if (i == -1) {
                        z3 = true;
                    } else {
                        codecCapabilities = aVarA.e;
                        if (codecCapabilities == null) {
                            aVarA.a("channelCount.caps");
                        } else {
                            audioCapabilities = codecCapabilities.getAudioCapabilities();
                            if (audioCapabilities == null) {
                                aVarA.a("channelCount.aCaps");
                            } else {
                                str = aVarA.a;
                                str2 = aVarA.d;
                                maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
                                if (maxInputChannelCount <= 1) {
                                    if ("audio/ac3".equals(str2)) {
                                        i3 = 6;
                                    } else if (!"audio/eac3".equals(str2)) {
                                        i3 = 30;
                                    }
                                    Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i3 + "]");
                                    maxInputChannelCount = i3;
                                }
                                if (maxInputChannelCount < i) {
                                    aVarA.a("channelCount.support, " + i);
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    z3 = true;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            z3 = true;
                        }
                    }
                }
            }
        }
        return (z3 ? 3 : 2) | i4 | 4;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, i iVar, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b {
        String str = iVar.f;
        this.W.getClass();
        return cVar.a(iVar.f, z);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, i iVar, MediaCrypto mediaCrypto) {
        boolean z;
        String str = aVar.a;
        if (u.a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(u.c)) {
            String str2 = u.f1242b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.X = z;
        mediaCodec.configure(iVar.a(), (Surface) null, (MediaCrypto) null, 0);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(String str, long j, long j2) {
        this.V.decoderInitialized(str, j, j2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(i iVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(iVar);
        this.V.inputFormatChanged(iVar);
        this.Y = "audio/raw".equals(iVar.f) ? iVar.t : 2;
        this.Z = iVar.r;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int[] iArr;
        int i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.X && integer == 6 && (i = this.Z) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.Z; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        try {
            this.W.a("audio/raw", integer, integer2, this.Y, 0, iArr);
        } catch (c.d e) {
            throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, this.c);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b, com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(long j, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(j, z);
        this.W.h();
        this.a0 = j;
        this.b0 = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.g
    public m a(m mVar) {
        return this.W.a(mVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.T.skippedOutputBufferCount++;
            c cVar = this.W;
            if (cVar.L == 1) {
                cVar.L = 2;
            }
            return true;
        }
        try {
            if (!this.W.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.T.renderedOutputBufferCount++;
            return true;
        } catch (c.e | c.h e) {
            throw com.fyber.inneractive.sdk.player.exoplayer2.d.a(e, this.c);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.T = decoderCounters;
        this.V.enabled(decoderCounters);
        int i = this.f1031b.a;
        if (i != 0) {
            c cVar = this.W;
            cVar.getClass();
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(u.a >= 21);
            if (cVar.a0 && cVar.Z == i) {
                return;
            }
            cVar.a0 = true;
            cVar.Z = i;
            cVar.h();
            return;
        }
        c cVar2 = this.W;
        if (cVar2.a0) {
            cVar2.a0 = false;
            cVar2.Z = 0;
            cVar2.h();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.e.b
    public void a(int i, Object obj) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (i == 2) {
            c cVar = this.W;
            float fFloatValue = ((Float) obj).floatValue();
            if (cVar.P != fFloatValue) {
                cVar.P = fFloatValue;
                cVar.k();
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        c cVar2 = this.W;
        if (cVar2.n == iIntValue) {
            return;
        }
        cVar2.n = iIntValue;
        if (cVar2.a0) {
            return;
        }
        cVar2.h();
        cVar2.Z = 0;
    }
}
