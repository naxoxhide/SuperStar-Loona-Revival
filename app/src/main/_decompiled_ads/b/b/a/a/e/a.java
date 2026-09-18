package b.b.a.a.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractBridge.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    protected Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected m f127b;
    protected String d;
    g f;
    protected Handler c = new Handler(Looper.getMainLooper());
    protected volatile boolean e = false;
    private final Map<String, g> g = new HashMap();

    /* JADX INFO: renamed from: b.b.a.a.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractBridge.java */
    class RunnableC0029a implements Runnable {
        final /* synthetic */ String a;

        RunnableC0029a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e) {
                return;
            }
            q qVarA = null;
            try {
                qVarA = a.this.a(new JSONObject(this.a));
            } catch (JSONException e) {
                i.a("Exception thrown while parsing function.", e);
            }
            if (!q.a(qVarA)) {
                a.this.a(qVarA);
                return;
            }
            i.a("By pass invalid call: " + qVarA);
            if (qVarA != null) {
                a.this.a(y.a(new s(qVarA.a, "Failed to parse invocation.")), qVarA);
            }
        }
    }

    protected a() {
    }

    protected abstract Context a(j jVar);

    protected abstract String a();

    protected abstract void b(j jVar);

    protected abstract void b(String str);

    protected void b(String str, q qVar) {
        b(str);
    }

    protected void invokeMethod(String str) {
        if (this.e) {
            return;
        }
        i.a("Received call: " + str);
        this.c.post(new RunnableC0029a(str));
    }

    protected final void a(q qVar) {
        String strA;
        if (this.e || (strA = a()) == null) {
            return;
        }
        g gVarA = a(qVar.g);
        if (gVarA == null) {
            i.b("Received call with unknown namespace, " + qVar);
            m mVar = this.f127b;
            if (mVar != null) {
                mVar.a(a(), qVar.d, 2);
            }
            a(y.a(new s(-4, "Namespace " + qVar.g + " unknown.")), qVar);
            return;
        }
        f fVar = new f();
        fVar.f131b = strA;
        fVar.a = this.a;
        try {
            g.c cVarA = gVarA.a(qVar, fVar);
            if (cVarA == null) {
                i.b("Received call but not registered, " + qVar);
                m mVar2 = this.f127b;
                if (mVar2 != null) {
                    mVar2.a(a(), qVar.d, 2);
                }
                a(y.a(new s(-2, "Function " + qVar.d + " is not registered.")), qVar);
                return;
            }
            if (cVarA.a) {
                a(cVarA.f134b, qVar);
            }
            m mVar3 = this.f127b;
            if (mVar3 != null) {
                mVar3.a(a(), qVar.d);
            }
        } catch (Exception e) {
            i.b("call finished with error, " + qVar, e);
            a(y.a(e), qVar);
        }
    }

    protected void b() {
        this.f.a();
        Iterator<g> it = this.g.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.c.removeCallbacksAndMessages(null);
        this.e = true;
    }

    final void a(j jVar, v vVar) {
        this.a = a(jVar);
        h hVar = jVar.d;
        this.f127b = jVar.i;
        this.f = new g(jVar, this, vVar);
        this.d = jVar.k;
        b(jVar);
    }

    final void a(String str, q qVar) {
        JSONObject jSONObject;
        if (this.e) {
            return;
        }
        if (TextUtils.isEmpty(qVar.f)) {
            i.a("By passing js callback due to empty callback: " + str);
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Illegal callback data: " + str));
        }
        i.a("Invoking js callback: " + qVar.f);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        b(p.a().a("__msg_type", "callback").a("__callback_id", qVar.f).a("__params", jSONObject).b(), qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q a(JSONObject jSONObject) {
        String strOptString = "params";
        if (this.e) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        String strA = a();
        if (strA == null) {
            m mVar = this.f127b;
            if (mVar != null) {
                mVar.a(null, null, 3);
            }
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = "";
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else if (objOpt instanceof String) {
                    strOptString = (String) objOpt;
                } else {
                    strOptString = String.valueOf(objOpt);
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString(strOptString);
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return q.a().g(string2).f(string).c(strOptString3).e(strOptString).a(strOptString2).d(strOptString4).b(jSONObject.optString("__iframe_url")).a();
        } catch (JSONException e) {
            i.a("Failed to create call.", e);
            m mVar2 = this.f127b;
            if (mVar2 != null) {
                mVar2.a(strA, strOptString3, 1);
            }
            return q.a(strOptString2, -1);
        }
    }

    private g a(String str) {
        if (!TextUtils.equals(str, this.d) && !TextUtils.isEmpty(str)) {
            return this.g.get(str);
        }
        return this.f;
    }
}
