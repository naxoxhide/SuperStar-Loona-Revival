package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbcf implements zzber {
    final /* synthetic */ zzbcg zza;

    zzbcf(zzbcg zzbcgVar) {
        this.zza = zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final Boolean zza(String str, boolean z) {
        try {
            return Boolean.valueOf(this.zza.zze.getBoolean(str, z));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(this.zza.zze.getString(str, String.valueOf(z)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final Double zzb(String str, double d) {
        try {
            return Double.valueOf(this.zza.zze.getFloat(str, (float) d));
        } catch (ClassCastException unused) {
            return Double.valueOf(this.zza.zze.getString(str, String.valueOf(d)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final Long zzc(String str, long j) {
        try {
            return Long.valueOf(this.zza.zze.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf(this.zza.zze.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzber
    public final String zzd(String str, String str2) {
        return this.zza.zze.getString(str, str2);
    }
}
