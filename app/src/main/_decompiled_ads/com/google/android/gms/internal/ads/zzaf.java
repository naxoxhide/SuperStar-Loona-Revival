package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaf {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzaf zza(int i) {
        zzdx.zzf(!this.zzb);
        this.zza.append(i, true);
        return this;
    }

    public final zzah zzb() {
        zzdx.zzf(!this.zzb);
        this.zzb = true;
        return new zzah(this.zza, null);
    }
}
