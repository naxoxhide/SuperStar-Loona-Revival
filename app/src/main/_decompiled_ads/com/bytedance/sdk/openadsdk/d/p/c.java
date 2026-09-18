package com.bytedance.sdk.openadsdk.d.p;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.p;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.s;
import com.google.firebase.messaging.Constants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdLogParamsGenerate.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f742b;
    private final boolean d = e();
    private final Context c = o.a();
    private final String e = c();

    private String a(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i != 480) {
            return i != 640 ? "mdpi" : "xxxhdpi";
        }
        return "xxhdpi";
    }

    private String c() {
        if (DeviceUtils.m(this.c)) {
            return "tv";
        }
        return DeviceUtils.l(this.c) ? "android_pad" : "android";
    }

    private boolean e() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(List<com.bytedance.sdk.openadsdk.d.a> list) {
        return a0.e((list.size() <= 0 || list.get(0) == null || list.get(0).e() == null) ? "" : list.get(0).e().optString("app_log_url"));
    }

    public List<com.bytedance.sdk.openadsdk.d.a> b(List<com.bytedance.sdk.openadsdk.d.a> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.d.a aVar : list) {
            try {
                JSONObject jSONObjectE = aVar.e();
                jSONObjectE.putOpt("_ad_staging_flag", 1);
                arrayList.add(new com.bytedance.sdk.openadsdk.d.a(aVar.a, jSONObjectE));
            } catch (Exception e) {
                m.b("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    @JProtect
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", a0.t());
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, a0.s());
            jSONObject.put("sim_op", a(this.c));
            jSONObject.put("root", this.d ? 1 : 0);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, b());
            jSONObject.put("access", p.a(this.c));
            jSONObject.put("os", "Android");
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.e);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_MANUFACTURER, Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", b0.g(this.c) + "x" + b0.i(this.c));
            jSONObject.put("display_density", a(b0.b(this.c)));
            jSONObject.put("density_dpi", b0.b(this.c));
            jSONObject.put("aid", "1371");
            jSONObject.put("device_id", com.bytedance.sdk.openadsdk.core.j.c(this.c));
            jSONObject.put("rom", a());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.f742b);
            jSONObject.put("uid", this.a);
            jSONObject.put("google_aid", b.c.a.a.a.b.a.b().a());
            jSONObject.put("locale_language", DeviceUtils.h());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.j() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.k() ? 1 : 0);
            com.bytedance.sdk.openadsdk.core.settings.d dVarD = o.d();
            jSONObject.put("force_language", t.k(this.c, "tt_choose_language"));
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

    private void a(com.bytedance.sdk.openadsdk.d.a aVar, boolean z) {
        String strOptString;
        if (aVar == null) {
            return;
        }
        try {
            if (z) {
                strOptString = aVar.e().optJSONObject("params").optString("log_extra", "");
            } else {
                strOptString = aVar.e().optString("log_extra", "");
            }
            long jD = q.d(strOptString);
            int iE = q.e(strOptString);
            if (jD == 0) {
                jD = this.a;
            }
            this.a = jD;
            if (iE == 0) {
                iE = this.f742b;
            }
            this.f742b = iE;
        } catch (Exception e) {
            m.b("AdLogParamsGenerate", "getInfoFromLogExtra exception", e.getMessage());
        }
    }

    private int b() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public JSONObject a(List<com.bytedance.sdk.openadsdk.d.a> list, long j, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            a(list.get(0), z);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.d.a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a(z));
            }
            if (z) {
                jSONObject2.put("event_v3", jSONArray);
                jSONObject2.put("magic_tag", "ss_app_log");
            } else {
                jSONObject2.put("event", jSONArray);
            }
            jSONObject2.put("_gen_time", j);
            jSONObject2.put("local_time", j / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public List<com.bytedance.sdk.openadsdk.d.a> a(List<com.bytedance.sdk.openadsdk.d.a> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.d.a aVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectE = aVar.e();
                jSONObject.putOpt("event", jSONObjectE.optString(Constants.ScionAnalytics.PARAM_LABEL));
                long jOptLong = jSONObjectE.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", com.bytedance.sdk.openadsdk.d.f.r.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> itKeys = jSONObjectE.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.equals(next, Constants.ScionAnalytics.PARAM_LABEL)) {
                        jSONObject2.putOpt(next, jSONObjectE.opt(next));
                    }
                }
                if (z) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt("params", jSONObject2);
                arrayList.add(new com.bytedance.sdk.openadsdk.d.f(aVar.a, jSONObject));
            } catch (Exception e) {
                m.b("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    private String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    @JProtect
    private String a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (r.w()) {
                sb.append("MIUI-");
            } else if (r.s()) {
                sb.append("FLYME-");
            } else {
                String strH = r.h();
                if (r.d(strH)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strH)) {
                    sb.append(strH).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
