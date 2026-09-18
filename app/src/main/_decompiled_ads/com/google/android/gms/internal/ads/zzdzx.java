package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzx implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;
    private final zzhbp zzc;
    private final zzhbp zzd;
    private final zzhbp zze;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;
    private final zzhbp zzi;

    public zzdzx(zzhbp zzhbpVar, zzhbp zzhbpVar2, zzhbp zzhbpVar3, zzhbp zzhbpVar4, zzhbp zzhbpVar5, zzhbp zzhbpVar6, zzhbp zzhbpVar7, zzhbp zzhbpVar8, zzhbp zzhbpVar9) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
        this.zzc = zzhbpVar3;
        this.zzd = zzhbpVar4;
        this.zze = zzhbpVar5;
        this.zzf = zzhbpVar6;
        this.zzg = zzhbpVar7;
        this.zzh = zzhbpVar8;
        this.zzi = zzhbpVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdzw zzb() {
        zzdae zzdaeVarZzb = ((zzdaf) this.zza).zzb();
        zzdze zzdzeVarZzb = ((zzdzf) this.zzb).zzb();
        zzfhr zzfhrVar = (zzfhr) this.zzc.zzb();
        zzfdn zzfdnVarZza = ((zzcxc) this.zzd).zza();
        zzcaz zzcazVarZza = ((zzcio) this.zze).zza();
        zzfjh zzfjhVar = (zzfjh) this.zzf.zzb();
        zzfje zzfjeVar = (zzfje) this.zzg.zzb();
        Context contextZza = ((zzcic) this.zzh).zza();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        return new zzdzw(zzdaeVarZzb, zzdzeVarZzb, zzfhrVar, zzfdnVarZza, zzcazVarZza, zzfjhVar, zzfjeVar, contextZza, zzgadVar);
    }
}
