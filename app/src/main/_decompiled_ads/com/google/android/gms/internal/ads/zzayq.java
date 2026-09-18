package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayq extends zzgtz implements zzgvk {
    private static final zzayq zzb;
    private zzgui zzd = zzaN();

    static {
        zzayq zzayqVar = new zzayq();
        zzb = zzayqVar;
        zzgtz.zzaU(zzayq.class, zzayqVar);
    }

    private zzayq() {
    }

    public static zzayk zza() {
        return (zzayk) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzayq zzayqVar, zzayj zzayjVar) {
        zzayjVar.getClass();
        zzgui zzguiVar = zzayqVar.zzd;
        if (!zzguiVar.zzc()) {
            zzayqVar.zzd = zzgtz.zzaO(zzguiVar);
        }
        zzayqVar.zzd.add(zzayjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzayj.class});
        }
        if (i2 == 3) {
            return new zzayq();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzayk(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
