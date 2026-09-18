package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnl extends zzgtz implements zzgvk {
    private static final zzgnl zzb;
    private int zzd;
    private int zze;
    private zzgnr zzf;
    private zzgsr zzg = zzgsr.zzb;

    static {
        zzgnl zzgnlVar = new zzgnl();
        zzb = zzgnlVar;
        zzgtz.zzaU(zzgnl.class, zzgnlVar);
    }

    private zzgnl() {
    }

    public static zzgnk zzc() {
        return (zzgnk) zzb.zzaA();
    }

    public static zzgnl zze(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgnl) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    static /* synthetic */ void zzi(zzgnl zzgnlVar, zzgnr zzgnrVar) {
        zzgnrVar.getClass();
        zzgnlVar.zzf = zzgnrVar;
        zzgnlVar.zzd |= 1;
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
            return new zzgnl();
        }
        zzgnj zzgnjVar = null;
        if (i2 == 4) {
            return new zzgnk(zzgnjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgnr zzf() {
        zzgnr zzgnrVar = this.zzf;
        return zzgnrVar == null ? zzgnr.zze() : zzgnrVar;
    }

    public final zzgsr zzg() {
        return this.zzg;
    }
}
