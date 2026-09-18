package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbwo extends zzaun implements zzbwp {
    public zzbwo() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbwp zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return iInterfaceQueryLocalInterface instanceof zzbwp ? (zzbwp) iInterfaceQueryLocalInterface : new zzbwn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    protected final boolean zzbJ(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbww zzbwuVar = null;
        zzbww zzbwuVar2 = null;
        zzbwx zzbwxVar = null;
        zzbws zzbwqVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzauo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwuVar = iInterfaceQueryLocalInterface instanceof zzbww ? (zzbww) iInterfaceQueryLocalInterface : new zzbwu(strongBinder);
                }
                zzauo.zzc(parcel);
                zzf(zzlVar, zzbwuVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzbwqVar = iInterfaceQueryLocalInterface2 instanceof zzbws ? (zzbws) iInterfaceQueryLocalInterface2 : new zzbwq(strongBinder2);
                }
                zzauo.zzc(parcel);
                zzk(zzbwqVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzo = zzo();
                parcel2.writeNoException();
                int i3 = zzauo.zza;
                parcel2.writeInt(zZzo ? 1 : 0);
                return true;
            case 4:
                String strZze = zze();
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzm(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzbwxVar = iInterfaceQueryLocalInterface3 instanceof zzbwx ? (zzbwx) iInterfaceQueryLocalInterface3 : new zzbwx(strongBinder3);
                }
                zzauo.zzc(parcel);
                zzp(zzbwxVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbxd zzbxdVar = (zzbxd) zzauo.zza(parcel, zzbxd.CREATOR);
                zzauo.zzc(parcel);
                zzl(zzbxdVar);
                parcel2.writeNoException();
                return true;
            case 8:
                com.google.android.gms.ads.internal.client.zzdd zzddVarZzb = com.google.android.gms.ads.internal.client.zzdc.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzi(zzddVarZzb);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle bundleZzb = zzb();
                parcel2.writeNoException();
                zzauo.zze(parcel2, bundleZzb);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zZzg = zzauo.zzg(parcel);
                zzauo.zzc(parcel);
                zzn(iObjectWrapperAsInterface2, zZzg);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbwm zzbwmVarZzd = zzd();
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzbwmVarZzd);
                return true;
            case 12:
                com.google.android.gms.ads.internal.client.zzdn zzdnVarZzc = zzc();
                parcel2.writeNoException();
                zzauo.zzf(parcel2, zzdnVarZzc);
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzdg zzdgVarZzb = com.google.android.gms.ads.internal.client.zzdf.zzb(parcel.readStrongBinder());
                zzauo.zzc(parcel);
                zzj(zzdgVarZzb);
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzauo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwuVar2 = iInterfaceQueryLocalInterface4 instanceof zzbww ? (zzbww) iInterfaceQueryLocalInterface4 : new zzbwu(strongBinder4);
                }
                zzauo.zzc(parcel);
                zzg(zzlVar2, zzbwuVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zZzg2 = zzauo.zzg(parcel);
                zzauo.zzc(parcel);
                zzh(zZzg2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
