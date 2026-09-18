package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaxq implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcbl zza;
    final /* synthetic */ zzaxr zzb;

    zzaxq(zzaxr zzaxrVar, zzcbl zzcblVar) {
        this.zzb = zzaxrVar;
        this.zza = zzcblVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zzd(new RuntimeException("Connection failed."));
        }
    }
}
