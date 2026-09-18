package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzwq extends zzxe implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzww zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    /* JADX WARN: Code duplicated, block: B:70:0x0130  */
    /* JADX WARN: Multi-variable type inference failed */
    public zzwq(int i, zzcx zzcxVar, int i2, zzww zzwwVar, int i3, boolean z, zzfsx zzfsxVar) {
        int i4;
        int iZza;
        int iZza2;
        boolean z2;
        super(i, zzcxVar, i2);
        this.zzh = zzwwVar;
        this.zzg = zzxi.zzg(this.zzd.zzd);
        int i5 = 0;
        this.zzi = zzxi.zzn(i3, false);
        int i6 = 0;
        while (true) {
            i4 = Integer.MAX_VALUE;
            if (i6 >= zzwwVar.zzq.size()) {
                iZza = 0;
                i6 = Integer.MAX_VALUE;
                break;
            } else {
                iZza = zzxi.zza(this.zzd, (String) zzwwVar.zzq.get(i6), false);
                if (iZza > 0) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        this.zzk = i6;
        this.zzj = iZza;
        int i7 = this.zzd.zzf;
        int i8 = zzwwVar.zzr;
        this.zzl = Integer.bitCount(0);
        zzam zzamVar = this.zzd;
        int i9 = zzamVar.zzf;
        this.zzm = true;
        this.zzp = 1 == (zzamVar.zze & 1);
        this.zzq = zzamVar.zzz;
        this.zzr = zzamVar.zzA;
        this.zzs = zzamVar.zzi;
        if (zzamVar.zzi != -1) {
            int i10 = zzwwVar.zzt;
        }
        if (zzamVar.zzz != -1) {
            int i11 = zzwwVar.zzs;
        }
        this.zzf = zzfsxVar.zza(zzamVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = zzfk.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{zzfk.zzz(configuration.locale)};
        for (int i12 = 0; i12 < strArrSplit.length; i12++) {
            strArrSplit[i12] = zzfk.zzB(strArrSplit[i12]);
        }
        int i13 = 0;
        while (true) {
            if (i13 >= strArrSplit.length) {
                iZza2 = 0;
                i13 = Integer.MAX_VALUE;
                break;
            } else {
                iZza2 = zzxi.zza(this.zzd, strArrSplit[i13], false);
                if (iZza2 > 0) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        this.zzn = i13;
        this.zzo = iZza2;
        for (int i14 = 0; i14 < zzwwVar.zzu.size(); i14++) {
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzwwVar.zzu.get(i14))) {
                i4 = i14;
                break;
            }
        }
        this.zzt = i4;
        this.zzu = (i3 & 384) == 128;
        this.zzv = (i3 & 64) == 64;
        zzww zzwwVar2 = this.zzh;
        if (zzxi.zzn(i3, zzwwVar2.zzR) && ((z2 = this.zzf) || zzwwVar2.zzL)) {
            int i15 = zzwwVar.zzv;
            if (zzxi.zzn(i3, false) && z2 && this.zzd.zzi != -1) {
                boolean z3 = zzwwVar2.zzB;
                boolean z4 = zzwwVar2.zzA;
                if (zzwwVar2.zzT || !z) {
                    i5 = 2;
                } else {
                    i5 = 1;
                }
            } else {
                i5 = 1;
            }
        }
        this.zze = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final /* bridge */ /* synthetic */ boolean zzc(zzxe zzxeVar) {
        zzww zzwwVar = this.zzh;
        zzwq zzwqVar = (zzwq) zzxeVar;
        boolean z = zzwwVar.zzO;
        zzam zzamVar = this.zzd;
        int i = zzamVar.zzz;
        if (i == -1) {
            return false;
        }
        zzam zzamVar2 = zzwqVar.zzd;
        if (i != zzamVar2.zzz) {
            return false;
        }
        boolean z2 = zzwwVar.zzM;
        String str = zzamVar.zzm;
        if (str == null || !TextUtils.equals(str, zzamVar2.zzm)) {
            return false;
        }
        zzww zzwwVar2 = this.zzh;
        boolean z3 = zzwwVar2.zzN;
        int i2 = this.zzd.zzA;
        if (i2 == -1 || i2 != zzwqVar.zzd.zzA) {
            return false;
        }
        boolean z4 = zzwwVar2.zzP;
        return this.zzu == zzwqVar.zzu && this.zzv == zzwqVar.zzv;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzwq zzwqVar) {
        zzfxb zzfxbVarZza = (this.zzf && this.zzi) ? zzxi.zzc : zzxi.zzc.zza();
        zzfvh zzfvhVarZzd = zzfvh.zzj().zzd(this.zzi, zzwqVar.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzwqVar.zzk), zzfxb.zzc().zza()).zzb(this.zzj, zzwqVar.zzj).zzb(this.zzl, zzwqVar.zzl).zzd(this.zzp, zzwqVar.zzp);
        boolean z = zzwqVar.zzm;
        zzfvh zzfvhVarZzc = zzfvhVarZzd.zzd(true, true).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzwqVar.zzn), zzfxb.zzc().zza()).zzb(this.zzo, zzwqVar.zzo).zzd(this.zzf, zzwqVar.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzwqVar.zzt), zzfxb.zzc().zza());
        Integer numValueOf = Integer.valueOf(this.zzs);
        Integer numValueOf2 = Integer.valueOf(zzwqVar.zzs);
        boolean z2 = this.zzh.zzA;
        zzfvh zzfvhVarZzc2 = zzfvhVarZzc.zzc(numValueOf, numValueOf2, zzxi.zzd).zzd(this.zzu, zzwqVar.zzu).zzd(this.zzv, zzwqVar.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzwqVar.zzq), zzfxbVarZza).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzwqVar.zzr), zzfxbVarZza);
        Integer numValueOf3 = Integer.valueOf(this.zzs);
        Integer numValueOf4 = Integer.valueOf(zzwqVar.zzs);
        if (!zzfk.zzE(this.zzg, zzwqVar.zzg)) {
            zzfxbVarZza = zzxi.zzd;
        }
        return zzfvhVarZzc2.zzc(numValueOf3, numValueOf4, zzfxbVarZza).zza();
    }
}
