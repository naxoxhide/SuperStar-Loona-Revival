package com.applovin.impl.mediation.e;

import android.content.Context;
import android.text.TextUtils;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final TreeMap<String, String> axe;
    private static final List<String> axf;
    private static JSONArray axg;
    private static final Object axh = new Object();
    private static final Map<Integer, AppLovinSdkUtils.Size> axi = Collections.synchronizedMap(new HashMap(1));

    static {
        TreeMap<String, String> treeMap = new TreeMap<>();
        axe = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonPublisherServicesMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", ADXLogUtil.PLATFORM_APPLOVIN);
        treeMap.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "BidMachine");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", ADXLogUtil.PLATFORM_PANGLE);
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.CriteoMediationAdapter", ADXLogUtil.PLATFORM_CRITEO);
        treeMap.put("com.applovin.mediation.adapters.CSJMediationAdapter", "CSJ");
        treeMap.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", ADXLogUtil.PLATFORM_ADMOB);
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", ADXLogUtil.PLATFORM_FYBER);
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", ADXLogUtil.PLATFORM_MINTEGRAL);
        treeMap.put("com.applovin.mediation.adapters.MobileFuseMediationAdapter", "MobileFuse");
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.NimbusMediationAdapter", "Nimbus");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.PangleMediationAdapter", ADXLogUtil.PLATFORM_PANGLE);
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.TaboolaMediationAdapter", "Taboola");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", ADXLogUtil.PLATFORM_VUNGLE);
        treeMap.put("com.applovin.mediation.adapters.YahooMediationAdapter", "Yahoo");
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        axf = new ArrayList(treeMap.keySet());
    }

    public static JSONArray f(n nVar) {
        if (axg != null) {
            g(nVar);
            return axg;
        }
        axg = new JSONArray();
        for (String str : axf) {
            MaxAdapter maxAdapterB = b(str, nVar);
            if (maxAdapterB != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", axe.get(str));
                    jSONObject.put("class", str);
                    jSONObject.put("sdk_version", maxAdapterB.getSdkVersion());
                    jSONObject.put("version", maxAdapterB.getAdapterVersion());
                } catch (Throwable unused) {
                }
                synchronized (axh) {
                    axg.put(jSONObject);
                }
            }
        }
        return axg;
    }

    public static JSONObject a(String str, n nVar) {
        JSONArray jSONArrayF = f(nVar);
        for (int i = 0; i < jSONArrayF.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArrayF, i, (JSONObject) null);
            if (jSONObject != null && str.equals(JsonUtils.getString(jSONObject, "class", null))) {
                return jSONObject;
            }
        }
        return null;
    }

    private static void g(n nVar) {
        MaxAdapter maxAdapterB;
        for (int i = 0; i < axg.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(axg, i, (JSONObject) null);
            String string = JsonUtils.getString(jSONObject, "class", "");
            if (!StringUtils.isValidString(JsonUtils.getString(jSONObject, "sdk_version", "")) && (maxAdapterB = b(string, nVar)) != null) {
                String sdkVersion = maxAdapterB.getSdkVersion();
                if (StringUtils.isValidString(sdkVersion)) {
                    synchronized (axh) {
                        JsonUtils.putString(jSONObject, "sdk_version", sdkVersion);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static q.b f(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
            return q.b.MEDIATION_INTERSTITIAL;
        }
        if (maxAdFormat == MaxAdFormat.APP_OPEN) {
            return q.b.MEDIATION_APP_OPEN;
        }
        if (maxAdFormat == MaxAdFormat.REWARDED) {
            return q.b.MEDIATION_INCENTIVIZED;
        }
        if (maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL) {
            return q.b.MEDIATION_REWARDED_INTERSTITIAL;
        }
        return q.b.MEDIATION_BANNER;
    }

    public static MaxAdapter b(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            }
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return (MaxAdapter) cls.getConstructor(AppLovinSdk.class).newInstance(nVar.getWrappingSdk());
            }
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("AppLovinSdk", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            }
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().c("AppLovinSdk", "Failed to load: " + str, th);
            }
        }
    }

    public static boolean Z(Object obj) {
        return (obj instanceof e) && StringUtils.isValidString(((e) obj).Gz());
    }

    public static boolean aa(Object obj) {
        return (obj instanceof com.applovin.impl.mediation.b.a) && "APPLOVIN".equals(((com.applovin.impl.mediation.b.a) obj).yA());
    }

    public static AppLovinSdkUtils.Size a(int i, MaxAdFormat maxAdFormat, Context context) {
        if (i < 0) {
            try {
                i = AppLovinSdkUtils.pxToDp(context, h.X(context).x);
            } catch (Throwable unused) {
                return maxAdFormat.getSize();
            }
        }
        Map<Integer, AppLovinSdkUtils.Size> map = axi;
        AppLovinSdkUtils.Size size = map.get(Integer.valueOf(i));
        if (size != null) {
            return size;
        }
        Class<?> cls = Class.forName("com.google.android.gms.ads.AdSize");
        Method method = cls.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", Context.class, Integer.TYPE);
        Method method2 = cls.getMethod("getWidth", new Class[0]);
        Method method3 = cls.getMethod("getHeight", new Class[0]);
        Object objInvoke = method.invoke(null, context, Integer.valueOf(i));
        AppLovinSdkUtils.Size size2 = new AppLovinSdkUtils.Size(((Integer) method2.invoke(objInvoke, new Object[0])).intValue(), ((Integer) method3.invoke(objInvoke, new Object[0])).intValue());
        map.put(Integer.valueOf(i), size2);
        return size2;
    }
}
