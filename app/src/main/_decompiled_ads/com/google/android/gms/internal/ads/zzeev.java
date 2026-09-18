package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeev implements zzeeu {
    public final zzeeu zza;
    private final zzfsk zzb;

    public zzeev(zzeeu zzeeuVar, zzfsk zzfskVar) {
        this.zza = zzeeuVar;
        this.zzb = zzfskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(zzfde zzfdeVar, zzfcr zzfcrVar) {
        return zzfzt.zzm(this.zza.zza(zzfdeVar, zzfcrVar), this.zzb, zzcbg.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        return this.zza.zzb(zzfdeVar, zzfcrVar);
    }
}
