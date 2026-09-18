package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaan {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b2 = bArr[4];
            return zzf((b2 & 192) >> 6, b2 & 63);
        }
        int i = bArr[2] & 7;
        int i2 = ((bArr[3] & 255) | (i << 8)) + 1;
        return i2 + i2;
    }

    public static zzam zzc(zzfb zzfbVar, String str, String str2, zzad zzadVar) {
        zzfa zzfaVar = new zzfa();
        zzfaVar.zzh(zzfbVar);
        int i = zzc[zzfaVar.zzd(2)];
        zzfaVar.zzl(8);
        int i2 = zze[zzfaVar.zzd(3)];
        if (zzfaVar.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzfaVar.zzd(5)] * 1000;
        zzfaVar.zze();
        zzfbVar.zzG(zzfaVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzJ(str);
        zzakVar.zzU("audio/ac3");
        zzakVar.zzy(i2);
        zzakVar.zzV(i);
        zzakVar.zzD(zzadVar);
        zzakVar.zzM(str2);
        zzakVar.zzx(i3);
        zzakVar.zzQ(i3);
        return zzakVar.zzac();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0062  */
    public static zzam zzd(zzfb zzfbVar, String str, String str2, zzad zzadVar) {
        String str3;
        zzfa zzfaVar = new zzfa();
        zzfaVar.zzh(zzfbVar);
        int iZzd = zzfaVar.zzd(13) * 1000;
        zzfaVar.zzl(3);
        int i = zzc[zzfaVar.zzd(2)];
        zzfaVar.zzl(10);
        int i2 = zze[zzfaVar.zzd(3)];
        if (zzfaVar.zzd(1) != 0) {
            i2++;
        }
        zzfaVar.zzl(3);
        int iZzd2 = zzfaVar.zzd(4);
        zzfaVar.zzl(1);
        if (iZzd2 > 0) {
            zzfaVar.zzl(6);
            if (zzfaVar.zzd(1) != 0) {
                i2 += 2;
            }
            zzfaVar.zzl(1);
        }
        if (zzfaVar.zza() > 7) {
            zzfaVar.zzl(7);
            if (zzfaVar.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
        } else {
            str3 = "audio/eac3";
        }
        zzfaVar.zze();
        zzfbVar.zzG(zzfaVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzJ(str);
        zzakVar.zzU(str3);
        zzakVar.zzy(i2);
        zzakVar.zzV(i);
        zzakVar.zzD(zzadVar);
        zzakVar.zzM(str2);
        zzakVar.zzQ(iZzd);
        return zzakVar.zzac();
    }

    public static zzaam zze(zzfa zzfaVar) {
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzc = zzfaVar.zzc();
        zzfaVar.zzl(40);
        int iZzd = zzfaVar.zzd(5);
        zzfaVar.zzj(iZzc);
        int i12 = -1;
        if (iZzd > 10) {
            zzfaVar.zzl(16);
            int iZzd2 = zzfaVar.zzd(2);
            if (iZzd2 == 0) {
                i12 = 0;
            } else if (iZzd2 == 1) {
                i12 = 1;
            } else if (iZzd2 == 2) {
                i12 = 2;
            }
            zzfaVar.zzl(3);
            int iZzd3 = zzfaVar.zzd(11) + 1;
            int iZzd4 = zzfaVar.zzd(2);
            if (iZzd4 == 3) {
                i8 = zzd[zzfaVar.zzd(2)];
                i9 = 6;
                i7 = 3;
            } else {
                int iZzd5 = zzfaVar.zzd(2);
                int i13 = zzb[iZzd5];
                i7 = iZzd5;
                i8 = zzc[iZzd4];
                i9 = i13;
            }
            int i14 = iZzd3 + iZzd3;
            int i15 = (i14 * i8) / (i9 * 32);
            int iZzd6 = zzfaVar.zzd(3);
            boolean zZzn = zzfaVar.zzn();
            i = zze[iZzd6] + (zZzn ? 1 : 0);
            zzfaVar.zzl(10);
            if (zzfaVar.zzn()) {
                zzfaVar.zzl(8);
            }
            if (iZzd6 == 0) {
                zzfaVar.zzl(5);
                if (zzfaVar.zzn()) {
                    zzfaVar.zzl(8);
                }
                i10 = 0;
                iZzd6 = 0;
            } else {
                i10 = iZzd6;
            }
            if (i12 == 1) {
                if (zzfaVar.zzn()) {
                    zzfaVar.zzl(16);
                }
                i11 = 1;
            } else {
                i11 = i12;
            }
            if (zzfaVar.zzn()) {
                if (i10 > 2) {
                    zzfaVar.zzl(2);
                }
                if ((i10 & 1) != 0 && i10 > 2) {
                    zzfaVar.zzl(6);
                }
                if ((i10 & 4) != 0) {
                    zzfaVar.zzl(6);
                }
                if (zZzn && zzfaVar.zzn()) {
                    zzfaVar.zzl(5);
                }
                if (i11 == 0) {
                    if (zzfaVar.zzn()) {
                        zzfaVar.zzl(6);
                    }
                    if (i10 == 0 && zzfaVar.zzn()) {
                        zzfaVar.zzl(6);
                    }
                    if (zzfaVar.zzn()) {
                        zzfaVar.zzl(6);
                    }
                    int iZzd7 = zzfaVar.zzd(2);
                    if (iZzd7 == 1) {
                        zzfaVar.zzl(5);
                    } else if (iZzd7 == 2) {
                        zzfaVar.zzl(12);
                    } else if (iZzd7 == 3) {
                        int iZzd8 = zzfaVar.zzd(5);
                        if (zzfaVar.zzn()) {
                            zzfaVar.zzl(5);
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(4);
                            }
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(4);
                            }
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(4);
                            }
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(4);
                            }
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(4);
                            }
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(4);
                            }
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(4);
                            }
                            if (zzfaVar.zzn()) {
                                if (zzfaVar.zzn()) {
                                    zzfaVar.zzl(4);
                                }
                                if (zzfaVar.zzn()) {
                                    zzfaVar.zzl(4);
                                }
                            }
                        }
                        if (zzfaVar.zzn()) {
                            zzfaVar.zzl(5);
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(7);
                                if (zzfaVar.zzn()) {
                                    zzfaVar.zzl(8);
                                }
                            }
                        }
                        zzfaVar.zzl((iZzd8 + 2) * 8);
                        zzfaVar.zze();
                    }
                    if (i10 < 2) {
                        if (zzfaVar.zzn()) {
                            zzfaVar.zzl(14);
                        }
                        if (iZzd6 == 0 && zzfaVar.zzn()) {
                            zzfaVar.zzl(14);
                        }
                    }
                    if (!zzfaVar.zzn()) {
                        i11 = 0;
                    } else if (i7 == 0) {
                        zzfaVar.zzl(5);
                        i11 = 0;
                        i7 = 0;
                    } else {
                        for (int i16 = 0; i16 < i9; i16++) {
                            if (zzfaVar.zzn()) {
                                zzfaVar.zzl(5);
                            }
                        }
                        i11 = 0;
                    }
                }
            }
            if (zzfaVar.zzn()) {
                zzfaVar.zzl(5);
                if (i10 == 2) {
                    zzfaVar.zzl(4);
                    i10 = 2;
                }
                if (i10 >= 6) {
                    zzfaVar.zzl(2);
                }
                if (zzfaVar.zzn()) {
                    zzfaVar.zzl(8);
                }
                if (i10 == 0 && zzfaVar.zzn()) {
                    zzfaVar.zzl(8);
                }
                if (iZzd4 < 3) {
                    zzfaVar.zzk();
                }
            }
            if (i11 == 0 && i7 != 3) {
                zzfaVar.zzk();
            }
            if (i11 == 2 && (i7 == 3 || zzfaVar.zzn())) {
                zzfaVar.zzl(6);
            }
            str = (zzfaVar.zzn() && zzfaVar.zzd(6) == 1 && zzfaVar.zzd(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i2 = i12;
            i4 = i14;
            i5 = i8;
            i6 = i9 * 256;
            i3 = i15;
        } else {
            zzfaVar.zzl(32);
            int iZzd9 = zzfaVar.zzd(2);
            String str2 = iZzd9 == 3 ? null : "audio/ac3";
            int iZzd10 = zzfaVar.zzd(6);
            int i17 = zzf[iZzd10 / 2] * 1000;
            int iZzf = zzf(iZzd9, iZzd10);
            zzfaVar.zzl(8);
            int iZzd11 = zzfaVar.zzd(3);
            if ((iZzd11 & 1) != 0 && iZzd11 != 1) {
                zzfaVar.zzl(2);
            }
            if ((iZzd11 & 4) != 0) {
                zzfaVar.zzl(2);
            }
            if (iZzd11 == 2) {
                zzfaVar.zzl(2);
            }
            int i18 = iZzd9 < 3 ? zzc[iZzd9] : -1;
            i = zze[iZzd11] + (zzfaVar.zzn() ? 1 : 0);
            str = str2;
            i2 = -1;
            i3 = i17;
            i4 = iZzf;
            i5 = i18;
            i6 = 1536;
        }
        return new zzaam(str, i2, i, i5, i4, i6, i3, null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
