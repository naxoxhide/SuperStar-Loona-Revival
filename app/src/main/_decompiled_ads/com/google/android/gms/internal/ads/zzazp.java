package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazp extends zzgtz implements zzgvk {
    private static final zzazp zzb;
    private int zzd;
    private int zze;
    private zzgue zzf = zzaJ();

    static {
        zzazp zzazpVar = new zzazp();
        zzb = zzazpVar;
        zzgtz.zzaU(zzazp.class, zzazpVar);
    }

    private zzazp() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u0016", new Object[]{"zzd", "zze", zzazi.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzazp();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzazo(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
