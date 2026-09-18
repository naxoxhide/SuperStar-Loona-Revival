package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjd {
    public static void zza(ListenableFuture listenableFuture, zzfje zzfjeVar, zzfit zzfitVar) {
        zzg(listenableFuture, zzfjeVar, zzfitVar, false);
    }

    public static void zzb(ListenableFuture listenableFuture, zzfje zzfjeVar, zzfit zzfitVar) {
        zzg(listenableFuture, zzfjeVar, zzfitVar, true);
    }

    public static void zzc(ListenableFuture listenableFuture, zzfje zzfjeVar, zzfit zzfitVar) {
        if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
            zzfzt.zzr(zzfzk.zzu(listenableFuture), new zzfjc(zzfjeVar, zzfitVar), zzcbg.zzf);
        }
    }

    public static void zzd(ListenableFuture listenableFuture, zzfit zzfitVar) {
        if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
            zzfzt.zzr(zzfzk.zzu(listenableFuture), new zzfja(zzfitVar), zzcbg.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziz), str);
    }

    public static int zzf(zzfdn zzfdnVar) {
        int iZze = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(zzfdnVar) - 1;
        return (iZze == 0 || iZze == 1) ? 7 : 23;
    }

    private static void zzg(ListenableFuture listenableFuture, zzfje zzfjeVar, zzfit zzfitVar, boolean z) {
        if (((Boolean) zzbdu.zzc.zze()).booleanValue()) {
            zzfzt.zzr(zzfzk.zzu(listenableFuture), new zzfjb(zzfjeVar, zzfitVar, z), zzcbg.zzf);
        }
    }
}
