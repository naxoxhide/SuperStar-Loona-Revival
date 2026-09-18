package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgas extends zzfzj implements RunnableFuture {

    @CheckForNull
    private volatile zzgac zza;

    zzgas(zzfyz zzfyzVar) {
        this.zza = new zzgaq(this, zzfyzVar);
    }

    static zzgas zze(Runnable runnable, Object obj) {
        return new zzgas(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgac zzgacVar = this.zza;
        if (zzgacVar != null) {
            zzgacVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    @CheckForNull
    protected final String zza() {
        zzgac zzgacVar = this.zza;
        if (zzgacVar == null) {
            return super.zza();
        }
        return "task=[" + zzgacVar.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final void zzb() {
        zzgac zzgacVar;
        if (zzt() && (zzgacVar = this.zza) != null) {
            zzgacVar.zzh();
        }
        this.zza = null;
    }

    zzgas(Callable callable) {
        this.zza = new zzgar(this, callable);
    }
}
