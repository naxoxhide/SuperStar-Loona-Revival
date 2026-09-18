package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbgg extends zzaum implements zzbgi {
    zzbgg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException {
        Parcel parcelZzbg = zzbg(7, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final zzbfl zzf() throws RemoteException {
        zzbfl zzbfjVar;
        Parcel parcelZzbg = zzbg(16, zza());
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

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final zzbfo zzg(String str) throws RemoteException {
        zzbfo zzbfmVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbg = zzbg(2, parcelZza);
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

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final IObjectWrapper zzh() throws RemoteException {
        Parcel parcelZzbg = zzbg(9, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final String zzi() throws RemoteException {
        Parcel parcelZzbg = zzbg(4, zza());
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final String zzj(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbg = zzbg(1, parcelZza);
        String string = parcelZzbg.readString();
        parcelZzbg.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final List zzk() throws RemoteException {
        Parcel parcelZzbg = zzbg(3, zza());
        ArrayList<String> arrayListCreateStringArrayList = parcelZzbg.createStringArrayList();
        parcelZzbg.recycle();
        return arrayListCreateStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzl() throws RemoteException {
        zzbh(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzm() throws RemoteException {
        zzbh(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzn(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbh(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzo() throws RemoteException {
        zzbh(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzq() throws RemoteException {
        Parcel parcelZzbg = zzbg(12, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbg = zzbg(17, parcelZza);
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbg = zzbg(10, parcelZza);
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final boolean zzt() throws RemoteException {
        Parcel parcelZzbg = zzbg(13, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }
}
