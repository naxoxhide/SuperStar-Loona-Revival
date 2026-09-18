package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgmt extends zzgtz implements zzgvk {
    private static final zzgmt zzb;
    private int zzd;

    static {
        zzgmt zzgmtVar = new zzgmt();
        zzb = zzgmtVar;
        zzgtz.zzaU(zzgmt.class, zzgmtVar);
    }

    private zzgmt() {
    }

    public static zzgms zzc() {
        return (zzgms) zzb.zzaA();
    }

    public static zzgmt zze() {
        return zzb;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzgmt();
        }
        zzgmr zzgmrVar = null;
        if (i2 == 4) {
            return new zzgms(zzgmrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
