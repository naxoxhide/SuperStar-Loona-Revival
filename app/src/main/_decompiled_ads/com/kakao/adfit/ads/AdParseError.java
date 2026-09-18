package com.kakao.adfit.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakao.adfit.a.n;
import com.kakao.adfit.common.volley.VolleyError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/kakao/adfit/ads/AdParseError;", "Lcom/kakao/adfit/common/volley/VolleyError;", "Lcom/kakao/adfit/ads/AdError;", "c", "Lcom/kakao/adfit/ads/AdError;", "getError", "()Lcom/kakao/adfit/ads/AdError;", "error", "Lcom/kakao/adfit/a/n;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/a/n;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "e", "I", "a", "()I", "errorCode", "", "message", "<init>", "(Lcom/kakao/adfit/ads/AdError;Ljava/lang/String;Lcom/kakao/adfit/a/n;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class AdParseError extends VolleyError {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final AdError error;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final n options;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdParseError(AdError error, String message, n nVar) {
        super(message);
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        this.error = error;
        this.options = nVar;
        this.errorCode = error.getErrorCode();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final n getOptions() {
        return this.options;
    }

    public /* synthetic */ AdParseError(AdError adError, String str, n nVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adError, str, (i & 4) != 0 ? null : nVar);
    }
}
