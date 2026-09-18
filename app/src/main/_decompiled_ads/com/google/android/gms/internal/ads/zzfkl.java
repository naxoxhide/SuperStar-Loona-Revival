package com.google.android.gms.internal.ads;

import com.facebook.appevents.integrity.IntegrityManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzfkl {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE(IntegrityManager.INTEGRITY_TYPE_NONE);

    private final String zze;

    zzfkl(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
