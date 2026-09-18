package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbfm extends zzaum implements zzbfo {
    zzbfm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbfo
    public final double zzb() throws RemoteException {
        Parcel parcelZzbg = zzbg(3, zza());
        double d = parcelZzbg.readDouble();
        parcelZzbg.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbfo
    public final int zzc() throws RemoteException {
        Parcel parcelZzbg = zzbg(5, zza());
        int i = parcelZzbg.readInt();
        parcelZzbg.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbfo
    public final int zzd() throws RemoteException {
        Parcel parcelZzbg = zzbg(4, zza());
        int i = parcelZzbg.readInt();
        parcelZzbg.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbfo
    public final Uri zze() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        Uri uri = (Uri) zzauo.zza(parcelZzbg, Uri.CREATOR);
        parcelZzbg.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbfo
    public final IObjectWrapper zzf() throws RemoteException {
        Parcel parcelZzbg = zzbg(1, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return iObjectWrapperAsInterface;
    }
}
