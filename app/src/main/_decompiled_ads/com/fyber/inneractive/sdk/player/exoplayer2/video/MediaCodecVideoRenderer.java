package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.h;
import com.fyber.inneractive.sdk.player.exoplayer2.util.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public class MediaCodecVideoRenderer extends com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b {
    public static final int[] w0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public final d V;
    public final VideoRendererEventListener.EventDispatcher W;
    public final long X;
    public final int Y;
    public final boolean Z;
    public i[] a0;
    public a b0;
    public Surface c0;
    public int d0;
    public boolean e0;
    public long f0;
    public long g0;
    public int h0;
    public int i0;
    public int j0;
    public float k0;
    public int l0;
    public int m0;
    public int n0;
    public float o0;
    public int p0;
    public int q0;
    public int r0;
    public float s0;
    public boolean t0;
    public int u0;
    public b v0;

    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1243b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.f1243b = i2;
            this.c = i3;
        }
    }

    public final class b implements MediaCodec.OnFrameRenderedListener {
        public b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.v0) {
                return;
            }
            mediaCodecVideoRenderer.C();
        }
    }

    public MediaCodecVideoRenderer(Context context, com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, long j, com.fyber.inneractive.sdk.player.exoplayer2.drm.c<com.fyber.inneractive.sdk.player.exoplayer2.drm.d> cVar2, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, cVar, null, z);
        this.X = j;
        this.Y = i;
        this.V = new d(context);
        this.W = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.Z = A();
        this.f0 = -9223372036854775807L;
        this.l0 = -1;
        this.m0 = -1;
        this.o0 = -1.0f;
        this.k0 = -1.0f;
        this.d0 = 1;
        z();
    }

    public static boolean A() {
        return u.a <= 22 && "foster".equals(u.f1242b) && "NVIDIA".equals(u.c);
    }

    public final void B() {
        if (this.h0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.W.droppedFrames(this.h0, jElapsedRealtime - this.g0);
            this.h0 = 0;
            this.g0 = jElapsedRealtime;
        }
    }

    public void C() {
        if (this.e0) {
            return;
        }
        this.e0 = true;
        this.W.renderedFirstFrame(this.c0);
    }

    public final void D() {
        int i = this.l0;
        if (i == -1 && this.m0 == -1) {
            return;
        }
        if (this.p0 == i && this.q0 == this.m0 && this.r0 == this.n0 && this.s0 == this.o0) {
            return;
        }
        this.W.videoSizeChanged(i, this.m0, this.n0, this.o0);
        this.p0 = this.l0;
        this.q0 = this.m0;
        this.r0 = this.n0;
        this.s0 = this.o0;
    }

    public final void E() {
        int i = this.p0;
        if (i == -1 && this.q0 == -1) {
            return;
        }
        this.W.videoSizeChanged(i, this.q0, this.r0, this.s0);
    }

    public final void F() {
        this.f0 = this.X > 0 ? SystemClock.elapsedRealtime() + this.X : -9223372036854775807L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x0287  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar, i iVar) throws com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b {
        boolean z;
        int i;
        int i2;
        String strA;
        Pair pair;
        Integer numValueOf;
        Integer numValueOf2;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i3;
        String str = iVar.f;
        boolean zA = false;
        if (!h.e(str)) {
            return 0;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.drm.a aVar = iVar.i;
        if (aVar != null) {
            z = false;
            for (int i4 = 0; i4 < aVar.c; i4++) {
                z |= aVar.a[i4].e;
            }
        } else {
            z = false;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVarA = cVar.a(str, z);
        if (aVarA == null) {
            return 1;
        }
        String str2 = iVar.c;
        if (str2 == null || aVarA.d == null || (strA = h.a(str2)) == null) {
            zA = true;
        } else if (aVarA.d.equals(strA)) {
            com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar2 = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.a;
            String[] strArrSplit = str2.split("\\.");
            String str3 = strArrSplit[0];
            str3.getClass();
            str3.hashCode();
            switch (str3) {
                case "avc1":
                case "avc2":
                    if (strArrSplit.length >= 2) {
                        try {
                            if (strArrSplit[1].length() == 6) {
                                numValueOf = Integer.valueOf(Integer.parseInt(strArrSplit[1].substring(0, 2), 16));
                                numValueOf2 = Integer.valueOf(Integer.parseInt(strArrSplit[1].substring(4), 16));
                            } else if (strArrSplit.length >= 3) {
                                numValueOf = Integer.valueOf(Integer.parseInt(strArrSplit[1]));
                                numValueOf2 = Integer.valueOf(Integer.parseInt(strArrSplit[2]));
                            } else {
                                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str2);
                            }
                            Integer numValueOf3 = Integer.valueOf(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.d.get(numValueOf.intValue()));
                            if (numValueOf3 != null) {
                                Integer numValueOf4 = Integer.valueOf(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.e.get(numValueOf2.intValue()));
                                if (numValueOf4 != null) {
                                    pair = new Pair(numValueOf3, numValueOf4);
                                } else {
                                    Log.w("MediaCodecUtil", "Unknown AVC level: " + numValueOf2);
                                }
                            } else {
                                Log.w("MediaCodecUtil", "Unknown AVC profile: " + numValueOf);
                            }
                        } catch (NumberFormatException unused) {
                            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str2);
                        }
                        break;
                    } else {
                        Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str2);
                    }
                    pair = null;
                    break;
                case "hev1":
                case "hvc1":
                    if (strArrSplit.length >= 4) {
                        Matcher matcher = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.f1159b.matcher(strArrSplit[1]);
                        if (matcher.matches()) {
                            String strGroup = matcher.group(1);
                            if ("1".equals(strGroup)) {
                                i3 = 1;
                            } else if ("2".equals(strGroup)) {
                                i3 = 2;
                            } else {
                                Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                            }
                            Integer num = (Integer) ((HashMap) com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.f).get(strArrSplit[3]);
                            if (num != null) {
                                pair = new Pair(Integer.valueOf(i3), num);
                            } else {
                                Log.w("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
                            }
                        } else {
                            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str2);
                        }
                        break;
                    } else {
                        Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str2);
                    }
                    pair = null;
                    break;
                default:
                    pair = null;
                    break;
            }
            if (pair != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = aVarA.e;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i5];
                        if (codecProfileLevel.profile != ((Integer) pair.first).intValue() || codecProfileLevel.level < ((Integer) pair.second).intValue()) {
                            i5++;
                        } else {
                            zA = true;
                        }
                    } else {
                        aVarA.a("codec.profileLevel, " + str2 + ", " + strA);
                        zA = false;
                    }
                }
            } else {
                zA = true;
            }
        } else {
            aVarA.a("codec.mime " + str2 + ", " + strA);
        }
        if (zA && (i = iVar.j) > 0 && (i2 = iVar.k) > 0) {
            if (u.a >= 21) {
                zA = aVarA.a(i, i2, iVar.l);
            } else {
                boolean z2 = i * i2 <= com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.a();
                if (!z2) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + iVar.j + "x" + iVar.k + "] [" + u.e + "]");
                }
                zA = z2;
            }
        }
        return (aVarA.f1158b ? 8 : 4) | (aVarA.c ? 16 : 0) | (zA ? 3 : 2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b, com.fyber.inneractive.sdk.player.exoplayer2.n
    public boolean isReady() {
        if ((this.e0 || super.x()) && super.isReady()) {
            this.f0 = -9223372036854775807L;
            return true;
        }
        if (this.f0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f0) {
            return true;
        }
        this.f0 = -9223372036854775807L;
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b, com.fyber.inneractive.sdk.player.exoplayer2.a
    public void p() {
        this.l0 = -1;
        this.m0 = -1;
        this.o0 = -1.0f;
        this.k0 = -1.0f;
        z();
        y();
        d dVar = this.V;
        dVar.getClass();
        dVar.a.f1255b.sendEmptyMessage(2);
        this.v0 = null;
        try {
            super.p();
        } finally {
            this.T.ensureUpdated();
            this.W.disabled(this.T);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void q() {
        this.h0 = 0;
        this.g0 = SystemClock.elapsedRealtime();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void r() {
        this.f0 = -9223372036854775807L;
        B();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public boolean x() {
        Surface surface;
        return super.x() && (surface = this.c0) != null && surface.isValid();
    }

    public final void y() {
        MediaCodec mediaCodec;
        this.e0 = false;
        if (u.a < 23 || !this.t0 || (mediaCodec = this.r) == null) {
            return;
        }
        this.v0 = new b(mediaCodec);
    }

    public final void z() {
        this.p0 = -1;
        this.q0 = -1;
        this.s0 = -1.0f;
        this.r0 = -1;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(i[] iVarArr) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.a0 = iVarArr;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b, com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(long j, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(j, z);
        y();
        this.i0 = 0;
        if (z) {
            F();
        } else {
            this.f0 = -9223372036854775807L;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.e.b
    public void a(int i, Object obj) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (i != 1) {
            if (i == 4) {
                int iIntValue = ((Integer) obj).intValue();
                this.d0 = iIntValue;
                MediaCodec mediaCodec = this.r;
                if (mediaCodec != null) {
                    mediaCodec.setVideoScalingMode(iIntValue);
                    return;
                }
                return;
            }
            return;
        }
        Surface surface = (Surface) obj;
        if (this.c0 == surface) {
            if (surface != null) {
                E();
                if (this.e0) {
                    this.W.renderedFirstFrame(this.c0);
                    return;
                }
                return;
            }
            return;
        }
        this.c0 = surface;
        int i2 = this.d;
        if (i2 == 1 || i2 == 2) {
            MediaCodec mediaCodec2 = this.r;
            if (u.a >= 23 && mediaCodec2 != null && surface != null) {
                mediaCodec2.setOutputSurface(surface);
            } else {
                v();
                t();
            }
        }
        if (surface != null) {
            E();
            y();
            if (i2 == 2) {
                F();
                return;
            }
            return;
        }
        z();
        y();
    }

    /* JADX WARN: Code duplicated, block: B:96:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x012b A[SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, i iVar, MediaCrypto mediaCrypto) throws com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.b {
        a aVar2;
        Point point;
        Point point2;
        Point point3;
        int i;
        i[] iVarArr = this.a0;
        int iMax = iVar.j;
        int iMax2 = iVar.k;
        int iMax3 = iVar.g;
        if (iMax3 == -1) {
            iMax3 = a(iVar.f, iMax, iMax2);
        }
        if (iVarArr.length == 1) {
            aVar2 = new a(iMax, iMax2, iMax3);
        } else {
            boolean z = false;
            for (i iVar2 : iVarArr) {
                if (a(aVar.f1158b, iVar, iVar2)) {
                    int i2 = iVar2.j;
                    z |= i2 == -1 || iVar2.k == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, iVar2.k);
                    int iA = iVar2.g;
                    if (iA == -1) {
                        iA = a(iVar2.f, iVar2.j, iVar2.k);
                    }
                    iMax3 = Math.max(iMax3, iA);
                }
            }
            if (z) {
                Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
                int i3 = iVar.k;
                int i4 = iVar.j;
                boolean z2 = i3 > i4;
                int i5 = z2 ? i3 : i4;
                if (z2) {
                    i3 = i4;
                }
                float f = i3 / i5;
                int[] iArr = w0;
                int length = iArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        int i7 = length;
                        int i8 = iArr[i6];
                        int[] iArr2 = iArr;
                        int i9 = (int) (i8 * f);
                        if (i8 > i5 && i9 > i3) {
                            int i10 = i3;
                            float f2 = f;
                            if (u.a >= 21) {
                                int i11 = z2 ? i9 : i8;
                                if (!z2) {
                                    i8 = i9;
                                }
                                MediaCodecInfo.CodecCapabilities codecCapabilities = aVar.e;
                                if (codecCapabilities == null) {
                                    aVar.a("align.caps");
                                } else {
                                    MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
                                    if (videoCapabilities == null) {
                                        aVar.a("align.vCaps");
                                    } else {
                                        int widthAlignment = videoCapabilities.getWidthAlignment();
                                        int heightAlignment = videoCapabilities.getHeightAlignment();
                                        point2 = new Point(u.a(i11, widthAlignment) * widthAlignment, u.a(i8, heightAlignment) * heightAlignment);
                                    }
                                    point3 = point2;
                                    if (aVar.a(point2.x, point2.y, iVar.l)) {
                                        point = point3;
                                        break;
                                    }
                                    i6++;
                                    length = i7;
                                    iArr = iArr2;
                                    i3 = i10;
                                    f = f2;
                                    i5 = i5;
                                }
                                point2 = null;
                                point3 = point2;
                                if (aVar.a(point2.x, point2.y, iVar.l)) {
                                    point = point3;
                                    break;
                                }
                                i6++;
                                length = i7;
                                iArr = iArr2;
                                i3 = i10;
                                f = f2;
                                i5 = i5;
                            } else {
                                i5 = i5;
                                int iA2 = u.a(i8, 16) * 16;
                                int iA3 = u.a(i9, 16) * 16;
                                if (iA2 * iA3 <= com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d.a()) {
                                    int i12 = z2 ? iA3 : iA2;
                                    if (!z2) {
                                        iA2 = iA3;
                                    }
                                    point = new Point(i12, iA2);
                                    break;
                                }
                                i6++;
                                length = i7;
                                iArr = iArr2;
                                i3 = i10;
                                f = f2;
                                i5 = i5;
                            }
                        }
                    }
                    point = null;
                    break;
                }
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    iMax3 = Math.max(iMax3, a(iVar.f, iMax, iMax2));
                    Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                }
            }
            aVar2 = new a(iMax, iMax2, iMax3);
        }
        this.b0 = aVar2;
        boolean z3 = this.Z;
        int i13 = this.u0;
        MediaFormat mediaFormatA = iVar.a();
        mediaFormatA.setInteger("max-width", aVar2.a);
        mediaFormatA.setInteger("max-height", aVar2.f1243b);
        int i14 = aVar2.c;
        if (i14 != -1) {
            mediaFormatA.setInteger("max-input-size", i14);
        }
        if (z3) {
            i = 0;
            mediaFormatA.setInteger("auto-frc", 0);
        } else {
            i = 0;
        }
        if (i13 != 0) {
            mediaFormatA.setFeatureEnabled("tunneled-playback", true);
            mediaFormatA.setInteger("audio-session-id", i13);
        }
        mediaCodec.configure(mediaFormatA, this.c0, (MediaCrypto) null, i);
        if (u.a < 23 || !this.t0) {
            return;
        }
        this.v0 = new b(mediaCodec);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(String str, long j, long j2) {
        this.W.decoderInitialized(str, j, j2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(i iVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(iVar);
        this.W.inputFormatChanged(iVar);
        float f = iVar.n;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.k0 = f;
        int i = iVar.m;
        if (i == -1) {
            i = 0;
        }
        this.j0 = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar) {
        if (u.a >= 23 || !this.t0) {
            return;
        }
        C();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.l0 = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.m0 = integer2;
        float f = this.k0;
        this.o0 = f;
        if (u.a >= 21) {
            int i = this.j0;
            if (i == 90 || i == 270) {
                int i2 = this.l0;
                this.l0 = integer2;
                this.m0 = i2;
                this.o0 = 1.0f / f;
            }
        } else {
            this.n0 = this.j0;
        }
        mediaCodec.setVideoScalingMode(this.d0);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.T = decoderCounters;
        int i = this.f1031b.a;
        this.u0 = i;
        this.t0 = i != 0;
        this.W.enabled(decoderCounters);
        d dVar = this.V;
        dVar.g = false;
        dVar.a.f1255b.sendEmptyMessage(1);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public boolean a(MediaCodec mediaCodec, boolean z, i iVar, i iVar2) {
        if (a(z, iVar, iVar2)) {
            int i = iVar2.j;
            a aVar = this.b0;
            if (i <= aVar.a && iVar2.k <= aVar.f1243b && iVar2.g <= aVar.c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.b
    public boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        long j4;
        long j5;
        long j6;
        long j7;
        if (z) {
            s.a("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            s.a();
            this.T.skippedOutputBufferCount++;
            return true;
        }
        if (!this.e0) {
            if (u.a >= 21) {
                a(mediaCodec, i, System.nanoTime());
            } else {
                a(mediaCodec, i);
            }
            return true;
        }
        if (this.d != 2) {
            return false;
        }
        long jElapsedRealtime = (j3 - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long jNanoTime = System.nanoTime();
        long j8 = (jElapsedRealtime * 1000) + jNanoTime;
        d dVar = this.V;
        long j9 = j3 * 1000;
        if (dVar.g) {
            if (j3 != dVar.d) {
                dVar.j++;
                dVar.e = dVar.f;
            }
            long j10 = dVar.j;
            if (j10 >= 6) {
                long j11 = dVar.e + ((j9 - dVar.i) / j10);
                if (dVar.a(j11, j8)) {
                    dVar.g = false;
                    j4 = j8;
                    j5 = j4;
                    j6 = j9;
                } else {
                    j6 = j11;
                    j5 = (dVar.h + j11) - dVar.i;
                    j4 = j8;
                }
            } else {
                j4 = j8;
                if (dVar.a(j9, j4)) {
                    dVar.g = false;
                }
                j5 = j4;
                j6 = j9;
            }
        } else {
            j4 = j8;
            j5 = j4;
            j6 = j9;
        }
        if (!dVar.g) {
            dVar.i = j9;
            dVar.h = j4;
            dVar.j = 0L;
            dVar.g = true;
        }
        dVar.d = j3;
        dVar.f = j6;
        d.a aVar = dVar.a;
        if (aVar != null && aVar.a != 0) {
            long j12 = dVar.a.a;
            long j13 = dVar.f1254b;
            long j14 = j12 + (((j5 - j12) / j13) * j13);
            if (j5 <= j14) {
                j7 = j14 - j13;
            } else {
                j14 = j13 + j14;
                j7 = j14;
            }
            if (j14 - j5 >= j5 - j7) {
                j14 = j7;
            }
            j5 = j14 - dVar.c;
        }
        long j15 = (j5 - jNanoTime) / 1000;
        if (j15 < -30000) {
            s.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            s.a();
            DecoderCounters decoderCounters = this.T;
            decoderCounters.droppedOutputBufferCount++;
            this.h0++;
            int i3 = this.i0 + 1;
            this.i0 = i3;
            decoderCounters.maxConsecutiveDroppedOutputBufferCount = Math.max(i3, decoderCounters.maxConsecutiveDroppedOutputBufferCount);
            if (this.h0 == this.Y) {
                B();
            }
            return true;
        }
        if (u.a >= 21) {
            if (j15 >= 50000) {
                return false;
            }
            a(mediaCodec, i, j5);
            return true;
        }
        if (j15 >= 30000) {
            return false;
        }
        if (j15 > 11000) {
            try {
                Thread.sleep((j15 - 10000) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        a(mediaCodec, i);
        return true;
    }

    public final void a(MediaCodec mediaCodec, int i) {
        D();
        s.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        s.a();
        this.T.renderedOutputBufferCount++;
        this.i0 = 0;
        C();
    }

    public final void a(MediaCodec mediaCodec, int i, long j) {
        D();
        s.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        s.a();
        this.T.renderedOutputBufferCount++;
        this.i0 = 0;
        C();
    }

    public static int a(String str, int i, int i2) {
        int iA;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.getClass();
        str.hashCode();
        int i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iA = i * i2;
                i3 = 2;
                return (iA * 3) / (i3 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iA = i * i2;
                return (iA * 3) / (i3 * 2);
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(u.d)) {
                    return -1;
                }
                iA = u.a(i, 16) * u.a(i2, 16) * 16 * 16;
                i3 = 2;
                return (iA * 3) / (i3 * 2);
            default:
                return -1;
        }
    }

    public static boolean a(boolean z, i iVar, i iVar2) {
        if (!iVar.f.equals(iVar2.f)) {
            return false;
        }
        int i = iVar.m;
        if (i == -1) {
            i = 0;
        }
        int i2 = iVar2.m;
        if (i2 == -1) {
            i2 = 0;
        }
        if (i == i2) {
            return z || (iVar.j == iVar2.j && iVar.k == iVar2.k);
        }
        return false;
    }
}
