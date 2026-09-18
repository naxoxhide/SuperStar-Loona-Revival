package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhy {
    private final Executor zza;
    private final zzcay zzb;

    public zzfhy(Executor executor, zzcay zzcayVar) {
        this.zza = executor;
        this.zzb = zzcayVar;
    }

    final /* synthetic */ void zza(String str) {
        this.zzb.zza(str);
    }

    public final void zzb(final String str) {
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfhx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(str);
            }
        });
    }
}
