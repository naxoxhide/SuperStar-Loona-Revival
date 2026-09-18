package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcla implements zzdty {
    private final Context zza;
    private final zzbkh zzb;
    private final zzcjs zzc;
    private final zzcla zzd = this;
    private final zzhbp zze;
    private final zzhbp zzf;
    private final zzhbp zzg;
    private final zzhbp zzh;

    /* synthetic */ zzcla(zzcjs zzcjsVar, Context context, zzbkh zzbkhVar, zzckz zzckzVar) {
        this.zzc = zzcjsVar;
        this.zza = context;
        this.zzb = zzbkhVar;
        zzhbc zzhbcVarZza = zzhbd.zza(this);
        this.zze = zzhbcVarZza;
        zzhbc zzhbcVarZza2 = zzhbd.zza(zzbkhVar);
        this.zzf = zzhbcVarZza2;
        zzdtu zzdtuVar = new zzdtu(zzhbcVarZza2);
        this.zzg = zzdtuVar;
        this.zzh = zzhbb.zzc(new zzdtw(zzhbcVarZza, zzdtuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdty
    public final zzdtp zzb() {
        return new zzcku(this.zzc, this.zzd, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdty
    public final zzdtv zzd() {
        return (zzdtv) this.zzh.zzb();
    }
}
