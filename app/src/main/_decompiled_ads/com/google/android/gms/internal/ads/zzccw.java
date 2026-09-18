package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccw {
    private long zzb;
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzD)).longValue());
    private boolean zzc = true;

    zzccw() {
    }

    public final void zza(SurfaceTexture surfaceTexture, final zzcch zzcchVar) {
        if (zzcchVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            long j = timestamp - this.zzb;
            if (Math.abs(j) < this.zza) {
                return;
            }
        }
        this.zzc = false;
        this.zzb = timestamp;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccv
            @Override // java.lang.Runnable
            public final void run() {
                zzcchVar.zzk();
            }
        });
    }

    public final void zzb() {
        this.zzc = true;
    }
}
