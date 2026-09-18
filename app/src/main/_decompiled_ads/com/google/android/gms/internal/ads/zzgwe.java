package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwe {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzgwt zzc;
    private static final zzgwt zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzgwt zzgwtVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzgwtVar = (zzgwt) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzgwtVar;
        zzd = new zzgwv();
    }

    public static void zzA(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzx(i, list, z);
    }

    public static void zzC(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzz(i, list, z);
    }

    public static void zzD(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzB(i, list, z);
    }

    public static void zzE(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzD(i, list, z);
    }

    public static void zzF(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzI(i, list, z);
    }

    public static void zzG(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzK(i, list, z);
    }

    static int zza(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgua) {
            zzgua zzguaVar = (zzgua) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzgtg.zzx(zzguaVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzgtg.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgtg.zzA(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgtg.zzA(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgua) {
            zzgua zzguaVar = (zzgua) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzgtg.zzx(zzguaVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzgtg.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzg(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzguy) {
            zzguy zzguyVar = (zzguy) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzgtg.zzB(zzguyVar.zze(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzgtg.zzB(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzB;
    }

    static int zzh(int i, Object obj, zzgwc zzgwcVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzgup)) {
            return zzgtg.zzA(i2) + zzgtg.zzy((zzgvj) obj, zzgwcVar);
        }
        int i3 = zzgtg.zzf;
        int iZza = ((zzgup) obj).zza();
        return zzgtg.zzA(i2) + zzgtg.zzA(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgua) {
            zzgua zzguaVar = (zzgua) list;
            iZzA = 0;
            while (i < size) {
                int iZze = zzguaVar.zze(i);
                iZzA += zzgtg.zzA((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzA += zzgtg.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzA;
    }

    static int zzj(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzguy) {
            zzguy zzguyVar = (zzguy) list;
            iZzB = 0;
            while (i < size) {
                long jZze = zzguyVar.zze(i);
                iZzB += zzgtg.zzB((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzB += zzgtg.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzB;
    }

    static int zzk(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgua) {
            zzgua zzguaVar = (zzgua) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzgtg.zzA(zzguaVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzgtg.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzl(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzguy) {
            zzguy zzguyVar = (zzguy) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzgtg.zzB(zzguyVar.zze(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzgtg.zzB(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzB;
    }

    public static zzgwt zzm() {
        return zzc;
    }

    public static zzgwt zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i, List list, zzgud zzgudVar, Object obj2, zzgwt zzgwtVar) {
        if (zzgudVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                if (zzgudVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    obj2 = zzp(obj, i, iIntValue, obj2, zzgwtVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzgudVar.zza(iIntValue2)) {
                    obj2 = zzp(obj, i, iIntValue2, obj2, zzgwtVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzp(Object obj, int i, int i2, Object obj2, zzgwt zzgwtVar) {
        if (obj2 == null) {
            obj2 = zzgwtVar.zzc(obj);
        }
        zzgwtVar.zzl(obj2, i, i2);
        return obj2;
    }

    static void zzq(zzgwt zzgwtVar, Object obj, Object obj2) {
        zzgwtVar.zzo(obj, zzgwtVar.zze(zzgwtVar.zzd(obj), zzgwtVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzgtz.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzs(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zzt(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzc(i, list, z);
    }

    public static void zzu(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzg(i, list, z);
    }

    public static void zzv(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzj(i, list, z);
    }

    public static void zzw(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzl(i, list, z);
    }

    public static void zzx(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzn(i, list, z);
    }

    public static void zzy(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzp(i, list, z);
    }

    public static void zzz(int i, List list, zzgth zzgthVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgthVar.zzs(i, list, z);
    }
}
