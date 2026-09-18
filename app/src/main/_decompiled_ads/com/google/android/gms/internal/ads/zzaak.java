package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaak {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzaaj zza(byte[] bArr) throws zzcc {
        return zzb(new zzfa(bArr, bArr.length), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b4, code lost:
    
        if (r11 != 3) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzaaj zzb(com.google.android.gms.internal.ads.zzfa r11, boolean r12) throws com.google.android.gms.internal.ads.zzcc {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzb(com.google.android.gms.internal.ads.zzfa, boolean):com.google.android.gms.internal.ads.zzaaj");
    }

    private static int zzc(zzfa zzfaVar) {
        int iZzd = zzfaVar.zzd(5);
        return iZzd == 31 ? zzfaVar.zzd(6) + 32 : iZzd;
    }

    private static int zzd(zzfa zzfaVar) throws zzcc {
        int iZzd = zzfaVar.zzd(4);
        if (iZzd == 15) {
            if (zzfaVar.zza() >= 24) {
                return zzfaVar.zzd(24);
            }
            throw zzcc.zza("AAC header insufficient data", null);
        }
        if (iZzd < 13) {
            return zzb[iZzd];
        }
        throw zzcc.zza("AAC header wrong Sampling Frequency Index", null);
    }
}
