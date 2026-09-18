package com.applovin.exoplayer2.f;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.applovin.exoplayer2.v;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public final String Hr;
    public final MediaCodecInfo.CodecCapabilities Hs;
    public final boolean Ht;
    public final boolean Hu;
    public final boolean Hv;
    public final boolean Hw;
    public final boolean Hx;
    private final boolean Hy;
    public final String eg;
    public final boolean hi;
    public final String name;

    public static i a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new i(str, str2, str3, codecCapabilities, z, z2, z3, (z4 || codecCapabilities == null || !a(codecCapabilities) || M(str)) ? false : true, codecCapabilities != null && c(codecCapabilities), z5 || (codecCapabilities != null && e(codecCapabilities)));
    }

    i(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.name = (String) com.applovin.exoplayer2.l.a.checkNotNull(str);
        this.eg = str2;
        this.Hr = str3;
        this.Hs = codecCapabilities;
        this.Hv = z;
        this.Hw = z2;
        this.Hx = z3;
        this.Ht = z4;
        this.hi = z5;
        this.Hu = z6;
        this.Hy = u.aX(str2);
    }

    public String toString() {
        return this.name;
    }

    public MediaCodecInfo.CodecProfileLevel[] jV() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.Hs.profileLevels;
    }

    public boolean l(v vVar) throws l.b {
        if (!m(vVar)) {
            return false;
        }
        if (this.Hy) {
            if (vVar.dE <= 0 || vVar.height <= 0) {
                return true;
            }
            if (ai.acV >= 21) {
                return a(vVar.dE, vVar.height, vVar.dF);
            }
            boolean z = vVar.dE * vVar.height <= l.kz();
            if (!z) {
                K("legacyFrameSize, " + vVar.dE + "x" + vVar.height);
            }
            return z;
        }
        if (ai.acV >= 21) {
            if (vVar.dM != -1 && !cS(vVar.dM)) {
                return false;
            }
            if (vVar.dL != -1 && !cT(vVar.dL)) {
                return false;
            }
        }
        return true;
    }

    public boolean m(v vVar) {
        String strAZ;
        if (vVar.dw == null || this.eg == null || (strAZ = u.aZ(vVar.dw)) == null) {
            return true;
        }
        if (!this.eg.equals(strAZ)) {
            K("codec.mime " + vVar.dw + ", " + strAZ);
            return false;
        }
        Pair<Integer, Integer> pairR = l.r(vVar);
        if (pairR == null) {
            return true;
        }
        int iIntValue = ((Integer) pairR.first).intValue();
        int iIntValue2 = ((Integer) pairR.second).intValue();
        if (!this.Hy && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrJV = jV();
        if (ai.acV <= 23 && "video/x-vnd.on2.vp9".equals(this.eg) && codecProfileLevelArrJV.length == 0) {
            codecProfileLevelArrJV = g(this.Hs);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrJV) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2) {
                return true;
            }
        }
        K("codec.profileLevel, " + vVar.dw + ", " + strAZ);
        return false;
    }

    public boolean jW() {
        if (ai.acV >= 29 && "video/x-vnd.on2.vp9".equals(this.eg)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : jV()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean n(v vVar) {
        if (this.Hy) {
            return this.Ht;
        }
        Pair<Integer, Integer> pairR = l.r(vVar);
        return pairR != null && ((Integer) pairR.first).intValue() == 42;
    }

    public com.applovin.exoplayer2.c.h a(v vVar, v vVar2) {
        int i = !ai.r(vVar.dz, vVar2.dz) ? 8 : 0;
        if (this.Hy) {
            if (vVar.dG != vVar2.dG) {
                i |= 1024;
            }
            if (!this.Ht && (vVar.dE != vVar2.dE || vVar.height != vVar2.height)) {
                i |= 512;
            }
            if (!ai.r(vVar.dK, vVar2.dK)) {
                i |= 2048;
            }
            if (N(this.name) && !vVar.a(vVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new com.applovin.exoplayer2.c.h(this.name, vVar, vVar2, vVar.a(vVar2) ? 3 : 2, 0);
            }
        } else {
            if (vVar.dL != vVar2.dL) {
                i |= 4096;
            }
            if (vVar.dM != vVar2.dM) {
                i |= 8192;
            }
            if (vVar.dN != vVar2.dN) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.eg)) {
                Pair<Integer, Integer> pairR = l.r(vVar);
                Pair<Integer, Integer> pairR2 = l.r(vVar2);
                if (pairR != null && pairR2 != null) {
                    int iIntValue = ((Integer) pairR.first).intValue();
                    int iIntValue2 = ((Integer) pairR2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new com.applovin.exoplayer2.c.h(this.name, vVar, vVar2, 3, 0);
                    }
                }
            }
            if (!vVar.a(vVar2)) {
                i |= 32;
            }
            if (O(this.eg)) {
                i |= 2;
            }
            if (i == 0) {
                return new com.applovin.exoplayer2.c.h(this.name, vVar, vVar2, 1, 0);
            }
        }
        return new com.applovin.exoplayer2.c.h(this.name, vVar, vVar2, 0, i);
    }

    public boolean a(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null) {
            K("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            K("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i >= i2 || !P(this.name) || !a(videoCapabilities, i2, i, d)) {
            K("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
            return false;
        }
        L("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
        return true;
    }

    public Point D(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return a(videoCapabilities, i, i2);
    }

    public boolean cS(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null) {
            K("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            K("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        K("sampleRate.support, " + i);
        return false;
    }

    public boolean cT(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Hs;
        if (codecCapabilities == null) {
            K("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            K("channelCount.aCaps");
            return false;
        }
        if (a(this.name, this.eg, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        }
        K("channelCount.support, " + i);
        return false;
    }

    private void K(String str) {
        q.f("MediaCodecInfo", "NoSupport [" + str + "] [" + this.name + ", " + this.eg + "] [" + ai.acZ + "]");
    }

    private void L(String str) {
        q.f("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.name + ", " + this.eg + "] [" + ai.acZ + "]");
    }

    private static int a(String str, String str2, int i) {
        int i2;
        if (i > 1 || ((ai.acV >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        if ("audio/ac3".equals(str2)) {
            i2 = 6;
        } else {
            i2 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        q.h("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ai.acV >= 19 && b(codecCapabilities);
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ai.acV >= 21 && d(codecCapabilities);
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return ai.acV >= 21 && f(codecCapabilities);
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointA = a(videoCapabilities, i, i2);
        int i3 = pointA.x;
        int i4 = pointA.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    private static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(ai.N(i, widthAlignment) * widthAlignment, ai.N(i2, heightAlignment) * heightAlignment);
    }

    private static MediaCodecInfo.CodecProfileLevel[] g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int i;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        if (iIntValue >= 180000000) {
            i = 1024;
        } else if (iIntValue >= 120000000) {
            i = 512;
        } else if (iIntValue >= 60000000) {
            i = 256;
        } else if (iIntValue >= 30000000) {
            i = 128;
        } else if (iIntValue >= 18000000) {
            i = 64;
        } else if (iIntValue >= 12000000) {
            i = 32;
        } else if (iIntValue >= 7200000) {
            i = 16;
        } else if (iIntValue >= 3600000) {
            i = 8;
        } else if (iIntValue >= 1800000) {
            i = 4;
        } else {
            i = iIntValue >= 800000 ? 2 : 1;
        }
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    private static boolean M(String str) {
        return ai.acV <= 22 && ("ODROID-XU3".equals(ai.acY) || "Nexus 10".equals(ai.acY)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }

    private static boolean N(String str) {
        return ai.acY.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean O(String str) {
        return "audio/opus".equals(str);
    }

    private static final boolean P(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(ai.acW)) ? false : true;
    }
}
