package com.bytedance.sdk.openadsdk.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.settings.n;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PAGAppOpenAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends PAGAppOpenAd {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f439b;
    private final AdSlot c;
    private com.bytedance.sdk.openadsdk.a.e.b d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final String f = com.bytedance.sdk.openadsdk.utils.q.a();
    private final boolean g;
    private boolean h;
    private boolean i;

    /* JADX INFO: compiled from: PAGAppOpenAdImpl.java */
    class a extends b.b.a.a.k.g {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.multipro.aidl.a aVarC = com.bytedance.sdk.openadsdk.multipro.aidl.a.c();
            if (d.this.d != null) {
                m.a("MultiProcess", "start registerAppOpenListener ! ");
                IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(aVarC.a(7));
                if (iListenerManagerAsInterface != null) {
                    try {
                        iListenerManagerAsInterface.registerAppOpenAdListener(d.this.f, new com.bytedance.sdk.openadsdk.multipro.aidl.e.a(d.this.d));
                        d.this.d = null;
                        m.a("MultiProcess", "end registerAppOpenAdListener ! ");
                    } catch (RemoteException e) {
                        m.b("TTAppOpenAdImpl", e.getMessage());
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: PAGAppOpenAdImpl.java */
    class b implements com.bytedance.sdk.component.utils.b.a {
        b(d dVar) {
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a() {
            m.a("TTAppOpenAdImpl", "app open ad startActivitySuccess");
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a(Throwable th) {
            m.a("TTAppOpenAdImpl", "app open ad startActivityFail");
        }
    }

    public d(Context context, q qVar, boolean z, AdSlot adSlot) {
        this.a = context;
        this.f439b = qVar;
        this.g = z;
        this.c = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        q qVar = this.f439b;
        if (qVar != null) {
            return qVar.i0();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.i) {
            return;
        }
        u.a(this.f439b, d, str, str2);
        this.i = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionCallback(PAGAppOpenAdInteractionCallback pAGAppOpenAdInteractionCallback) {
        this.d = new e(pAGAppOpenAdInteractionCallback);
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.d = new e(pAGAppOpenAdInteractionListener);
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void show(Activity activity) {
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (this.e.getAndSet(true)) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            m.b("TTAppOpenAdImpl", "showTTAppOpenAd error: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread ---- TTAppOpenAdImpl.showAppOpenAd");
        }
        Context contextA = activity != null ? activity : this.a;
        if (contextA == null) {
            contextA = o.a();
        }
        int rotation = 0;
        try {
            rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        } catch (Exception unused) {
        }
        Intent intent = new Intent(contextA, (Class<?>) TTAppOpenAdActivity.class);
        intent.putExtra("orientation_angle", rotation);
        intent.putExtra("ad_source", this.g ? 1 : 2);
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f439b.n1().toString());
            intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.f);
        } else {
            s.g().a();
            s.g().a(this.f439b);
            s.g().a(this.d);
            this.d = null;
        }
        intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.utils.b.a(contextA, intent, new b(this));
        if (this.c != null) {
            try {
                if (n.j0().p(this.c.getCodeId()) == 1) {
                    f fVarA = f.a(this.a);
                    fVarA.c(Integer.parseInt(this.c.getCodeId()));
                    fVarA.b(this.c);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.h) {
            return;
        }
        u.a(this.f439b, d);
        this.h = true;
    }

    private void a() {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            y.a(new a("AppOpenAd_registerMultiProcessListener"), 5);
        }
    }
}
