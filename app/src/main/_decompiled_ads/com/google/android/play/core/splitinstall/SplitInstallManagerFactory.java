package com.google.android.play.core.splitinstall;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
public final class SplitInstallManagerFactory {
    private SplitInstallManagerFactory() {
    }

    public static SplitInstallManager create(Context context) {
        return zzu.zza(context).zza();
    }
}
