package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpq extends zzgtz implements zzgvk {
    private static final zzgpq zzb;
    private String zzd = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgpq zzgpqVar = new zzgpq();
        zzb = zzgpqVar;
        zzgtz.zzaU(zzgpq.class, zzgpqVar);
    }

    private zzgpq() {
    }

    public static zzgpp zza() {
        return (zzgpp) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgpq zzgpqVar, String str) {
        str.getClass();
        zzgpqVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgpq();
        }
        zzgpn zzgpnVar = null;
        if (i2 == 4) {
            return new zzgpp(zzgpnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
