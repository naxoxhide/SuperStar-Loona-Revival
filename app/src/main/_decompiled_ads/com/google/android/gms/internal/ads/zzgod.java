package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgod extends zzgtz implements zzgvk {
    private static final zzgod zzb;
    private int zzd;
    private int zze;

    static {
        zzgod zzgodVar = new zzgod();
        zzb = zzgodVar;
        zzgtz.zzaU(zzgod.class, zzgodVar);
    }

    private zzgod() {
    }

    public static zzgoc zzc() {
        return (zzgoc) zzb.zzaA();
    }

    public static zzgod zze(zzgsr zzgsrVar, zzgtl zzgtlVar) throws zzgul {
        return (zzgod) zzgtz.zzaG(zzb, zzgsrVar, zzgtlVar);
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
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        }
        if (i2 == 3) {
            return new zzgod();
        }
        zzgob zzgobVar = null;
        if (i2 == 4) {
            return new zzgoc(zzgobVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
