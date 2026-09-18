package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgxy extends zzgtz implements zzgvk {
    private static final zzgxy zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private zzgsr zzg = zzgsr.zzb;

    static {
        zzgxy zzgxyVar = new zzgxy();
        zzb = zzgxyVar;
        zzgtz.zzaU(zzgxy.class, zzgxyVar);
    }

    private zzgxy() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", zzgxx.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgxy();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgxw(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
