package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdgl implements zzhbc {
    private final zzdga zza;
    private final zzhbp zzb;

    public zzdgl(zzdga zzdgaVar, zzhbp zzhbpVar) {
        this.zza = zzdgaVar;
        this.zzb = zzhbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzf = this.zza.zzf((zzcwi) this.zzb.zzb());
        zzhbk.zzb(setZzf);
        return setZzf;
    }
}
