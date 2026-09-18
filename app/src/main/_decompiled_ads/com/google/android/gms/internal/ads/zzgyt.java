package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgyt extends zzgtz implements zzgvk {
    private static final zzgyt zzb;
    private int zzd;
    private zzgys zze;
    private int zzi;
    private byte zzj = 2;
    private zzgui zzf = zzaN();
    private zzgsr zzg = zzgsr.zzb;
    private zzgsr zzh = zzgsr.zzb;

    static {
        zzgyt zzgytVar = new zzgyt();
        zzb = zzgytVar;
        zzgtz.zzaU(zzgyt.class, zzgytVar);
    }

    private zzgyt() {
    }

    public static zzgyq zza() {
        return (zzgyq) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgyt zzgytVar, zzgyp zzgypVar) {
        zzgypVar.getClass();
        zzgui zzguiVar = zzgytVar.zzf;
        if (!zzguiVar.zzc()) {
            zzgytVar.zzf = zzgtz.zzaO(zzguiVar);
        }
        zzgytVar.zzf.add(zzgypVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzd", "zze", "zzf", zzgyp.class, "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzgyt();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgyq(zzgxtVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
