package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgzi extends zzgtz implements zzgvk {
    private static final zzgzi zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    static {
        zzgzi zzgziVar = new zzgzi();
        zzb = zzgziVar;
        zzgtz.zzaU(zzgzi.class, zzgziVar);
    }

    private zzgzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", zzgzh.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgzi();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgzg(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
