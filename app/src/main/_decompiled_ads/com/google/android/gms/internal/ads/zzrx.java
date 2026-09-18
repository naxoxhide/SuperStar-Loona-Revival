package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzrx extends zzhr {
    public final zzrz zza;
    public final String zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzrx(Throwable th, zzrz zzrzVar) {
        super("Decoder failed: ".concat(String.valueOf(zzrzVar == null ? null : zzrzVar.zza)), th);
        String diagnosticInfo = null;
        this.zza = zzrzVar;
        if (zzfk.zza >= 21 && (th instanceof MediaCodec.CodecException)) {
            diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.zzb = diagnosticInfo;
    }
}
