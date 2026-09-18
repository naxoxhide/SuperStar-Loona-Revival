package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbpb extends zzaum implements zzbpd {
    zzbpb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zze() throws RemoteException {
        zzbh(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzf() throws RemoteException {
        zzbh(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzg(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzbh(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzeVar);
        zzbh(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzi(int i, String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        zzbh(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzj(int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzeVar);
        zzbh(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzl(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbh(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzm() throws RemoteException {
        zzbh(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzn() throws RemoteException {
        zzbh(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzo() throws RemoteException {
        zzbh(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzp() throws RemoteException {
        zzbh(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzq(String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbh(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzr(zzbgi zzbgiVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, zzbgiVar);
        parcelZza.writeString(str);
        zzbh(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzs(zzbwi zzbwiVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzt(zzbwm zzbwmVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, zzbwmVar);
        zzbh(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzu() throws RemoteException {
        zzbh(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzv() throws RemoteException {
        zzbh(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzw() throws RemoteException {
        zzbh(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzx() throws RemoteException {
        zzbh(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final void zzy() throws RemoteException {
        zzbh(13, zza());
    }
}
