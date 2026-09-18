package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaum;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbow;
import com.google.android.gms.internal.ads.zzbox;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcj extends zzaum implements zzcl {
    zzcj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzbox getAdapterCreator() throws RemoteException {
        Parcel parcelZzbg = zzbg(2, zza());
        zzbox zzboxVarZzf = zzbow.zzf(parcelZzbg.readStrongBinder());
        parcelZzbg.recycle();
        return zzboxVarZzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzen getLiteSdkVersion() throws RemoteException {
        Parcel parcelZzbg = zzbg(1, zza());
        zzen zzenVar = (zzen) zzauo.zza(parcelZzbg, zzen.CREATOR);
        parcelZzbg.recycle();
        return zzenVar;
    }
}
