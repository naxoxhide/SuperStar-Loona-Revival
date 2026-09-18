package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhba implements zzhbc {
    private zzhbp zza;

    public static void zza(zzhbp zzhbpVar, zzhbp zzhbpVar2) {
        zzhba zzhbaVar = (zzhba) zzhbpVar;
        if (zzhbaVar.zza != null) {
            throw new IllegalStateException();
        }
        zzhbaVar.zza = zzhbpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final Object zzb() {
        zzhbp zzhbpVar = this.zza;
        if (zzhbpVar != null) {
            return zzhbpVar.zzb();
        }
        throw new IllegalStateException();
    }
}
