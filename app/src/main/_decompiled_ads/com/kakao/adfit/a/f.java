package com.kakao.adfit.a;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\f\u0010\u0001\u001a\u00020\u0000*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"Lcom/kakao/adfit/a/e;", "a", "Lorg/json/JSONObject;", "library_networkRelease"}, k = 2, mv = {1, 6, 0})
public final class f {
    public static final e a() {
        return new e();
    }

    public static final e a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("events");
        return jSONArrayOptJSONArray != null ? new e(jSONArrayOptJSONArray) : a();
    }
}
