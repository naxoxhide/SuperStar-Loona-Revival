package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaoh extends zzgtz implements zzgvk {
    private static final zzaoh zzb;
    private int zzd;
    private int zze = 2;

    static {
        zzaoh zzaohVar = new zzaoh();
        zzb = zzaohVar;
        zzgtz.zzaU(zzaoh.class, zzaohVar);
    }

    private zzaoh() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzd", "zze", zzaoi.zza});
        }
        if (i2 == 3) {
            return new zzaoh();
        }
        zzaod zzaodVar = null;
        if (i2 == 4) {
            return new zzaog(zzaodVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
