package com.applovin.impl.mediation.debugger.b.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements AppLovinCommunicatorSubscriber, Comparable<b> {
    private final a aoS;
    private int aoT;
    private final boolean aoU;
    private final boolean aoV;
    private final boolean aoW;
    private final boolean aoX;
    private final boolean aoY;
    private final boolean aoZ;
    private final boolean aot;
    private final String aou;
    private final boolean apa;
    private final boolean apb;
    private final boolean apc;
    private final boolean apd;
    private final boolean ape;
    private final String apf;
    private String apg;
    private final String aph;
    private final String api;
    private final String apj;
    private final String apk;
    private final int apl;
    private final List<MaxAdFormat> apm;
    private final List<c> apn;
    private final List<com.applovin.impl.mediation.debugger.b.c.a> apo;
    private final List<String> app;
    private final List<String> apq;
    private final Map<MaxAdFormat, String> apr;
    private final boolean aps;
    private final String apt;
    private final Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> apu;
    private final String name;
    private final n sdk;

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");

        private final String apz;

        a(String str) {
            this.apz = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String vM() {
            return this.apz;
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.b.c.b$b, reason: collision with other inner class name */
    public enum EnumC0123b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");

        private final String apG;
        private final int apH;
        private final String apI;

        EnumC0123b(String str, int i, String str2) {
            this.apG = str;
            this.apH = i;
            this.apI = str2;
        }

        public String vN() {
            return this.apG;
        }

        public int vO() {
            return this.apH;
        }

        public String vP() {
            return this.apI;
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x021e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:69:0x0222  */
    /* JADX WARN: Code duplicated, block: B:72:0x0234  */
    /* JADX WARN: Code duplicated, block: B:73:0x0240  */
    /* JADX WARN: Code duplicated, block: B:76:0x028a  */
    /* JADX WARN: Code duplicated, block: B:79:0x02a1  */
    public b(JSONObject jSONObject, n nVar) {
        String adapterVersion;
        String sdkVersion;
        boolean zEquals;
        String string;
        boolean zIsBeta;
        boolean z;
        boolean z2;
        int iLastIndexOf;
        String lowerCase;
        LinkedHashMap<String, Integer> linkedHashMapTV;
        JSONObject jSONObject2;
        String string2;
        this.sdk = nVar;
        this.name = JsonUtils.getString(jSONObject, "name", "");
        this.aou = JsonUtils.getString(jSONObject, "display_name", "");
        this.apf = JsonUtils.getString(jSONObject, "adapter_class", "");
        this.api = JsonUtils.getString(jSONObject, "latest_adapter_version", "");
        this.app = e(jSONObject);
        this.apa = JsonUtils.getBoolean(jSONObject, "hide_if_missing", false).booleanValue();
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject, "configuration", new JSONObject());
        this.apn = b(jSONObject3, nVar);
        this.ape = JsonUtils.getBoolean(jSONObject3, "java_8_required", false).booleanValue();
        this.aps = JsonUtils.getBoolean(jSONObject3, "hide_initialization_status", false).booleanValue();
        this.apq = JsonUtils.getList(jSONObject3, "live_network_filtering_names", null);
        JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONObject3, "test_mode", new JSONObject());
        this.apd = JsonUtils.getBoolean(jSONObject4, "false_coppa_required", false).booleanValue();
        JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "network_names", (JSONObject) null);
        if (jSONObject5 != null && jSONObject5.length() > 0) {
            HashMap map = new HashMap(jSONObject5.length());
            Iterator<String> itKeys = jSONObject5.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                MaxAdFormat fromString = MaxAdFormat.formatFromString(next);
                String string3 = JsonUtils.getString(jSONObject5, next, null);
                if (fromString != null && !TextUtils.isEmpty(string3)) {
                    map.put(fromString, string3);
                }
            }
            this.apr = map;
        } else {
            this.apr = null;
        }
        JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject, "test_mode", new JSONObject());
        this.aoY = JsonUtils.getBoolean(jSONObject6, "supported", true).booleanValue();
        this.aoZ = JsonUtils.getBoolean(jSONObject, "test_mode_requires_init", false).booleanValue();
        this.apj = JsonUtils.getString(jSONObject6, "message", null);
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        if (list != null) {
            this.aoU = u.M(list);
        } else {
            this.aoU = u.dI(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
        List<MaxAdFormat> listEmptyList = Collections.emptyList();
        MaxAdapter maxAdapterB = com.applovin.impl.mediation.e.c.b(this.apf, nVar);
        if (maxAdapterB != null) {
            this.aoV = true;
            try {
                try {
                    adapterVersion = maxAdapterB.getAdapterVersion();
                    try {
                        sdkVersion = maxAdapterB.getSdkVersion() != null ? maxAdapterB.getSdkVersion() : "";
                        try {
                            listEmptyList = a(maxAdapterB, JsonUtils.getBoolean(jSONObject4, "is_mrec_supported", true).booleanValue());
                            JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONObject3, "native_ad_view_config", (JSONObject) null);
                            if (jSONObject7 != null) {
                                String string4 = JsonUtils.getString(jSONObject7, "min_adapter_version", null);
                                z = string4 == null || u.M(adapterVersion, string4) >= 0;
                                try {
                                    string = JsonUtils.getString(jSONObject7, "network_name", null);
                                } catch (Throwable th) {
                                    th = th;
                                    string = null;
                                    x.H("MediatedNetwork", "Failed to load adapter for network " + this.name + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                                    zIsBeta = false;
                                    Class<?> cls = Class.forName(this.apf);
                                    zEquals = cls.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls);
                                    this.aph = adapterVersion;
                                    this.apg = sdkVersion;
                                    this.apm = listEmptyList;
                                    this.apb = zEquals;
                                    this.apc = z;
                                    this.apk = string;
                                    this.apo = a(jSONObject3, adapterVersion, nVar);
                                    this.aoX = u.dI(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
                                    this.aoS = vL();
                                    if (adapterVersion.equals(this.api)) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    this.aoW = z2;
                                    Context applicationContext = n.getApplicationContext();
                                    iLastIndexOf = this.name.lastIndexOf("_");
                                    if (iLastIndexOf != -1) {
                                        lowerCase = this.name.toLowerCase().substring(0, iLastIndexOf);
                                    } else {
                                        lowerCase = this.name.toLowerCase();
                                    }
                                    this.apl = applicationContext.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", applicationContext.getPackageName());
                                    this.aoT = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
                                    AppLovinCommunicator.getInstance(applicationContext).subscribe(this, "adapter_initialization_status");
                                    linkedHashMapTV = nVar.Cv().tV();
                                    if (linkedHashMapTV.containsKey(this.apf)) {
                                        this.aoT = linkedHashMapTV.get(this.apf).intValue();
                                    }
                                    jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
                                    if (jSONObject2 == null) {
                                    }
                                    this.aot = false;
                                    this.apt = null;
                                    this.apu = null;
                                }
                            } else {
                                string = null;
                                z = false;
                            }
                            try {
                                zIsBeta = maxAdapterB.isBeta();
                            } catch (Throwable th2) {
                                th = th2;
                                x.H("MediatedNetwork", "Failed to load adapter for network " + this.name + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                                zIsBeta = false;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            string = null;
                            z = false;
                            x.H("MediatedNetwork", "Failed to load adapter for network " + this.name + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                            zIsBeta = false;
                            Class<?> cls2 = Class.forName(this.apf);
                            zEquals = cls2.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls2);
                            this.aph = adapterVersion;
                            this.apg = sdkVersion;
                            this.apm = listEmptyList;
                            this.apb = zEquals;
                            this.apc = z;
                            this.apk = string;
                            this.apo = a(jSONObject3, adapterVersion, nVar);
                            this.aoX = u.dI(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
                            this.aoS = vL();
                            if (adapterVersion.equals(this.api)) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            this.aoW = z2;
                            Context applicationContext2 = n.getApplicationContext();
                            iLastIndexOf = this.name.lastIndexOf("_");
                            if (iLastIndexOf != -1) {
                                lowerCase = this.name.toLowerCase().substring(0, iLastIndexOf);
                            } else {
                                lowerCase = this.name.toLowerCase();
                            }
                            this.apl = applicationContext2.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", applicationContext2.getPackageName());
                            this.aoT = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
                            AppLovinCommunicator.getInstance(applicationContext2).subscribe(this, "adapter_initialization_status");
                            linkedHashMapTV = nVar.Cv().tV();
                            if (linkedHashMapTV.containsKey(this.apf)) {
                                this.aoT = linkedHashMapTV.get(this.apf).intValue();
                            }
                            jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
                            if (jSONObject2 == null) {
                            }
                            this.aot = false;
                            this.apt = null;
                            this.apu = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        sdkVersion = "";
                    }
                } catch (Throwable th5) {
                    th = th5;
                    adapterVersion = "";
                    sdkVersion = adapterVersion;
                }
                Class<?> cls3 = Class.forName(this.apf);
                zEquals = cls3.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls3);
            } catch (Throwable th6) {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().c("MediatedNetwork", "Failed to check if adapter overrides MaxNativeAdAdapter", th6);
                }
                zEquals = false;
            }
        } else {
            this.aoV = false;
            adapterVersion = "";
            sdkVersion = adapterVersion;
            zEquals = false;
            string = null;
            zIsBeta = false;
            z = false;
        }
        this.aph = adapterVersion;
        this.apg = sdkVersion;
        this.apm = listEmptyList;
        this.apb = zEquals;
        this.apc = z;
        this.apk = string;
        this.apo = a(jSONObject3, adapterVersion, nVar);
        this.aoX = u.dI(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
        this.aoS = vL();
        if (adapterVersion.equals(this.api) || zIsBeta) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.aoW = z2;
        Context applicationContext3 = n.getApplicationContext();
        iLastIndexOf = this.name.lastIndexOf("_");
        if (iLastIndexOf != -1) {
            lowerCase = this.name.toLowerCase().substring(0, iLastIndexOf);
        } else {
            lowerCase = this.name.toLowerCase();
        }
        this.apl = applicationContext3.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", applicationContext3.getPackageName());
        this.aoT = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
        AppLovinCommunicator.getInstance(applicationContext3).subscribe(this, "adapter_initialization_status");
        linkedHashMapTV = nVar.Cv().tV();
        if (linkedHashMapTV.containsKey(this.apf)) {
            this.aoT = linkedHashMapTV.get(this.apf).intValue();
        }
        jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
        if (jSONObject2 == null && this.aoU) {
            this.aot = true;
            this.apt = JsonUtils.getString(jSONObject2, "test_mode_app_id", null);
            JSONObject jSONObject8 = JsonUtils.getJSONObject(jSONObject2, "test_mode_slot_ids", new JSONObject());
            HashMap map2 = new HashMap(jSONObject8.length());
            Iterator<String> itKeys2 = jSONObject8.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                MaxAdFormat fromString2 = MaxAdFormat.formatFromString(next2);
                JSONObject jSONObject9 = JsonUtils.getJSONObject(jSONObject8, next2, (JSONObject) null);
                if (fromString2 != null && jSONObject9 != null && (string2 = JsonUtils.getString(jSONObject9, "uuid", null)) != null) {
                    map2.put(fromString2, new com.applovin.impl.mediation.debugger.a.b(string2, jSONObject9, fromString2));
                }
            }
            this.apu = map2;
            return;
        }
        this.aot = false;
        this.apt = null;
        this.apu = null;
    }

    public a vl() {
        return this.aoS;
    }

    public int vm() {
        return this.aoT;
    }

    public EnumC0123b vn() {
        if (!this.aoY) {
            return EnumC0123b.NOT_SUPPORTED;
        }
        if (this.aoS != a.COMPLETE && (this.aoS != a.INCOMPLETE_INTEGRATION || !vo() || !vp())) {
            return EnumC0123b.INVALID_INTEGRATION;
        }
        if (!this.sdk.CC().isEnabled()) {
            return EnumC0123b.DISABLED;
        }
        if (this.aoZ && (this.aoT == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.aoT == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) {
            return EnumC0123b.NOT_INITIALIZED;
        }
        return EnumC0123b.READY;
    }

    public boolean vo() {
        return this.aoU;
    }

    public boolean vp() {
        return this.aoV;
    }

    public boolean vq() {
        return this.aoW;
    }

    public boolean vr() {
        return this.aoS == a.MISSING && this.apa;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.aou;
    }

    public String getSdkVersion() {
        return this.apg;
    }

    public String getAdapterVersion() {
        return this.aph;
    }

    public String vs() {
        return this.api;
    }

    public String vt() {
        return this.apf;
    }

    public String vu() {
        return this.apk;
    }

    public List<String> vv() {
        return this.apq;
    }

    public List<String> vw() {
        return this.app;
    }

    public int vx() {
        return this.apl;
    }

    public List<MaxAdFormat> vy() {
        return this.apm;
    }

    public boolean vz() {
        return this.apb;
    }

    public boolean vA() {
        return this.apc;
    }

    public List<c> vB() {
        return this.apn;
    }

    public List<com.applovin.impl.mediation.debugger.b.c.a> vC() {
        return this.apo;
    }

    public boolean vD() {
        return this.ape;
    }

    public boolean vE() {
        return this.aps;
    }

    public Map<MaxAdFormat, String> vF() {
        return this.apr;
    }

    public String vG() {
        return this.apj;
    }

    public boolean vH() {
        return this.apd;
    }

    public final n getSdk() {
        return this.sdk;
    }

    public final String vI() {
        StringBuilder sb = new StringBuilder();
        String str = "UNAVAILABLE";
        StringBuilder sbAppend = sb.append("\n---------- ").append(this.name).append(" ----------").append("\nStatus  - ").append(this.aoS.vM()).append("\nSDK     - ").append((!this.aoU || TextUtils.isEmpty(this.apg)) ? "UNAVAILABLE" : this.apg).append("\nAdapter - ");
        if (this.aoV && !TextUtils.isEmpty(this.aph)) {
            str = this.aph;
        }
        sbAppend.append(str);
        for (c cVar : vB()) {
            if (!cVar.vk()) {
                sb.append("\n* MISSING ").append(cVar.getName()).append(": ").append(cVar.vj());
            }
        }
        for (com.applovin.impl.mediation.debugger.b.c.a aVar : vC()) {
            if (!aVar.vk()) {
                sb.append("\n* MISSING ").append(aVar.getName()).append(": ").append(aVar.vj());
            }
        }
        return sb.toString();
    }

    public boolean uN() {
        return this.aot;
    }

    public String vJ() {
        return this.apt;
    }

    public Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> vK() {
        return this.apu;
    }

    private a vL() {
        a aVar;
        if (this.aoU) {
            if (this.aoV) {
                aVar = a.COMPLETE;
            } else if (this.aoX) {
                aVar = a.MISSING;
            } else {
                aVar = a.INCOMPLETE_INTEGRATION;
            }
        } else if (this.aoV) {
            aVar = a.INCOMPLETE_INTEGRATION;
        } else {
            aVar = a.MISSING;
        }
        if (aVar == a.MISSING) {
            return aVar;
        }
        Iterator<c> it = this.apn.iterator();
        while (it.hasNext()) {
            if (!it.next().vk()) {
                return a.INVALID_INTEGRATION;
            }
        }
        Iterator<com.applovin.impl.mediation.debugger.b.c.a> it2 = this.apo.iterator();
        while (it2.hasNext()) {
            if (!it2.next().vk()) {
                return a.INVALID_INTEGRATION;
            }
        }
        return (!this.ape || n.CF()) ? aVar : a.INVALID_INTEGRATION;
    }

    private List<MaxAdFormat> a(MaxAdapter maxAdapter, boolean z) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAppOpenAdapter) {
            arrayList.add(MaxAdFormat.APP_OPEN);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            if (z) {
                arrayList.add(MaxAdFormat.MREC);
            }
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List<c> b(JSONObject jSONObject, n nVar) {
        ArrayList arrayList = new ArrayList();
        if (this.apf.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            c cVar = new c("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", n.getApplicationContext());
            if (cVar.vk()) {
                arrayList.add(cVar);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                arrayList.add(new c(next, jSONObject2.getString(next), n.getApplicationContext()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List<String> e(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", null), null);
    }

    private List<com.applovin.impl.mediation.debugger.b.c.a> a(JSONObject jSONObject, String str, n nVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new com.applovin.impl.mediation.debugger.b.c.a(jSONObject2, nVar));
            }
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null);
            if (jSONObject3 != null && com.applovin.impl.mediation.debugger.b.c.a.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", null), JsonUtils.getString(jSONObject3, "max_adapter_version", null))) {
                arrayList.add(new com.applovin.impl.mediation.debugger.b.c.a(jSONObject3, nVar));
            }
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        return this.aou.compareToIgnoreCase(bVar.aou);
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.name + ", displayName=" + this.aou + ", sdkAvailable=" + this.aoU + ", sdkVersion=" + this.apg + ", adapterAvailable=" + this.aoV + ", adapterVersion=" + this.aph + "}";
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.apf.equals(string)) {
            this.aoT = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter maxAdapterB = com.applovin.impl.mediation.e.c.b(string, this.sdk);
            if (maxAdapterB == null || this.apg.equals(maxAdapterB.getSdkVersion())) {
                return;
            }
            this.apg = maxAdapterB.getSdkVersion();
            this.sdk.Cf().A(this.apg, string);
        }
    }
}
