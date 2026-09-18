package com.bytedance.sdk.openadsdk.core.f0;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdLogInfoModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f573b;
    public int c = 1;
    public ArrayList<Integer> d;
    public AdSlot e;

    /* JADX INFO: compiled from: AdLogInfoModel.java */
    static class a implements com.bytedance.sdk.openadsdk.l.a {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.MessagePayloadKeys.FROM, b.this.d());
            jSONObject.put("err_code", b.this.b());
            jSONObject.put("server_res_str", b.this.e());
            if (b.this.c() != null && b.this.c().size() > 0) {
                jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) b.this.c()).toString());
            }
            com.bytedance.sdk.component.utils.m.c("AdLogInfoModel", "rd_client_custom_error = ", jSONObject);
            return com.bytedance.sdk.openadsdk.l.c.b.o().h("rd_client_custom_error").a(b.this.a().getDurationSlotType()).c(jSONObject.toString());
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public int b() {
        return this.f573b;
    }

    public ArrayList<Integer> c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public String e() {
        return this.a;
    }

    public void a(int i) {
        this.f573b = i;
    }

    public void b(int i) {
        this.c = i;
    }

    public AdSlot a() {
        return this.e;
    }

    public void a(AdSlot adSlot) {
        this.e = adSlot;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.d = arrayList;
    }

    public static void a(b bVar) {
        int iB;
        if (bVar == null || bVar.a() == null || (iB = bVar.b()) >= 0 || iB == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.b.a();
        com.bytedance.sdk.openadsdk.l.b.a("rd_client_custom_error", false, (com.bytedance.sdk.openadsdk.l.a) bVar.new a());
    }
}
