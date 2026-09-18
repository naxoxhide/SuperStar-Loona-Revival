package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqs implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;
    private final zzhbp zzd;
    private final zzhbp zze;

    public zzdqs(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3, zzhbp zzhbpVar4, zzhbp zzhbpVar5) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
        this.zzd = zzhbpVar4;
        this.zze = zzhbpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcic) this.zza).zza();
        final String strZzb = ((zzdxd) this.zzb).zzb();
        zzcaz zzcazVarZza = ((zzcio) this.zzc).zza();
        final zzayf zzayfVar = (zzayf) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzaxv zzaxvVar = new zzaxv(new zzayb(contextZza));
        zzbau zzbauVarZza = zzbav.zza();
        zzbauVarZza.zza(zzcazVarZza.zzb);
        zzbauVarZza.zzc(zzcazVarZza.zzc);
        zzbauVarZza.zzb(true != zzcazVarZza.zzd ? 2 : 0);
        final zzbav zzbavVar = (zzbav) zzbauVarZza.zzal();
        zzaxvVar.zzb(new zzaxu() { // from class: com.google.android.gms.internal.ads.zzdqr
            @Override // com.google.android.gms.internal.ads.zzaxu
            public final void zza(zzazk zzazkVar) {
                zzayg zzaygVar = (zzayg) zzazkVar.zza().zzaB();
                zzaygVar.zza(zzayfVar);
                zzazkVar.zze(zzaygVar);
                zzazc zzazcVar = (zzazc) zzazkVar.zzb().zzaB();
                zzazcVar.zza(strZzb);
                zzazcVar.zzb(zzbavVar);
                zzazkVar.zzg(zzazcVar);
                zzazkVar.zzh(str);
            }
        });
        return zzaxvVar;
    }
}
