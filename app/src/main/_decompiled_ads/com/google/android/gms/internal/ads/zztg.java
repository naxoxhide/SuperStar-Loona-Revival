package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztg implements zzvq {
    protected final zzvq[] zza;

    public zztg(zzvq[] zzvqVarArr) {
        this.zza = zzvqVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzvq
    public final long zzb() {
        long jMin = Long.MAX_VALUE;
        for (zzvq zzvqVar : this.zza) {
            long jZzb = zzvqVar.zzb();
            if (jZzb != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzb);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzvq
    public final long zzc() {
        long jMin = Long.MAX_VALUE;
        for (zzvq zzvqVar : this.zza) {
            long jZzc = zzvqVar.zzc();
            if (jZzc != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzc);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzvq
    public final void zzm(long j) {
        for (zzvq zzvqVar : this.zza) {
            zzvqVar.zzm(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvq
    public final boolean zzo(zzks zzksVar) {
        boolean zZzo;
        boolean z = false;
        do {
            long jZzc = zzc();
            long j = Long.MIN_VALUE;
            if (jZzc == Long.MIN_VALUE) {
                break;
            }
            zzvq[] zzvqVarArr = this.zza;
            int length = zzvqVarArr.length;
            int i = 0;
            zZzo = false;
            while (i < length) {
                zzvq zzvqVar = zzvqVarArr[i];
                long jZzc2 = zzvqVar.zzc();
                boolean z2 = jZzc2 != j && jZzc2 <= zzksVar.zza;
                if (jZzc2 == jZzc || z2) {
                    zZzo |= zzvqVar.zzo(zzksVar);
                }
                i++;
                j = Long.MIN_VALUE;
            }
            z |= zZzo;
        } while (zZzo);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzvq
    public final boolean zzp() {
        for (zzvq zzvqVar : this.zza) {
            if (zzvqVar.zzp()) {
                return true;
            }
        }
        return false;
    }
}
