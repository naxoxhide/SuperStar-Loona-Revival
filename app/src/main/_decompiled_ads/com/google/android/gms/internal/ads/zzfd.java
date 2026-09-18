package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfd implements zzdy {
    protected zzfd() {
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final zzei zzb(Looper looper, Handler.Callback callback) {
        return new zzfg(new Handler(looper, callback));
    }
}
