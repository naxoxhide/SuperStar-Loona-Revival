package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdri implements zzdag, zzcyz, zzcxo, zzcyf, com.google.android.gms.ads.internal.client.zza, zzdcs {
    private final zzaxv zza;
    private boolean zzb = false;

    public zzdri(zzaxv zzaxvVar, @Nullable zzfam zzfamVar) {
        this.zza = zzaxvVar;
        zzaxvVar.zzc(2);
        if (zzfamVar != null) {
            zzaxvVar.zzc(1101);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        if (this.zzb) {
            this.zza.zzc(8);
        } else {
            this.zza.zzc(7);
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzbF(com.google.android.gms.ads.internal.client.zze zzeVar) {
        switch (zzeVar.zza) {
            case 1:
                this.zza.zzc(101);
                break;
            case 2:
                this.zza.zzc(102);
                break;
            case 3:
                this.zza.zzc(5);
                break;
            case 4:
                this.zza.zzc(103);
                break;
            case 5:
                this.zza.zzc(104);
                break;
            case 6:
                this.zza.zzc(105);
                break;
            case 7:
                this.zza.zzc(106);
                break;
            default:
                this.zza.zzc(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbr(zzbvg zzbvgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbs(final zzfde zzfdeVar) {
        this.zza.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzdre
            @Override // com.google.android.gms.internal.ads.zzaxu
            public final void zza(zzazk zzazkVar) {
                zzayg zzaygVar = (zzayg) zzazkVar.zza().zzaB();
                zzayy zzayyVar = (zzayy) zzazkVar.zza().zzd().zzaB();
                zzayyVar.zza(zzfdeVar.zzb.zzb.zzb);
                zzaygVar.zzb(zzayyVar);
                zzazkVar.zze(zzaygVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcs
    public final void zzh() {
        this.zza.zzc(1109);
    }

    @Override // com.google.android.gms.internal.ads.zzdcs
    public final void zzi(final zzayq zzayqVar) {
        this.zza.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzdrh
            @Override // com.google.android.gms.internal.ads.zzaxu
            public final void zza(zzazk zzazkVar) {
                zzazkVar.zzf(zzayqVar);
            }
        });
        this.zza.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdcs
    public final void zzj(final zzayq zzayqVar) {
        this.zza.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzdrf
            @Override // com.google.android.gms.internal.ads.zzaxu
            public final void zza(zzazk zzazkVar) {
                zzazkVar.zzf(zzayqVar);
            }
        });
        this.zza.zzc(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdcs
    public final void zzl(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdcs
    public final void zzm(final zzayq zzayqVar) {
        this.zza.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzdrg
            @Override // com.google.android.gms.internal.ads.zzaxu
            public final void zza(zzazk zzazkVar) {
                zzazkVar.zzf(zzayqVar);
            }
        });
        this.zza.zzc(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdcs
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzcyf
    public final synchronized void zzq() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzcyz
    public final void zzr() {
        this.zza.zzc(3);
    }
}
