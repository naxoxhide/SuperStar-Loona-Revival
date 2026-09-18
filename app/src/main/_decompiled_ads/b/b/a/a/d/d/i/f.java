package b.b.a.a.d.d.i;

import b.b.a.a.d.f.m;
import org.json.JSONObject;

/* JADX INFO: compiled from: DynamicNativeParser.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements g {
    private b.b.a.a.d.d.j.b a;

    /* JADX INFO: compiled from: DynamicNativeParser.java */
    class a implements Runnable {
        final /* synthetic */ m a;

        a(m mVar) {
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.utils.m.a("DynamicNativeParser", "parse on non ui thread");
            f.this.b(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        try {
            JSONObject jSONObjectQ = mVar.q();
            JSONObject jSONObject = new JSONObject(jSONObjectQ.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectQ.optJSONObject("creative");
            b.b.a.a.d.d.h.h hVarA = new e(jSONObject, jSONObjectOptJSONObject, jSONObjectQ.optJSONObject("AdSize"), new JSONObject(jSONObjectQ.optString("diff_template_Plugin"))).a(mVar.h(), mVar.l(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), mVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                hVarA.a(jSONObject2.optString("color"));
                hVarA.a(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.a.a(hVarA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // b.b.a.a.d.d.i.g
    public void a(b.b.a.a.d.d.j.b bVar) {
        this.a = bVar;
    }

    @Override // b.b.a.a.d.d.i.g
    public void a(m mVar) {
        if (mVar.p() == 1) {
            com.bytedance.sdk.component.utils.m.a("DynamicNativeParser", "parse on ui thread");
            b(mVar);
        } else {
            b.b.a.a.k.e.d().execute(new a(mVar));
        }
    }
}
