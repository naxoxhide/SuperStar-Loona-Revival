package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacd {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final float zzf;
    public final String zzg;

    private zzacd(List list, int i, int i2, int i3, int i4, int i5, int i6, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = f;
        this.zzg = str;
    }

    public static zzacd zza(zzfb zzfbVar) throws zzcc {
        try {
            zzfbVar.zzH(21);
            int iZzl = zzfbVar.zzl() & 3;
            int iZzl2 = zzfbVar.zzl();
            int iZzc = zzfbVar.zzc();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < iZzl2; i3++) {
                zzfbVar.zzH(1);
                int iZzp = zzfbVar.zzp();
                for (int i4 = 0; i4 < iZzp; i4++) {
                    int iZzp2 = zzfbVar.zzp();
                    i2 += iZzp2 + 4;
                    zzfbVar.zzH(iZzp2);
                }
            }
            zzfbVar.zzG(iZzc);
            byte[] bArr = new byte[i2];
            String strZzb = null;
            float f = 1.0f;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = 0;
            int i11 = 0;
            while (i10 < iZzl2) {
                int iZzl3 = zzfbVar.zzl() & 63;
                int iZzp3 = zzfbVar.zzp();
                int i12 = i;
                while (i12 < iZzp3) {
                    int iZzp4 = zzfbVar.zzp();
                    int i13 = iZzl2;
                    System.arraycopy(zzfy.zza, i, bArr, i11, 4);
                    int i14 = i11 + 4;
                    System.arraycopy(zzfbVar.zzI(), zzfbVar.zzc(), bArr, i14, iZzp4);
                    int i15 = i14 + iZzp4;
                    if (iZzl3 == 33 && i12 == 0) {
                        zzfv zzfvVarZzc = zzfy.zzc(bArr, i14 + 2, i15);
                        i5 = zzfvVarZzc.zzg;
                        i6 = zzfvVarZzc.zzh;
                        i7 = zzfvVarZzc.zzj;
                        int i16 = zzfvVarZzc.zzk;
                        int i17 = zzfvVarZzc.zzl;
                        float f2 = zzfvVarZzc.zzi;
                        strZzb = zzdz.zzb(zzfvVarZzc.zza, zzfvVarZzc.zzb, zzfvVarZzc.zzc, zzfvVarZzc.zzd, zzfvVarZzc.zze, zzfvVarZzc.zzf);
                        f = f2;
                        i8 = i16;
                        i9 = i17;
                        i12 = 0;
                    }
                    zzfbVar.zzH(iZzp4);
                    i12++;
                    iZzl2 = i13;
                    i11 = i15;
                    iZzl3 = iZzl3;
                    iZzp3 = iZzp3;
                    i = 0;
                }
                i10++;
                i = 0;
            }
            return new zzacd(i2 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iZzl + 1, i5, i6, i7, i8, i9, f, strZzb);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzcc.zza("Error parsing HEVC config", e);
        }
    }
}
