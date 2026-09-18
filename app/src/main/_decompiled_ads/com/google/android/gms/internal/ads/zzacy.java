package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacy {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzby zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzfk.zza;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                zzer.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzaem.zzb(new zzfb(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e) {
                    zzer.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzafz(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzby(arrayList);
    }

    public static zzacv zzc(zzfb zzfbVar, boolean z, boolean z2) throws zzcc {
        if (z) {
            zzd(3, zzfbVar, false);
        }
        String strZzy = zzfbVar.zzy((int) zzfbVar.zzr(), zzfsi.zzc);
        int length = strZzy.length();
        long jZzr = zzfbVar.zzr();
        String[] strArr = new String[(int) jZzr];
        int length2 = length + 15;
        for (int i = 0; i < jZzr; i++) {
            String strZzy2 = zzfbVar.zzy((int) zzfbVar.zzr(), zzfsi.zzc);
            strArr[i] = strZzy2;
            length2 = length2 + 4 + strZzy2.length();
        }
        if (z2 && (zzfbVar.zzl() & 1) == 0) {
            throw zzcc.zza("framing bit expected to be set", null);
        }
        return new zzacv(strZzy, strArr, length2 + 1);
    }

    public static boolean zzd(int i, zzfb zzfbVar, boolean z) throws zzcc {
        if (zzfbVar.zza() < 7) {
            if (z) {
                return false;
            }
            throw zzcc.zza("too short header: " + zzfbVar.zza(), null);
        }
        if (zzfbVar.zzl() != i) {
            if (z) {
                return false;
            }
            throw zzcc.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), null);
        }
        if (zzfbVar.zzl() == 118 && zzfbVar.zzl() == 111 && zzfbVar.zzl() == 114 && zzfbVar.zzl() == 98 && zzfbVar.zzl() == 105 && zzfbVar.zzl() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw zzcc.zza("expected characters 'vorbis'", null);
    }
}
