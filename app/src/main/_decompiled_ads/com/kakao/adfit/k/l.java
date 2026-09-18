package com.kakao.adfit.k;

import com.kakao.adfit.common.volley.VolleyError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: EacidRequests.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u000b\u0012#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0014R/\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/k/l;", "Lcom/kakao/adfit/common/volley/e;", "Lcom/kakao/adfit/k/n;", "", "jsonString", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/m/d;", "response", "Lcom/kakao/adfit/common/volley/g;", "a", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/jvm/functions/Function1;", "onResponse", "url", "message", "onError", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class l extends com.kakao.adfit.common.volley.e<n> {

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Function1<n, Unit> onResponse;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public l(String url, Function1<? super n, Unit> onResponse, final Function1<? super String, Unit> onError) {
        super(0, url, new com.kakao.adfit.common.volley.g.a() { // from class: com.kakao.adfit.k.-$$Lambda$l$5jSQPR3aOeHTaGGmU79JOx1ja2A
            @Override // com.kakao.adfit.common.volley.g.a
            public final void a(VolleyError volleyError) {
                l.a(onError, volleyError);
            }
        });
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.onResponse = onResponse;
    }

    private final n d(String jsonString) throws VolleyError {
        JSONObject jSONObject = new JSONObject(jsonString);
        String eacid = jSONObject.optString("eacid");
        Intrinsics.checkNotNullExpressionValue(eacid, "eacid");
        if (!StringsKt.isBlank(eacid)) {
            return new n(eacid);
        }
        String errorCode = jSONObject.optString("errorCode");
        Intrinsics.checkNotNullExpressionValue(errorCode, "errorCode");
        if (StringsKt.isBlank(errorCode)) {
            throw new VolleyError("No eacid");
        }
        throw new VolleyError("No eacid [errorCode = " + errorCode + ']');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 onError, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(onError, "$onError");
        onError.invoke(volleyError.getMessage());
    }

    @Override // com.kakao.adfit.common.volley.e
    protected com.kakao.adfit.common.volley.g<n> a(com.kakao.adfit.m.d response) {
        String str;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            try {
                byte[] bArr = response.f1851b;
                Intrinsics.checkNotNullExpressionValue(bArr, "response.data");
                Charset charsetForName = Charset.forName(com.kakao.adfit.n.e.a(response.c));
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(HttpHeaderParser…harset(response.headers))");
                str = new String(bArr, charsetForName);
            } catch (UnsupportedEncodingException unused) {
                byte[] bArr2 = response.f1851b;
                Intrinsics.checkNotNullExpressionValue(bArr2, "response.data");
                str = new String(bArr2, Charsets.UTF_8);
            }
            com.kakao.adfit.common.volley.g<n> gVarA = com.kakao.adfit.common.volley.g.a(d(str), com.kakao.adfit.n.e.a(response));
            Intrinsics.checkNotNullExpressionValue(gVarA, "{\n            val data =…ders(response))\n        }");
            return gVarA;
        } catch (Exception e) {
            com.kakao.adfit.common.volley.g<n> gVarA2 = com.kakao.adfit.common.volley.g.a(new VolleyError(e.getMessage()));
            Intrinsics.checkNotNullExpressionValue(gVarA2, "{\n            Response.e…ror(e.message))\n        }");
            return gVarA2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kakao.adfit.common.volley.e
    public void a(n response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.onResponse.invoke(response);
    }
}
