package com.android.billingclient.api;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.android.billingclient:billing@@5.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbv {
    private String zza;

    private zzbv() {
    }

    /* synthetic */ zzbv(zzbu zzbuVar) {
    }

    public final zzbv zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzbx zzb() {
        if (TextUtils.isEmpty(this.zza)) {
            throw new IllegalArgumentException("SKU must be set.");
        }
        return new zzbx(this.zza, null, null, 0, null);
    }
}
