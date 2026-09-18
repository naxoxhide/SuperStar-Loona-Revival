package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhac extends zzgtz implements zzgvk {
    private static final zzhac zzb;
    private int zzd;
    private int zze;
    private int zzh;
    private String zzf = "";
    private zzgue zzg = zzaJ();
    private zzgui zzi = zzaN();
    private zzgsr zzj = zzgsr.zzb;

    static {
        zzhac zzhacVar = new zzhac();
        zzb = zzhacVar;
        zzgtz.zzaU(zzhac.class, zzhacVar);
    }

    private zzhac() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzhaa.class, "zzj"});
        }
        if (i2 == 3) {
            return new zzhac();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzhab(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
