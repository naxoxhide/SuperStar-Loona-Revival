package com.mbridge.msdk.splash.signal;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SplashSignalUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static String a = "SplashSignalUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2452b = 0;
    private static int c = 1;

    public static void a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        JSONArray jSONArray;
        int i;
        boolean z;
        String str3;
        String str4 = "";
        JSONObject jSONObject2 = new JSONObject();
        String str5 = "message";
        int i2 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e) {
                aa.a(a, e.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray2 = jSONObject.getJSONArray("resource");
            try {
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    int length = jSONArray2.length();
                    int i3 = 0;
                    while (i3 < length) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        String strOptString = jSONObject3.optString("ref", str4);
                        int i4 = jSONObject3.getInt("type");
                        JSONObject jSONObject4 = new JSONObject();
                        if (i4 == i2 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            m mVarA = p.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(strOptString);
                            if (mVarA != null) {
                                jSONArray = jSONArray2;
                                i = length;
                                aa.a(a, "VideoBean not null");
                                jSONObject5.put("type", 1);
                                jSONObject5.put("videoDataLength", mVarA.c());
                                String strE = mVarA.e();
                                str2 = str5;
                                if (TextUtils.isEmpty(strE)) {
                                    aa.a(a, "VideoPath null");
                                    jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str4);
                                    jSONObject5.put("path4Web", str4);
                                } else {
                                    aa.a(a, "VideoPath not null");
                                    jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, strE);
                                    jSONObject5.put("path4Web", strE);
                                }
                                if (mVarA.d() == 5) {
                                    jSONObject5.put("downloaded", 1);
                                    z = false;
                                } else {
                                    z = false;
                                    jSONObject5.put("downloaded", 0);
                                }
                                jSONObject4.put(strOptString, jSONObject5);
                                jSONArray3.put(jSONObject4);
                            } else {
                                str4 = str4;
                                str2 = str5;
                                jSONArray = jSONArray2;
                                i = length;
                                z = false;
                                aa.a(a, "VideoBean null");
                            }
                        } else {
                            str4 = str4;
                            str2 = str5;
                            jSONArray = jSONArray2;
                            i = length;
                            z = false;
                            if (i4 == 2 && !TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 2);
                                jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, com.mbridge.msdk.videocommon.download.g.a().b(strOptString) == null ? str4 : com.mbridge.msdk.videocommon.download.g.a().b(strOptString));
                                jSONObject4.put(strOptString, jSONObject6);
                                jSONArray3.put(jSONObject4);
                            } else if (i4 == 3 && !TextUtils.isEmpty(strOptString)) {
                                try {
                                    File file = new File(strOptString);
                                    if (file.exists() && file.isFile() && file.canRead()) {
                                        aa.a(a, "getFileInfo Mraid file " + strOptString);
                                        str3 = "file:////" + strOptString;
                                    } else {
                                        str3 = str4;
                                    }
                                } catch (Throwable th) {
                                    if (MBridgeConstans.DEBUG) {
                                        th.printStackTrace();
                                    }
                                }
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("type", 3);
                                jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str3);
                                jSONObject4.put(strOptString, jSONObject7);
                                jSONArray3.put(jSONObject4);
                            } else if (i4 == 4 && !TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("type", 4);
                                jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, ae.a(strOptString) == null ? str4 : ae.a(strOptString));
                                jSONObject4.put(strOptString, jSONObject8);
                                jSONArray3.put(jSONObject4);
                            }
                        }
                        i3++;
                        jSONArray2 = jSONArray;
                        length = i;
                        str5 = str2;
                        str4 = str4;
                        i2 = 1;
                    }
                    jSONObject2.put("resource", jSONArray3);
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                }
                try {
                    jSONObject2.put("code", 1);
                    str = "message";
                    try {
                        try {
                            jSONObject2.put(str, "resource is null");
                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                jSONObject2.put("code", 1);
                                jSONObject2.put(str, th.getLocalizedMessage());
                                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            } catch (JSONException e2) {
                                aa.a(a, e2.getMessage());
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        aa.a(a, e.getMessage());
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str = "message";
                }
            } catch (Throwable th3) {
                th = th3;
                str = str2;
                jSONObject2.put("code", 1);
                jSONObject2.put(str, th.getLocalizedMessage());
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th4) {
            th = th4;
            str = str5;
        }
    }

    public static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            aa.d(a, "code to string is error");
            return "";
        }
    }

    public static void b(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject);
            if (campaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.signal.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVarA = k.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                        if (kVarA != null) {
                            if (!kVarA.a(campaignWithBackData.getId())) {
                                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                                gVar.a(campaignWithBackData.getId());
                                gVar.a(campaignWithBackData.getFca());
                                gVar.b(campaignWithBackData.getFcb());
                                gVar.d(0);
                                gVar.c(1);
                                gVar.a(System.currentTimeMillis());
                                kVarA.a(gVar);
                            } else {
                                kVarA.b(campaignWithBackData.getId());
                            }
                        }
                        c.a(campaignWithBackData.getCampaignUnitId(), campaignWithBackData);
                    } catch (Throwable th) {
                        aa.b(c.a, th.getMessage(), th);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", f2452b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                a(obj, e.getMessage());
                aa.a(a, e.getMessage());
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    private static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            aa.a(a, e.getMessage());
        }
    }

    public static void a(WebView webView, String str, String str2) {
        g.a().a(webView, str, str2);
    }

    public static void a(WebView webView) {
        aa.d(a, "fireOnSignalCommunication");
        g.a().a(webView);
    }

    static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (d.h == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        d.a(str, campaignEx, "splash");
    }
}
