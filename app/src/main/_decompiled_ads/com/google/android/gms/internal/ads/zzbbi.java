package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbbi extends zzgtz implements zzgvk {
    private static final zzbbi zzb;
    private int zzd;
    private int zze = 1000;
    private zzbbc zzf;
    private zzbat zzg;

    static {
        zzbbi zzbbiVar = new zzbbi();
        zzb = zzbbiVar;
        zzgtz.zzaU(zzbbi.class, zzbbiVar);
    }

    private zzbbi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzazi.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbbi();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzbbh(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
