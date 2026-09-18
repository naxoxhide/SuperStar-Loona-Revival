package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaoc extends zzgtz implements zzgvk {
    private static final zzaoc zzb;
    private int zzd;
    private long zzf;
    private long zzj;
    private long zzk;
    private long zzm;
    private int zzq;
    private String zze = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzl = "";
    private String zzn = "";
    private String zzo = "";
    private zzgui zzp = zzaN();

    static {
        zzaoc zzaocVar = new zzaoc();
        zzb = zzaocVar;
        zzgtz.zzaU(zzaoc.class, zzaocVar);
    }

    private zzaoc() {
    }

    public static zzany zza() {
        return (zzany) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzaoc zzaocVar, long j) {
        zzaocVar.zzd |= 2;
        zzaocVar.zzf = j;
    }

    static /* synthetic */ void zze(zzaoc zzaocVar, String str) {
        str.getClass();
        zzaocVar.zzd |= 4;
        zzaocVar.zzg = str;
    }

    static /* synthetic */ void zzf(zzaoc zzaocVar, String str) {
        str.getClass();
        zzaocVar.zzd |= 8;
        zzaocVar.zzh = str;
    }

    static /* synthetic */ void zzg(zzaoc zzaocVar, String str) {
        zzaocVar.zzd |= 16;
        zzaocVar.zzi = str;
    }

    static /* synthetic */ void zzh(zzaoc zzaocVar, String str) {
        zzaocVar.zzd |= 1024;
        zzaocVar.zzo = str;
    }

    static /* synthetic */ void zzi(zzaoc zzaocVar, String str) {
        str.getClass();
        zzaocVar.zzd |= 1;
        zzaocVar.zze = str;
    }

    static /* synthetic */ void zzj(zzaoc zzaocVar, int i) {
        zzaocVar.zzq = i - 1;
        zzaocVar.zzd |= 2048;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzaoa.class, "zzq", zzaob.zza});
        }
        if (i2 == 3) {
            return new zzaoc();
        }
        zzanx zzanxVar = null;
        if (i2 == 4) {
            return new zzany(zzanxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
