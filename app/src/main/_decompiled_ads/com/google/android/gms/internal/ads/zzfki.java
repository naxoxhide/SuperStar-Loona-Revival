package com.google.android.gms.internal.ads;

import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzfki {
    CTV("ctv"),
    MOBILE(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE),
    OTHER("other");

    private final String zze;

    zzfki(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
