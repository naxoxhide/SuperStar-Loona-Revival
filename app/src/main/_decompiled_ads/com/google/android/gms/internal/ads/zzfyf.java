package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzfyf extends zzfzj implements Runnable {

    @CheckForNull
    ListenableFuture zza;

    @CheckForNull
    Class zzb;

    @CheckForNull
    Object zzc;

    zzfyf(ListenableFuture listenableFuture, Class cls, Object obj) {
        Objects.requireNonNull(listenableFuture);
        this.zza = listenableFuture;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable e;
        Object objZzp;
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            e = listenableFuture instanceof zzgav ? ((zzgav) listenableFuture).zzl() : null;
            objZzp = e == null ? zzfzt.zzp(listenableFuture) : null;
        } catch (Error e2) {
            e = e2;
        } catch (RuntimeException e3) {
            e = e3;
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + String.valueOf(listenableFuture.getClass()) + " threw " + String.valueOf(e4.getClass()) + " without a cause");
            }
            e = cause;
        }
        if (e == null) {
            zzc(objZzp);
            return;
        }
        if (!cls.isInstance(e)) {
            zzs(listenableFuture);
            return;
        }
        try {
            Object objZze = zze(obj, e);
            this.zzb = null;
            this.zzc = null;
            zzf(objZze);
        } catch (Throwable th) {
            try {
                zzgak.zza(th);
                zzd(th);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    @CheckForNull
    protected final String zza() {
        String str;
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZza = super.zza();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture.toString() + "], ";
        } else {
            str = "";
        }
        if (cls == null || obj == null) {
            if (strZza != null) {
                return str.concat(strZza);
            }
            return null;
        }
        return str + "exceptionType=[" + cls.toString() + "], fallback=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    abstract Object zze(Object obj, Throwable th) throws Exception;

    abstract void zzf(Object obj);
}
