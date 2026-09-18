package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.f;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: BinderPool.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final a f = new a();
    private IBinderPool a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.multipro.aidl.b f797b;
    private long c = 0;
    private final ServiceConnection d = new b();
    private final IBinder.DeathRecipient e = new c();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BinderPool.java */
    class C0242a extends g {
        C0242a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f797b != null) {
                a.this.f797b.onServiceConnected();
            }
        }
    }

    /* JADX INFO: compiled from: BinderPool.java */
    class b implements ServiceConnection {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BinderPool.java */
        class C0243a extends g {
            final /* synthetic */ IBinder c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0243a(String str, IBinder iBinder) {
                super(str);
                this.c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a = IBinderPool.Stub.asInterface(this.c);
                try {
                    a.this.a.asBinder().linkToDeath(a.this.e, 0);
                } catch (RemoteException e) {
                    m.b("TTAD.BinderPool", "onServiceConnected throws :", e);
                }
                m.a("TTAD.BinderPool", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.c));
                if (a.this.f797b != null) {
                    a.this.f797b.onServiceConnected();
                }
            }
        }

        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            y.b(new C0243a("onServiceConnected", iBinder), 5);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            m.d("TTAD.BinderPool", "BinderPool......onServiceDisconnected");
        }
    }

    /* JADX INFO: compiled from: BinderPool.java */
    class c implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BinderPool.java */
        class C0244a extends g {
            C0244a(String str) {
                super(str);
            }

            @Override // java.lang.Runnable
            public void run() {
                m.f("TTAD.BinderPool", "binder died.");
                a.this.a.asBinder().unlinkToDeath(a.this.e, 0);
                a.this.a = null;
                a.this.b();
            }
        }

        c() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            y.b(new C0244a("binderDied"), 5);
        }
    }

    private a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            m.d("TTAD.BinderPool", "BinderPool......connectBinderPoolService");
            a();
        }
    }

    public static a c() {
        return f;
    }

    public void d() {
        try {
            Context contextA = o.a();
            contextA.startService(new Intent(contextA, (Class<?>) BinderPoolService.class));
        } catch (Exception unused) {
        }
    }

    public void a() {
        try {
            Context contextA = o.a();
            contextA.bindService(new Intent(contextA, (Class<?>) BinderPoolService.class), this.d, 1);
            this.c = System.currentTimeMillis();
        } catch (Throwable unused) {
        }
    }

    public void a(com.bytedance.sdk.openadsdk.multipro.aidl.b bVar) {
        this.f797b = bVar;
        if (this.a != null) {
            y.b(new C0242a("onServiceConnected2"), 5);
        }
    }

    public IBinder a(int i) {
        try {
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                try {
                    IBinderPool iBinderPool = this.a;
                    if (iBinderPool != null) {
                        return iBinderPool.queryBinder(i);
                    }
                    return null;
                } catch (RemoteException e) {
                    m.b("TTAD.BinderPool", e.getMessage());
                    a0.k("queryBinder error");
                    return null;
                }
            }
            if (i == 0) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.d.g.a();
            }
            if (i == 1) {
                return e.a();
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
        } catch (Throwable unused) {
            return null;
        }
    }
}
