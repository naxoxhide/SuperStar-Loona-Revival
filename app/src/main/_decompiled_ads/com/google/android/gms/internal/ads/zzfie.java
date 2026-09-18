package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfie implements zzfib {
    private final zzfib zza;
    private final Queue zzb = new LinkedBlockingQueue();
    private final int zzc = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziu)).intValue();
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzfie(zzfib zzfibVar, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfibVar;
        long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzit)).intValue();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkO)).booleanValue()) {
            scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfid
                @Override // java.lang.Runnable
                public final void run() {
                    zzfie.zzc(this.zza);
                }
            }, jIntValue, jIntValue, TimeUnit.MILLISECONDS);
        } else {
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfid
                @Override // java.lang.Runnable
                public final void run() {
                    zzfie.zzc(this.zza);
                }
            }, jIntValue, jIntValue, TimeUnit.MILLISECONDS);
        }
    }

    public static /* synthetic */ void zzc(zzfie zzfieVar) {
        while (!zzfieVar.zzb.isEmpty()) {
            zzfieVar.zza.zzb((zzfia) zzfieVar.zzb.remove());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfib
    public final String zza(zzfia zzfiaVar) {
        return this.zza.zza(zzfiaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfib
    public final void zzb(zzfia zzfiaVar) {
        if (this.zzb.size() < this.zzc) {
            this.zzb.offer(zzfiaVar);
            return;
        }
        if (this.zzd.getAndSet(true)) {
            return;
        }
        Queue queue = this.zzb;
        zzfia zzfiaVarZzb = zzfia.zzb("dropped_event");
        Map mapZzj = zzfiaVar.zzj();
        if (mapZzj.containsKey("action")) {
            zzfiaVarZzb.zza("dropped_action", (String) mapZzj.get("action"));
        }
        queue.offer(zzfiaVarZzb);
    }
}
