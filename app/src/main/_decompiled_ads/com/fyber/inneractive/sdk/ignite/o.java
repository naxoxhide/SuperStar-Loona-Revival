package com.fyber.inneractive.sdk.ignite;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.network.j0;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o extends IIgniteServiceCallback.Stub {
    public final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.a f945b;

    public o(n nVar, g.a aVar) {
        this.a = nVar;
        this.f945b = aVar;
    }

    public final String a(String str) {
        try {
            return new JSONObject(str).optString("taskId");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public void onError(String str) {
        String strOptString;
        IAlog.a("InstallCallback onError %s", str);
        if (this.a != null) {
            String strA = a(str);
            String strOptString2 = null;
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("data");
                strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("message") : null;
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObjectOptJSONObject2 = new JSONObject(str).optJSONObject("data");
                if (jSONObjectOptJSONObject2 != null) {
                    strOptString2 = jSONObjectOptJSONObject2.optString("code");
                }
            } catch (Exception unused2) {
            }
            this.a.b(strA, strOptString, strOptString2);
        }
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public void onProgress(String str) {
        JSONObject jSONObjectOptJSONObject;
        IAlog.a("InstallCallback onProgress %s", str);
        try {
            String strA = a(str);
            JSONObject jSONObjectOptJSONObject2 = new JSONObject(str).optJSONObject("data");
            if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(NotificationCompat.CATEGORY_PROGRESS)) == null) {
                return;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("action");
            double dOptDouble = jSONObjectOptJSONObject.optDouble("value");
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(strA, iOptInt, dOptDouble);
            }
        } catch (Exception unused) {
            IAlog.a("Failed to resolve progress data", new Object[0]);
        }
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public void onScheduled(String str) {
        String strOptString;
        IAlog.a("InstallCallback onScheduled %s", str);
        try {
            String strA = a(str);
            try {
                strOptString = new JSONObject(str).getJSONObject("application").optString("packageName");
            } catch (Exception unused) {
                strOptString = null;
            }
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(strA, strOptString);
            }
        } catch (Exception unused2) {
            IAlog.a("Failed to resolve taskId", new Object[0]);
        }
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public void onStart(String str) {
        IAlog.a("InstallCallback onStart %s", str);
        if (this.a != null) {
            this.a.a(a(str));
        }
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public void onSuccess(String str) {
        IAlog.a("InstallCallback onSuccess %s", str);
        if (this.a != null) {
            this.a.c(a(str));
            g.a aVar = this.f945b;
            if (aVar != null) {
                c.b bVar = (c.b) aVar;
                c cVar = c.this;
                String str2 = bVar.a.a;
                cVar.getClass();
                if (!TextUtils.isEmpty(str2)) {
                    j0 j0Var = new j0(new f(cVar, str2), str2, x.a().b());
                    IAConfigManager.M.s.a.offer(j0Var);
                    j0Var.a(q0.QUEUED);
                }
                c.d dVar = bVar.a;
                p<?> pVar = dVar.f943b;
                k kVar = dVar.c;
                j jVar = pVar.h;
                r rVar = r.IGNITE_FLOW_INSTALL_DONE;
                if (kVar == null) {
                    kVar = k.SINGLE_TAP;
                }
                ((p.a) jVar).a(rVar, kVar);
            }
        }
    }
}
