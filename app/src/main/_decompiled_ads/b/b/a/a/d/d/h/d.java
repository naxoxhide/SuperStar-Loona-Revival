package b.b.a.a.d.d.h;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DynamicDiffPlugin.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public List<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f86b;

    /* JADX INFO: compiled from: DynamicDiffPlugin.java */
    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f87b;
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    a aVar = new a();
                    aVar.a = jSONObjectOptJSONObject.optInt("id");
                    aVar.f87b = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(aVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dVar.a = arrayList;
        dVar.f86b = jSONObject.optString("diff_data");
        jSONObject.optString("style_diff");
        jSONObject.optString("tag_diff");
        return dVar;
    }
}
