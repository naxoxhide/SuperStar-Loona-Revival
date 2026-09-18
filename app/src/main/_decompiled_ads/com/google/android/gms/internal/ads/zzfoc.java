package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfoc extends zzaum implements IInterface {
    zzfoc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfoa zze(zzfny zzfnyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzfnyVar);
        Parcel parcelZzbg = zzbg(1, parcelZza);
        zzfoa zzfoaVar = (zzfoa) zzauo.zza(parcelZzbg, zzfoa.CREATOR);
        parcelZzbg.recycle();
        return zzfoaVar;
    }

    public final zzfoj zzf(zzfoh zzfohVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzfohVar);
        Parcel parcelZzbg = zzbg(3, parcelZza);
        zzfoj zzfojVar = (zzfoj) zzauo.zza(parcelZzbg, zzfoj.CREATOR);
        parcelZzbg.recycle();
        return zzfojVar;
    }

    public final void zzg(zzfnv zzfnvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzfnvVar);
        zzbh(2, parcelZza);
    }
}
