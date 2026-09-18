package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgqd extends zzgtz implements zzgvk {
    private static final zzgqd zzb;
    private int zzd;
    private String zze = "";
    private zzgpe zzf;

    static {
        zzgqd zzgqdVar = new zzgqd();
        zzb = zzgqdVar;
        zzgtz.zzaU(zzgqd.class, zzgqdVar);
    }

    private zzgqd() {
    }

    public static zzgqd zzd() {
        return zzb;
    }

    public static zzgqd zze(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgqd) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    public final zzgpe zza() {
        zzgpe zzgpeVar = this.zzf;
        return zzgpeVar == null ? zzgpe.zzd() : zzgpeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgqd();
        }
        zzgqb zzgqbVar = null;
        if (i2 == 4) {
            return new zzgqc(zzgqbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return (this.zzd & 1) != 0;
    }
}
