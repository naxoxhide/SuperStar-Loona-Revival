package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsConfiglInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static final e c = new e(null);
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f673b;

    public e(String str) {
        this.a = "https://sf16-scmcdn-sg.ibytedtos.com/goofy/bytecom/resource/tetris/oversea_pi.01f77b3a.js";
        this.f673b = true;
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("performance_js");
            this.a = jSONObjectOptJSONObject.optString("url", "https://sf16-scmcdn-sg.ibytedtos.com/goofy/bytecom/resource/tetris/oversea_pi.01f77b3a.js");
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("execute_time");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i));
            }
            this.f673b = arrayList.contains("load_finish");
        } catch (Exception unused) {
        }
    }
}
