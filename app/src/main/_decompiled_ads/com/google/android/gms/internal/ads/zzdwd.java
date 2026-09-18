package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdwd extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdwg zzb;

    zzdwd(zzdwg zzdwgVar, String str) {
        this.zzb = zzdwgVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdwg.zzl(loadAdError), this.zza);
    }
}
