package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcrj implements zzhbc {
    private final zzcrc zza;
    private final zzhbp zzb;

    public zzcrj(zzcrc zzcrcVar, zzhbp zzhbpVar) {
        this.zza = zzcrcVar;
        this.zzb = zzhbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzg = zzcrc.zzg((zzcsm) this.zzb.zzb());
        zzhbk.zzb(setZzg);
        return setZzg;
    }
}
