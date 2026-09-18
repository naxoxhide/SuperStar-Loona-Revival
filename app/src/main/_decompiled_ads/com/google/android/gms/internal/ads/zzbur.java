package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbur extends zzaun implements zzbus {
    public zzbur() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    protected final boolean zzbJ(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbvc zzbvaVar = null;
        if (i == 1) {
            zzauo.zzc(parcel);
            parcel2.writeNoException();
            zzauo.zze(parcel2, null);
        } else if (i == 2) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (iInterfaceQueryLocalInterface instanceof zzbut) {
                }
            }
            zzauo.zzc(parcel);
            parcel2.writeNoException();
        } else if (i == 4) {
            zzbvg zzbvgVar = (zzbvg) zzauo.zza(parcel, zzbvg.CREATOR);
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbvaVar = iInterfaceQueryLocalInterface2 instanceof zzbvc ? (zzbvc) iInterfaceQueryLocalInterface2 : new zzbva(strongBinder2);
            }
            zzauo.zzc(parcel);
            zzg(zzbvgVar, zzbvaVar);
            parcel2.writeNoException();
        } else if (i == 5) {
            zzbvg zzbvgVar2 = (zzbvg) zzauo.zza(parcel, zzbvg.CREATOR);
            IBinder strongBinder3 = parcel.readStrongBinder();
            if (strongBinder3 != null) {
                IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbvaVar = iInterfaceQueryLocalInterface3 instanceof zzbvc ? (zzbvc) iInterfaceQueryLocalInterface3 : new zzbva(strongBinder3);
            }
            zzauo.zzc(parcel);
            zzf(zzbvgVar2, zzbvaVar);
            parcel2.writeNoException();
        } else if (i == 6) {
            zzbvg zzbvgVar3 = (zzbvg) zzauo.zza(parcel, zzbvg.CREATOR);
            IBinder strongBinder4 = parcel.readStrongBinder();
            if (strongBinder4 != null) {
                IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbvaVar = iInterfaceQueryLocalInterface4 instanceof zzbvc ? (zzbvc) iInterfaceQueryLocalInterface4 : new zzbva(strongBinder4);
            }
            zzauo.zzc(parcel);
            zze(zzbvgVar3, zzbvaVar);
            parcel2.writeNoException();
        } else {
            if (i != 7) {
                return false;
            }
            String string = parcel.readString();
            IBinder strongBinder5 = parcel.readStrongBinder();
            if (strongBinder5 != null) {
                IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbvaVar = iInterfaceQueryLocalInterface5 instanceof zzbvc ? (zzbvc) iInterfaceQueryLocalInterface5 : new zzbva(strongBinder5);
            }
            zzauo.zzc(parcel);
            zzh(string, zzbvaVar);
            parcel2.writeNoException();
        }
        return true;
    }
}
