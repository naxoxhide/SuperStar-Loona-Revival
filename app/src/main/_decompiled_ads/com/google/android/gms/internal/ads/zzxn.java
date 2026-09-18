package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxn extends zzxq {
    private zzxm zza;

    protected abstract Pair zzb(zzxm zzxmVar, int[][][] iArr, int[] iArr2, zztw zztwVar, zzcv zzcvVar) throws zzil;

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxr zzo(zzlt[] zzltVarArr, zzvx zzvxVar, zztw zztwVar, zzcv zzcvVar) throws zzil {
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzcx[][] zzcxVarArr = new zzcx[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzvxVar.zzc;
            zzcxVarArr[i] = new zzcx[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzltVarArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzvxVar.zzc) {
            zzcx zzcxVarZzb = zzvxVar.zzb(i5);
            int i6 = zzcxVarZzb.zzd;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzlt zzltVar = zzltVarArr[i8];
                int i10 = 0;
                int iMax = 0;
                while (true) {
                    int i11 = zzcxVarZzb.zzb;
                    if (i10 > 0) {
                        break;
                    }
                    iMax = Math.max(iMax, zzltVar.zzV(zzcxVarZzb.zzb(i10)) & 7);
                    i10++;
                }
                boolean z3 = iArr2[i8] == 0;
                if (iMax > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = iMax;
                } else if (iMax == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = iMax;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                int i12 = zzcxVarZzb.zzb;
                iArr = new int[1];
            } else {
                zzlt zzltVar2 = zzltVarArr[i7];
                int i13 = zzcxVarZzb.zzb;
                int[] iArr5 = new int[1];
                int i14 = 0;
                while (true) {
                    int i15 = zzcxVarZzb.zzb;
                    if (i14 > 0) {
                        break;
                    }
                    iArr5[i14] = zzltVar2.zzV(zzcxVarZzb.zzb(i14));
                    i14++;
                }
                iArr = iArr5;
            }
            int i16 = iArr2[i7];
            zzcxVarArr[i7][i16] = zzcxVarZzb;
            iArr3[i7][i16] = iArr;
            iArr2[i7] = i16 + 1;
            i5++;
            i3 = 2;
        }
        zzvx[] zzvxVarArr = new zzvx[i3];
        String[] strArr = new String[i3];
        int[] iArr6 = new int[i3];
        int i17 = 0;
        while (i17 < i3) {
            int i18 = iArr2[i17];
            zzvxVarArr[i17] = new zzvx((zzcx[]) zzfk.zzJ(zzcxVarArr[i17], i18));
            iArr3[i17] = (int[][]) zzfk.zzJ(iArr3[i17], i18);
            strArr[i17] = zzltVarArr[i17].zzR();
            iArr6[i17] = zzltVarArr[i17].zzb();
            i17++;
            i3 = 2;
        }
        int i19 = i3;
        zzxm zzxmVar = new zzxm(strArr, iArr6, zzvxVarArr, iArr4, iArr3, new zzvx((zzcx[]) zzfk.zzJ(zzcxVarArr[i19], iArr2[i19])));
        Pair pairZzb = zzb(zzxmVar, iArr3, iArr4, zztwVar, zzcvVar);
        zzxo[] zzxoVarArr = (zzxo[]) pairZzb.second;
        List[] listArr = new List[zzxoVarArr.length];
        for (int i20 = 0; i20 < zzxoVarArr.length; i20++) {
            zzxo zzxoVar = zzxoVarArr[i20];
            listArr[i20] = zzxoVar != null ? zzfvs.zzm(zzxoVar) : zzfvs.zzl();
        }
        zzfvp zzfvpVar = new zzfvp();
        for (int i21 = 0; i21 < 2; i21++) {
            zzvx zzvxVarZzd = zzxmVar.zzd(i21);
            List list = listArr[i21];
            for (int i22 = 0; i22 < zzvxVarZzd.zzc; i22++) {
                zzcx zzcxVarZzb2 = zzvxVarZzd.zzb(i22);
                boolean z4 = zzxmVar.zza(i21, i22, false) != 0;
                int i23 = zzcxVarZzb2.zzb;
                int[] iArr7 = new int[1];
                boolean[] zArr = new boolean[1];
                int i24 = 0;
                while (true) {
                    int i25 = zzcxVarZzb2.zzb;
                    if (i24 <= 0) {
                        iArr7[i24] = zzxmVar.zzb(i21, i22, i24) & 7;
                        int i26 = 0;
                        while (true) {
                            if (i26 >= list.size()) {
                                z = false;
                                break;
                            }
                            zzxo zzxoVar2 = (zzxo) list.get(i26);
                            if (zzxoVar2.zze().equals(zzcxVarZzb2) && zzxoVar2.zzb(i24) != -1) {
                                z = true;
                                break;
                            }
                            i26++;
                        }
                        zArr[i24] = z;
                        i24++;
                    }
                }
                zzfvpVar.zzf(new zzdf(zzcxVarZzb2, z4, iArr7, zArr));
            }
        }
        zzvx zzvxVarZze = zzxmVar.zze();
        for (int i27 = 0; i27 < zzvxVarZze.zzc; i27++) {
            zzcx zzcxVarZzb3 = zzvxVarZze.zzb(i27);
            int i28 = zzcxVarZzb3.zzb;
            int[] iArr8 = new int[1];
            Arrays.fill(iArr8, 0);
            int i29 = zzcxVarZzb3.zzb;
            zzfvpVar.zzf(new zzdf(zzcxVarZzb3, false, iArr8, new boolean[1]));
        }
        return new zzxr((zzlu[]) pairZzb.first, (zzxk[]) pairZzb.second, new zzdg(zzfvpVar.zzi()), zzxmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzp(Object obj) {
        this.zza = (zzxm) obj;
    }
}
