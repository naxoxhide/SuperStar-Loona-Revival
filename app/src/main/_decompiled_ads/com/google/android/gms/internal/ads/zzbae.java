package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbae extends zzgtz implements zzgvk {
    private static final zzguf zzb = new zzbac();
    private static final zzbae zzd;
    private int zze;
    private long zzf;
    private int zzg;
    private long zzh;
    private long zzi;
    private zzgue zzj = zzaJ();
    private zzazz zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private long zzr;

    static {
        zzbae zzbaeVar = new zzbae();
        zzd = zzbaeVar;
        zzgtz.zzaU(zzbae.class, zzbaeVar);
    }

    private zzbae() {
    }

    static /* synthetic */ void zzA(zzbae zzbaeVar, int i) {
        zzbaeVar.zzm = i - 1;
        zzbaeVar.zze |= 64;
    }

    static /* synthetic */ void zzB(zzbae zzbaeVar, int i) {
        zzbaeVar.zzn = i - 1;
        zzbaeVar.zze |= 128;
    }

    static /* synthetic */ void zzC(zzbae zzbaeVar, int i) {
        zzbaeVar.zzp = i - 1;
        zzbaeVar.zze |= 512;
    }

    public static zzbad zzg() {
        return (zzbad) zzd.zzaA();
    }

    public static zzbae zzi(byte[] bArr) throws zzgul {
        return (zzbae) zzgtz.zzaF(zzd, bArr);
    }

    static /* synthetic */ void zzl(zzbae zzbaeVar, long j) {
        zzbaeVar.zze |= 1;
        zzbaeVar.zzf = j;
    }

    static /* synthetic */ void zzm(zzbae zzbaeVar, long j) {
        zzbaeVar.zze |= 4;
        zzbaeVar.zzh = j;
    }

    static /* synthetic */ void zzn(zzbae zzbaeVar, long j) {
        zzbaeVar.zze |= 8;
        zzbaeVar.zzi = j;
    }

    static /* synthetic */ void zzo(zzbae zzbaeVar, Iterable iterable) {
        zzgue zzgueVar = zzbaeVar.zzj;
        if (!zzgueVar.zzc()) {
            zzbaeVar.zzj = zzgtz.zzaK(zzgueVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzbaeVar.zzj.zzh(((zzayt) it.next()).zza());
        }
    }

    static /* synthetic */ void zzp(zzbae zzbaeVar, zzazz zzazzVar) {
        zzazzVar.getClass();
        zzbaeVar.zzk = zzazzVar;
        zzbaeVar.zze |= 16;
    }

    static /* synthetic */ void zzq(zzbae zzbaeVar, int i) {
        zzbaeVar.zze |= 256;
        zzbaeVar.zzo = i;
    }

    static /* synthetic */ void zzr(zzbae zzbaeVar, zzbai zzbaiVar) {
        zzbaeVar.zzq = zzbaiVar.zza();
        zzbaeVar.zze |= 1024;
    }

    static /* synthetic */ void zzs(zzbae zzbaeVar, long j) {
        zzbaeVar.zze |= 2048;
        zzbaeVar.zzr = j;
    }

    static /* synthetic */ void zzy(zzbae zzbaeVar, int i) {
        zzbaeVar.zzg = i - 1;
        zzbaeVar.zze |= 2;
    }

    static /* synthetic */ void zzz(zzbae zzbaeVar, int i) {
        zzbaeVar.zzl = i - 1;
        zzbaeVar.zze |= 32;
    }

    public final int zza() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzgtz
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgud zzgudVar = zzazi.zza;
            return zzaR(zzd, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ࠞ\u0006ဉ\u0004\u0007᠌\u0005\b᠌\u0006\t᠌\u0007\nင\b\u000b᠌\t\f᠌\n\rဂ\u000b", new Object[]{"zze", "zzf", "zzg", zzazi.zza, "zzh", "zzi", "zzj", zzays.zza, "zzk", "zzl", zzgudVar, "zzm", zzgudVar, "zzn", zzgudVar, "zzo", "zzp", zzgudVar, "zzq", zzbah.zza, "zzr"});
        }
        if (i2 == 3) {
            return new zzbae();
        }
        zzayc zzaycVar = null;
        if (i2 == 4) {
            return new zzbad(zzaycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzd;
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzazz zzf() {
        zzazz zzazzVar = this.zzk;
        return zzazzVar == null ? zzazz.zzd() : zzazzVar;
    }

    public final zzbai zzj() {
        zzbai zzbaiVarZzb = zzbai.zzb(this.zzq);
        return zzbaiVarZzb == null ? zzbai.UNSPECIFIED : zzbaiVarZzb;
    }

    public final List zzk() {
        return new zzgug(this.zzj, zzb);
    }

    public final int zzt() {
        int iZza = zzazj.zza(this.zzm);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzu() {
        int iZza = zzazj.zza(this.zzn);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzv() {
        int iZza = zzazj.zza(this.zzp);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzw() {
        int iZza = zzazj.zza(this.zzg);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzx() {
        int iZza = zzazj.zza(this.zzl);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }
}
