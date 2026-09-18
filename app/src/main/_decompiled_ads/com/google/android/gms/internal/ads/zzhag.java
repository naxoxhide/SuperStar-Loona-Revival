package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhag extends zzgtz implements zzgvk {
    private static final zzhag zzb;
    private int zzd;
    private String zze = "";

    static {
        zzhag zzhagVar = new zzhag();
        zzb = zzhagVar;
        zzgtz.zzaU(zzhag.class, zzhagVar);
    }

    private zzhag() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzhag();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzhaf(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
