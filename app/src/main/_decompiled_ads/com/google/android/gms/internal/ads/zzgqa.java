package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgqa extends zzgtz implements zzgvk {
    private static final zzgqa zzb;
    private int zzd;
    private int zze;
    private zzgqd zzf;

    static {
        zzgqa zzgqaVar = new zzgqa();
        zzb = zzgqaVar;
        zzgtz.zzaU(zzgqa.class, zzgqaVar);
    }

    private zzgqa() {
    }

    public static zzgpz zzc() {
        return (zzgpz) zzb.zzaA();
    }

    public static zzgqa zze(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgqa) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
    }

    static /* synthetic */ void zzh(zzgqa zzgqaVar, zzgqd zzgqdVar) {
        zzgqdVar.getClass();
        zzgqaVar.zzf = zzgqdVar;
        zzgqaVar.zzd |= 1;
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
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgqa();
        }
        zzgpy zzgpyVar = null;
        if (i2 == 4) {
            return new zzgpz(zzgpyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgqd zzf() {
        zzgqd zzgqdVar = this.zzf;
        return zzgqdVar == null ? zzgqd.zzd() : zzgqdVar;
    }
}
