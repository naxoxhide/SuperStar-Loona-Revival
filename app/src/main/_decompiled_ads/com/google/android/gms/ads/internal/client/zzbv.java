package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaum;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbox;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbv extends zzaum implements IInterface {
    zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbox zzboxVar, int i, int i2) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzboxVar);
        parcelZza.writeInt(233702000);
        parcelZza.writeInt(i2);
        Parcel parcelZzbg = zzbg(2, parcelZza);
        IBinder strongBinder = parcelZzbg.readStrongBinder();
        parcelZzbg.recycle();
        return strongBinder;
    }
}
