package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTSdkSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements com.bytedance.sdk.openadsdk.core.settings.d, l.b {
    private static final String n = a0.f();
    private static final b.b.a.a.k.g o = new a("TemplateReInitTask");
    public static String p = null;
    public static String q = "IABTCF_TCString";
    private static final com.bytedance.sdk.openadsdk.core.settings.i r = new com.bytedance.sdk.openadsdk.core.settings.i();
    static final ConcurrentHashMap<String, Integer> s = new ConcurrentHashMap<>();
    private Set<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.settings.h f677b;
    private final k c;
    private final AtomicBoolean d;
    private volatile boolean e;
    private int f;
    private int g;
    private com.bytedance.sdk.openadsdk.core.settings.g h;
    private final BroadcastReceiver i;
    private final Runnable j;
    final com.bytedance.sdk.openadsdk.core.settings.c.d<ConcurrentHashMap<String, Integer>> k;
    private final Set<String> l;
    private final com.bytedance.sdk.openadsdk.core.settings.c.d<Set<String>> m;

    /* JADX INFO: compiled from: TTSdkSettings.java */
    static class a extends b.b.a.a.k.g {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.d.e.b.c.d().b();
            b.b.a.a.d.e.b.c.d().b(false);
            b.b.a.a.d.e.b.a.a();
            b.b.a.a.d.e.b.c.d().j();
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!l.a()) {
                com.bytedance.sdk.openadsdk.multipro.aidl.a.c().d();
            } else {
                n.this.d(1);
                n.this.n0();
            }
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class c implements Runnable {
        c(n nVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.b(n.o);
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class d implements com.bytedance.sdk.openadsdk.core.settings.c.d<com.bytedance.sdk.openadsdk.core.settings.g> {
        d(n nVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.bytedance.sdk.openadsdk.core.settings.g a(String str) {
            return new com.bytedance.sdk.openadsdk.core.settings.g(str);
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class e implements com.bytedance.sdk.openadsdk.core.settings.c.d<com.bytedance.sdk.openadsdk.core.settings.e> {
        e(n nVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.bytedance.sdk.openadsdk.core.settings.e a(String str) {
            return new com.bytedance.sdk.openadsdk.core.settings.e(str);
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class f extends BroadcastReceiver {
        private final Runnable a = new a();

        /* JADX INFO: compiled from: TTSdkSettings.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.settings.n$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: TTSdkSettings.java */
            class C0214a extends b.b.a.a.k.g {
                C0214a(String str) {
                    super(str);
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.this.u();
                    } catch (Exception unused) {
                    }
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y.c(new C0214a("LoadLocalData"));
            }
        }

        /* JADX INFO: compiled from: TTSdkSettings.java */
        class b extends b.b.a.a.k.g {
            final /* synthetic */ Intent c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str, Intent intent) {
                super(str);
                this.c = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                String action = this.c.getAction();
                com.bytedance.sdk.component.utils.m.a("TTAD.SdkSettings", "onReceive: action=" + action);
                if ("_tryFetRemoDat".equals(action)) {
                    n.this.a(this.c.getIntExtra("_source", 0), this.c.getBooleanExtra("_force", false));
                } else if ("_dataChanged".equals(action)) {
                    com.bytedance.sdk.component.utils.i.a().removeCallbacks(f.this.a);
                    com.bytedance.sdk.component.utils.i.a().postDelayed(f.this.a, 10000L);
                }
            }
        }

        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            y.c(new b("setting_receiver", intent));
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.utils.m.a("TTAD.SdkSettings", "auto fetch task active, try fetch remote data");
            n.this.d(2);
            n.this.n0();
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class h implements com.bytedance.sdk.openadsdk.core.settings.c.d<ConcurrentHashMap<String, Integer>> {
        h(n nVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ConcurrentHashMap<String, Integer> a(String str) {
            if (TextUtils.isEmpty(str)) {
                return n.s;
            }
            ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    int iOptInt = jSONObject.optInt(next, 100);
                    if (!TextUtils.isEmpty(next) && iOptInt >= 0 && iOptInt <= 100) {
                        concurrentHashMap.put(next, Integer.valueOf(iOptInt));
                    }
                }
            } catch (JSONException e) {
                Log.i("TTAD.SdkSettings", e.getMessage());
            }
            return concurrentHashMap;
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    class i implements com.bytedance.sdk.openadsdk.core.settings.c.d<Set<String>> {
        i() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Set<String> a(String str) {
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int iOptInt = jSONObject.optInt("applog_count");
                    if (iOptInt >= 2 && iOptInt <= 100) {
                        n.this.g = iOptInt;
                    }
                    int iOptInt2 = jSONObject.optInt("applog_interval");
                    if (iOptInt2 >= 100 && iOptInt2 <= 30000) {
                        n.this.f = iOptInt2;
                    }
                    JSONArray jSONArray = jSONObject.getJSONArray("core_label_arr");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string)) {
                                hashSet.add(string);
                            }
                        }
                    }
                } catch (JSONException e) {
                    Log.i("TTAD.SdkSettings", e.getMessage());
                }
            }
            return hashSet.size() == 0 ? new HashSet(Arrays.asList("click", TJAdUnitConstants.String.BEACON_SHOW_PATH, "insight_log", "mrc_show")) : hashSet;
        }
    }

    /* JADX INFO: compiled from: TTSdkSettings.java */
    private static final class j {
        static final n a = new n(null);
    }

    /* synthetic */ n(a aVar) {
        this();
    }

    private static int b(boolean z) {
        return z ? 20 : 5;
    }

    public static int c(Context context) {
        SharedPreferences sharedPreferencesB;
        if (context == null || (sharedPreferencesB = b(context)) == null) {
            return -2;
        }
        if ((sharedPreferencesB.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE) == Integer.MIN_VALUE && sharedPreferencesB.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE) == Integer.MIN_VALUE) ? false : true) {
            return sharedPreferencesB.getInt("IABTCF_gdprApplies", -1);
        }
        return -2;
    }

    public static String d(Context context) {
        SharedPreferences sharedPreferencesB;
        return (context == null || (sharedPreferencesB = b(context)) == null) ? "" : sharedPreferencesB.getString(q, "");
    }

    private Set<String> g0() {
        return (Set) this.c.a("perf_con_applog_send", this.l, this.m);
    }

    private int h0() {
        return this.c.a("coppa", -99);
    }

    private String i0() {
        return this.c.a("force_language", "");
    }

    public static com.bytedance.sdk.openadsdk.core.settings.d j0() {
        if (o.a() != null) {
            return j.a;
        }
        IllegalStateException illegalStateException = new IllegalStateException("context is null");
        Log.e(ADXLogUtil.PLATFORM_PANGLE, "context is null", illegalStateException);
        ApmHelper.reportCustomError("context is null", "context is null", illegalStateException);
        return r;
    }

    private long k0() {
        return this.c.a("last_req_time", 0L);
    }

    private long l0() {
        long jA = this.c.a("req_inter_min", 600000L);
        if (jA < 0 || jA > 86400000) {
            return 600000L;
        }
        return jA;
    }

    public static void m0() {
        o0();
    }

    private static void o0() {
        Context contextA = o.a();
        if (contextA != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextA.getPackageName());
                intent.setAction("_dataChanged");
                contextA.sendBroadcast(intent);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.SdkSettings", "", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean A() {
        return this.c.a("perf_con_apm_native", Integer.MAX_VALUE) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void B() {
        try {
            com.bytedance.sdk.openadsdk.core.settings.b.a();
            this.c.b();
            this.f677b.b();
            Context contextA = o.a();
            int i2 = Build.VERSION.SDK_INT;
            File file = new File(i2 >= 24 ? new File(contextA.getDataDir(), "shared_prefs") : new File(contextA.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs"), "tt_sdk_settings.xml");
            if (file.exists() && file.isFile()) {
                String strReplace = file.getName().replace(".xml", "");
                if (i2 >= 24) {
                    contextA.deleteSharedPreferences(strReplace);
                } else {
                    contextA.getSharedPreferences(strReplace, 0).edit().clear().apply();
                    com.bytedance.sdk.component.utils.g.a(file);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int C() {
        return this.c.a("loadedCallbackOpportunity", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void D() {
        if (Build.VERSION.SDK_INT >= 17) {
            String strI0 = i0();
            if (TextUtils.isEmpty(strI0)) {
                return;
            }
            if (strI0.equals("zh-Hant")) {
                com.bytedance.sdk.component.utils.j.b(o.a(), "zh", "tw");
            } else {
                com.bytedance.sdk.component.utils.j.b(o.a(), strI0, null);
            }
            try {
                TTAdDislikeToast.p();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("TTAD.SdkSettings", th.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean E() {
        return this.c.a("support_mem_dynamic", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void F() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean G() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean H() {
        return !(this.c.a("support_tnc", 1) == 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int I() {
        return this.c.a("vbtt", 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int J() {
        int iA = this.c.a("privacy_personalized_ad", Integer.MAX_VALUE);
        if (iA != Integer.MAX_VALUE) {
            return iA;
        }
        int iL = a0.l();
        if (iL == 1 || iL == 2) {
            return 2;
        }
        return iL != 3 ? 0 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String[] K() {
        try {
            Set<String> set = this.a;
            if (set == null || set.size() == 0) {
                JSONArray jSONArray = new JSONArray(this.c.a("gecko_hosts", (String) null));
                if (jSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        this.a.add(jSONArray.getString(i2));
                    }
                }
                Set<String> setA = k.a(this.a);
                this.a = setA;
                if (setA != null) {
                    if (setA.size() == 0) {
                    }
                }
                return null;
            }
            return (String[]) this.a.toArray(new String[0]);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String L() {
        return this.c.a("playableLoadH5Url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int M() {
        return this.c.a("max", 50);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int N() {
        return this.c.a("isGdprUser", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean O() {
        boolean z = this.c.a("bus_con_sec_type", Integer.MAX_VALUE) != 0;
        com.bytedance.sdk.component.utils.m.c("TTAD.SdkSettings", "secSdk type: ", Boolean.valueOf(z));
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean P() {
        return this.c.a("ad_revenue_enable", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String Q() {
        return this.c.a("ab_test_param", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean R() {
        if (b.b.a.a.d.g.b.a(o.a())) {
            return this.c.a("support_rtl", false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public JSONObject S() {
        return (JSONObject) this.c.a("video_cache_config", null, com.bytedance.sdk.openadsdk.core.settings.c.a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int T() {
        g0();
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean U() {
        return this.c.a("global_rate", 1.0f) == 1.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int V() {
        int iA = this.c.a("fetch_tpl_second", 0);
        if (iA <= 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String W() {
        return this.c.a("policy_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int X() {
        return this.c.a("bus_con_send_log_type", 1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean Y() {
        return this.c.a("landingpage_new_style", -1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public long Z() {
        return this.c.a("data_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int a0() {
        return this.c.a("ivrv_downward", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean b0() {
        return this.c.a("read_video_from_cache", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String c0() {
        return this.c.a("ads_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String d0() {
        return this.c.a("dyn_draw_engine_url", n);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int e() {
        int iA = this.c.a("fetch_tpl_timeout_ctrl", 3000);
        if (iA <= 0) {
            return 3000;
        }
        return iA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean e0() {
        return this.c.a("if_both_open", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean f() {
        return this.c.a("allow_blind_mode_request_ad", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public JSONObject g() {
        return (JSONObject) this.c.a("digest", null, com.bytedance.sdk.openadsdk.core.settings.c.a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean h() {
        return this.c.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean i(String str) {
        return j(str) != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int j(String str) {
        return l(String.valueOf(str)).h;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String k() {
        return this.c.a("pyload_h5", (String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int l() {
        g0();
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int m() {
        return this.c.a("load_callback_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean n(String str) {
        int i2 = l(str).e;
        if (i2 != 1) {
            return i2 == 2 && p.b(o.a()) != 0;
        }
        return p.g(o.a());
    }

    void n0() {
        if (l.a()) {
            com.bytedance.sdk.openadsdk.core.l.a().removeCallbacks(this.j);
            com.bytedance.sdk.openadsdk.core.l.a().postDelayed(this.j, l0());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int o(String str) {
        Integer num;
        Map map = (Map) this.c.a("perf_con_stats_rate", s, this.k);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int p(String str) {
        return l(str).D;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public com.bytedance.sdk.openadsdk.core.settings.g q() {
        com.bytedance.sdk.openadsdk.core.settings.g gVar = this.h;
        if (gVar != null) {
            return gVar;
        }
        com.bytedance.sdk.openadsdk.core.settings.g gVar2 = (com.bytedance.sdk.openadsdk.core.settings.g) this.f677b.a("mediation_init_conf", com.bytedance.sdk.openadsdk.core.settings.g.f674b, new d(this));
        this.h = gVar2;
        return gVar2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String r() {
        return this.c.a("aes_key", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void s() {
        this.c.c().remove("tt_sdk_settings").remove("ab_test_param").commit();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String t() {
        return this.c.a("app_log_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public synchronized void u() {
        com.bytedance.sdk.component.utils.m.a("TTAD.SdkSettings", "loadLocalData: ");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = !this.e;
        this.f677b.a(this.e);
        this.c.a(this.e);
        com.bytedance.sdk.openadsdk.core.settings.b.a(z);
        com.bytedance.sdk.openadsdk.core.h.a().c(h0());
        this.e = true;
        com.bytedance.sdk.component.utils.m.a("TTAD.SdkSettings", "loadLocalData: finished, used", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), "ms");
        if (z) {
            com.bytedance.sdk.openadsdk.core.l.a().postDelayed(new b(), 1000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int v(String str) {
        if (str == null) {
            return 0;
        }
        return o.d().l(str).r;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public Set<String> w() {
        return g0();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public com.bytedance.sdk.openadsdk.core.settings.e x() {
        return (com.bytedance.sdk.openadsdk.core.settings.e) this.c.a("insert_js_config", com.bytedance.sdk.openadsdk.core.settings.e.c, new e(this));
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int y(String str) {
        return l(str).z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean z(String str) {
        return str == null || DeviceUtils.r(o.a()) == 0 || l(str).l == 1;
    }

    private n() {
        this.a = Collections.synchronizedSet(new HashSet());
        this.f677b = new com.bytedance.sdk.openadsdk.core.settings.h();
        this.c = new k();
        this.d = new AtomicBoolean(false);
        this.e = false;
        this.f = 5000;
        this.g = 10;
        f fVar = new f();
        this.i = fVar;
        this.j = new g();
        this.k = new h(this);
        this.l = new HashSet();
        this.m = new i();
        try {
            Context contextA = o.a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                contextA.registerReceiver(fVar, intentFilter, 4);
            } else {
                contextA.registerReceiver(fVar, intentFilter);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.SdkSettings", "", e2);
        }
    }

    private static void b(int i2, boolean z) {
        Context contextA = o.a();
        if (contextA != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextA.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z);
                intent.putExtra("_source", i2);
                contextA.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean A(String str) {
        Set set = (Set) this.c.a("privacy_fields_allowed", Collections.emptySet(), com.bytedance.sdk.openadsdk.core.settings.c.f672b);
        if (!set.isEmpty()) {
            return set.contains(str);
        }
        int iL = a0.l();
        if (iL == 1) {
            return true;
        }
        if (iL == 2 || iL == 3) {
            return "mcc".equals(str) || "mnc".equals(str);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c interfaceC0213c) {
        if (jSONObject == null || !jSONObject.has("dyn_draw_engine_url")) {
            return;
        }
        k kVar = this.c;
        String str = n;
        String strA = kVar.a("dyn_draw_engine_url", str);
        String strOptString = jSONObject.optString("dyn_draw_engine_url", str);
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strOptString) && !strOptString.equals(strA)) {
            com.bytedance.sdk.openadsdk.core.l.a().postDelayed(new c(this), 5000L);
        }
        interfaceC0213c.putString("dyn_draw_engine_url", strOptString);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean e(String str) {
        return str == null || l(str).m == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean f(String str) {
        return l(str).c == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean g(String str) {
        return l(str).C;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int h(String str) {
        return l(str).j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int i() {
        return this.c.a("blank_detect_rate", 30);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean k(String str) {
        return l(str).t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean m(String str) {
        return l(str).A;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int r(String str) {
        return l(str).s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int s(String str) {
        return l(str).y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean t(String str) {
        return o.d().l(str).n == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int w(String str) {
        return l(str).q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean x(String str) {
        return l(str).u == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String j() {
        return this.c.a("dc", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public com.bytedance.sdk.openadsdk.core.settings.a l(String str) {
        return com.bytedance.sdk.openadsdk.core.settings.b.a(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean p() {
        return this.c.a("privacy_sladar_enable", Integer.MAX_VALUE) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean v() {
        return this.c.a("support_gzip", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean y() {
        int iA = this.c.a("privacy_ad_enable", Integer.MAX_VALUE);
        if (iA == 1) {
            return true;
        }
        if (iA == 0) {
            return false;
        }
        int iL = a0.l();
        return iL == 1 || iL == 2 || iL == 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String d() {
        return this.c.a("ab_test_version", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean d(String str) {
        try {
            return l(str).v != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean q(String str) {
        return l(str).B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int o() {
        return this.c.a("disable_rotate_banner_on_dislike", Integer.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public String z() {
        return this.c.a("apm_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void d(int i2) {
        a(i2, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int c() {
        return this.c.a("max_tpl_cnts", 100);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean c(String str) {
        return l(str).g == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public boolean n() {
        return this.c.a("privacy_debug_unlock", 1) != 0;
    }

    private static SharedPreferences b(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int c(int i2) {
        return l(String.valueOf(i2)).i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void b(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c interfaceC0213c) {
        if (jSONObject.has("is_gdpr_user")) {
            int iOptInt = jSONObject.optInt("is_gdpr_user", -1);
            interfaceC0213c.putInt("isGdprUser", (iOptInt == -1 || iOptInt == 1 || iOptInt == 0) ? iOptInt : -1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public long a() {
        return this.c.a("duration", 10000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int a(String str) {
        return l(str).k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int a(String str, boolean z) {
        if (str == null) {
            return b(z);
        }
        int i2 = l(str).w;
        return i2 != -1 ? i2 : b(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int b(String str) {
        if (str == null) {
            return 1500;
        }
        return l(str).o;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int u(String str) {
        return l(str).x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int b(int i2) {
        return l(String.valueOf(i2)).f671b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int a(int i2) {
        return l(String.valueOf(i2)).E;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public int b() {
        int iA = this.c.a("webview_cache_count", 20);
        if (iA < 0) {
            return 20;
        }
        return iA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void a(long j2) {
        this.c.c().putLong("last_req_time", j2).commit();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void a(int i2, boolean z) {
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.a().d())) {
                return;
            }
            long jK0 = k0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jL0 = l0();
            long j2 = jCurrentTimeMillis - jK0;
            if (!z && j2 < jL0) {
                com.bytedance.sdk.openadsdk.core.h0.a.a();
                return;
            }
            if (!l.a()) {
                b(i2, z);
            } else if (this.d.compareAndSet(false, true)) {
                y.c(new l(this, this.c, this.f677b));
                com.bytedance.sdk.openadsdk.core.l.a().removeCallbacks(this.j);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.a("TTAD.SdkSettings", "load sdk settings error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.l.b
    public void a(boolean z) {
        this.d.set(false);
        n0();
        if (z) {
            o0();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.d
    public void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.i, intentFilter, 4);
            } else {
                context.registerReceiver(this.i, intentFilter);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("TTAD.SdkSettings", "", e2);
        }
        if (G()) {
            d(1);
            n0();
        }
    }
}
