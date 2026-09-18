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
public final class zzbpj extends zzaum implements IInterface {
    zzbpj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final Bundle zze() throws RemoteException {
        Parcel parcelZzbg = zzbg(13, zza());
        Bundle bundle = (Bundle) zzauo.zza(parcelZzbg, Bundle.CREATOR);
        parcelZzbg.recycle();
        return bundle;
    }

    public final com.google.android.gms.ads.internal.client.zzdq zzf() throws RemoteException {
        Parcel parcelZzbg = zzbg(16, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzdqVarZzb;
    }

    public final zzbfg zzg() throws RemoteException {
        Parcel parcelZzbg = zzbg(19, zza());
        zzbfg zzbfgVarZzj = zzbff.zzj(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbfgVarZzj;
    }

    public final zzbfo zzh() throws RemoteException {
        Parcel parcelZzbg = zzbg(5, zza());
        zzbfo zzbfoVarZzg = zzbfn.zzg(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbfoVarZzg;
    }

    public final IObjectWrapper zzi() throws RemoteException {
        Parcel parcelZzbg = zzbg(15, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzj() throws RemoteException {
        Parcel parcelZzbg = zzbg(20, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzk() throws RemoteException {
        Parcel parcelZzbg = zzbg(21, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    public final String zzl() throws RemoteException {
        Parcel parcelZzbg = zzbg(7, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    public final String zzm() throws RemoteException {
        Parcel parcelZzbg = zzbg(4, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    public final String zzn() throws RemoteException {
        Parcel parcelZzbg = zzbg(6, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    public final String zzo() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    public final List zzp() throws RemoteException {
        Parcel parcelZzbg = zzbg(3, zza());
        ArrayList arrayListZzb = zzauo.zzb(parcelZzbg);
        parcelZzbg.recycle();
        return arrayListZzb;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(9, parcelZza);
    }

    public final void zzr() throws RemoteException {
        zzbh(8, zza());
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(10, parcelZza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, iObjectWrapper2);
        zzauo.zzf(parcelZza, iObjectWrapper3);
        zzbh(22, parcelZza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(14, parcelZza);
    }

    public final boolean zzv() throws RemoteException {
        Parcel parcelZzbg = zzbg(12, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    public final boolean zzw() throws RemoteException {
        Parcel parcelZzbg = zzbg(11, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }
}
