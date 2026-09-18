package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjs {
    public static zzol zza(Context context, zzkb zzkbVar, boolean z) {
        zzoh zzohVarZzb = zzoh.zzb(context);
        if (zzohVarZzb == null) {
            zzer.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zzol(LogSessionId.LOG_SESSION_ID_NONE);
        }
        if (z) {
            zzkbVar.zzz(zzohVarZzb);
        }
        return new zzol(zzohVarZzb.zza());
    }
}
