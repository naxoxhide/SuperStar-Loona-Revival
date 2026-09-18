package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.embedapplog.PangleEncryptUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetApiImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class q implements p<com.bytedance.sdk.openadsdk.d.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f662b = true;
    private final Context a;

    /* JADX INFO: compiled from: NetApiImpl.java */
    class a extends b.b.a.a.k.g {
        final /* synthetic */ AdSlot c;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.s d;
        final /* synthetic */ int e;
        final /* synthetic */ p.a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar, int i, p.a aVar) {
            super(str);
            this.c = adSlot;
            this.d = sVar;
            this.e = i;
            this.f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.b(this.c, this.d, this.e, this.f);
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class d implements b.b.a.a.h.o {
        d(q qVar) {
        }

        @Override // b.b.a.a.h.o
        public void a(b.b.a.a.h.k kVar) {
            com.bytedance.sdk.component.utils.m.d("imgCache", "loadImgAndReport: success");
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            com.bytedance.sdk.component.utils.m.d("imgCache", "loadImgAndReport: fail");
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class h extends b.b.a.a.j.c.a {
        h(q qVar) {
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            com.bytedance.sdk.component.utils.m.a("client bidding success", bVar.a());
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            com.bytedance.sdk.component.utils.m.a("client bidding fail", iOException.toString());
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class i extends b.b.a.a.j.c.a {
        i(q qVar) {
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            com.bytedance.sdk.component.utils.m.a("execPVToApm success", bVar.a());
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            com.bytedance.sdk.component.utils.m.a("execPVToApm fail", iOException.toString());
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    public static class j {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f666b;
        final String c;
        final int d;
        public final com.bytedance.sdk.openadsdk.core.f0.a e;
        final String f;
        final ArrayList<Integer> g;

        private j(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.f0.a aVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.a = i;
            this.f666b = i2;
            this.c = str2;
            this.e = aVar;
            this.f = str;
            this.d = i3;
            this.g = arrayList;
        }

        public static j a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
            Object obj;
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String strOptString3 = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
            int iOptInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.f0.a, ArrayList<Integer>> pairA = com.bytedance.sdk.openadsdk.core.b.a(jSONObject, adSlot, sVar);
            if (pairA != null && (obj = pairA.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.f0.a) obj).a(jSONObject.optLong("request_after"));
            }
            return pairA == null ? new j(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null) : new j(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.f0.a) pairA.first, jOptLong, jOptLong2, (ArrayList) pairA.second);
        }

        public static j b(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String strOptString3 = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
            int iOptInt3 = jSONObject.optInt("reason");
            if (adSlot == null || adSlot.getBiddingTokens() == null) {
                return new j(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adn_bid_result");
            com.bytedance.sdk.openadsdk.core.f0.a aVar = new com.bytedance.sdk.openadsdk.core.f0.a();
            if (jSONArrayOptJSONArray != null) {
                int i = 0;
                while (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString4 = jSONObjectOptJSONObject.optString("name");
                        String strOptString5 = jSONObjectOptJSONObject.optString("render_data");
                        String strOptString6 = jSONObjectOptJSONObject.optString("price");
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("win_notice");
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("loss_notice");
                        String strOptString7 = jSONObjectOptJSONObject.optString(BidResponsedEx.KEY_CID);
                        String strOptString8 = jSONObjectOptJSONObject.optString("crid");
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("adomain");
                        String strOptString9 = jSONObjectOptJSONObject.optString("adn_response_id");
                        com.bytedance.sdk.openadsdk.core.f0.g gVar = new com.bytedance.sdk.openadsdk.core.f0.g();
                        gVar.a(strOptString4);
                        gVar.f(strOptString5);
                        gVar.e(strOptString6);
                        gVar.c(strOptString7);
                        gVar.d(strOptString8);
                        gVar.b(strOptString9);
                        if (jSONArrayOptJSONArray4 != null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray4.length(); i2++) {
                                arrayList.add(jSONArrayOptJSONArray4.optString(i2));
                            }
                            gVar.a(arrayList);
                        }
                        if (jSONArrayOptJSONArray2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                arrayList2.add(jSONArrayOptJSONArray2.optString(i3));
                            }
                            gVar.c(arrayList2);
                        }
                        if (jSONArrayOptJSONArray3 != null) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                                arrayList3.add(jSONArrayOptJSONArray3.optString(i4));
                            }
                            gVar.b(arrayList3);
                        }
                        aVar.a(gVar);
                    }
                    i++;
                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    strOptString3 = strOptString3;
                    jOptLong2 = jOptLong2;
                    jOptLong = jOptLong;
                    iOptInt3 = iOptInt3;
                }
            }
            return new j(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, aVar, jOptLong, jOptLong2, null);
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    public static class k {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f667b;
        public final com.bytedance.sdk.openadsdk.core.f0.w c;

        private k(int i, boolean z, com.bytedance.sdk.openadsdk.core.f0.w wVar) {
            this.a = i;
            this.f667b = z;
            this.c = wVar;
        }

        public static k a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.f0.w wVar = new com.bytedance.sdk.openadsdk.core.f0.w();
            if (jSONObjectOptJSONObject != null) {
                try {
                    wVar.b(jSONObjectOptJSONObject.optInt("reason"));
                    wVar.a(jSONObjectOptJSONObject.optInt("corp_type"));
                    wVar.c(jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_REWARD_AMOUNT));
                    wVar.a(jSONObjectOptJSONObject.optString(CampaignEx.JSON_KEY_REWARD_NAME));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", th.getMessage());
                }
            }
            return new k(iOptInt, zOptBoolean, wVar);
        }
    }

    q(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, String str, int i2, j jVar, int i3, String str2) {
    }

    private boolean b(String str) {
        if (com.bytedance.sdk.openadsdk.core.e0.b.b()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.e0.b.a(str)) {
            return false;
        }
        String strA = com.bytedance.sdk.openadsdk.core.e0.b.a();
        if (!TextUtils.isEmpty(strA)) {
            com.bytedance.sdk.openadsdk.d.c.a(strA, System.currentTimeMillis());
        }
        return true;
    }

    private Map<String, String> c(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        if (d(jSONObject)) {
            map.put(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
        }
        return map;
    }

    private boolean d(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    private boolean e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    @JProtect
    private void f(JSONObject jSONObject) {
        try {
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, com.bytedance.sdk.openadsdk.utils.a0.i());
            jSONObject.put("version_code", com.bytedance.sdk.openadsdk.utils.a0.r());
            jSONObject.put("version", com.bytedance.sdk.openadsdk.utils.a0.s());
        } catch (Exception unused) {
        }
    }

    public static JSONArray d(String str) {
        try {
            Set<String> setE = b.b.a.a.d.e.b.a.e(str);
            if (setE != null && setE.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = setE.iterator();
                while (it.hasNext()) {
                    b.b.a.a.d.e.c.b bVarD = b.b.a.a.d.e.b.a.d(it.next());
                    if (bVarD != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", bVarD.b());
                        jSONObject.put("md5", bVarD.c());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e2) {
            Log.e("NetApiImpl", "getParentTplIds: ", e2);
            return null;
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class e extends b.b.a.a.j.c.a {
        e(q qVar) {
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            if (bVar == null || !bVar.g()) {
                com.bytedance.sdk.component.utils.m.d("NetApiImpl", "onResponse: NetResponse is null");
            } else {
                com.bytedance.sdk.component.utils.m.c("NetApiImpl", "onResponse: ", bVar.a());
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            com.bytedance.sdk.component.utils.m.c("NetApiImpl", "onFailure: ", iOException.getMessage());
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class f extends b.b.a.a.j.c.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.c a;

        f(q qVar, com.bytedance.sdk.openadsdk.l.c.c cVar) {
            this.a = cVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            if (bVar == null) {
                this.a.a(false).a(com.bytedance.sdk.openadsdk.l.c.c.j).b();
            } else {
                this.a.a(bVar.g()).a(bVar.b()).c(bVar.f()).b(bVar.a()).b();
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            this.a.a(false).c(iOException != null ? iOException.getMessage() : null).b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0064  */
    /* JADX WARN: Code duplicated, block: B:26:0x0094 A[Catch: JSONException -> 0x00c6, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00c6, blocks: (B:3:0x0007, B:5:0x0014, B:13:0x004c, B:15:0x0053, B:18:0x0066, B:20:0x006f, B:22:0x0080, B:24:0x008b, B:26:0x0094, B:38:0x00ba, B:11:0x0030, B:7:0x0028), top: B:41:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b7  */
    @JProtect
    private JSONObject c() {
        String packageResourcePath;
        int i2;
        int rotation;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PangleConstants.APP_ID, com.bytedance.sdk.openadsdk.core.h.a().d());
            jSONObject.put("name", com.bytedance.sdk.openadsdk.core.h.a().k());
            f(jSONObject);
            Context contextA = o.a();
            if (contextA != null) {
                try {
                    packageResourcePath = contextA.getPackageResourcePath();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", "failed to get the application installation package path. error: " + th.getMessage());
                    packageResourcePath = "";
                }
                jSONObject.put("package_install_path", packageResourcePath);
                jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.h.a().r());
                if (com.bytedance.sdk.openadsdk.core.g0.c.b() != null) {
                    jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.g0.c.b());
                }
                jSONObject.put("app_running_time", (System.currentTimeMillis() - l.d()) / 1000);
                jSONObject.put("fmwname", DeviceUtils.e(this.a));
                jSONObject.put("is_init", l.e() ? 1 : 0);
                if (contextA != null) {
                    i2 = 0;
                    rotation = ((WindowManager) contextA.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (rotation != 0) {
                        i2 = 1;
                    } else if (rotation != 1) {
                        i2 = 3;
                    } else if (rotation != 2) {
                        i2 = 2;
                    } else if (rotation == 3) {
                        i2 = 4;
                    }
                    jSONObject.put("orientation_support", new JSONArray().put(i2));
                }
            } else {
                packageResourcePath = "";
                jSONObject.put("package_install_path", packageResourcePath);
                jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.h.a().r());
                if (com.bytedance.sdk.openadsdk.core.g0.c.b() != null) {
                    jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.g0.c.b());
                }
                jSONObject.put("app_running_time", (System.currentTimeMillis() - l.d()) / 1000);
                jSONObject.put("fmwname", DeviceUtils.e(this.a));
                jSONObject.put("is_init", l.e() ? 1 : 0);
                if (contextA != null) {
                    i2 = 0;
                    rotation = ((WindowManager) contextA.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (rotation != 0) {
                        i2 = 1;
                    } else if (rotation != 1) {
                        i2 = 3;
                    } else if (rotation != 2) {
                        i2 = 2;
                    } else if (rotation == 3) {
                        i2 = 4;
                    }
                    jSONObject.put("orientation_support", new JSONArray().put(i2));
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @JProtect
    private JSONObject a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar, int i2) {
        int i3;
        int i4;
        int i5;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strJ = (sVar == null || TextUtils.isEmpty(sVar.a)) ? com.bytedance.sdk.openadsdk.utils.a0.j() : sVar.a;
            if (i2 == 7) {
                if (sVar != null && (i5 = sVar.f589b) > 0) {
                    jSONObject2.put("req_type", i5);
                }
            } else if (i2 == 8) {
                if (sVar != null && (i4 = sVar.c) > 0) {
                    jSONObject2.put("req_type", i4);
                }
            } else if (i2 == 3 && sVar != null && (i3 = sVar.d) > 0) {
                jSONObject2.put("req_type", i3);
            }
            try {
                String strD = o.d().d();
                String strQ = o.d().Q();
                if (strD != null && strQ != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", strD);
                    jSONObject3.put("param", strQ);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable unused) {
            }
            if (adSlot != null && adSlot.getBiddingTokens() != null) {
                jSONObject2.put("bidding_param", adSlot.getBiddingTokens());
                com.bytedance.sdk.openadsdk.core.settings.a aVarL = com.bytedance.sdk.openadsdk.core.settings.n.j0().l(adSlot.getCodeId());
                jSONObject2.put("waterfall_id", aVarL.J);
                jSONObject2.put("waterfall_version", aVarL.K);
                jSONObject2.put("link_id", adSlot.getLinkId());
            }
            jSONObject2.put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, strJ);
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("source_type", "app");
            jSONObject2.put("app", c());
            jSONObject2.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, DeviceUtils.a(this.a, true));
            jSONObject2.put("user", b(adSlot));
            jSONObject2.put("ua", com.bytedance.sdk.openadsdk.utils.a0.t());
            jSONObject2.put("channel", "main");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(adSlot, i2, sVar));
            jSONObject2.put("adslots", jSONArray);
            a(jSONObject2, sVar);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis);
            jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.e.a((adSlot.getCodeId() == null || strJ == null) ? "" : String.valueOf(jCurrentTimeMillis).concat(adSlot.getCodeId()).concat(strJ)));
            jSONObject = com.bytedance.sdk.component.utils.a.a(jSONObject2);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("oversea_version_type", 1);
            return jSONObject;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void b(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar, int i2, p.a aVar) {
        l.f();
        com.bytedance.sdk.openadsdk.core.f0.b bVar = new com.bytedance.sdk.openadsdk.core.f0.b();
        bVar.a(adSlot);
        if (!com.bytedance.sdk.openadsdk.core.settings.j.a()) {
            if (aVar != null) {
                aVar.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
                bVar.a(1000);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            return;
        }
        if (!o.d().y()) {
            if (aVar != null) {
                aVar.onError(-16, com.bytedance.sdk.openadsdk.core.g.a(-16));
                bVar.a(1001);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            return;
        }
        if (aVar == null) {
            return;
        }
        if (b(adSlot.getCodeId())) {
            aVar.onError(-8, com.bytedance.sdk.openadsdk.core.g.a(-8));
            return;
        }
        if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
            bVar.b(2);
            bVar.a(adSlot.getBidAdm());
            if (com.bytedance.sdk.component.utils.m.c()) {
                com.bytedance.sdk.component.utils.m.a("bidding", "getAd bidAdm is valid，it will directly parse the returned advertisement: BidAdm->MD5->" + b.a.a.a.a.a.a.i.b.a(adSlot.getBidAdm()));
            }
            if (o.d().n() && v.a().c() == 1) {
                com.bytedance.sdk.openadsdk.utils.a0.a("Pangle_Debug_Mode", adSlot.getBidAdm(), this.a);
            }
            try {
                JSONObject jSONObjectB = b(new JSONObject(adSlot.getBidAdm()));
                if (jSONObjectB == null) {
                    a(aVar, bVar);
                    return;
                }
                j jVarA = j.a(jSONObjectB, adSlot, sVar);
                bVar.a(jVarA.g);
                com.bytedance.sdk.openadsdk.core.j.a(this.a, jVarA.f);
                int i3 = jVarA.f666b;
                if (i3 != 20000) {
                    aVar.onError(i3, jVarA.c);
                    bVar.a(jVarA.f666b);
                    com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.f0.a aVar2 = jVarA.e;
                if (aVar2 == null) {
                    a(aVar, bVar);
                    return;
                }
                if (aVar2.b() != null && jVarA.e.b().size() > 0) {
                    com.bytedance.sdk.openadsdk.d.c.a(jVarA.e.b().get(0), com.bytedance.sdk.openadsdk.utils.a0.d(i2));
                }
                jVarA.e.c(jSONObjectB.toString());
                aVar.a(jVarA.e, bVar);
                Map<String, com.bytedance.sdk.openadsdk.core.f0.q> mapA = com.bytedance.sdk.openadsdk.core.f0.a.a(jVarA.e);
                if (mapA != null) {
                    com.bytedance.sdk.openadsdk.f.b.c().a(mapA);
                }
                a(jVarA.e);
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("NetApiImpl", "get ad error: ", th);
                a(aVar, bVar);
                return;
            }
        }
        JSONObject jSONObjectA = a(adSlot, sVar, i2);
        if (jSONObjectA == null) {
            aVar.onError(-9, com.bytedance.sdk.openadsdk.core.g.a(-9));
            bVar.a(-9);
            com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
            return;
        }
        if (o.d().n() && v.a().c() == 1) {
            com.bytedance.sdk.openadsdk.utils.a0.a("Pangle_Debug_Mode", jSONObjectA.toString(), this.a);
        }
        String strA = com.bytedance.sdk.openadsdk.utils.a0.a(adSlot.getBiddingTokens() != null ? "/api/ad/union/mediation/get_ads/" : "/api/ad/union/sdk/get_ads/", true);
        b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
        com.bytedance.sdk.openadsdk.l.c.c cVar = new com.bytedance.sdk.openadsdk.l.c.c();
        try {
            String strA2 = com.bytedance.sdk.openadsdk.g.d.a(dVarD, strA);
            dVarD.b(strA2);
            cVar.d(strA2);
        } catch (Exception unused) {
        }
        dVarD.a(jSONObjectA.toString(), o.d().v());
        cVar.a(dVarD.c()).c();
        Map<String, String> mapA2 = com.bytedance.sdk.openadsdk.core.g0.c.a(strA, jSONObjectA.toString());
        if (mapA2 != null && mapA2.size() > 0) {
            for (String str : mapA2.keySet()) {
                try {
                    dVarD.a(str, mapA2.get(str));
                } catch (Exception e2) {
                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", e2.getMessage());
                }
            }
        }
        try {
            dVarD.a("User-Agent", com.bytedance.sdk.openadsdk.utils.a0.t());
        } catch (Exception unused2) {
        }
        com.bytedance.sdk.openadsdk.utils.z zVarC = com.bytedance.sdk.openadsdk.utils.z.c();
        Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
        boolean z = com.bytedance.sdk.openadsdk.core.h.a().p() && requestExtraMap != null;
        if (z) {
            requestExtraMap.put("pgad_start", zVarC);
        }
        if (adSlot.getBiddingTokens() != null) {
            a(adSlot, sVar, dVarD, requestExtraMap, z, zVarC, aVar);
        } else {
            dVarD.a(new b(cVar, z, requestExtraMap, zVarC, bVar, aVar, adSlot, i2, sVar));
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class c extends b.b.a.a.j.c.a {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f664b;
        final /* synthetic */ com.bytedance.sdk.openadsdk.utils.z c;
        final /* synthetic */ p.a d;
        final /* synthetic */ AdSlot e;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.s f;

        c(boolean z, Map map, com.bytedance.sdk.openadsdk.utils.z zVar, p.a aVar, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
            this.a = z;
            this.f664b = map;
            this.c = zVar;
            this.d = aVar;
            this.e = adSlot;
            this.f = sVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            if (this.a) {
                this.f664b.put("pgad_end", this.c);
            }
            if (bVar == null || !bVar.g()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(bVar.a());
                if (o.d().n() && v.a().c() == 1) {
                    com.bytedance.sdk.openadsdk.utils.a0.a("Pangle_Debug_Mode", jSONObject.toString(), q.this.a);
                }
                JSONObject jSONObjectB = q.this.b(jSONObject);
                if (jSONObjectB == null) {
                    this.d.onError(-1, com.bytedance.sdk.openadsdk.core.g.a(-1));
                    return;
                }
                j jVarB = j.b(jSONObjectB, this.e, this.f);
                if (jVarB.f666b != 20000) {
                    if (o.d().h() || jVarB.f666b != 40029) {
                        this.d.onError(jVarB.f666b, jVarB.c);
                        return;
                    } else {
                        this.d.onError(-100, com.bytedance.sdk.openadsdk.core.g.a(-100));
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.core.f0.a aVar = jVarB.e;
                if (aVar == null) {
                    this.d.onError(-1, com.bytedance.sdk.openadsdk.core.g.a(-1));
                    return;
                }
                aVar.c(jSONObjectB.toString());
                this.d.a(jVarB.e, new com.bytedance.sdk.openadsdk.core.f0.b());
                q.this.a(jVarB.e);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("NetApiImpl", "get ad error: ", th);
                this.d.onError(-1, com.bytedance.sdk.openadsdk.core.g.a(-1));
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            com.bytedance.sdk.openadsdk.utils.z zVarC = com.bytedance.sdk.openadsdk.utils.z.c();
            if (this.a) {
                this.f664b.put("pgad_end", Long.valueOf(zVarC.a));
            }
            if (o.d().n() && v.a().c() == 1) {
                com.bytedance.sdk.openadsdk.utils.a0.a("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, q.this.a);
            }
            this.d.onError(601, iOException != null ? iOException.getMessage() : "");
        }
    }

    private byte[] c(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes("utf-8"));
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e2) {
                                com.bytedance.sdk.component.utils.m.b("NetApiImpl", e2.toString());
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e = e3;
                            gZIPOutputStream = gZIPOutputStream2;
                            com.bytedance.sdk.component.utils.m.b("NetApiImpl", e.toString());
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e4) {
                                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", e4.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream = gZIPOutputStream2;
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e5) {
                                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", e5.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException e6) {
                                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", e6.toString());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e7) {
                    e = e7;
                }
            } catch (IOException e8) {
                e = e8;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (IOException e9) {
            com.bytedance.sdk.component.utils.m.b("NetApiImpl", e9.toString());
        }
        return byteArray;
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class g extends b.b.a.a.j.c.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p.b f665b;

        g(com.bytedance.sdk.openadsdk.l.c.c cVar, p.b bVar) {
            this.a = cVar;
            this.f665b = bVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            if (bVar == null) {
                this.a.a(false).a(com.bytedance.sdk.openadsdk.l.c.c.j).b();
                q.this.a(this.f665b);
                return;
            }
            if (!bVar.g() || TextUtils.isEmpty(bVar.a())) {
                this.a.a(bVar.g()).b(bVar.a()).a(bVar.b()).c(bVar.f()).b();
                String strA = com.bytedance.sdk.openadsdk.core.g.a(-2);
                int iB = bVar.b();
                if (!bVar.g() && !TextUtils.isEmpty(bVar.f())) {
                    strA = bVar.f();
                }
                this.f665b.onError(iB, strA);
                return;
            }
            this.a.a(true).a(bVar.b()).b(bVar.a()).b();
            try {
                JSONObject jSONObject = new JSONObject(bVar.a());
                String strA2 = jSONObject.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.a.a(jSONObject.optString("message")) : null;
                if (!TextUtils.isEmpty(strA2)) {
                    try {
                        jSONObject = new JSONObject(strA2);
                    } catch (Throwable unused) {
                    }
                }
                k kVarA = k.a(jSONObject);
                int i = kVarA.a;
                if (i != 20000) {
                    this.f665b.onError(i, com.bytedance.sdk.openadsdk.core.g.a(i));
                } else if (kVarA.c == null) {
                    q.this.a(this.f665b);
                } else {
                    this.f665b.a(kVarA);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.m.b("NetApiImpl", e.getMessage());
                q.this.a(this.f665b);
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            String message = iOException != null ? iOException.getMessage() : "";
            this.a.a(false).c(message).b();
            this.f665b.onError(-2, message);
        }
    }

    private void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
        JSONArray jSONArray;
        if (sVar == null || (jSONArray = sVar.e) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar, int i2, p.a aVar) {
        com.bytedance.sdk.openadsdk.core.b0.a aVar2 = new com.bytedance.sdk.openadsdk.core.b0.a(aVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            l.a().post(new a("getAd", adSlot, sVar, i2, aVar2));
        } else {
            b(adSlot, sVar, i2, aVar2);
        }
    }

    private void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.s sVar, b.b.a.a.j.d.d dVar, Map<String, Object> map, boolean z, com.bytedance.sdk.openadsdk.utils.z zVar, p.a aVar) {
        dVar.a(new c(z, map, zVar, aVar, adSlot, sVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar) {
        List<com.bytedance.sdk.openadsdk.core.f0.q> listB = aVar.b();
        if (listB == null || listB.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < listB.size(); i2++) {
            com.bytedance.sdk.openadsdk.core.f0.q qVar = listB.get(i2);
            if (qVar != null && qVar.l() == null) {
                a("", 0, 0, qVar.b0(), qVar);
                a("", 0, 0, qVar.w(), qVar);
                List<com.bytedance.sdk.openadsdk.core.f0.n> listD0 = qVar.d0();
                if (listD0 != null && listD0.size() > 0) {
                    for (int i3 = 0; i3 < listD0.size(); i3++) {
                        a(qVar, listD0.get(i3));
                    }
                }
                if (qVar.N0() != null) {
                    a(qVar.N0().b(), qVar.N0().c(), qVar.N0().a(), (com.bytedance.sdk.openadsdk.core.f0.n) null, qVar);
                }
            }
        }
    }

    private void a(String str, int i2, int i3, com.bytedance.sdk.openadsdk.core.f0.n nVar, com.bytedance.sdk.openadsdk.core.f0.q qVar) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.h.d.a(str).b(i2).a(i3).d(b0.g(o.a())).c(b0.i(o.a())).a(b.b.a.a.h.u.BITMAP).a(new com.bytedance.sdk.openadsdk.h.b(qVar, str, null), b.b.a.a.h.t.IO);
        } else {
            if (nVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.h.d.a(nVar).a(b.b.a.a.h.u.BITMAP).a(new com.bytedance.sdk.openadsdk.h.b(qVar, nVar.d(), null), b.b.a.a.h.t.IO);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.core.f0.q qVar, com.bytedance.sdk.openadsdk.core.f0.n nVar) {
        com.bytedance.sdk.component.utils.m.d("imgCache", "loadImgAndReport: ");
        if (nVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.d.a(nVar).a(b.b.a.a.h.u.BITMAP).a(new com.bytedance.sdk.openadsdk.h.b(qVar, nVar.d(), new d(this)), b.b.a.a.h.t.IO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.f0.s sVar, com.bytedance.sdk.openadsdk.utils.z zVar, com.bytedance.sdk.openadsdk.utils.z zVar2, int i2, com.bytedance.sdk.openadsdk.utils.z zVar3, com.bytedance.sdk.openadsdk.core.f0.q qVar, String str, boolean z) {
        if (o.d().U()) {
            JSONObject jSONObject = new JSONObject();
            long jA = 0;
            if (sVar != null) {
                try {
                    com.bytedance.sdk.openadsdk.utils.z zVar4 = sVar.g;
                    if (zVar4.a > 0) {
                        jSONObject.put("client_start_time", zVar.a(zVar4));
                        jA = zVar3.a(sVar.g);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put("network_time", zVar2.a(zVar));
            jSONObject.put("sever_time", i2);
            jSONObject.put("client_end_time", zVar3.a(zVar2));
            if (z) {
                jSONObject.put("is_choose_ad", true);
            }
            com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "load_ad_time", jA, jSONObject);
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    class b extends b.b.a.a.j.c.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.c.c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f663b;
        final /* synthetic */ Map c;
        final /* synthetic */ com.bytedance.sdk.openadsdk.utils.z d;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.b e;
        final /* synthetic */ p.a f;
        final /* synthetic */ AdSlot g;
        final /* synthetic */ int h;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.s i;

        b(com.bytedance.sdk.openadsdk.l.c.c cVar, boolean z, Map map, com.bytedance.sdk.openadsdk.utils.z zVar, com.bytedance.sdk.openadsdk.core.f0.b bVar, p.a aVar, AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
            this.a = cVar;
            this.f663b = z;
            this.c = map;
            this.d = zVar;
            this.e = bVar;
            this.f = aVar;
            this.g = adSlot;
            this.h = i;
            this.i = sVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            com.bytedance.sdk.openadsdk.core.f0.v vVar;
            System.currentTimeMillis();
            this.a.a();
            if (this.f663b) {
                this.c.put("pgad_end", this.d);
            }
            if (bVar != null) {
                if (!bVar.g()) {
                    int iB = bVar.b();
                    String strF = bVar.f();
                    this.f.onError(iB, strF);
                    this.e.a(iB);
                    com.bytedance.sdk.openadsdk.core.f0.b.a(this.e);
                    q.this.a(bVar.c(), this.g.getCodeId(), this.h, null, iB, strF);
                    com.bytedance.sdk.openadsdk.d.p.f.h.incrementAndGet();
                    com.bytedance.sdk.openadsdk.d.p.f.c.incrementAndGet();
                    com.bytedance.sdk.openadsdk.d.p.f.a.incrementAndGet();
                    com.bytedance.sdk.openadsdk.d.p.f.a(iB, strF);
                    com.bytedance.sdk.openadsdk.d.p.f.c();
                    this.a.a(false).a(iB).c(strF).b(bVar.a()).b();
                    return;
                }
                com.bytedance.sdk.openadsdk.d.p.f.f744b.incrementAndGet();
                com.bytedance.sdk.openadsdk.d.p.f.a.incrementAndGet();
                try {
                    com.bytedance.sdk.openadsdk.utils.z zVarC = com.bytedance.sdk.openadsdk.utils.z.c();
                    String strA = bVar.a();
                    JSONObject jSONObject = new JSONObject(strA);
                    if (o.d().n() && v.a().c() == 1) {
                        com.bytedance.sdk.openadsdk.utils.a0.a("Pangle_Debug_Mode", jSONObject.toString(), q.this.a);
                    }
                    this.e.a(strA);
                    JSONObject jSONObjectB = q.this.b(jSONObject);
                    if (jSONObjectB == null) {
                        q.this.a(this.f, this.e);
                        q.this.a(bVar.c(), this.g.getCodeId(), this.h, null, -1, "mate parse_fail");
                        com.bytedance.sdk.openadsdk.d.p.f.f.incrementAndGet();
                        com.bytedance.sdk.openadsdk.d.p.f.c();
                        this.a.a(true).a(bVar.b()).b(strA).b();
                        return;
                    }
                    j jVarA = j.a(jSONObjectB, this.g, this.i);
                    this.e.a(jVarA.g);
                    com.bytedance.sdk.openadsdk.core.j.a(q.this.a, jVarA.f);
                    int i = jVarA.f666b;
                    if (i != 20000) {
                        this.e.a(i);
                        if (o.d().h() || jVarA.f666b != 40029) {
                            this.f.onError(jVarA.f666b, jVarA.c);
                        } else {
                            this.f.onError(-100, com.bytedance.sdk.openadsdk.core.g.a(-100));
                        }
                        com.bytedance.sdk.openadsdk.core.f0.b.a(this.e);
                        q.this.a(bVar.c(), this.g.getCodeId(), this.h, jVarA, jVarA.f666b, String.valueOf(jVarA.d));
                        com.bytedance.sdk.openadsdk.d.p.f.f.incrementAndGet();
                        com.bytedance.sdk.openadsdk.d.p.f.c();
                        this.a.a(true).a(bVar.b()).b(strA).b();
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.f0.a aVar = jVarA.e;
                    if (aVar == null) {
                        q.this.a(this.f, this.e);
                        q.this.a(bVar.c(), this.g.getCodeId(), this.h, jVarA, -1, "parse_fail");
                        com.bytedance.sdk.openadsdk.d.p.f.e.incrementAndGet();
                        com.bytedance.sdk.openadsdk.d.p.f.c();
                        this.a.a(true).a(bVar.b()).b(strA).b();
                        return;
                    }
                    aVar.c(jSONObjectB.toString());
                    com.bytedance.sdk.openadsdk.utils.z zVarC2 = com.bytedance.sdk.openadsdk.utils.z.c();
                    com.bytedance.sdk.openadsdk.core.f0.s sVar = this.i;
                    if (sVar != null && (vVar = sVar.h) != null) {
                        vVar.a(this.d, zVarC, jVarA.a, zVarC2);
                    }
                    this.f.a(jVarA.e, this.e);
                    q.this.a(jVarA.e);
                    Map<String, com.bytedance.sdk.openadsdk.core.f0.q> mapA = com.bytedance.sdk.openadsdk.core.f0.a.a(jVarA.e);
                    if (mapA != null) {
                        com.bytedance.sdk.openadsdk.f.b.c().a(mapA);
                    }
                    if (jVarA.e.b() != null && !jVarA.e.b().isEmpty()) {
                        q.this.a(this.i, this.d, zVarC, jVarA.a, zVarC2, jVarA.e.b().get(0), com.bytedance.sdk.openadsdk.utils.a0.d(this.h), jVarA.e.i());
                        com.bytedance.sdk.openadsdk.d.p.f.d.incrementAndGet();
                    }
                    com.bytedance.sdk.openadsdk.d.p.f.c();
                    this.a.a(true).a(bVar.b()).b(strA).b();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", "get ad error: ", th);
                    q.this.a(this.f, this.e);
                    q.this.a(bVar.c(), this.g.getCodeId(), this.h, null, -1, "parse_fail");
                    com.bytedance.sdk.openadsdk.d.p.f.e.incrementAndGet();
                    com.bytedance.sdk.openadsdk.d.p.f.c();
                    this.a.a(bVar.g()).a(bVar.b()).b(bVar.a()).c(th.getMessage()).b();
                }
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            this.a.a();
            String message = iOException != null ? iOException.getMessage() : "";
            com.bytedance.sdk.openadsdk.utils.z zVarC = com.bytedance.sdk.openadsdk.utils.z.c();
            if (this.f663b) {
                this.c.put("pgad_end", Long.valueOf(zVarC.a));
            }
            if (o.d().n() && v.a().c() == 1) {
                com.bytedance.sdk.openadsdk.utils.a0.a("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, q.this.a);
            }
            int i = 601;
            if (iOException != null && (iOException instanceof SocketTimeoutException)) {
                i = 602;
            }
            int i2 = i;
            p.a aVar = this.f;
            if (aVar != null) {
                aVar.onError(i2, message);
            }
            com.bytedance.sdk.component.utils.m.c("NetApiImpl", "onFailure: ", Integer.valueOf(i2));
            this.e.a(i2);
            com.bytedance.sdk.openadsdk.core.f0.b.a(this.e);
            q.this.a(zVarC.a(this.d), this.g.getCodeId(), this.h, null, i2, message);
            com.bytedance.sdk.openadsdk.d.p.f.c.incrementAndGet();
            com.bytedance.sdk.openadsdk.d.p.f.a.incrementAndGet();
            com.bytedance.sdk.openadsdk.d.p.f.g.incrementAndGet();
            com.bytedance.sdk.openadsdk.d.p.f.a(i2, message);
            com.bytedance.sdk.openadsdk.d.p.f.c();
            this.a.c(message).a(false).b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    @JProtect
    public com.bytedance.sdk.openadsdk.d.e a(JSONObject jSONObject, String str, boolean z) {
        String strF;
        boolean z2;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strF2 = null;
            if (!com.bytedance.sdk.openadsdk.core.settings.j.a()) {
                return null;
            }
            b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
            dVarD.b(str);
            if (z) {
                byte[] bArrC = c(jSONObject.toString());
                byte[] bArrEncrypt = PangleEncryptUtils.encrypt(bArrC, bArrC.length);
                if (bArrEncrypt == null) {
                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", "V3 encrypt failed");
                    JSONObject jSONObjectA = com.bytedance.sdk.component.utils.a.a(jSONObject);
                    if (!d(jSONObjectA)) {
                        jSONObjectA = jSONObject;
                    }
                    a(c(jSONObjectA), dVarD);
                    dVarD.a(jSONObjectA.toString(), o.d().v());
                } else {
                    a(b(), dVarD);
                    dVarD.a("application/octet-stream;tt-data=a", bArrEncrypt);
                }
            } else {
                JSONObject jSONObjectA2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                if (!d(jSONObjectA2)) {
                    jSONObjectA2 = jSONObject;
                }
                a(c(jSONObjectA2), dVarD);
                dVarD.a(jSONObjectA2.toString(), o.d().v());
            }
            com.bytedance.sdk.openadsdk.l.c.c cVar = new com.bytedance.sdk.openadsdk.l.c.c();
            cVar.d(str).a(dVarD.c()).c();
            b.b.a.a.j.b bVarB = dVarD.b();
            boolean zE = (bVarB == null || !bVarB.g() || TextUtils.isEmpty(bVarB.a())) ? false : e(new JSONObject(bVarB.a()));
            int iB = bVarB != null ? bVarB.b() : 0;
            boolean z3 = true;
            if (zE || iB != 200) {
                strF = (bVarB == null || bVarB.f() == null) ? "error unknown" : bVarB.f();
                z2 = false;
            } else {
                strF = "server say not success";
                z2 = true;
            }
            boolean z4 = bVarB == null;
            if (z4 || !bVarB.g()) {
                z3 = false;
            }
            com.bytedance.sdk.openadsdk.l.c.c cVarA = cVar.a(z3).b(z4 ? null : bVarB.a()).a(z4 ? com.bytedance.sdk.openadsdk.l.c.c.j : iB);
            if (!z4) {
                strF2 = bVarB.f();
            }
            cVarA.c(strF2).b();
            a(jSONObject, z);
            com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.a, zE, iB, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.d.e(zE, iB, strF, z2);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("NetApiImpl", "uploadEvent error", th);
            return new com.bytedance.sdk.openadsdk.d.e(false, 509, "service_busy", false);
        }
    }

    @JProtect
    private JSONObject b(String str, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("extra", str);
            jSONObject2.put("filter_words", a(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        return map;
    }

    public static JSONObject b(AdSlot adSlot) {
        r rVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personalized_ad", o.d().J());
            jSONObject.put("lmt", DeviceUtils.g());
            jSONObject.put("coppa", com.bytedance.sdk.openadsdk.core.h.a().i());
            jSONObject.put("gdpr", com.bytedance.sdk.openadsdk.core.h.a().h());
            jSONObject.put("is_gdpr_user", o.d().N());
            jSONObject.put("ccpa", com.bytedance.sdk.openadsdk.core.h.a().e());
            if (adSlot != null && r.f.containsKey(Integer.valueOf(adSlot.getCodeId())) && (rVar = r.f.get(Integer.valueOf(adSlot.getCodeId()))) != null) {
                jSONObject.put("lastadomain", rVar.b());
                jSONObject.put("lastbundle", rVar.c());
                jSONObject.put("lastclick", rVar.d());
                jSONObject.put("lastskip", rVar.e());
            }
            a(jSONObject, "keywords", com.bytedance.sdk.openadsdk.core.h.a().j());
            a(jSONObject, "data", a(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0032  */
    public JSONObject b(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            if (f662b) {
                int iOptInt = jSONObject.optInt("cypher", -1);
                String strOptString = jSONObject.optString("message");
                String strOptString2 = jSONObject.optString("auction_price", "");
                if (iOptInt == 3) {
                    strOptString = com.bytedance.sdk.component.utils.a.a(strOptString);
                }
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject2 = jSONObject;
                } else {
                    jSONObject2 = new JSONObject(strOptString);
                    try {
                        jSONObject2.put("auction_price", strOptString2);
                    } catch (Throwable unused) {
                    }
                }
            } else {
                jSONObject2 = jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return f662b ? jSONObject2 : jSONObject;
    }

    private void a(Map<String, String> map, b.b.a.a.j.d.d dVar) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    dVar.a(entry.getKey(), entry.getValue());
                } catch (Exception e2) {
                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", "ADD header exceptopn", e2.getMessage());
                }
            }
        }
        try {
            dVar.a("User-Agent", com.bytedance.sdk.openadsdk.utils.a0.t());
        } catch (Exception e3) {
            com.bytedance.sdk.component.utils.m.b("NetApiImpl", "ADD header exceptopn", e3.getMessage());
        }
    }

    @JProtect
    private void a(JSONObject jSONObject, boolean z) throws Throwable {
        if (com.bytedance.sdk.openadsdk.core.h.a().p()) {
            try {
                jSONObject.getJSONObject("header").put("aid", "4562");
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.m.b("NetApiImpl", "reportETEvent error", e2.getMessage());
            }
            b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
            dVarD.b(com.bytedance.sdk.openadsdk.utils.a0.g());
            if (z) {
                byte[] bArrC = c(jSONObject.toString());
                byte[] bArrEncrypt = PangleEncryptUtils.encrypt(bArrC, bArrC.length);
                if (bArrEncrypt == null) {
                    com.bytedance.sdk.component.utils.m.b("NetApiImpl", "V3 encrypt failed");
                    JSONObject jSONObjectA = com.bytedance.sdk.component.utils.a.a(jSONObject);
                    if (d(jSONObjectA)) {
                        jSONObject = jSONObjectA;
                    }
                    a(c(jSONObject), dVarD);
                    dVarD.a(jSONObject.toString(), o.d().v());
                } else {
                    a(b(), dVarD);
                    dVarD.a("application/octet-stream;tt-data=a", bArrEncrypt);
                }
            } else {
                JSONObject jSONObjectA2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                if (d(jSONObjectA2)) {
                    jSONObject = jSONObjectA2;
                }
                a(c(jSONObject), dVarD);
                dVarD.a(jSONObject.toString(), o.d().v());
            }
            dVarD.a(new e(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(String str, List<FilterWord> list) {
        JSONObject jSONObjectB;
        if (com.bytedance.sdk.openadsdk.core.settings.j.a() && (jSONObjectB = b(str, list)) != null) {
            b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
            String strJ = com.bytedance.sdk.openadsdk.utils.a0.j("/api/ad/union/dislike_event/");
            String string = com.bytedance.sdk.component.utils.a.a(jSONObjectB).toString();
            dVarD.b(strJ);
            dVarD.d(string);
            com.bytedance.sdk.openadsdk.l.c.c cVar = new com.bytedance.sdk.openadsdk.l.c.c();
            cVar.d(strJ).a(string).c();
            dVarD.a(new f(this, cVar));
        }
    }

    private JSONArray a(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar) {
        aVar.onError(-1, com.bytedance.sdk.openadsdk.core.g.a(-1));
        bVar.a(-1);
        com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.b bVar) {
        bVar.onError(-1, com.bytedance.sdk.openadsdk.core.g.a(-1));
    }

    private static String a(AdSlot adSlot) {
        String strF = com.bytedance.sdk.openadsdk.core.h.a().f();
        if (adSlot == null) {
            return TextUtils.isEmpty(strF) ? "" : strF;
        }
        String userData = adSlot.getUserData();
        if (TextUtils.isEmpty(strF)) {
            return userData;
        }
        if (TextUtils.isEmpty(userData)) {
            return strF;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(userData);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString("name", null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strF);
                int length2 = jSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable unused) {
                return userData;
            }
        } catch (Throwable unused2) {
            return strF;
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject a(AdSlot adSlot, int i2, com.bytedance.sdk.openadsdk.core.f0.s sVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i2);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt())) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject2.put("ad_id", adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject2.put(CampaignEx.JSON_KEY_CREATIVE_ID, adSlot.getCreativeId());
                }
                if (adSlot.getExt() != null) {
                    jSONObject2.put("ext", adSlot.getExt());
                }
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (sVar != null) {
                jSONObject.put("render_method", sVar.f);
                int i3 = sVar.f;
                if (i3 == 1) {
                    a(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (i3 == 2) {
                    a(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject.put("render_method", 1);
                a(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject.put("ptpl_ids", d(adSlot.getCodeId()));
            jSONObject.put("pos", AdSlot.getPosition(i2));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i2 == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            int adCount = adSlot.getAdCount();
            if (adCount < 1) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i2 == 7 || i2 == 8) {
                adCount = 1;
            }
            if (sVar != null && sVar.e != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
            if (i2 == 1) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_rotate_banner", adSlot.getIsRotateBanner());
                jSONObject3.put("rotate_time", adSlot.getRotateTime());
                jSONObject3.put("rotate_order", adSlot.getRotateOrder());
                jSONObject.put(ReportUtil.INVENTORY_TYPE_BANNER, jSONObject3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i2);
            jSONObject2.put("height", i3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject, String str, float f2, float f3) {
        if (f2 < 0.0f || f3 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f2);
            jSONObject2.put("height", (int) f3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(JSONObject jSONObject, p.b bVar) {
        if (!com.bytedance.sdk.openadsdk.core.settings.j.a()) {
            if (bVar != null) {
                bVar.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
            }
        } else {
            if (jSONObject == null || bVar == null) {
                return;
            }
            JSONObject jSONObjectA = com.bytedance.sdk.component.utils.a.a(jSONObject);
            com.bytedance.sdk.openadsdk.l.c.c cVar = new com.bytedance.sdk.openadsdk.l.c.c();
            b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
            try {
                String strA = com.bytedance.sdk.openadsdk.g.d.a(dVarD, com.bytedance.sdk.openadsdk.utils.a0.j("/api/ad/union/sdk/reward_video/reward/"));
                dVarD.b(strA);
                cVar.d(strA);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.m.b("NetApiImpl", e2.getMessage());
            }
            dVarD.d(jSONObjectA.toString());
            cVar.a(dVarD.c()).c();
            dVarD.a(new g(cVar, bVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.d.e a(JSONObject jSONObject) {
        int i2;
        boolean z;
        boolean z2;
        String strF = "error unknown";
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.j.a() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        JSONObject jSONObjectA = com.bytedance.sdk.component.utils.a.a(jSONObject);
        b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
        boolean z3 = false;
        int iB = 0;
        try {
            dVarD.a(jSONObjectA.toString(), o.d().v());
            dVarD.b(com.bytedance.sdk.openadsdk.utils.a0.j("/api/ad/union/sdk/stats/batch/"));
            dVarD.a("User-Agent", com.bytedance.sdk.openadsdk.utils.a0.t());
            b.b.a.a.j.b bVarB = dVarD.b();
            try {
                if (bVarB == null) {
                    return new com.bytedance.sdk.openadsdk.d.e(false, 0, "error unknown", false);
                }
                z = true;
                if (!bVarB.g() || TextUtils.isEmpty(bVarB.a())) {
                    z2 = false;
                    z = false;
                } else {
                    JSONObject jSONObject2 = new JSONObject(bVarB.a());
                    int iOptInt = jSONObject2.optInt("code", -1);
                    strF = jSONObject2.optString("data", "");
                    z2 = iOptInt == 20000;
                    if (iOptInt != 60005) {
                        z = false;
                    }
                }
                try {
                    iB = bVarB.b();
                    if (!bVarB.g()) {
                        strF = bVarB.f();
                    }
                } catch (Throwable unused) {
                    i2 = iB;
                    z3 = z2;
                    z2 = z3;
                    iB = i2;
                }
                com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.f740b, z2, iB, System.currentTimeMillis() - jCurrentTimeMillis);
                return new com.bytedance.sdk.openadsdk.d.e(z2, iB, strF, z);
            } catch (Throwable unused2) {
                i2 = 0;
                z = false;
            }
        } catch (Throwable unused3) {
            com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.f740b, false, 0, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.d.e(false, 0, "error unknown", false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public b.b.a.a.d.e.c.a a() {
        b.b.a.a.d.e.c.a aVarA = null;
        if (!com.bytedance.sdk.openadsdk.core.settings.j.a()) {
            return null;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.m.i.d.a("tpl_fetch_model", "date", 0L);
        if (jCurrentTimeMillis <= o.d().V() && jCurrentTimeMillis >= 0) {
            String strA = com.bytedance.sdk.openadsdk.m.i.d.a("tpl_fetch_model", DeviceRequestsHelper.DEVICE_INFO_MODEL, "");
            try {
                if (!TextUtils.isEmpty(strA)) {
                    return b.b.a.a.d.e.c.a.a(strA);
                }
            } catch (Exception unused) {
            }
        }
        b.b.a.a.j.d.b bVarB = com.bytedance.sdk.openadsdk.n.c.b().d().b();
        try {
            bVarB.b(com.bytedance.sdk.openadsdk.g.d.a(bVarB, o.d().d0()));
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.m.b("NetApiImpl", e2.getMessage());
        }
        b.b.a.a.j.b bVarB2 = bVarB.b();
        if (bVarB2 == null) {
            return null;
        }
        try {
            if (!bVarB2.g()) {
                return null;
            }
            String strA2 = bVarB2.a();
            aVarA = b.b.a.a.d.e.c.a.a(strA2);
            com.bytedance.sdk.openadsdk.m.i.d.a("tpl_fetch_model", "date", Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.m.i.d.b("tpl_fetch_model", DeviceRequestsHelper.DEVICE_INFO_MODEL, strA2);
            return aVarA;
        } catch (Exception unused2) {
            return aVarA;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(String str) {
        b.b.a.a.j.d.b bVarB = com.bytedance.sdk.openadsdk.n.c.b().d().b();
        bVarB.b(str);
        bVarB.a(new h(this));
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(JSONObject jSONObject, String str) {
        b.b.a.a.j.d.d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
        dVarD.b(str);
        dVarD.a(jSONObject);
        dVarD.a(new i(this));
    }
}
