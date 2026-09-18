package com.igaworks.adpopcorn.a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.igaworks.adpopcorn.cores.common.APUpdateLog;
import com.igaworks.adpopcorn.cores.common.h;
import com.igaworks.adpopcorn.cores.common.j;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.common.l;
import com.mbridge.msdk.MBridgeConstans;
import com.tapjoy.TapjoyConstants;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private JSONArray m;
    private JSONArray o;
    private float p;
    private long z;
    private Map<String, String> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1484b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = APUpdateLog.SDK_VERSION;
    private String k = "";
    private boolean l = false;
    private boolean n = true;
    private String q = "";
    private String r = "";
    private String s = "";
    private boolean t = true;
    private String u = "";
    private String v = "";
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;

    private class a extends Thread {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1485b = true;

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.a.c$a$a, reason: collision with other inner class name */
        class C0395a implements com.igaworks.adpopcorn.cores.common.a.c {
            C0395a() {
            }

            @Override // com.igaworks.adpopcorn.cores.common.a.c
            public void a(com.igaworks.adpopcorn.cores.common.a.d dVar) {
                a.this.f1485b = false;
                com.igaworks.adpopcorn.a.b bVarA = com.igaworks.adpopcorn.a.b.a();
                if (dVar != null) {
                    c.this.d = dVar.a();
                    c.this.t = dVar.b();
                    h.a(a.this.a, "ADIDThread", "AdInfo onResult, adid : " + dVar.a() + ", optOutEnabled : " + c.this.t, 3);
                    bVarA.b(a.this.a, "adpopcorn_parameter", "google_ad_id", c.this.d);
                    bVarA.b(a.this.a, "adpopcorn_parameter", "optout_enabled", c.this.t);
                    d.a(a.this.a).e(a.this.a);
                    if (c.this.g() == null || c.this.g().equals("")) {
                        d.a(a.this.a).h(c.this.d);
                    }
                } else {
                    try {
                        h.a(a.this.a, "ADIDThread", "AdInfo onResult, adInfo is null", 3);
                        a aVar = a.this;
                        c.this.d = bVarA.a(aVar.a, "adpopcorn_parameter", "google_ad_id", "");
                        a aVar2 = a.this;
                        c.this.t = bVarA.a(aVar2.a, "adpopcorn_parameter", "optout_enabled", false);
                        d.a(a.this.a).e(a.this.a);
                        if (c.this.g() == null || c.this.g().equals("")) {
                            d.a(a.this.a).h(c.this.d);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                a aVar3 = a.this;
                c.this.a(aVar3.a, c.this.d);
                c.this.c(true);
            }
        }

        class b extends TimerTask {
            b() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.f1485b) {
                    try {
                        h.a(a.this.a, "ADIDThread", "AdInfo timeout", 3);
                        com.igaworks.adpopcorn.a.b bVarA = com.igaworks.adpopcorn.a.b.a();
                        a aVar = a.this;
                        c.this.d = bVarA.a(aVar.a, "adpopcorn_parameter", "google_ad_id", "");
                        a aVar2 = a.this;
                        c.this.t = bVarA.a(aVar2.a, "adpopcorn_parameter", "optout_enabled", false);
                        d.a(a.this.a).e(a.this.a);
                        if (c.this.g() == null || c.this.g().equals("")) {
                            d.a(a.this.a).h(c.this.d);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    c.this.c(true);
                }
            }
        }

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                if (c.this.d != null && c.this.d.length() >= 1) {
                    c.this.c(true);
                } else if (l.a(this.a).a(this.a, new C0395a()) == null) {
                    new Timer().schedule(new b(), 3000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public c(Context context) {
        c(false);
        new a(context).start();
    }

    private JSONArray c(Context context) {
        try {
            this.m = new JSONArray();
            this.l = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.m;
    }

    private JSONArray f(Context context) {
        try {
            this.o = new JSONArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.o;
    }

    private float h() {
        this.p = 0.0f;
        try {
            this.p = Calendar.getInstance().getTimeZone().getRawOffset() / 3600000.0f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.p;
    }

    public String a() {
        return this.d;
    }

    public String a(Context context) {
        String strA = b.a().a(context, "adpopcorn_parameter", "adpopcorn_sdk_age", "");
        this.r = strA;
        return strA;
    }

    public String a(Context context, int i) {
        JSONObject jSONObjectD = d(context);
        if (i != -1) {
            try {
                jSONObjectD.put("page_idx", i);
            } catch (Exception unused) {
            }
        }
        return jSONObjectD.toString();
    }

    public String a(Context context, String str, String str2) {
        JSONObject jSONObjectD = d(context);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    jSONObjectD.put(str, str2);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObjectD.toString();
    }

    public String a(Context context, String str, JSONArray jSONArray) {
        JSONObject jSONObjectD = d(context);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    jSONObjectD.put(str, jSONArray);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObjectD.toString();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:6:0x000b, B:8:0x0011, B:10:0x001e, B:13:0x0031, B:12:0x002a, B:14:0x0039), top: B:18:0x000b }] */
    public void a(Context context, String str) {
        if (this.C) {
            return;
        }
        this.C = true;
        this.w = true;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    d.a(context).e(context);
                    if (g() == null || g().equals("")) {
                        d.a(context).h(str);
                    }
                    this.w = !j.a(context, str);
                } else {
                    this.w = true;
                }
            } catch (Exception unused) {
            }
        } else {
            this.w = true;
        }
        this.x = com.igaworks.adpopcorn.a.e.a.a(context);
        this.y = com.igaworks.adpopcorn.a.e.b.c(context);
        this.z = System.currentTimeMillis() / 1000;
        this.C = false;
    }

    public void a(String str) {
        this.f1484b = str;
    }

    public void a(String str, String str2) {
        if (str.equals("igaworks_app_key") || str.equals("adpopcorn_app_key")) {
            this.f1484b = str2;
            return;
        }
        if (str.equals("igaworks_hash_key") || str.equals("adpopcorn_hash_key")) {
            this.v = str2;
        } else if (str.equals("igaworks_test_country")) {
            this.k = str2;
        } else {
            this.a.put(str, str2);
        }
    }

    public void a(boolean z) {
        this.A = z;
    }

    public String b() {
        return this.f1484b;
    }

    public String b(Context context) {
        String strA = b.a().a(context, "adpopcorn_parameter", "adpopcorn_sdk_gender", "");
        this.s = strA;
        return strA;
    }

    public void b(String str) {
        this.v = str;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public String c() {
        return this.v;
    }

    public void c(String str) {
        if (str == null) {
            str = "unknown";
        }
        this.q = str;
    }

    public void c(boolean z) {
        this.B = z;
    }

    public JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f1484b;
            if (str == null || str.length() == 0) {
                return null;
            }
            jSONObject.put(MBridgeConstans.APP_KEY, this.f1484b);
            String str2 = this.c;
            if (str2 == null || str2.length() == 0) {
                jSONObject.put("usn", "");
            } else {
                jSONObject.put("usn", g());
            }
            String str3 = this.d;
            if (str3 == null || str3.length() <= 0) {
                try {
                    String string = context.getSharedPreferences("adpopcorn_parameter", 0).getString("google_ad_id", "");
                    if (string == null || string.length() <= 0) {
                        jSONObject.put("adid", "");
                    } else {
                        jSONObject.put("adid", string);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    jSONObject.put("adid", "");
                }
            } else {
                jSONObject.put("adid", this.d);
            }
            try {
                d(com.igaworks.adpopcorn.cores.common.c.b(context));
            } catch (Exception unused) {
            }
            jSONObject.put("network", this.e);
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.f = telephonyManager.getNetworkOperatorName();
                }
                String str4 = this.f;
                if (str4 == null || str4.equalsIgnoreCase("")) {
                    this.f = "unknown";
                }
            } catch (Exception unused2) {
            }
            String strEncode = URLEncoder.encode(this.f);
            this.f = strEncode;
            jSONObject.put("carrier", strEncode);
            String str5 = Build.MODEL;
            if (str5 != null && !str5.equalsIgnoreCase("")) {
                this.g = str5;
            }
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.g);
            String str6 = Build.MANUFACTURER;
            if (str6 != null && !str6.equalsIgnoreCase("")) {
                this.h = str6;
            }
            jSONObject.put("manufacturer", this.h);
            String str7 = Build.VERSION.RELEASE;
            if (str7 != null && !str7.equalsIgnoreCase("")) {
                this.i = str7;
            }
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, this.i);
            jSONObject.put("sdk_version", this.j);
            Display displayA = com.igaworks.adpopcorn.cores.common.c.a(context);
            jSONObject.put("width", displayA.getWidth());
            jSONObject.put("height", displayA.getHeight());
            Locale locale = Locale.getDefault();
            String str8 = this.k;
            jSONObject.put(UserDataStore.COUNTRY, (str8 == null || str8.length() <= 0) ? locale.getCountry() : this.k);
            jSONObject.put("language", locale.getLanguage());
            jSONObject.put("use_google_account", this.l);
            jSONObject.put("google_account_list", c(context));
            jSONObject.put("has_one_store", this.n);
            jSONObject.put("one_store_account_list", f(context));
            jSONObject.put("utc_offset", h());
            jSONObject.put("market", this.q);
            jSONObject.put("android_opt_out_enabled", this.t);
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, "android");
            a(context);
            String str9 = this.r;
            if (str9 != null && str9.length() > 0) {
                jSONObject.put(InneractiveMediationDefs.KEY_AGE, this.r);
            }
            b(context);
            String str10 = this.s;
            if (str10 != null && str10.length() > 0) {
                jSONObject.put(InneractiveMediationDefs.KEY_GENDER, this.s);
            }
            jSONObject.put("sign_1", this.w);
            jSONObject.put("sign_2", this.x);
            jSONObject.put("sign_3", this.y);
            jSONObject.put("timestamp", this.z);
            jSONObject.put(TapjoyConstants.TJC_INSTALLER, e(context));
            jSONObject.put("build_target_version", k.a(context));
        } catch (Exception unused3) {
        }
        return jSONObject;
    }

    public void d(String str) {
        this.e = str;
    }

    public boolean d() {
        return this.w;
    }

    public String e(Context context) {
        try {
            this.u = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.u;
    }

    public void e(String str) {
        this.c = str;
    }

    public boolean e() {
        return this.x;
    }

    public boolean f() {
        return this.y;
    }

    public String g() {
        return this.c;
    }

    public boolean i() {
        return this.A;
    }

    public boolean j() {
        return this.B;
    }
}
