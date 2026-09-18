package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.tools.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsFeedBackForH5 extends h {
    private static int e = 0;
    private static int f = 1;
    private String d = "AbsFeedBackForH5";

    public void feedbackOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                com.mbridge.msdk.foundation.c.b.a().a(jSONObject.optString(SDKConstants.PARAM_KEY, ""), iOptInt == 1 ? 8 : 0, aVar.a);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("width", -1);
                int iOptInt2 = jSONObject.optInt("height", -1);
                int iOptInt3 = jSONObject.optInt("left", -1);
                int iOptInt4 = jSONObject.optInt("top", -1);
                double dOptDouble = jSONObject.optDouble("opacity", 1.0d);
                int iOptInt5 = jSONObject.optInt("radius", 20);
                String strOptString = jSONObject.optString("fontColor", "");
                String strOptString2 = jSONObject.optString("bgColor", "");
                com.mbridge.msdk.foundation.c.b.a().a(jSONObject.optString(SDKConstants.PARAM_KEY, ""), iOptInt, iOptInt2, iOptInt5, iOptInt3, iOptInt4, (float) dOptDouble, strOptString, strOptString2, (float) jSONObject.optDouble("fontSize", -1.0d), jSONObject.optJSONArray("padding"));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                String strOptString = jSONObject.optString(SDKConstants.PARAM_KEY, "");
                final WindVaneWebView windVaneWebView = ((a) obj).a;
                com.mbridge.msdk.foundation.c.b.a().a(strOptString, iOptInt, new com.mbridge.msdk.foundation.c.a() { // from class: com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5.1
                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a() {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject2.put("status", 1);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th) {
                            aa.b(AbsFeedBackForH5.this.d, th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void b() {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject2.put("status", 2);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th) {
                            aa.b(AbsFeedBackForH5.this.d, th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.c.a
                    public final void a(String str2) {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.b.d().g() != null) {
                                jSONObject2.put("status", 2);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th) {
                            aa.b(AbsFeedBackForH5.this.d, th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }
                });
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", e);
            jSONObject.put("message", "");
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            aa.a(this.d, e2.getMessage());
        }
    }

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            aa.a(this.d, e2.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", e);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            aa.a(this.d, e2.getMessage());
        }
    }
}
