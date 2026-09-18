package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbsn extends zzaun implements zzbso {
    public zzbsn() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbso zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return iInterfaceQueryLocalInterface instanceof zzbso ? (zzbso) iInterfaceQueryLocalInterface : new zzbsm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    protected final boolean zzbJ(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            Intent intent = (Intent) zzauo.zza(parcel, Intent.CREATOR);
            zzauo.zzc(parcel);
            zze(intent);
        } else if (i == 2) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            String string2 = parcel.readString();
            zzauo.zzc(parcel);
            zzi(iObjectWrapperAsInterface, string, string2);
        } else if (i == 3) {
            zzh();
        } else if (i == 4) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzauo.zzc(parcel);
            zzg(iObjectWrapperAsInterface2);
        } else {
            if (i != 5) {
                return false;
            }
            String[] strArrCreateStringArray = parcel.createStringArray();
            int[] iArrCreateIntArray = parcel.createIntArray();
            IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzauo.zzc(parcel);
            zzf(strArrCreateStringArray, iArrCreateIntArray, iObjectWrapperAsInterface3);
        }
        parcel2.writeNoException();
        return true;
    }
}
