package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzg extends zzfys {

    @CheckForNull
    private zzfzf zza;

    zzfzg(zzfvn zzfvnVar, boolean z, Executor executor, Callable callable) {
        super(zzfvnVar, z, false);
        this.zza = new zzfze(this, callable, executor);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzfys
    final void zzf(int i, @CheckForNull Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final void zzq() {
        zzfzf zzfzfVar = this.zza;
        if (zzfzfVar != null) {
            zzfzfVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfys
    final void zzu() {
        zzfzf zzfzfVar = this.zza;
        if (zzfzfVar != null) {
            zzfzfVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfys
    final void zzy(int i) {
        super.zzy(i);
        if (i == 1) {
            this.zza = null;
        }
    }
}
