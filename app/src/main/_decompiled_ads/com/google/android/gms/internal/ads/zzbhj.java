package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhj extends zzaum implements zzbhl {
    zzbhj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzA() throws RemoteException {
        zzbh(28, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzB(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, bundle);
        zzbh(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzC() throws RemoteException {
        zzbh(27, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzD(com.google.android.gms.ads.internal.client.zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, zzcsVar);
        zzbh(26, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzE(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, zzdgVar);
        zzbh(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzF(zzbhi zzbhiVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, zzbhiVar);
        zzbh(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final boolean zzG() throws RemoteException {
        Parcel parcelZzbg = zzbg(30, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final boolean zzH() throws RemoteException {
        Parcel parcelZzbg = zzbg(24, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final boolean zzI(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, bundle);
        Parcel parcelZzbg = zzbg(16, parcelZza);
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final double zze() throws RemoteException {
        Parcel parcelZzbg = zzbg(8, zza());
        double d = parcelZzbg.readDouble();
        parcelZzbg.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final Bundle zzf() throws RemoteException {
        Parcel parcelZzbg = zzbg(20, zza());
        Bundle bundle = (Bundle) zzauo.zza(parcelZzbg, Bundle.CREATOR);
        parcelZzbg.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final com.google.android.gms.ads.internal.client.zzdn zzg() throws RemoteException {
        Parcel parcelZzbg = zzbg(31, zza());
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzdnVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzbg = zzbg(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final zzbfg zzi() throws RemoteException {
        zzbfg zzbfeVar;
        Parcel parcelZzbg = zzbg(14, zza());
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbfeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbfeVar = iInterfaceQueryLocalInterface instanceof zzbfg ? (zzbfg) iInterfaceQueryLocalInterface : new zzbfe(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbfeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final zzbfl zzj() throws RemoteException {
        zzbfl zzbfjVar;
        Parcel parcelZzbg = zzbg(29, zza());
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbfjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbfjVar = iInterfaceQueryLocalInterface instanceof zzbfl ? (zzbfl) iInterfaceQueryLocalInterface : new zzbfj(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbfjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final zzbfo zzk() throws RemoteException {
        zzbfo zzbfmVar;
        Parcel parcelZzbg = zzbg(5, zza());
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbfmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbfmVar = iInterfaceQueryLocalInterface instanceof zzbfo ? (zzbfo) iInterfaceQueryLocalInterface : new zzbfm(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbfmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final IObjectWrapper zzl() throws RemoteException {
        Parcel parcelZzbg = zzbg(19, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel parcelZzbg = zzbg(18, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final String zzn() throws RemoteException {
        Parcel parcelZzbg = zzbg(7, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final String zzo() throws RemoteException {
        Parcel parcelZzbg = zzbg(4, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final String zzp() throws RemoteException {
        Parcel parcelZzbg = zzbg(6, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final String zzq() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final String zzr() throws RemoteException {
        Parcel parcelZzbg = zzbg(12, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final String zzs() throws RemoteException {
        Parcel parcelZzbg = zzbg(10, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final String zzt() throws RemoteException {
        Parcel parcelZzbg = zzbg(9, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final List zzu() throws RemoteException {
        Parcel parcelZzbg = zzbg(3, zza());
        ArrayList arrayListZzb = zzauo.zzb(parcelZzbg);
        parcelZzbg.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final List zzv() throws RemoteException {
        Parcel parcelZzbg = zzbg(23, zza());
        ArrayList arrayListZzb = zzauo.zzb(parcelZzbg);
        parcelZzbg.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzw() throws RemoteException {
        zzbh(22, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzx() throws RemoteException {
        zzbh(13, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzy(com.google.android.gms.ads.internal.client.zzcw zzcwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, zzcwVar);
        zzbh(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhl
    public final void zzz(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, bundle);
        zzbh(15, parcelZza);
    }
}
