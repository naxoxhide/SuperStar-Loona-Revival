package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayx extends zzgtz implements zzgvk {
    private static final zzayx zzb;
    private int zzd;
    private String zze = "";
    private zzgui zzf = zzaN();
    private int zzg;

    static {
        zzayx zzayxVar = new zzayx();
        zzb = zzayxVar;
        zzgtz.zzaU(zzayx.class, zzayxVar);
    }

    private zzayx() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzayv.class, "zzg", zzazi.zza});
        }
        if (i2 == 3) {
            return new zzayx();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzayw(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
