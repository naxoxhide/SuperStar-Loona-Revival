package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaof extends zzgtz implements zzgvk {
    private static final zzaof zzb;
    private int zzd;
    private zzaoh zze;
    private zzaok zzf;

    static {
        zzaof zzaofVar = new zzaof();
        zzb = zzaofVar;
        zzgtz.zzaU(zzaof.class, zzaofVar);
    }

    private zzaof() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaof();
        }
        zzaod zzaodVar = null;
        if (i2 == 4) {
            return new zzaoe(zzaodVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
