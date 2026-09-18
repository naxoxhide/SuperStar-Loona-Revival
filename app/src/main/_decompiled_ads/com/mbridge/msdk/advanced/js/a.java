package com.mbridge.msdk.advanced.js;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAdvancedJsUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static String a = "NativeAdvancedJsUtils";

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

    public static void a(WebView webView, String str, String str2) {
        g.a().a(webView, str, str2);
    }

    public static void a(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sq", 1);
            jSONObject.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            g.a().a(webView, "thirdPartyCalled", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void a(WebView webView) {
        aa.d(a, "fireOnSignalCommunication");
        g.a().a(webView);
    }

    public static void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", com.mbridge.msdk.mbsignalcommon.communication.b.f2325b);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            aa.a(a, e.getMessage());
        }
    }
}
