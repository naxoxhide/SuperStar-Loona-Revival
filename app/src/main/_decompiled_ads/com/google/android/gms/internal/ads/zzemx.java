package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzemx {
    private final zzdju zza;
    private final zzemk zzb;
    private final zzcxo zzc;

    public zzemx(zzdju zzdjuVar, zzfib zzfibVar) {
        this.zza = zzdjuVar;
        final zzemk zzemkVar = new zzemk(zzfibVar);
        this.zzb = zzemkVar;
        final zzbmb zzbmbVarZzg = zzdjuVar.zzg();
        this.zzc = new zzcxo() { // from class: com.google.android.gms.internal.ads.zzemw
            @Override // com.google.android.gms.internal.ads.zzcxo
            public final void zzbF(com.google.android.gms.ads.internal.client.zze zzeVar) {
                zzemkVar.zzbF(zzeVar);
                zzbmb zzbmbVar = zzbmbVarZzg;
                if (zzbmbVar != null) {
                    try {
                        zzbmbVar.zzf(zzeVar);
                    } catch (RemoteException e) {
                        zzcat.zzl("#007 Could not call remote method.", e);
                    }
                }
                if (zzbmbVar != null) {
                    try {
                        zzbmbVar.zze(zzeVar.zza);
                    } catch (RemoteException e2) {
                        zzcat.zzl("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    public final zzcxo zza() {
        return this.zzc;
    }

    public final zzcyz zzb() {
        return this.zzb;
    }

    public final zzdho zzc() {
        return new zzdho(this.zza, this.zzb.zzg());
    }

    public final zzemk zzd() {
        return this.zzb;
    }

    public final void zze(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        this.zzb.zzj(zzbhVar);
    }
}
