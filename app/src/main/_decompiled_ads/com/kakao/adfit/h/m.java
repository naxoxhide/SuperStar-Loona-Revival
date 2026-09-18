package com.kakao.adfit.h;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kakao.adfit.h.m, reason: from toString */
/* JADX INFO: compiled from: MatrixSdkPackage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u0003B1\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/kakao/adfit/h/m;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, MobileAdsBridge.versionMethodName, "setVersion", "version", "", "Lcom/kakao/adfit/h/l;", "c", "Ljava/util/List;", "getPackages", "()Ljava/util/List;", "setPackages", "(Ljava/util/List;)V", "packages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixSdkPackage {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String version;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private List<MatrixPackage> packages;

    /* JADX INFO: renamed from: com.kakao.adfit.h.m$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixSdkPackage.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/kakao/adfit/h/m$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/m;", "a", "", "KEY_NAME", "Ljava/lang/String;", "KEY_PACKAGES", "KEY_VERSION", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixSdkPackage a(JSONObject json) {
            MatrixPackage lVarA;
            Intrinsics.checkNotNullParameter(json, "json");
            String strE = com.kakao.adfit.k.p.e(json, "name");
            String strE2 = com.kakao.adfit.k.p.e(json, "version");
            JSONArray jSONArrayOptJSONArray = json.optJSONArray("packages");
            ArrayList arrayList = null;
            if (jSONArrayOptJSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
                ArrayList arrayList2 = new ArrayList(jSONArrayOptJSONArray.length());
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(index)");
                        lVarA = MatrixPackage.INSTANCE.a(jSONObjectOptJSONObject);
                    } else {
                        lVarA = null;
                    }
                    if (lVarA != null) {
                        arrayList2.add(lVarA);
                    }
                }
                arrayList = arrayList2;
            }
            return new MatrixSdkPackage(strE, strE2, arrayList);
        }
    }

    public MatrixSdkPackage() {
        this(null, null, null, 7, null);
    }

    public MatrixSdkPackage(String str, String str2, List<MatrixPackage> list) {
        this.name = str;
        this.version = str2;
        this.packages = list;
    }

    public final JSONObject a() throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObjectPutOpt = new JSONObject().putOpt("name", this.name).putOpt("version", this.version);
        List<MatrixPackage> list = this.packages;
        if (list != null) {
            jSONArray = new JSONArray();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Object objA = ((MatrixPackage) it.next()).a();
                if (objA == null) {
                    objA = JSONObject.NULL;
                }
                jSONArray.put(objA);
            }
        } else {
            jSONArray = null;
        }
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("packages", jSONArray);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt2, "JSONObject()\n           …ay { it.toJsonObject() })");
        return jSONObjectPutOpt2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixSdkPackage)) {
            return false;
        }
        MatrixSdkPackage matrixSdkPackage = (MatrixSdkPackage) other;
        return Intrinsics.areEqual(this.name, matrixSdkPackage.name) && Intrinsics.areEqual(this.version, matrixSdkPackage.version) && Intrinsics.areEqual(this.packages, matrixSdkPackage.packages);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MatrixPackage> list = this.packages;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MatrixSdkPackage(name=" + this.name + ", version=" + this.version + ", packages=" + this.packages + ')';
    }

    public /* synthetic */ MatrixSdkPackage(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }
}
