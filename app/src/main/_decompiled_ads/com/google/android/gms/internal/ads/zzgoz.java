package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgoz extends zzgtz implements zzgvk {
    private static final zzgoz zzb;
    private String zzd = "";
    private zzgsr zze = zzgsr.zzb;
    private int zzf;

    static {
        zzgoz zzgozVar = new zzgoz();
        zzb = zzgozVar;
        zzgtz.zzaU(zzgoz.class, zzgozVar);
    }

    private zzgoz() {
    }

    public static zzgow zza() {
        return (zzgow) zzb.zzaA();
    }

    public static zzgoz zze() {
        return zzb;
    }

    static /* synthetic */ void zzh(zzgoz zzgozVar, String str) {
        str.getClass();
        zzgozVar.zzd = str;
    }

    static /* synthetic */ void zzi(zzgoz zzgozVar, zzgsr zzgsrVar) {
        zzgsrVar.getClass();
        zzgozVar.zze = zzgsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgoz();
        }
        zzgov zzgovVar = null;
        if (i2 == 4) {
            return new zzgow(zzgovVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgoy zzc() {
        zzgoy zzgoyVar;
        int i = this.zzf;
        zzgoy zzgoyVar2 = zzgoy.UNKNOWN_KEYMATERIAL;
        if (i == 0) {
            zzgoyVar = zzgoy.UNKNOWN_KEYMATERIAL;
        } else if (i == 1) {
            zzgoyVar = zzgoy.SYMMETRIC;
        } else if (i == 2) {
            zzgoyVar = zzgoy.ASYMMETRIC_PRIVATE;
        } else if (i != 3) {
            zzgoyVar = i != 4 ? null : zzgoy.REMOTE;
        } else {
            zzgoyVar = zzgoy.ASYMMETRIC_PUBLIC;
        }
        return zzgoyVar == null ? zzgoy.UNRECOGNIZED : zzgoyVar;
    }

    public final zzgsr zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }
}
