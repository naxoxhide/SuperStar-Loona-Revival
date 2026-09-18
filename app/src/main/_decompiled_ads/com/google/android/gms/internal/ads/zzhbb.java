package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhbb implements zzhbp, zzhaw {
    private static final Object zza = new Object();
    private volatile zzhbp zzb;
    private volatile Object zzc = zza;

    private zzhbb(zzhbp zzhbpVar) {
        this.zzb = zzhbpVar;
    }

    public static zzhaw zza(zzhbp zzhbpVar) {
        if (zzhbpVar instanceof zzhaw) {
            return (zzhaw) zzhbpVar;
        }
        Objects.requireNonNull(zzhbpVar);
        return new zzhbb(zzhbpVar);
    }

    public static zzhbp zzc(zzhbp zzhbpVar) {
        return zzhbpVar instanceof zzhbb ? zzhbpVar : new zzhbb(zzhbpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final Object zzb() {
        Object objZzb = this.zzc;
        Object obj = zza;
        if (objZzb == obj) {
            synchronized (this) {
                objZzb = this.zzc;
                if (objZzb == obj) {
                    objZzb = this.zzb.zzb();
                    Object obj2 = this.zzc;
                    if (obj2 != obj && obj2 != objZzb) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objZzb + ". This is likely due to a circular dependency.");
                    }
                    this.zzc = objZzb;
                    this.zzb = null;
                }
            }
        }
        return objZzb;
    }
}
