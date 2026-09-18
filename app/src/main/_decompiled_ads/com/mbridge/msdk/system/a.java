package com.mbridge.msdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: MBridgeSDKImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements MBridgeSDK {
    public static Map<String, String> a;
    private Context c;
    private SDKInitStatusListener d;
    private volatile AtomicBoolean g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile MBridgeSDK.PLUGIN_LOAD_STATUS f2463b = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;
    private boolean e = false;
    private boolean f = false;
    private final Application.ActivityLifecycleCallbacks h = new Application.ActivityLifecycleCallbacks() { // from class: com.mbridge.msdk.system.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            q.a().c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            int iE = b.d().e();
            if (iE == 0) {
                com.mbridge.msdk.foundation.same.report.q.a("1");
            }
            b.d().b(iE + 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            b.d().a((Context) activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            int iE = b.d().e();
            if (iE == 1 || iE == 0) {
                com.mbridge.msdk.foundation.same.report.q.a("2");
            }
            b.d().b(iE - 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            q.a().d();
            b.d().a(activity);
        }
    };

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setThirdPartyFeatures(Map<String, Object> map) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    private void a() {
        boolean z;
        if (this.g == null) {
            this.g = new AtomicBoolean(false);
        }
        this.e = false;
        try {
            if (this.g.get()) {
                SDKInitStatusListener sDKInitStatusListener = this.d;
                if (sDKInitStatusListener == null || this.e) {
                    return;
                }
                try {
                    this.e = true;
                    sDKInitStatusListener.onInitSuccess();
                    return;
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d(MBConfiguration.LOG_TAG, e.getMessage());
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.d(MBConfiguration.LOG_TAG, e2.getMessage());
            }
        }
        this.g.set(true);
        try {
            c.a().a(a, this.c);
            this.f2463b = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
            d.a().c();
            m.a().c();
            HandlerThread handlerThread = new HandlerThread("mb_db_thread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
            builder.setDatabaseHandler(handler);
            builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() { // from class: com.mbridge.msdk.system.a.2
                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
                public final SQLiteDatabase getReadableDatabase() {
                    return h.a(b.d().g()).a();
                }

                @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
                public final SQLiteDatabase getWritableDatabase() {
                    return h.a(b.d().g()).b();
                }
            });
            builder.setLogger(new ILogger() { // from class: com.mbridge.msdk.system.a.3
                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public final void log(String str, String str2) {
                    aa.a(str, str2);
                }

                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public final void log(String str, Exception exc) {
                    aa.a(str, exc.getMessage());
                }
            });
            MBDownloadManager.getInstance().initialize(b.d().g(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100L).setMaxStorageTime(259200000L).build());
            k.a().b();
            l.a().b();
            SDKInitStatusListener sDKInitStatusListener2 = this.d;
            if (sDKInitStatusListener2 != null && !this.e) {
                this.e = true;
                sDKInitStatusListener2.onInitSuccess();
            }
            try {
                q.a().a(this.c.getApplicationContext());
            } catch (Exception e3) {
                aa.b(MBConfiguration.LOG_TAG, "INIT", e3);
            }
            Context context = this.c;
            if (context instanceof Application) {
                Application application = (Application) context;
                try {
                    z = ac.a().a("c_r_a_l_c", 0) == 0;
                } catch (Exception e4) {
                    aa.d(MBConfiguration.LOG_TAG, e4.getMessage());
                }
                if (application != null && z) {
                    application.registerActivityLifecycleCallbacks(this.h);
                    this.f = true;
                }
            }
            this.g.set(true);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                aa.b(MBConfiguration.LOG_TAG, "INIT FAIL", e5);
                e5.printStackTrace();
            }
            if (this.g != null) {
                this.g.set(false);
            }
            SDKInitStatusListener sDKInitStatusListener3 = this.d;
            if (sDKInitStatusListener3 != null && !this.e) {
                this.e = true;
                sDKInitStatusListener3.onInitFail(e5.getMessage());
            }
        }
        try {
            HashMap map = new HashMap();
            if (this.g != null) {
                String str = "1";
                map.put("status", this.g.get() ? "1" : "2");
                map.put("is_allow_crash", b.d().f().a() ? "1" : "2");
                if (!b.d().f().b()) {
                    str = "2";
                }
                map.put("is_allow_anr", str);
            }
            m.a().b("m_init_sdk", "InitSDK", "", "", map);
        } catch (Throwable th) {
            aa.d(MBConfiguration.LOG_TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.f2463b;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void preload(Map<String, Object> map) {
        if (this.f2463b == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            c.a().a(map, 0);
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setUserPrivateInfoType(Context context, String str, int i) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(str, i);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDoNotTrackStatus(boolean z) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setCoppaStatus(Context context, boolean z) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a();
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_COPPA, z ? 1 : 2);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDoNotTrackStatus(Context context, boolean z) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final AuthorityInfoBean userPrivateInfo(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setConsentStatus(Context context, int i) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(i);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final boolean getConsentStatus(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().d();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void preloadFrame(Map<String, Object> map) {
        c.a().a(map, 1);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final Map<String, String> getMBConfigurationMap(String str, String str2) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final Map<String, String> getMBConfigurationMap(String str, String str2, boolean z) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final Map<String, String> getMBConfigurationMap(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put(MBridgeConstans.ID_MBRIDGE_APPID, str);
        map.put(MBridgeConstans.ID_MBRIDGE_APPKEY, str2);
        map.put(MBridgeConstans.ID_MBRIDGE_WX_APPID, str3);
        map.put(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH, String.valueOf(1));
        return map;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final Map<String, String> getMBConfigurationMap(String str, String str2, String str3, boolean z) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void release() {
        if (this.f2463b == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            c.a().b();
        }
        Context context = this.c;
        if (context instanceof Application) {
            Application application = (Application) context;
            if (this.f) {
                application.unregisterActivityLifecycleCallbacks(this.h);
            }
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Application application) {
        this.c = application.getApplicationContext();
        a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Application application) {
        this.c = application.getApplicationContext();
        a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Context context) {
        this.c = context.getApplicationContext();
        a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Context context) {
        this.c = context.getApplicationContext();
        a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.c = application;
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.c = application;
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void init(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.c = context.getApplicationContext();
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void initAsync(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.c = context.getApplicationContext();
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    private void a(Context context) {
        if (b.d().g() != null || context == null) {
            return;
        }
        b.d().b(context);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        b.d().a(weakReference);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setAllowAcquireIds(boolean z) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a(z);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() || developerTransferIdInfo == null || TextUtils.isEmpty(developerTransferIdInfo.getGaid())) {
            return;
        }
        w.a(developerTransferIdInfo.getGaid());
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public final void setAllowTransferIdsIfLimit(boolean z) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.b(z);
    }
}
