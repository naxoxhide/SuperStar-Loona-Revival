package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxw {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzxx zzxxVar) {
        zzc(zzxxVar);
        this.zza.add(new zzxv(handler, zzxxVar));
    }

    public final void zzb(final int i, final long j, final long j2) {
        for (final zzxv zzxvVar : this.zza) {
            if (!zzxvVar.zzc) {
                zzxvVar.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzxu
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzxvVar.zzb.zzV(i, j, j2);
                    }
                });
            }
        }
    }

    public final void zzc(zzxx zzxxVar) {
        for (zzxv zzxvVar : this.zza) {
            if (zzxvVar.zzb == zzxxVar) {
                zzxvVar.zzc();
                this.zza.remove(zzxvVar);
            }
        }
    }
}
