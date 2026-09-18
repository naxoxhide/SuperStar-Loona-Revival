package com.mbridge.msdk.mbsignalcommon.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: H5ReportManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String c = "a";
    private String d = "handlerNativeResult";
    int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2320b = 1;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: H5ReportManager.java */
    private static final class C0495a {
        private static a a = new a();
    }

    public static a a() {
        return C0495a.a;
    }

    public final void a(Object obj, String str, JSONArray jSONArray, int i) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        JSONObject jSONObjectOptJSONObject5;
        JSONObject jSONObjectOptJSONObject6;
        JSONObject jSONObjectOptJSONObject7;
        JSONObject jSONObjectOptJSONObject8;
        JSONObject jSONObjectOptJSONObject9;
        JSONObject jSONObjectOptJSONObject10;
        JSONObject jSONObjectOptJSONObject11;
        int i2;
        try {
            if (jSONArray == null) {
                a(this.f2320b, "called reporter failed, params empty", obj);
                return;
            }
            int length = jSONArray.length();
            if (length == 0) {
                a(this.f2320b, "called reporter failed, params empty", obj);
                return;
            }
            if ("reportMessageR".equalsIgnoreCase(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                int i3 = 0;
                while (true) {
                    i2 = length - 1;
                    if (i3 >= i2) {
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject12 = jSONArray.optJSONObject(i3);
                    if (jSONObjectOptJSONObject12 != null) {
                        stringBuffer = stringBuffer.append(jSONObjectOptJSONObject12.optString(SDKConstants.PARAM_KEY)).append("=").append(jSONObjectOptJSONObject12.opt("value")).append("&");
                    }
                    i3++;
                }
                JSONObject jSONObjectOptJSONObject13 = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject13 != null) {
                    stringBuffer = stringBuffer.append(jSONObjectOptJSONObject13.optString(SDKConstants.PARAM_KEY)).append("=").append(jSONObjectOptJSONObject13.opt("value"));
                }
                String string = stringBuffer.toString();
                Context contextG = b.d().g();
                if (contextG != null && !TextUtils.isEmpty(string)) {
                    try {
                        new com.mbridge.msdk.foundation.same.report.d.a(contextG).post(0, d.a().a, q.a(string, contextG), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.mbsignalcommon.a.a.1
                            @Override // com.mbridge.msdk.foundation.same.report.d.b
                            public final void onSuccess(String str2) {
                                aa.d(a.c, str2);
                            }

                            @Override // com.mbridge.msdk.foundation.same.report.d.b
                            public final void onFailed(String str2) {
                                aa.d(a.c, str2);
                            }
                        });
                    } catch (Exception e) {
                        aa.d(c, e.getMessage());
                    }
                }
            } else if ("reportMessageD".equalsIgnoreCase(str)) {
                String string2 = "";
                String string3 = (length <= 0 || (jSONObjectOptJSONObject11 = jSONArray.optJSONObject(0)) == null) ? "" : jSONObjectOptJSONObject11.getString("value");
                int i4 = -1;
                int i5 = (length <= 1 || (jSONObjectOptJSONObject10 = jSONArray.optJSONObject(1)) == null) ? -1 : jSONObjectOptJSONObject10.getInt("value");
                int i6 = (length <= 2 || (jSONObjectOptJSONObject9 = jSONArray.optJSONObject(2)) == null) ? -1 : jSONObjectOptJSONObject9.getInt("value");
                int i7 = (length <= 3 || (jSONObjectOptJSONObject8 = jSONArray.optJSONObject(3)) == null) ? -1 : jSONObjectOptJSONObject8.getInt("value");
                int i8 = (length <= 4 || (jSONObjectOptJSONObject7 = jSONArray.optJSONObject(4)) == null) ? -1 : jSONObjectOptJSONObject7.getInt("value");
                String string4 = (length <= 5 || (jSONObjectOptJSONObject6 = jSONArray.optJSONObject(5)) == null) ? "" : jSONObjectOptJSONObject6.getString("value");
                String string5 = (length <= 6 || (jSONObjectOptJSONObject5 = jSONArray.optJSONObject(6)) == null) ? "" : jSONObjectOptJSONObject5.getString("value");
                int i9 = (length <= 7 || (jSONObjectOptJSONObject4 = jSONArray.optJSONObject(7)) == null) ? -1 : jSONObjectOptJSONObject4.getInt("value");
                String string6 = (length <= 8 || (jSONObjectOptJSONObject3 = jSONArray.optJSONObject(8)) == null) ? "" : jSONObjectOptJSONObject3.getString("value");
                if (length > 9 && (jSONObjectOptJSONObject2 = jSONArray.optJSONObject(9)) != null) {
                    i4 = jSONObjectOptJSONObject2.getInt("value");
                }
                int i10 = i4;
                if (length > 10 && (jSONObjectOptJSONObject = jSONArray.optJSONObject(10)) != null) {
                    string2 = jSONObjectOptJSONObject.getString("value");
                }
                String str2 = string2;
                try {
                    Context contextG2 = b.d().g();
                    if (contextG2 != null) {
                        com.mbridge.msdk.foundation.db.q.a(h.a(contextG2)).a(new n(string3, i5, i6, i7, i8, string4, string5, i9, string6, i10, str2));
                    }
                } catch (Throwable th) {
                    aa.a(c, th.getMessage());
                }
            }
            a(this.a, "called reporter success", obj);
        } catch (Throwable th2) {
            aa.a(c, th2.getMessage());
            a(this.f2320b, "exception: " + th2.getMessage(), obj);
        }
    }

    private void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            aa.a(c, e.getMessage());
        } catch (Throwable th) {
            aa.a(c, th.getMessage());
        }
    }
}
