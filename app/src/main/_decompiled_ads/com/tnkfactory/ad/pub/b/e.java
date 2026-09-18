package com.tnkfactory.ad.pub.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    public static class a extends Binder implements IInterface {
        public IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        public final String a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public final boolean a(boolean z) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.a;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean zA = a(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String string = parcel.readString();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeString(string);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    String string2 = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    parcel2.writeNoException();
                    parcel2.writeString(string2);
                    return true;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
            if (i != 4) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String string3 = parcel.readString();
            int i3 = parcel.readInt() != 0 ? 1 : 0;
            Parcel parcelObtain3 = Parcel.obtain();
            Parcel parcelObtain4 = Parcel.obtain();
            try {
                parcelObtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain3.writeString(string3);
                parcelObtain3.writeInt(i3);
                this.a.transact(4, parcelObtain3, parcelObtain4, 0);
                parcelObtain4.readException();
                parcelObtain4.recycle();
                parcelObtain3.recycle();
                parcel2.writeNoException();
                return true;
            } catch (Throwable th2) {
                parcelObtain4.recycle();
                parcelObtain3.recycle();
                throw th2;
            }
        }
    }

    public static class b implements ServiceConnection {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BlockingQueue<IBinder> f2905b = new LinkedBlockingQueue();

        public b() {
            this.a = false;
            this.a = false;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.concurrent.BlockingQueue<android.os.IBinder>, java.util.concurrent.LinkedBlockingQueue] */
        public final IBinder a() {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return (IBinder) this.f2905b.take();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.concurrent.BlockingQueue<android.os.IBinder>, java.util.concurrent.LinkedBlockingQueue] */
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f2905b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static d a(Context context) throws IOException {
        Context applicationContext = context.getApplicationContext();
        PackageManager packageManager = applicationContext.getPackageManager();
        try {
            packageManager.getPackageInfo("com.android.vending", 0);
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                if (packageInfo.versionCode < 4242000) {
                    throw new IOException("Google Play services out of date. Requires 4242000 but found " + packageInfo.versionCode);
                }
                try {
                    if (!packageManager.getApplicationInfo("com.google.android.gms", 0).enabled) {
                        throw new IOException("Google Play services is not enabled.");
                    }
                    b bVar = new b();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!applicationContext.bindService(intent, bVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        try {
                            a aVarA = a(bVar.a());
                            d dVar = new d(aVarA.a(), aVarA.a(true));
                            applicationContext.unbindService(bVar);
                            return dVar;
                        } catch (RemoteException e) {
                            throw new IOException("GMS Remote exception: " + e);
                        } catch (InterruptedException e2) {
                            throw new IOException("Interrupted exception: " + e2);
                        }
                    } catch (Throwable th) {
                        applicationContext.unbindService(bVar);
                        throw th;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new IOException("Google Play services is missing when getting application info.");
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new IOException("Google Play services is missing.");
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Google Play Store is missing.");
        }
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new a(iBinder) : (a) iInterfaceQueryLocalInterface;
    }
}
