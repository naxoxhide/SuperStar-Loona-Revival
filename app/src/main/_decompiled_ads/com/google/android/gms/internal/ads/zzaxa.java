package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaxa implements zzavp {
    final /* synthetic */ zzaxd zza;

    zzaxa(zzaxd zzaxdVar) {
        this.zza = zzaxdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zza(boolean z) {
        if (z) {
            this.zza.zzl();
        } else {
            zzaxd.zzh(this.zza);
        }
    }
}
