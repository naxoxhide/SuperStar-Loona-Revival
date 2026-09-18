package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbox;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzcl extends IInterface {
    zzbox getAdapterCreator() throws RemoteException;

    zzen getLiteSdkVersion() throws RemoteException;
}
