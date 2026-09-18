package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MediationInitConfigs.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f674b = new g("");
    private final HashMap<String, a> a = new HashMap<>();

    /* JADX INFO: compiled from: MediationInitConfigs.java */
    public static class a {
        public final String a;

        public a(JSONObject jSONObject) {
            this.a = jSONObject.optString("name");
            jSONObject.optString("app_id");
            jSONObject.optInt("init_thread", 2);
            jSONObject.optInt("request_after_init", 2);
            jSONObject.optString("class_name");
        }
    }

    public g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    a aVar = new a(jSONObjectOptJSONObject);
                    this.a.put(aVar.a, aVar);
                }
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.m.b("MediationInitConfigs", e.getMessage());
        }
    }
}
