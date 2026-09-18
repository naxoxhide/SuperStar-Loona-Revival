package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeov implements zzetw {
    private final Executor zza;
    private final zzcac zzb;

    zzeov(Executor executor, zzcac zzcacVar) {
        this.zza = executor;
        this.zzb = zzcacVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcy)).booleanValue()) {
            return zzfzt.zzh(null);
        }
        zzcac zzcacVar = this.zzb;
        return zzfzt.zzm(zzcacVar.zzj(), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzeou
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                final ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new zzetv() { // from class: com.google.android.gms.internal.ads.zzeot
                    @Override // com.google.android.gms.internal.ads.zzetv
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putStringArrayList("android_permissions", arrayList);
                    }
                };
            }
        }, this.zza);
    }
}
