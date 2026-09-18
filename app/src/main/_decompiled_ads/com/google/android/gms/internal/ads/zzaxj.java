package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaxj extends zzaum implements IInterface {
    zzaxj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzaxh zzaxhVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzaxhVar);
        Parcel parcelZzbg = zzbg(3, parcelZza);
        long j = parcelZzbg.readLong();
        parcelZzbg.recycle();
        return j;
    }

    public final zzaxe zzf(zzaxh zzaxhVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzaxhVar);
        Parcel parcelZzbg = zzbg(1, parcelZza);
        zzaxe zzaxeVar = (zzaxe) zzauo.zza(parcelZzbg, zzaxe.CREATOR);
        parcelZzbg.recycle();
        return zzaxeVar;
    }

    public final zzaxe zzg(zzaxh zzaxhVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzaxhVar);
        Parcel parcelZzbg = zzbg(2, parcelZza);
        zzaxe zzaxeVar = (zzaxe) zzauo.zza(parcelZzbg, zzaxe.CREATOR);
        parcelZzbg.recycle();
        return zzaxeVar;
    }
}
