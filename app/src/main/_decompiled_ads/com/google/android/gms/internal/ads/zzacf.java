package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacf implements zzacm {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzacf(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzdx.zzd(length == length2);
        boolean z = length2 > 0;
        this.zzd = z;
        if (!z || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i = length2 + 1;
            long[] jArr3 = new long[i];
            this.zza = jArr3;
            long[] jArr4 = new long[i];
            this.zzb = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        }
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        if (!this.zzd) {
            zzacn zzacnVar = zzacn.zza;
            return new zzack(zzacnVar, zzacnVar);
        }
        int iZzc = zzfk.zzc(this.zzb, j, true, true);
        zzacn zzacnVar2 = new zzacn(this.zzb[iZzc], this.zza[iZzc]);
        if (zzacnVar2.zzb != j) {
            long[] jArr = this.zzb;
            if (iZzc != jArr.length - 1) {
                int i = iZzc + 1;
                return new zzack(zzacnVar2, new zzacn(jArr[i], this.zza[i]));
            }
        }
        return new zzack(zzacnVar2, zzacnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return this.zzd;
    }
}
