package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaxb implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzaxd zza;

    zzaxb(zzaxd zzaxdVar) {
        this.zza = zzaxdVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzaxd zzaxdVar = this.zza;
                if (zzaxdVar.zzd != null) {
                    zzaxdVar.zzf = zzaxdVar.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                zzcat.zzh("Unable to obtain a cache service instance.", e);
                zzaxd.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
