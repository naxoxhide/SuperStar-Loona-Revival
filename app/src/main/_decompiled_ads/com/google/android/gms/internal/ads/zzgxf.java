package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgxf {
    zzgxf() {
    }

    static final String zzd(ByteBuffer byteBuffer, int i, int i2) throws zzgul {
        if ((((byteBuffer.limit() - i) - i2) | i | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b2 = byteBuffer.get(i);
            if (!zzgxe.zzd(b2)) {
                break;
            }
            i++;
            cArr[i4] = (char) b2;
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b3 = byteBuffer.get(i);
            if (zzgxe.zzd(b3)) {
                int i7 = i5 + 1;
                cArr[i5] = (char) b3;
                i = i6;
                while (true) {
                    i5 = i7;
                    if (i >= i3) {
                        break;
                    }
                    byte b4 = byteBuffer.get(i);
                    if (!zzgxe.zzd(b4)) {
                        break;
                    }
                    i++;
                    i7 = i5 + 1;
                    cArr[i5] = (char) b4;
                }
            } else if (zzgxe.zzf(b3)) {
                if (i6 >= i3) {
                    throw zzgul.zzd();
                }
                zzgxe.zzc(b3, byteBuffer.get(i6), cArr, i5);
                i5++;
                i = i6 + 1;
            } else if (zzgxe.zze(b3)) {
                if (i6 >= i3 - 1) {
                    throw zzgul.zzd();
                }
                int i8 = i6 + 1;
                zzgxe.zzb(b3, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                i5++;
                i = i8 + 1;
            } else {
                if (i6 >= i3 - 2) {
                    throw zzgul.zzd();
                }
                int i9 = i6 + 1;
                byte b5 = byteBuffer.get(i6);
                int i10 = i9 + 1;
                zzgxe.zza(b3, b5, byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                i5 += 2;
                i = i10 + 1;
            }
        }
        return new String(cArr, 0, i5);
    }

    abstract int zza(int i, byte[] bArr, int i2, int i3);

    abstract String zzb(byte[] bArr, int i, int i2) throws zzgul;

    final boolean zzc(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
