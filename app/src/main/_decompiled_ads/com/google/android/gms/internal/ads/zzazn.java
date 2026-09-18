package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazn extends zzgtz implements zzgvk {
    private static final zzazn zzb;
    private int zzd;
    private int zzf;
    private zzbat zzh;
    private String zze = "";
    private zzgue zzg = zzaJ();

    static {
        zzazn zzaznVar = new zzazn();
        zzb = zzaznVar;
        zzgtz.zzaU(zzazn.class, zzaznVar);
    }

    private zzazn() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzazi.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzazn();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzazm(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
