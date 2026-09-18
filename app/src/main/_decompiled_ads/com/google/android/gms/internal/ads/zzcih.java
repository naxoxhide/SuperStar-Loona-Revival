package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcih implements zzhbc {
    private final zzhbp zza;
    private final zzhbp zzb;

    public zzcih(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        this.zza = zzhbpVar;
        this.zzb = zzhbpVar2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x003b  */
    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet;
        zzebt zzebtVar = (zzebt) this.zza.zzb();
        zzgad zzgadVar = zzcbg.zza;
        zzhbk.zzb(zzgadVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbX)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzir)).booleanValue()) {
                setEmptySet = Collections.singleton(new zzdev(zzebtVar, zzgadVar));
            } else {
                setEmptySet = Collections.emptySet();
            }
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzhbk.zzb(setEmptySet);
        return setEmptySet;
    }
}
