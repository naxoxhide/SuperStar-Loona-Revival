package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaia implements zzacm {
    final /* synthetic */ zzaib zza;

    /* synthetic */ zzaia(zzaib zzaibVar, zzahz zzahzVar) {
        this.zza = zzaibVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        zzaib zzaibVar = this.zza;
        return zzaibVar.zzd.zzf(zzaibVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        zzaib zzaibVar = this.zza;
        long jZzg = zzaibVar.zzd.zzg(j);
        long j2 = zzaibVar.zzb;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(jZzg);
        zzaib zzaibVar2 = this.zza;
        long jLongValue = j2 + bigIntegerValueOf.multiply(BigInteger.valueOf(zzaibVar2.zzc - zzaibVar2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzaib zzaibVar3 = this.zza;
        zzacn zzacnVar = new zzacn(j, Math.max(zzaibVar3.zzb, Math.min(jLongValue - 30000, zzaibVar3.zzc - 1)));
        return new zzack(zzacnVar, zzacnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return true;
    }
}
