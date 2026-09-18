package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzczc implements zzhbc {
    private final zzhbp zza;

    public zzczc(zzhbp zzhbpVar) {
        this.zza = zzhbpVar;
    }

    public static zzczb zzc(Set set) {
        return new zzczb(set);
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzczb zzb() {
        return new zzczb(((zzhbn) this.zza).zzb());
    }
}
