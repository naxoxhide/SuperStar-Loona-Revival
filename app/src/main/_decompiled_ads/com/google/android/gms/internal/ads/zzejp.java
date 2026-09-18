package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzejp implements zzdhf {
    private final Context zza;
    private final zzdpt zzb;
    private final zzfdn zzc;
    private final zzcaz zzd;
    private final zzfcr zze;
    private final ListenableFuture zzf;
    private final zzcgb zzg;
    private final zzbjl zzh;
    private final boolean zzi;
    private final zzedz zzj;

    zzejp(Context context, zzdpt zzdptVar, zzfdn zzfdnVar, zzcaz zzcazVar, zzfcr zzfcrVar, ListenableFuture listenableFuture, zzcgb zzcgbVar, zzbjl zzbjlVar, boolean z, zzedz zzedzVar) {
        this.zza = context;
        this.zzb = zzdptVar;
        this.zzc = zzfdnVar;
        this.zzd = zzcazVar;
        this.zze = zzfcrVar;
        this.zzf = listenableFuture;
        this.zzg = zzcgbVar;
        this.zzh = zzbjlVar;
        this.zzi = z;
        this.zzj = zzedzVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0088  */
    /* JADX WARN: Code duplicated, block: B:19:0x0090  */
    /* JADX WARN: Code duplicated, block: B:22:0x009e  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e9  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdhf
    public final void zza(boolean z, Context context, zzcxy zzcxyVar) {
        zzcgb zzcgbVar;
        zzcgb zzcgbVar2;
        boolean zZze;
        boolean z2;
        boolean zZzd;
        float fZza;
        zzdoy zzdoyVar = (zzdoy) zzfzt.zzq(this.zzf);
        try {
            zzfcr zzfcrVar = this.zze;
            if (this.zzg.zzaB()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaL)).booleanValue()) {
                    final zzcgb zzcgbVarZza = this.zzb.zza(this.zzc.zze, null, null);
                    zzbka.zzb(zzcgbVarZza, zzdoyVar.zzg());
                    final zzdpx zzdpxVar = new zzdpx();
                    zzdpxVar.zza(this.zza, (View) zzcgbVarZza);
                    zzdoyVar.zzl().zzi(zzcgbVarZza, true, this.zzi ? this.zzh : null);
                    zzcgbVarZza.zzN().zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzejn
                        @Override // com.google.android.gms.internal.ads.zzchm
                        public final void zza(boolean z3, int i, String str, String str2) {
                            zzdpxVar.zzb();
                            zzcgb zzcgbVar3 = zzcgbVarZza;
                            zzcgbVar3.zzY();
                            zzcgbVar3.zzN().zzq();
                        }
                    });
                    zzcgbVarZza.zzN().zzG(new zzchn() { // from class: com.google.android.gms.internal.ads.zzejo
                        @Override // com.google.android.gms.internal.ads.zzchn
                        public final void zza() {
                            zzcgbVarZza.zzX();
                        }
                    });
                    zzfcx zzfcxVar = zzfcrVar.zzu;
                    zzcgbVarZza.zzab(zzfcxVar.zzb, zzfcxVar.zza, null);
                    zzcgbVar = zzcgbVarZza;
                } else {
                    zzcgbVar2 = this.zzg;
                }
                zzcgbVar.zzan(true);
                if (this.zzi) {
                    zZze = this.zzh.zze(false);
                } else {
                    zZze = false;
                }
                com.google.android.gms.ads.internal.zzt.zzp();
                Context context2 = this.zza;
                z2 = this.zzi;
                boolean zZzH = com.google.android.gms.ads.internal.util.zzt.zzH(context2);
                if (z2) {
                    zZzd = this.zzh.zzd();
                } else {
                    zZzd = false;
                }
                if (this.zzi) {
                    fZza = this.zzh.zza();
                } else {
                    fZza = 0.0f;
                }
                float f = fZza;
                zzfcr zzfcrVar2 = this.zze;
                com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zZze, zZzH, zZzd, f, -1, z, zzfcrVar2.zzQ, zzfcrVar2.zzR);
                if (zzcxyVar != null) {
                    zzcxyVar.zzf();
                }
                com.google.android.gms.ads.internal.zzt.zzi();
                zzdgu zzdguVarZzh = zzdoyVar.zzh();
                zzfcr zzfcrVar3 = this.zze;
                zzcaz zzcazVar = this.zzd;
                int i = zzfcrVar3.zzS;
                String str = zzfcrVar3.zzD;
                zzfcx zzfcxVar2 = zzfcrVar3.zzu;
                com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdguVarZzh, (com.google.android.gms.ads.internal.overlay.zzz) null, zzcgbVar, i, zzcazVar, str, zzjVar, zzfcxVar2.zzb, zzfcxVar2.zza, this.zzc.zzf, zzcxyVar, zzfcrVar3.zzak ? this.zzj : null), true);
            }
            zzcgbVar2 = this.zzg;
            zzcgbVar = zzcgbVar2;
            zzcgbVar.zzan(true);
            if (this.zzi) {
                zZze = this.zzh.zze(false);
            } else {
                zZze = false;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            Context context3 = this.zza;
            z2 = this.zzi;
            boolean zZzH2 = com.google.android.gms.ads.internal.util.zzt.zzH(context3);
            if (z2) {
                zZzd = this.zzh.zzd();
            } else {
                zZzd = false;
            }
            if (this.zzi) {
                fZza = this.zzh.zza();
            } else {
                fZza = 0.0f;
            }
            float f2 = fZza;
            zzfcr zzfcrVar4 = this.zze;
            com.google.android.gms.ads.internal.zzj zzjVar2 = new com.google.android.gms.ads.internal.zzj(zZze, zZzH2, zZzd, f2, -1, z, zzfcrVar4.zzQ, zzfcrVar4.zzR);
            if (zzcxyVar != null) {
                zzcxyVar.zzf();
            }
            com.google.android.gms.ads.internal.zzt.zzi();
            zzdgu zzdguVarZzh2 = zzdoyVar.zzh();
            zzfcr zzfcrVar5 = this.zze;
            zzcaz zzcazVar2 = this.zzd;
            int i2 = zzfcrVar5.zzS;
            String str2 = zzfcrVar5.zzD;
            zzfcx zzfcxVar3 = zzfcrVar5.zzu;
            if (zzfcrVar5.zzak) {
            }
            com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdguVarZzh2, (com.google.android.gms.ads.internal.overlay.zzz) null, zzcgbVar, i2, zzcazVar2, str2, zzjVar2, zzfcxVar3.zzb, zzfcxVar3.zza, this.zzc.zzf, zzcxyVar, zzfcrVar5.zzak ? this.zzj : null), true);
        } catch (zzcgm e) {
            zzcat.zzh("", e);
        }
    }
}
