package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbuu extends zzaum implements zzbuw {
    zzbuu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzbuw
    public final void zze(zzbuo zzbuoVar, zzbuz zzbuzVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzbuoVar);
        zzauo.zzf(parcelZza, zzbuzVar);
        zzbh(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuw
    public final void zzf(zzbuk zzbukVar, zzbuz zzbuzVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzbukVar);
        zzauo.zzf(parcelZza, zzbuzVar);
        zzbh(1, parcelZza);
    }
}
