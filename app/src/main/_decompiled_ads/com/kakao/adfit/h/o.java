package com.kakao.adfit.h;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
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

/* JADX INFO: renamed from: com.kakao.adfit.h.o, reason: from toString */
/* JADX INFO: compiled from: MatrixStackTrace.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B\u0019\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/kakao/adfit/h/o;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/kakao/adfit/h/n;", "Ljava/util/List;", "getFrames", "()Ljava/util/List;", "setFrames", "(Ljava/util/List;)V", CampaignUnit.JSON_KEY_FRAME_ADS, "<init>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final /* data */ class MatrixStackTrace {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private List<MatrixStackFrame> frames;

    /* JADX INFO: renamed from: com.kakao.adfit.h.o$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MatrixStackTrace.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/kakao/adfit/h/o$a;", "", "Lorg/json/JSONObject;", "json", "Lcom/kakao/adfit/h/o;", "a", "", "KEY_FRAMES", "Ljava/lang/String;", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MatrixStackTrace a(JSONObject json) {
            MatrixStackFrame matrixStackFrameA;
            Intrinsics.checkNotNullParameter(json, "json");
            JSONArray jSONArrayOptJSONArray = json.optJSONArray(CampaignUnit.JSON_KEY_FRAME_ADS);
            ArrayList arrayList = null;
            if (jSONArrayOptJSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray, "optJSONArray(key)");
                ArrayList arrayList2 = new ArrayList(jSONArrayOptJSONArray.length());
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(index)");
                        matrixStackFrameA = MatrixStackFrame.INSTANCE.a(jSONObjectOptJSONObject);
                    } else {
                        matrixStackFrameA = null;
                    }
                    if (matrixStackFrameA != null) {
                        arrayList2.add(matrixStackFrameA);
                    }
                }
                arrayList = arrayList2;
            }
            return new MatrixStackTrace(arrayList);
        }
    }

    public MatrixStackTrace() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MatrixStackTrace(List<MatrixStackFrame> list) {
        this.frames = list;
    }

    public final JSONObject a() throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        List<MatrixStackFrame> list = this.frames;
        if (list != null) {
            jSONArray = new JSONArray();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Object objA = ((MatrixStackFrame) it.next()).a();
                if (objA == null) {
                    objA = JSONObject.NULL;
                }
                jSONArray.put(objA);
            }
        } else {
            jSONArray = null;
        }
        JSONObject jSONObjectPutOpt = jSONObject.putOpt(CampaignUnit.JSON_KEY_FRAME_ADS, jSONArray);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt, "JSONObject()\n           …ay { it.toJsonObject() })");
        return jSONObjectPutOpt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MatrixStackTrace) && Intrinsics.areEqual(this.frames, ((MatrixStackTrace) other).frames);
    }

    public int hashCode() {
        List<MatrixStackFrame> list = this.frames;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "MatrixStackTrace(frames=" + this.frames + ')';
    }

    public /* synthetic */ MatrixStackTrace(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }
}
