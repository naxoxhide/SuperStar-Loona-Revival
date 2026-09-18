package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgzb extends zzgtz implements zzgvk {
    private static final zzgzb zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;

    static {
        zzgzb zzgzbVar = new zzgzb();
        zzb = zzgzbVar;
        zzgtz.zzaU(zzgzb.class, zzgzbVar);
    }

    private zzgzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgud zzgudVar = zzgyz.zza;
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzgudVar, "zzf", "zzg", zzgudVar});
        }
        if (i2 == 3) {
            return new zzgzb();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgza(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
