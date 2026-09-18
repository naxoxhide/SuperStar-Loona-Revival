package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahl {
    public final zzacs zza;
    public zzahy zzd;
    public zzahh zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private boolean zzl;
    public final zzahx zzb = new zzahx();
    public final zzfb zzc = new zzfb();
    private final zzfb zzj = new zzfb(1);
    private final zzfb zzk = new zzfb();

    public zzahl(zzacs zzacsVar, zzahy zzahyVar, zzahh zzahhVar) {
        this.zza = zzacsVar;
        this.zzd = zzahyVar;
        this.zze = zzahhVar;
        zzh(zzahyVar, zzahhVar);
    }

    public final int zza() {
        int i;
        if (this.zzl) {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        } else {
            i = this.zzd.zzg[this.zzf];
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        return !this.zzl ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzfb zzfbVar;
        zzahw zzahwVarZzf = zzf();
        if (zzahwVarZzf == null) {
            return 0;
        }
        int i3 = zzahwVarZzf.zzd;
        if (i3 != 0) {
            zzfbVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzahwVarZzf.zze;
            int i4 = zzfk.zza;
            zzfb zzfbVar2 = this.zzk;
            int length = bArr.length;
            zzfbVar2.zzE(bArr, length);
            zzfbVar = this.zzk;
            i3 = length;
        }
        boolean zZzb = this.zzb.zzb(this.zzf);
        boolean z = zZzb || i2 != 0;
        zzfb zzfbVar3 = this.zzj;
        zzfbVar3.zzI()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzfbVar3.zzG(0);
        this.zza.zzs(this.zzj, 1, 1);
        this.zza.zzs(zzfbVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zZzb) {
            this.zzc.zzD(8);
            zzfb zzfbVar4 = this.zzc;
            byte[] bArrZzI = zzfbVar4.zzI();
            bArrZzI[0] = 0;
            bArrZzI[1] = 1;
            bArrZzI[2] = 0;
            bArrZzI[3] = (byte) i2;
            bArrZzI[4] = (byte) ((i >> 24) & 255);
            bArrZzI[5] = (byte) ((i >> 16) & 255);
            bArrZzI[6] = (byte) ((i >> 8) & 255);
            bArrZzI[7] = (byte) (i & 255);
            this.zza.zzs(zzfbVar4, 8, 1);
            return i3 + 9;
        }
        int i5 = i3 + 1;
        zzfb zzfbVar5 = this.zzb.zzn;
        int iZzp = zzfbVar5.zzp();
        zzfbVar5.zzH(-2);
        int i6 = (iZzp * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzD(i6);
            byte[] bArrZzI2 = this.zzc.zzI();
            zzfbVar5.zzC(bArrZzI2, 0, i6);
            int i7 = (((bArrZzI2[2] & 255) << 8) | (bArrZzI2[3] & 255)) + i2;
            bArrZzI2[2] = (byte) ((i7 >> 8) & 255);
            bArrZzI2[3] = (byte) (i7 & 255);
            zzfbVar5 = this.zzc;
        }
        this.zza.zzs(zzfbVar5, i6, 1);
        return i5 + i6;
    }

    public final long zzd() {
        return !this.zzl ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzahx zzahxVar = this.zzb;
        return zzahxVar.zzi[this.zzf];
    }

    public final zzahw zzf() {
        if (!this.zzl) {
            return null;
        }
        zzahh zzahhVar = this.zzb.zza;
        int i = zzfk.zza;
        int i2 = zzahhVar.zza;
        zzahw zzahwVarZza = this.zzb.zzm;
        if (zzahwVarZza == null) {
            zzahwVarZza = this.zzd.zza.zza(i2);
        }
        if (zzahwVarZza == null || !zzahwVarZza.zza) {
            return null;
        }
        return zzahwVarZza;
    }

    public final void zzh(zzahy zzahyVar, zzahh zzahhVar) {
        this.zzd = zzahyVar;
        this.zze = zzahhVar;
        this.zza.zzl(zzahyVar.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzahx zzahxVar = this.zzb;
        zzahxVar.zzd = 0;
        zzahxVar.zzp = 0L;
        zzahxVar.zzq = false;
        zzahxVar.zzk = false;
        zzahxVar.zzo = false;
        zzahxVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
