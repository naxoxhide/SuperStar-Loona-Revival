package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnu extends zzgtz implements zzgvk {
    private static final zzgnu zzb;
    private int zzd;
    private zzgsr zze = zzgsr.zzb;

    static {
        zzgnu zzgnuVar = new zzgnu();
        zzb = zzgnuVar;
        zzgtz.zzaU(zzgnu.class, zzgnuVar);
    }

    private zzgnu() {
    }

    public static zzgnt zzc() {
        return (zzgnt) zzb.zzaA();
    }

    public static zzgnu zze(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgnu) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
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
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzgnu();
        }
        zzgns zzgnsVar = null;
        if (i2 == 4) {
            return new zzgnt(zzgnsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgsr zzf() {
        return this.zze;
    }
}
