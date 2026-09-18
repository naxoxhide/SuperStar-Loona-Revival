package com.kakao.adfit.a;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, d2 = {"Lorg/json/JSONObject;", "Lcom/kakao/adfit/a/n;", "a", "", SDKConstants.PARAM_KEY, "library_networkRelease"}, k = 2, mv = {1, 6, 0})
public final class o {
    public static final n a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return new n(jSONObject);
    }

    public static final n a(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(key);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
        return a(jSONObjectOptJSONObject);
    }
}
