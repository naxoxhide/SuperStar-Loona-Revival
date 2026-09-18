package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaop extends zzgtz implements zzgvk {
    private static final zzaop zzb;
    private int zzd;
    private int zze;

    static {
        zzaop zzaopVar = new zzaop();
        zzb = zzaopVar;
        zzgtz.zzaU(zzaop.class, zzaopVar);
    }

    private zzaop() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzaot.zza});
        }
        if (i2 == 3) {
            return new zzaop();
        }
        zzaol zzaolVar = null;
        if (i2 == 4) {
            return new zzaoo(zzaolVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
