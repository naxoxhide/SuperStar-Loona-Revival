package com.kakao.adfit.k;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONObjects.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u0018\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\u00020\u0005H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\t*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\n\u001a\u001d\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0000¨\u0006\u0015"}, d2 = {"Lorg/json/JSONObject;", "", "", "", "a", "Lorg/json/JSONArray;", "", "value", SDKConstants.PARAM_KEY, "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "", "c", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Float;", "e", "library_networkRelease"}, k = 2, mv = {1, 6, 0})
public final class p {
    public static final Map<String, Object> a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        HashMap map = new HashMap(jSONObject.length());
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys()");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Object obj = jSONObject.get(key);
            Intrinsics.checkNotNullExpressionValue(obj, "this[key]");
            map.put(key, a(obj));
        }
        return map;
    }

    public static final Float b(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objOpt = jSONObject.opt(key);
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Float) {
            return (Float) objOpt;
        }
        if (objOpt instanceof Number) {
            return Float.valueOf(((Number) objOpt).floatValue());
        }
        if (objOpt instanceof String) {
            return StringsKt.toFloatOrNull((String) objOpt);
        }
        return null;
    }

    public static final Integer c(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objOpt = jSONObject.opt(key);
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Integer) {
            return (Integer) objOpt;
        }
        if (objOpt instanceof Number) {
            return Integer.valueOf(((Number) objOpt).intValue());
        }
        if (objOpt instanceof String) {
            return StringsKt.toIntOrNull((String) objOpt);
        }
        return null;
    }

    public static final Long d(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objOpt = jSONObject.opt(key);
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Long) {
            return (Long) objOpt;
        }
        if (objOpt instanceof Number) {
            return Long.valueOf(((Number) objOpt).longValue());
        }
        if (objOpt instanceof String) {
            return StringsKt.toLongOrNull((String) objOpt);
        }
        return null;
    }

    public static final String e(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objOpt = jSONObject.opt(key);
        if (objOpt != null) {
            return objOpt instanceof String ? (String) objOpt : objOpt.toString();
        }
        return null;
    }

    public static final List<Object> a(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "this[i]");
            arrayList.add(i, a(obj));
        }
        return arrayList;
    }

    private static final Object a(Object obj) {
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
        }
        return obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public static final Boolean a(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object objOpt = jSONObject.opt(key);
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Boolean) {
            return (Boolean) objOpt;
        }
        if (!(objOpt instanceof String)) {
            return null;
        }
        String str = (String) objOpt;
        if (StringsKt.equals(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (StringsKt.equals(str, TJAdUnitConstants.String.FALSE, true)) {
            return Boolean.FALSE;
        }
        return null;
    }
}
