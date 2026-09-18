package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayj extends zzgtz implements zzgvk {
    private static final zzayj zzb;
    private int zzd;
    private int zze;
    private zzayn zzf;
    private zzayp zzg;

    static {
        zzayj zzayjVar = new zzayj();
        zzb = zzayjVar;
        zzgtz.zzaU(zzayj.class, zzayjVar);
    }

    private zzayj() {
    }

    public static zzayi zza() {
        return (zzayi) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzayj zzayjVar, zzayn zzaynVar) {
        zzaynVar.getClass();
        zzayjVar.zzf = zzaynVar;
        zzayjVar.zzd |= 2;
    }

    static /* synthetic */ void zze(zzayj zzayjVar, zzayp zzaypVar) {
        zzaypVar.getClass();
        zzayjVar.zzg = zzaypVar;
        zzayjVar.zzd |= 4;
    }

    static /* synthetic */ void zzf(zzayj zzayjVar, int i) {
        zzayjVar.zze = 1;
        zzayjVar.zzd = 1 | zzayjVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzayl.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzayj();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzayi(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
