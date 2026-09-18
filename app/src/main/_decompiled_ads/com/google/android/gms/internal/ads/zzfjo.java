package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjo extends zzgtz implements zzgvk {
    private static final zzfjo zzb;
    private int zzd;
    private zzfjk zze;

    static {
        zzfjo zzfjoVar = new zzfjo();
        zzb = zzfjoVar;
        zzgtz.zzaU(zzfjo.class, zzfjoVar);
    }

    private zzfjo() {
    }

    public static zzfjn zza() {
        return (zzfjn) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzfjo zzfjoVar, zzfjk zzfjkVar) {
        zzfjkVar.getClass();
        zzfjoVar.zze = zzfjkVar;
        zzfjoVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzfjo();
        }
        zzfjl zzfjlVar = null;
        if (i2 == 4) {
            return new zzfjn(zzfjlVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
