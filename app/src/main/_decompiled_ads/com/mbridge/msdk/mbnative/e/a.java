package com.mbridge.msdk.mbnative.e;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbnative.controller.b;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NativeProvider.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private NativeController a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f2316b = new Handler(Looper.getMainLooper());
    private com.mbridge.msdk.mbnative.c.a c;
    private NativeListener.NativeTrackingListener d;

    public final void a(com.mbridge.msdk.mbnative.c.a aVar) {
        this.c = aVar;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.d = nativeTrackingListener;
    }

    public a() {
    }

    public a(com.mbridge.msdk.mbnative.c.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.c = aVar;
        this.d = nativeTrackingListener;
    }

    public final void a(Context context, Resources resources, Map<String, Object> map) {
        this.a = new NativeController(this.c, this.d, map, context);
    }

    public final void a() {
        a(0, "");
    }

    public final void a(String str) {
        a(0, str);
    }

    public final void b() {
        a(1, "");
    }

    public final void d() {
        try {
            this.a.a();
        } catch (Exception unused) {
            aa.d("NativeProvider", "release failed");
        }
    }

    public final void a(View view, List<View> list, Campaign campaign) {
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view, list);
    }

    public final void a(View view, Campaign campaign) {
        aa.b("NativeProvider", "native provider registerView");
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view);
    }

    public final void b(View view, Campaign campaign) {
        aa.b("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view);
    }

    public final void b(View view, List<View> list, Campaign campaign) {
        aa.b("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view, list);
    }

    public static void preload(Map<String, Object> map, int i) {
        aa.b("NativeProvider", "native provider preload");
        new b().a(map, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.c.onAdLoadError("current request is loading");
        this.c.c();
    }

    private void a(int i, String str) {
        if (this.a != null) {
            com.mbridge.msdk.mbnative.c.a aVar = this.c;
            if (aVar != null && aVar.b()) {
                if (af.b()) {
                    f();
                    return;
                } else {
                    this.f2316b.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.e.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.f();
                        }
                    });
                    return;
                }
            }
            com.mbridge.msdk.mbnative.c.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.c();
            }
            this.a.a(i, str);
        }
    }

    public final String e() {
        NativeController nativeController = this.a;
        return nativeController != null ? nativeController.b() : "";
    }

    public final void c() {
        try {
            y.a();
        } catch (Exception unused) {
            aa.d("NativeProvider", "clear cache failed");
        }
    }
}
