package com.kakao.adfit.h;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.common.matrix.MatrixLevel;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.b, reason: from toString */
/* JADX INFO: compiled from: MatrixBreadcrumb.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b\u000b\b\u0086\b\u0018\u0000 02\u00020\u0001:\u0001\u0003B[\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010&¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010 R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/kakao/adfit/h/b;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/kakao/adfit/h/d;", "Lcom/kakao/adfit/h/d;", "getTimestamp", "()Lcom/kakao/adfit/h/d;", "setTimestamp", "(Lcom/kakao/adfit/h/d;)V", "timestamp", "Lcom/kakao/adfit/common/matrix/MatrixLevel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/common/matrix/MatrixLevel;", "getLevel", "()Lcom/kakao/adfit/common/matrix/MatrixLevel;", "level", "c", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "category", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getType", "setType", "(Ljava/lang/String;)V", "type", "e", "getMessage", "setMessage", "message", "", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "data", "<init>", "(Lcom/kakao/adfit/h/d;Lcom/kakao/adfit/common/matrix/MatrixLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "g", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixBreadcrumb {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private d timestamp;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final MatrixLevel level;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String category;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private String type;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private String message;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private Map<String, ? extends Object> data;

    /* JADX INFO: renamed from: com.kakao.adfit.h.b$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixBreadcrumb.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/kakao/adfit/h/b$a;", "", "", "message", "category", "Lcom/kakao/adfit/common/matrix/MatrixLevel;", "level", "Lcom/kakao/adfit/h/b;", "a", "Lorg/json/JSONObject;", "json", "KEY_CATEGORY", "Ljava/lang/String;", "KEY_DATA", "KEY_LEVEL", "KEY_MESSAGE", "KEY_TIMESTAMP", "KEY_TYPE", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MatrixBreadcrumb a(Companion companion, String str, String str2, MatrixLevel matrixLevel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                matrixLevel = null;
            }
            return companion.a(str, str2, matrixLevel);
        }

        @JvmStatic
        public final MatrixBreadcrumb a(String message, String category, MatrixLevel level) {
            return new MatrixBreadcrumb(d.INSTANCE.a(), level, category, null, message, null, 40, null);
        }

        @JvmStatic
        public final MatrixBreadcrumb a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String strE = com.kakao.adfit.k.p.e(json, "timestamp");
            Map<String, Object> mapA = null;
            d dVarA = strE != null ? d.INSTANCE.a(strE) : null;
            String strE2 = com.kakao.adfit.k.p.e(json, "level");
            MatrixLevel matrixLevelA = strE2 != null ? MatrixLevel.INSTANCE.a(strE2) : null;
            String strE3 = com.kakao.adfit.k.p.e(json, "category");
            String strE4 = com.kakao.adfit.k.p.e(json, "type");
            String strE5 = com.kakao.adfit.k.p.e(json, "message");
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                mapA = com.kakao.adfit.k.p.a(jSONObjectOptJSONObject);
            }
            return new MatrixBreadcrumb(dVarA, matrixLevelA, strE3, strE4, strE5, mapA);
        }
    }

    public MatrixBreadcrumb() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MatrixBreadcrumb(d dVar, MatrixLevel matrixLevel, String str, String str2, String str3, Map<String, ? extends Object> map) {
        this.timestamp = dVar;
        this.level = matrixLevel;
        this.category = str;
        this.type = str2;
        this.message = str3;
        this.data = map;
    }

    public final JSONObject a() throws JSONException {
        String lowerCase;
        String string;
        JSONObject jSONObject = new JSONObject();
        d dVar = this.timestamp;
        JSONObject jSONObject2 = null;
        JSONObject jSONObjectPutOpt = jSONObject.putOpt("timestamp", dVar != null ? dVar.getTimestamp() : null);
        MatrixLevel matrixLevel = this.level;
        if (matrixLevel == null || (string = matrixLevel.toString()) == null) {
            lowerCase = null;
        } else {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            lowerCase = string.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        }
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("level", lowerCase).putOpt("category", this.category).putOpt("type", this.type).putOpt("message", this.message);
        Map<String, ? extends Object> map = this.data;
        if (map != null) {
            jSONObject2 = new JSONObject();
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt("data", jSONObject2);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt3, "JSONObject()\n           …TA, data?.toJsonObject())");
        return jSONObjectPutOpt3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixBreadcrumb)) {
            return false;
        }
        MatrixBreadcrumb matrixBreadcrumb = (MatrixBreadcrumb) other;
        return Intrinsics.areEqual(this.timestamp, matrixBreadcrumb.timestamp) && this.level == matrixBreadcrumb.level && Intrinsics.areEqual(this.category, matrixBreadcrumb.category) && Intrinsics.areEqual(this.type, matrixBreadcrumb.type) && Intrinsics.areEqual(this.message, matrixBreadcrumb.message) && Intrinsics.areEqual(this.data, matrixBreadcrumb.data);
    }

    public int hashCode() {
        d dVar = this.timestamp;
        int iHashCode = (dVar == null ? 0 : dVar.hashCode()) * 31;
        MatrixLevel matrixLevel = this.level;
        int iHashCode2 = (iHashCode + (matrixLevel == null ? 0 : matrixLevel.hashCode())) * 31;
        String str = this.category;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.type;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, ? extends Object> map = this.data;
        return iHashCode5 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "MatrixBreadcrumb(timestamp=" + this.timestamp + ", level=" + this.level + ", category=" + this.category + ", type=" + this.type + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public /* synthetic */ MatrixBreadcrumb(d dVar, MatrixLevel matrixLevel, String str, String str2, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dVar, (i & 2) != 0 ? null : matrixLevel, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : map);
    }
}
