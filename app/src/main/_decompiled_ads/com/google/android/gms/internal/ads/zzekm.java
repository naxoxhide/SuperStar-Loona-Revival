package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzekm implements zzeeu {
    private final Context zza;
    private final zzcrs zzb;
    private final zzbdg zzc;
    private final zzgad zzd;
    private final zzfhr zze;

    public zzekm(Context context, zzcrs zzcrsVar, zzfhr zzfhrVar, zzgad zzgadVar, zzbdg zzbdgVar) {
        this.zza = context;
        this.zzb = zzcrsVar;
        this.zze = zzfhrVar;
        this.zzd = zzgadVar;
        this.zzc = zzbdgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzekk zzekkVar = new zzekk(this, new View(this.zza), null, new zzcsv() { // from class: com.google.android.gms.internal.ads.zzeki
            @Override // com.google.android.gms.internal.ads.zzcsv
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return null;
            }
        }, (zzfcs) zzfcrVar.zzw.get(0));
        zzcqw zzcqwVarZza = this.zzb.zza(new zzctm(zzfdeVar, zzfcrVar, null), zzekkVar);
        zzekl zzeklVarZzk = zzcqwVarZza.zzk();
        zzfcx zzfcxVar = zzfcrVar.zzu;
        final zzbdb zzbdbVar = new zzbdb(zzeklVarZzk, zzfcxVar.zzb, zzfcxVar.zza);
        zzfhl zzfhlVar = zzfhl.CUSTOM_RENDER_SYN;
        return zzfhb.zzd(new zzfgv() { // from class: com.google.android.gms.internal.ads.zzekj
            @Override // com.google.android.gms.internal.ads.zzfgv
            public final void zza() throws Exception {
                this.zza.zzc(zzbdbVar);
            }
        }, this.zzd, zzfhlVar, this.zze).zzb(zzfhl.CUSTOM_RENDER_ACK).zzd(zzfzt.zzh(zzcqwVarZza.zza())).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzfcx zzfcxVar;
        return (this.zzc == null || (zzfcxVar = zzfcrVar.zzu) == null || zzfcxVar.zza == null) ? false : true;
    }

    final /* synthetic */ void zzc(zzbdb zzbdbVar) throws Exception {
        this.zzc.zze(zzbdbVar);
    }
}
