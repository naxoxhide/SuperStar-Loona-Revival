package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgyx extends zzgtz implements zzgvk {
    private static final zzgyx zzb;
    private int zzd;
    private zzgyw zze;
    private zzgsr zzh;
    private int zzi;
    private zzgsr zzj;
    private byte zzk = 2;
    private zzgui zzf = zzaN();
    private zzgsr zzg = zzgsr.zzb;

    static {
        zzgyx zzgyxVar = new zzgyx();
        zzb = zzgyxVar;
        zzgtz.zzaU(zzgyx.class, zzgyxVar);
    }

    private zzgyx() {
        zzgsr zzgsrVar = zzgsr.zzb;
        this.zzh = zzgsrVar;
        this.zzj = zzgsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzd", "zze", "zzf", zzgyp.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzgyx();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgyu(zzgxtVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
