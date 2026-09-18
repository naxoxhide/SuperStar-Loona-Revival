package com.kakao.adfit.h;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.h, reason: from toString */
/* JADX INFO: compiled from: MatrixException.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001\u0005BO\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0005\u0010\u0013R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\b\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0003\u0010\u0013R$\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u0005\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b\u0005\u0010#R$\u0010*\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u0005\u0010)¨\u0006."}, d2 = {"Lcom/kakao/adfit/h/h;", "", "Lorg/json/JSONObject;", "c", "", "a", "()Ljava/lang/Long;", "Lcom/kakao/adfit/h/i;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "module", "getType", "type", "getValue", "value", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/lang/Long;", "getThreadId", "(Ljava/lang/Long;)V", "threadId", "Lcom/kakao/adfit/h/o;", "e", "Lcom/kakao/adfit/h/o;", "getStacktrace", "()Lcom/kakao/adfit/h/o;", "(Lcom/kakao/adfit/h/o;)V", "stacktrace", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/kakao/adfit/h/i;", "getMechanism", "()Lcom/kakao/adfit/h/i;", "(Lcom/kakao/adfit/h/i;)V", "mechanism", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/kakao/adfit/h/o;Lcom/kakao/adfit/h/i;)V", "g", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixException {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String module;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String type;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private String value;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private Long threadId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private MatrixStackTrace stacktrace;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private MatrixMechanism mechanism;

    /* JADX INFO: renamed from: com.kakao.adfit.h.h$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixException.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/h/h$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/h;", "a", "", "KEY_MECHANISM", "Ljava/lang/String;", "KEY_MODULE", "KEY_STACKTRACE", "KEY_THREAD_ID", "KEY_TYPE", "KEY_VALUE", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixException a(JSONObject json) {
            MatrixStackTrace oVarA;
            MatrixMechanism matrixMechanismA;
            Intrinsics.checkNotNullParameter(json, "json");
            String strE = com.kakao.adfit.k.p.e(json, "module");
            String strE2 = com.kakao.adfit.k.p.e(json, "type");
            String strE3 = com.kakao.adfit.k.p.e(json, "value");
            Long lD = com.kakao.adfit.k.p.d(json, "thread_id");
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("stacktrace");
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                oVarA = MatrixStackTrace.INSTANCE.a(jSONObjectOptJSONObject);
            } else {
                oVarA = null;
            }
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("mechanism");
            if (jSONObjectOptJSONObject2 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(key)");
                matrixMechanismA = MatrixMechanism.INSTANCE.a(jSONObjectOptJSONObject2);
            } else {
                matrixMechanismA = null;
            }
            return new MatrixException(strE, strE2, strE3, lD, oVarA, matrixMechanismA);
        }
    }

    public MatrixException() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MatrixException(String str, String str2, String str3, Long l, MatrixStackTrace oVar, MatrixMechanism matrixMechanism) {
        this.module = str;
        this.type = str2;
        this.value = str3;
        this.threadId = l;
        this.stacktrace = oVar;
        this.mechanism = matrixMechanism;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getThreadId() {
        return this.threadId;
    }

    public final void a(String str) {
        this.module = str;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final MatrixMechanism getMechanism() {
        return this.mechanism;
    }

    public final void b(String str) {
        this.type = str;
    }

    public final void c(String str) {
        this.value = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixException)) {
            return false;
        }
        MatrixException matrixException = (MatrixException) other;
        return Intrinsics.areEqual(this.module, matrixException.module) && Intrinsics.areEqual(this.type, matrixException.type) && Intrinsics.areEqual(this.value, matrixException.value) && Intrinsics.areEqual(this.threadId, matrixException.threadId) && Intrinsics.areEqual(this.stacktrace, matrixException.stacktrace) && Intrinsics.areEqual(this.mechanism, matrixException.mechanism);
    }

    public int hashCode() {
        String str = this.module;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.value;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.threadId;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        MatrixStackTrace oVar = this.stacktrace;
        int iHashCode5 = (iHashCode4 + (oVar == null ? 0 : oVar.hashCode())) * 31;
        MatrixMechanism matrixMechanism = this.mechanism;
        return iHashCode5 + (matrixMechanism != null ? matrixMechanism.hashCode() : 0);
    }

    public String toString() {
        return "MatrixException(module=" + this.module + ", type=" + this.type + ", value=" + this.value + ", threadId=" + this.threadId + ", stacktrace=" + this.stacktrace + ", mechanism=" + this.mechanism + ')';
    }

    public final void a(Long l) {
        this.threadId = l;
    }

    public final JSONObject c() throws JSONException {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("module", this.module).putOpt("type", this.type).putOpt("value", this.value).putOpt("thread_id", this.threadId);
        MatrixStackTrace oVar = this.stacktrace;
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("stacktrace", oVar != null ? oVar.a() : null);
        MatrixMechanism matrixMechanism = this.mechanism;
        JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt("mechanism", matrixMechanism != null ? matrixMechanism.a() : null);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt3, "JSONObject()\n           …echanism?.toJsonObject())");
        return jSONObjectPutOpt3;
    }

    public final void a(MatrixStackTrace oVar) {
        this.stacktrace = oVar;
    }

    public final void a(MatrixMechanism matrixMechanism) {
        this.mechanism = matrixMechanism;
    }

    public /* synthetic */ MatrixException(String str, String str2, String str3, Long l, MatrixStackTrace oVar, MatrixMechanism matrixMechanism, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : oVar, (i & 32) != 0 ? null : matrixMechanism);
    }
}
