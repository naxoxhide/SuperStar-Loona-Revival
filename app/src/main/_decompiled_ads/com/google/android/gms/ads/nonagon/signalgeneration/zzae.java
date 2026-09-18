package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzayf;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzae {
    private final String zza;

    /* synthetic */ zzae(zzac zzacVar, zzad zzadVar) {
        this.zza = zzacVar.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    public final zzayf zza() {
        byte b2;
        switch (this.zza) {
            case "NATIVE":
                b2 = 2;
                break;
            case "INTERSTITIAL":
                b2 = 1;
                break;
            case "REWARDED":
                b2 = 3;
                break;
            case "BANNER":
                b2 = 0;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0) {
            return zzayf.BANNER;
        }
        if (b2 == 1) {
            return zzayf.INTERSTITIAL;
        }
        if (b2 != 2) {
            return b2 != 3 ? zzayf.AD_INITIATER_UNSPECIFIED : zzayf.REWARD_BASED_VIDEO_AD;
        }
        return zzayf.AD_LOADER;
    }

    public final String zzb() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    public final Set zzc() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
