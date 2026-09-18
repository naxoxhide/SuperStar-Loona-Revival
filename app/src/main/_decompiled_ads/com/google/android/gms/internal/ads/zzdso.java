package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzdso {
    private final zzdst zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdso(zzdst zzdstVar, Executor executor) {
        this.zza = zzdstVar;
        this.zzc = zzdstVar.zza();
        this.zzb = executor;
    }

    public final zzdsn zza() {
        zzdsn zzdsnVar = new zzdsn(this);
        zzdsn.zza(zzdsnVar);
        return zzdsnVar;
    }

    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkF)).booleanValue()) {
            zzdsn zzdsnVarZza = zza();
            zzdsnVarZza.zzb("action", "pecr");
            zzdsnVarZza.zzg();
        }
    }
}
