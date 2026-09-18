package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpy {
    private final zzdq[] zza;
    private final zzqq zzb;
    private final zzdt zzc;

    public zzpy(zzdq... zzdqVarArr) {
        zzqq zzqqVar = new zzqq();
        zzdt zzdtVar = new zzdt();
        zzdq[] zzdqVarArr2 = {zzqqVar, zzdtVar};
        this.zza = zzdqVarArr2;
        System.arraycopy(zzdqVarArr, 0, zzdqVarArr2, 0, 0);
        this.zzb = zzqqVar;
        this.zzc = zzdtVar;
    }

    public final long zza(long j) {
        return this.zzc.zzi(j);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzcg zzc(zzcg zzcgVar) {
        this.zzc.zzk(zzcgVar.zzc);
        this.zzc.zzj(zzcgVar.zzd);
        return zzcgVar;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzdq[] zze() {
        return this.zza;
    }
}
