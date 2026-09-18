package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzala {
    public final int zza;
    public final long zzb;

    private zzala(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzala zza(zzabn zzabnVar, zzfb zzfbVar) throws IOException {
        ((zzabc) zzabnVar).zzm(zzfbVar.zzI(), 0, 8, false);
        zzfbVar.zzG(0);
        return new zzala(zzfbVar.zzf(), zzfbVar.zzr());
    }
}
