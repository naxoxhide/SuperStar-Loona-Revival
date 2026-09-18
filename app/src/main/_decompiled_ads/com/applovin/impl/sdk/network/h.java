package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.p;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private p.a aHK;
    private String aHy;
    private Map<String, String> aHz;
    private String aIk;
    private String aIl;
    private Map<String, Object> aIm;
    private boolean aIn;
    private boolean aIo;
    private boolean aIp;
    private boolean aIq;
    private String aIr;
    private int aIs;
    private String ajW;
    private Map<String, String> awu;

    public boolean IC() {
        return this.aIp;
    }

    h(JSONObject jSONObject, n nVar) throws Exception {
        Map<String, String> map;
        Map<String, String> map2;
        Map<String, Object> map3;
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        String string3 = JsonUtils.getString(jSONObject, "httpMethod", "");
        String string4 = jSONObject.getString("targetUrl");
        String string5 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i = jSONObject.getInt("attemptNumber");
        if (JsonUtils.valueExists(jSONObject, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS)) {
            map = Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject(DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS)));
        } else {
            map = new HashMap<>();
        }
        if (JsonUtils.valueExists(jSONObject, "httpHeaders")) {
            map2 = Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders")));
        } else {
            map2 = new HashMap<>();
        }
        if (JsonUtils.valueExists(jSONObject, "requestBody")) {
            map3 = Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody")));
        } else {
            map3 = new HashMap<>();
        }
        this.ajW = string;
        this.aHy = string3;
        this.aIr = string2;
        this.aIk = string4;
        this.aIl = string5;
        this.aHz = map;
        this.awu = map2;
        this.aIm = map3;
        this.aHK = p.a.gU(jSONObject.optInt("encodingType", p.a.DEFAULT.getValue()));
        this.aIn = jSONObject.optBoolean("isEncodingEnabled", false);
        this.aIo = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.aIp = jSONObject.optBoolean("isAllowedPreInitEvent", false);
        this.aIq = jSONObject.optBoolean("shouldFireInWebView", false);
        this.aIs = i;
    }

    private h(a aVar) {
        this.ajW = UUID.randomUUID().toString();
        this.aHy = aVar.aHy;
        this.aIk = aVar.aIk;
        this.aIl = aVar.aIl;
        this.aHz = aVar.aHz;
        this.awu = aVar.awu;
        this.aIm = aVar.aIm;
        this.aHK = aVar.aHK;
        this.aIn = aVar.aIn;
        this.aIo = aVar.aIo;
        this.aIp = aVar.aIp;
        this.aIq = aVar.aIq;
        this.aIr = aVar.aIr;
        this.aIs = 0;
    }

    String HO() {
        return this.aHy;
    }

    String Is() {
        return this.aIk;
    }

    String It() {
        return this.aIl;
    }

    Map<String, String> HP() {
        return this.aHz;
    }

    Map<String, String> HQ() {
        return this.awu;
    }

    Map<String, Object> Iu() {
        return this.aIm;
    }

    p.a Ib() {
        return this.aHK;
    }

    boolean Ia() {
        return this.aIn;
    }

    boolean Id() {
        return this.aIo;
    }

    boolean Iv() {
        return this.aIq;
    }

    String Iw() {
        return this.aIr;
    }

    int Ix() {
        return this.aIs;
    }

    void Iy() {
        this.aIs++;
    }

    void Iz() {
        Map<String, String> map = CollectionUtils.map(this.aHz);
        map.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.aHz = map;
    }

    JSONObject IA() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.ajW);
        jSONObject.put("communicatorRequestId", this.aIr);
        jSONObject.put("httpMethod", this.aHy);
        jSONObject.put("targetUrl", this.aIk);
        jSONObject.put("backupUrl", this.aIl);
        jSONObject.put("encodingType", this.aHK);
        jSONObject.put("isEncodingEnabled", this.aIn);
        jSONObject.put("gzipBodyEncoding", this.aIo);
        jSONObject.put("isAllowedPreInitEvent", this.aIp);
        jSONObject.put("attemptNumber", this.aIs);
        if (this.aHz != null) {
            jSONObject.put(DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS, new JSONObject(this.aHz));
        }
        if (this.awu != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.awu));
        }
        if (this.aIm != null) {
            jSONObject.put("requestBody", new JSONObject(this.aIm));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.ajW + "', communicatorRequestId='" + this.aIr + "', httpMethod='" + this.aHy + "', targetUrl='" + this.aIk + "', backupUrl='" + this.aIl + "', attemptNumber=" + this.aIs + ", isEncodingEnabled=" + this.aIn + ", isGzipBodyEncoding=" + this.aIo + ", isAllowedPreInitEvent=" + this.aIp + ", shouldFireInWebView=" + this.aIq + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ajW.equals(((h) obj).ajW);
    }

    public int hashCode() {
        return this.ajW.hashCode();
    }

    public static a IB() {
        return new a();
    }

    public static class a {
        private p.a aHK;
        private String aHy;
        private Map<String, String> aHz;
        private String aIk;
        private String aIl;
        private Map<String, Object> aIm;
        private boolean aIn;
        private boolean aIo;
        private boolean aIp;
        private boolean aIq;
        private String aIr;
        private Map<String, String> awu;

        public a df(String str) {
            this.aIr = str;
            return this;
        }

        public a dg(String str) {
            this.aHy = str;
            return this;
        }

        public a dh(String str) {
            this.aIk = str;
            return this;
        }

        public a di(String str) {
            this.aIl = str;
            return this;
        }

        public a n(Map<String, String> map) {
            this.aHz = map;
            return this;
        }

        public a o(Map<String, String> map) {
            this.awu = map;
            return this;
        }

        public a p(Map<String, Object> map) {
            this.aIm = map;
            return this;
        }

        public a b(p.a aVar) {
            this.aHK = aVar;
            return this;
        }

        public a aV(boolean z) {
            this.aIn = z;
            return this;
        }

        public a aW(boolean z) {
            this.aIo = z;
            return this;
        }

        public a aX(boolean z) {
            this.aIp = z;
            return this;
        }

        public a aY(boolean z) {
            this.aIq = z;
            return this;
        }

        public h ID() {
            return new h(this);
        }
    }
}
