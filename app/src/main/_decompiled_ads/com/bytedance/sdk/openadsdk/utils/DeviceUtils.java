package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUtils {
    private static volatile boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f820b = false;
    private static volatile boolean c = true;
    public static String d = "";
    private static long e;
    private static int f;
    private static int g;
    private static int h;
    private static int i;
    private static int j;
    private static int k;

    public static class AudioInfoReceiver extends BroadcastReceiver {
        static final CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.k.g> a = new CopyOnWriteArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (DeviceUtils.a || context == null) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                context.registerReceiver(new AudioInfoReceiver(), intentFilter);
                boolean unused = DeviceUtils.a = true;
            } catch (Throwable unused2) {
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                        int unused = DeviceUtils.j = intent.getIntExtra("state", 0);
                    }
                } else if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    int unused2 = DeviceUtils.h = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                    Iterator<com.bytedance.sdk.openadsdk.k.g> it = a.iterator();
                    while (it.hasNext()) {
                        it.next().a(DeviceUtils.h);
                    }
                    if (DeviceUtils.g != 0) {
                        int unused3 = DeviceUtils.i = (int) ((((double) DeviceUtils.h) / ((double) DeviceUtils.g)) * 100.0d);
                    }
                }
            } catch (Exception unused4) {
            }
        }

        public static void a(com.bytedance.sdk.openadsdk.k.g gVar) {
            if (gVar != null) {
                CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.k.g> copyOnWriteArrayList = a;
                if (copyOnWriteArrayList.contains(gVar)) {
                    return;
                }
                copyOnWriteArrayList.add(gVar);
            }
        }

        public static void b(com.bytedance.sdk.openadsdk.k.g gVar) {
            if (gVar == null) {
                return;
            }
            a.remove(gVar);
        }
    }

    static class a extends b.b.a.a.k.g {
        final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Context context) {
            super(str);
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = DeviceUtils.k = DeviceUtils.f(this.c);
        }
    }

    static class b extends ContentObserver {
        final /* synthetic */ Context a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Handler handler, Context context) {
            super(handler);
            this.a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            DeviceUtils.t(this.a);
        }
    }

    private static class c extends BroadcastReceiver {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            int i = Build.VERSION.SDK_INT;
            if (i < 21 || context == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            intentFilter.addAction("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
            if (i >= 33) {
                context.registerReceiver(new c(), intentFilter, 2);
            } else {
                context.registerReceiver(new c(), intentFilter);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                DeviceUtils.t(context);
            } else if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(intent.getAction())) {
                int unused = DeviceUtils.k = intent.getIntExtra("state", 0) == 1 ? 1 : 0;
            }
        }
    }

    public static class d implements Runnable {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.sdk.openadsdk.core.c] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r3;
            boolean zIsLimitAdTrackingEnabled;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.sdk.openadsdk.core.o.a());
                if (advertisingIdInfo != null) {
                    zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                    if (com.bytedance.sdk.openadsdk.core.o.d().A("gaid")) {
                        String id = advertisingIdInfo.getId();
                        if (!TextUtils.isEmpty(id)) {
                            r3 = zIsLimitAdTrackingEnabled;
                            r3 = zIsLimitAdTrackingEnabled;
                            b.c.a.a.a.b.a.b().a(id);
                            b.c.a.a.a.b.a.b(id);
                            r3 = zIsLimitAdTrackingEnabled;
                        }
                    }
                } else {
                    r3 = -1;
                }
                if (r3 != -1) {
                    com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.o.a()).b("limit_ad_track", r3);
                }
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.m.b("TTAD.DeviceUtils", "getLmtTask error : signaling connection to Google Play Services failed.", e);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.DeviceUtils", th.getMessage());
            }
        }
    }

    public static int e() {
        return i;
    }

    public static int f() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        return accessibilityManager.isEnabled() ? 1 : 0;
    }

    public static int g() {
        return com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.o.a()).a("limit_ad_track", -1);
    }

    public static int h(Context context) {
        if (m(context)) {
            return 3;
        }
        return l(context) ? 2 : 1;
    }

    public static int i() {
        return g;
    }

    public static float j() {
        int i2 = -1;
        try {
            Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
            if (contextA != null) {
                i2 = Settings.System.getInt(contextA.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.DeviceUtils", th.getMessage());
        }
        if (i2 < 0) {
            return -1.0f;
        }
        return Math.round((i2 / 255.0f) * 10.0f) / 10.0f;
    }

    @JProtect
    public static boolean k() {
        if (SystemClock.elapsedRealtime() - e >= 20000) {
            e = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("power");
                if (powerManager != null) {
                    if (Build.VERSION.SDK_INT >= 20) {
                        c = powerManager.isInteractive();
                    } else {
                        c = powerManager.isScreenOn();
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.DeviceUtils", th.getMessage());
            }
        }
        return c;
    }

    public static boolean l(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean m(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int n(Context context) {
        return j;
    }

    private static int o(Context context) {
        return k;
    }

    public static void p(Context context) {
        AudioInfoReceiver.b(context);
    }

    public static void q(Context context) {
        Context applicationContext;
        if (f820b || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                a(applicationContext);
            } else {
                c.b(applicationContext);
            }
            f820b = true;
        } catch (Throwable unused) {
        }
    }

    public static int r(Context context) {
        return f;
    }

    private static float s(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(Context context) {
        if (context == null) {
            return;
        }
        y.c(new a("DeviceUtils_get_low_power_mode", context.getApplicationContext()));
    }

    public static int u(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Build.VERSION.SDK_INT >= 17 ? Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1) : Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTAD.DeviceUtils", th.getMessage());
            return -1;
        }
    }

    public static JSONObject d(Context context) {
        return a(context, false);
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(d)) {
            d = com.bytedance.sdk.openadsdk.core.c.a(context).a("framework_name", "");
        }
        return d;
    }

    private static int g(Context context) {
        try {
            String str = Build.MANUFACTURER;
            if (str.equalsIgnoreCase("XIAOMI")) {
                if (Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN") == 1) {
                    return 1;
                }
            } else if (str.equalsIgnoreCase("HUAWEI") && Settings.System.getInt(context.getContentResolver(), "SmartModeStatus") == 4) {
                return 1;
            }
            return 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static void i(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            g = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            h = streamVolume;
            i = (int) ((((double) streamVolume) / ((double) g)) * 100.0d);
        } catch (Throwable unused) {
        }
    }

    public static void l() {
        try {
            int ringerMode = ((AudioManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("audio")).getRingerMode();
            if (ringerMode == 2) {
                f = 1;
            } else if (ringerMode == 1) {
                f = 2;
            } else {
                f = 0;
            }
        } catch (Throwable unused) {
        }
    }

    @JProtect
    public static void m() {
        new d().run();
        Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
        if (contextA != null) {
            com.bytedance.sdk.openadsdk.core.c.a(contextA).b("cpu_count", e.a());
            com.bytedance.sdk.openadsdk.core.c.a(contextA).b("cpu_max_frequency", e.a(e.a()));
            com.bytedance.sdk.openadsdk.core.c.a(contextA).b("cpu_min_frequency", e.b(e.a()));
            String strP = a0.p();
            if (strP != null) {
                com.bytedance.sdk.openadsdk.core.c.a(contextA).b("total_memory", strP);
            }
            com.bytedance.sdk.openadsdk.core.c.a(contextA).b("total_internal_storage", a0.o());
            com.bytedance.sdk.openadsdk.core.c.a(contextA).b("free_internal_storage", com.bytedance.sdk.component.utils.n.a());
            com.bytedance.sdk.openadsdk.core.c.a(contextA).b("total_sdcard_storage", a0.k());
            com.bytedance.sdk.openadsdk.core.c.a(contextA).b("is_root", a0.w() ? 1 : 0);
            if (TextUtils.isEmpty(e(contextA))) {
                try {
                    Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
                    d = TapjoyConstants.TJC_PLUGIN_UNITY;
                } catch (ClassNotFoundException unused) {
                    d = "native";
                }
                com.bytedance.sdk.openadsdk.core.c.a(contextA).b("framework_name", d);
            }
            l();
            i(contextA);
            k = f(contextA);
        }
    }

    public static int d() {
        return h;
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        if (com.bytedance.sdk.openadsdk.core.o.d().A("gaid")) {
            jSONObject.put("gaid", b.c.a.a.a.b.a.b().a());
        }
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        a(jSONObject);
    }

    public static String h() {
        if (Build.VERSION.SDK_INT >= 21) {
            String languageTag = Locale.getDefault().toLanguageTag();
            return !TextUtils.isEmpty(languageTag) ? languageTag : "";
        }
        return Locale.getDefault().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            String str = Build.MANUFACTURER;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("HUAWEI")) {
                return (Build.VERSION.SDK_INT < 21 || !((PowerManager) context.getSystemService("power")).isPowerSaveMode()) ? 0 : 1;
            }
            return g(context);
        } catch (Throwable unused) {
            return 0;
        }
    }

    @JProtect
    public static JSONObject a(Context context, boolean z) {
        String strK;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_adb_status", u(context));
            b(jSONObject);
            jSONObject.put("type", h(context));
            jSONObject.put("os", 1);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", a0.f(context));
            jSONObject.put(TapjoyConstants.TJC_APP_SET_ID, AppSetIdAndScope.a());
            jSONObject.put("app_set_id_scope", AppSetIdAndScope.b());
            jSONObject.put("installed_source", AppSetIdAndScope.d());
            jSONObject.put("screen_width", b0.i(context));
            jSONObject.put("screen_height", b0.g(context));
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.g0.c.a());
            com.bytedance.sdk.openadsdk.core.settings.d dVarD = com.bytedance.sdk.openadsdk.core.o.d();
            if (dVarD.A("boot")) {
                jSONObject.put("boot", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + "");
                jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            }
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.j.d(context));
            jSONObject.put("rom_version", r.m());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.j.a(context));
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, a0.h());
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.j.b());
            jSONObject.put(TapjoyConstants.TJC_CARRIER_NAME, s.b());
            if (z) {
                strK = a0.j(context);
            } else {
                strK = a0.k(context);
            }
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(strK) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
            jSONObject.put("locale_language", h());
            jSONObject.put("screen_bright", Math.ceil(j() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !k() ? 1 : 0);
            jSONObject.put("cpu_num", e.a(context));
            jSONObject.put("cpu_max_freq", e.b(context));
            jSONObject.put("cpu_min_freq", e.c(context));
            com.bytedance.sdk.openadsdk.utils.d.a aVarA = com.bytedance.sdk.openadsdk.utils.d.a();
            jSONObject.put("battery_remaining_pct", (int) aVarA.f829b);
            jSONObject.put("is_charging", aVarA.a);
            jSONObject.put("total_space", String.valueOf(a0.i(context)));
            jSONObject.put("free_space_in", String.valueOf(a0.c(context)));
            jSONObject.put("sdcard_size", String.valueOf(a0.g(context)));
            jSONObject.put("rooted", a0.n(context));
            jSONObject.put("enable_assisted_clicking", f());
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.t.k(context, "tt_choose_language"));
            jSONObject.put("airplane", j(context));
            jSONObject.put("darkmode", k(context));
            jSONObject.put("headset", n(context));
            jSONObject.put("ringmute", r(context));
            jSONObject.put("screenscale", s(context));
            jSONObject.put(TapjoyConstants.TJC_VOLUME, e());
            jSONObject.put("low_power_mode", o(context));
            if (dVarD.A("mnc")) {
                jSONObject.put("mnc", s.d());
            }
            if (dVarD.A("mcc")) {
                jSONObject.put("mcc", s.c());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static int j(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
            }
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int k(Context context) {
        try {
            int i2 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
            if (i2 == 32) {
                return 1;
            }
            return i2 == 16 ? 0 : -1;
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        context.getContentResolver().registerContentObserver(Uri.parse("content://settings/system/POWER_SAVE_MODE_OPEN"), false, new b(null, applicationContext));
    }
}
