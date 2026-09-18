package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzoe {
    final /* synthetic */ zzof zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zztw zze;
    private boolean zzf;
    private boolean zzg;

    public zzoe(zzof zzofVar, String str, int i, zztw zztwVar) {
        this.zza = zzofVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zztwVar == null ? -1L : zztwVar.zzd;
        if (zztwVar == null || !zztwVar.zzb()) {
            return;
        }
        this.zze = zztwVar;
    }

    public final void zzg(int i, zztw zztwVar) {
        if (this.zzd == -1 && i == this.zzc && zztwVar != null) {
            zzof zzofVar = this.zza;
            long j = zztwVar.zzd;
            if (j >= zzofVar.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zztw zztwVar) {
        if (zztwVar == null) {
            return i == this.zzc;
        }
        zztw zztwVar2 = this.zze;
        if (zztwVar2 == null) {
            return !zztwVar.zzb() && zztwVar.zzd == this.zzd;
        }
        return zztwVar.zzd == zztwVar2.zzd && zztwVar.zzb == zztwVar2.zzb && zztwVar.zzc == zztwVar2.zzc;
    }

    public final boolean zzk(zzmc zzmcVar) {
        zztw zztwVar = zzmcVar.zzd;
        if (zztwVar == null) {
            return this.zzc != zzmcVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        if (zztwVar.zzd > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzcv zzcvVar = zzmcVar.zzb;
        int iZza = zzcvVar.zza(zztwVar.zza);
        int iZza2 = zzcvVar.zza(this.zze.zza);
        zztw zztwVar2 = zzmcVar.zzd;
        if (zztwVar2.zzd < this.zze.zzd || iZza < iZza2) {
            return false;
        }
        if (iZza > iZza2) {
            return true;
        }
        if (!zztwVar2.zzb()) {
            int i = zzmcVar.zzd.zze;
            return i == -1 || i > this.zze.zzb;
        }
        zztw zztwVar3 = zzmcVar.zzd;
        int i2 = zztwVar3.zzb;
        int i3 = zztwVar3.zzc;
        zztw zztwVar4 = this.zze;
        int i4 = zztwVar4.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zztwVar4.zzc;
        }
        return true;
    }

    public final boolean zzl(zzcv zzcvVar, zzcv zzcvVar2) {
        int i = this.zzc;
        if (i < zzcvVar.zzc()) {
            zzcvVar.zze(i, this.zza.zzc, 0L);
            int i2 = this.zza.zzc.zzp;
            while (true) {
                if (i2 > this.zza.zzc.zzq) {
                    i = -1;
                    break;
                }
                int iZza = zzcvVar2.zza(zzcvVar.zzf(i2));
                if (iZza != -1) {
                    i = zzcvVar2.zzd(iZza, this.zza.zzd, false).zzd;
                    break;
                }
                i2++;
            }
        } else if (i >= zzcvVar2.zzc()) {
            i = -1;
            break;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zztw zztwVar = this.zze;
        return zztwVar == null || zzcvVar2.zza(zztwVar.zza) != -1;
    }
}
