package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbar extends zzgtz implements zzgvk {
    private static final zzbar zzb;
    private int zzd;
    private String zze = "";
    private int zzf;
    private zzbat zzg;

    static {
        zzbar zzbarVar = new zzbar();
        zzb = zzbarVar;
        zzgtz.zzaU(zzbar.class, zzbarVar);
    }

    private zzbar() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzazi.zza, "zzg"});
        }
        if (i2 == 3) {
            return new zzbar();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzbaq(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
