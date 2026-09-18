package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzflq {
    private static int zza = 2;

    public static void zza(Context context) {
        context.registerReceiver(new zzflp(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }

    public static int zzb() {
        if (zzflm.zza() != zzfki.CTV) {
            return 2;
        }
        return zza;
    }
}
