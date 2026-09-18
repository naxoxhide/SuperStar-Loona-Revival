package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardSettingController.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String a = "com.mbridge.msdk.videocommon.c.a";

    /* JADX WARN: Code duplicated, block: B:8:0x0059 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #0 {all -> 0x0075, blocks: (B:3:0x0024, B:5:0x002b, B:7:0x0054, B:11:0x0061, B:12:0x0065, B:16:0x0071, B:8:0x0059), top: B:22:0x0024 }] */
    public final void a(Context context, final String str, String str2) {
        com.mbridge.msdk.videocommon.d.a aVarA;
        d dVar = new d();
        dVar.a("app_id", str);
        dVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            com.mbridge.msdk.videocommon.d.b.a();
            if (com.mbridge.msdk.videocommon.d.b.a == null) {
                String strB = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + com.mbridge.msdk.foundation.controller.b.d().h());
                if (!TextUtils.isEmpty(strB)) {
                    aVarA = com.mbridge.msdk.videocommon.d.a.a(strB);
                } else {
                    aVarA = com.mbridge.msdk.videocommon.d.b.a;
                }
            } else {
                aVarA = com.mbridge.msdk.videocommon.d.b.a;
            }
            String str3 = "";
            if (aVarA == null) {
                dVar.a("vtag", "");
            } else {
                String strA = aVarA.a();
                if (!TextUtils.isEmpty(strA)) {
                    str3 = strA;
                }
                dVar.a("vtag", str3);
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
        new b(context).get(1, com.mbridge.msdk.foundation.same.net.f.d.a().z, dVar, new com.mbridge.msdk.foundation.same.net.g.c() { // from class: com.mbridge.msdk.videocommon.c.a.1
            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(JSONObject jSONObject) {
                try {
                    if (af.a(jSONObject)) {
                        com.mbridge.msdk.videocommon.d.b.a().a(false);
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            com.mbridge.msdk.videocommon.d.b.a();
                            String strB2 = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + str);
                            if (!TextUtils.isEmpty(strB2)) {
                                try {
                                    jSONObject = com.mbridge.msdk.c.d.a().a(new JSONObject(strB2), jSONObject);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        try {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            com.mbridge.msdk.videocommon.d.b.a().b(str, jSONObject.toString());
                        } catch (JSONException e2) {
                            aa.d(a.a, e2.getMessage());
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b bVarA = com.mbridge.msdk.videocommon.d.b.a();
                        String str4 = str;
                        try {
                            String strB3 = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + str4);
                            if (!TextUtils.isEmpty(strB3)) {
                                JSONObject jSONObject2 = new JSONObject(strB3);
                                jSONObject2.put("current_time", System.currentTimeMillis());
                                bVarA.b(str4, jSONObject2.toString());
                            }
                        } catch (Throwable th2) {
                            aa.d("RewardSettingManager", th2.getMessage());
                        }
                    }
                    a.a(a.this, 1, 2, "");
                } catch (Throwable th3) {
                    aa.d(a.a, th3.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(String str4) {
                com.mbridge.msdk.videocommon.d.b.a().a(false);
                aa.d(a.a, str4);
                a.a(a.this, 2, 2, str4);
            }
        });
    }

    public final void a(Context context, final String str, String str2, String str3, final c cVar) {
        d dVar = new d();
        dVar.a("app_id", str);
        dVar.a("sign", SameMD5.getMD5(str + str2));
        dVar.a("unit_ids", "[" + str3 + "]");
        try {
            com.mbridge.msdk.videocommon.d.c cVarC = com.mbridge.msdk.videocommon.d.b.a().c(str, str3);
            String str4 = "";
            if (cVarC == null) {
                dVar.a("vtag", "");
            } else {
                String strJ = cVarC.j();
                if (!TextUtils.isEmpty(strJ)) {
                    str4 = strJ;
                }
                dVar.a("vtag", str4);
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
        com.mbridge.msdk.foundation.same.net.g.c cVar2 = new com.mbridge.msdk.foundation.same.net.g.c() { // from class: com.mbridge.msdk.videocommon.c.a.2
            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(final JSONObject jSONObject) {
                try {
                    try {
                        com.mbridge.msdk.videocommon.d.b.a().a(this.unitId);
                    } catch (Exception e) {
                        aa.d(a.a, e.getMessage());
                    }
                    if (af.a(jSONObject)) {
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            com.mbridge.msdk.videocommon.d.b.a();
                            String strB = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + str + "_" + this.unitId);
                            if (!TextUtils.isEmpty(strB)) {
                                try {
                                    jSONObject = com.mbridge.msdk.c.d.a().a(new JSONObject(strB), jSONObject);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (com.mbridge.msdk.videocommon.d.b.c(jSONObject.toString())) {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.videocommon.c.a.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.mbridge.msdk.videocommon.d.b.a().a(str, AnonymousClass2.this.unitId, jSONObject.toString());
                                }
                            };
                            com.mbridge.msdk.foundation.controller.c.a();
                            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
                            c cVar3 = cVar;
                            if (cVar3 != null) {
                                cVar3.a("request success");
                            }
                        } else {
                            c cVar4 = cVar;
                            if (cVar4 != null) {
                                cVar4.b("data error");
                            }
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b bVarA = com.mbridge.msdk.videocommon.d.b.a();
                        String str5 = str;
                        String str6 = this.unitId;
                        try {
                            String strB2 = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + str5 + "_" + str6);
                            if (!TextUtils.isEmpty(strB2)) {
                                JSONObject jSONObject2 = new JSONObject(strB2);
                                jSONObject2.put("current_time", System.currentTimeMillis());
                                bVarA.a(str5, str6, jSONObject2.toString());
                            }
                        } catch (Throwable th2) {
                            aa.d("RewardSettingManager", th2.getMessage());
                        }
                    }
                    a.a(a.this, 1, 3, "");
                } catch (Throwable th3) {
                    aa.d(a.a, th3.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.g.c
            public final void a(String str5) {
                try {
                    com.mbridge.msdk.videocommon.d.b.a().a(this.unitId);
                } catch (Exception e) {
                    aa.d(a.a, e.getMessage());
                }
                if (!TextUtils.isEmpty(str5)) {
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.b(str5);
                    }
                } else {
                    c cVar4 = cVar;
                    if (cVar4 != null) {
                        cVar4.b("request error");
                    }
                }
                a.a(a.this, 2, 3, str5);
            }
        };
        cVar2.setUnitId(str3);
        new b(context).get(1, com.mbridge.msdk.foundation.same.net.f.d.a().z, dVar, cVar2);
    }

    static /* synthetic */ void a(a aVar, int i, int i2, String str) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(i, com.mbridge.msdk.foundation.same.net.f.d.a().q, i2, str, com.mbridge.msdk.foundation.same.net.f.d.a().p ? com.mbridge.msdk.foundation.same.net.f.d.a().E : com.mbridge.msdk.foundation.same.net.f.d.a().z);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }
}
