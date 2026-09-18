package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzbdn {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbdn(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbdn zza(String str, double d) {
        return new zzbdn(str, Double.valueOf(d), 3);
    }

    public static zzbdn zzb(String str, long j) {
        return new zzbdn(str, Long.valueOf(j), 2);
    }

    public static zzbdn zzc(String str, String str2) {
        return new zzbdn(str, str2, 4);
    }

    public static zzbdn zzd(String str, boolean z) {
        return new zzbdn(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzber zzberVarZza = zzbet.zza();
        if (zzberVarZza == null) {
            if (zzbet.zzb() != null) {
                zzbet.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zzberVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i != 1) {
            return i != 2 ? zzberVarZza.zzd(this.zza, (String) this.zzb) : zzberVarZza.zzb(this.zza, ((Double) this.zzb).doubleValue());
        }
        return zzberVarZza.zzc(this.zza, ((Long) this.zzb).longValue());
    }
}
