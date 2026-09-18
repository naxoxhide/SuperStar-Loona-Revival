package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzma {
    private final WifiManager zza;

    public zzma(Context context) {
        this.zza = (WifiManager) context.getApplicationContext().getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI);
    }
}
