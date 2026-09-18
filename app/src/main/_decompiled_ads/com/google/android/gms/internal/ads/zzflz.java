package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzflz implements Runnable {
    zzflz() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzfmc.zzc != null) {
            zzfmc.zzc.post(zzfmc.zzd);
            zzfmc.zzc.postDelayed(zzfmc.zze, 200L);
        }
    }
}
