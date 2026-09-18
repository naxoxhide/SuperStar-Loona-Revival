package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzady {
    protected final zzacs zza;

    protected zzady(zzacs zzacsVar) {
        this.zza = zzacsVar;
    }

    protected abstract boolean zza(zzfb zzfbVar) throws zzcc;

    protected abstract boolean zzb(zzfb zzfbVar, long j) throws zzcc;

    public final boolean zzf(zzfb zzfbVar, long j) throws zzcc {
        return zza(zzfbVar) && zzb(zzfbVar, j);
    }
}
