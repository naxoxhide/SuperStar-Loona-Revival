package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbzk extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, zzbzo zzbzoVar, zzbzh zzbzhVar) throws RemoteException;

    void zzf(zzbtt zzbttVar) throws RemoteException;

    void zzg(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbtk zzbtkVar) throws RemoteException;
}
