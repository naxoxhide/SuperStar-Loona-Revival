package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlz {
    private final PowerManager zza;

    public zzlz(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
