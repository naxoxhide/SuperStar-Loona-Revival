package com.kakao.adfit.a;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/kakao/adfit/a/n;", "", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "viewable", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "ext", "", "c", "()Ljava/lang/Long;", "viewableTime", "", "()Ljava/lang/Float;", "viewableArea", "refreshInterval", "source", "<init>", "(Lorg/json/JSONObject;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class n {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final JSONObject viewable;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private JSONObject ext;

    public n(JSONObject source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.viewable = source.optJSONObject("viewable");
        this.ext = source.optJSONObject("ext");
    }

    public final Long a() {
        String strOptString;
        Long longOrNull;
        JSONObject jSONObject = this.ext;
        if (jSONObject == null || (strOptString = jSONObject.optString("refreshInterval", null)) == null || (longOrNull = StringsKt.toLongOrNull(strOptString)) == null) {
            return null;
        }
        return Long.valueOf(longOrNull.longValue() * ((long) 1000));
    }

    public final Float b() {
        String strOptString;
        Integer intOrNull;
        JSONObject jSONObject = this.viewable;
        if (jSONObject == null || (strOptString = jSONObject.optString("area", null)) == null || (intOrNull = StringsKt.toIntOrNull(strOptString)) == null) {
            return null;
        }
        return Float.valueOf(Math.min(intOrNull.intValue(), 100) / 100);
    }

    public final Long c() {
        String strOptString;
        Long longOrNull;
        JSONObject jSONObject = this.viewable;
        if (jSONObject == null || (strOptString = jSONObject.optString("time", null)) == null || (longOrNull = StringsKt.toLongOrNull(strOptString)) == null) {
            return null;
        }
        return Long.valueOf(Math.max(longOrNull.longValue(), 500L));
    }
}
