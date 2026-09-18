package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingRequestController.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final String a = "e";

    public final void a(final Context context, final String str, final String str2) {
        if (context == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
        dVar.a("app_id", str);
        dVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            String strAL = d.a().g(str).aL();
            if (TextUtils.isEmpty(strAL)) {
                strAL = "";
            }
            dVar.a("vtag", strAL);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
        if (com.mbridge.msdk.foundation.same.net.f.d.a().O) {
            dVar.a("st_net", com.mbridge.msdk.foundation.same.net.f.d.a().q + "");
        }
        com.mbridge.msdk.foundation.same.net.g.c cVar = new com.mbridge.msdk.foundation.same.net.g.c() { // from class: com.mbridge.msdk.c.e.1
            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(JSONObject jSONObject) {
                try {
                    String strB = e.this.b();
                    int i = com.mbridge.msdk.foundation.same.net.f.d.a().q;
                    if (af.a(jSONObject)) {
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String strC = d.a().c(str);
                            if (!TextUtils.isEmpty(strC)) {
                                try {
                                    jSONObject = d.a().a(new JSONObject(strC), jSONObject);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        jSONObject.put("current_time", System.currentTimeMillis());
                        if (com.mbridge.msdk.foundation.same.net.f.d.a().p) {
                            if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                                jSONObject.put("hst_st_t", com.mbridge.msdk.foundation.same.net.f.d.a().f);
                            }
                        } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                            jSONObject.put("hst_st", com.mbridge.msdk.foundation.same.net.f.d.a().e);
                        }
                        d.a().b(str, jSONObject.toString());
                        com.mbridge.msdk.foundation.same.net.f.d.a().c();
                        if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                            com.mbridge.msdk.c.b.a.a().a(context, jSONObject.optString("mraid_js"));
                        }
                        if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                            com.mbridge.msdk.c.b.b.a().a(context, jSONObject.optString("web_env_url"));
                        }
                        e.a(e.this, context, str);
                    } else {
                        d.a().f(str);
                    }
                    e.a(e.this, 1, i, "", strB);
                    e.b(e.this);
                } catch (Exception e2) {
                    aa.d(e.a, e2.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(String str3) {
                e.a(e.this, 2, com.mbridge.msdk.foundation.same.net.f.d.a().q, str3, e.this.b());
                if (!com.mbridge.msdk.foundation.same.net.f.d.a().p) {
                    com.mbridge.msdk.foundation.same.net.f.d.a().M++;
                } else {
                    com.mbridge.msdk.foundation.same.net.f.d.a().N++;
                }
                e.this.b(context, str, str2);
                e.b(e.this);
                aa.d(e.a, "get app setting error" + str3);
            }
        };
        com.mbridge.msdk.c.a.c cVar2 = new com.mbridge.msdk.c.a.c(context);
        String str3 = com.mbridge.msdk.foundation.same.net.f.d.a().x;
        try {
            if (com.mbridge.msdk.foundation.same.net.f.d.a().p && com.mbridge.msdk.foundation.same.net.f.d.a().O && com.mbridge.msdk.foundation.same.net.f.d.a().N < com.mbridge.msdk.foundation.same.net.f.d.a().Q.size()) {
                String str4 = com.mbridge.msdk.foundation.same.net.f.d.a().Q.get(com.mbridge.msdk.foundation.same.net.f.d.a().N);
                if (!TextUtils.isEmpty(str4) && (str4.startsWith(ProxyConfig.MATCH_HTTP) || str4.startsWith("https"))) {
                    str3 = str4 + "/setting";
                }
            }
        } catch (Throwable th2) {
            aa.d(a, th2.getMessage());
        }
        cVar2.get(1, str3, dVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, final String str, final String str2) {
        if (!(!com.mbridge.msdk.foundation.same.net.f.d.a().d())) {
            a(context, str, str2);
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.same.net.f.d.a().O) {
                return;
            }
            com.mbridge.msdk.foundation.same.net.f.d.a().O = true;
            if (System.currentTimeMillis() >= com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts").longValue() + 86400000) {
                String strB = com.mbridge.msdk.foundation.a.a.a.a().b("mkey_spare_host");
                if (!TextUtils.isEmpty(strB)) {
                    for (String str3 : strB.split("\n")) {
                        if (!TextUtils.isEmpty(str3.trim()) && !com.mbridge.msdk.foundation.same.net.f.d.a().P.contains(str3.trim())) {
                            com.mbridge.msdk.foundation.same.net.f.d.a().P.add(str3.trim());
                            com.mbridge.msdk.foundation.same.net.f.d.a().Q.add(str3.trim());
                        }
                    }
                    b(context, str, str2);
                    return;
                }
            }
            new com.mbridge.msdk.foundation.same.net.g.b(context.getApplicationContext()).get(0, com.mbridge.msdk.foundation.same.net.f.d.a().L, new com.mbridge.msdk.foundation.same.net.g.d(), new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.c.e.2
                @Override // com.mbridge.msdk.foundation.same.net.b.a
                public final void a(String str4) {
                    aa.a(e.a, "fetch CNDSettingHost success, content = " + str4);
                    if (TextUtils.isEmpty(str4)) {
                        return;
                    }
                    com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts", System.currentTimeMillis());
                    com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host", str4);
                    for (String str5 : str4.split("\n")) {
                        if (!TextUtils.isEmpty(str5.trim()) && !com.mbridge.msdk.foundation.same.net.f.d.a().P.contains(str5.trim())) {
                            com.mbridge.msdk.foundation.same.net.f.d.a().P.add(str5.trim());
                            com.mbridge.msdk.foundation.same.net.f.d.a().Q.add(str5.trim());
                        }
                    }
                    e.this.b(context, str, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.net.b.a
                public final void b(String str4) {
                    com.mbridge.msdk.foundation.same.net.f.d.a().O = false;
                    aa.a(e.a, "fetch CNDSettingHost failed, errorCode = " + str4);
                }
            });
        } catch (Throwable th) {
            com.mbridge.msdk.foundation.same.net.f.d.a().O = false;
            aa.d(a, th.getMessage());
        }
    }

    public final void a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = com.mbridge.msdk.foundation.controller.b.d().h();
            str2 = com.mbridge.msdk.foundation.controller.b.d().j();
        }
        if (d.a().a(str3, str) && d.a().a(str, 2, str3)) {
            com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
            String str4 = "[" + str3 + "]";
            dVar.a("unit_ids", str4);
            dVar.a("app_id", str);
            dVar.a("sign", SameMD5.getMD5(str + str2));
            try {
                String strY = d.a().c(str, str4).y();
                if (TextUtils.isEmpty(strY)) {
                    strY = "";
                }
                dVar.a("vtag", strY);
            } catch (Throwable th) {
                aa.d(a, th.getMessage());
            }
            new com.mbridge.msdk.c.a.c(context).get(1, com.mbridge.msdk.foundation.same.net.f.d.a().x, dVar, new com.mbridge.msdk.foundation.same.net.g.c() { // from class: com.mbridge.msdk.c.e.3
                @Override // com.mbridge.msdk.foundation.same.net.g.c
                public final void a(JSONObject jSONObject) {
                    try {
                        if (af.a(jSONObject)) {
                            String strOptString = jSONObject.optString("vtag", "");
                            String strOptString2 = jSONObject.optString("rid", "");
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                                if (jSONObject.optInt("vtag_status", 0) == 1) {
                                    d.a();
                                    String strB = com.mbridge.msdk.foundation.a.a.a.a().b(str + "_" + str3);
                                    if (!TextUtils.isEmpty(strB)) {
                                        try {
                                            jSONObjectOptJSONObject = d.a().a(new JSONObject(strB), jSONObjectOptJSONObject);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                jSONObjectOptJSONObject.put("current_time", System.currentTimeMillis());
                                jSONObjectOptJSONObject.put("vtag", strOptString);
                                jSONObjectOptJSONObject.put("rid", strOptString2);
                                d.a().a(str, str3, jSONObjectOptJSONObject.toString());
                            }
                        } else {
                            d.a().g(str, str3);
                        }
                        e.a(e.this, 1, "");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.net.g.c
                public final void a(String str5) {
                    e.a(e.this, 2, str5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        String str = com.mbridge.msdk.foundation.same.net.f.d.a().p ? com.mbridge.msdk.foundation.same.net.f.d.a().C : com.mbridge.msdk.foundation.same.net.f.d.a().x;
        try {
            if (!com.mbridge.msdk.foundation.same.net.f.d.a().p || !com.mbridge.msdk.foundation.same.net.f.d.a().O || com.mbridge.msdk.foundation.same.net.f.d.a().N >= com.mbridge.msdk.foundation.same.net.f.d.a().Q.size()) {
                return str;
            }
            String str2 = com.mbridge.msdk.foundation.same.net.f.d.a().Q.get(com.mbridge.msdk.foundation.same.net.f.d.a().N);
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return (str2.startsWith(ProxyConfig.MATCH_HTTP) || str2.startsWith("https")) ? str2 + "/setting" : str;
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
            return str;
        }
    }

    static /* synthetic */ void a(e eVar, Context context, String str) {
        c cVarB;
        d dVarA = d.a();
        if (dVarA != null && (cVarB = dVarA.b(str)) != null) {
            MBridgeConstans.OMID_JS_SERVICE_URL = cVarB.ax();
            MBridgeConstans.OMID_JS_H5_URL = cVarB.aw();
        }
        com.mbridge.msdk.a.b.a(context);
        com.mbridge.msdk.a.b.b(context);
    }

    static /* synthetic */ void a(e eVar, int i, int i2, String str, String str2) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(i, i2, 0, str, str2);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    static /* synthetic */ void b(e eVar) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a();
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    static /* synthetic */ void a(e eVar, int i, String str) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(i, com.mbridge.msdk.foundation.same.net.f.d.a().q, 1, str, com.mbridge.msdk.foundation.same.net.f.d.a().p ? com.mbridge.msdk.foundation.same.net.f.d.a().C : com.mbridge.msdk.foundation.same.net.f.d.a().x);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }
}
