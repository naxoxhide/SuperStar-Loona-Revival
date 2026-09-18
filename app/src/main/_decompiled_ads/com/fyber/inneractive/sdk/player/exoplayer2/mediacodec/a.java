package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1158b;
    public final boolean c;
    public final String d;
    public final MediaCodecInfo.CodecCapabilities e;

    public a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z) {
        this.a = (String) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(str);
        this.d = str2;
        this.e = codecCapabilities;
        this.f1158b = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.c = codecCapabilities != null && b(codecCapabilities);
    }

    public static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public boolean a(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.e;
        if (codecCapabilities == null) {
            a("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
            a("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
            return false;
        }
        Log.d("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d) + "] [" + this.a + ", " + this.d + "] [" + u.e + "]");
        return true;
    }

    public final void a(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.a + ", " + this.d + "] [" + u.e + "]");
    }

    public static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d != -1.0d && d > 0.0d) {
            return videoCapabilities.areSizeAndRateSupported(i, i2, d);
        }
        return videoCapabilities.isSizeSupported(i, i2);
    }
}
