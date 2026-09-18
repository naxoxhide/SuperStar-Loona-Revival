package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private final String f9do;
    private final n sdk;

    public enum a {
        UNSPECIFIED("UNSPECIFIED"),
        REGULAR("REGULAR"),
        AD_RESPONSE_JSON("AD_RESPONSE_JSON");

        private final String mTag;

        a(String str) {
            this.mTag = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mTag;
        }
    }

    public c(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f9do = str;
        this.sdk = nVar;
    }

    public String mQ() {
        return this.f9do;
    }

    public a FN() {
        if (d(com.applovin.impl.sdk.c.b.aLv) != null) {
            return a.REGULAR;
        }
        if (d(com.applovin.impl.sdk.c.b.aLw) != null) {
            return a.AD_RESPONSE_JSON;
        }
        return a.UNSPECIFIED;
    }

    public String FO() {
        String strD = d(com.applovin.impl.sdk.c.b.aLv);
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        String strD2 = d(com.applovin.impl.sdk.c.b.aLw);
        if (TextUtils.isEmpty(strD2)) {
            return null;
        }
        return strD2;
    }

    public JSONObject FP() {
        if (FN() != a.AD_RESPONSE_JSON) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f9do.substring(FO().length()), 0), "UTF-8"));
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("AdToken", "Decoded token into ad response: " + jSONObject);
                }
                return jSONObject;
            } catch (JSONException e) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().c("AdToken", "Unable to decode token '" + this.f9do + "' into JSON", e);
                }
                this.sdk.Cq().d("AdToken", "decodeFullAdResponseStr", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("AdToken", "Unable to process ad response from token '" + this.f9do + "'", e2);
            }
            this.sdk.Cq().d("AdToken", "decodeFullAdResponse", e2);
            return null;
        }
    }

    private String d(com.applovin.impl.sdk.c.b<String> bVar) {
        for (String str : this.sdk.b(bVar)) {
            if (this.f9do.startsWith(str)) {
                return str;
            }
        }
        return null;
    }

    public String toString() {
        return "AdToken{id=" + StringUtils.prefixToIndex(32, this.f9do) + ", type=" + FN() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        String str = this.f9do;
        String str2 = ((c) obj).f9do;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        String str = this.f9do;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
