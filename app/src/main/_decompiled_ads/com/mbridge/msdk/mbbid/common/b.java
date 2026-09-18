package com.mbridge.msdk.mbbid.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.out.BidConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BidCommon.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends a {
    public static Map<String, String> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONArray f2280b;

    public static String a(Context context, String str) {
        HashMap map = new HashMap();
        map.put(BidConstants.BID_FILTER_KEY_UNIT_ID, str);
        return a(context, map);
    }

    public static String a(Context context, Map<String, String> map) {
        String md5;
        a = map;
        try {
            if (com.mbridge.msdk.foundation.controller.b.d().g() == null) {
                com.mbridge.msdk.foundation.controller.b.d().b(context);
            }
            if (f2280b == null) {
                f2280b = d.a().g(com.mbridge.msdk.foundation.controller.b.d().h()).i();
            }
            md5 = SameMD5.getMD5(af.c());
            try {
                if (b(context, md5)) {
                    return "";
                }
                Map<String, String> map2 = a;
                return a.a(context, (map2 == null || !map2.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) ? "" : a.get(BidConstants.BID_FILTER_KEY_UNIT_ID), md5);
            } catch (Exception unused) {
                return a.a(context, "", md5);
            }
        } catch (Exception unused2) {
            md5 = "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x014a A[Catch: all -> 0x029b, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01a5 A[Catch: all -> 0x029b, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01e7 A[Catch: all -> 0x029b, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01ef A[Catch: all -> 0x029b, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x021f A[Catch: all -> 0x029b, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0250 A[Catch: all -> 0x029b, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0287 A[Catch: all -> 0x029b, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0293 A[Catch: all -> 0x029b, TRY_LEAVE, TryCatch #4 {all -> 0x029b, blocks: (B:69:0x0140, B:71:0x014a, B:73:0x01a5, B:75:0x01ab, B:76:0x01c9, B:78:0x01e7, B:80:0x01ef, B:81:0x0215, B:83:0x021f, B:84:0x0246, B:86:0x0250, B:87:0x0277, B:89:0x0287, B:90:0x0293), top: B:109:0x0140 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:97:0x02ac A[ORIG_RETURN, RETURN] */
    private static boolean b(Context context, String str) {
        Exception exc;
        int i;
        int i2;
        Context contextG;
        StringBuffer stringBufferAppend;
        Map<String, String> map;
        StringBuffer stringBufferAppend2;
        int i3;
        int i4;
        JSONArray jSONArray = f2280b;
        int i5 = 2;
        int i6 = 0;
        if (jSONArray == null || jSONArray.length() == 0) {
            a(str, 2);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        int i7 = 0;
        while (true) {
            try {
                if (i7 < f2280b.length()) {
                    JSONObject jSONObjectOptJSONObject = f2280b.optJSONObject(i7);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("key_tpl");
                        String strOptString2 = jSONObjectOptJSONObject.optString("key_value");
                        Object objValueOf = 0L;
                        if (context != null) {
                            String simpleName = "";
                            if (objValueOf != null) {
                                try {
                                    simpleName = objValueOf.getClass().getSimpleName();
                                } catch (Exception e) {
                                    int i8 = i6;
                                    exc = e;
                                    i = i8;
                                    exc.printStackTrace();
                                    i2 = 0;
                                    contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                                    if (contextG != null) {
                                        StringBuffer stringBufferAppend3 = new StringBuffer().append("filter=" + i5 + "&");
                                        stringBufferAppend3.append("network_type=" + w.r(contextG) + "&");
                                        stringBufferAppend = stringBufferAppend3.append("timeout=" + i + "&");
                                        if (jSONObject != null) {
                                            stringBufferAppend.append("hitNode=" + jSONObject.toString() + "&");
                                        }
                                        stringBufferAppend.append("hitRate=" + i2 + "&");
                                        map = a;
                                        if (map != null) {
                                            if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                                                stringBufferAppend.append("unit_id=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_UNIT_ID)) + "&");
                                            }
                                            if (a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                                                stringBufferAppend = stringBufferAppend.append("placementId=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) + "&");
                                            }
                                            if (a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                                                stringBufferAppend = stringBufferAppend.append("adType=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_AD_TYPE)) + "&");
                                            }
                                        }
                                        stringBufferAppend2 = stringBufferAppend.append("key=2000122");
                                        if (k.a().c()) {
                                            k.a().a(stringBufferAppend2.toString());
                                        } else {
                                            q.b(contextG, stringBufferAppend2.toString());
                                        }
                                    }
                                    a(str, i5);
                                    if (i5 == 1) {
                                        return true;
                                    }
                                    return false;
                                }
                            }
                            SharedPreferences sharedPreferences = context.getSharedPreferences("share_date_setting_filter", i6);
                            if ("String".equals(simpleName)) {
                                objValueOf = sharedPreferences.getString(strOptString2, (String) objValueOf);
                            } else if ("Integer".equals(simpleName)) {
                                objValueOf = Integer.valueOf(sharedPreferences.getInt(strOptString2, ((Integer) objValueOf).intValue()));
                            } else if ("Boolean".equals(simpleName)) {
                                objValueOf = Boolean.valueOf(sharedPreferences.getBoolean(strOptString2, ((Boolean) objValueOf).booleanValue()));
                            } else if ("Float".equals(simpleName)) {
                                objValueOf = Float.valueOf(sharedPreferences.getFloat(strOptString2, ((Float) objValueOf).floatValue()));
                            } else if ("Long".equals(simpleName)) {
                                objValueOf = Long.valueOf(sharedPreferences.getLong(strOptString2, ((Long) objValueOf).longValue()));
                            }
                        }
                        long jLongValue = ((Long) objValueOf).longValue();
                        if (a(strOptString, strOptString2)) {
                            try {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                try {
                                    if (jLongValue > 0) {
                                        if (jCurrentTimeMillis - jLongValue >= ((long) jSONObjectOptJSONObject.optInt("ttl")) * 1000) {
                                            a(context, strOptString2, jCurrentTimeMillis);
                                            i = 1;
                                            i4 = 0;
                                        } else {
                                            try {
                                                int i9 = jSONObjectOptJSONObject.optDouble("rate") * 100.0d >= ((double) new Random().nextInt(100)) ? 1 : 2;
                                                i4 = i9;
                                                i5 = i9;
                                                i = 2;
                                            } catch (Exception e2) {
                                                exc = e2;
                                                i = 2;
                                                jSONObject = jSONObjectOptJSONObject;
                                                exc.printStackTrace();
                                                i2 = 0;
                                            }
                                        }
                                        i5 = i5;
                                        i3 = i4;
                                        jSONObject = jSONObjectOptJSONObject;
                                        break;
                                    }
                                    a(context, strOptString2, jCurrentTimeMillis);
                                    i = 1;
                                    jSONObject = jSONObjectOptJSONObject;
                                } catch (Exception e3) {
                                    exc = e3;
                                    i = 1;
                                }
                            } catch (Exception e4) {
                                exc = e4;
                                jSONObject = jSONObjectOptJSONObject;
                                i = 0;
                                exc.printStackTrace();
                                i2 = 0;
                                contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                                if (contextG != null) {
                                    StringBuffer stringBufferAppend4 = new StringBuffer().append("filter=" + i5 + "&");
                                    stringBufferAppend4.append("network_type=" + w.r(contextG) + "&");
                                    stringBufferAppend = stringBufferAppend4.append("timeout=" + i + "&");
                                    if (jSONObject != null) {
                                        stringBufferAppend.append("hitNode=" + jSONObject.toString() + "&");
                                    }
                                    stringBufferAppend.append("hitRate=" + i2 + "&");
                                    map = a;
                                    if (map != null) {
                                        if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                                            stringBufferAppend.append("unit_id=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_UNIT_ID)) + "&");
                                        }
                                        if (a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                                            stringBufferAppend = stringBufferAppend.append("placementId=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) + "&");
                                        }
                                        if (a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                                            stringBufferAppend = stringBufferAppend.append("adType=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_AD_TYPE)) + "&");
                                        }
                                    }
                                    stringBufferAppend2 = stringBufferAppend.append("key=2000122");
                                    if (k.a().c()) {
                                        k.a().a(stringBufferAppend2.toString());
                                    } else {
                                        q.b(contextG, stringBufferAppend2.toString());
                                    }
                                }
                                a(str, i5);
                                if (i5 == 1) {
                                    return true;
                                }
                                return false;
                            }
                        }
                    }
                    i7++;
                    i6 = 0;
                } else {
                    i = 0;
                }
                i3 = 0;
                break;
            } catch (Exception e5) {
                exc = e5;
            }
        }
        int i10 = i5;
        i2 = i3;
        i5 = i10;
        try {
            contextG = com.mbridge.msdk.foundation.controller.b.d().g();
            if (contextG != null) {
                StringBuffer stringBufferAppend5 = new StringBuffer().append("filter=" + i5 + "&");
                stringBufferAppend5.append("network_type=" + w.r(contextG) + "&");
                stringBufferAppend = stringBufferAppend5.append("timeout=" + i + "&");
                if (jSONObject != null && jSONObject.length() > 0) {
                    stringBufferAppend.append("hitNode=" + jSONObject.toString() + "&");
                }
                stringBufferAppend.append("hitRate=" + i2 + "&");
                map = a;
                if (map != null) {
                    if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                        stringBufferAppend.append("unit_id=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_UNIT_ID)) + "&");
                    }
                    if (a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                        stringBufferAppend = stringBufferAppend.append("placementId=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) + "&");
                    }
                    if (a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                        stringBufferAppend = stringBufferAppend.append("adType=" + String.valueOf(a.get(BidConstants.BID_FILTER_KEY_AD_TYPE)) + "&");
                    }
                }
                stringBufferAppend2 = stringBufferAppend.append("key=2000122");
                if (k.a().c()) {
                    k.a().a(stringBufferAppend2.toString());
                } else {
                    q.b(contextG, stringBufferAppend2.toString());
                }
            }
        } catch (Throwable th) {
            aa.d("BidCommon", th.getMessage());
        }
        a(str, i5);
        if (i5 == 1) {
            return true;
        }
        return false;
    }

    private static void a(Context context, String str, long j) {
        ah.a(context, str, Long.valueOf(j));
    }

    private static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        for (String str3 : str.split("-")) {
            if (!TextUtils.isEmpty(str3) && str3.length() > 2 && str3.startsWith("{") && str3.endsWith("}")) {
                String strSubstring = str3.substring(1, str3.length() - 1);
                Map<String, String> map = a;
                if (map != null && map.containsKey(strSubstring)) {
                    String strValueOf = String.valueOf(a.get(strSubstring));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        str = str.replace(str3, strValueOf + "");
                    }
                } else if (BidConstants.BID_FILTER_KEY_NETWORK.equals(str3)) {
                    str = str.replace(str3, w.r(com.mbridge.msdk.foundation.controller.b.d().g()) + "");
                }
            }
        }
        return str.equals(str2);
    }

    private static void a(String str, int i) {
        String str2;
        String str3;
        Map<String, String> map = a;
        if (map != null) {
            String str4 = map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID) ? a.get(BidConstants.BID_FILTER_KEY_UNIT_ID) : "";
            if (a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                str2 = str4;
                str3 = a.get(BidConstants.BID_FILTER_KEY_AD_TYPE);
            } else {
                str2 = str4;
                str3 = "";
            }
        } else {
            str2 = "";
            str3 = str2;
        }
        HashMap map2 = new HashMap();
        map2.put("filter", i + "");
        m.a().a("2000124", str, "buyer_id", str2, str3, map2);
    }
}
