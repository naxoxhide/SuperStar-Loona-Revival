package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbav extends zzgtz implements zzgvk {
    private static final zzbav zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbav zzbavVar = new zzbav();
        zzb = zzbavVar;
        zzgtz.zzaU(zzbav.class, zzbavVar);
    }

    private zzbav() {
    }

    public static zzbau zza() {
        return (zzbau) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzbav zzbavVar, int i) {
        zzbavVar.zzd |= 1;
        zzbavVar.zze = i;
    }

    static /* synthetic */ void zze(zzbav zzbavVar, int i) {
        zzbavVar.zzd |= 2;
        zzbavVar.zzf = i;
    }

    static /* synthetic */ void zzf(zzbav zzbavVar, int i) {
        zzbavVar.zzd |= 4;
        zzbavVar.zzg = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbav();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzbau(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
