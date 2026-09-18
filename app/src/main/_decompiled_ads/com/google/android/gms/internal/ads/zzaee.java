package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaee extends zzacb {
    final /* synthetic */ zzacm zza;
    final /* synthetic */ zzaef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaee(zzaef zzaefVar, zzacm zzacmVar, zzacm zzacmVar2) {
        super(zzacmVar);
        this.zzb = zzaefVar;
        this.zza = zzacmVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzacb, com.google.android.gms.internal.ads.zzacm
    public final zzack zzg(long j) {
        zzack zzackVarZzg = this.zza.zzg(j);
        zzacn zzacnVar = zzackVarZzg.zza;
        zzacn zzacnVar2 = new zzacn(zzacnVar.zzb, zzacnVar.zzc + this.zzb.zzb);
        zzacn zzacnVar3 = zzackVarZzg.zzb;
        return new zzack(zzacnVar2, new zzacn(zzacnVar3.zzb, zzacnVar3.zzc + this.zzb.zzb));
    }
}
