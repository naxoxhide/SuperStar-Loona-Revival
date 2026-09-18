package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzfzk extends zzfzu {
    zzfzk() {
    }

    public static zzfzk zzu(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzfzk ? (zzfzk) listenableFuture : new zzfzl(listenableFuture);
    }
}
