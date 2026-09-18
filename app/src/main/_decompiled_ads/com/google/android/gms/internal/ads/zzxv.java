package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxv {
    private final Handler zza;
    private final zzxx zzb;
    private boolean zzc;

    public zzxv(Handler handler, zzxx zzxxVar) {
        this.zza = handler;
        this.zzb = zzxxVar;
    }

    public final void zzc() {
        this.zzc = true;
    }
}
