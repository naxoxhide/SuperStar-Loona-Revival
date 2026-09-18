package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaui extends zzgtz implements zzgvk {
    private static final zzaui zzb;
    private int zzd;
    private zzaul zze;
    private zzgsr zzf = zzgsr.zzb;
    private zzgsr zzg = zzgsr.zzb;

    static {
        zzaui zzauiVar = new zzaui();
        zzb = zzauiVar;
        zzgtz.zzaU(zzaui.class, zzauiVar);
    }

    private zzaui() {
    }

    public static zzaui zzc(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzaui) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaui();
        }
        zzaug zzaugVar = null;
        if (i2 == 4) {
            return new zzauh(zzaugVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzaul zzd() {
        zzaul zzaulVar = this.zze;
        return zzaulVar == null ? zzaul.zzg() : zzaulVar;
    }

    public final zzgsr zze() {
        return this.zzg;
    }

    public final zzgsr zzf() {
        return this.zzf;
    }
}
