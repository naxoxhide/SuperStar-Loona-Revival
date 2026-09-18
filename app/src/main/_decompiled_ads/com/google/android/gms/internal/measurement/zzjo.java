package com.google.android.gms.internal.measurement;

import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjo {
    static int zza(byte[] bArr, int i, zzjn zzjnVar) throws zzll {
        int iZzj = zzj(bArr, i, zzjnVar);
        int i2 = zzjnVar.zza;
        if (i2 < 0) {
            throw zzll.zzd();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzll.zzf();
        }
        if (i2 == 0) {
            zzjnVar.zzc = zzka.zzb;
            return iZzj;
        }
        zzjnVar.zzc = zzka.zzl(bArr, iZzj, i2);
        return iZzj + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzmt zzmtVar, byte[] bArr, int i, int i2, int i3, zzjn zzjnVar) throws IOException {
        Object objZze = zzmtVar.zze();
        int iZzn = zzn(objZze, zzmtVar, bArr, i, i2, i3, zzjnVar);
        zzmtVar.zzf(objZze);
        zzjnVar.zzc = objZze;
        return iZzn;
    }

    static int zzd(zzmt zzmtVar, byte[] bArr, int i, int i2, zzjn zzjnVar) throws IOException {
        Object objZze = zzmtVar.zze();
        int iZzo = zzo(objZze, zzmtVar, bArr, i, i2, zzjnVar);
        zzmtVar.zzf(objZze);
        zzjnVar.zzc = objZze;
        return iZzo;
    }

    static int zze(zzmt zzmtVar, int i, byte[] bArr, int i2, int i3, zzli zzliVar, zzjn zzjnVar) throws IOException {
        int iZzd = zzd(zzmtVar, bArr, i2, i3, zzjnVar);
        zzliVar.add(zzjnVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zzjnVar);
            if (i != zzjnVar.zza) {
                break;
            }
            iZzd = zzd(zzmtVar, bArr, iZzj, i3, zzjnVar);
            zzliVar.add(zzjnVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzli zzliVar, zzjn zzjnVar) throws IOException {
        zzlc zzlcVar = (zzlc) zzliVar;
        int iZzj = zzj(bArr, i, zzjnVar);
        int i2 = zzjnVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzjnVar);
            zzlcVar.zzh(zzjnVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzll.zzf();
    }

    static int zzg(byte[] bArr, int i, zzjn zzjnVar) throws zzll {
        int iZzj = zzj(bArr, i, zzjnVar);
        int i2 = zzjnVar.zza;
        if (i2 < 0) {
            throw zzll.zzd();
        }
        if (i2 == 0) {
            zzjnVar.zzc = "";
            return iZzj;
        }
        zzjnVar.zzc = new String(bArr, iZzj, i2, zzlj.zzb);
        return iZzj + i2;
    }

    static int zzh(byte[] bArr, int i, zzjn zzjnVar) throws zzll {
        int iZzj = zzj(bArr, i, zzjnVar);
        int i2 = zzjnVar.zza;
        if (i2 < 0) {
            throw zzll.zzd();
        }
        if (i2 == 0) {
            zzjnVar.zzc = "";
            return iZzj;
        }
        int i3 = zznz.zza;
        int length = bArr.length;
        if ((((length - iZzj) - i2) | iZzj | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzj), Integer.valueOf(i2)));
        }
        int i4 = iZzj + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (iZzj < i4) {
            byte b2 = bArr[iZzj];
            if (!zznv.zzd(b2)) {
                break;
            }
            iZzj++;
            cArr[i5] = (char) b2;
            i5++;
        }
        while (iZzj < i4) {
            int i6 = iZzj + 1;
            byte b3 = bArr[iZzj];
            if (zznv.zzd(b3)) {
                int i7 = i5 + 1;
                cArr[i5] = (char) b3;
                iZzj = i6;
                while (true) {
                    i5 = i7;
                    if (iZzj >= i4) {
                        break;
                    }
                    byte b4 = bArr[iZzj];
                    if (!zznv.zzd(b4)) {
                        break;
                    }
                    iZzj++;
                    i7 = i5 + 1;
                    cArr[i5] = (char) b4;
                }
            } else if (b3 < -32) {
                if (i6 >= i4) {
                    throw zzll.zzc();
                }
                zznv.zzc(b3, bArr[i6], cArr, i5);
                iZzj = i6 + 1;
                i5++;
            } else if (b3 < -16) {
                if (i6 >= i4 - 1) {
                    throw zzll.zzc();
                }
                int i8 = i6 + 1;
                zznv.zzb(b3, bArr[i6], bArr[i8], cArr, i5);
                iZzj = i8 + 1;
                i5++;
            } else {
                if (i6 >= i4 - 2) {
                    throw zzll.zzc();
                }
                int i9 = i6 + 1;
                byte b5 = bArr[i6];
                int i10 = i9 + 1;
                zznv.zza(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                i5 += 2;
                iZzj = i10 + 1;
            }
        }
        zzjnVar.zzc = new String(cArr, 0, i5);
        return i4;
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zznl zznlVar, zzjn zzjnVar) throws zzll {
        if ((i >>> 3) == 0) {
            throw zzll.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzjnVar);
            zznlVar.zzj(i, Long.valueOf(zzjnVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zznlVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzjnVar);
            int i5 = zzjnVar.zza;
            if (i5 < 0) {
                throw zzll.zzd();
            }
            if (i5 > bArr.length - iZzj) {
                throw zzll.zzf();
            }
            if (i5 == 0) {
                zznlVar.zzj(i, zzka.zzb);
            } else {
                zznlVar.zzj(i, zzka.zzl(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzll.zzb();
            }
            zznlVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zznl zznlVarZzf = zznl.zzf();
        int i7 = 0;
        while (i2 < i3) {
            int iZzj2 = zzj(bArr, i2, zzjnVar);
            int i8 = zzjnVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzj2;
                break;
            }
            int iZzi = zzi(i7, bArr, iZzj2, i3, zznlVarZzf, zzjnVar);
            i7 = i8;
            i2 = iZzi;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzll.zze();
        }
        zznlVar.zzj(i, zznlVarZzf);
        return i2;
    }

    static int zzj(byte[] bArr, int i, zzjn zzjnVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return zzk(b2, bArr, i2, zzjnVar);
        }
        zzjnVar.zza = b2;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzjn zzjnVar) {
        byte b2 = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b2 >= 0) {
            zzjnVar.zza = i4 | (b2 << 7);
            return i3;
        }
        int i5 = i4 | ((b2 & 127) << 7);
        int i6 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 >= 0) {
            zzjnVar.zza = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzjnVar.zza = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzjnVar.zza = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzjnVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzli zzliVar, zzjn zzjnVar) {
        zzlc zzlcVar = (zzlc) zzliVar;
        int iZzj = zzj(bArr, i2, zzjnVar);
        zzlcVar.zzh(zzjnVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzjnVar);
            if (i != zzjnVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzjnVar);
            zzlcVar.zzh(zzjnVar.zza);
        }
        return iZzj;
    }

    static int zzm(byte[] bArr, int i, zzjn zzjnVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzjnVar.zzb = j;
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
        zzjnVar.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzmt zzmtVar, byte[] bArr, int i, int i2, int i3, zzjn zzjnVar) throws IOException {
        int iZzc = ((zzml) zzmtVar).zzc(obj, bArr, i, i2, i3, zzjnVar);
        zzjnVar.zzc = obj;
        return iZzc;
    }

    static int zzo(Object obj, zzmt zzmtVar, byte[] bArr, int i, int i2, zzjn zzjnVar) throws IOException {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzjnVar);
            i3 = zzjnVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzll.zzf();
        }
        int i5 = i3 + i4;
        zzmtVar.zzh(obj, bArr, i4, i5, zzjnVar);
        zzjnVar.zzc = obj;
        return i5;
    }

    static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
