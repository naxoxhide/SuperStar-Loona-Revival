package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazl extends zzgtz implements zzgvk {
    private static final zzazl zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private zzbav zzi;
    private zzazd zzk;
    private zzazg zzl;
    private zzazz zzm;
    private zzayh zzn;
    private zzbaj zzo;
    private zzbbq zzp;
    private zzayq zzq;
    private String zzf = "";
    private int zzh = 1000;
    private zzguh zzj = zzaL();

    static {
        zzazl zzazlVar = new zzazl();
        zzb = zzazlVar;
        zzgtz.zzaU(zzazl.class, zzazlVar);
    }

    private zzazl() {
    }

    public static zzazk zzd() {
        return (zzazk) zzb.zzaA();
    }

    static /* synthetic */ void zzg(zzazl zzazlVar, String str) {
        str.getClass();
        zzazlVar.zzd |= 2;
        zzazlVar.zzf = str;
    }

    static /* synthetic */ void zzh(zzazl zzazlVar, Iterable iterable) {
        zzguh zzguhVar = zzazlVar.zzj;
        if (!zzguhVar.zzc()) {
            zzazlVar.zzj = zzgtz.zzaM(zzguhVar);
        }
        zzgsa.zzav(iterable, zzazlVar.zzj);
    }

    static /* synthetic */ void zzj(zzazl zzazlVar, zzazd zzazdVar) {
        zzazdVar.getClass();
        zzazlVar.zzk = zzazdVar;
        zzazlVar.zzd |= 32;
    }

    static /* synthetic */ void zzk(zzazl zzazlVar, zzayh zzayhVar) {
        zzayhVar.getClass();
        zzazlVar.zzn = zzayhVar;
        zzazlVar.zzd |= 256;
    }

    static /* synthetic */ void zzl(zzazl zzazlVar, zzbaj zzbajVar) {
        zzbajVar.getClass();
        zzazlVar.zzo = zzbajVar;
        zzazlVar.zzd |= 512;
    }

    static /* synthetic */ void zzm(zzazl zzazlVar, zzbbq zzbbqVar) {
        zzbbqVar.getClass();
        zzazlVar.zzp = zzbbqVar;
        zzazlVar.zzd |= 1024;
    }

    static /* synthetic */ void zzn(zzazl zzazlVar, zzayq zzayqVar) {
        zzayqVar.getClass();
        zzazlVar.zzq = zzayqVar;
        zzazlVar.zzd |= 2048;
    }

    public final zzayh zza() {
        zzayh zzayhVar = this.zzn;
        return zzayhVar == null ? zzayh.zzc() : zzayhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\f᠌\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzazi.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
        }
        if (i2 == 3) {
            return new zzazl();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzazk(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzazd zzc() {
        zzazd zzazdVar = this.zzk;
        return zzazdVar == null ? zzazd.zzc() : zzazdVar;
    }

    public final String zzf() {
        return this.zzf;
    }
}
