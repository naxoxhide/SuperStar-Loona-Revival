package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesp implements zzetv {
    private final String zza;
    private final String zzb;

    public zzesp(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzetv
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgS)).booleanValue()) {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zzb);
        } else {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zza);
        }
    }
}
