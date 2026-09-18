package com.bytedance.sdk.openadsdk.core.settings;

import org.json.JSONObject;

/* JADX INFO: compiled from: MediationInitSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends m {
    public h() {
        super("tt_set_mediation.prop");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.c
    public void a(JSONObject jSONObject) {
        if (jSONObject.has("mediation_init_conf")) {
            c.InterfaceC0213c interfaceC0213cC = c();
            interfaceC0213cC.putString("mediation_init_conf", jSONObject.optString("mediation_init_conf"));
            interfaceC0213cC.commit();
        }
    }
}
