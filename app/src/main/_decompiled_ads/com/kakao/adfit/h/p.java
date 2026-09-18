package com.kakao.adfit.h;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.p, reason: from toString */
/* JADX INFO: compiled from: MatrixThread.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 12\u00020\u0001:\u0001\fBg\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\f\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\f\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\f\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u0003\u0010\u001aR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b\f\u0010$R$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b\u0016\u0010*R$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)\"\u0004\b\u0003\u0010*R$\u0010.\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b\f\u0010*¨\u00062"}, d2 = {"Lcom/kakao/adfit/h/p;", "", "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/Long;", "()Ljava/lang/Long;", "(Ljava/lang/Long;)V", "id", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "priority", "c", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "name", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getState", "state", "Lcom/kakao/adfit/h/o;", "e", "Lcom/kakao/adfit/h/o;", "getStacktrace", "()Lcom/kakao/adfit/h/o;", "(Lcom/kakao/adfit/h/o;)V", "stacktrace", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/lang/Boolean;", "isDaemon", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "g", "isCurrent", "h", "isCrashed", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/adfit/h/o;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "i", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixThread {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private Long id;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private Integer priority;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private String name;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private String state;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private MatrixStackTrace stacktrace;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private Boolean isDaemon;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private Boolean isCurrent;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private Boolean isCrashed;

    /* JADX INFO: renamed from: com.kakao.adfit.h.p$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixThread.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/kakao/adfit/h/p$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/p;", "a", "", "KEY_ID", "Ljava/lang/String;", "KEY_IS_CRASHED", "KEY_IS_CURRENT", "KEY_IS_DAEMON", "KEY_NAME", "KEY_PRIORITY", "KEY_STACKTRACE", "KEY_STATE", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixThread a(JSONObject json) {
            MatrixStackTrace oVarA;
            Intrinsics.checkNotNullParameter(json, "json");
            Long lD = com.kakao.adfit.k.p.d(json, "id");
            Integer numC = com.kakao.adfit.k.p.c(json, "priority");
            String strE = com.kakao.adfit.k.p.e(json, "name");
            String strE2 = com.kakao.adfit.k.p.e(json, "state");
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("stacktrace");
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                oVarA = MatrixStackTrace.INSTANCE.a(jSONObjectOptJSONObject);
            } else {
                oVarA = null;
            }
            return new MatrixThread(lD, numC, strE, strE2, oVarA, com.kakao.adfit.k.p.a(json, "daemon"), com.kakao.adfit.k.p.a(json, "current"), com.kakao.adfit.k.p.a(json, "crashed"));
        }
    }

    public MatrixThread() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public MatrixThread(Long l, Integer num, String str, String str2, MatrixStackTrace oVar, Boolean bool, Boolean bool2, Boolean bool3) {
        this.id = l;
        this.priority = num;
        this.name = str;
        this.state = str2;
        this.stacktrace = oVar;
        this.isDaemon = bool;
        this.isCurrent = bool2;
        this.isCrashed = bool3;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    public final void b(String str) {
        this.state = str;
    }

    public final void c(Boolean bool) {
        this.isDaemon = bool;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixThread)) {
            return false;
        }
        MatrixThread matrixThread = (MatrixThread) other;
        return Intrinsics.areEqual(this.id, matrixThread.id) && Intrinsics.areEqual(this.priority, matrixThread.priority) && Intrinsics.areEqual(this.name, matrixThread.name) && Intrinsics.areEqual(this.state, matrixThread.state) && Intrinsics.areEqual(this.stacktrace, matrixThread.stacktrace) && Intrinsics.areEqual(this.isDaemon, matrixThread.isDaemon) && Intrinsics.areEqual(this.isCurrent, matrixThread.isCurrent) && Intrinsics.areEqual(this.isCrashed, matrixThread.isCrashed);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.priority;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.state;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MatrixStackTrace oVar = this.stacktrace;
        int iHashCode5 = (iHashCode4 + (oVar == null ? 0 : oVar.hashCode())) * 31;
        Boolean bool = this.isDaemon;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isCurrent;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isCrashed;
        return iHashCode7 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "MatrixThread(id=" + this.id + ", priority=" + this.priority + ", name=" + this.name + ", state=" + this.state + ", stacktrace=" + this.stacktrace + ", isDaemon=" + this.isDaemon + ", isCurrent=" + this.isCurrent + ", isCrashed=" + this.isCrashed + ')';
    }

    public final void a(Long l) {
        this.id = l;
    }

    public final void b(Boolean bool) {
        this.isCurrent = bool;
    }

    public final void a(Integer num) {
        this.priority = num;
    }

    public final JSONObject b() throws JSONException {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("id", this.id).putOpt("priority", this.priority).putOpt("name", this.name).putOpt("state", this.state);
        MatrixStackTrace oVar = this.stacktrace;
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("stacktrace", oVar != null ? oVar.a() : null).putOpt("daemon", this.isDaemon).putOpt("current", this.isCurrent).putOpt("crashed", this.isCrashed);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt2, "JSONObject()\n           …EY_IS_CRASHED, isCrashed)");
        return jSONObjectPutOpt2;
    }

    public final void a(String str) {
        this.name = str;
    }

    public final void a(MatrixStackTrace oVar) {
        this.stacktrace = oVar;
    }

    public final void a(Boolean bool) {
        this.isCrashed = bool;
    }

    public /* synthetic */ MatrixThread(Long l, Integer num, String str, String str2, MatrixStackTrace oVar, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : oVar, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2, (i & 128) == 0 ? bool3 : null);
    }
}
