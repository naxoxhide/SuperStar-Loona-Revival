package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnc extends zzgtz implements zzgvk {
    private static final zzgnc zzb;
    private int zzd;
    private int zze;
    private zzgni zzf;
    private zzgsr zzg = zzgsr.zzb;

    static {
        zzgnc zzgncVar = new zzgnc();
        zzb = zzgncVar;
        zzgtz.zzaU(zzgnc.class, zzgncVar);
    }

    private zzgnc() {
    }

    public static zzgnb zzc() {
        return (zzgnb) zzb.zzaA();
    }

    public static zzgnc zze() {
        return zzb;
    }

    public static zzgnc zzf(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgnc) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    static /* synthetic */ void zzj(zzgnc zzgncVar, zzgni zzgniVar) {
        zzgniVar.getClass();
        zzgncVar.zzf = zzgniVar;
        zzgncVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgnc();
        }
        zzgna zzgnaVar = null;
        if (i2 == 4) {
            return new zzgnb(zzgnaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgni zzg() {
        zzgni zzgniVar = this.zzf;
        return zzgniVar == null ? zzgni.zze() : zzgniVar;
    }

    public final zzgsr zzh() {
        return this.zzg;
    }
}
