package com.applovin.impl.mediation.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private static JSONObject avr;
    protected final SharedPreferences avs = PreferenceManager.getDefaultSharedPreferences(n.getApplicationContext());
    protected final n sdk;
    protected final String tag;

    protected b(String str, n nVar) {
        this.tag = str;
        this.sdk = nVar;
    }

    public com.applovin.impl.sdk.network.c a(String str, String str2, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, a aVar, Map<String, String> map, boolean z, n nVar) {
        Map<String, Object> mapAL;
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().f(this.tag, "Creating OpenRTB request with " + str2);
        }
        Bundle customParameters = maxAdapterResponseParameters.getCustomParameters();
        Context applicationContext = n.getApplicationContext();
        if (nVar.BT() != null) {
            mapAL = nVar.BT().CS();
        } else {
            mapAL = nVar.BQ().aL(false);
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "id", str2);
        JsonUtils.putBoolean(jSONObject, "test", maxAdapterResponseParameters.isTesting());
        JsonUtils.putJsonArrayIfValid(jSONObject, "imp", a(customParameters, maxAdFormat, aVar.avu));
        JsonUtils.putJSONObjectIfValid(jSONObject, "app", a(customParameters, aVar.avv, applicationContext));
        JsonUtils.putJSONObjectIfValid(jSONObject, DeviceRequestsHelper.DEVICE_INFO_DEVICE, a(aVar.avw, mapAL, nVar));
        JsonUtils.putJSONObjectIfValid(jSONObject, "user", i(aVar.avx));
        JsonUtils.putJSONObjectIfValid(jSONObject, "source", j(aVar.avy));
        JsonUtils.putJSONObjectIfValid(jSONObject, "regs", a(aVar.avz, applicationContext));
        JsonUtils.putJSONObjectIfValid(jSONObject, "format", f(mapAL));
        JsonUtils.putJSONObjectIfValid(jSONObject, "ext", aVar.avt);
        return com.applovin.impl.sdk.network.c.D(nVar).da(str).db("POST").l(map).K(jSONObject).ad(new JSONObject()).aS(false).aU(z).Ie();
    }

    private JSONArray a(Bundle bundle, MaxAdFormat maxAdFormat, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putDouble(jSONObject2, "bidfloor", bundle.getDouble("bidfloor", 0.0d));
        if (maxAdFormat.isAdViewAd()) {
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putInt(jSONObject3, "w", bundle.getInt("width", maxAdFormat.getSize().getWidth()));
            JsonUtils.putInt(jSONObject3, "h", bundle.getInt("height", maxAdFormat.getSize().getHeight()));
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(3);
            jSONArray2.put(5);
            jSONArray2.put(6);
            JsonUtils.putJsonArray(jSONObject3, "api", jSONArray2);
            JsonUtils.putJSONObject(jSONObject2, ReportUtil.INVENTORY_TYPE_BANNER, jSONObject3);
        }
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        jSONArray.put(jSONObject2);
        return jSONArray;
    }

    private JSONObject a(Bundle bundle, JSONObject jSONObject, Context context) {
        JSONObject jSONObjectZ = z(context);
        JsonUtils.putString(jSONObjectZ, DynamicLink.Builder.KEY_DOMAIN, bundle.getString(DynamicLink.Builder.KEY_DOMAIN, ""));
        JsonUtils.putString(jSONObjectZ, "storeurl", bundle.getString("storeurl", ""));
        JsonUtils.putJSONObjectIfValid(jSONObjectZ, "ext", jSONObject);
        return jSONObjectZ;
    }

    private JSONObject a(JSONObject jSONObject, Map<String, Object> map, n nVar) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "ua", String.valueOf(map.get("ua")));
        JsonUtils.putBoolean(jSONObject2, "dnt", ((Boolean) map.get("dnt")).booleanValue());
        JsonUtils.putBoolean(jSONObject2, "lmt", ((Boolean) map.get("dnt")).booleanValue());
        JsonUtils.putString(jSONObject2, "ifa", String.valueOf(map.get("idfa")));
        JsonUtils.putString(jSONObject2, "make", String.valueOf(map.get("brand_name")));
        JsonUtils.putString(jSONObject2, DeviceRequestsHelper.DEVICE_INFO_MODEL, String.valueOf(map.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)));
        JsonUtils.putString(jSONObject2, "os", "android");
        JsonUtils.putString(jSONObject2, "osv", String.valueOf(map.get("os")));
        JsonUtils.putInt(jSONObject2, "devicetype", 1);
        JsonUtils.putInt(jSONObject2, "connectiontype", i.H(nVar));
        JsonUtils.putInt(jSONObject2, "w", ((Integer) map.get("dx")).intValue());
        JsonUtils.putInt(jSONObject2, "h", ((Integer) map.get("dy")).intValue());
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject i(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject a(JSONObject jSONObject, Context context) {
        JSONObject jSONObject2 = new JSONObject();
        Boolean boolB = com.applovin.impl.privacy.a.zM().B(context);
        if (boolB != null) {
            JsonUtils.putBoolean(jSONObject2, "coppa", boolB.booleanValue());
        }
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject f(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, "w", ((Integer) map.get("dx")).intValue());
        JsonUtils.putInt(jSONObject, "h", ((Integer) map.get("dy")).intValue());
        return jSONObject;
    }

    protected JSONObject zo() {
        Map<String, Object> mapCY;
        JSONObject jSONObject = new JSONObject();
        if (this.sdk.BT() != null) {
            mapCY = this.sdk.BT().DF();
        } else {
            mapCY = this.sdk.BQ().CY();
        }
        JsonUtils.putObject(jSONObject, "gdpr", mapCY.get("IABTCF_gdprApplies"));
        Boolean boolB = com.applovin.impl.privacy.a.zO().B(n.getApplicationContext());
        if (boolB != null) {
            JsonUtils.putString(jSONObject, "us_privacy", boolB.booleanValue() ? "1YY-" : "1YN-");
        }
        return jSONObject;
    }

    protected JSONObject zp() {
        JSONObject jSONObject = new JSONObject();
        Boolean boolZq = zq();
        if (boolZq != null && boolZq.booleanValue()) {
            JsonUtils.putBoolean(jSONObject, "did_consent", com.applovin.impl.privacy.a.zN().B(n.getApplicationContext()).booleanValue());
            JsonUtils.putString(jSONObject, "consent", this.sdk.Ck().Aq());
        }
        return jSONObject;
    }

    private static JSONObject z(Context context) {
        JSONObject jSONObject = avr;
        if (jSONObject != null) {
            return jSONObject;
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "name", packageManager.getApplicationLabel(applicationInfo).toString());
        JsonUtils.putString(jSONObject2, TJAdUnitConstants.String.BUNDLE, applicationInfo.packageName);
        JsonUtils.putString(jSONObject2, "ver", packageInfo != null ? packageInfo.versionName : "");
        avr = jSONObject2;
        return jSONObject2;
    }

    protected Boolean zq() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(n.getApplicationContext());
        String name = com.applovin.impl.sdk.c.d.aRr.getName();
        if (!defaultSharedPreferences.contains(name)) {
            return null;
        }
        String str = (String) e.a(name, "", String.class, defaultSharedPreferences, false);
        if (StringUtils.isValidString(str)) {
            return Boolean.valueOf(str.equals("1") || str.equalsIgnoreCase("true"));
        }
        Integer num = (Integer) e.a(name, Integer.MAX_VALUE, Integer.class, defaultSharedPreferences, false);
        if (num != null && num.intValue() != Integer.MAX_VALUE) {
            return Boolean.valueOf(num.intValue() > 0);
        }
        Long l = (Long) e.a(name, Long.MAX_VALUE, Long.class, defaultSharedPreferences, false);
        if (l == null || l.longValue() == Long.MAX_VALUE) {
            return (Boolean) e.a(name, false, Boolean.class, defaultSharedPreferences, false);
        }
        return Boolean.valueOf(l.longValue() > 0);
    }

    public static class a {
        private final JSONObject avt;
        private final JSONObject avu;
        private final JSONObject avv;
        private final JSONObject avw;
        private final JSONObject avx;
        private final JSONObject avy;
        private final JSONObject avz;

        /* JADX INFO: renamed from: com.applovin.impl.mediation.c.b$a$a, reason: collision with other inner class name */
        public static class C0119a {
            private JSONObject avt;
            private JSONObject avu;
            private JSONObject avv;
            private JSONObject avw;
            private JSONObject avx;
            private JSONObject avy;
            private JSONObject avz;

            C0119a() {
            }

            public C0119a k(JSONObject jSONObject) {
                this.avt = jSONObject;
                return this;
            }

            public C0119a l(JSONObject jSONObject) {
                this.avu = jSONObject;
                return this;
            }

            public C0119a m(JSONObject jSONObject) {
                this.avx = jSONObject;
                return this;
            }

            public C0119a n(JSONObject jSONObject) {
                this.avz = jSONObject;
                return this;
            }

            public String toString() {
                return "S2SApiService.Extensions.Builder(bidRequestExtObject=" + this.avt + ", impExtObject=" + this.avu + ", appExtObject=" + this.avv + ", deviceExtObject=" + this.avw + ", userExtObject=" + this.avx + ", sourceExtObject=" + this.avy + ", regsExtObject=" + this.avz + ")";
            }

            public a zs() {
                return new a(this.avt, this.avu, this.avv, this.avw, this.avx, this.avy, this.avz);
            }
        }

        a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6, JSONObject jSONObject7) {
            this.avt = jSONObject;
            this.avu = jSONObject2;
            this.avv = jSONObject3;
            this.avw = jSONObject4;
            this.avx = jSONObject5;
            this.avy = jSONObject6;
            this.avz = jSONObject7;
        }

        public static C0119a zr() {
            return new C0119a();
        }
    }
}
