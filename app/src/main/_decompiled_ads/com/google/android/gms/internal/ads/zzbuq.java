package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbuq extends zzaum implements zzbus {
    zzbuq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zze(zzbvg zzbvgVar, zzbvc zzbvcVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzbvgVar);
        zzauo.zzf(parcelZza, zzbvcVar);
        zzbh(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzf(zzbvg zzbvgVar, zzbvc zzbvcVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzbvgVar);
        zzauo.zzf(parcelZza, zzbvcVar);
        zzbh(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzg(zzbvg zzbvgVar, zzbvc zzbvcVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzbvgVar);
        zzauo.zzf(parcelZza, zzbvcVar);
        zzbh(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzh(String str, zzbvc zzbvcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzauo.zzf(parcelZza, zzbvcVar);
        zzbh(7, parcelZza);
    }
}
