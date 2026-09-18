package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaxc implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzaxd zza;

    zzaxc(zzaxd zzaxdVar) {
        this.zza = zzaxdVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzaxd zzaxdVar = this.zza;
            if (zzaxdVar.zzd != null) {
                zzaxdVar.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
