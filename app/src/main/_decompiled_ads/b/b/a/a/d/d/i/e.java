package b.b.a.a.d.d.i;

import android.text.TextUtils;
import b.b.a.a.d.f.m;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DynamicLayoutInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static HashMap<String, String> g;
    private JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f99b;
    private b.b.a.a.d.d.h.c c;
    private a d;
    private b e;
    private b.b.a.a.d.d.h.d f;

    /* JADX INFO: compiled from: DynamicLayoutInflater.java */
    static class a {
        float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f100b;
        boolean c;

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                aVar.a = (float) jSONObject.optDouble("width");
                aVar.f100b = (float) jSONObject.optDouble("height");
                aVar.c = jSONObject.optBoolean("isLandscape");
            }
            return aVar;
        }
    }

    static {
        HashMap<String, String> map = new HashMap<>();
        g = map;
        map.put("subtitle", "description");
        g.put("source", "source|app.app_name");
        g.put("screenshot", "dynamic_creative.screenshot");
    }

    public e(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.a = jSONObject;
        this.f99b = jSONObject2;
        this.c = new b.b.a.a.d.d.h.c(jSONObject2);
        this.d = a.a(jSONObject3);
        this.f = b.b.a.a.d.d.h.d.a(jSONObject4);
    }

    public b.b.a.a.d.d.h.h a(double d, int i, double d2, String str, m mVar) {
        JSONObject jSONObject;
        this.c.a();
        try {
            jSONObject = new JSONObject(this.f.f86b);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        b.b.a.a.d.d.h.h hVarA = a(c.a(this.a, jSONObject), (b.b.a.a.d.d.h.h) null);
        a(hVarA);
        d dVar = new d(d, i, d2, str, mVar);
        d.a aVar = new d.a();
        a aVar2 = this.d;
        aVar.a = aVar2.a;
        aVar.f98b = aVar2.f100b;
        dVar.a(aVar);
        dVar.a(hVarA, 0.0f, 0.0f);
        dVar.a();
        b.b.a.a.d.d.h.b bVar = dVar.f97b;
        if (bVar.d == 65536.0f) {
            return null;
        }
        return bVar.f;
    }

    private void a(b.b.a.a.d.d.h.h hVar) {
        if (hVar == null) {
            return;
        }
        int iC = b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), b.b.a.a.d.g.d.d(b.b.a.a.d.c.a()));
        a aVar = this.d;
        float fMin = aVar.c ? aVar.a : Math.min(aVar.a, iC);
        if (this.d.f100b == 0.0f) {
            hVar.e(fMin);
            hVar.n().g().o(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            hVar.a(0.0f);
        } else {
            hVar.e(fMin);
            int iC2 = b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), b.b.a.a.d.g.d.c(b.b.a.a.d.c.a()));
            a aVar2 = this.d;
            hVar.a(aVar2.c ? aVar2.f100b : Math.min(aVar2.f100b, iC2));
            hVar.n().g().o("fixed");
        }
    }

    public b.b.a.a.d.d.h.h a(JSONObject jSONObject, b.b.a.a.d.d.h.h hVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            b.b.a.a.d.d.h.d dVar = this.f;
            if (dVar != null) {
                b bVar = new b();
                this.e = bVar;
                JSONObject jSONObjectA = bVar.a(dVar.a, iOptInt, jSONObject);
                if (jSONObjectA != null) {
                    jSONObject = jSONObjectA;
                }
            }
        }
        b.b.a.a.d.d.h.h hVarA = a(jSONObject);
        hVarA.a(hVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            hVarA.b((List<b.b.a.a.d.d.h.h>) null);
            return hVarA;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = hVarA.n().g().j0();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    b.b.a.a.d.d.h.h hVarA2 = a(jSONArrayOptJSONArray2.optJSONObject(i2), hVarA);
                    if (b.b.a.a.d.c.c() && "skip-with-time".equals(hVarA.n().f()) && !TJAdUnitConstants.String.TRANSPARENT.equals(hVarA.m()) && !TextUtils.isEmpty(hVarA.m())) {
                        hVarA2.c(hVarA.m());
                    }
                    arrayList.add(hVarA2);
                    arrayList3.add(hVarA2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            hVarA.b(arrayList);
        }
        if (arrayList2.size() > 0) {
            hVarA.a(arrayList2);
        }
        return hVarA;
    }

    public b.b.a.a.d.d.h.h a(JSONObject jSONObject) {
        String strA;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        h.a(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectA = h.a(strOptString, h.a(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        b.b.a.a.d.d.h.h hVar = new b.b.a.a.d.d.h.h();
        if (TextUtils.isEmpty(strOptString2)) {
            hVar.b(String.valueOf(hVar.hashCode()));
        } else {
            hVar.b(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            hVar.f((float) jSONObjectOptJSONObject.optDouble("x"));
            hVar.g((float) jSONObjectOptJSONObject.optDouble("y"));
            hVar.e((float) jSONObjectOptJSONObject.optDouble("width"));
            hVar.a((float) jSONObjectOptJSONObject.optDouble("height"));
            hVar.b(jSONObjectOptJSONObject.optInt("remainWidth"));
            b.b.a.a.d.d.h.e eVar = new b.b.a.a.d.d.h.e();
            eVar.c(strOptString);
            eVar.a(jSONObjectOptJSONObject.optString("data"));
            eVar.b(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            b.b.a.a.d.d.h.f fVarA = b.b.a.a.d.d.h.f.a(jSONObjectOptJSONObject);
            eVar.b(fVarA);
            b.b.a.a.d.d.h.f fVarA2 = b.b.a.a.d.d.h.f.a(jSONObjectA);
            if (fVarA2 == null) {
                eVar.a(fVarA);
            } else {
                eVar.a(fVarA2);
            }
            a(fVarA);
            a(fVarA2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.f99b) != null) {
                a(eVar, jSONObject2.optInt("image_mode"));
            }
            String strF = eVar.f();
            b.b.a.a.d.d.h.f fVarG = eVar.g();
            if (g.containsKey(strF) && !fVarG.u0()) {
                fVarG.l(g.get(strF));
            }
            if (fVarG.u0()) {
                strA = eVar.a();
            } else {
                strA = a(eVar.a());
            }
            if (b.b.a.a.d.c.c()) {
                if (TextUtils.equals(strF, "star") || TextUtils.equals(strF, "text_star")) {
                    strA = a("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(strF, "score-count") || TextUtils.equals(strF, "score-count-type-1") || TextUtils.equals(strF, "score-count-type-2")) {
                    strA = a("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(strF) && fVarA.f()) {
                    strA = a("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(a()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                eVar.a(strA + "adx:" + a());
            } else {
                eVar.a(strA);
            }
            hVar.a(eVar);
        }
        return hVar;
    }

    private void a(b.b.a.a.d.d.h.e eVar, int i) {
        int iLastIndexOf;
        if (i != 5 && i != 15 && i != 50 && i != 154) {
            eVar.c("image");
            String strB = h.b("image");
            eVar.g().l(strB);
            eVar.d().l(strB);
            String strA = h.a("image", "clickArea");
            if (!TextUtils.isEmpty(strA)) {
                eVar.g().i(strA);
                eVar.d().i(strA);
            }
            eVar.a(strB);
            if (strB != null && (iLastIndexOf = strB.lastIndexOf(".")) > 0) {
                String strSubstring = strB.substring(0, iLastIndexOf);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", a(strSubstring + ".width"));
                    jSONObject.put("height", a(strSubstring + ".height"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                eVar.b(jSONObject.toString());
            }
            eVar.g().D0();
            return;
        }
        eVar.c("video");
        String strB2 = h.b("video");
        eVar.g().l(strB2);
        String strA2 = h.a("video", "clickArea");
        if (!TextUtils.isEmpty(strA2)) {
            eVar.g().i(strA2);
            eVar.d().i(strA2);
        }
        eVar.d().l(strB2);
        eVar.a(strB2);
        eVar.g().E0();
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.c.b(str2)) {
                String strValueOf = String.valueOf(this.c.a(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String a() {
        b.b.a.a.d.d.h.c cVar = this.c;
        return cVar == null ? "" : String.valueOf(cVar.a("adx_name"));
    }

    private void a(b.b.a.a.d.d.h.f fVar) {
        if (fVar == null) {
            return;
        }
        String strK = fVar.K();
        if (b.b.a.a.d.c.c()) {
            String strB = b.b.a.a.d.g.d.b(b.b.a.a.d.c.a());
            if ("zh".equals(strB)) {
                strB = "cn";
            }
            if (!TextUtils.isEmpty(strB) && fVar.H() != null) {
                String strOptString = fVar.H().optString(strB);
                if (!TextUtils.isEmpty(strOptString)) {
                    strK = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        int iIndexOf = strK.indexOf("{{");
        int iIndexOf2 = strK.indexOf("}}");
        if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf2 >= iIndexOf) {
            String strA = a(strK.substring(iIndexOf + 2, iIndexOf2));
            StringBuilder sb = new StringBuilder(strK.substring(0, iIndexOf));
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
            }
            sb.append(strK.substring(iIndexOf2 + 2));
            fVar.r(sb.toString());
            return;
        }
        fVar.r(strK);
    }
}
