package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhbo implements zzhbp {
    private static final Object zza = new Object();
    private volatile zzhbp zzb;
    private volatile Object zzc = zza;

    private zzhbo(zzhbp zzhbpVar) {
        this.zzb = zzhbpVar;
    }

    public static zzhbp zza(zzhbp zzhbpVar) {
        return ((zzhbpVar instanceof zzhbo) || (zzhbpVar instanceof zzhbb)) ? zzhbpVar : new zzhbo(zzhbpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzhbp zzhbpVar = this.zzb;
        if (zzhbpVar == null) {
            return this.zzc;
        }
        Object objZzb = zzhbpVar.zzb();
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }
}
