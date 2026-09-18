package com.fyber.inneractive.sdk.player.exoplayer2.decoder;

import android.media.MediaCodec;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f1050b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public final MediaCodec.CryptoInfo g;
    public final b h;

    public static final class b {
        public final MediaCodec.CryptoInfo a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f1051b;

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.f1051b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public a() {
        int i = u.a;
        byte b2 = 0;
        MediaCodec.CryptoInfo cryptoInfoA = i >= 16 ? a() : null;
        this.g = cryptoInfoA;
        this.h = i >= 24 ? new b(cryptoInfoA) : null;
    }

    public final MediaCodec.CryptoInfo a() {
        return new MediaCodec.CryptoInfo();
    }
}
