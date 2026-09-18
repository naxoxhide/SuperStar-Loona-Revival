package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzawq extends zzaum implements zzaws {
    zzawq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaws
    public final void zzb(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzbh(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzaws
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzeVar);
        zzbh(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzaws
    public final void zzd(zzawp zzawpVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, zzawpVar);
        zzbh(1, parcelZza);
    }
}
