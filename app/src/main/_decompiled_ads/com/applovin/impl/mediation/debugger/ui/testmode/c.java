package com.applovin.impl.mediation.debugger.ui.testmode;

import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.e;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private List<String> auk;
    private boolean iV;
    private final n sdk;

    public c(n nVar) {
        this.sdk = nVar;
        this.iV = ((Boolean) nVar.b((d<boolean>) d.aRJ, false)).booleanValue() || e.V(n.getApplicationContext()).dC("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator();
        nVar.b(d.aRJ);
    }

    public boolean isEnabled() {
        return this.iV;
    }

    public boolean xi() {
        List<String> list = this.auk;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public List<String> xj() {
        return this.auk;
    }

    public void bT(String str) {
        if (StringUtils.isValidString(str)) {
            C(Collections.singletonList(str));
        } else {
            C(null);
        }
    }

    public void C(List<String> list) {
        if (list == null && this.auk == null) {
            return;
        }
        if (list == null || !list.equals(this.auk)) {
            this.auk = list;
            xl();
        }
    }

    public void xk() {
        this.sdk.a((d<boolean>) d.aRJ, true);
    }

    public void f(JSONObject jSONObject) {
        String strKP;
        boolean zCX;
        if (this.iV) {
            return;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
        if (this.sdk.BT() != null) {
            strKP = this.sdk.BS().DJ().KP();
            zCX = this.sdk.BS().CX();
        } else {
            strKP = this.sdk.BQ().Df().KP();
            zCX = this.sdk.BQ().CX();
        }
        this.iV = zCX || JsonUtils.containsCaseInsensitiveString(strKP, jSONArray);
    }

    private void xl() {
        k kVarCf = this.sdk.Cf();
        if (this.iV) {
            kVarCf.H(this.auk);
        } else {
            kVarCf.G(this.auk);
        }
    }
}
