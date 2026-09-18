package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzq implements Runnable {
    final Future zza;
    final zzfzp zzb;

    zzfzq(Future future, zzfzp zzfzpVar) {
        this.zza = future;
        this.zzb = zzfzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Object obj = this.zza;
        if ((obj instanceof zzgav) && (thZza = zzgaw.zza((zzgav) obj)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzfzt.zzp(this.zza));
        } catch (Error e) {
            e = e;
            this.zzb.zza(e);
        } catch (RuntimeException e2) {
            e = e2;
            this.zzb.zza(e);
        } catch (ExecutionException e3) {
            this.zzb.zza(e3.getCause());
        }
    }

    public final String toString() {
        zzfsp zzfspVarZza = zzfsq.zza(this);
        zzfspVarZza.zza(this.zzb);
        return zzfspVarZza.toString();
    }
}
