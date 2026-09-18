package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzblb implements zzfza {
    final /* synthetic */ zzbkt zza;

    zzblb(zzblf zzblfVar, zzbkt zzbktVar) {
        this.zza = zzbktVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzcbl zzcblVar = new zzcbl();
        ((zzbkz) obj).zze(this.zza, new zzbla(this, zzcblVar));
        return zzcblVar;
    }
}
