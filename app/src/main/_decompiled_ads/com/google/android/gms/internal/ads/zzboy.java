package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzboy extends zzaum implements zzbpa {
    zzboy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzB(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzE() throws RemoteException {
        zzbh(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzF() throws RemoteException {
        zzbh(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzG(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzauo.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzbh(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzI() throws RemoteException {
        zzbh(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(37, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzL() throws RemoteException {
        zzbh(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final boolean zzM() throws RemoteException {
        Parcel parcelZzbg = zzbg(22, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final boolean zzN() throws RemoteException {
        Parcel parcelZzbg = zzbg(13, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final zzbpi zzO() throws RemoteException {
        zzbpi zzbpiVar;
        Parcel parcelZzbg = zzbg(15, zza());
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbpiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzbpiVar = iInterfaceQueryLocalInterface instanceof zzbpi ? (zzbpi) iInterfaceQueryLocalInterface : new zzbpi(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbpiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final zzbpj zzP() throws RemoteException {
        zzbpj zzbpjVar;
        Parcel parcelZzbg = zzbg(16, zza());
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbpjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzbpjVar = iInterfaceQueryLocalInterface instanceof zzbpj ? (zzbpj) iInterfaceQueryLocalInterface : new zzbpj(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbpjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final Bundle zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzbg = zzbg(26, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final zzbgi zzi() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final zzbpg zzj() throws RemoteException {
        zzbpg zzbpeVar;
        Parcel parcelZzbg = zzbg(36, zza());
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbpeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbpeVar = iInterfaceQueryLocalInterface instanceof zzbpg ? (zzbpg) iInterfaceQueryLocalInterface : new zzbpe(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbpeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final zzbpm zzk() throws RemoteException {
        zzbpm zzbpkVar;
        Parcel parcelZzbg = zzbg(27, zza());
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbpkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbpkVar = iInterfaceQueryLocalInterface instanceof zzbpm ? (zzbpm) iInterfaceQueryLocalInterface : new zzbpk(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbpkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final zzbrj zzl() throws RemoteException {
        Parcel parcelZzbg = zzbg(33, zza());
        zzbrj zzbrjVar = (zzbrj) zzauo.zza(parcelZzbg, zzbrj.CREATOR);
        parcelZzbg.recycle();
        return zzbrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final zzbrj zzm() throws RemoteException {
        Parcel parcelZzbg = zzbg(34, zza());
        zzbrj zzbrjVar = (zzbrj) zzauo.zza(parcelZzbg, zzbrj.CREATOR);
        parcelZzbg.recycle();
        return zzbrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzo() throws RemoteException {
        zzbh(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbwh zzbwhVar, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(null);
        zzauo.zzf(parcelZza, zzbwhVar);
        parcelZza.writeString(str2);
        zzbh(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzq(IObjectWrapper iObjectWrapper, zzblk zzblkVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzblkVar);
        parcelZza.writeTypedList(list);
        zzbh(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzr(IObjectWrapper iObjectWrapper, zzbwh zzbwhVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzbwhVar);
        parcelZza.writeStringList(list);
        zzbh(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzs(com.google.android.gms.ads.internal.client.zzl zzlVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzbh(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbpd zzbpdVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzqVar);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzqVar);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbpd zzbpdVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbpd zzbpdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzbh(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpa
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbpd zzbpdVar, zzbfc zzbfcVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzauo.zzf(parcelZza, zzbpdVar);
        zzauo.zzd(parcelZza, zzbfcVar);
        parcelZza.writeStringList(list);
        zzbh(14, parcelZza);
    }
}
