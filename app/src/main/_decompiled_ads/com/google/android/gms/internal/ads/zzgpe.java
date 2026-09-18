package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpe extends zzgtz implements zzgvk {
    private static final zzgpe zzb;
    private String zzd = "";
    private zzgsr zze = zzgsr.zzb;
    private int zzf;

    static {
        zzgpe zzgpeVar = new zzgpe();
        zzb = zzgpeVar;
        zzgtz.zzaU(zzgpe.class, zzgpeVar);
    }

    private zzgpe() {
    }

    public static zzgpd zza() {
        return (zzgpd) zzb.zzaA();
    }

    public static zzgpe zzd() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgpe();
        }
        zzgpc zzgpcVar = null;
        if (i2 == 4) {
            return new zzgpd(zzgpcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgqf zze() {
        zzgqf zzgqfVarZzb = zzgqf.zzb(this.zzf);
        return zzgqfVarZzb == null ? zzgqf.UNRECOGNIZED : zzgqfVarZzb;
    }

    public final zzgsr zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }
}
