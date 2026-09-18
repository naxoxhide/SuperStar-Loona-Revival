package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaoa extends zzgtz implements zzgvk {
    private static final zzaoa zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzaoa zzaoaVar = new zzaoa();
        zzb = zzaoaVar;
        zzgtz.zzaU(zzaoa.class, zzaoaVar);
    }

    private zzaoa() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaoa();
        }
        zzanx zzanxVar = null;
        if (i2 == 4) {
            return new zzanz(zzanxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
