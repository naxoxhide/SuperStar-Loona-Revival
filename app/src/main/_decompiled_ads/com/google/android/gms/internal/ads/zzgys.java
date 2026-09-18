package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgys extends zzgtz implements zzgvk {
    private static final zzgys zzb;
    private int zzd;
    private zzgsr zze = zzgsr.zzb;
    private zzgsr zzf;
    private zzgsr zzg;

    static {
        zzgys zzgysVar = new zzgys();
        zzb = zzgysVar;
        zzgtz.zzaU(zzgys.class, zzgysVar);
    }

    private zzgys() {
        zzgsr zzgsrVar = zzgsr.zzb;
        this.zzf = zzgsrVar;
        this.zzg = zzgsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgys();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgyr(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
