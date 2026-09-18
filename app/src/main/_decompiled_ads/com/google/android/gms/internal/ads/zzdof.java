package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdof implements Callable {
    private final com.google.android.gms.ads.internal.zza zza;
    private final zzcgn zzb;
    private final Context zzc;
    private final zzdso zzd;
    private final zzfib zze;
    private final zzedo zzf;
    private final Executor zzg;
    private final zzaro zzh;
    private final zzcaz zzi;
    private final zzfjx zzj;
    private final zzedz zzk;

    public zzdof(Context context, Executor executor, zzaro zzaroVar, zzcaz zzcazVar, com.google.android.gms.ads.internal.zza zzaVar, zzcgn zzcgnVar, zzedo zzedoVar, zzfjx zzfjxVar, zzdso zzdsoVar, zzfib zzfibVar, zzedz zzedzVar) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzaroVar;
        this.zzi = zzcazVar;
        this.zza = zzaVar;
        this.zzb = zzcgnVar;
        this.zzf = zzedoVar;
        this.zzj = zzfjxVar;
        this.zzd = zzdsoVar;
        this.zze = zzfibVar;
        this.zzk = zzedzVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdoi zzdoiVar = new zzdoi(this);
        zzdoiVar.zzh();
        return zzdoiVar;
    }
}
