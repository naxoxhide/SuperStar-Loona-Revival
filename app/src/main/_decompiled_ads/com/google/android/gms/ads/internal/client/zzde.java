package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaum;
import com.google.android.gms.internal.ads.zzauo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzde extends zzaum implements zzdg {
    zzde(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdg
    public final void zze(zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, zzsVar);
        zzbh(1, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdg
    public final boolean zzf() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }
}
