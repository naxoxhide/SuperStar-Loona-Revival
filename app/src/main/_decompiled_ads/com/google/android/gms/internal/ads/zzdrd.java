package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrd implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;

    public zzdrd(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeM)).booleanValue() ? Collections.singleton(new zzdev(((zzdrw) this.zzb).zzb(), zzgadVar)) : Collections.emptySet();
        zzhbk.zzb(setSingleton);
        return setSingleton;
    }
}
