package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import com.applovin.exoplayer2.l.ai;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.applovin.exoplayer2.c.f {
    public final i Hk;
    public final String Hq;

    public h(Throwable th, i iVar) {
        super("Decoder failed: " + (iVar == null ? null : iVar.name), th);
        this.Hk = iVar;
        this.Hq = ai.acV >= 21 ? g(th) : null;
    }

    private static String g(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
