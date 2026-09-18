package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgxq extends zzgtz implements zzgvk {
    private static final zzgxq zzb;
    private int zzd;
    private long zze;
    private long zzf;

    static {
        zzgxq zzgxqVar = new zzgxq();
        zzb = zzgxqVar;
        zzgtz.zzaU(zzgxq.class, zzgxqVar);
    }

    private zzgxq() {
    }

    public static zzgxp zza() {
        return (zzgxp) zzb.zzaA();
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgxq();
        }
        zzgxo zzgxoVar = null;
        if (i2 == 4) {
            return new zzgxp(zzgxoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
