package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzavm {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final zzavl zza(boolean z) {
        synchronized (this.zzb) {
            zzavl zzavlVar = null;
            if (this.zzc.isEmpty()) {
                zzcat.zze("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzc.size() < 2) {
                zzavl zzavlVar2 = (zzavl) this.zzc.get(0);
                if (z) {
                    this.zzc.remove(0);
                } else {
                    zzavlVar2.zzi();
                }
                return zzavlVar2;
            }
            int i2 = Integer.MIN_VALUE;
            int i3 = 0;
            for (zzavl zzavlVar3 : this.zzc) {
                int iZzb = zzavlVar3.zzb();
                if (iZzb > i2) {
                    i = i3;
                }
                int i4 = iZzb > i2 ? iZzb : i2;
                if (iZzb > i2) {
                    zzavlVar = zzavlVar3;
                }
                i3++;
                i2 = i4;
            }
            this.zzc.remove(i);
            return zzavlVar;
        }
    }

    public final void zzb(zzavl zzavlVar) {
        synchronized (this.zzb) {
            if (this.zzc.size() >= 10) {
                zzcat.zze("Queue is full, current size = " + this.zzc.size());
                this.zzc.remove(0);
            }
            int i = this.zza;
            this.zza = i + 1;
            zzavlVar.zzj(i);
            zzavlVar.zzn();
            this.zzc.add(zzavlVar);
        }
    }

    public final boolean zzc(zzavl zzavlVar) {
        synchronized (this.zzb) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                zzavl zzavlVar2 = (zzavl) it.next();
                if (com.google.android.gms.ads.internal.zzt.zzo().zzh().zzN()) {
                    if (!com.google.android.gms.ads.internal.zzt.zzo().zzh().zzO() && !zzavlVar.equals(zzavlVar2) && zzavlVar2.zzf().equals(zzavlVar.zzf())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzavlVar.equals(zzavlVar2) && zzavlVar2.zzd().equals(zzavlVar.zzd())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean zzd(zzavl zzavlVar) {
        synchronized (this.zzb) {
            return this.zzc.contains(zzavlVar);
        }
    }
}
