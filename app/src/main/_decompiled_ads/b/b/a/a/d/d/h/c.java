package b.b.a.a.d.d.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DynamicCreative.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private HashMap<String, Object> a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f85b;

    public c(JSONObject jSONObject) {
        this.f85b = jSONObject;
    }

    public Object a(String str) {
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        return null;
    }

    public boolean b(String str) {
        return this.a.containsKey(str);
    }

    public void a() {
        Iterator<String> itKeys = this.f85b.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.f85b.opt(next);
            int i = 0;
            if (TextUtils.equals("image", next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    this.a.put(next + "." + i + "." + next2, jSONObjectOptJSONObject.opt(next2));
                                }
                            }
                            i++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (objOpt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) objOpt);
                        Iterator<String> itKeys3 = jSONObject.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            Object objOpt2 = jSONObject.opt(next3);
                            if ((objOpt2 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i2 = 0; i2 < ((JSONArray) objOpt2).length(); i2++) {
                                    this.a.put(next + "." + next3 + "." + i2, ((JSONArray) objOpt2).opt(i2));
                                }
                            } else {
                                this.a.put(next + "." + next3, objOpt2);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.a.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.a.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys4 = jSONObject2.keys();
                while (itKeys4.hasNext()) {
                    String next4 = itKeys4.next();
                    this.a.put(next + "." + next4, jSONObject2.opt(next4));
                }
            }
        }
    }
}
