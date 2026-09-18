package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzekr implements zzeeu {
    private final zzbdg zza;
    private final zzgad zzb;
    private final zzfhr zzc;
    private final zzela zzd;

    public zzekr(zzfhr zzfhrVar, zzgad zzgadVar, zzbdg zzbdgVar, zzela zzelaVar) {
        this.zzc = zzfhrVar;
        this.zzb = zzgadVar;
        this.zza = zzbdgVar;
        this.zzd = zzelaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzcbl zzcblVar = new zzcbl();
        zzekw zzekwVar = new zzekw();
        zzekwVar.zzd(new zzekq(this, zzcblVar, zzfdeVar, zzfcrVar, zzekwVar));
        zzfcx zzfcxVar = zzfcrVar.zzu;
        final zzbdb zzbdbVar = new zzbdb(zzekwVar, zzfcxVar.zzb, zzfcxVar.zza);
        zzfhl zzfhlVar = zzfhl.CUSTOM_RENDER_SYN;
        return zzfhb.zzd(new zzfgv() { // from class: com.google.android.gms.internal.ads.zzekp
            @Override // com.google.android.gms.internal.ads.zzfgv
            public final void zza() throws Exception {
                this.zza.zzc(zzbdbVar);
            }
        }, this.zzb, zzfhlVar, this.zzc).zzb(zzfhl.CUSTOM_RENDER_ACK).zzd(zzcblVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzfcx zzfcxVar;
        return (this.zza == null || (zzfcxVar = zzfcrVar.zzu) == null || zzfcxVar.zza == null) ? false : true;
    }

    final /* synthetic */ void zzc(zzbdb zzbdbVar) throws Exception {
        this.zza.zze(zzbdbVar);
    }
}
