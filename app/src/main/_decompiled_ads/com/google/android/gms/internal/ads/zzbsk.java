package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbsk extends zzbhb {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbsk(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zze(zzbhl zzbhlVar) {
        this.zza.onNativeAdLoaded(new zzbsd(zzbhlVar));
    }
}
