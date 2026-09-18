package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetp implements zzetw {
    private final boolean zza;

    zzetp(zzfam zzfamVar) {
        this.zza = zzfamVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return zzfzt.zzh(this.zza ? new zzetv() { // from class: com.google.android.gms.internal.ads.zzeto
            @Override // com.google.android.gms.internal.ads.zzetv
            public final void zzj(Object obj) {
                ((Bundle) obj).putBoolean("sdk_prefetch", true);
            }
        } : null);
    }
}
