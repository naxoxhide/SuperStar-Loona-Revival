package com.kakao.adfit.h;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.c, reason: from toString */
/* JADX INFO: compiled from: MatrixContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\fB+\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\f\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\f\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u0012\u0010\u001a\"\u0004\b\f\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/kakao/adfit/h/c;", "", "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "", "toString", "", "hashCode", "other", "", "equals", "Lcom/kakao/adfit/h/a;", "a", "Lcom/kakao/adfit/h/a;", "()Lcom/kakao/adfit/h/a;", "(Lcom/kakao/adfit/h/a;)V", "app", "Lcom/kakao/adfit/h/k;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/h/k;", "c", "()Lcom/kakao/adfit/h/k;", "(Lcom/kakao/adfit/h/k;)V", "os", "Lcom/kakao/adfit/h/g;", "Lcom/kakao/adfit/h/g;", "()Lcom/kakao/adfit/h/g;", "(Lcom/kakao/adfit/h/g;)V", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "<init>", "(Lcom/kakao/adfit/h/a;Lcom/kakao/adfit/h/k;Lcom/kakao/adfit/h/g;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixContexts {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private MatrixApp app;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private MatrixOs os;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private MatrixDevice device;

    /* JADX INFO: renamed from: com.kakao.adfit.h.c$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixContexts.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/h/c$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/c;", "a", "", "KEY_APP", "Ljava/lang/String;", "KEY_DEVICE", "KEY_OS", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixContexts a(JSONObject json) {
            MatrixApp aVarA;
            MatrixOs kVarA;
            Intrinsics.checkNotNullParameter(json, "json");
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("app");
            MatrixDevice gVarA = null;
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(key)");
                aVarA = MatrixApp.INSTANCE.a(jSONObjectOptJSONObject);
            } else {
                aVarA = null;
            }
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("os");
            if (jSONObjectOptJSONObject2 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(key)");
                kVarA = MatrixOs.INSTANCE.a(jSONObjectOptJSONObject2);
            } else {
                kVarA = null;
            }
            JSONObject jSONObjectOptJSONObject3 = json.optJSONObject(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
            if (jSONObjectOptJSONObject3 != null) {
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject3, "optJSONObject(key)");
                gVarA = MatrixDevice.INSTANCE.a(jSONObjectOptJSONObject3);
            }
            return new MatrixContexts(aVarA, kVarA, gVarA);
        }
    }

    public MatrixContexts() {
        this(null, null, null, 7, null);
    }

    public MatrixContexts(MatrixApp aVar, MatrixOs kVar, MatrixDevice gVar) {
        this.app = aVar;
        this.os = kVar;
        this.device = gVar;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final MatrixApp getApp() {
        return this.app;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final MatrixDevice getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final MatrixOs getOs() {
        return this.os;
    }

    public final JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        MatrixApp aVar = this.app;
        JSONObject jSONObjectPutOpt = jSONObject.putOpt("app", aVar != null ? aVar.b() : null);
        MatrixOs kVar = this.os;
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("os", kVar != null ? kVar.a() : null);
        MatrixDevice gVar = this.device;
        JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt(DeviceRequestsHelper.DEVICE_INFO_DEVICE, gVar != null ? gVar.a() : null);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt3, "JSONObject()\n           …, device?.toJsonObject())");
        return jSONObjectPutOpt3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixContexts)) {
            return false;
        }
        MatrixContexts matrixContexts = (MatrixContexts) other;
        return Intrinsics.areEqual(this.app, matrixContexts.app) && Intrinsics.areEqual(this.os, matrixContexts.os) && Intrinsics.areEqual(this.device, matrixContexts.device);
    }

    public int hashCode() {
        MatrixApp aVar = this.app;
        int iHashCode = (aVar == null ? 0 : aVar.hashCode()) * 31;
        MatrixOs kVar = this.os;
        int iHashCode2 = (iHashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
        MatrixDevice gVar = this.device;
        return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
    }

    public String toString() {
        return "MatrixContexts(app=" + this.app + ", os=" + this.os + ", device=" + this.device + ')';
    }

    public final void a(MatrixApp aVar) {
        this.app = aVar;
    }

    public final void a(MatrixOs kVar) {
        this.os = kVar;
    }

    public final void a(MatrixDevice gVar) {
        this.device = gVar;
    }

    public /* synthetic */ MatrixContexts(MatrixApp aVar, MatrixOs kVar, MatrixDevice gVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aVar, (i & 2) != 0 ? null : kVar, (i & 4) != 0 ? null : gVar);
    }
}
