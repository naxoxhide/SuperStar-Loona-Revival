package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgse {
    static int zza(byte[] bArr, int i, zzgsd zzgsdVar) throws zzgul {
        int iZzh = zzh(bArr, i, zzgsdVar);
        int i2 = zzgsdVar.zza;
        if (i2 < 0) {
            throw zzgul.zzf();
        }
        if (i2 > bArr.length - iZzh) {
            throw zzgul.zzj();
        }
        if (i2 == 0) {
            zzgsdVar.zzc = zzgsr.zzb;
            return iZzh;
        }
        zzgsdVar.zzc = zzgsr.zzv(bArr, iZzh, i2);
        return iZzh + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzgwc zzgwcVar, byte[] bArr, int i, int i2, int i3, zzgsd zzgsdVar) throws IOException {
        Object objZze = zzgwcVar.zze();
        int iZzl = zzl(objZze, zzgwcVar, bArr, i, i2, i3, zzgsdVar);
        zzgwcVar.zzf(objZze);
        zzgsdVar.zzc = objZze;
        return iZzl;
    }

    static int zzd(zzgwc zzgwcVar, byte[] bArr, int i, int i2, zzgsd zzgsdVar) throws IOException {
        Object objZze = zzgwcVar.zze();
        int iZzm = zzm(objZze, zzgwcVar, bArr, i, i2, zzgsdVar);
        zzgwcVar.zzf(objZze);
        zzgsdVar.zzc = objZze;
        return iZzm;
    }

    static int zze(zzgwc zzgwcVar, int i, byte[] bArr, int i2, int i3, zzgui zzguiVar, zzgsd zzgsdVar) throws IOException {
        int iZzd = zzd(zzgwcVar, bArr, i2, i3, zzgsdVar);
        zzguiVar.add(zzgsdVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzgsdVar);
            if (i != zzgsdVar.zza) {
                break;
            }
            iZzd = zzd(zzgwcVar, bArr, iZzh, i3, zzgsdVar);
            zzguiVar.add(zzgsdVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzgui zzguiVar, zzgsd zzgsdVar) throws IOException {
        zzgua zzguaVar = (zzgua) zzguiVar;
        int iZzh = zzh(bArr, i, zzgsdVar);
        int i2 = zzgsdVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzgsdVar);
            zzguaVar.zzh(zzgsdVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw zzgul.zzj();
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzgwu zzgwuVar, zzgsd zzgsdVar) throws zzgul {
        if ((i >>> 3) == 0) {
            throw zzgul.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzgsdVar);
            zzgwuVar.zzj(i, Long.valueOf(zzgsdVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzgwuVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzgsdVar);
            int i5 = zzgsdVar.zza;
            if (i5 < 0) {
                throw zzgul.zzf();
            }
            if (i5 > bArr.length - iZzh) {
                throw zzgul.zzj();
            }
            if (i5 == 0) {
                zzgwuVar.zzj(i, zzgsr.zzb);
            } else {
                zzgwuVar.zzj(i, zzgsr.zzv(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzgul.zzc();
            }
            zzgwuVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzgwu zzgwuVarZzf = zzgwu.zzf();
        int i7 = 0;
        while (i2 < i3) {
            int iZzh2 = zzh(bArr, i2, zzgsdVar);
            int i8 = zzgsdVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzh2;
                break;
            }
            int iZzg = zzg(i7, bArr, iZzh2, i3, zzgwuVarZzf, zzgsdVar);
            i7 = i8;
            i2 = iZzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzgul.zzg();
        }
        zzgwuVar.zzj(i, zzgwuVarZzf);
        return i2;
    }

    static int zzh(byte[] bArr, int i, zzgsd zzgsdVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return zzi(b2, bArr, i2, zzgsdVar);
        }
        zzgsdVar.zza = b2;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzgsd zzgsdVar) {
        byte b2 = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b2 >= 0) {
            zzgsdVar.zza = i4 | (b2 << 7);
            return i3;
        }
        int i5 = i4 | ((b2 & 127) << 7);
        int i6 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 >= 0) {
            zzgsdVar.zza = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzgsdVar.zza = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzgsdVar.zza = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgsdVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzgui zzguiVar, zzgsd zzgsdVar) {
        zzgua zzguaVar = (zzgua) zzguiVar;
        int iZzh = zzh(bArr, i2, zzgsdVar);
        zzguaVar.zzh(zzgsdVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzgsdVar);
            if (i != zzgsdVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzgsdVar);
            zzguaVar.zzh(zzgsdVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i, zzgsd zzgsdVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgsdVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & 127)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & 127)) << i4;
            i3 = i5;
            b2 = b3;
        }
        zzgsdVar.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzgwc zzgwcVar, byte[] bArr, int i, int i2, int i3, zzgsd zzgsdVar) throws IOException {
        int iZzc = ((zzgvm) zzgwcVar).zzc(obj, bArr, i, i2, i3, zzgsdVar);
        zzgsdVar.zzc = obj;
        return iZzc;
    }

    static int zzm(Object obj, zzgwc zzgwcVar, byte[] bArr, int i, int i2, zzgsd zzgsdVar) throws IOException {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzgsdVar);
            i3 = zzgsdVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzgul.zzj();
        }
        int i5 = i3 + i4;
        zzgwcVar.zzi(obj, bArr, i4, i5, zzgsdVar);
        zzgsdVar.zzc = obj;
        return i5;
    }

    static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
