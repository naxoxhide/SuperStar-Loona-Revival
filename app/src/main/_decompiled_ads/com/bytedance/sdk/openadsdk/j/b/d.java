package com.bytedance.sdk.openadsdk.j.b;

import b.b.a.a.e.r;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.x;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InteractiveFinishMethod.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends b.b.a.a.e.e<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<x> f776b;

    public d(x xVar) {
        this.f776b = new WeakReference<>(xVar);
    }

    public static void a(r rVar, x xVar) {
        rVar.a("interactiveFinish", new d(xVar));
    }

    @Override // b.b.a.a.e.e
    public JSONObject a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<x> weakReference = this.f776b;
        if (weakReference != null && weakReference.get() != null) {
            x xVar = this.f776b.get();
            q qVarC = xVar.c();
            try {
                boolean z = true;
                int i = 0;
                if (jSONObject.optInt("finish", 1) != 1) {
                    z = false;
                }
                int iOptInt = jSONObject.optInt("reduce_duration", -1);
                int I = qVarC != null ? qVarC.I() : 0;
                if (iOptInt >= 0 && I >= 0) {
                    iOptInt = Math.min(iOptInt, I);
                } else if (iOptInt < 0) {
                    iOptInt = I >= 0 ? I : 0;
                }
                if (z) {
                    xVar.a(iOptInt);
                } else {
                    i = -1;
                }
                jSONObject2.put("code", i);
                jSONObject2.put("reduce_duration", iOptInt);
            } catch (JSONException e) {
                m.b("InteractiveFinishMethod", e.getMessage());
            }
        }
        return jSONObject2;
    }
}
