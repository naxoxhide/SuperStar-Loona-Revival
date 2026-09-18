package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenz implements zzetw {
    private final ListenableFuture zza;
    private final Executor zzb;

    public zzenz(ListenableFuture listenableFuture, Executor executor) {
        this.zza = listenableFuture;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return zzfzt.zzn(this.zza, new zzfza() { // from class: com.google.android.gms.internal.ads.zzeny
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                final String str = (String) obj;
                return zzfzt.zzh(new zzetv() { // from class: com.google.android.gms.internal.ads.zzenx
                    @Override // com.google.android.gms.internal.ads.zzetv
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putString("ms", str);
                    }
                });
            }
        }, this.zzb);
    }
}
