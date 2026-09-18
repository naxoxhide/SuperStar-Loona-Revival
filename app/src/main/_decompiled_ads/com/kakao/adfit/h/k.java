package com.kakao.adfit.h;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.k, reason: from toString */
/* JADX INFO: compiled from: MatrixOs.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\u0003BC\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/kakao/adfit/h/k;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, MobileAdsBridge.versionMethodName, "setVersion", "version", "c", "getBuild", "setBuild", "build", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getKernelVersion", "setKernelVersion", "kernelVersion", "e", "Ljava/lang/Boolean;", "getRooted", "()Ljava/lang/Boolean;", "setRooted", "(Ljava/lang/Boolean;)V", "rooted", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", InneractiveMediationDefs.GENDER_FEMALE, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixOs {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String version;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private String build;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private String kernelVersion;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private Boolean rooted;

    /* JADX INFO: renamed from: com.kakao.adfit.h.k$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixOs.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/kakao/adfit/h/k$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/k;", "a", "", "KEY_BUILD", "Ljava/lang/String;", "KEY_KERNEL_VERSION", "KEY_NAME", "KEY_ROOTED", "KEY_VERSION", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixOs a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new MatrixOs(com.kakao.adfit.k.p.e(json, "name"), com.kakao.adfit.k.p.e(json, "version"), com.kakao.adfit.k.p.e(json, "build"), com.kakao.adfit.k.p.e(json, "kernel_version"), com.kakao.adfit.k.p.a(json, "rooted"));
        }
    }

    public MatrixOs() {
        this(null, null, null, null, null, 31, null);
    }

    public MatrixOs(String str, String str2, String str3, String str4, Boolean bool) {
        this.name = str;
        this.version = str2;
        this.build = str3;
        this.kernelVersion = str4;
        this.rooted = bool;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("name", this.name).putOpt("version", this.version).putOpt("build", this.build).putOpt("kernel_version", this.kernelVersion).putOpt("rooted", this.rooted);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt, "JSONObject()\n           …utOpt(KEY_ROOTED, rooted)");
        return jSONObjectPutOpt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixOs)) {
            return false;
        }
        MatrixOs matrixOs = (MatrixOs) other;
        return Intrinsics.areEqual(this.name, matrixOs.name) && Intrinsics.areEqual(this.version, matrixOs.version) && Intrinsics.areEqual(this.build, matrixOs.build) && Intrinsics.areEqual(this.kernelVersion, matrixOs.kernelVersion) && Intrinsics.areEqual(this.rooted, matrixOs.rooted);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.build;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.kernelVersion;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.rooted;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MatrixOs(name=" + this.name + ", version=" + this.version + ", build=" + this.build + ", kernelVersion=" + this.kernelVersion + ", rooted=" + this.rooted + ')';
    }

    public /* synthetic */ MatrixOs(String str, String str2, String str3, String str4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool);
    }
}
