package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazb extends zzgtz implements zzgvk {
    private static final zzazb zzb;
    private int zzd;
    private int zze;
    private zzbat zzf;
    private zzbat zzg;
    private zzbat zzh;
    private zzgui zzi = zzaN();
    private int zzj;

    static {
        zzazb zzazbVar = new zzazb();
        zzb = zzazbVar;
        zzgtz.zzaU(zzazb.class, zzazbVar);
    }

    private zzazb() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzbat.class, "zzj"});
        }
        if (i2 == 3) {
            return new zzazb();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzaza(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
