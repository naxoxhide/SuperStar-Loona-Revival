package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzban extends zzgtz implements zzgvk {
    private static final zzban zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzban zzbanVar = new zzban();
        zzb = zzbanVar;
        zzgtz.zzaU(zzban.class, zzbanVar);
    }

    private zzban() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzban();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzbam(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
