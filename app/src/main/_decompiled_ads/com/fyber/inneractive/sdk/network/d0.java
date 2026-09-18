package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends f0<com.fyber.inneractive.sdk.response.e> implements n {
    public final InneractiveAdRequest r;
    public Map<String, String> s;
    public StringBuffer t;
    public final com.fyber.inneractive.sdk.serverapi.c u;
    public com.fyber.inneractive.sdk.dv.g v;
    public boolean w;
    public com.fyber.inneractive.sdk.network.timeouts.request.a x;

    public d0(w<com.fyber.inneractive.sdk.response.e> wVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.config.global.s sVar) {
        this(wVar, inneractiveAdRequest, new com.fyber.inneractive.sdk.serverapi.b(sVar), x.a().b(), sVar);
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public String a() {
        int i = com.fyber.inneractive.sdk.config.f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        String strA = TextUtils.isEmpty(property) ? "https://" + IAConfigManager.M.i.e : com.fyber.inneractive.sdk.config.a.a(property, "clientRequestEnhancedXmlAd");
        InneractiveAdRequest inneractiveAdRequest = this.r;
        com.fyber.inneractive.sdk.serverapi.c cVar = this.u;
        e0 e0Var = new e0(inneractiveAdRequest, cVar);
        e0Var.c = new HashMap();
        e0Var.a("fromSDK", Boolean.toString(true));
        e0Var.a("po", System.getProperty("ia.testEnvironmentConfiguration.number"));
        e0Var.a("secure", (com.fyber.inneractive.sdk.util.p.a() ^ true) || IAConfigManager.M.r ? "1" : "0");
        e0Var.a("spotid", inneractiveAdRequest.getSpotId());
        String property2 = System.getProperty("ia.testEnvironmentConfiguration.chosenUnitId");
        if (property2 == null) {
            property2 = inneractiveAdRequest.getSelectedUnitConfig() == null ? null : ((com.fyber.inneractive.sdk.config.a0) inneractiveAdRequest.getSelectedUnitConfig()).a;
        }
        e0Var.a("uid", property2);
        IAConfigManager iAConfigManager = IAConfigManager.M;
        if (TextUtils.isEmpty(iAConfigManager.o)) {
            e0Var.a("med", iAConfigManager.m);
        } else {
            e0Var.a("med", String.format("%s_%s", iAConfigManager.m, iAConfigManager.o));
        }
        cVar.getClass();
        e0Var.a(InneractiveMediationDefs.GENDER_FEMALE, Integer.toString(372));
        com.fyber.inneractive.sdk.serverapi.b bVar = (com.fyber.inneractive.sdk.serverapi.b) cVar;
        List<Integer> list = com.fyber.inneractive.sdk.serverapi.b.d;
        if (!list.isEmpty()) {
            e0Var.a("protocols", com.fyber.inneractive.sdk.util.l.a(",", list));
        }
        List<String> list2 = com.fyber.inneractive.sdk.serverapi.b.e;
        if (!list2.isEmpty()) {
            e0Var.a("mimes", com.fyber.inneractive.sdk.util.l.b(",", list2));
        }
        List<Integer> list3 = com.fyber.inneractive.sdk.serverapi.b.c;
        if (!list3.isEmpty()) {
            e0Var.a("api", com.fyber.inneractive.sdk.util.l.a(",", list3));
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("zip", iAConfigManager.j.getZipCode());
        }
        e0Var.a("a", Integer.toString(iAConfigManager.j.getAge()));
        InneractiveUserConfig.Gender gender = iAConfigManager.j.getGender();
        if (InneractiveUserConfig.Gender.MALE.equals(gender)) {
            e0Var.a("g", InneractiveMediationDefs.GENDER_MALE);
        } else if (InneractiveUserConfig.Gender.FEMALE.equals(gender)) {
            e0Var.a("g", InneractiveMediationDefs.GENDER_FEMALE);
        }
        e0Var.a(CampaignEx.JSON_KEY_AD_K, iAConfigManager.k);
        e0Var.a("t", Long.toString(System.currentTimeMillis()));
        e0Var.a("v", bVar.a("2.2.0"));
        Boolean boolA = iAConfigManager.D.a();
        if (boolA != null) {
            e0Var.a("gdpr_privacy_consent", boolA.booleanValue() ? "1" : "0");
        }
        com.fyber.inneractive.sdk.config.d dVar = iAConfigManager.D;
        if (dVar != null) {
            Boolean bool = com.fyber.inneractive.sdk.util.l.a == null ? null : dVar.f;
            if (bool != null) {
                e0Var.a("lgpd_consent", bool.booleanValue() ? "1" : "0");
            }
            Boolean bool2 = iAConfigManager.D.g;
            if (bool2 != null && bool2.booleanValue()) {
                e0Var.a("coppaApplies", "1");
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            String property3 = System.getProperty("ia.testEnvironmentConfiguration.device");
            String str = com.fyber.inneractive.sdk.config.l.b() ? "amazonId" : "aaid";
            if (TextUtils.isEmpty(property3)) {
                property3 = com.fyber.inneractive.sdk.config.l.a();
            }
            e0Var.a(str, property3);
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("dnt", Boolean.toString(com.fyber.inneractive.sdk.config.l.c()));
        }
        e0Var.a("dml", bVar.b());
        int iC = com.fyber.inneractive.sdk.util.l.c(com.fyber.inneractive.sdk.util.l.e());
        int iC2 = com.fyber.inneractive.sdk.util.l.c(com.fyber.inneractive.sdk.util.l.d());
        if (iC > 0 && iC2 > 0) {
            e0Var.a("w", Integer.toString(iC));
            e0Var.a("h", Integer.toString(iC2));
        }
        int iC3 = com.fyber.inneractive.sdk.util.l.c();
        e0Var.a("o", iC3 == 1 ? "p" : iC3 == 2 ? "l" : "u");
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("ciso", com.fyber.inneractive.sdk.util.j.g());
            e0Var.a("mcc", bVar.c());
            e0Var.a("mnc", bVar.d());
            e0Var.a("nt", com.fyber.inneractive.sdk.util.f0.e().key);
            e0Var.a("crn", bVar.a());
        }
        e0Var.a("os", "Android");
        e0Var.a("lng", iAConfigManager.p);
        List<String> list4 = iAConfigManager.q;
        if (list4 != null && !list4.isEmpty()) {
            e0Var.a("in_lng", com.fyber.inneractive.sdk.util.l.b(",", list4));
        }
        e0Var.a(BidResponsed.KEY_BID_ID, com.fyber.inneractive.sdk.util.l.a.getPackageName());
        e0Var.a("appv", bVar.f());
        com.fyber.inneractive.sdk.config.d dVar2 = iAConfigManager.D;
        dVar2.getClass();
        e0Var.a("gdpr_consent_data", com.fyber.inneractive.sdk.util.l.a == null ? null : dVar2.f869b);
        com.fyber.inneractive.sdk.config.d dVar3 = iAConfigManager.D;
        dVar3.getClass();
        e0Var.a("us_privacy", com.fyber.inneractive.sdk.util.l.a == null ? null : dVar3.e);
        e0Var.a("mute_video", Boolean.toString(iAConfigManager.l));
        e0Var.a("osv", Build.VERSION.RELEASE);
        e0Var.a("ignitep", iAConfigManager.E.c);
        e0Var.a("ignitev", iAConfigManager.E.d);
        HashMap map = new HashMap();
        bVar.a(map, inneractiveAdRequest.getSpotId());
        for (Map.Entry entry : map.entrySet()) {
            e0Var.a((String) entry.getKey(), (String) entry.getValue());
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            e0Var.a("childMode", "1");
        }
        Map<String, String> map2 = e0Var.c;
        StringBuilder sb = new StringBuilder(strA);
        boolean z = true;
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            sb.append(z ? "?" : "&");
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append(Uri.encode(entry2.getValue()));
            z = false;
        }
        String string = sb.toString();
        if (!this.w) {
            int i2 = IAlog.a;
            IAlog.a(1, null, "%s %s", "AD_REQUEST", string);
            this.w = true;
        }
        return string;
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestAd : set start connection timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestAd : set end read timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(y()));
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public void d() {
        super.d();
        IAlog.a("%s : NetworkRequestAd cancel by timeout - resolve request with no fill", IAlog.a(this));
        this.a = true;
        a((Object) null, (Exception) new s0(204, "no fill"), false);
    }

    @Override // com.fyber.inneractive.sdk.network.n
    public StringBuffer e() {
        return this.t;
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public int h() {
        return this.x.f;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public o0 i() {
        return o0.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public t0 n() {
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.x;
        return new t0(aVar.i, aVar.h);
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public boolean o() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public z r() {
        return z.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.n
    public Map<String, String> t() {
        return this.s;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public int v() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public Map<String, String> w() {
        int i = com.fyber.inneractive.sdk.config.f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("mockadnetworkresponseid", property);
        IAlog.a("NetworkRequestAd: Adding mock response header - %s", property);
        return map;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public int x() {
        return y();
    }

    public d0(w<com.fyber.inneractive.sdk.response.e> wVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.serverapi.c cVar, g gVar, com.fyber.inneractive.sdk.config.global.s sVar) {
        super(wVar, gVar, sVar);
        this.v = null;
        this.w = false;
        this.q = true;
        this.r = inneractiveAdRequest;
        this.u = cVar;
        if (inneractiveAdRequest != null) {
            this.x = new com.fyber.inneractive.sdk.network.timeouts.request.c().a(com.fyber.inneractive.sdk.util.q0.a(inneractiveAdRequest.getSpotId()), inneractiveAdRequest.getMediationName(), sVar, false);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public byte[] u() {
        byte[] bytes = new byte[0];
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            com.fyber.inneractive.sdk.config.global.s sVar = ((com.fyber.inneractive.sdk.serverapi.b) this.u).a;
            JSONArray jSONArrayD = sVar != null ? sVar.d() : null;
            if (jSONArrayD != null && jSONArrayD.length() > 0) {
                jSONObject2.put("experiments", jSONArrayD);
                jSONObject.put("sdk_experiments", jSONObject2);
            }
            UnitDisplayType unitDisplayTypeA = com.fyber.inneractive.sdk.serverapi.a.a(this.r.getSpotId());
            IAConfigManager iAConfigManager = IAConfigManager.M;
            JSONArray jSONArrayA = iAConfigManager.x.a(unitDisplayTypeA);
            if (jSONArrayA != null && jSONArrayA.length() > 0) {
                jSONObject.put("user_sessions", jSONArrayA);
            }
            int iA = iAConfigManager.u.f886b.a("dv_enabled_v2", 0, 0);
            if (unitDisplayTypeA != null && iA == 1) {
                com.fyber.inneractive.sdk.dv.g gVarA = iAConfigManager.F.a(unitDisplayTypeA);
                this.v = gVarA;
                if (gVarA != null) {
                    jSONObject.put("gdem_signal", gVarA.a.getQuery());
                }
            }
            bytes = Build.VERSION.SDK_INT >= 19 ? jSONObject.toString().getBytes(StandardCharsets.UTF_8) : jSONObject.toString().getBytes("UTF-8");
            IAlog.a("request json body - %s", jSONObject.toString());
        } catch (Exception unused) {
            IAlog.a("Failed building body for ad request!", new Object[0]);
        }
        return bytes;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008f  */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, com.fyber.inneractive.sdk.response.e] */
    @Override // com.fyber.inneractive.sdk.network.c0
    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        StringBuffer stringBufferA;
        String str;
        List<String> list;
        if (map != null) {
            HashMap map2 = new HashMap();
            for (String str2 : map.keySet()) {
                if (str2 != null && (list = map.get(str2)) != null && list.size() > 0) {
                    map2.put(str2.toLowerCase(), list.get(0));
                }
            }
            this.s = map2;
        }
        InputStream inputStream = jVar.c;
        super.d(System.currentTimeMillis());
        IAlog.a("%s : NetworkRequestAd : set start read timestamp", IAlog.a(this));
        if (inputStream != null) {
            try {
                stringBufferA = com.fyber.inneractive.sdk.util.q.a(inputStream, false);
            } catch (Exception e) {
                IAlog.a("failed create response builder in network request ad", e, new Object[0]);
                stringBufferA = null;
            }
            this.t = stringBufferA;
        }
        c(System.currentTimeMillis());
        b0 b0Var = new b0();
        try {
            Map<String, String> map3 = this.s;
            if (map3 != null) {
                str = map3.get(m.RETURNED_AD_TYPE.key.toLowerCase());
                if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                    str = null;
                }
            } else {
                str = null;
            }
            b0Var.a = a(str != null ? Integer.parseInt(str) : 6, this, null, this.v);
            return b0Var;
        } catch (Exception e2) {
            c(System.currentTimeMillis());
            IAlog.a("failed parse ad network request", e2, new Object[0]);
            throw new a0(e2);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public j a(String str) throws Exception {
        IAlog.a("%s: NetworkRequestAd Ad request execution started, timeouts(connection: %d read: %d)", IAlog.a(this), Integer.valueOf(n().a), Integer.valueOf(n().f994b));
        return super.a(str);
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestAd : set end connection timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(y()));
    }
}
