package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeac extends zzeaf {
    private zzbuk zzh;

    zzeac(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final synchronized void onConnected(Bundle bundle) {
        if (this.zzc) {
            return;
        }
        this.zzc = true;
        try {
            try {
                this.zzd.zzp().zzf(this.zzh, new zzeae(this));
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "RemoteAdsServiceSignalClientTask.onConnected");
                this.zza.zzd(th);
            }
        } catch (RemoteException unused) {
            this.zza.zzd(new zzdyo(1));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeaf, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        String str = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", Integer.valueOf(i));
        zzcat.zze(str);
        this.zza.zzd(new zzdyo(1, str));
    }

    public final synchronized ListenableFuture zza(zzbuk zzbukVar, long j) {
        if (this.zzb) {
            return zzfzt.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbukVar;
        zzb();
        ListenableFuture listenableFutureZzo = zzfzt.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        listenableFutureZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeab
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc();
            }
        }, zzcbg.zzf);
        return listenableFutureZzo;
    }
}
