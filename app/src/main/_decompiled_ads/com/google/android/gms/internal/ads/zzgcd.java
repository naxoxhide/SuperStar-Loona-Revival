package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgcd {
    private final ConcurrentMap zza;
    private final List zzb;
    private final zzgbz zzc;
    private final Class zzd;
    private final zzgmc zze;

    /* synthetic */ zzgcd(ConcurrentMap concurrentMap, List list, zzgbz zzgbzVar, zzgmc zzgmcVar, Class cls, zzgcc zzgccVar) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzgbzVar;
        this.zzd = cls;
        this.zze = zzgmcVar;
    }

    @Nullable
    public final zzgbz zza() {
        return this.zzc;
    }

    public final zzgmc zzb() {
        return this.zze;
    }

    public final Class zzc() {
        return this.zzd;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze(byte[] bArr) {
        List list = (List) this.zza.get(new zzgcb(bArr, null));
        return list != null ? list : Collections.emptyList();
    }

    public final boolean zzf() {
        return !this.zze.zza().isEmpty();
    }
}
