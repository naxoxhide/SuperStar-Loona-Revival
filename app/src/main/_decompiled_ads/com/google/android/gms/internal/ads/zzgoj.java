package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgoj extends zzgtz implements zzgvk {
    private static final zzgoj zzb;

    static {
        zzgoj zzgojVar = new zzgoj();
        zzb = zzgojVar;
        zzgtz.zzaU(zzgoj.class, zzgojVar);
    }

    private zzgoj() {
    }

    public static zzgoj zzc() {
        return zzb;
    }

    public static zzgoj zzd(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgoj) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzgoh zzgohVar = null;
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0000", null);
        }
        if (i2 == 3) {
            return new zzgoj();
        }
        if (i2 == 4) {
            return new zzgoi(zzgohVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
