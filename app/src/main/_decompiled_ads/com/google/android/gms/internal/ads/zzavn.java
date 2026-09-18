package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzavn implements Runnable {
    final /* synthetic */ zzavo zza;

    zzavn(zzavo zzavoVar) {
        this.zza = zzavoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzc) {
            zzavo zzavoVar = this.zza;
            if (zzavoVar.zzd && zzavoVar.zze) {
                zzavoVar.zzd = false;
                zzcat.zze("App went background");
                Iterator it = this.zza.zzf.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzavp) it.next()).zza(false);
                    } catch (Exception e) {
                        zzcat.zzh("", e);
                    }
                }
            } else {
                zzcat.zze("App is still foreground");
            }
        }
    }
}
