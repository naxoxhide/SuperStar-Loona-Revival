package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpx extends zzgtz implements zzgvk {
    private static final zzgpx zzb;
    private String zzd = "";

    static {
        zzgpx zzgpxVar = new zzgpx();
        zzb = zzgpxVar;
        zzgtz.zzaU(zzgpx.class, zzgpxVar);
    }

    private zzgpx() {
    }

    public static zzgpx zzc() {
        return zzb;
    }

    public static zzgpx zzd(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgpx) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzgpx();
        }
        zzgpv zzgpvVar = null;
        if (i2 == 4) {
            return new zzgpw(zzgpvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zze() {
        return this.zzd;
    }
}
