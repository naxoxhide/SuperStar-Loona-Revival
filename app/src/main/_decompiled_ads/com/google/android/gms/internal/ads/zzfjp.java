package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjp extends zzgtz implements zzgvk {
    private static final zzfjp zzb;
    private zzgui zzd = zzaN();

    static {
        zzfjp zzfjpVar = new zzfjp();
        zzb = zzfjpVar;
        zzgtz.zzaU(zzfjp.class, zzfjpVar);
    }

    private zzfjp() {
    }

    public static zzfjm zzc() {
        return (zzfjm) zzb.zzaA();
    }

    static /* synthetic */ void zzf(zzfjp zzfjpVar, zzfjo zzfjoVar) {
        zzfjoVar.getClass();
        zzgui zzguiVar = zzfjpVar.zzd;
        if (!zzguiVar.zzc()) {
            zzfjpVar.zzd = zzgtz.zzaO(zzguiVar);
        }
        zzfjpVar.zzd.add(zzfjoVar);
    }

    public final int zza() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfjo.class});
        }
        if (i2 == 3) {
            return new zzfjp();
        }
        zzfjl zzfjlVar = null;
        if (i2 == 4) {
            return new zzfjm(zzfjlVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
