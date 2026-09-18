package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabj {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static zzam zza(byte[] bArr, String str, String str2, zzad zzadVar) {
        zzfa zzfaVar;
        if (bArr[0] == 127) {
            zzfaVar = new zzfa(bArr, bArr.length);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            byte b2 = bArrCopyOf[0];
            if (b2 == -2 || b2 == -1) {
                for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                    byte b3 = bArrCopyOf[i];
                    int i2 = i + 1;
                    bArrCopyOf[i] = bArrCopyOf[i2];
                    bArrCopyOf[i2] = b3;
                }
            }
            int length = bArrCopyOf.length;
            zzfaVar = new zzfa(bArrCopyOf, length);
            if (bArrCopyOf[0] == 31) {
                zzfa zzfaVar2 = new zzfa(bArrCopyOf, length);
                while (zzfaVar2.zza() >= 16) {
                    zzfaVar2.zzl(2);
                    zzfaVar.zzf(zzfaVar2.zzd(14), 14);
                }
            }
            zzfaVar.zzi(bArrCopyOf, bArrCopyOf.length);
        }
        zzfaVar.zzl(60);
        int i3 = zzb[zzfaVar.zzd(6)];
        int i4 = zzc[zzfaVar.zzd(4)];
        int iZzd = zzfaVar.zzd(5);
        int i5 = iZzd < 29 ? (zzd[iZzd] * 1000) / 2 : -1;
        zzfaVar.zzl(10);
        int i6 = i3 + (zzfaVar.zzd(2) > 0 ? 1 : 0);
        zzak zzakVar = new zzak();
        zzakVar.zzJ(str);
        zzakVar.zzU("audio/vnd.dts");
        zzakVar.zzx(i5);
        zzakVar.zzy(i6);
        zzakVar.zzV(i4);
        zzakVar.zzD(null);
        zzakVar.zzM(str2);
        return zzakVar.zzac();
    }
}
