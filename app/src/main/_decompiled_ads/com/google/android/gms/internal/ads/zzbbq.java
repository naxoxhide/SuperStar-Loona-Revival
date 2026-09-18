package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbbq extends zzgtz implements zzgvk {
    private static final zzbbq zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzbbq zzbbqVar = new zzbbq();
        zzb = zzbbqVar;
        zzgtz.zzaU(zzbbq.class, zzbbqVar);
    }

    private zzbbq() {
    }

    public static zzbbp zza() {
        return (zzbbp) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzbbq zzbbqVar, boolean z) {
        zzbbqVar.zzd |= 1;
        zzbbqVar.zze = z;
    }

    static /* synthetic */ void zze(zzbbq zzbbqVar, int i) {
        zzbbqVar.zzd |= 2;
        zzbbqVar.zzf = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbbq();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzbbp(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
