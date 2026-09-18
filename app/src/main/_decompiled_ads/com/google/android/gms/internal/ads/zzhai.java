package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhai extends zzgtz implements zzgvk {
    private static final zzhai zzb;
    private int zzd;
    private boolean zzk;
    private double zzl;
    private int zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private String zze = "";
    private String zzf = "";
    private int zzg = 4;
    private zzgui zzh = zzgtz.zzaN();
    private String zzi = "";
    private String zzj = "";
    private zzgui zzm = zzaN();

    static {
        zzhai zzhaiVar = new zzhai();
        zzb = zzhaiVar;
        zzgtz.zzaU(zzhai.class, zzhaiVar);
    }

    private zzhai() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zzd", "zze", "zzg", zzhah.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzhag.class, "zzf", "zzn", zzhae.zza, "zzo", "zzp", "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new zzhai();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzhad(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
