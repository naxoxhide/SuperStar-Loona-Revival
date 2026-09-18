package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcbj {
    public static void zza(ListenableFuture listenableFuture, String str) {
        zzfzt.zzr(listenableFuture, new zzcbh(str), zzcbg.zzf);
    }

    public static void zzb(ListenableFuture listenableFuture, String str) {
        zzfzt.zzr(listenableFuture, new zzcbi("ActiveViewListener.callActiveViewJs"), zzcbg.zzf);
    }
}
