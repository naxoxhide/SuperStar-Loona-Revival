package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfy {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzdx.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzf(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zzf(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b2 = bArr[i5];
            if ((b2 & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b2 == 1) {
                    zzf(zArr);
                    return i6;
                }
                i5 = i6;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static zzfv zzc(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iZzb;
        int i6;
        int i7;
        zzfz zzfzVar = new zzfz(bArr, i, i2);
        int i8 = 4;
        zzfzVar.zze(4);
        int iZza = zzfzVar.zza(3);
        zzfzVar.zzd();
        int iZza2 = zzfzVar.zza(2);
        boolean zZzf = zzfzVar.zzf();
        int iZza3 = zzfzVar.zza(5);
        int i9 = 0;
        for (int i10 = 0; i10 < 32; i10++) {
            if (zzfzVar.zzf()) {
                i9 |= 1 << i10;
            }
        }
        int i11 = 6;
        int[] iArr = new int[6];
        for (int i12 = 0; i12 < 6; i12++) {
            iArr[i12] = zzfzVar.zza(8);
        }
        int iZza4 = zzfzVar.zza(8);
        int i13 = 0;
        for (int i14 = 0; i14 < iZza; i14++) {
            if (zzfzVar.zzf()) {
                i13 += 89;
            }
            if (zzfzVar.zzf()) {
                i13 += 8;
            }
        }
        zzfzVar.zze(i13);
        if (iZza > 0) {
            int i15 = 8 - iZza;
            zzfzVar.zze(i15 + i15);
        }
        int iZzc = zzfzVar.zzc();
        int iZzc2 = zzfzVar.zzc();
        if (iZzc2 == 3) {
            zzfzVar.zzd();
            iZzc2 = 3;
        }
        int iZzc3 = zzfzVar.zzc();
        int iZzc4 = zzfzVar.zzc();
        if (zzfzVar.zzf()) {
            int iZzc5 = zzfzVar.zzc();
            int iZzc6 = zzfzVar.zzc();
            int iZzc7 = zzfzVar.zzc();
            int iZzc8 = zzfzVar.zzc();
            if (iZzc2 == 1) {
                i7 = 2;
            } else if (iZzc2 == 2) {
                iZzc2 = 2;
                i7 = 2;
            } else {
                i7 = 1;
            }
            iZzc3 -= i7 * (iZzc5 + iZzc6);
            iZzc4 -= (iZzc2 == 1 ? 2 : 1) * (iZzc7 + iZzc8);
        }
        int i16 = iZzc3;
        int i17 = iZzc2;
        int i18 = iZzc4;
        int iZzc9 = zzfzVar.zzc();
        int iZzc10 = zzfzVar.zzc();
        int iZzc11 = zzfzVar.zzc();
        for (int i19 = true != zzfzVar.zzf() ? iZza : 0; i19 <= iZza; i19++) {
            zzfzVar.zzc();
            zzfzVar.zzc();
            zzfzVar.zzc();
        }
        zzfzVar.zzc();
        zzfzVar.zzc();
        zzfzVar.zzc();
        zzfzVar.zzc();
        zzfzVar.zzc();
        zzfzVar.zzc();
        if (zzfzVar.zzf() && zzfzVar.zzf()) {
            int i20 = 0;
            while (i20 < i8) {
                int i21 = 0;
                while (i21 < i11) {
                    if (zzfzVar.zzf()) {
                        int iMin = Math.min(64, 1 << ((i20 + i20) + 4));
                        if (i20 > 1) {
                            zzfzVar.zzb();
                        }
                        for (int i22 = 0; i22 < iMin; i22++) {
                            zzfzVar.zzb();
                        }
                    } else {
                        zzfzVar.zzc();
                    }
                    i21 += i20 == 3 ? 3 : 1;
                    i11 = 6;
                }
                i20++;
                i8 = 4;
                i11 = 6;
            }
        }
        zzfzVar.zze(2);
        if (zzfzVar.zzf()) {
            zzfzVar.zze(8);
            zzfzVar.zzc();
            zzfzVar.zzc();
            zzfzVar.zzd();
        }
        int iZzc12 = zzfzVar.zzc();
        int i23 = 0;
        int[] iArr2 = new int[0];
        int[] iArrCopyOf = new int[0];
        int i24 = -1;
        int i25 = -1;
        int i26 = -1;
        while (i23 < iZzc12) {
            if (i23 == 0 || !zzfzVar.zzf()) {
                int iZzc13 = zzfzVar.zzc();
                int iZzc14 = zzfzVar.zzc();
                int[] iArr3 = new int[iZzc13];
                int i27 = 0;
                while (i27 < iZzc13) {
                    iArr3[i27] = (i27 > 0 ? iArr3[i27 - 1] : 0) - (zzfzVar.zzc() + 1);
                    zzfzVar.zzd();
                    i27++;
                }
                int[] iArr4 = new int[iZzc14];
                int i28 = 0;
                while (i28 < iZzc14) {
                    iArr4[i28] = (i28 > 0 ? iArr4[i28 - 1] : 0) + zzfzVar.zzc() + 1;
                    zzfzVar.zzd();
                    i28++;
                }
                i26 = iZzc14;
                iArrCopyOf = iArr4;
                i25 = iZzc13;
                iArr2 = iArr3;
            } else {
                int i29 = i25 + i26;
                boolean zZzf2 = zzfzVar.zzf();
                int iZzc15 = zzfzVar.zzc() + 1;
                int i30 = 1 - ((zZzf2 ? 1 : 0) + (zZzf2 ? 1 : 0));
                int i31 = i29 + 1;
                boolean[] zArr = new boolean[i31];
                for (int i32 = 0; i32 <= i29; i32++) {
                    if (zzfzVar.zzf()) {
                        zArr[i32] = true;
                    } else {
                        zArr[i32] = zzfzVar.zzf();
                    }
                }
                int i33 = i26 - 1;
                int[] iArr5 = new int[i31];
                int[] iArr6 = new int[i31];
                int i34 = 0;
                while (true) {
                    i6 = i30 * iZzc15;
                    if (i33 < 0) {
                        break;
                    }
                    int i35 = iArrCopyOf[i33] + i6;
                    if (i35 < 0 && zArr[i25 + i33]) {
                        iArr5[i34] = i35;
                        i34++;
                    }
                    i33--;
                }
                if (i6 < 0 && zArr[i29]) {
                    iArr5[i34] = i6;
                    i34++;
                }
                int i36 = i34;
                for (int i37 = 0; i37 < i25; i37++) {
                    int i38 = iArr2[i37] + i6;
                    if (i38 < 0 && zArr[i37]) {
                        iArr5[i36] = i38;
                        i36++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr5, i36);
                int i39 = 0;
                for (int i40 = i25 - 1; i40 >= 0; i40--) {
                    int i41 = iArr2[i40] + i6;
                    if (i41 > 0 && zArr[i40]) {
                        iArr6[i39] = i41;
                        i39++;
                    }
                }
                if (i6 > 0 && zArr[i29]) {
                    iArr6[i39] = i6;
                    i39++;
                }
                int i42 = i39;
                for (int i43 = 0; i43 < i26; i43++) {
                    int i44 = iArrCopyOf[i43] + i6;
                    if (i44 > 0 && zArr[i25 + i43]) {
                        iArr6[i42] = i44;
                        i42++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr6, i42);
                i26 = i42;
                iArr2 = iArrCopyOf2;
                i25 = i36;
            }
            i23++;
            i17 = i17;
            i9 = i9;
            iZzc12 = iZzc12;
            iArr = iArr;
        }
        int i45 = i9;
        int i46 = i17;
        int[] iArr7 = iArr;
        if (zzfzVar.zzf()) {
            int iZzc16 = zzfzVar.zzc();
            for (int i47 = 0; i47 < iZzc16; i47++) {
                zzfzVar.zze(iZzc11 + 5);
            }
        }
        zzfzVar.zze(2);
        float f = 1.0f;
        if (zzfzVar.zzf()) {
            if (zzfzVar.zzf()) {
                int iZza5 = zzfzVar.zza(8);
                if (iZza5 == 255) {
                    int iZza6 = zzfzVar.zza(16);
                    int iZza7 = zzfzVar.zza(16);
                    if (iZza6 != 0 && iZza7 != 0) {
                        f = iZza6 / iZza7;
                    }
                } else if (iZza5 < 17) {
                    f = zzb[iZza5];
                } else {
                    zzer.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza5);
                }
            }
            if (zzfzVar.zzf()) {
                zzfzVar.zzd();
            }
            if (zzfzVar.zzf()) {
                zzfzVar.zze(3);
                int i48 = true != zzfzVar.zzf() ? 2 : 1;
                if (zzfzVar.zzf()) {
                    int iZza8 = zzfzVar.zza(8);
                    int iZza9 = zzfzVar.zza(8);
                    zzfzVar.zze(8);
                    int iZza10 = zzs.zza(iZza8);
                    iZzb = zzs.zzb(iZza9);
                    i4 = iZza10;
                } else {
                    i4 = -1;
                    iZzb = -1;
                }
                i24 = i48;
            } else {
                i4 = -1;
                iZzb = -1;
            }
            if (zzfzVar.zzf()) {
                zzfzVar.zzc();
                zzfzVar.zzc();
            }
            zzfzVar.zzd();
            if (zzfzVar.zzf()) {
                i18 += i18;
            }
            i5 = iZzb;
            i3 = i18;
        } else {
            i3 = i18;
            i4 = -1;
            i5 = -1;
        }
        return new zzfv(iZza2, zZzf, iZza3, i45, i46, iZzc9, iZzc10, iArr7, iZza4, iZzc, i16, i3, f, i4, i24, i5);
    }

    public static zzfw zzd(byte[] bArr, int i, int i2) {
        zzfz zzfzVar = new zzfz(bArr, 4, i2);
        int iZzc = zzfzVar.zzc();
        int iZzc2 = zzfzVar.zzc();
        zzfzVar.zzd();
        return new zzfw(iZzc, iZzc2, zzfzVar.zzf());
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:103:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:104:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:106:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:111:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:26:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x006b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    /* JADX WARN: Code duplicated, block: B:31:0x006f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x007a  */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:39:0x007f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0098  */
    /* JADX WARN: Code duplicated, block: B:62:0x0100  */
    /* JADX WARN: Code duplicated, block: B:65:0x0111  */
    /* JADX WARN: Code duplicated, block: B:67:0x0123  */
    /* JADX WARN: Code duplicated, block: B:68:0x0126  */
    /* JADX WARN: Code duplicated, block: B:70:0x0129  */
    /* JADX WARN: Code duplicated, block: B:71:0x012c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0130  */
    /* JADX WARN: Code duplicated, block: B:74:0x0133  */
    /* JADX WARN: Code duplicated, block: B:79:0x0148  */
    /* JADX WARN: Code duplicated, block: B:81:0x014e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0158  */
    /* JADX WARN: Code duplicated, block: B:87:0x0169  */
    /* JADX WARN: Code duplicated, block: B:89:0x016d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0172  */
    /* JADX WARN: Code duplicated, block: B:91:0x0188  */
    /* JADX WARN: Code duplicated, block: B:94:0x0190  */
    /* JADX WARN: Code duplicated, block: B:97:0x0199  */
    /* JADX WARN: Code duplicated, block: B:99:0x01a3  */
    /* JADX WARN: Instruction removed from duplicated block: B:90:0x0172, please report this as an issue */
    public static zzfx zze(byte[] bArr, int i, int i2) {
        int iZzc;
        int i3;
        boolean zZzf;
        boolean z;
        int i4;
        int i5;
        int i6;
        int iZzb;
        int i7;
        int i8;
        int iZzc2;
        boolean z2;
        boolean zZzf2;
        int i9;
        int i10;
        int i11;
        int iZza;
        int i12;
        int iZzb2;
        float f;
        float f2;
        int i13;
        int iZza2;
        int iZza3;
        int i14;
        int i15;
        zzfz zzfzVar = new zzfz(bArr, i, i2);
        int iZza4 = zzfzVar.zza(8);
        int iZza5 = zzfzVar.zza(8);
        int iZza6 = zzfzVar.zza(8);
        int iZzc3 = zzfzVar.zzc();
        if (iZza4 == 100 || iZza4 == 110 || iZza4 == 122 || iZza4 == 244 || iZza4 == 44 || iZza4 == 83 || iZza4 == 86 || iZza4 == 118 || iZza4 == 128) {
            iZzc = zzfzVar.zzc();
            if (iZzc == 3) {
                zZzf = zzfzVar.zzf();
                i3 = 3;
            } else {
                i3 = iZzc;
                zZzf = false;
            }
            zzfzVar.zzc();
            zzfzVar.zzc();
            zzfzVar.zzd();
            if (zzfzVar.zzf()) {
                if (i3 != 3) {
                    i4 = 8;
                } else {
                    i4 = 12;
                }
                for (i5 = 0; i5 < i4; i5++) {
                    if (!zzfzVar.zzf()) {
                        if (i5 < 6) {
                            i6 = 16;
                        } else {
                            i6 = 64;
                        }
                        iZzb = 8;
                        i7 = 8;
                        for (i8 = 0; i8 < i6; i8++) {
                            if (iZzb != 0) {
                                iZzb = ((i7 + zzfzVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i7 = iZzb;
                            }
                        }
                    }
                }
            }
            z = zZzf;
        } else if (iZza4 == 138) {
            iZza4 = 138;
            iZzc = zzfzVar.zzc();
            if (iZzc == 3) {
                zZzf = zzfzVar.zzf();
                i3 = 3;
            } else {
                i3 = iZzc;
                zZzf = false;
            }
            zzfzVar.zzc();
            zzfzVar.zzc();
            zzfzVar.zzd();
            if (zzfzVar.zzf()) {
                if (i3 != 3) {
                    i4 = 8;
                } else {
                    i4 = 12;
                }
                while (i5 < i4) {
                    if (!zzfzVar.zzf()) {
                        if (i5 < 6) {
                            i6 = 16;
                        } else {
                            i6 = 64;
                        }
                        iZzb = 8;
                        i7 = 8;
                        while (i8 < i6) {
                            if (iZzb != 0) {
                                iZzb = ((i7 + zzfzVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i7 = iZzb;
                            }
                        }
                    }
                }
            }
            z = zZzf;
        } else {
            iZzc = 1;
            z = false;
        }
        int iZzc4 = zzfzVar.zzc() + 4;
        int iZzc5 = zzfzVar.zzc();
        if (iZzc5 != 0) {
            if (iZzc5 == 1) {
                boolean zZzf3 = zzfzVar.zzf();
                zzfzVar.zzb();
                zzfzVar.zzb();
                iZza4 = iZza4;
                long jZzc = zzfzVar.zzc();
                for (int i16 = 0; i16 < jZzc; i16++) {
                    zzfzVar.zzc();
                }
                z2 = zZzf3;
                iZzc2 = 0;
                iZzc5 = 1;
            } else {
                iZzc2 = 0;
            }
            int iZzc6 = zzfzVar.zzc();
            zzfzVar.zzd();
            int iZzc7 = zzfzVar.zzc() + 1;
            int iZzc8 = zzfzVar.zzc() + 1;
            zZzf2 = zzfzVar.zzf();
            i9 = 2 - (zZzf2 ? 1 : 0);
            if (!zZzf2) {
                zzfzVar.zzd();
            }
            zzfzVar.zzd();
            i10 = iZzc7 * 16;
            i11 = iZzc8 * i9 * 16;
            if (zzfzVar.zzf()) {
                int iZzc9 = zzfzVar.zzc();
                int iZzc10 = zzfzVar.zzc();
                int iZzc11 = zzfzVar.zzc();
                int iZzc12 = zzfzVar.zzc();
                if (iZzc == 0) {
                    i14 = 1;
                } else {
                    if (iZzc == 3) {
                        i14 = 1;
                    } else {
                        i14 = 2;
                    }
                    if (iZzc == 1) {
                        i15 = 2;
                    } else {
                        i15 = 1;
                    }
                    i9 *= i15;
                }
                i10 -= (iZzc9 + iZzc10) * i14;
                i11 -= (iZzc11 + iZzc12) * i9;
            }
            int i17 = i10;
            if (zzfzVar.zzf()) {
                if (zzfzVar.zzf()) {
                    iZza2 = zzfzVar.zza(8);
                    if (iZza2 == 255) {
                        iZza3 = zzfzVar.zza(16);
                        int iZza7 = zzfzVar.zza(16);
                        if (iZza3 != 0 || iZza7 == 0) {
                            f2 = 1.0f;
                        } else {
                            f2 = iZza3 / iZza7;
                        }
                    } else if (iZza2 < 17) {
                        f2 = zzb[iZza2];
                    } else {
                        zzer.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza2);
                        f2 = 1.0f;
                    }
                } else {
                    f2 = 1.0f;
                }
                if (zzfzVar.zzf()) {
                    zzfzVar.zzd();
                }
                if (zzfzVar.zzf()) {
                    zzfzVar.zze(3);
                    i13 = true != zzfzVar.zzf() ? 2 : 1;
                    if (zzfzVar.zzf()) {
                        int iZza8 = zzfzVar.zza(8);
                        int iZza9 = zzfzVar.zza(8);
                        zzfzVar.zze(8);
                        iZza = zzs.zza(iZza8);
                        iZzb2 = zzs.zzb(iZza9);
                        f = f2;
                        i12 = i13;
                    } else {
                        i12 = i13;
                        iZza = -1;
                        iZzb2 = -1;
                    }
                } else {
                    iZza = -1;
                    i12 = -1;
                    iZzb2 = -1;
                }
                f = f2;
            } else {
                iZza = -1;
                i12 = -1;
                iZzb2 = -1;
                f = 1.0f;
            }
            return new zzfx(iZza4, iZza5, iZza6, iZzc3, iZzc6, i17, i11, f, z, zZzf2, iZzc4, iZzc5, iZzc2, z2, iZza, i12, iZzb2);
        }
        iZzc2 = zzfzVar.zzc() + 4;
        z2 = false;
        int iZzc13 = zzfzVar.zzc();
        zzfzVar.zzd();
        int iZzc14 = zzfzVar.zzc() + 1;
        int iZzc15 = zzfzVar.zzc() + 1;
        zZzf2 = zzfzVar.zzf();
        i9 = 2 - (zZzf2 ? 1 : 0);
        if (!zZzf2) {
            zzfzVar.zzd();
        }
        zzfzVar.zzd();
        i10 = iZzc14 * 16;
        i11 = iZzc15 * i9 * 16;
        if (zzfzVar.zzf()) {
            int iZzc16 = zzfzVar.zzc();
            int iZzc17 = zzfzVar.zzc();
            int iZzc18 = zzfzVar.zzc();
            int iZzc19 = zzfzVar.zzc();
            if (iZzc == 0) {
                i14 = 1;
            } else {
                if (iZzc == 3) {
                    i14 = 1;
                } else {
                    i14 = 2;
                }
                if (iZzc == 1) {
                    i15 = 2;
                } else {
                    i15 = 1;
                }
                i9 *= i15;
            }
            i10 -= (iZzc16 + iZzc17) * i14;
            i11 -= (iZzc18 + iZzc19) * i9;
        }
        int i18 = i10;
        if (zzfzVar.zzf()) {
            if (zzfzVar.zzf()) {
                f2 = 1.0f;
            } else {
                iZza2 = zzfzVar.zza(8);
                if (iZza2 == 255) {
                    iZza3 = zzfzVar.zza(16);
                    int iZza10 = zzfzVar.zza(16);
                    if (iZza3 != 0) {
                        f2 = 1.0f;
                    } else {
                        f2 = 1.0f;
                    }
                } else if (iZza2 < 17) {
                    f2 = zzb[iZza2];
                } else {
                    zzer.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza2);
                    f2 = 1.0f;
                }
            }
            if (zzfzVar.zzf()) {
                zzfzVar.zzd();
            }
            if (zzfzVar.zzf()) {
                zzfzVar.zze(3);
                if (true != zzfzVar.zzf()) {
                }
                if (zzfzVar.zzf()) {
                    int iZza11 = zzfzVar.zza(8);
                    int iZza12 = zzfzVar.zza(8);
                    zzfzVar.zze(8);
                    iZza = zzs.zza(iZza11);
                    iZzb2 = zzs.zzb(iZza12);
                    f = f2;
                    i12 = i13;
                } else {
                    i12 = i13;
                    iZza = -1;
                    iZzb2 = -1;
                }
            } else {
                iZza = -1;
                i12 = -1;
                iZzb2 = -1;
            }
            f = f2;
        } else {
            iZza = -1;
            i12 = -1;
            iZzb2 = -1;
            f = 1.0f;
        }
        return new zzfx(iZza4, iZza5, iZza6, iZzc3, iZzc13, i18, i11, f, z, zZzf2, iZzc4, iZzc5, iZzc2, z2, iZza, i12, iZzb2);
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i11 + 1;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }
}
