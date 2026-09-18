package com.kakao.adfit.h;

import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tapjoy.TapjoyConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.a, reason: from toString */
/* JADX INFO: compiled from: MatrixApp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\u000bBC\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u001a\u0010\u0010R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/kakao/adfit/h/a;", "", "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "getName", "setName", "name", "c", "getVersionName", "setVersionName", "versionName", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "setVersionCode", "versionCode", "Lcom/kakao/adfit/h/d;", "e", "Lcom/kakao/adfit/h/d;", "getStartTime", "()Lcom/kakao/adfit/h/d;", "setStartTime", "(Lcom/kakao/adfit/h/d;)V", "startTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/adfit/h/d;)V", InneractiveMediationDefs.GENDER_FEMALE, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixApp {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String id;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private String versionName;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private String versionCode;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private d startTime;

    /* JADX INFO: renamed from: com.kakao.adfit.h.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: MatrixApp.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/kakao/adfit/h/a$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/a;", "a", "", "KEY_ID", "Ljava/lang/String;", "KEY_NAME", "KEY_START_TIME", "KEY_VERSION_CODE", "KEY_VERSION_NAME", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixApp a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String strE = com.kakao.adfit.k.p.e(json, "app_identifier");
            String strE2 = com.kakao.adfit.k.p.e(json, NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
            String strE3 = com.kakao.adfit.k.p.e(json, TapjoyConstants.TJC_APP_VERSION_NAME);
            String strE4 = com.kakao.adfit.k.p.e(json, "app_build");
            String strE5 = com.kakao.adfit.k.p.e(json, "app_start_time");
            return new MatrixApp(strE, strE2, strE3, strE4, strE5 != null ? d.INSTANCE.a(strE5) : null);
        }
    }

    public MatrixApp() {
        this(null, null, null, null, null, 31, null);
    }

    public MatrixApp(String str, String str2, String str3, String str4, d dVar) {
        this.id = str;
        this.name = str2;
        this.versionName = str3;
        this.versionCode = str4;
        this.startTime = dVar;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getVersionCode() {
        return this.versionCode;
    }

    public final JSONObject b() throws JSONException {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("app_identifier", this.id).putOpt(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, this.name).putOpt(TapjoyConstants.TJC_APP_VERSION_NAME, this.versionName).putOpt("app_build", this.versionCode);
        d dVar = this.startTime;
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("app_start_time", dVar != null ? dVar.getTimestamp() : null);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt2, "JSONObject()\n           …E, startTime?.toString())");
        return jSONObjectPutOpt2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixApp)) {
            return false;
        }
        MatrixApp matrixApp = (MatrixApp) other;
        return Intrinsics.areEqual(this.id, matrixApp.id) && Intrinsics.areEqual(this.name, matrixApp.name) && Intrinsics.areEqual(this.versionName, matrixApp.versionName) && Intrinsics.areEqual(this.versionCode, matrixApp.versionCode) && Intrinsics.areEqual(this.startTime, matrixApp.startTime);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.versionName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.versionCode;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        d dVar = this.startTime;
        return iHashCode4 + (dVar != null ? dVar.hashCode() : 0);
    }

    public String toString() {
        return "MatrixApp(id=" + this.id + ", name=" + this.name + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", startTime=" + this.startTime + ')';
    }

    public /* synthetic */ MatrixApp(String str, String str2, String str3, String str4, d dVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : dVar);
    }
}
