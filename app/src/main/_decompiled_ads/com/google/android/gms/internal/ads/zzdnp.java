package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdnp implements zzbfb {
    final /* synthetic */ String zza = "_videoMediaView";
    final /* synthetic */ zzdnq zzb;

    zzdnp(zzdnq zzdnqVar, String str) {
        this.zzb = zzdnqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfb
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfb
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfb
    public final void zzc() {
        zzdnq zzdnqVar = this.zzb;
        if (zzdnqVar.zzd != null) {
            zzdnqVar.zzd.zzD(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfb
    public final void zzd(MotionEvent motionEvent) {
    }
}
