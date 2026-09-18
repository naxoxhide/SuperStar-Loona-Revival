package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzkj {
    public zzlk zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    private boolean zzg;

    public zzkj(zzlk zzlkVar) {
        this.zza = zzlkVar;
    }

    public final void zza(int i) {
        this.zzg = 1 == ((this.zzg ? 1 : 0) | i);
        this.zzb += i;
    }

    public final void zzb(int i) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i;
    }

    public final void zzc(zzlk zzlkVar) {
        this.zzg |= this.zza != zzlkVar;
        this.zza = zzlkVar;
    }

    public final void zzd(int i) {
        if (this.zzc && this.zzd != 5) {
            zzdx.zzd(i == 5);
            return;
        }
        this.zzg = true;
        this.zzc = true;
        this.zzd = i;
    }
}
