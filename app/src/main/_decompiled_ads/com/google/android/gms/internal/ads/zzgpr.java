package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpr extends zzgtz implements zzgvk {
    private static final zzgpr zzb;
    private int zzd;
    private zzgui zze = zzaN();

    static {
        zzgpr zzgprVar = new zzgpr();
        zzb = zzgprVar;
        zzgtz.zzaU(zzgpr.class, zzgprVar);
    }

    private zzgpr() {
    }

    public static zzgpo zza() {
        return (zzgpo) zzb.zzaA();
    }

    static /* synthetic */ void zze(zzgpr zzgprVar, zzgpq zzgpqVar) {
        zzgpqVar.getClass();
        zzgui zzguiVar = zzgprVar.zze;
        if (!zzguiVar.zzc()) {
            zzgprVar.zze = zzgtz.zzaO(zzguiVar);
        }
        zzgprVar.zze.add(zzgpqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzgpq.class});
        }
        if (i2 == 3) {
            return new zzgpr();
        }
        zzgpn zzgpnVar = null;
        if (i2 == 4) {
            return new zzgpo(zzgpnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
