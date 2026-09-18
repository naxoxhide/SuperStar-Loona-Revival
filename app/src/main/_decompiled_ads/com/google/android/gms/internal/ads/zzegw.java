package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegw implements zzdhf {
    private final Context zza;
    private final zzcaz zzb;
    private final ListenableFuture zzc;
    private final zzfcr zzd;
    private final zzcgb zze;
    private final zzfdn zzf;
    private final zzbjl zzg;
    private final boolean zzh;
    private final zzedz zzi;

    zzegw(Context context, zzcaz zzcazVar, ListenableFuture listenableFuture, zzfcr zzfcrVar, zzcgb zzcgbVar, zzfdn zzfdnVar, boolean z, zzbjl zzbjlVar, zzedz zzedzVar) {
        this.zza = context;
        this.zzb = zzcazVar;
        this.zzc = listenableFuture;
        this.zzd = zzfcrVar;
        this.zze = zzcgbVar;
        this.zzf = zzfdnVar;
        this.zzg = zzbjlVar;
        this.zzh = z;
        this.zzi = zzedzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhf
    public final void zza(boolean z, Context context, zzcxy zzcxyVar) {
        zzdfx zzdfxVar = (zzdfx) zzfzt.zzq(this.zzc);
        this.zze.zzan(true);
        boolean zZze = this.zzh ? this.zzg.zze(false) : false;
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zZze, com.google.android.gms.ads.internal.util.zzt.zzH(this.zza), this.zzh ? this.zzg.zzd() : false, this.zzh ? this.zzg.zza() : 0.0f, -1, z, this.zzd.zzQ, false);
        if (zzcxyVar != null) {
            zzcxyVar.zzf();
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        zzdgu zzdguVarZzh = zzdfxVar.zzh();
        zzcgb zzcgbVar = this.zze;
        zzfcr zzfcrVar = this.zzd;
        zzcaz zzcazVar = this.zzb;
        int i = zzfcrVar.zzS;
        String str = zzfcrVar.zzD;
        zzfcx zzfcxVar = zzfcrVar.zzu;
        com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdguVarZzh, (com.google.android.gms.ads.internal.overlay.zzz) null, zzcgbVar, i, zzcazVar, str, zzjVar, zzfcxVar.zzb, zzfcxVar.zza, this.zzf.zzf, zzcxyVar, zzfcrVar.zzak ? this.zzi : null), true);
    }
}
