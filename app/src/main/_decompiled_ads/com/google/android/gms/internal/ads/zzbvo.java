package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbvo {
    private final WeakHashMap zza = new WeakHashMap();

    public final Future zzb(Context context) {
        return zzcbg.zza.zzb(new zzbvm(this, context));
    }
}
