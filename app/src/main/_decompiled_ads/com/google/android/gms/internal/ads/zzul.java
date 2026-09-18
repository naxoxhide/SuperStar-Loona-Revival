package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzul implements zzvo {
    private final zzvo zza;
    private final long zzb;

    public zzul(zzvo zzvoVar, long j) {
        this.zza = zzvoVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final int zza(zzkn zzknVar, zzht zzhtVar, int i) {
        int iZza = this.zza.zza(zzknVar, zzhtVar, i);
        if (iZza != -4) {
            return iZza;
        }
        zzhtVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzvo zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvo
    public final boolean zze() {
        return this.zza.zze();
    }
}
