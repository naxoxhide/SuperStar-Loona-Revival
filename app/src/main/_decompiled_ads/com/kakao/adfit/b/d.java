package com.kakao.adfit.b;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: BannerAd.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000H\u0002\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0002¨\u0006\t"}, d2 = {"Lorg/json/JSONObject;", "Lcom/kakao/adfit/b/a;", "a", "Lcom/kakao/adfit/b/a$d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/kakao/adfit/b/a$c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/b/a$b;", "c", "library_networkRelease"}, k = 2, mv = {1, 6, 0})
public final class d {
    public static final a a(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        a.d dVarB;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strOptString3 = jSONObject.optString("type", null);
        if (strOptString3 == null) {
            return null;
        }
        if (!Intrinsics.areEqual(strOptString3, ReportUtil.INVENTORY_TYPE_BANNER)) {
            strOptString3 = null;
        }
        if (strOptString3 == null || (strOptString = jSONObject.optString("mimeType", null)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(strOptString, "text/html")) {
            strOptString = null;
        }
        if (strOptString == null || (strOptString2 = jSONObject.optString("content", null)) == null) {
            return null;
        }
        if (!(!StringsKt.isBlank(strOptString2))) {
            strOptString2 = null;
        }
        if (strOptString2 == null || (dVarB = b(jSONObject)) == null) {
            return null;
        }
        return new a(strOptString2, dVarB, com.kakao.adfit.a.f.a(jSONObject));
    }

    private static final a.d b(JSONObject jSONObject) {
        a.c cVarD = d(jSONObject);
        return cVarD != null ? cVarD : c(jSONObject);
    }

    private static final a.b c(JSONObject jSONObject) {
        Integer numValueOf = Integer.valueOf(jSONObject.optInt("width"));
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            Integer numValueOf2 = Integer.valueOf(jSONObject.optInt("height"));
            if (!(numValueOf2.intValue() > 0)) {
                numValueOf2 = null;
            }
            if (numValueOf2 != null) {
                return new a.b(iIntValue, numValueOf2.intValue());
            }
        }
        return null;
    }

    private static final a.c d(JSONObject jSONObject) {
        Integer numValueOf = Integer.valueOf(jSONObject.optInt("wratio"));
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            Integer numValueOf2 = Integer.valueOf(jSONObject.optInt("hratio"));
            if (!(numValueOf2.intValue() > 0)) {
                numValueOf2 = null;
            }
            if (numValueOf2 != null) {
                int iIntValue2 = numValueOf2.intValue();
                Integer numValueOf3 = Integer.valueOf(jSONObject.optInt("wmin"));
                if (!(numValueOf3.intValue() > 0)) {
                    numValueOf3 = null;
                }
                if (numValueOf3 != null) {
                    return new a.c(iIntValue, iIntValue2, numValueOf3.intValue());
                }
            }
        }
        return null;
    }
}
