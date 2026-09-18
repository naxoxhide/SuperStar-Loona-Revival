package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpl extends zzgtz implements zzgvk {
    private static final zzgpl zzb;
    private int zzd;
    private zzgoz zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzgpl zzgplVar = new zzgpl();
        zzb = zzgplVar;
        zzgtz.zzaU(zzgpl.class, zzgplVar);
    }

    private zzgpl() {
    }

    public static zzgpk zzd() {
        return (zzgpk) zzb.zzaA();
    }

    static /* synthetic */ void zzg(zzgpl zzgplVar, zzgoz zzgozVar) {
        zzgozVar.getClass();
        zzgplVar.zze = zzgozVar;
        zzgplVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgpl();
        }
        zzgpi zzgpiVar = null;
        if (i2 == 4) {
            return new zzgpk(zzgpiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgoz zzc() {
        zzgoz zzgozVar = this.zze;
        return zzgozVar == null ? zzgoz.zze() : zzgozVar;
    }

    public final zzgqf zzf() {
        zzgqf zzgqfVarZzb = zzgqf.zzb(this.zzh);
        return zzgqfVarZzb == null ? zzgqf.UNRECOGNIZED : zzgqfVarZzb;
    }

    public final boolean zzj() {
        return (this.zzd & 1) != 0;
    }

    public final int zzk() {
        int i = this.zzf;
        int i2 = 3;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            if (i != 2) {
                i2 = i != 3 ? 0 : 5;
            } else {
                i2 = 4;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
