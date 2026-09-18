package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaov extends zzgtz implements zzgvk {
    private static final zzaov zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;
    private int zzg = 1000;

    static {
        zzaov zzaovVar = new zzaov();
        zzb = zzaovVar;
        zzgtz.zzaU(zzaov.class, zzaovVar);
    }

    private zzaov() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgud zzgudVar = zzapp.zza;
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", zzgudVar, "zzg", zzgudVar});
        }
        if (i2 == 3) {
            return new zzaov();
        }
        zzaol zzaolVar = null;
        if (i2 == 4) {
            return new zzaou(zzaolVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
