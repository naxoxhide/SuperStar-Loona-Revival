package com.kakao.adfit.h;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.n, reason: from toString */
/* JADX INFO: compiled from: MatrixStackFrame.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001\u0003BO\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006,"}, d2 = {"Lcom/kakao/adfit/h/n;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "setModule", "(Ljava/lang/String;)V", "module", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getFunction", "setFunction", "function", "c", "getFileName", "setFileName", "fileName", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/lang/Integer;", "getLineNumber", "()Ljava/lang/Integer;", "setLineNumber", "(Ljava/lang/Integer;)V", "lineNumber", "e", "Ljava/lang/Boolean;", "isInApp", "()Ljava/lang/Boolean;", "setInApp", "(Ljava/lang/Boolean;)V", InneractiveMediationDefs.GENDER_FEMALE, "isNative", "setNative", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "g", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixStackFrame {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String module;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String function;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private String fileName;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private Integer lineNumber;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private Boolean isInApp;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private Boolean isNative;

    /* JADX INFO: renamed from: com.kakao.adfit.h.n$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixStackFrame.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/kakao/adfit/h/n$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/n;", "a", "", "KEY_FILE_NAME", "Ljava/lang/String;", "KEY_FUNCTION", "KEY_IS_IN_APP", "KEY_IS_NATIVE", "KEY_LINE_NUMBER", "KEY_MODULE", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixStackFrame a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new MatrixStackFrame(com.kakao.adfit.k.p.e(json, "module"), com.kakao.adfit.k.p.e(json, "function"), com.kakao.adfit.k.p.e(json, "filename"), com.kakao.adfit.k.p.c(json, "lineno"), com.kakao.adfit.k.p.a(json, "in_app"), com.kakao.adfit.k.p.a(json, "native"));
        }
    }

    public MatrixStackFrame() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MatrixStackFrame(String str, String str2, String str3, Integer num, Boolean bool, Boolean bool2) {
        this.module = str;
        this.function = str2;
        this.fileName = str3;
        this.lineNumber = num;
        this.isInApp = bool;
        this.isNative = bool2;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("module", this.module).putOpt("function", this.function).putOpt("filename", this.fileName).putOpt("lineno", this.lineNumber).putOpt("in_app", this.isInApp).putOpt("native", this.isNative);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt, "JSONObject()\n           …(KEY_IS_NATIVE, isNative)");
        return jSONObjectPutOpt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixStackFrame)) {
            return false;
        }
        MatrixStackFrame matrixStackFrame = (MatrixStackFrame) other;
        return Intrinsics.areEqual(this.module, matrixStackFrame.module) && Intrinsics.areEqual(this.function, matrixStackFrame.function) && Intrinsics.areEqual(this.fileName, matrixStackFrame.fileName) && Intrinsics.areEqual(this.lineNumber, matrixStackFrame.lineNumber) && Intrinsics.areEqual(this.isInApp, matrixStackFrame.isInApp) && Intrinsics.areEqual(this.isNative, matrixStackFrame.isNative);
    }

    public int hashCode() {
        String str = this.module;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.function;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lineNumber;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isInApp;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isNative;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "MatrixStackFrame(module=" + this.module + ", function=" + this.function + ", fileName=" + this.fileName + ", lineNumber=" + this.lineNumber + ", isInApp=" + this.isInApp + ", isNative=" + this.isNative + ')';
    }

    public /* synthetic */ MatrixStackFrame(String str, String str2, String str3, Integer num, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2);
    }
}
