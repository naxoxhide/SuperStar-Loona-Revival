package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqx {
    public final int zza;
    public final zztw zzb;
    private final CopyOnWriteArrayList zzc;

    public zzqx() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzqx(CopyOnWriteArrayList copyOnWriteArrayList, int i, zztw zztwVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zztwVar;
    }

    public final zzqx zza(int i, zztw zztwVar) {
        return new zzqx(this.zzc, 0, zztwVar);
    }

    public final void zzb(Handler handler, zzqy zzqyVar) {
        this.zzc.add(new zzqw(handler, zzqyVar));
    }

    public final void zzc(zzqy zzqyVar) {
        for (zzqw zzqwVar : this.zzc) {
            if (zzqwVar.zzb == zzqyVar) {
                this.zzc.remove(zzqwVar);
            }
        }
    }
}
