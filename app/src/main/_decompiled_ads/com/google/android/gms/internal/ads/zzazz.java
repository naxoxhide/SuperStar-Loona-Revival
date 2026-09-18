package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazz extends zzgtz implements zzgvk {
    private static final zzazz zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzazz zzazzVar = new zzazz();
        zzb = zzazzVar;
        zzgtz.zzaU(zzazz.class, zzazzVar);
    }

    private zzazz() {
    }

    public static zzazs zza() {
        return (zzazs) zzb.zzaA();
    }

    public static zzazz zzd() {
        return zzb;
    }

    static /* synthetic */ void zzi(zzazz zzazzVar, int i) {
        zzazzVar.zze = i - 1;
        zzazzVar.zzd |= 1;
    }

    static /* synthetic */ void zzj(zzazz zzazzVar, int i) {
        zzazzVar.zzf = i - 1;
        zzazzVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzazx.zza, "zzf", zzazu.zza});
        }
        if (i2 == 3) {
            return new zzazz();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzazs(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zze() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzf() {
        return (this.zzd & 1) != 0;
    }

    public final int zzg() {
        int iZza = zzazv.zza(this.zzf);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzh() {
        int iZza = zzazy.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }
}
