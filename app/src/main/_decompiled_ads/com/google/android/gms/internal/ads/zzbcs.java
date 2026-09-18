package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzbcs {
    public static boolean zza(zzbda zzbdaVar, zzbcx zzbcxVar, String... strArr) {
        if (zzbcxVar == null) {
            return false;
        }
        zzbdaVar.zze(zzbcxVar, com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
