package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadc implements zzacm {
    final /* synthetic */ zzadf zza;
    private final long zzb;

    public zzadc(zzadf zzadfVar, long j) {
        this.zza = zzadfVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        zzack zzackVarZza = this.zza.zzg[0].zza(j);
        int i = 1;
        while (true) {
            zzadf zzadfVar = this.zza;
            if (i >= zzadfVar.zzg.length) {
                return zzackVarZza;
            }
            zzack zzackVarZza2 = zzadfVar.zzg[i].zza(j);
            if (zzackVarZza2.zza.zzc < zzackVarZza.zza.zzc) {
                zzackVarZza = zzackVarZza2;
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final boolean zzh() {
        return true;
    }
}
