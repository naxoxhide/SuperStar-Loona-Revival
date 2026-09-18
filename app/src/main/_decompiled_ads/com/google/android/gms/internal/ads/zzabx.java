package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabx implements zzacm {
    private final zzabz zza;
    private final long zzb;

    public zzabx(zzabz zzabzVar, long j) {
        this.zza = zzabzVar;
        this.zzb = j;
    }

    private final zzacn zzb(long j, long j2) {
        return new zzacn((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        zzdx.zzb(this.zza.zzk);
        zzabz zzabzVar = this.zza;
        zzaby zzabyVar = zzabzVar.zzk;
        long[] jArr = zzabyVar.zza;
        long[] jArr2 = zzabyVar.zzb;
        int iZzc = zzfk.zzc(jArr, zzabzVar.zzb(j), true, false);
        zzacn zzacnVarZzb = zzb(iZzc == -1 ? 0L : jArr[iZzc], iZzc != -1 ? jArr2[iZzc] : 0L);
        if (zzacnVarZzb.zzb == j || iZzc == jArr.length - 1) {
            return new zzack(zzacnVarZzb, zzacnVarZzb);
        }
        int i = iZzc + 1;
        return new zzack(zzacnVarZzb, zzb(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return true;
    }
}
