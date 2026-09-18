package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzett implements zzetw {
    private final zzgad zza;
    private final Context zzb;

    zzett(zzgad zzgadVar, Context context) {
        this.zza = zzgadVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzetv zzc() throws Exception {
        final Bundle bundleZzb = com.google.android.gms.ads.internal.util.zzad.zzb(this.zzb, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgb));
        if (bundleZzb.isEmpty()) {
            return null;
        }
        return new zzetv() { // from class: com.google.android.gms.internal.ads.zzets
            @Override // com.google.android.gms.internal.ads.zzetv
            public final void zzj(Object obj) {
                ((Bundle) obj).putBundle("shared_pref", bundleZzb);
            }
        };
    }
}
