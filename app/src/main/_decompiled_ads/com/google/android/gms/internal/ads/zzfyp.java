package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfyp extends zzfzj implements Runnable {
    public static final /* synthetic */ int zzc = 0;

    @CheckForNull
    ListenableFuture zza;

    @CheckForNull
    Object zzb;

    zzfyp(ListenableFuture listenableFuture, Object obj) {
        Objects.requireNonNull(listenableFuture);
        this.zza = listenableFuture;
        this.zzb = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.zza;
        Object obj = this.zzb;
        if ((isCancelled() | (listenableFuture == null)) || (obj == null)) {
            return;
        }
        this.zza = null;
        if (listenableFuture.isCancelled()) {
            zzs(listenableFuture);
            return;
        }
        try {
            try {
                Object objZze = zze(obj, zzfzt.zzp(listenableFuture));
                this.zzb = null;
                zzf(objZze);
            } catch (Throwable th) {
                try {
                    zzgak.zza(th);
                    zzd(th);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e) {
            zzd(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e2) {
            zzd(e2);
        } catch (ExecutionException e3) {
            zzd(e3.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    @CheckForNull
    protected final String zza() {
        String str;
        ListenableFuture listenableFuture = this.zza;
        Object obj = this.zzb;
        String strZza = super.zza();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture.toString() + "], ";
        } else {
            str = "";
        }
        if (obj == null) {
            if (strZza != null) {
                return str.concat(strZza);
            }
            return null;
        }
        return str + "function=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    abstract Object zze(Object obj, Object obj2) throws Exception;

    abstract void zzf(Object obj);
}
