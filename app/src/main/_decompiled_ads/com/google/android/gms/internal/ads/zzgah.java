package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgah extends zzfyh.zzi implements Runnable {
    private final Runnable zza;

    public zzgah(Runnable runnable) {
        Objects.requireNonNull(runnable);
        this.zza = runnable;
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final String zza() {
        return "task=[" + this.zza.toString() + "]";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Error | RuntimeException e) {
            zzd(e);
            throw e;
        }
    }
}
