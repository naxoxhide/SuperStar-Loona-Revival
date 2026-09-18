package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafg {
    public static final zzafe zza = new zzafe() { // from class: com.google.android.gms.internal.ads.zzafd
    };

    /* JADX WARN: Code duplicated, block: B:30:0x0090  */
    /* JADX WARN: Code duplicated, block: B:34:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    /* JADX WARN: Code duplicated, block: B:52:0x0108  */
    /* JADX WARN: Code duplicated, block: B:58:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0102 A[SYNTHETIC] */
    public static final zzby zza(byte[] bArr, int i, zzafe zzafeVar, zzaeh zzaehVar) throws Throwable {
        boolean z;
        zzaff zzaffVar;
        int i2;
        int iZze;
        zzafh zzafhVarZzf;
        ArrayList arrayList = new ArrayList();
        zzfb zzfbVar = new zzfb(bArr, i);
        boolean z2 = false;
        if (zzfbVar.zza() < 10) {
            zzer.zzf("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iZzn = zzfbVar.zzn();
            if (iZzn == 4801587) {
                int iZzl = zzfbVar.zzl();
                zzfbVar.zzH(1);
                int iZzl2 = zzfbVar.zzl();
                int iZzk = zzfbVar.zzk();
                if (iZzl != 2) {
                    if (iZzl == 3) {
                        if ((iZzl2 & 64) != 0) {
                            int iZzf = zzfbVar.zzf();
                            zzfbVar.zzH(iZzf);
                            iZzk -= iZzf + 4;
                        }
                    } else if (iZzl == 4) {
                        if ((iZzl2 & 64) != 0) {
                            int iZzk2 = zzfbVar.zzk();
                            zzfbVar.zzH(iZzk2 - 4);
                            iZzk -= iZzk2;
                        }
                        if ((iZzl2 & 16) != 0) {
                            iZzk -= 10;
                        }
                    } else {
                        zzer.zzf("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iZzl);
                    }
                    if (iZzl < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    zzaffVar = new zzaff(iZzl, z, iZzk);
                } else if ((iZzl2 & 64) != 0) {
                    zzer.zzf("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                } else {
                    if (iZzl < 4 || (iZzl2 & 128) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    zzaffVar = new zzaff(iZzl, z, iZzk);
                }
                if (zzaffVar == null) {
                    return null;
                }
                int iZzc = zzfbVar.zzc();
                i2 = zzaffVar.zza == 2 ? 6 : 10;
                iZze = zzaffVar.zzc;
                if (zzaffVar.zzb) {
                    iZze = zze(zzfbVar, zzaffVar.zzc);
                }
                zzfbVar.zzF(iZzc + iZze);
                if (!zzk(zzfbVar, zzaffVar.zza, i2, false)) {
                    if (zzaffVar.zza == 4 || !zzk(zzfbVar, 4, i2, true)) {
                        zzer.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + zzaffVar.zza);
                        return null;
                    }
                    z2 = true;
                }
                while (zzfbVar.zza() >= i2) {
                    zzafhVarZzf = zzf(zzaffVar.zza, zzfbVar, z2, i2, zzafeVar);
                    if (zzafhVarZzf != null) {
                        arrayList.add(zzafhVarZzf);
                    }
                }
                return new zzby(arrayList);
            }
            zzer.zzf("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.valueOf(String.format("%06X", Integer.valueOf(iZzn)))));
        }
        zzaffVar = null;
        if (zzaffVar == null) {
            return null;
        }
        int iZzc2 = zzfbVar.zzc();
        if (zzaffVar.zza == 2) {
        }
        iZze = zzaffVar.zzc;
        if (zzaffVar.zzb) {
            iZze = zze(zzfbVar, zzaffVar.zzc);
        }
        zzfbVar.zzF(iZzc2 + iZze);
        if (!zzk(zzfbVar, zzaffVar.zza, i2, false)) {
            if (zzaffVar.zza == 4) {
            }
            zzer.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + zzaffVar.zza);
            return null;
        }
        while (zzfbVar.zza() >= i2) {
            zzafhVarZzf = zzf(zzaffVar.zza, zzfbVar, z2, i2, zzafeVar);
            if (zzafhVarZzf != null) {
                arrayList.add(zzafhVarZzf);
            }
        }
        return new zzby(arrayList);
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int iZzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZzd;
        }
        while (true) {
            int length = bArr.length;
            if (iZzd >= length - 1) {
                return length;
            }
            int i3 = iZzd + 1;
            if ((iZzd - i) % 2 == 0 && bArr[i3] == 0) {
                return iZzd;
            }
            iZzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzfb zzfbVar, int i) {
        byte[] bArrZzI = zzfbVar.zzI();
        int iZzc = zzfbVar.zzc();
        int i2 = iZzc;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iZzc + i) {
                return i;
            }
            if ((bArrZzI[i2] & 255) == 255 && bArrZzI[i3] == 0) {
                System.arraycopy(bArrZzI, i2 + 2, bArrZzI, i3, (i - (i2 - iZzc)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0257  */
    /* JADX WARN: Code duplicated, block: B:132:0x025b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0262  */
    /* JADX WARN: Code duplicated, block: B:138:0x0268 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:143:0x0280 A[Catch: all -> 0x051a, TryCatch #1 {all -> 0x051a, blocks: (B:224:0x04f5, B:125:0x0218, B:141:0x026e, B:143:0x0280, B:150:0x02c5, B:147:0x02a2, B:149:0x02bb, B:162:0x0307, B:171:0x034e, B:174:0x0383, B:177:0x0394, B:178:0x039c, B:180:0x03a2, B:182:0x03a9, B:183:0x03ad, B:190:0x03cf, B:194:0x03fa, B:196:0x0404, B:197:0x0437, B:198:0x0443, B:200:0x0449, B:202:0x0450, B:203:0x0454, B:207:0x0469, B:216:0x0494, B:218:0x04be, B:219:0x04cd, B:222:0x04e4), top: B:236:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x029e  */
    /* JADX WARN: Code duplicated, block: B:147:0x02a2 A[Catch: all -> 0x051a, TryCatch #1 {all -> 0x051a, blocks: (B:224:0x04f5, B:125:0x0218, B:141:0x026e, B:143:0x0280, B:150:0x02c5, B:147:0x02a2, B:149:0x02bb, B:162:0x0307, B:171:0x034e, B:174:0x0383, B:177:0x0394, B:178:0x039c, B:180:0x03a2, B:182:0x03a9, B:183:0x03ad, B:190:0x03cf, B:194:0x03fa, B:196:0x0404, B:197:0x0437, B:198:0x0443, B:200:0x0449, B:202:0x0450, B:203:0x0454, B:207:0x0469, B:216:0x0494, B:218:0x04be, B:219:0x04cd, B:222:0x04e4), top: B:236:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x02bb A[Catch: all -> 0x051a, TryCatch #1 {all -> 0x051a, blocks: (B:224:0x04f5, B:125:0x0218, B:141:0x026e, B:143:0x0280, B:150:0x02c5, B:147:0x02a2, B:149:0x02bb, B:162:0x0307, B:171:0x034e, B:174:0x0383, B:177:0x0394, B:178:0x039c, B:180:0x03a2, B:182:0x03a9, B:183:0x03ad, B:190:0x03cf, B:194:0x03fa, B:196:0x0404, B:197:0x0437, B:198:0x0443, B:200:0x0449, B:202:0x0450, B:203:0x0454, B:207:0x0469, B:216:0x0494, B:218:0x04be, B:219:0x04cd, B:222:0x04e4), top: B:236:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:153:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:165:0x0342 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x0344  */
    /* JADX WARN: Code duplicated, block: B:185:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:208:0x047a  */
    /* JADX WARN: Code duplicated, block: B:210:0x0482  */
    /* JADX WARN: Code duplicated, block: B:212:0x0488  */
    /* JADX WARN: Code duplicated, block: B:214:0x0490  */
    /* JADX WARN: Code duplicated, block: B:220:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:221:0x04de  */
    /* JADX WARN: Code duplicated, block: B:224:0x04f5 A[Catch: all -> 0x051a, TRY_LEAVE, TryCatch #1 {all -> 0x051a, blocks: (B:224:0x04f5, B:125:0x0218, B:141:0x026e, B:143:0x0280, B:150:0x02c5, B:147:0x02a2, B:149:0x02bb, B:162:0x0307, B:171:0x034e, B:174:0x0383, B:177:0x0394, B:178:0x039c, B:180:0x03a2, B:182:0x03a9, B:183:0x03ad, B:190:0x03cf, B:194:0x03fa, B:196:0x0404, B:197:0x0437, B:198:0x0443, B:200:0x0449, B:202:0x0450, B:203:0x0454, B:207:0x0469, B:216:0x0494, B:218:0x04be, B:219:0x04cd, B:222:0x04e4), top: B:236:0x00f4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:224:0x04f5, please report this as an issue */
    private static zzafh zzf(int i, zzfb zzfbVar, boolean z, int i2, zzafe zzafeVar) throws Throwable {
        int iZzo;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        String str;
        int i6;
        int i7;
        byte[] bArr;
        int iZzd;
        String strZza;
        int iZzl = zzfbVar.zzl();
        int iZzl2 = zzfbVar.zzl();
        int iZzl3 = zzfbVar.zzl();
        int iZzl4 = i >= 3 ? zzfbVar.zzl() : 0;
        if (i == 4) {
            iZzo = zzfbVar.zzo();
            if (!z) {
                iZzo = ((iZzo >> 24) << 21) | (iZzo & 255) | (((iZzo >> 8) & 255) << 7) | (((iZzo >> 16) & 255) << 14);
            }
        } else {
            iZzo = i == 3 ? zzfbVar.zzo() : zzfbVar.zzn();
        }
        int iZzp = i >= 3 ? zzfbVar.zzp() : 0;
        zzafh zzaeuVar = null;
        if (iZzl == 0 && iZzl2 == 0 && iZzl3 == 0 && iZzl4 == 0 && iZzo == 0 && iZzp == 0) {
            zzfbVar.zzG(zzfbVar.zzd());
            return null;
        }
        int iZzc = zzfbVar.zzc() + iZzo;
        if (iZzc > zzfbVar.zzd()) {
            zzer.zzf("Id3Decoder", "Frame size exceeds remaining tag data");
            zzfbVar.zzG(zzfbVar.zzd());
            return null;
        }
        if (zzafeVar != null) {
            zzfbVar.zzG(iZzc);
            return null;
        }
        if (i == 3) {
            int i8 = iZzp & 64;
            i3 = (iZzp & 128) != 0 ? 1 : 0;
            boolean z5 = i8 != 0;
            z2 = (iZzp & 32) != 0;
            z3 = z5;
            z4 = false;
            i4 = i3;
        } else if (i == 4) {
            boolean z6 = (iZzp & 64) != 0;
            i4 = (iZzp & 8) != 0 ? 1 : 0;
            z3 = (iZzp & 4) != 0;
            z4 = (iZzp & 2) != 0;
            int i9 = iZzp & 1;
            z2 = z6;
            i3 = i9;
        } else {
            i3 = 0;
            z2 = false;
            i4 = 0;
            z3 = false;
            z4 = false;
        }
        if (i4 != 0 || z3) {
            zzer.zzf("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            zzfbVar.zzG(iZzc);
            return null;
        }
        if (z2) {
            zzfbVar.zzH(1);
            iZzo--;
        }
        if (i3 != 0) {
            zzfbVar.zzH(4);
            iZzo -= 4;
        }
        if (z4) {
            iZzo = zze(zzfbVar, iZzo);
        }
        try {
            try {
                if (iZzl != 84 || iZzl2 != 88 || iZzl3 != 88 || (i != 2 && iZzl4 != 88)) {
                    if (iZzl == 84) {
                        String strZzi = zzi(i, 84, iZzl2, iZzl3, iZzl4);
                        if (iZzo > 0) {
                            int iZzl5 = zzfbVar.zzl();
                            int i10 = iZzo - 1;
                            byte[] bArr2 = new byte[i10];
                            zzfbVar.zzC(bArr2, 0, i10);
                            zzaeuVar = new zzafp(strZzi, null, zzg(bArr2, iZzl5, 0));
                        }
                        str = "Id3Decoder";
                        i7 = iZzl4;
                        iZzc = iZzc;
                        if (zzaeuVar == null) {
                            zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                        }
                        zzfbVar.zzG(iZzc);
                        return zzaeuVar;
                    }
                    if (iZzl != 87) {
                        i5 = iZzl;
                    } else if (iZzl2 != 88 || iZzl3 != 88 || (i != 2 && iZzl4 != 88)) {
                        i5 = 87;
                    } else if (iZzo > 0) {
                        int iZzl6 = zzfbVar.zzl();
                        int i11 = iZzo - 1;
                        byte[] bArr3 = new byte[i11];
                        zzfbVar.zzC(bArr3, 0, i11);
                        int iZzc2 = zzc(bArr3, 0, iZzl6);
                        String str2 = new String(bArr3, 0, iZzc2, zzj(iZzl6));
                        int iZzb = iZzc2 + zzb(iZzl6);
                        zzaeuVar = new zzafr("WXXX", str2, zzh(bArr3, iZzb, zzd(bArr3, iZzb), zzfsi.zzb));
                    }
                    if (i5 != 87) {
                        if (i5 == 80) {
                            if (iZzl2 == 82 && iZzl3 == 73 && iZzl4 == 86) {
                                byte[] bArr4 = new byte[iZzo];
                                zzfbVar.zzC(bArr4, 0, iZzo);
                                int iZzd2 = zzd(bArr4, 0);
                                zzaeuVar = new zzafn(new String(bArr4, 0, iZzd2, zzfsi.zzb), zzl(bArr4, iZzd2 + 1, iZzo));
                            } else {
                                i5 = 80;
                            }
                        }
                        if (i5 != 71) {
                            if (i == 2) {
                                if (i5 != 80 && iZzl2 == 73 && iZzl3 == 67) {
                                    int iZzl7 = zzfbVar.zzl();
                                    Charset charsetZzj = zzj(iZzl7);
                                    int i12 = iZzo - 1;
                                    bArr = new byte[i12];
                                    zzfbVar.zzC(bArr, 0, i12);
                                    if (i == 2) {
                                        strZza = "image/".concat(String.valueOf(zzfsc.zza(new String(bArr, 0, 3, zzfsi.zzb))));
                                        if ("image/jpg".equals(strZza)) {
                                            strZza = "image/jpeg";
                                        }
                                        iZzd = 2;
                                    } else {
                                        iZzd = zzd(bArr, 0);
                                        strZza = zzfsc.zza(new String(bArr, 0, iZzd, zzfsi.zzb));
                                        if (strZza.indexOf(47) == -1) {
                                            strZza = "image/".concat(String.valueOf(strZza));
                                        }
                                    }
                                    int i13 = bArr[iZzd + 1] & 255;
                                    int i14 = iZzd + 2;
                                    int iZzc3 = zzc(bArr, i14, iZzl7);
                                    str = "Id3Decoder";
                                    iZzl = iZzl;
                                    zzaeuVar = new zzaes(strZza, new String(bArr, i14, iZzc3 - i14, charsetZzj), i13, zzl(bArr, iZzc3 + zzb(iZzl7), i12));
                                } else {
                                    iZzl = iZzl;
                                    str = "Id3Decoder";
                                    if (i5 != 67 && iZzl2 == 79 && iZzl3 == 77 && (iZzl4 == 77 || i == 2)) {
                                        if (iZzo < 4) {
                                            iZzl2 = iZzl2;
                                            iZzl3 = iZzl3;
                                            i7 = iZzl4;
                                            zzaeuVar = null;
                                        } else {
                                            int iZzl8 = zzfbVar.zzl();
                                            Charset charsetZzj2 = zzj(iZzl8);
                                            byte[] bArr5 = new byte[3];
                                            zzfbVar.zzC(bArr5, 0, 3);
                                            String str3 = new String(bArr5, 0, 3);
                                            int i15 = iZzo - 4;
                                            byte[] bArr6 = new byte[i15];
                                            zzfbVar.zzC(bArr6, 0, i15);
                                            int iZzc4 = zzc(bArr6, 0, iZzl8);
                                            String str4 = new String(bArr6, 0, iZzc4, charsetZzj2);
                                            int iZzb2 = iZzc4 + zzb(iZzl8);
                                            zzaeuVar = new zzafa(str3, str4, zzh(bArr6, iZzb2, zzc(bArr6, iZzb2, iZzl8), charsetZzj2));
                                        }
                                    } else if (i5 != 67 && iZzl2 == 72 && iZzl3 == 65 && iZzl4 == 80) {
                                        int iZzc5 = zzfbVar.zzc();
                                        int iZzd3 = zzd(zzfbVar.zzI(), iZzc5);
                                        String str5 = new String(zzfbVar.zzI(), iZzc5, iZzd3 - iZzc5, zzfsi.zzb);
                                        zzfbVar.zzG(iZzd3 + 1);
                                        int iZzf = zzfbVar.zzf();
                                        int iZzf2 = zzfbVar.zzf();
                                        long jZzt = zzfbVar.zzt();
                                        if (jZzt == 4294967295L) {
                                            jZzt = -1;
                                        }
                                        long j = jZzt;
                                        long jZzt2 = zzfbVar.zzt();
                                        if (jZzt2 == 4294967295L) {
                                            jZzt2 = -1;
                                        }
                                        long j2 = jZzt2;
                                        ArrayList arrayList = new ArrayList();
                                        int i16 = iZzc5 + iZzo;
                                        while (zzfbVar.zzc() < i16) {
                                            zzafh zzafhVarZzf = zzf(i, zzfbVar, z, i2, null);
                                            if (zzafhVarZzf != null) {
                                                arrayList.add(zzafhVarZzf);
                                            }
                                        }
                                        zzaeuVar = new zzaew(str5, iZzf, iZzf2, j, j2, (zzafh[]) arrayList.toArray(new zzafh[0]));
                                    } else if (i5 != 67 && iZzl2 == 84 && iZzl3 == 79 && iZzl4 == 67) {
                                        int iZzc6 = zzfbVar.zzc();
                                        int iZzd4 = zzd(zzfbVar.zzI(), iZzc6);
                                        String str6 = new String(zzfbVar.zzI(), iZzc6, iZzd4 - iZzc6, zzfsi.zzb);
                                        zzfbVar.zzG(iZzd4 + 1);
                                        int iZzl9 = zzfbVar.zzl();
                                        boolean z7 = (iZzl9 & 2) != 0;
                                        int i17 = iZzl9 & 1;
                                        int iZzl10 = zzfbVar.zzl();
                                        String[] strArr = new String[iZzl10];
                                        int i18 = 0;
                                        while (i18 < iZzl10) {
                                            int iZzc7 = zzfbVar.zzc();
                                            int iZzd5 = zzd(zzfbVar.zzI(), iZzc7);
                                            strArr[i18] = new String(zzfbVar.zzI(), iZzc7, iZzd5 - iZzc7, zzfsi.zzb);
                                            zzfbVar.zzG(iZzd5 + 1);
                                            i18++;
                                            iZzl10 = iZzl10;
                                            iZzl4 = iZzl4;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        int i19 = iZzl2;
                                        int i20 = iZzl3;
                                        int i21 = iZzl4;
                                        ArrayList arrayList2 = new ArrayList();
                                        int i22 = iZzc6 + iZzo;
                                        while (zzfbVar.zzc() < i22) {
                                            zzafh zzafhVarZzf2 = zzf(i, zzfbVar, z, i2, null);
                                            if (zzafhVarZzf2 != null) {
                                                arrayList2.add(zzafhVarZzf2);
                                            }
                                        }
                                        zzaeuVar = new zzaey(str6, z7, 1 == i17, strArr, (zzafh[]) arrayList2.toArray(new zzafh[0]));
                                        i7 = i21;
                                        iZzl3 = i20;
                                        iZzl2 = i19;
                                    } else {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76 && i7 == 84) {
                                                    int iZzp2 = zzfbVar.zzp();
                                                    int iZzn = zzfbVar.zzn();
                                                    int iZzn2 = zzfbVar.zzn();
                                                    int iZzl11 = zzfbVar.zzl();
                                                    int iZzl12 = zzfbVar.zzl();
                                                    zzfa zzfaVar = new zzfa();
                                                    zzfaVar.zzh(zzfbVar);
                                                    int i23 = ((iZzo - 10) * 8) / (iZzl11 + iZzl12);
                                                    int[] iArr = new int[i23];
                                                    int[] iArr2 = new int[i23];
                                                    for (int i24 = 0; i24 < i23; i24++) {
                                                        int iZzd6 = zzfaVar.zzd(iZzl11);
                                                        int iZzd7 = zzfaVar.zzd(iZzl12);
                                                        iArr[i24] = iZzd6;
                                                        iArr2[i24] = iZzd7;
                                                    }
                                                    zzaeuVar = new zzafl(iZzp2, iZzn, iZzn2, iArr, iArr2);
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi2 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr7 = new byte[iZzo];
                                        zzfbVar.zzC(bArr7, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi2, bArr7);
                                    }
                                }
                                if (zzaeuVar == null) {
                                    zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                                }
                                zzfbVar.zzG(iZzc);
                                return zzaeuVar;
                            }
                            if (i5 == 65 || iZzl2 != 80 || iZzl3 != 73 || iZzl4 != 67) {
                                iZzl = iZzl;
                                str = "Id3Decoder";
                                if (i5 != 67) {
                                    if (i5 != 67) {
                                    }
                                    if (i5 != 67) {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi3 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr8 = new byte[iZzo];
                                        zzfbVar.zzC(bArr8, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi3, bArr8);
                                    } else {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi4 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr9 = new byte[iZzo];
                                        zzfbVar.zzC(bArr9, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi4, bArr9);
                                    }
                                } else {
                                    if (i5 != 67) {
                                    }
                                    if (i5 != 67) {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi5 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr10 = new byte[iZzo];
                                        zzfbVar.zzC(bArr10, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi5, bArr10);
                                    } else {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi6 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr11 = new byte[iZzo];
                                        zzfbVar.zzC(bArr11, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi6, bArr11);
                                    }
                                }
                                if (zzaeuVar == null) {
                                    zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                                }
                                zzfbVar.zzG(iZzc);
                                return zzaeuVar;
                            }
                            int iZzl13 = zzfbVar.zzl();
                            Charset charsetZzj3 = zzj(iZzl13);
                            int i110 = iZzo - 1;
                            bArr = new byte[i110];
                            zzfbVar.zzC(bArr, 0, i110);
                            if (i == 2) {
                                strZza = "image/".concat(String.valueOf(zzfsc.zza(new String(bArr, 0, 3, zzfsi.zzb))));
                                if ("image/jpg".equals(strZza)) {
                                    strZza = "image/jpeg";
                                }
                                iZzd = 2;
                            } else {
                                iZzd = zzd(bArr, 0);
                                strZza = zzfsc.zza(new String(bArr, 0, iZzd, zzfsi.zzb));
                                if (strZza.indexOf(47) == -1) {
                                    strZza = "image/".concat(String.valueOf(strZza));
                                }
                            }
                            int i111 = bArr[iZzd + 1] & 255;
                            int i112 = iZzd + 2;
                            int iZzc8 = zzc(bArr, i112, iZzl13);
                            str = "Id3Decoder";
                            iZzl = iZzl;
                            zzaeuVar = new zzaes(strZza, new String(bArr, i112, iZzc8 - i112, charsetZzj3), i111, zzl(bArr, iZzc8 + zzb(iZzl13), i110));
                        } else {
                            if (iZzl2 != 69 || iZzl3 != 79) {
                                i5 = 71;
                                if (i == 2) {
                                    if (i5 != 80) {
                                    }
                                    iZzl = iZzl;
                                    str = "Id3Decoder";
                                    if (i5 != 67) {
                                        if (i5 != 67) {
                                        }
                                        if (i5 != 67) {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi7 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr12 = new byte[iZzo];
                                            zzfbVar.zzC(bArr12, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi7, bArr12);
                                        } else {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi8 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr13 = new byte[iZzo];
                                            zzfbVar.zzC(bArr13, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi8, bArr13);
                                        }
                                    } else {
                                        if (i5 != 67) {
                                        }
                                        if (i5 != 67) {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi9 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr14 = new byte[iZzo];
                                            zzfbVar.zzC(bArr14, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi9, bArr14);
                                        } else {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi10 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr15 = new byte[iZzo];
                                            zzfbVar.zzC(bArr15, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi10, bArr15);
                                        }
                                    }
                                    if (zzaeuVar == null) {
                                        zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                                    }
                                    zzfbVar.zzG(iZzc);
                                    return zzaeuVar;
                                }
                                if (i5 == 65) {
                                }
                                iZzl = iZzl;
                                str = "Id3Decoder";
                                if (i5 != 67) {
                                    if (i5 != 67) {
                                    }
                                    if (i5 != 67) {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi11 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr16 = new byte[iZzo];
                                        zzfbVar.zzC(bArr16, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi11, bArr16);
                                    } else {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi12 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr17 = new byte[iZzo];
                                        zzfbVar.zzC(bArr17, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi12, bArr17);
                                    }
                                } else {
                                    if (i5 != 67) {
                                    }
                                    if (i5 != 67) {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi13 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr18 = new byte[iZzo];
                                        zzfbVar.zzC(bArr18, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi13, bArr18);
                                    } else {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi14 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr19 = new byte[iZzo];
                                        zzfbVar.zzC(bArr19, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi14, bArr19);
                                    }
                                }
                                if (zzaeuVar == null) {
                                    zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                                }
                                zzfbVar.zzG(iZzc);
                                return zzaeuVar;
                            }
                            if (iZzl4 != 66 && i != 2) {
                                i5 = 71;
                                if (i == 2) {
                                    if (i5 != 80) {
                                    }
                                    iZzl = iZzl;
                                    str = "Id3Decoder";
                                    if (i5 != 67) {
                                        if (i5 != 67) {
                                        }
                                        if (i5 != 67) {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi15 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr110 = new byte[iZzo];
                                            zzfbVar.zzC(bArr110, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi15, bArr110);
                                        } else {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi16 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr111 = new byte[iZzo];
                                            zzfbVar.zzC(bArr111, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi16, bArr111);
                                        }
                                    } else {
                                        if (i5 != 67) {
                                        }
                                        if (i5 != 67) {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi17 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr112 = new byte[iZzo];
                                            zzfbVar.zzC(bArr112, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi17, bArr112);
                                        } else {
                                            i6 = iZzl4;
                                            if (i5 == 77) {
                                                iZzl2 = iZzl2;
                                                if (iZzl2 == 76) {
                                                    iZzl3 = iZzl3;
                                                    i7 = i6;
                                                    if (iZzl3 != 76) {
                                                    }
                                                } else {
                                                    i7 = i6;
                                                    iZzl3 = iZzl3;
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                                iZzl2 = iZzl2;
                                            }
                                            String strZzi18 = zzi(i, i5, iZzl2, iZzl3, i7);
                                            byte[] bArr113 = new byte[iZzo];
                                            zzfbVar.zzC(bArr113, 0, iZzo);
                                            zzaeuVar = new zzaeu(strZzi18, bArr113);
                                        }
                                    }
                                    if (zzaeuVar == null) {
                                        zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                                    }
                                    zzfbVar.zzG(iZzc);
                                    return zzaeuVar;
                                }
                                if (i5 == 65) {
                                }
                                iZzl = iZzl;
                                str = "Id3Decoder";
                                if (i5 != 67) {
                                    if (i5 != 67) {
                                    }
                                    if (i5 != 67) {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi19 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr114 = new byte[iZzo];
                                        zzfbVar.zzC(bArr114, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi19, bArr114);
                                    } else {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi110 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr115 = new byte[iZzo];
                                        zzfbVar.zzC(bArr115, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi110, bArr115);
                                    }
                                } else {
                                    if (i5 != 67) {
                                    }
                                    if (i5 != 67) {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi111 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr116 = new byte[iZzo];
                                        zzfbVar.zzC(bArr116, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi111, bArr116);
                                    } else {
                                        i6 = iZzl4;
                                        if (i5 == 77) {
                                            iZzl2 = iZzl2;
                                            if (iZzl2 == 76) {
                                                iZzl3 = iZzl3;
                                                i7 = i6;
                                                if (iZzl3 != 76) {
                                                }
                                            } else {
                                                i7 = i6;
                                                iZzl3 = iZzl3;
                                            }
                                        } else {
                                            i7 = i6;
                                            iZzl3 = iZzl3;
                                            iZzl2 = iZzl2;
                                        }
                                        String strZzi112 = zzi(i, i5, iZzl2, iZzl3, i7);
                                        byte[] bArr117 = new byte[iZzo];
                                        zzfbVar.zzC(bArr117, 0, iZzo);
                                        zzaeuVar = new zzaeu(strZzi112, bArr117);
                                    }
                                }
                                if (zzaeuVar == null) {
                                    zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                                }
                                zzfbVar.zzG(iZzc);
                                return zzaeuVar;
                            }
                            int iZzl14 = zzfbVar.zzl();
                            Charset charsetZzj4 = zzj(iZzl14);
                            int i25 = iZzo - 1;
                            byte[] bArr20 = new byte[i25];
                            zzfbVar.zzC(bArr20, 0, i25);
                            int iZzd8 = zzd(bArr20, 0);
                            iZzc = iZzc;
                            String str7 = new String(bArr20, 0, iZzd8, zzfsi.zzb);
                            int i26 = iZzd8 + 1;
                            int iZzc9 = zzc(bArr20, i26, iZzl14);
                            String strZzh = zzh(bArr20, i26, iZzc9, charsetZzj4);
                            int iZzb3 = iZzc9 + zzb(iZzl14);
                            int iZzc10 = zzc(bArr20, iZzb3, iZzl14);
                            iZzl = iZzl;
                            zzaeuVar = new zzafc(str7, strZzh, zzh(bArr20, iZzb3, iZzc10, charsetZzj4), zzl(bArr20, iZzc10 + zzb(iZzl14), i25));
                            str = "Id3Decoder";
                        }
                        i7 = iZzl4;
                        if (zzaeuVar == null) {
                            zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                        }
                        zzfbVar.zzG(iZzc);
                        return zzaeuVar;
                    }
                    String strZzi20 = zzi(i, 87, iZzl2, iZzl3, iZzl4);
                    byte[] bArr21 = new byte[iZzo];
                    zzfbVar.zzC(bArr21, 0, iZzo);
                    zzaeuVar = new zzafr(strZzi20, null, new String(bArr21, 0, zzd(bArr21, 0), zzfsi.zzb));
                } else if (iZzo > 0) {
                    int iZzl15 = zzfbVar.zzl();
                    int i27 = iZzo - 1;
                    byte[] bArr22 = new byte[i27];
                    zzfbVar.zzC(bArr22, 0, i27);
                    int iZzc11 = zzc(bArr22, 0, iZzl15);
                    zzaeuVar = new zzafp("TXXX", new String(bArr22, 0, iZzc11, zzj(iZzl15)), zzg(bArr22, iZzl15, iZzc11 + zzb(iZzl15)));
                }
                str = "Id3Decoder";
                i7 = iZzl4;
                iZzc = iZzc;
                if (zzaeuVar == null) {
                    zzer.zzf(str, "Failed to decode frame: id=" + zzi(i, iZzl, iZzl2, iZzl3, i7) + ", frameSize=" + iZzo);
                }
                zzfbVar.zzG(iZzc);
                return zzaeuVar;
            } catch (Throwable th) {
                th = th;
                iZzc = iZzc;
                zzfbVar.zzG(iZzc);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zzfbVar.zzG(iZzc);
            throw th;
        }
    }

    private static zzfvs zzg(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzfvs.zzm("");
        }
        zzfvp zzfvpVar = new zzfvp();
        int iZzc = zzc(bArr, i2, i);
        while (i2 < iZzc) {
            zzfvpVar.zzf(new String(bArr, i2, iZzc - i2, zzj(i)));
            i2 = zzb(i) + iZzc;
            iZzc = zzc(bArr, i2, i);
        }
        zzfvs zzfvsVarZzi = zzfvpVar.zzi();
        return zzfvsVarZzi.isEmpty() ? zzfvs.zzm("") : zzfvsVarZzi;
    }

    private static String zzh(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzi(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static boolean zzk(zzfb zzfbVar, int i, int i2, boolean z) {
        int iZzn;
        long jZzn;
        int iZzp;
        int i3;
        int iZzc = zzfbVar.zzc();
        while (true) {
            try {
                int i4 = 1;
                if (zzfbVar.zza() < i2) {
                    zzfbVar.zzG(iZzc);
                    return true;
                }
                if (i >= 3) {
                    iZzn = zzfbVar.zzf();
                    jZzn = zzfbVar.zzt();
                    iZzp = zzfbVar.zzp();
                } else {
                    iZzn = zzfbVar.zzn();
                    jZzn = zzfbVar.zzn();
                    iZzp = 0;
                }
                if (iZzn == 0 && jZzn == 0 && iZzp == 0) {
                    zzfbVar.zzG(iZzc);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jZzn) != 0) {
                        zzfbVar.zzG(iZzc);
                        return false;
                    }
                    jZzn = ((jZzn >> 24) << 21) | (((jZzn >> 16) & 255) << 14) | (jZzn & 255) | (((jZzn >> 8) & 255) << 7);
                }
                if (i == 4) {
                    i4 = iZzp & 1;
                    i3 = (iZzp & 64) == 0 ? 0 : 1;
                } else if (i == 3) {
                    i3 = (iZzp & 32) != 0 ? 1 : 0;
                    if ((iZzp & 128) == 0) {
                        i4 = 0;
                    }
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (i4 != 0) {
                    i3 += 4;
                }
                if (jZzn < i3) {
                    zzfbVar.zzG(iZzc);
                    return false;
                }
                if (zzfbVar.zza() < jZzn) {
                    zzfbVar.zzG(iZzc);
                    return false;
                }
                zzfbVar.zzH((int) jZzn);
            } catch (Throwable th) {
                zzfbVar.zzG(iZzc);
                throw th;
            }
        }
    }

    private static byte[] zzl(byte[] bArr, int i, int i2) {
        return i2 <= i ? zzfk.zzf : Arrays.copyOfRange(bArr, i, i2);
    }

    private static Charset zzj(int i) {
        if (i == 1) {
            return zzfsi.zzf;
        }
        if (i != 2) {
            return i != 3 ? zzfsi.zzb : zzfsi.zzc;
        }
        return zzfsi.zzd;
    }
}
