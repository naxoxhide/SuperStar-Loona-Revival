package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgzt extends zzgtz implements zzgvk {
    private static final zzgzt zzb;
    private int zzd;
    private long zzf;
    private boolean zzg;
    private int zzh;
    private String zze = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzgzt zzgztVar = new zzgzt();
        zzb = zzgztVar;
        zzgtz.zzaU(zzgzt.class, zzgztVar);
    }

    private zzgzt() {
    }

    public static zzgzs zza() {
        return (zzgzs) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgzt zzgztVar, String str) {
        zzgztVar.zzd |= 1;
        zzgztVar.zze = str;
    }

    static /* synthetic */ void zze(zzgzt zzgztVar, long j) {
        zzgztVar.zzd |= 2;
        zzgztVar.zzf = j;
    }

    static /* synthetic */ void zzf(zzgzt zzgztVar, boolean z) {
        zzgztVar.zzd |= 4;
        zzgztVar.zzg = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzgzu.zza, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzgzt();
        }
        zzgxt zzgxtVar = null;
        if (i2 == 4) {
            return new zzgzs(zzgxtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
