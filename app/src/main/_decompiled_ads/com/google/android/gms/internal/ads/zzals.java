package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzals extends Thread {
    private static final boolean zza = zzams.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzalq zzd;
    private volatile boolean zze = false;
    private final zzamt zzf;
    private final zzalx zzg;

    public zzals(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzalq zzalqVar, zzalx zzalxVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzalqVar;
        this.zzg = zzalxVar;
        this.zzf = new zzamt(this, blockingQueue2, zzalxVar);
    }

    private void zzc() throws InterruptedException {
        zzamg zzamgVar = (zzamg) this.zzb.take();
        zzamgVar.zzm("cache-queue-take");
        zzamgVar.zzt(1);
        try {
            zzamgVar.zzw();
            zzalp zzalpVarZza = this.zzd.zza(zzamgVar.zzj());
            if (zzalpVarZza == null) {
                zzamgVar.zzm("cache-miss");
                if (!this.zzf.zzc(zzamgVar)) {
                    this.zzc.put(zzamgVar);
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (zzalpVarZza.zza(jCurrentTimeMillis)) {
                zzamgVar.zzm("cache-hit-expired");
                zzamgVar.zze(zzalpVarZza);
                if (!this.zzf.zzc(zzamgVar)) {
                    this.zzc.put(zzamgVar);
                }
                return;
            }
            zzamgVar.zzm("cache-hit");
            zzamm zzammVarZzh = zzamgVar.zzh(new zzamc(zzalpVarZza.zza, zzalpVarZza.zzg));
            zzamgVar.zzm("cache-hit-parsed");
            if (!zzammVarZzh.zzc()) {
                zzamgVar.zzm("cache-parsing-failed");
                this.zzd.zzc(zzamgVar.zzj(), true);
                zzamgVar.zze(null);
                if (!this.zzf.zzc(zzamgVar)) {
                    this.zzc.put(zzamgVar);
                }
                return;
            }
            if (zzalpVarZza.zzf < jCurrentTimeMillis) {
                zzamgVar.zzm("cache-hit-refresh-needed");
                zzamgVar.zze(zzalpVarZza);
                zzammVarZzh.zzd = true;
                if (this.zzf.zzc(zzamgVar)) {
                    this.zzg.zzb(zzamgVar, zzammVarZzh, null);
                } else {
                    this.zzg.zzb(zzamgVar, zzammVarZzh, new zzalr(this, zzamgVar));
                }
            } else {
                this.zzg.zzb(zzamgVar, zzammVarZzh, null);
            }
        } finally {
            zzamgVar.zzt(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzams.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzams.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
