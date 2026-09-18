package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzffw {
    private final zzffa zza;
    private final zzffu zzb;
    private final zzfew zzc;
    private zzfgc zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzffw(zzffa zzffaVar, zzfew zzfewVar, zzffu zzffuVar) {
        this.zza = zzffaVar;
        this.zzc = zzfewVar;
        this.zzb = zzffuVar;
        zzfewVar.zzb(new zzffr(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgl)).booleanValue() && !com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzh()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (!this.zzd.isEmpty()) {
                zzffv zzffvVar = (zzffv) this.zzd.pollFirst();
                if (zzffvVar == null || (zzffvVar.zza() != null && this.zza.zze(zzffvVar.zza()))) {
                    zzfgc zzfgcVar = new zzfgc(this.zza, this.zzb, zzffvVar);
                    this.zze = zzfgcVar;
                    zzfgcVar.zzd(new zzffs(this, zzffvVar));
                    return;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized ListenableFuture zza(zzffv zzffvVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zza(zzffvVar);
    }

    public final synchronized void zze(zzffv zzffvVar) {
        this.zzd.add(zzffvVar);
    }

    final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
