package com.google.android.play.core.assetpacks;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
public final class AssetPackManagerFactory {
    private AssetPackManagerFactory() {
    }

    public static synchronized AssetPackManager getInstance(Context context) {
        return zzd.zza(context).zza();
    }
}
