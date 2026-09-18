package com.kakao.adfit.h;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.q, reason: from toString */
/* JADX INFO: compiled from: MatrixUser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0013\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/kakao/adfit/h/q;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "<init>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixUser {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String id;

    /* JADX INFO: renamed from: com.kakao.adfit.h.q$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixUser.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/h/q$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/q;", "a", "", "KEY_ID", "Ljava/lang/String;", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixUser a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new MatrixUser(com.kakao.adfit.k.p.e(json, "id"));
        }
    }

    public MatrixUser() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MatrixUser(String str) {
        this.id = str;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("id", this.id);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt, "JSONObject()\n            .putOpt(KEY_ID, id)");
        return jSONObjectPutOpt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MatrixUser) && Intrinsics.areEqual(this.id, ((MatrixUser) other).id);
    }

    public int hashCode() {
        String str = this.id;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "MatrixUser(id=" + this.id + ')';
    }

    public /* synthetic */ MatrixUser(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
