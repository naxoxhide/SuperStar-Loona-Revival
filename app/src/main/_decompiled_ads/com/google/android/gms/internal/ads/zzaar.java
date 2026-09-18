package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaar {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;
    public final String zzi;

    private zzaar(List list, int i, int i2, int i3, int i4, int i5, int i6, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = f;
        this.zzi = str;
    }

    public static zzaar zza(zzfb zzfbVar) throws zzcc {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String strZza;
        float f;
        try {
            zzfbVar.zzH(4);
            int iZzl = (zzfbVar.zzl() & 3) + 1;
            if (iZzl == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzl2 = zzfbVar.zzl() & 31;
            for (int i6 = 0; i6 < iZzl2; i6++) {
                arrayList.add(zzb(zzfbVar));
            }
            int iZzl3 = zzfbVar.zzl();
            for (int i7 = 0; i7 < iZzl3; i7++) {
                arrayList.add(zzb(zzfbVar));
            }
            if (iZzl2 > 0) {
                zzfx zzfxVarZze = zzfy.zze((byte[]) arrayList.get(0), iZzl + 1, ((byte[]) arrayList.get(0)).length);
                int i8 = zzfxVarZze.zze;
                int i9 = zzfxVarZze.zzf;
                int i10 = zzfxVarZze.zzh;
                int i11 = zzfxVarZze.zzi;
                int i12 = zzfxVarZze.zzj;
                float f2 = zzfxVarZze.zzg;
                strZza = zzdz.zza(zzfxVarZze.zza, zzfxVarZze.zzb, zzfxVarZze.zzc);
                i4 = i11;
                i5 = i12;
                f = f2;
                i = i8;
                i2 = i9;
                i3 = i10;
            } else {
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                strZza = null;
                f = 1.0f;
            }
            return new zzaar(arrayList, iZzl, i, i2, i3, i4, i5, f, strZza);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzcc.zza("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzfb zzfbVar) {
        int iZzp = zzfbVar.zzp();
        int iZzc = zzfbVar.zzc();
        zzfbVar.zzH(iZzp);
        return zzdz.zzc(zzfbVar.zzI(), iZzc, iZzp);
    }
}
