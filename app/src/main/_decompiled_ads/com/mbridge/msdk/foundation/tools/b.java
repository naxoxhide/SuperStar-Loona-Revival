package com.mbridge.msdk.foundation.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: AdvertisingIdClient.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    public final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2204b;
        private final boolean c;

        a(String str, boolean z) {
            this.f2204b = str;
            this.c = z;
        }

        public final String a() {
            return this.f2204b;
        }

        public final boolean b() {
            return this.c;
        }
    }

    public final a a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC0488b serviceConnectionC0488b = new ServiceConnectionC0488b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, serviceConnectionC0488b, 1)) {
                try {
                    try {
                        c cVar = new c(serviceConnectionC0488b.a());
                        a aVar = new a(cVar.a(), cVar.a(true));
                        context.unbindService(serviceConnectionC0488b);
                        return aVar;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Throwable th) {
                    context.unbindService(serviceConnectionC0488b);
                    throw th;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.tools.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    private final class ServiceConnectionC0488b implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> c;

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private ServiceConnectionC0488b() {
            this.a = false;
            this.c = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException e) {
                aa.d("AdvertisingIdClient", e.getMessage());
            }
        }

        public final IBinder a() throws InterruptedException {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.c.take();
        }
    }

    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    private final class c implements IInterface {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IBinder f2206b;

        public c(IBinder iBinder) {
            this.f2206b = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f2206b;
        }

        public final String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f2206b.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th) {
                try {
                    aa.d("AdvertisingIdClient", th.getMessage());
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public final boolean a(boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z2 = false;
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.f2206b.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() != 0) {
                    z2 = true;
                }
            } catch (Throwable th) {
                try {
                    aa.d("AdvertisingIdClient", th.getMessage());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
            return z2;
        }
    }
}
