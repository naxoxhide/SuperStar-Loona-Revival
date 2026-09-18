package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnr extends zzgtz implements zzgvk {
    private static final zzgnr zzb;
    private int zzd;

    static {
        zzgnr zzgnrVar = new zzgnr();
        zzb = zzgnrVar;
        zzgtz.zzaU(zzgnr.class, zzgnrVar);
    }

    private zzgnr() {
    }

    public static zzgnq zzc() {
        return (zzgnq) zzb.zzaA();
    }

    public static zzgnr zze() {
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
            return new zzgnr();
        }
        zzgnp zzgnpVar = null;
        if (i2 == 4) {
            return new zzgnq(zzgnpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
