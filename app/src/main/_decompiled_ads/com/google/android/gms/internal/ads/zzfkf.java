package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzfkf {
    HTML(TJAdUnitConstants.String.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String zze;

    zzfkf(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
