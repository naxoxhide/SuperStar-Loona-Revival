package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamr {
    public static final boolean zza = zzams.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    zzamr() {
    }

    protected final void finalize() throws Throwable {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzams.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzamq(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        long j;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j = 0;
        } else {
            long j2 = ((zzamq) this.zzb.get(0)).zzc;
            List list = this.zzb;
            j = ((zzamq) list.get(list.size() - 1)).zzc - j2;
        }
        if (j <= 0) {
            return;
        }
        long j3 = ((zzamq) this.zzb.get(0)).zzc;
        zzams.zza("(%-4d ms) %s", Long.valueOf(j), str);
        for (zzamq zzamqVar : this.zzb) {
            long j4 = zzamqVar.zzc;
            zzams.zza("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(zzamqVar.zzb), zzamqVar.zza);
            j3 = j4;
        }
    }
}
