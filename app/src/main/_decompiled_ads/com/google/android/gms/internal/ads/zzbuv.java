package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbuv extends zzaun implements zzbuw {
    public zzbuv() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    protected final boolean zzbJ(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbuz zzbuxVar = null;
        if (i == 1) {
            zzbuk zzbukVar = (zzbuk) zzauo.zza(parcel, zzbuk.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbuxVar = iInterfaceQueryLocalInterface instanceof zzbuz ? (zzbuz) iInterfaceQueryLocalInterface : new zzbux(strongBinder);
            }
            zzauo.zzc(parcel);
            zzf(zzbukVar, zzbuxVar);
        } else if (i == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (iInterfaceQueryLocalInterface2 instanceof zzbuz) {
                }
            }
            zzauo.zzc(parcel);
        } else {
            if (i != 3) {
                return false;
            }
            zzbuo zzbuoVar = (zzbuo) zzauo.zza(parcel, zzbuo.CREATOR);
            IBinder strongBinder3 = parcel.readStrongBinder();
            if (strongBinder3 != null) {
                IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbuxVar = iInterfaceQueryLocalInterface3 instanceof zzbuz ? (zzbuz) iInterfaceQueryLocalInterface3 : new zzbux(strongBinder3);
            }
            zzauo.zzc(parcel);
            zze(zzbuoVar, zzbuxVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
