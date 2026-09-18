package b.b.a.a.d.e.c;

import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TempPkgModel.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f107b;
    private String c;
    private List<C0027a> d;
    private b e;

    /* JADX INFO: renamed from: b.b.a.a.d.e.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TempPkgModel.java */
    public static class C0027a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f108b;
        private int c;

        public void a(String str) {
            this.f108b = str;
        }

        public void b(String str) {
            this.a = str;
        }

        public String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0027a)) {
                return super.equals(obj);
            }
            String str = this.a;
            return str != null && str.equals(((C0027a) obj).c());
        }

        public int a() {
            return this.c;
        }

        public String b() {
            return this.f108b;
        }

        public void a(int i) {
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: TempPkgModel.java */
    public static class b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f109b;
        private List<Pair<String, String>> c;

        public void a(String str) {
            this.f109b = str;
        }

        public String b() {
            return this.a;
        }

        public void a(List<Pair<String, String>> list) {
            this.c = list;
        }

        public void b(String str) {
            this.a = str;
        }

        public List<Pair<String, String>> a() {
            return this.c;
        }
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.a;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.f107b = str;
    }

    public String e() {
        return this.f107b;
    }

    public boolean f() {
        return (TextUtils.isEmpty(a()) || TextUtils.isEmpty(e()) || TextUtils.isEmpty(b())) ? false : true;
    }

    public String g() {
        if (!f()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", b());
            jSONObject.putOpt("version", e());
            jSONObject.putOpt("main", a());
            JSONArray jSONArray = new JSONArray();
            if (d() != null) {
                for (C0027a c0027a : d()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0027a.c());
                    jSONObject2.putOpt("md5", c0027a.b());
                    jSONObject2.putOpt("level", Integer.valueOf(c0027a.a()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            b bVarC = c();
            if (bVarC != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", bVarC.a);
                jSONObject3.put("md5", bVarC.f109b);
                JSONObject jSONObject4 = new JSONObject();
                List<Pair<String, String>> listA = bVarC.a();
                if (listA != null) {
                    for (Pair<String, String> pair : listA) {
                        jSONObject4.put((String) pair.first, pair.second);
                    }
                }
                jSONObject3.put("map", jSONObject4);
                jSONObject.putOpt("resources_archive", jSONObject3);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void b(String str) {
        this.c = str;
    }

    public b c() {
        return this.e;
    }

    public List<C0027a> d() {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        return this.d;
    }

    public void a(List<C0027a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.d = list;
    }

    public static a a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static a a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.c(jSONObject.optString("name"));
        aVar.d(jSONObject.optString("version"));
        aVar.b(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0027a c0027a = new C0027a();
                c0027a.b(jSONObjectOptJSONObject2.optString("url"));
                c0027a.a(jSONObjectOptJSONObject2.optString("md5"));
                c0027a.a(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0027a);
            }
        }
        aVar.a(arrayList);
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            b bVar = new b();
            bVar.b(jSONObjectOptJSONObject.optString("url"));
            bVar.a(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    arrayList2.add(new Pair<>(next, jSONObjectOptJSONObject3.optString(next)));
                }
                bVar.a(arrayList2);
            }
            aVar.a(bVar);
        }
        if (aVar.f()) {
            return aVar;
        }
        return null;
    }
}
