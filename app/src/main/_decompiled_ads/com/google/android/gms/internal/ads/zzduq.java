package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzduq extends zzblj {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfit zzd;
    final /* synthetic */ zzcbl zze;
    final /* synthetic */ zzdur zzf;

    zzduq(zzdur zzdurVar, Object obj, String str, long j, zzfit zzfitVar, zzcbl zzcblVar) {
        this.zzf = zzdurVar;
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfitVar;
        this.zze = zzcblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, "error");
            this.zzf.zzo.zzb(this.zzb, "error");
            zzfjh zzfjhVar = this.zzf.zzp;
            zzfit zzfitVar = this.zzd;
            zzfitVar.zzc(str);
            zzfitVar.zzf(false);
            zzfjhVar.zzb(zzfitVar.zzl());
            this.zze.zzc(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfjh zzfjhVar = this.zzf.zzp;
            zzfit zzfitVar = this.zzd;
            zzfitVar.zzf(true);
            zzfjhVar.zzb(zzfitVar.zzl());
            this.zze.zzc(true);
        }
    }
}
