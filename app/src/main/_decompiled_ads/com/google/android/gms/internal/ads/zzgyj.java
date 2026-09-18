package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgyj extends zzgtz implements zzgvk {
    private static final zzgyj zzb;
    private int zzd;
    private zzgyi zzf;
    private long zzg;
    private String zze = "";
    private String zzh = "";

    static {
        zzgyj zzgyjVar = new zzgyj();
        zzb = zzgyjVar;
        zzgtz.zzaU(zzgyj.class, zzgyjVar);
    }

    private zzgyj() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003ဂ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgyj();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgyg(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
