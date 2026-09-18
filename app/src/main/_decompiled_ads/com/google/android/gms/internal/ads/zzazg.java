package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazg extends zzgtz implements zzgvk {
    private static final zzazg zzb;
    private int zzd;
    private int zze;
    private zzbav zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzazg zzazgVar = new zzazg();
        zzb = zzazgVar;
        zzgtz.zzaU(zzazg.class, zzazgVar);
    }

    private zzazg() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005᠌\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zzd", "zze", zzazf.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzazg();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzaze(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
