package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayp extends zzgtz implements zzgvk {
    private static final zzayp zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzayp zzaypVar = new zzayp();
        zzb = zzaypVar;
        zzgtz.zzaU(zzayp.class, zzaypVar);
    }

    private zzayp() {
    }

    public static zzayo zza() {
        return (zzayo) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzayp zzaypVar, boolean z) {
        zzaypVar.zzd |= 1;
        zzaypVar.zze = z;
    }

    static /* synthetic */ void zze(zzayp zzaypVar, boolean z) {
        zzaypVar.zzd |= 2;
        zzaypVar.zzf = z;
    }

    static /* synthetic */ void zzf(zzayp zzaypVar, int i) {
        zzaypVar.zzd |= 4;
        zzaypVar.zzg = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzayp();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzayo(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
