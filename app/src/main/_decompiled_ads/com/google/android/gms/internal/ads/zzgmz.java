package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgmz extends zzgtz implements zzgvk {
    private static final zzgmz zzb;
    private int zzd;
    private zzgnf zze;
    private zzgor zzf;

    static {
        zzgmz zzgmzVar = new zzgmz();
        zzb = zzgmzVar;
        zzgtz.zzaU(zzgmz.class, zzgmzVar);
    }

    private zzgmz() {
    }

    public static zzgmy zza() {
        return (zzgmy) zzb.zzaA();
    }

    public static zzgmz zzd(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgmz) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    static /* synthetic */ void zzg(zzgmz zzgmzVar, zzgnf zzgnfVar) {
        zzgnfVar.getClass();
        zzgmzVar.zze = zzgnfVar;
        zzgmzVar.zzd |= 1;
    }

    static /* synthetic */ void zzh(zzgmz zzgmzVar, zzgor zzgorVar) {
        zzgorVar.getClass();
        zzgmzVar.zzf = zzgorVar;
        zzgmzVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgmz();
        }
        zzgmx zzgmxVar = null;
        if (i2 == 4) {
            return new zzgmy(zzgmxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgnf zze() {
        zzgnf zzgnfVar = this.zze;
        return zzgnfVar == null ? zzgnf.zze() : zzgnfVar;
    }

    public final zzgor zzf() {
        zzgor zzgorVar = this.zzf;
        return zzgorVar == null ? zzgor.zze() : zzgorVar;
    }
}
