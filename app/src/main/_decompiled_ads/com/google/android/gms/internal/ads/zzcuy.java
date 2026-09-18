package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcuy implements com.google.android.gms.ads.internal.client.zza {
    private final zzcvc zza;
    private final zzfdn zzb;

    zzcuy(zzcvc zzcvcVar, zzfdn zzfdnVar) {
        this.zza = zzcvcVar;
        this.zzb = zzfdnVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
