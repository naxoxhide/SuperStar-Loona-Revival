package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhw extends zzbhb {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zza;

    public zzbhw(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zza = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbhc
    public final void zze(zzbhl zzbhlVar) {
        this.zza.onUnifiedNativeAdLoaded(new zzbhm(zzbhlVar));
    }
}
