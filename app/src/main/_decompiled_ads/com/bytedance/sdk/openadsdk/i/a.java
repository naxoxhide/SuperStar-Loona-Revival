package com.bytedance.sdk.openadsdk.i;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsAppAdDownloadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements c {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f775b;
    private final Map<String, b.c.a.a.a.a.c> c = new HashMap();

    private a(b bVar, q qVar) {
        this.f775b = bVar;
        this.a = qVar;
    }

    public static a a(b bVar, q qVar) {
        return new a(bVar, qVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.c
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.i.c
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.i.c
    public void b(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.c
    public void onDestroy() {
        this.c.clear();
    }

    private q a(JSONObject jSONObject, String str) {
        String strD;
        if (jSONObject == null) {
            return null;
        }
        q qVarL1 = q.l1();
        qVarL1.a(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            qVarL1.r(str);
        }
        if (this.a == null) {
            return qVarL1;
        }
        String strD2 = qVarL1.h() != null ? qVarL1.h().d() : null;
        if (TextUtils.isEmpty(strD2)) {
            return this.a;
        }
        com.bytedance.sdk.openadsdk.core.f0.c cVarH = this.a.h();
        if (cVarH != null && strD2.equals(cVarH.d())) {
            return this.a;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (cVarH != null) {
            try {
                strD = cVarH.d();
            } catch (JSONException unused) {
            }
        } else {
            strD = "null";
        }
        jSONObject2.put("lu", strD);
        jSONObject2.put("ju", strD2);
        q qVar = this.a;
        com.bytedance.sdk.openadsdk.core.d.a(qVar, a0.a(qVar), -5, jSONObject2);
        if (cVarH != null && strD2.contains("play.google.com/store/apps/details?id=") && !strD2.contains(TapjoyConstants.TJC_REFERRER)) {
            qVarL1.h().b(cVarH.d());
        }
        return qVarL1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.c
    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(jSONObjectOptJSONObject, str), jSONObjectOptJSONObject, i, z);
    }

    private void a(Context context, q qVar, JSONObject jSONObject, int i, boolean z) {
        if (context == null || qVar == null || qVar.h() == null || jSONObject == null || this.f775b == null || this.c.get(qVar.h().d()) != null) {
            return;
        }
        String strC = a0.c(i);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        this.c.put(qVar.h().d(), a(context, qVar, jSONObject, strC, z));
    }

    @Override // com.bytedance.sdk.openadsdk.i.c
    public void a(Context context, JSONObject jSONObject, String str) {
        a(context, this.a, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Context context, q qVar, String str) {
        if (context == 0 || qVar == null) {
            return;
        }
        b.c.a.a.a.a.d.a(context, qVar, str).b();
        if (context instanceof com.bytedance.sdk.openadsdk.core.j0.c.b) {
            ((com.bytedance.sdk.openadsdk.core.j0.c.b) context).d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.c
    public void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(a(jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void a(q qVar, JSONObject jSONObject) {
        if (this.f775b == null || qVar == null || qVar.h() == null) {
            return;
        }
        String strD = qVar.h().d();
        if (this.c.containsKey(strD)) {
            this.c.remove(strD);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                jSONObject2.put("status", "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.f775b.a("app_ad_event", jSONObject2);
            } catch (JSONException e) {
                m.b("JsAppAdDownloadManager", e.getMessage());
            }
        }
    }

    private b.c.a.a.a.a.c a(Context context, q qVar, JSONObject jSONObject, String str, boolean z) {
        b.c.a.a.a.a.c cVarA = b.c.a.a.a.a.d.a(context, qVar, str);
        cVarA.a(true);
        return cVarA;
    }
}
