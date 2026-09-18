package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbzj extends zzaun implements zzbzk {
    public zzbzj() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzbzk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return iInterfaceQueryLocalInterface instanceof zzbzk ? (zzbzk) iInterfaceQueryLocalInterface : new zzbzi(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    protected final boolean zzbJ(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbzh zzbzfVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbzo zzbzoVar = (zzbzo) zzauo.zza(parcel, zzbzo.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzbzfVar = iInterfaceQueryLocalInterface instanceof zzbzh ? (zzbzh) iInterfaceQueryLocalInterface : new zzbzf(strongBinder);
                }
                zzauo.zzc(parcel);
                zze(iObjectWrapperAsInterface, zzbzoVar, zzbzfVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzj(iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, null);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                parcel2.writeNoException();
                zzauo.zzf(parcel2, null);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtk zzbtkVarZzb = zzbtj.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzl(arrayListCreateTypedArrayList, iObjectWrapperAsInterface3, zzbtkVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtk zzbtkVarZzb2 = zzbtj.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzk(arrayListCreateTypedArrayList2, iObjectWrapperAsInterface4, zzbtkVarZzb2);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbtt zzbttVar = (zzbtt) zzauo.zza(parcel, zzbtt.CREATOR);
                zzauo.zzc(parcel);
                zzf(zzbttVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzi(iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtk zzbtkVarZzb3 = zzbtj.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzh(arrayListCreateTypedArrayList3, iObjectWrapperAsInterface6, zzbtkVarZzb3);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtk zzbtkVarZzb4 = zzbtj.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzg(arrayListCreateTypedArrayList4, iObjectWrapperAsInterface7, zzbtkVarZzb4);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
