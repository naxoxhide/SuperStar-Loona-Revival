package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzgqi extends zzgtz implements zzgvk {
    private static final zzgqi zzb;
    private String zzd = "";
    private zzgui zze = zzaN();

    static {
        zzgqi zzgqiVar = new zzgqi();
        zzb = zzgqiVar;
        zzgtz.zzaU(zzgqi.class, zzgqiVar);
    }

    private zzgqi() {
    }

    public static zzgqi zzc() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgph.class});
        }
        if (i2 == 3) {
            return new zzgqi();
        }
        zzgqg zzgqgVar = null;
        if (i2 == 4) {
            return new zzgqh(zzgqgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
