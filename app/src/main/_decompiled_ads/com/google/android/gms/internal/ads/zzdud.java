package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdud extends zzbwr {
    final /* synthetic */ zzdue zza;

    zzdud(zzdue zzdueVar) {
        this.zza = zzdueVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zze() throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzj(zzdueVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzf() throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzo(zzdueVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzg() throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzk(zzdueVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzh(int i) throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzn(zzdueVar.zza, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzn(zzdueVar.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzj() throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzr(zzdueVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzk(zzbwm zzbwmVar) throws RemoteException {
        zzdue zzdueVar = this.zza;
        zzdueVar.zzb.zzl(zzdueVar.zza, zzbwmVar);
    }
}
