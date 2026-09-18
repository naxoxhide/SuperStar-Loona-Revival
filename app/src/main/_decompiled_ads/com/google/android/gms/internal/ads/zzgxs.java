package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgxs extends zzgtz implements zzgvk {
    private static final zzgxs zzb;
    private zzgui zzd = zzaN();

    static {
        zzgxs zzgxsVar = new zzgxs();
        zzb = zzgxsVar;
        zzgtz.zzaU(zzgxs.class, zzgxsVar);
    }

    private zzgxs() {
    }

    public static zzgxr zza() {
        return (zzgxr) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgxs zzgxsVar, zzgxq zzgxqVar) {
        zzgxqVar.getClass();
        zzgui zzguiVar = zzgxsVar.zzd;
        if (!zzguiVar.zzc()) {
            zzgxsVar.zzd = zzgtz.zzaO(zzguiVar);
        }
        zzgxsVar.zzd.add(zzgxqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgxq.class});
        }
        if (i2 == 3) {
            return new zzgxs();
        }
        zzgxo zzgxoVar = null;
        if (i2 == 4) {
            return new zzgxr(zzgxoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
