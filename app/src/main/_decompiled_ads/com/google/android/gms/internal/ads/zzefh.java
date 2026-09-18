package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzefh implements zzdhf {
    private final zzcaz zza;
    private final ListenableFuture zzb;
    private final zzfcr zzc;
    private final zzcgb zzd;
    private final zzfdn zze;
    private final zzbjl zzf;
    private final boolean zzg;
    private final zzedz zzh;

    zzefh(zzcaz zzcazVar, ListenableFuture listenableFuture, zzfcr zzfcrVar, zzcgb zzcgbVar, zzfdn zzfdnVar, boolean z, zzbjl zzbjlVar, zzedz zzedzVar) {
        this.zza = zzcazVar;
        this.zzb = listenableFuture;
        this.zzc = zzfcrVar;
        this.zzd = zzcgbVar;
        this.zze = zzfdnVar;
        this.zzg = z;
        this.zzf = zzbjlVar;
        this.zzh = zzedzVar;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006e  */
    @Override // com.google.android.gms.internal.ads.zzdhf
    public final void zza(boolean z, Context context, zzcxy zzcxyVar) {
        zzcqg zzcqgVar = (zzcqg) zzfzt.zzq(this.zzb);
        this.zzd.zzan(true);
        boolean zZze = this.zzg ? this.zzf.zze(true) : true;
        boolean z2 = this.zzg;
        com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zZze, true, z2 ? this.zzf.zzd() : false, z2 ? this.zzf.zza() : 0.0f, -1, z, this.zzc.zzQ, false);
        if (zzcxyVar != null) {
            zzcxyVar.zzf();
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        zzdgu zzdguVarZzg = zzcqgVar.zzg();
        zzcgb zzcgbVar = this.zzd;
        int i = this.zzc.zzS;
        if (i == -1) {
            com.google.android.gms.ads.internal.client.zzw zzwVar = this.zze.zzj;
            if (zzwVar == null) {
                zzcat.zze("Error setting app open orientation; no targeting orientation available.");
                i = this.zzc.zzS;
            } else {
                int i2 = zzwVar.zza;
                if (i2 == 1) {
                    i = 7;
                } else if (i2 == 2) {
                    i = 6;
                } else {
                    zzcat.zze("Error setting app open orientation; no targeting orientation available.");
                    i = this.zzc.zzS;
                }
            }
        }
        int i3 = i;
        zzcaz zzcazVar = this.zza;
        zzfcr zzfcrVar = this.zzc;
        String str = zzfcrVar.zzD;
        zzfcx zzfcxVar = zzfcrVar.zzu;
        com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdguVarZzg, (com.google.android.gms.ads.internal.overlay.zzz) null, zzcgbVar, i3, zzcazVar, str, zzjVar, zzfcxVar.zzb, zzfcxVar.zza, this.zze.zzf, zzcxyVar, zzfcrVar.zzak ? this.zzh : null), true);
    }
}
