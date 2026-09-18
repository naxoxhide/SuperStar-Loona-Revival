package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbzl extends zzaum implements zzbzn {
    zzbzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbzn
    public final zzbzk zze(IObjectWrapper iObjectWrapper, zzbox zzboxVar, int i) throws RemoteException {
        zzbzk zzbziVar;
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        Parcel parcelZzbg = zzbg(2, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        if (strongBinder == null) {
            zzbziVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzbziVar = iInterfaceQueryLocalInterface instanceof zzbzk ? (zzbzk) iInterfaceQueryLocalInterface : new zzbzi(strongBinder);
        }
        parcelZzbg.recycle();
        return zzbziVar;
    }
}
