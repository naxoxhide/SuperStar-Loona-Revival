package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcht extends zzaum implements zzchv {
    zzcht(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    @Override // com.google.android.gms.internal.ads.zzchv
    public final void zze(IObjectWrapper iObjectWrapper, zzchs zzchsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzauo.zzf(parcelZza, zzchsVar);
        zzbh(2, parcelZza);
    }
}
