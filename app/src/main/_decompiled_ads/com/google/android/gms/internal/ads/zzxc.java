package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxc extends zzxe implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    /* JADX WARN: Multi-variable type inference failed */
    public zzxc(int i, zzcx zzcxVar, int i2, zzww zzwwVar, int i3, String str) {
        int iZza;
        super(i, zzcxVar, i2);
        int i4 = 0;
        this.zzf = zzxi.zzn(i3, false);
        int i5 = this.zzd.zze;
        int i6 = zzwwVar.zzy;
        this.zzg = 1 == (i5 & 1);
        this.zzh = (i5 & 2) != 0;
        zzfvs zzfvsVarZzm = zzwwVar.zzw.isEmpty() ? zzfvs.zzm("") : zzwwVar.zzw;
        int i7 = 0;
        while (true) {
            if (i7 >= zzfvsVarZzm.size()) {
                i7 = Integer.MAX_VALUE;
                iZza = 0;
                break;
            }
            zzam zzamVar = this.zzd;
            String str2 = (String) zzfvsVarZzm.get(i7);
            boolean z = zzwwVar.zzz;
            iZza = zzxi.zza(zzamVar, str2, false);
            if (iZza > 0) {
                break;
            } else {
                i7++;
            }
        }
        this.zzi = i7;
        this.zzj = iZza;
        int i8 = this.zzd.zzf;
        int i9 = zzwwVar.zzx;
        int iBitCount = Integer.bitCount(0);
        this.zzk = iBitCount;
        int i10 = this.zzd.zzf;
        this.zzm = false;
        int iZza2 = zzxi.zza(this.zzd, str, zzxi.zzg(str) == null);
        this.zzl = iZza2;
        boolean z2 = iZza > 0 || (zzwwVar.zzw.isEmpty() && iBitCount > 0) || this.zzg || (this.zzh && iZza2 > 0);
        if (zzxi.zzn(i3, zzwwVar.zzR) && z2) {
            i4 = 1;
        }
        this.zze = i4;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxc zzxcVar) {
        zzfvh zzfvhVarZzb = zzfvh.zzj().zzd(this.zzf, zzxcVar.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzxcVar.zzi), zzfxb.zzc().zza()).zzb(this.zzj, zzxcVar.zzj).zzb(this.zzk, zzxcVar.zzk).zzd(this.zzg, zzxcVar.zzg).zzc(Boolean.valueOf(this.zzh), Boolean.valueOf(zzxcVar.zzh), this.zzj == 0 ? zzfxb.zzc() : zzfxb.zzc().zza()).zzb(this.zzl, zzxcVar.zzl);
        if (this.zzk == 0) {
            boolean z = zzxcVar.zzm;
            zzfvhVarZzb = zzfvhVarZzb.zze(false, false);
        }
        return zzfvhVarZzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final /* bridge */ /* synthetic */ boolean zzc(zzxe zzxeVar) {
        return false;
    }
}
