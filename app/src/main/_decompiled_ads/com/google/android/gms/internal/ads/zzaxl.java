package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaxl extends zzcbl {
    final /* synthetic */ zzaxr zza;

    zzaxl(zzaxr zzaxrVar) {
        this.zza = zzaxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbl, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzaxr.zze(this.zza);
        return super.cancel(z);
    }
}
