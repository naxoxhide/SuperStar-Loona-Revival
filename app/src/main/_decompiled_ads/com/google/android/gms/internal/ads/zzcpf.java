package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcpf implements zzfzp {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcpg zzb;

    zzcpf(zzcpg zzcpgVar, String str) {
        this.zzb = zzcpgVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        zzcpg zzcpgVar = this.zzb;
        zzcpgVar.zzh.zza(zzcpgVar.zzg.zzd(zzcpgVar.zze, zzcpgVar.zzf, false, this.zza, null, zzcpgVar.zzf.zzd));
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpg zzcpgVar = this.zzb;
        String str = (String) obj;
        zzcpgVar.zzh.zza(zzcpgVar.zzg.zzd(zzcpgVar.zze, zzcpgVar.zzf, false, this.zza, str, zzcpgVar.zzf.zzd));
    }
}
