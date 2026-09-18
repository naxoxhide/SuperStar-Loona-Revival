package b.b.a.a.j.e;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TNCConfigHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final Object e = new Object();
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f240b = new c();
    private boolean c;
    private int d;

    public d(Context context, boolean z, int i) {
        this.c = true;
        this.a = context;
        this.c = z;
        this.d = i;
    }

    public void a(JSONObject jSONObject) {
        if (!this.c) {
            b.b.a.a.j.f.b.a("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        g.a().a(this.d).i();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (g.a().a(this.d).g() && z && jSONArrayOptJSONArray != null) {
                ArrayList<JSONObject> arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    for (JSONObject jSONObject4 : arrayList) {
                        Iterator<String> itKeys = jSONObject4.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
            if (jSONObjectOptJSONObject == null && jSONObject2 == null) {
                b.b.a.a.j.f.b.b("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
            }
            c cVarB = b(jSONObjectOptJSONObject);
            b.b.a.a.j.f.b.a("TNCConfigHandler", "handleConfigChanged, newConfig: " + (cVarB == null ? "null" : cVarB.toString()));
            if (cVarB == null) {
                synchronized (e) {
                    this.a.getSharedPreferences(g.a().a(this.d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    b.b.a.a.j.f.c.a(this.a, 1, "", this.d);
                }
            } else {
                this.f240b = cVarB;
                String string = jSONObjectOptJSONObject.toString();
                synchronized (e) {
                    this.a.getSharedPreferences(g.a().a(this.d).f(), 0).edit().putString("tnc_config_str", string).apply();
                    b.b.a.a.j.f.c.a(this.a, 1, string, this.d);
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.f240b = new c();
            } finally {
                synchronized (e) {
                    this.a.getSharedPreferences(g.a().a(this.d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    b.b.a.a.j.f.c.a(this.a, 1, "", this.d);
                }
            }
        }
    }

    public void b() {
        if (this.c) {
            String string = this.a.getSharedPreferences(g.a().a(this.d).f(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                b.b.a.a.j.f.b.a("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                c cVarB = b(new JSONObject(string));
                if (cVarB != null) {
                    this.f240b = cVarB;
                }
                b.b.a.a.j.f.b.a("TNCConfigHandler", "loadLocalConfig: " + (cVarB == null ? "null" : cVarB.toString()));
            } catch (Throwable th) {
                th.printStackTrace();
                b.b.a.a.j.f.b.a("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void c() {
        try {
            String strA = b.b.a.a.j.f.c.a(this.a, 1, this.d);
            if (TextUtils.isEmpty(strA)) {
                b.b.a.a.j.f.b.a("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            c cVarB = b(new JSONObject(strA));
            b.b.a.a.j.f.b.a("TNCConfigHandler", "loadLocalConfigForOtherProcess, config: " + (cVarB == null ? "null" : cVarB.toString()));
            if (cVarB != null) {
                this.f240b = cVarB;
            }
        } catch (Throwable th) {
            b.b.a.a.j.f.b.a("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    private c b(JSONObject jSONObject) {
        try {
            c cVar = new c();
            if (jSONObject.has("local_enable")) {
                cVar.a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                cVar.f239b = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                cVar.c = map;
            } else {
                cVar.c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                cVar.d = map2;
            } else {
                cVar.d = null;
            }
            cVar.e = jSONObject.optInt("req_to_cnt", cVar.e);
            cVar.f = jSONObject.optInt("req_to_api_cnt", cVar.f);
            cVar.g = jSONObject.optInt("req_to_ip_cnt", cVar.g);
            cVar.h = jSONObject.optInt("req_err_cnt", cVar.h);
            cVar.i = jSONObject.optInt("req_err_api_cnt", cVar.i);
            cVar.j = jSONObject.optInt("req_err_ip_cnt", cVar.j);
            cVar.k = jSONObject.optInt("update_interval", cVar.k);
            cVar.l = jSONObject.optInt("update_random_range", cVar.l);
            cVar.m = jSONObject.optString("http_code_black", cVar.m);
            return cVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public c a() {
        return this.f240b;
    }
}
