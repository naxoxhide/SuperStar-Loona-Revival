package com.igaworks.adpopcorn.cores.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f1605b;
    private static List<c> c;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.cores.common.a$a, reason: collision with other inner class name */
    class RunnableC0433a implements Runnable {
        final /* synthetic */ Context a;

        RunnableC0433a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor editorEdit = this.a.getSharedPreferences("adpopcorn_parameter", 0).edit();
            editorEdit.putString("google_ad_id", a.f1605b.a());
            editorEdit.commit();
        }
    }

    class b implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f1606b;

        b(Context context, String str) {
            this.a = context;
            this.f1606b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor editorEdit = this.a.getSharedPreferences("adpopcorn_parameter", 0).edit();
            editorEdit.putString("google_ad_id", this.f1606b);
            editorEdit.commit();
        }
    }

    public interface c {
        void a(d dVar);
    }

    public static final class d {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f1607b;

        d(String str, boolean z) {
            this.a = str;
            this.f1607b = z;
        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.f1607b;
        }
    }

    private static final class e implements ServiceConnection {
        boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f1608b;

        private e() {
            this.a = false;
            this.f1608b = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ e(RunnableC0433a runnableC0433a) {
            this();
        }

        public IBinder a() {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.f1608b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f1608b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static final class f implements IInterface {
        private IBinder a;

        public f(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() {
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

        public boolean a(boolean z) {
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
        public IBinder asBinder() {
            return this.a;
        }
    }

    public static d a(Context context, c cVar) {
        d dVarB = b(context, cVar);
        return dVarB == null ? c(context, cVar) : dVarB;
    }

    public static void a(c cVar) {
        if (c == null) {
            c = new ArrayList();
        }
        if (c.contains(cVar)) {
            return;
        }
        c.add(cVar);
    }

    public static d b(Context context, c cVar) {
        RunnableC0433a runnableC0433a = null;
        try {
            d dVar = f1605b;
            if (dVar != null) {
                if (cVar != null) {
                    cVar.a(dVar);
                }
                return f1605b;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (cVar != null) {
                    cVar.a(null);
                }
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            if (a) {
                h.b(context, "AP_OFFER", "onBind > com.google.android.gms", 3);
                if (cVar != null) {
                    h.b(context, "AP_OFFER", "onBind > add to adidListener.", 3);
                    a(cVar);
                }
                return null;
            }
            a = true;
            try {
                e eVar = new e(runnableC0433a);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, eVar, 1)) {
                    try {
                        try {
                            f fVar = new f(eVar.a());
                            d dVar2 = new d(fVar.a(), fVar.a(true));
                            f1605b = dVar2;
                            String strA = dVar2.a();
                            if (strA != null && strA.length() > 0) {
                                new Thread(new b(context, strA)).start();
                            }
                            d dVar3 = f1605b;
                            context.unbindService(eVar);
                            a = false;
                            a = false;
                            h.b(context, "AP_OFFER", "onBind > adid request complete, send callback request to listeners.", 3);
                            if (cVar != null) {
                                try {
                                    cVar.a(f1605b);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            List<c> list = c;
                            if (list != null && list.size() > 0) {
                                ArrayList<c> arrayList = new ArrayList(c);
                                h.b(context, "AP_OFFER", "onBind > adidListeners size : " + c.size(), 3);
                                c.clear();
                                h.b(context, "AP_OFFER", "onBind > adidListeners size(after clear) : " + c.size(), 3);
                                h.b(context, "AP_OFFER", "onBind > tList size : " + arrayList.size(), 3);
                                for (c cVar2 : arrayList) {
                                    h.b(context, "AP_OFFER", "onBind > send adInfo to adidListeners", 3);
                                    cVar2.a(f1605b);
                                }
                                arrayList.clear();
                            }
                            return dVar3;
                        } catch (Throwable th) {
                            context.unbindService(eVar);
                            a = false;
                            throw th;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        context.unbindService(eVar);
                        a = false;
                        throw new IOException("Google Play connection failed");
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Throwable th2) {
                a = false;
                h.b(context, "AP_OFFER", "onBind > adid request complete, send callback request to listeners.", 3);
                if (cVar != null) {
                    try {
                        cVar.a(f1605b);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        throw th2;
                    }
                }
                List<c> list2 = c;
                if (list2 != null && list2.size() > 0) {
                    ArrayList<c> arrayList2 = new ArrayList(c);
                    h.b(context, "AP_OFFER", "onBind > adidListeners size : " + c.size(), 3);
                    c.clear();
                    h.b(context, "AP_OFFER", "onBind > adidListeners size(after clear) : " + c.size(), 3);
                    h.b(context, "AP_OFFER", "onBind > tList size : " + arrayList2.size(), 3);
                    for (c cVar3 : arrayList2) {
                        h.b(context, "AP_OFFER", "onBind > send adInfo to adidListeners", 3);
                        cVar3.a(f1605b);
                    }
                    arrayList2.clear();
                }
                throw th2;
            }
        } catch (Exception e5) {
            h.b(context, "AP_OFFER", e5.toString(), 3);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0385 A[Catch: Exception -> 0x0398, LOOP:4: B:87:0x037f->B:89:0x0385, LOOP_END, TryCatch #2 {Exception -> 0x0398, blocks: (B:81:0x0314, B:82:0x0319, B:84:0x031d, B:86:0x0323, B:87:0x037f, B:89:0x0385, B:90:0x0394), top: B:95:0x0314 }] */
    public static d c(Context context, c cVar) {
        List<c> list;
        try {
            try {
                try {
                    try {
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            if (cVar != null) {
                                cVar.a(null);
                            }
                            throw new IllegalStateException("Cannot be called from the main thread");
                        }
                        h.b(context, "AP_OFFER", "getAndroidADID step2 start", 3);
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                        if (advertisingIdInfo != null) {
                            f1605b = new d(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
                            h.b(context, "AP_OFFER", "getAndroidADID step2 adidInfo : " + f1605b.a() + ", opt_out : " + f1605b.b(), 3);
                            if (f1605b.a() != null && f1605b.a().length() > 0) {
                                new Thread(new RunnableC0433a(context)).start();
                            }
                        }
                        h.b(context, "AP_OFFER", "getAndroidADID step2 send callback request to listeners.", 3);
                        if (cVar != null) {
                            cVar.a(f1605b);
                        }
                        List<c> list2 = c;
                        if (list2 != null && list2.size() > 0) {
                            ArrayList<c> arrayList = new ArrayList(c);
                            h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size : " + c.size(), 3);
                            c.clear();
                            h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size(after clear) : " + c.size(), 3);
                            h.b(context, "AP_OFFER", "getAndroidADID step2 tList size : " + arrayList.size(), 3);
                            for (c cVar2 : arrayList) {
                                h.b(context, "AP_OFFER", "getAndroidADID step2 send adInfo to adidListeners", 3);
                                cVar2.a(f1605b);
                            }
                            arrayList.clear();
                        }
                        return f1605b;
                    } catch (Exception e2) {
                        h.b(context, "AP_OFFER", "getAndroidADID step2 exception : " + e2.toString(), 3);
                        h.b(context, "AP_OFFER", "getAndroidADID step2 send callback request to listeners.", 3);
                        if (cVar != null) {
                            cVar.a(f1605b);
                        }
                        List<c> list3 = c;
                        if (list3 != null && list3.size() > 0) {
                            ArrayList<c> arrayList2 = new ArrayList(c);
                            h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size : " + c.size(), 3);
                            c.clear();
                            h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size(after clear) : " + c.size(), 3);
                            h.b(context, "AP_OFFER", "getAndroidADID step2 tList size : " + arrayList2.size(), 3);
                            for (c cVar3 : arrayList2) {
                                h.b(context, "AP_OFFER", "getAndroidADID step2 send adInfo to adidListeners", 3);
                                cVar3.a(f1605b);
                            }
                            arrayList2.clear();
                        }
                    } catch (NoSuchMethodError e3) {
                        h.b(context, "AP_OFFER", "getAndroidADID step2 noSuchMethodError : " + e3.toString(), 3);
                        h.b(context, "AP_OFFER", "getAndroidADID step2 send callback request to listeners.", 3);
                        if (cVar != null) {
                            cVar.a(f1605b);
                        }
                        List<c> list4 = c;
                        if (list4 != null && list4.size() > 0) {
                            ArrayList<c> arrayList3 = new ArrayList(c);
                            h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size : " + c.size(), 3);
                            c.clear();
                            h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size(after clear) : " + c.size(), 3);
                            h.b(context, "AP_OFFER", "getAndroidADID step2 tList size : " + arrayList3.size(), 3);
                            for (c cVar4 : arrayList3) {
                                h.b(context, "AP_OFFER", "getAndroidADID step2 send adInfo to adidListeners", 3);
                                cVar4.a(f1605b);
                            }
                            arrayList3.clear();
                        }
                    }
                } catch (NoClassDefFoundError e4) {
                    h.b(context, "AP_OFFER", "getAndroidADID step2 noClassDefFoundError : " + e4.toString(), 3);
                    h.b(context, "AP_OFFER", "getAndroidADID step2 send callback request to listeners.", 3);
                    if (cVar != null) {
                        cVar.a(f1605b);
                    }
                    List<c> list5 = c;
                    if (list5 != null && list5.size() > 0) {
                        ArrayList<c> arrayList4 = new ArrayList(c);
                        h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size : " + c.size(), 3);
                        c.clear();
                        h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size(after clear) : " + c.size(), 3);
                        h.b(context, "AP_OFFER", "getAndroidADID step2 tList size : " + arrayList4.size(), 3);
                        for (c cVar5 : arrayList4) {
                            h.b(context, "AP_OFFER", "getAndroidADID step2 send adInfo to adidListeners", 3);
                            cVar5.a(f1605b);
                        }
                        arrayList4.clear();
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } catch (Throwable th) {
            h.b(context, "AP_OFFER", "getAndroidADID step2 send callback request to listeners.", 3);
            if (cVar != null) {
                try {
                    cVar.a(f1605b);
                    list = c;
                    if (list != null && list.size() > 0) {
                        ArrayList<c> arrayList5 = new ArrayList(c);
                        h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size : " + c.size(), 3);
                        c.clear();
                        h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size(after clear) : " + c.size(), 3);
                        h.b(context, "AP_OFFER", "getAndroidADID step2 tList size : " + arrayList5.size(), 3);
                        for (c cVar6 : arrayList5) {
                            h.b(context, "AP_OFFER", "getAndroidADID step2 send adInfo to adidListeners", 3);
                            cVar6.a(f1605b);
                        }
                        arrayList5.clear();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                    throw th;
                }
            } else {
                list = c;
                if (list != null) {
                    ArrayList<c> arrayList6 = new ArrayList(c);
                    h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size : " + c.size(), 3);
                    c.clear();
                    h.b(context, "AP_OFFER", "getAndroidADID step2 adidListeners size(after clear) : " + c.size(), 3);
                    h.b(context, "AP_OFFER", "getAndroidADID step2 tList size : " + arrayList6.size(), 3);
                    while (r1.hasNext()) {
                        h.b(context, "AP_OFFER", "getAndroidADID step2 send adInfo to adidListeners", 3);
                        cVar6.a(f1605b);
                    }
                    arrayList6.clear();
                }
            }
            throw th;
        }
    }
}
