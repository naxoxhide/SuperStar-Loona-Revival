package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgzl extends zzgtz implements zzgvk {
    private static final zzgzl zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzgsr zzg = zzgsr.zzb;
    private zzgsr zzh = zzgsr.zzb;

    static {
        zzgzl zzgzlVar = new zzgzl();
        zzb = zzgzlVar;
        zzgtz.zzaU(zzgzl.class, zzgzlVar);
    }

    private zzgzl() {
    }

    public static zzgzj zza() {
        return (zzgzj) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgzl zzgzlVar, String str) {
        zzgzlVar.zzd |= 2;
        zzgzlVar.zzf = "image/png";
    }

    static /* synthetic */ void zze(zzgzl zzgzlVar, zzgsr zzgsrVar) {
        zzgsrVar.getClass();
        zzgzlVar.zzd |= 4;
        zzgzlVar.zzg = zzgsrVar;
    }

    static /* synthetic */ void zzf(zzgzl zzgzlVar, int i) {
        zzgzlVar.zze = 1;
        zzgzlVar.zzd = 1 | zzgzlVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", zzgzk.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgzl();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgzj(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
