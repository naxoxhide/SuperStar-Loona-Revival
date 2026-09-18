package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzsb {
    public static void zza(zzru zzruVar, zzol zzolVar) {
        LogSessionId logSessionIdZza = zzolVar.zza();
        if (logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        zzruVar.zzb.setString("log-session-id", logSessionIdZza.getStringId());
    }
}
