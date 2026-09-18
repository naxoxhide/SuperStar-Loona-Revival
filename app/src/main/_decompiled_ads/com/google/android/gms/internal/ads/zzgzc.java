package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgzc extends zzgtz implements zzgvk {
    private static final zzgzc zzb;
    private int zzd;
    private int zze;
    private zzgzb zzf;
    private zzgzb zzg;

    static {
        zzgzc zzgzcVar = new zzgzc();
        zzb = zzgzcVar;
        zzgtz.zzaU(zzgzc.class, zzgzcVar);
    }

    private zzgzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzgyz.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgzc();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgyy(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
