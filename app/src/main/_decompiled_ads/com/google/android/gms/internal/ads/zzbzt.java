package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbzt {
    public final ListenableFuture zza(Context context, int i) {
        zzcbl zzcblVar = new zzcbl();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        if (zzcam.zzt(context)) {
            zzcbg.zza.execute(new zzbzs(this, context, zzcblVar));
        }
        return zzcblVar;
    }
}
