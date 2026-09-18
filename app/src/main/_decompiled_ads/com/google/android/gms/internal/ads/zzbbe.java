package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbbe extends zzgtz implements zzgvk {
    private static final zzbbe zzb;
    private int zzd;
    private zzbav zze;
    private int zzf = 1000;
    private zzbbc zzg;
    private zzbat zzh;

    static {
        zzbbe zzbbeVar = new zzbbe();
        zzb = zzbbeVar;
        zzgtz.zzaU(zzbbe.class, zzbbeVar);
    }

    private zzbbe() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", zzazi.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbbe();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzbbd(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
