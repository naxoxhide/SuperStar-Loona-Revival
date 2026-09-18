package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbst extends zzaum implements zzbsv {
    zzbst(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final boolean zzH() throws RemoteException {
        Parcel parcelZzbg = zzbg(11, zza());
        boolean zZzg = zzauo.zzg(parcelZzbg);
        parcelZzbg.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzh(int i, int i2, Intent intent) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeInt(i2);
        zzauo.zzd(parcelZza, intent);
        zzbh(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzi() throws RemoteException {
        zzbh(10, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzf(parcelZza, iObjectWrapper);
        zzbh(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzl(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, bundle);
        zzbh(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzm() throws RemoteException {
        zzbh(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzo() throws RemoteException {
        zzbh(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzp(int i, String[] strArr, int[] iArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzbh(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzq() throws RemoteException {
        zzbh(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzr() throws RemoteException {
        zzbh(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzs(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzauo.zzd(parcelZza, bundle);
        Parcel parcelZzbg = zzbg(6, parcelZza);
        if (parcelZzbg.readInt() != 0) {
            bundle.readFromParcel(parcelZzbg);
        }
        parcelZzbg.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzt() throws RemoteException {
        zzbh(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzu() throws RemoteException {
        zzbh(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzv() throws RemoteException {
        zzbh(14, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final void zzx() throws RemoteException {
        zzbh(9, zza());
    }
}
