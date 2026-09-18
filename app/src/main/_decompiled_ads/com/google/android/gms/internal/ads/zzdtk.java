package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdtk implements zzhbc {
    private final zzdtc zza;
    private final zzhbp zzb;
    private final zzhbp zzc;

    public zzdtk(zzdtc zzdtcVar, zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzdtcVar;
        this.zzb = zzhbpVar;
        this.zzc = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdtm zzdtmVar = (zzdtm) this.zzb.zzb();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        Set setZzh = zzdtc.zzh(zzdtmVar, zzgadVar);
        zzhbk.zzb(setZzh);
        return setZzh;
    }
}
