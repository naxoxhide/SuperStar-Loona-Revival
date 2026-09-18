package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgam implements Runnable {

    @CheckForNull
    zzgap zza;

    zzgam(zzgap zzgapVar) {
        this.zza = zzgapVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture;
        zzgap zzgapVar = this.zza;
        if (zzgapVar == null || (listenableFuture = zzgapVar.zza) == null) {
            return;
        }
        this.zza = null;
        if (listenableFuture.isDone()) {
            zzgapVar.zzs(listenableFuture);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgapVar.zzb;
            zzgapVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzgapVar.zzd(new zzgao(str, null));
                    throw th;
                }
            }
            zzgapVar.zzd(new zzgao(str + ": " + listenableFuture.toString(), null));
            listenableFuture.cancel(true);
        } catch (Throwable th2) {
            listenableFuture.cancel(true);
            throw th2;
        }
    }
}
