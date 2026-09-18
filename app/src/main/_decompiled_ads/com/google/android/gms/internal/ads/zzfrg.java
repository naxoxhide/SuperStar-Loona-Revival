package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfrg extends zzaum implements zzfri {
    zzfrg(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzfri
    public final void zze(Bundle bundle, zzfrk zzfrkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, bundle);
        zzauo.zzf(parcelZza, zzfrkVar);
        zzbi(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfri
    public final void zzf(String str, Bundle bundle, zzfrk zzfrkVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzauo.zzd(parcelZza, bundle);
        zzauo.zzf(parcelZza, zzfrkVar);
        zzbi(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfri
    public final void zzg(Bundle bundle, zzfrk zzfrkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, bundle);
        zzauo.zzf(parcelZza, zzfrkVar);
        zzbi(3, parcelZza);
    }
}
