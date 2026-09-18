package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaaq {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {AdError.CACHE_ERROR_CODE, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Code duplicated, block: B:47:0x0097  */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    public static zzaap zza(zzfa zzfaVar) {
        int i;
        int i2;
        int iZzd;
        int iZzd2 = zzfaVar.zzd(16);
        int iZzd3 = zzfaVar.zzd(16);
        if (iZzd3 == 65535) {
            iZzd3 = zzfaVar.zzd(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iZzd3 + i;
        if (iZzd2 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iZzd4 = zzfaVar.zzd(2);
        int i5 = 0;
        if (iZzd4 == 3) {
            int i6 = 0;
            while (true) {
                iZzd = i6 + zzfaVar.zzd(2);
                if (!zzfaVar.zzn()) {
                    break;
                }
                i6 = (iZzd + 1) << 2;
            }
            iZzd4 = iZzd + 3;
        }
        int iZzd5 = zzfaVar.zzd(10);
        if (zzfaVar.zzn() && zzfaVar.zzd(3) > 0) {
            zzfaVar.zzl(2);
        }
        int i7 = true != zzfaVar.zzn() ? 44100 : 48000;
        int iZzd6 = zzfaVar.zzd(4);
        if (i7 == 44100 && iZzd6 == 13) {
            i2 = zzb[13];
        } else {
            if (i7 == 48000 && iZzd6 < 14) {
                i5 = zzb[iZzd6];
                int i8 = iZzd5 % 5;
                if (i8 == 1) {
                    if (iZzd6 != 3 || iZzd6 == 8) {
                        i5++;
                    }
                } else if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4 && (iZzd6 == 3 || iZzd6 == 8 || iZzd6 == 11)) {
                            i5++;
                        }
                    } else if (iZzd6 != 3) {
                        i5++;
                    } else {
                        i5++;
                    }
                } else if (iZzd6 == 8 || iZzd6 == 11) {
                    i5++;
                }
            }
            i2 = i5;
        }
        return new zzaap(iZzd4, 2, i7, i4, i2, null);
    }

    public static void zzb(int i, zzfb zzfbVar) {
        zzfbVar.zzD(7);
        byte[] bArrZzI = zzfbVar.zzI();
        bArrZzI[0] = -84;
        bArrZzI[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrZzI[2] = -1;
        bArrZzI[3] = -1;
        bArrZzI[4] = (byte) ((i >> 16) & 255);
        bArrZzI[5] = (byte) ((i >> 8) & 255);
        bArrZzI[6] = (byte) (i & 255);
    }
}
