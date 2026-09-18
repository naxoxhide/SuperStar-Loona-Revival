package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamm {
    public final Object zza;
    public final zzalp zzb;
    public final zzamp zzc;
    public boolean zzd;

    private zzamm(zzamp zzampVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzampVar;
    }

    private zzamm(Object obj, zzalp zzalpVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzalpVar;
        this.zzc = null;
    }

    public static zzamm zza(zzamp zzampVar) {
        return new zzamm(zzampVar);
    }

    public static zzamm zzb(Object obj, zzalp zzalpVar) {
        return new zzamm(obj, zzalpVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
