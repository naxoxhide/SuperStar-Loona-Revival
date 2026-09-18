package com.applovin.exoplayer2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class f extends Binder {
    private static final int ah;
    private final com.applovin.exoplayer2.common.a.s<Bundle> ai;

    static {
        ah = com.applovin.exoplayer2.l.ai.acV >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    @Override // android.os.Binder
    protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.ai.size();
        int i3 = parcel.readInt();
        while (i3 < size && parcel2.dataSize() < ah) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.ai.get(i3));
            i3++;
        }
        parcel2.writeInt(i3 < size ? 2 : 0);
        return true;
    }

    public static com.applovin.exoplayer2.common.a.s<Bundle> a(IBinder iBinder) {
        int i;
        com.applovin.exoplayer2.common.a.s.a aVarGc = com.applovin.exoplayer2.common.a.s.gc();
        int i2 = 0;
        int i3 = 1;
        while (i3 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i2);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i = parcelObtain2.readInt();
                        if (i == 1) {
                            aVarGc.t((Bundle) com.applovin.exoplayer2.l.a.checkNotNull(parcelObtain2.readBundle()));
                            i2++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i3 = i;
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return aVarGc.gd();
    }
}
