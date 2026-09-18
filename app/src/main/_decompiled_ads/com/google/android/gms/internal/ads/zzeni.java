package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeni implements zzetw {
    private final Context zza;

    zzeni(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcG)).booleanValue()) {
            return zzfzt.zzh(new zzenj(ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
        }
        return zzfzt.zzh(null);
    }
}
