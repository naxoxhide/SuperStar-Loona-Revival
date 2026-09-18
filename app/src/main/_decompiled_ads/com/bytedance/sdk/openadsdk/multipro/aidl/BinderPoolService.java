package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.n;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.f;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.g;

/* JADX INFO: loaded from: classes2.dex */
public class BinderPoolService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f796b;
    private static boolean c;
    private final Binder a = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.j0().a(BinderPoolService.this.getApplicationContext());
        }
    }

    public static class b extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            m.d("MultiProcess", "queryBinder...........binderCode=" + i);
            if (i == 0) {
                return g.a();
            }
            if (i == 1) {
                return e.a();
            }
            if (i == 4) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.d.c.a();
            }
            if (i == 5) {
                return f.b();
            }
            if (i == 6) {
                return d.a();
            }
            if (i != 7) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.multipro.aidl.d.b.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        m.a("TTAD.BinderPoolService", "BinderPoolService onBind ! ");
        return this.a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m.a("TTAD.BinderPoolService", "BinderPoolService has been created ! ");
        o.a(getApplicationContext());
        f796b = true;
        if (!c) {
            i.b().post(new a());
        }
        c = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m.a("TTAD.BinderPoolService", "BinderPoolService is destroy ! ");
    }
}
