package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.response.a f1379b;
    public final Map<String, String> c;

    public c(JSONObject jSONObject, com.fyber.inneractive.sdk.response.a aVar, Map<String, String> map) {
        try {
            this.a = jSONObject.getJSONObject("ad").optString("markup");
        } catch (JSONException e) {
            IAlog.a("Failed extracting markup", e, new Object[0]);
        }
        this.f1379b = aVar;
        this.c = map;
    }
}
