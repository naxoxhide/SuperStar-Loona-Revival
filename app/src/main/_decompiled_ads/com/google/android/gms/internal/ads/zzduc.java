package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzduc extends zzbwv {
    final /* synthetic */ zzdue zza;

    zzduc(zzdue zzdueVar) {
        this.zza = zzdueVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final void zze(int i) throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzm(zzdueVar.zza, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzm(zzdueVar.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbww
    public final void zzg() throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzp(zzdueVar.zza);
    }
}
