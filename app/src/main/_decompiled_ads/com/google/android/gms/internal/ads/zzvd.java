package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzvd implements zzui {
    private final zzgh zzc;
    private int zzd;
    private final zzvc zze;
    private final zzyd zzf;
    private final zzqu zzg;

    public zzvd(zzgh zzghVar, zzvc zzvcVar) {
        zzqu zzquVar = new zzqu();
        zzyd zzydVar = new zzyd();
        this.zzc = zzghVar;
        this.zze = zzvcVar;
        this.zzg = zzquVar;
        this.zzf = zzydVar;
        this.zzd = 1048576;
    }

    public final zzvd zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzvf zzb(zzbp zzbpVar) {
        Objects.requireNonNull(zzbpVar.zzd);
        return new zzvf(zzbpVar, this.zzc, this.zze, zzrd.zza, this.zzf, this.zzd, null);
    }
}
