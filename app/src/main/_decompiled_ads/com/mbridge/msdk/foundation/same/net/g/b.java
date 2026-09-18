package com.mbridge.msdk.foundation.same.net.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.share.internal.ShareConstants;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.same.net.m;
import com.mbridge.msdk.foundation.same.net.n;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.out.MBConfiguration;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonAsyncHttpRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static final String TAG = "b";
    protected Context mContext;

    public b(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.b.d().g();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    public void addExtraParams(String str, d dVar) {
        if (dVar != null) {
            dVar.a("open", com.mbridge.msdk.foundation.same.a.v);
            String strA = Aa.a();
            if (strA == null) {
                strA = "";
            }
            dVar.a("channel", strA);
            dVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().e() + "");
            String str2 = dVar.c().get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (str2 != null) {
                String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
                if (!TextUtils.isEmpty(customInfoByUnitId)) {
                    dVar.a("ch_info", customInfoByUnitId);
                }
                com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), str2);
                if (fVarE != null && !TextUtils.isEmpty(fVarE.a())) {
                    dVar.a("u_stid", fVarE.a());
                }
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                dVar.a("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                dVar.a("re_domain", "1");
            }
        }
    }

    public void get(int i, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        get(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, false);
    }

    public void getLoadOrSetting(int i, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        getLoadOrSetting(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, true);
    }

    public void getLoadOrSetting(int i, String str, d dVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar, boolean z) {
        get(i, str, dVar, lVar, eVar, z, false);
    }

    public void getCampaign(int i, String str, d dVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        int iAI;
        d dVar2;
        try {
            com.mbridge.msdk.c.c cVarG = com.mbridge.msdk.c.d.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
            if (TextUtils.isEmpty(str)) {
                iAI = cVarG.aJ();
            } else {
                iAI = cVarG.aI();
            }
            String strA = com.mbridge.msdk.foundation.same.net.f.d.a().a(str, iAI);
            if (lVar == null) {
                lVar = new com.mbridge.msdk.foundation.same.net.b();
            }
            if (iAI < 2) {
                postV5(i, strA, dVar, eVar, lVar, true);
                return;
            }
            if (iAI % 2 == 0) {
                if (dVar == null) {
                    dVar = new d();
                }
                dVar2 = dVar;
                JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
                if (jSONArrayB != null) {
                    String string = jSONArrayB.toString();
                    int iB = com.mbridge.msdk.foundation.same.net.f.d.a().b();
                    if (iB > 0 && string.length() > iB) {
                        post(i, strA, dVar2, lVar, eVar, true, false);
                        return;
                    }
                    dVar2.a(d.e, string);
                }
            } else {
                dVar2 = dVar;
            }
            get(i, strA, dVar2, lVar, eVar, true, true);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0161  */
    /* JADX WARN: Code duplicated, block: B:48:0x0164  */
    /* JADX WARN: Code duplicated, block: B:51:0x0168  */
    /* JADX WARN: Code duplicated, block: B:52:0x016e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0170  */
    /* JADX WARN: Code duplicated, block: B:54:0x017e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0184  */
    /* JADX WARN: Code duplicated, block: B:58:0x018c  */
    /* JADX WARN: Code duplicated, block: B:60:0x019a  */
    /* JADX WARN: Code duplicated, block: B:61:0x019e  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    public void get(int i, String str, d dVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar, boolean z, boolean z2) {
        d dVar2;
        d dVar3;
        String str2;
        com.mbridge.msdk.c.c cVarG;
        i dVar4;
        i fVar;
        if (dVar == null) {
            try {
                dVar2 = new d();
            } catch (Exception e) {
                e = e;
                dVar2 = dVar;
                aa.a(TAG, e.getMessage());
                dVar3 = dVar2;
                if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().e)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(ShareConstants.MEDIA_URI, com.mbridge.msdk.foundation.same.net.f.d.a().f + Uri.parse(str).getPath());
                            jSONObject.put("data", dVar3.a());
                        } catch (Throwable th) {
                            aa.d(TAG, th.getMessage());
                        }
                        m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().f, com.mbridge.msdk.foundation.same.net.f.d.a().n, jSONObject.toString(), true, eVar);
                        return;
                    } catch (Throwable th2) {
                        aa.d(TAG, th2.getMessage());
                    }
                }
                str2 = str + "?" + dVar3.toString();
                cVarG = com.mbridge.msdk.c.d.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
                if (str2.length() < cVarG.n()) {
                }
                if (str2.length() < cVarG.o()) {
                }
                dVar4 = null;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            fVar = new com.mbridge.msdk.foundation.same.net.d.c(0, str2, null, eVar);
                        }
                    } else if (z2) {
                        dVar4 = new com.mbridge.msdk.foundation.same.net.d.d(0, str2, null, eVar, true);
                    } else {
                        fVar = new com.mbridge.msdk.foundation.same.net.d.d(0, str2, null, eVar);
                    }
                    if (dVar4 != null) {
                        dVar4.a(lVar);
                        dVar4.b(dVar4.g());
                        if (z2) {
                            n.a(dVar4);
                        } else {
                            n.b(dVar4);
                        }
                    }
                }
                fVar = new com.mbridge.msdk.foundation.same.net.d.f(0, str2, null, eVar);
                dVar4 = fVar;
                if (dVar4 != null) {
                    dVar4.a(lVar);
                    dVar4.b(dVar4.g());
                    if (z2) {
                        n.a(dVar4);
                    } else {
                        n.b(dVar4);
                    }
                }
            }
        } else {
            dVar2 = dVar;
        }
        try {
            addExtraParams(str, dVar2);
            e.e(dVar2);
            String str3 = dVar2.c().get("sign");
            if (str3 == null) {
                str3 = "";
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            dVar2.a(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis + "");
            dVar2.a("st", SameMD5.getMD5(jCurrentTimeMillis + str3));
            k kVarA = com.mbridge.msdk.foundation.same.net.f.c.a().a(dVar2);
            if (kVarA != null && eVar != null) {
                eVar.onSuccess(kVarA);
                return;
            }
        } catch (Exception e2) {
            e = e2;
            aa.a(TAG, e.getMessage());
        }
        dVar3 = dVar2;
        if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().e) && com.mbridge.msdk.foundation.same.net.f.d.a().p) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ShareConstants.MEDIA_URI, com.mbridge.msdk.foundation.same.net.f.d.a().f + Uri.parse(str).getPath());
            jSONObject2.put("data", dVar3.a());
            m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().f, com.mbridge.msdk.foundation.same.net.f.d.a().n, jSONObject2.toString(), true, eVar);
            return;
        }
        str2 = str + "?" + dVar3.toString();
        cVarG = com.mbridge.msdk.c.d.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
        if (str2.length() < cVarG.n() && str2.contains(com.mbridge.msdk.foundation.same.net.f.d.a().e)) {
            post(i, str, dVar3, lVar, eVar, z2, false);
            return;
        }
        if (str2.length() < cVarG.o() && z) {
            post(i, str, dVar3, lVar, eVar, z2, false);
            return;
        }
        dVar4 = null;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    fVar = new com.mbridge.msdk.foundation.same.net.d.c(0, str2, null, eVar);
                }
            } else if (z2) {
                dVar4 = new com.mbridge.msdk.foundation.same.net.d.d(0, str2, null, eVar, true);
            } else {
                fVar = new com.mbridge.msdk.foundation.same.net.d.d(0, str2, null, eVar);
            }
            if (dVar4 != null) {
                dVar4.a(lVar);
                dVar4.b(dVar4.g());
                if (z2) {
                    n.a(dVar4);
                } else {
                    n.b(dVar4);
                }
            }
        }
        fVar = new com.mbridge.msdk.foundation.same.net.d.f(0, str2, null, eVar);
        dVar4 = fVar;
        if (dVar4 != null) {
            dVar4.a(lVar);
            dVar4.b(dVar4.g());
            if (z2) {
                n.a(dVar4);
            } else {
                n.b(dVar4);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public void get(int i, String str, Map<String, String> map, l lVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        i fVar;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("app_id", com.mbridge.msdk.foundation.controller.b.d().h());
        map.put("sdk_version", MBConfiguration.SDK_VERSION);
        map.put(TapjoyConstants.TJC_PLATFORM, "1");
        String strAsUrlParams = asUrlParams(map);
        if (!TextUtils.isEmpty(strAsUrlParams)) {
            str = str + "?" + strAsUrlParams;
        }
        if (MBridgeConstans.DEBUG) {
            aa.a("AppletsModel", "get wx scheme url = " + str);
        }
        i iVar = null;
        try {
            if (i == 0) {
                fVar = new com.mbridge.msdk.foundation.same.net.d.f(0, str, null, eVar);
            } else {
                if (i != 1) {
                    if (i == 2) {
                        fVar = new com.mbridge.msdk.foundation.same.net.d.c(0, str, null, eVar);
                    }
                    if (iVar != null) {
                        try {
                            iVar.a(lVar);
                            iVar.b(iVar.g());
                            n.b(iVar);
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
                fVar = new com.mbridge.msdk.foundation.same.net.d.d(0, str, null, eVar);
            }
            iVar = fVar;
        } catch (Exception unused2) {
        }
        if (iVar != null) {
            iVar.a(lVar);
            iVar.b(iVar.g());
            n.b(iVar);
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        sb.append("&").append(str).append("=").append(str2);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d(TAG, e.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static void downloadFile(File file, String str, com.mbridge.msdk.foundation.same.net.e eVar) {
        n.a().a(file, str, eVar);
    }

    public void choiceV3OrV5BySetting(int i, d dVar, com.mbridge.msdk.foundation.same.net.e eVar, String str) {
        choiceV3OrV5BySetting(i, dVar, eVar, str, new com.mbridge.msdk.foundation.same.net.b());
    }

    public void choiceV3OrV5BySetting(int i, d dVar, com.mbridge.msdk.foundation.same.net.e eVar, String str, l lVar) {
        int iAI;
        com.mbridge.msdk.c.c cVarG = com.mbridge.msdk.c.d.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
        if (TextUtils.isEmpty(str)) {
            iAI = cVarG.aJ();
        } else {
            iAI = cVarG.aI();
        }
        String strA = com.mbridge.msdk.foundation.same.net.f.d.a().a(str, iAI);
        if (iAI < 2) {
            if (lVar == null) {
                postV5(i, strA, dVar, eVar);
                return;
            } else {
                postV5(i, strA, dVar, eVar, lVar, false);
                return;
            }
        }
        if (iAI % 2 == 0) {
            if (dVar == null) {
                dVar = new d();
            }
            JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
            if (jSONArrayB != null) {
                String string = jSONArrayB.toString();
                int iB = com.mbridge.msdk.foundation.same.net.f.d.a().b();
                if (iB > 0 && string.length() > iB) {
                    post(i, strA, dVar, eVar);
                    return;
                }
                dVar.a(d.e, string);
            }
        }
        d dVar2 = dVar;
        if (lVar == null) {
            getLoadOrSetting(i, strA, dVar2, eVar);
        } else {
            getLoadOrSetting(i, strA, dVar2, lVar, eVar, true);
        }
    }

    public void postV5(int i, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        String str2 = dVar.c().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        dVar.a(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str2));
        post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, false);
    }

    public void postV5(int i, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar, l lVar, boolean z) {
        String str2 = dVar.c().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        dVar.a(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str2));
        if (lVar != null) {
            post(i, str, dVar, lVar, eVar, z, false);
        } else {
            post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, z, false);
        }
    }

    public void post(int i, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, false);
    }

    public void postFocusReport(int i, String str, d dVar, com.mbridge.msdk.foundation.same.net.e eVar) {
        post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, true);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0095  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a0 A[Catch: Exception -> 0x00ef, TRY_ENTER, TryCatch #1 {Exception -> 0x00ef, blocks: (B:35:0x00a0, B:37:0x00a6, B:41:0x00b1, B:48:0x00d4, B:53:0x00f3), top: B:95:0x009e }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a6 A[Catch: Exception -> 0x00ef, TryCatch #1 {Exception -> 0x00ef, blocks: (B:35:0x00a0, B:37:0x00a6, B:41:0x00b1, B:48:0x00d4, B:53:0x00f3), top: B:95:0x009e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00f3 A[Catch: Exception -> 0x00ef, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ef, blocks: (B:35:0x00a0, B:37:0x00a6, B:41:0x00b1, B:48:0x00d4, B:53:0x00f3), top: B:95:0x009e }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0113  */
    /* JADX WARN: Code duplicated, block: B:58:0x011f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0158  */
    /* JADX WARN: Code duplicated, block: B:68:0x0164 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x0166  */
    /* JADX WARN: Code duplicated, block: B:70:0x0182  */
    /* JADX WARN: Code duplicated, block: B:73:0x018d  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ee  */
    private void post(int i, String str, d dVar, l lVar, com.mbridge.msdk.foundation.same.net.e eVar, boolean z, boolean z2) {
        d dVar2;
        d dVar3;
        String str2;
        JSONArray jSONArrayB;
        String str3;
        com.mbridge.msdk.c.c cVarB;
        com.mbridge.msdk.c.a aVarH;
        i fVar;
        com.mbridge.msdk.c.c cVarB2;
        String str4;
        int i2;
        String strAH;
        String str5;
        int i3;
        String str6;
        if (dVar == null) {
            try {
                dVar2 = new d();
            } catch (Exception e) {
                e = e;
                dVar2 = dVar;
                aa.a(TAG, e.getMessage());
                dVar3 = dVar2;
                if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().a)) {
                    cVarB2 = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                    str4 = "";
                    i2 = 0;
                    if (cVarB2 != null) {
                        int iAq = cVarB2.aq();
                        strAH = cVarB2.aH();
                        try {
                            str6 = dVar3.c().get("data");
                            if (!z2) {
                                try {
                                    if (!q.a(cVarB2, str6)) {
                                        return;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str4 = str6;
                                    e.printStackTrace();
                                }
                            }
                            str4 = str6;
                        } catch (Exception e3) {
                            e = e3;
                        }
                        int iV = cVarB2.v();
                        dVar3.a("a_stid", cVarB2.c());
                        String str7 = str4;
                        i3 = iV;
                        i2 = iAq;
                        str5 = str7;
                    } else {
                        strAH = "UNKNOWN";
                        str5 = "";
                        i3 = 0;
                    }
                    dVar3.a(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, strAH);
                    try {
                        if (i2 == 2) {
                            if (!TextUtils.isEmpty(str5)) {
                                return;
                            }
                            if (q.a(cVarB2, str5)) {
                                if (i3 != 1) {
                                }
                                m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().h, com.mbridge.msdk.foundation.same.net.f.d.a().l, dVar3.toString(), false, eVar);
                                return;
                            } else if (z2) {
                                if (i3 != 1) {
                                    return;
                                }
                                m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().h, com.mbridge.msdk.foundation.same.net.f.d.a().l, dVar3.toString(), false, eVar);
                                return;
                            }
                        } else if (i2 == 1) {
                            m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().h, com.mbridge.msdk.foundation.same.net.f.d.a().l, dVar3.toString(), false, eVar);
                            return;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } else if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().f2147b)) {
                    cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                    if (cVarB != null) {
                        m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().i, com.mbridge.msdk.foundation.same.net.f.d.a().m, dVar3.toString(), false, eVar);
                        return;
                    }
                } else {
                    if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().v)) {
                        if (dVar3 != null) {
                            str2 = str + "?" + dVar3.toString();
                        } else {
                            str2 = str;
                        }
                        jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
                        if (jSONArrayB != null) {
                            String string = jSONArrayB.toString();
                            dVar3 = new d();
                            dVar3.a(d.e, string);
                        }
                        str3 = str2;
                    }
                    fVar = null;
                    if (i != 0) {
                        fVar = new com.mbridge.msdk.foundation.same.net.d.f(1, str3, dVar3.toString(), eVar);
                        fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    } else if (i != 1) {
                        if (z) {
                            fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar, true);
                        } else {
                            fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar);
                        }
                        fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    } else if (i == 2) {
                        fVar = new com.mbridge.msdk.foundation.same.net.d.c(1, str3, dVar3.toString(), eVar);
                        fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    }
                    if (fVar != null) {
                        fVar.a(lVar);
                        if (z) {
                            n.a(fVar);
                        } else {
                            n.b(fVar);
                        }
                    }
                }
                str3 = str;
                fVar = null;
                if (i != 0) {
                    fVar = new com.mbridge.msdk.foundation.same.net.d.f(1, str3, dVar3.toString(), eVar);
                    fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                } else if (i != 1) {
                    if (z) {
                        fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar, true);
                    } else {
                        fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar);
                    }
                    fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                } else if (i == 2) {
                    fVar = new com.mbridge.msdk.foundation.same.net.d.c(1, str3, dVar3.toString(), eVar);
                    fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                }
                if (fVar != null) {
                    fVar.a(lVar);
                    if (z) {
                        n.a(fVar);
                    } else {
                        n.b(fVar);
                    }
                }
            }
        } else {
            dVar2 = dVar;
        }
        try {
            addExtraParams(str, dVar2);
            e.e(dVar2);
            k kVarA = com.mbridge.msdk.foundation.same.net.f.c.a().a(dVar2);
            if (kVarA != null && eVar != null) {
                eVar.onSuccess(kVarA);
                return;
            }
        } catch (Exception e5) {
            e = e5;
            aa.a(TAG, e.getMessage());
        }
        dVar3 = dVar2;
        if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().a)) {
            cVarB2 = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            str4 = "";
            i2 = 0;
            if (cVarB2 != null) {
                int iAq2 = cVarB2.aq();
                strAH = cVarB2.aH();
                str6 = dVar3.c().get("data");
                if (!z2) {
                    if (!q.a(cVarB2, str6)) {
                        return;
                    }
                }
                str4 = str6;
                int iV2 = cVarB2.v();
                dVar3.a("a_stid", cVarB2.c());
                String str8 = str4;
                i3 = iV2;
                i2 = iAq2;
                str5 = str8;
            } else {
                strAH = "UNKNOWN";
                str5 = "";
                i3 = 0;
            }
            dVar3.a(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, strAH);
            if (i2 == 2) {
                if (!TextUtils.isEmpty(str5)) {
                    return;
                }
                if (q.a(cVarB2, str5)) {
                    if (i3 != 1 || i3 == 3) {
                        m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().h, com.mbridge.msdk.foundation.same.net.f.d.a().l, dVar3.toString(), false, eVar);
                        return;
                    }
                } else if (z2) {
                    if (i3 != 1 && i3 != 3) {
                        return;
                    }
                    m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().h, com.mbridge.msdk.foundation.same.net.f.d.a().l, dVar3.toString(), false, eVar);
                    return;
                }
            } else if (i2 == 1) {
                m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().h, com.mbridge.msdk.foundation.same.net.f.d.a().l, dVar3.toString(), false, eVar);
                return;
            }
        } else if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().f2147b)) {
            cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (cVarB != null && (aVarH = cVarB.h()) != null && aVarH.e() == 1) {
                m.a().a(com.mbridge.msdk.foundation.same.net.f.d.a().i, com.mbridge.msdk.foundation.same.net.f.d.a().m, dVar3.toString(), false, eVar);
                return;
            }
        } else {
            if (str.contains(com.mbridge.msdk.foundation.same.net.f.d.a().v)) {
                if (dVar3 != null) {
                    str2 = str + "?" + dVar3.toString();
                } else {
                    str2 = str;
                }
                jSONArrayB = com.mbridge.msdk.foundation.db.a.a.a().b();
                if (jSONArrayB != null) {
                    String string2 = jSONArrayB.toString();
                    dVar3 = new d();
                    dVar3.a(d.e, string2);
                }
                str3 = str2;
            }
            fVar = null;
            if (i != 0) {
                fVar = new com.mbridge.msdk.foundation.same.net.d.f(1, str3, dVar3.toString(), eVar);
                fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
            } else if (i != 1) {
                if (z) {
                    fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar, true);
                } else {
                    fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar);
                }
                fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
            } else if (i == 2) {
                fVar = new com.mbridge.msdk.foundation.same.net.d.c(1, str3, dVar3.toString(), eVar);
                fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
            }
            if (fVar != null) {
                fVar.a(lVar);
                if (z) {
                    n.a(fVar);
                } else {
                    n.b(fVar);
                }
            }
        }
        str3 = str;
        fVar = null;
        if (i != 0) {
            fVar = new com.mbridge.msdk.foundation.same.net.d.f(1, str3, dVar3.toString(), eVar);
            fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        } else if (i != 1) {
            if (z) {
                fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar, true);
            } else {
                fVar = new com.mbridge.msdk.foundation.same.net.d.d(1, str3, dVar3.toString(), eVar);
            }
            fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        } else if (i == 2) {
            fVar = new com.mbridge.msdk.foundation.same.net.d.c(1, str3, dVar3.toString(), eVar);
            fVar.a(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        }
        if (fVar != null) {
            fVar.a(lVar);
            if (z) {
                n.a(fVar);
            } else {
                n.b(fVar);
            }
        }
    }
}
