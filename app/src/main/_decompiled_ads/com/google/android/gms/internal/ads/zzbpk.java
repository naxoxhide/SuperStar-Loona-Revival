package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbpk extends zzaum implements zzbpm {
    zzbpk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final boolean zzA() throws RemoteException {
        Parcel parcelZzbg = zzbg(18, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final boolean zzB() throws RemoteException {
        Parcel parcelZzbg = zzbg(17, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final double zze() throws RemoteException {
        Parcel parcelZzbg = zzbg(8, zza());
        double d = parcelZzbg.readDouble();
        parcelZzbg.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final float zzf() throws RemoteException {
        Parcel parcelZzbg = zzbg(23, zza());
        float f = parcelZzbg.readFloat();
        parcelZzbg.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final float zzg() throws RemoteException {
        Parcel parcelZzbg = zzbg(25, zza());
        float f = parcelZzbg.readFloat();
        parcelZzbg.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final float zzh() throws RemoteException {
        Parcel parcelZzbg = zzbg(24, zza());
        float f = parcelZzbg.readFloat();
        parcelZzbg.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final Bundle zzi() throws RemoteException {
        Parcel parcelZzbg = zzbg(16, zza());
        Bundle bundle = (Bundle) zzauo.zza(parcelZzbg, Bundle.CREATOR);
        parcelZzbg.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final com.google.android.gms.ads.internal.client.zzdq zzj() throws RemoteException {
        Parcel parcelZzbg = zzbg(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final zzbfg zzk() throws RemoteException {
        Parcel parcelZzbg = zzbg(12, zza());
        zzbfg zzbfgVarZzj = zzbff.zzj(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbfgVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final zzbfo zzl() throws RemoteException {
        Parcel parcelZzbg = zzbg(5, zza());
        zzbfo zzbfoVarZzg = zzbfn.zzg(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzbfoVarZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel parcelZzbg = zzbg(13, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel parcelZzbg = zzbg(14, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final IObjectWrapper zzo() throws RemoteException {
        Parcel parcelZzbg = zzbg(15, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final String zzp() throws RemoteException {
        Parcel parcelZzbg = zzbg(7, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final String zzq() throws RemoteException {
        Parcel parcelZzbg = zzbg(4, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final String zzr() throws RemoteException {
        Parcel parcelZzbg = zzbg(6, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final String zzs() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final String zzt() throws RemoteException {
        Parcel parcelZzbg = zzbg(10, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final String zzu() throws RemoteException {
        Parcel parcelZzbg = zzbg(9, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final List zzv() throws RemoteException {
        Parcel parcelZzbg = zzbg(3, zza());
        ArrayList arrayListZzb = zzauo.zzb(parcelZzbg);
        parcelZzbg.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final void zzx() throws RemoteException {
        zzbh(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, iObjectWrapper2);
        zzauo.zzf(parcelZza, iObjectWrapper3);
        zzbh(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpm
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(22, parcelZza);
    }
}
