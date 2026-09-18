package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgou extends zzgtz implements zzgvk {
    private static final zzgou zzb;
    private int zzd;
    private int zze;

    static {
        zzgou zzgouVar = new zzgou();
        zzb = zzgouVar;
        zzgtz.zzaU(zzgou.class, zzgouVar);
    }

    private zzgou() {
    }

    public static zzgot zzd() {
        return (zzgot) zzb.zzaA();
    }

    public static zzgou zzf() {
        return zzb;
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
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzgou();
        }
        zzgos zzgosVar = null;
        if (i2 == 4) {
            return new zzgot(zzgosVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgol zzc() {
        zzgol zzgolVar;
        int i = this.zzd;
        zzgol zzgolVar2 = zzgol.UNKNOWN_HASH;
        if (i == 0) {
            zzgolVar = zzgol.UNKNOWN_HASH;
        } else if (i == 1) {
            zzgolVar = zzgol.SHA1;
        } else if (i == 2) {
            zzgolVar = zzgol.SHA384;
        } else if (i == 3) {
            zzgolVar = zzgol.SHA256;
        } else if (i != 4) {
            zzgolVar = i != 5 ? null : zzgol.SHA224;
        } else {
            zzgolVar = zzgol.SHA512;
        }
        return zzgolVar == null ? zzgol.UNRECOGNIZED : zzgolVar;
    }
}
