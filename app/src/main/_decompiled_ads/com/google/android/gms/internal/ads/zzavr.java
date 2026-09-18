package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzavr implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzavv zzb;

    zzavr(zzavv zzavvVar, View view) {
        this.zzb = zzavvVar;
        this.zza = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
