package com.bytedance.sdk.openadsdk.api.init;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import b.b.a.a.b;
import b.b.a.a.d.e.b.d;
import b.b.a.a.k.e;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.core.g0.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.core.settings.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.PangleWebView;
import com.bytedance.sdk.openadsdk.d.p.f;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.m;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    private static long a;

    public interface PAGInitCallback {
        void fail(int i, String str);

        void success();
    }

    static {
        l.a(System.currentTimeMillis());
        l.a();
        SSWebView.setWebViewProvider(new SSWebView.t0() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.1
            @Override // com.bytedance.sdk.component.widget.SSWebView.t0
            public WebView createWebView(Context context, AttributeSet attributeSet, int i) {
                return i == 0 ? new PangleWebView(context, attributeSet) : new PangleWebView(context, attributeSet, i);
            }
        });
        a = 0L;
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && l.b() == 0) {
            PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Context applicationContext;
        a = SystemClock.elapsedRealtime();
        o.a(context);
        if (pAGInitCallback != null) {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                if (!list.contains(pAGInitCallback)) {
                    list.add(pAGInitCallback);
                    if (l.b() == 3) {
                        return;
                    }
                }
            }
        }
        if (isInitSuccess()) {
            b();
            return;
        }
        l.a(3);
        if (context == null) {
            b(4000, "Context is null, please check. ");
            return;
        }
        if (!(context instanceof Application) && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        if (initConfig == null) {
            b(4000, "PAGConfig is null, please check.");
            return;
        }
        e(context, initConfig);
        ApmHelper.initApm(context, initConfig);
        if (Build.VERSION.SDK_INT >= 19) {
            b.d.a(y.b());
        }
        try {
            h.a(new k() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.2
                @Override // com.bytedance.sdk.openadsdk.core.k
                public void fail(int i, String str) {
                    PAGSdk.b(i, str);
                }

                public void success() {
                    PAGSdk.b();
                }
            });
            try {
                t.k(o.a(), "tt_ad_logo_txt");
                if (t.e(context, "tt_ad_logo_new") == 0) {
                    a(initConfig, pAGInitCallback);
                    return;
                }
                if (isInitSuccess()) {
                    if (pAGInitCallback != null) {
                        b();
                        return;
                    }
                    return;
                }
                final a aVar = new a();
                SDKTypeConfig.setSdkTypeFactory(new ISDKTypeFactory() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.3
                    @Override // com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory
                    public IADTypeLoaderFactory createADTypeLoaderFactory(String str) {
                        return aVar;
                    }
                });
                if (!initConfig.isSupportMultiProcess()) {
                    f(context, initConfig);
                } else {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a.c().a(new com.bytedance.sdk.openadsdk.multipro.aidl.b() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.4
                        @Override // com.bytedance.sdk.openadsdk.multipro.aidl.b
                        public void onServiceConnected() {
                            l.a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    PAGSdk.f(context, initConfig);
                                }
                            });
                        }
                    });
                    com.bytedance.sdk.openadsdk.multipro.aidl.a.c().a();
                }
            } catch (Throwable unused) {
                a(initConfig, pAGInitCallback);
            }
        } catch (Throwable unused2) {
            b(4000, "Internal Error, setting exception. ");
        }
    }

    private static void c(final Context context, final InitConfig initConfig) {
        SystemClock.elapsedRealtime();
        y.b(new g("init_sync") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.5
            @Override // java.lang.Runnable
            public void run() {
                d.a(m.a() * 10);
                com.bytedance.sdk.openadsdk.d.p.d.a(context, initConfig.isSupportMultiProcess());
                com.bytedance.sdk.openadsdk.core.m.a().c();
                c.c();
                PAGSdk.getBiddingToken();
                com.bytedance.sdk.openadsdk.p.a.a(new com.bytedance.sdk.openadsdk.p.a.InterfaceC0253a(this) { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.5.1
                    public void onGdprChanged(int i) {
                        PAGConfig.setGDPRConsent(i);
                    }
                });
                n.p = n.d(context);
                com.bytedance.sdk.openadsdk.q.c.g.a();
                b.a.a.a.a.a.b.a.a(o.d().S());
                b.a.a.a.a.a.b.a.a(CacheDirFactory.getICacheDir(0));
                com.bytedance.sdk.openadsdk.core.settings.d dVarD = o.d();
                if (!dVarD.G()) {
                    synchronized (dVarD) {
                        if (!dVarD.G()) {
                            dVarD.u();
                            dVarD.D();
                        }
                    }
                }
                DeviceUtils.m();
                PAGInitHelper.maybeAsyncInitTask(context);
                e.a(true);
                e.a(new com.bytedance.sdk.openadsdk.l.d.a());
                DeviceUtils.p(context);
                DeviceUtils.q(context);
                b.c.a.a.a.a.b.a(context);
                com.bytedance.sdk.openadsdk.d.p.a.b();
                f.b();
                AppSetIdAndScope.c();
                com.bytedance.sdk.openadsdk.l.b.b();
                a0.l(context);
                com.bytedance.sdk.openadsdk.d.c.a();
            }
        });
    }

    public static void closeMultiWebViewFileLock() {
        com.bytedance.sdk.openadsdk.m.c.a();
    }

    private static void d(Context context, InitConfig initConfig) {
        if (j.a()) {
            e.c(-1);
            com.bytedance.sdk.openadsdk.m.c.b(context);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) y.c();
            b.b.a.a.j.e.a.a(threadPoolExecutor);
            com.bytedance.sdk.openadsdk.f.b.a(threadPoolExecutor);
            l.f640b.set(true);
            try {
                b.b.a.a.d.e.a.a.d().a(new com.bytedance.sdk.openadsdk.h.a());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.PAGSdk", e.getMessage());
            }
            c(initConfig);
            b(context, initConfig);
            b.a.a.a.a.a.a.i.c.c("PangleSDK-5411");
            com.bytedance.sdk.component.utils.m.d("PangleSDK-5411");
            b.a.a.a.a.a.a.c.a(context, null);
            b.a.a.a.a.a.a.c.a(2);
            b.a.a.a.a.a.a.c.a(initConfig.isSupportMultiProcess());
            b.a.a.a.a.a.a.c.a(com.bytedance.sdk.openadsdk.n.c.b().d().c());
            if (Build.VERSION.SDK_INT < 23) {
                b.a.a.a.a.a.b.a.a(context);
            }
        }
    }

    private static void e(Context context, InitConfig initConfig) {
        if (TextUtils.isEmpty(initConfig.getPackageName())) {
            t.a((String) null);
        } else {
            t.a(initConfig.getPackageName());
        }
        o.a(context);
        if (initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.m.b.c();
        } else {
            com.bytedance.sdk.openadsdk.m.b.a();
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.j.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, InitConfig initConfig) {
        long jElapsedRealtime;
        try {
            if (isInitSuccess()) {
                b();
                return;
            }
            d(context, initConfig);
            n.j0().q();
            jElapsedRealtime = SystemClock.elapsedRealtime() - a;
            b();
            c(context, initConfig);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - a;
            a(context, isInitSuccess(), initConfig, jElapsedRealtime2, jElapsedRealtime);
            com.bytedance.sdk.component.utils.m.c("TTAD.PAGSdk", "init Pangle exec init sdk sdkInitTime=", Long.valueOf(jElapsedRealtime), " duration=", Long.valueOf(jElapsedRealtime2));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.d("TTAD.PAGSdk", "init Pangle throwable " + th.getMessage());
            com.bytedance.sdk.component.utils.m.b("TTAD.PAGSdk", th.getMessage());
            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - a;
            b(4000, th.getMessage());
            jElapsedRealtime = jElapsedRealtime3;
        }
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getBiddingToken(Context context, String str) {
        o.a(context);
        return getBiddingToken(str);
    }

    public static String getSDKVersion() {
        return v.a() != null ? v.a().b() : "";
    }

    public static void init(final Context context, final PAGConfig pAGConfig, final PAGInitCallback pAGInitCallback) {
        l.a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7
            @Override // java.lang.Runnable
            public void run() {
                PAGSdk.b(context, pAGConfig, pAGInitCallback);
            }
        });
    }

    public static boolean isInitSuccess() {
        return l.b() == 1;
    }

    public static boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (v.a() != null) {
            return v.a().a(str, i, str2, str3, str4);
        }
        return false;
    }

    public static void setAabPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t.a(str);
    }

    public static void setAdRevenue(JSONObject jSONObject) {
        if (jSONObject != null && o.d().P() && isInitSuccess()) {
            com.bytedance.sdk.openadsdk.l.b.a().a(jSONObject);
        }
    }

    private static void c(InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getData())) {
            h.a().h(initConfig.getData());
        }
        h.a().b(b(initConfig));
    }

    public static String getBiddingToken(String str) {
        return (o.a() == null || v.a() == null) ? "" : v.a().b(str);
    }

    private static void a(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        l.a(2);
        if (pAGInitCallback != null) {
            if (initConfig instanceof PAGConfig) {
                b(4000, "resources not found, if you use aab please call PAGConfig.setPackageName");
            } else {
                b(4000, "resources not found, if you use aab please call TTAdConfig.setPackageName");
            }
        }
    }

    public static String getBiddingToken(Context context) {
        o.a(context);
        return getBiddingToken();
    }

    public static String getBiddingToken() {
        return (o.a() == null || v.a() == null) ? "" : v.a().d();
    }

    private static void a(final Context context, final boolean z, final InitConfig initConfig, final long j, final long j2) {
        com.bytedance.sdk.openadsdk.l.b.a();
        com.bytedance.sdk.openadsdk.l.b.a("pangle_sdk_init", false, new com.bytedance.sdk.openadsdk.l.a() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6
            @Override // com.bytedance.sdk.openadsdk.l.a
            public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean zO = h.a().o();
                    jSONObject.put("duration", j);
                    jSONObject.put("sdk_init_time", j2);
                    jSONObject.put("is_async", true);
                    jSONObject.put("is_multi_process", initConfig.isSupportMultiProcess());
                    jSONObject.put("is_debug", PAGSdk.b(initConfig));
                    jSONObject.put("is_use_texture_view", initConfig.isUseTextureView());
                    jSONObject.put("is_activate_init", zO);
                    jSONObject.put("minSdkVersion", a0.e(context));
                    jSONObject.put("targetSdkVersion", a0.h(context));
                    jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                    jSONObject.put("is_success", z);
                    h.a().a(false);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.m.b("TTAD.PAGSdk", "run: ", e);
                }
                return com.bytedance.sdk.openadsdk.l.c.b.o().h("pangle_sdk_init").c(jSONObject.toString());
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0012  */
    private static void b(Context context, InitConfig initConfig) {
        int i = 1;
        l.a = true;
        int gdpr = initConfig.getGdpr();
        boolean z = initConfig instanceof PAGConfig;
        if (!z) {
            i = gdpr;
        } else if (gdpr == 1) {
            i = 0;
        } else if (gdpr != 0) {
            i = gdpr;
        }
        v.a().c(initConfig.getAppId()).a(initConfig.getCoppa()).c(i).f(initConfig.getCcpa()).d(initConfig.getAppIconId()).e(initConfig.getTitleBarTheme()).a(initConfig.isUseTextureView());
        h.w();
        if (z) {
            v.a().b(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        try {
            if (b(initConfig)) {
                com.bytedance.sdk.component.utils.m.d();
                v.a().a();
                com.bytedance.sdk.openadsdk.utils.j.a();
                b.a.a.a.a.a.a.i.c.c();
            }
        } catch (Throwable unused) {
        }
        h.a().s();
        i.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(InitConfig initConfig) {
        return ((PAGConfig) initConfig).getDebugLog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        l.a(1);
        try {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                try {
                    Iterator<PAGInitCallback> it = list.iterator();
                    while (it.hasNext()) {
                        PAGInitCallback next = it.next();
                        if (next != null) {
                            it.remove();
                            next.success();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.m.b(th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, String str) {
        l.a(2);
        try {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                try {
                    Iterator<PAGInitCallback> it = list.iterator();
                    while (it.hasNext()) {
                        PAGInitCallback next = it.next();
                        if (next != null) {
                            it.remove();
                            next.fail(i, str);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.m.b(th2.getMessage());
        }
    }
}
