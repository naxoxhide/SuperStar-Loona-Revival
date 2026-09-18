package com.kakao.adfit.h;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.l, reason: from toString */
/* JADX INFO: compiled from: MatrixPackage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0003B\u001f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/h/l;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, MobileAdsBridge.versionMethodName, "setVersion", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixPackage {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String version;

    /* JADX INFO: renamed from: com.kakao.adfit.h.l$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixPackage.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/h/l$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/l;", "a", "", "KEY_NAME", "Ljava/lang/String;", "KEY_VERSION", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixPackage a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new MatrixPackage(com.kakao.adfit.k.p.e(json, "name"), com.kakao.adfit.k.p.e(json, "version"));
        }
    }

    public MatrixPackage() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MatrixPackage(String str, String str2) {
        this.name = str;
        this.version = str2;
    }

    public final JSONObject a() {
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("name", this.name).putOpt("version", this.version);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt, "JSONObject()\n           …Opt(KEY_VERSION, version)");
        return jSONObjectPutOpt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixPackage)) {
            return false;
        }
        MatrixPackage matrixPackage = (MatrixPackage) other;
        return Intrinsics.areEqual(this.name, matrixPackage.name) && Intrinsics.areEqual(this.version, matrixPackage.version);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MatrixPackage(name=" + this.name + ", version=" + this.version + ')';
    }

    public /* synthetic */ MatrixPackage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
