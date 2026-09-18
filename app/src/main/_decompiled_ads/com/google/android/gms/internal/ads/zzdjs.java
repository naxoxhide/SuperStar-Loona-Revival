package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjs {
    zzbgp zza;
    zzbgm zzb;
    zzbhc zzc;
    zzbgz zzd;
    zzbmb zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdjs zza(zzbgm zzbgmVar) {
        this.zzb = zzbgmVar;
        return this;
    }

    public final zzdjs zzb(zzbgp zzbgpVar) {
        this.zza = zzbgpVar;
        return this;
    }

    public final zzdjs zzc(String str, zzbgv zzbgvVar, zzbgs zzbgsVar) {
        this.zzf.put(str, zzbgvVar);
        if (zzbgsVar != null) {
            this.zzg.put(str, zzbgsVar);
        }
        return this;
    }

    public final zzdjs zzd(zzbmb zzbmbVar) {
        this.zze = zzbmbVar;
        return this;
    }

    public final zzdjs zze(zzbgz zzbgzVar) {
        this.zzd = zzbgzVar;
        return this;
    }

    public final zzdjs zzf(zzbhc zzbhcVar) {
        this.zzc = zzbhcVar;
        return this;
    }

    public final zzdju zzg() {
        return new zzdju(this);
    }
}
