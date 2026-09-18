package com.kakao.adfit.a;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.RequestConfiguration;
import com.kakao.adfit.a.a;
import com.kakao.adfit.ads.AdError;
import com.kakao.adfit.ads.AdParseError;
import com.kakao.adfit.common.volley.ServerError;
import com.kakao.adfit.common.volley.VolleyError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000 (*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003:\u0001\nB´\u0001\u0012\u0006\u0010%\u001a\u00020\u0005\u0012#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012'\u0010\u001c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u000f\u0012M\u0010$\u001aI\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u000e0\u001d¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\t\u001a\u00020\bJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0016\u0010\n\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014R1\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R5\u0010\u001c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R[\u0010$\u001aI\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/kakao/adfit/a/h;", "Lcom/kakao/adfit/a/a;", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "Lcom/kakao/adfit/common/volley/e;", "Lcom/kakao/adfit/a/j;", "", "jsonString", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/m/f;", "retryPolicy", "a", "Lcom/kakao/adfit/m/d;", "response", "Lcom/kakao/adfit/common/volley/g;", "", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "input", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/jvm/functions/Function1;", "createOrNull", "", CampaignEx.JSON_KEY_AD_R, "I", "count", "s", "onResponse", "Lkotlin/Function3;", "errorCode", "message", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "t", "Lkotlin/jvm/functions/Function3;", "onError", "url", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "u", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public class h<T extends a> extends com.kakao.adfit.common.volley.e<j<T>> {

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Function1<JSONObject, T> createOrNull;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final int count;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final Function1<j<T>, Unit> onResponse;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final Function3<Integer, String, n, Unit> onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(String url, Function1<? super JSONObject, ? extends T> createOrNull, int i, Function1<? super j<T>, Unit> onResponse, final Function3<? super Integer, ? super String, ? super n, Unit> onError) {
        super(0, url, new com.kakao.adfit.common.volley.g.a() { // from class: com.kakao.adfit.a.-$$Lambda$h$CYUeYMJOy_N_IQCf9Q_EyshLHj0
            @Override // com.kakao.adfit.common.volley.g.a
            public final void a(VolleyError volleyError) {
                h.a(onError, volleyError);
            }
        });
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(createOrNull, "createOrNull");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.createOrNull = createOrNull;
        this.count = i;
        this.onResponse = onResponse;
        this.onError = onError;
        a(false);
        a((com.kakao.adfit.m.f) new com.kakao.adfit.m.a(3000, 0, 0.0f));
    }

    private final j<T> d(String jsonString) throws AdParseError {
        T tInvoke;
        JSONObject jSONObject = new JSONObject(jsonString);
        String strOptString = jSONObject.optString("status");
        if (!Intrinsics.areEqual(strOptString, "OK")) {
            if (Intrinsics.areEqual(strOptString, "NO_AD")) {
                throw new AdParseError(AdError.NO_AD, "No AD", o.a(jSONObject, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS));
            }
            if (((strOptString == null || StringsKt.isBlank(strOptString)) ? 1 : 0) != 0) {
                throw new AdParseError(AdError.INVALID_AD, "No status", null, 4, null);
            }
            throw new AdParseError(AdError.INVALID_AD, "Invalid status: [status = " + strOptString + ']', null, 4, null);
        }
        String id = jSONObject.optString("id");
        if (id == null || StringsKt.isBlank(id)) {
            throw new AdParseError(AdError.INVALID_AD, "No id", null, 4, null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(CampaignUnit.JSON_KEY_ADS);
        if (jSONArrayOptJSONArray == null) {
            throw new AdParseError(AdError.INVALID_AD, "No ads", null, 4, null);
        }
        Integer numValueOf = Integer.valueOf(jSONArrayOptJSONArray.length());
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            throw new AdParseError(AdError.INVALID_AD, "Empty ads", null, 4, null);
        }
        int iIntValue = numValueOf.intValue();
        ArrayList arrayList = new ArrayList(Math.min(this.count, iIntValue));
        for (int i = 0; i < iIntValue; i++) {
            Function1<JSONObject, T> function1 = this.createOrNull;
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (tInvoke = function1.invoke(jSONObjectOptJSONObject)) != null) {
                arrayList.add(tInvoke);
            }
        }
        if (arrayList.isEmpty()) {
            throw new AdParseError(AdError.INVALID_AD, "Invalid ads: [ads = " + jSONArrayOptJSONArray + ']', null, 4, null);
        }
        n nVarA = o.a(jSONObject, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Intrinsics.checkNotNullExpressionValue(id, "id");
        return new j<>(jsonString, id, arrayList, nVarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function3 onError, VolleyError volleyError) {
        com.kakao.adfit.m.d dVar;
        Intrinsics.checkNotNullParameter(onError, "$onError");
        if (volleyError instanceof AdParseError) {
            AdParseError adParseError = (AdParseError) volleyError;
            Integer numValueOf = Integer.valueOf(adParseError.getErrorCode());
            String message = volleyError.getMessage();
            Intrinsics.checkNotNull(message);
            onError.invoke(numValueOf, message, adParseError.getOptions());
            return;
        }
        onError.invoke(Integer.valueOf(AdError.HTTP_FAILED.getErrorCode()), "response error[" + volleyError + ']', null);
        if (!(volleyError instanceof ServerError) || (dVar = volleyError.a) == null) {
            return;
        }
        int i = dVar.a;
        if (i == 400) {
            com.kakao.adfit.k.f.b("Check your client ID, please.");
        } else {
            if (i != 403) {
                return;
            }
            com.kakao.adfit.k.f.b("Check your package name and client ID, please.");
        }
    }

    @Override // com.kakao.adfit.common.volley.e
    public final com.kakao.adfit.common.volley.e<?> a(com.kakao.adfit.m.f retryPolicy) {
        Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
        com.kakao.adfit.common.volley.e<?> eVarA = super.a(retryPolicy);
        Intrinsics.checkNotNullExpressionValue(eVarA, "super.setRetryPolicy(retryPolicy)");
        return eVarA;
    }

    @Override // com.kakao.adfit.common.volley.e
    protected com.kakao.adfit.common.volley.g<j<T>> a(com.kakao.adfit.m.d response) {
        String str;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            try {
                byte[] bArr = response.f1851b;
                Intrinsics.checkNotNullExpressionValue(bArr, "response.data");
                Charset charsetForName = Charset.forName(com.kakao.adfit.n.e.a(response.c));
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(HttpHeaderParser…harset(response.headers))");
                str = new String(bArr, charsetForName);
            } catch (AdParseError e) {
                com.kakao.adfit.common.volley.g<j<T>> gVarA = com.kakao.adfit.common.volley.g.a(e);
                Intrinsics.checkNotNullExpressionValue(gVarA, "{\n            Response.error(e)\n        }");
                return gVarA;
            } catch (Exception e2) {
                com.kakao.adfit.common.volley.g<j<T>> gVarA2 = com.kakao.adfit.common.volley.g.a(new AdParseError(AdError.INVALID_AD, "response parsing error[" + e2 + ']', null, 4, null));
                Intrinsics.checkNotNullExpressionValue(gVarA2, "{\n            Response.e…ng error[$e]\"))\n        }");
                return gVarA2;
            }
        } catch (UnsupportedEncodingException unused) {
            byte[] bArr2 = response.f1851b;
            Intrinsics.checkNotNullExpressionValue(bArr2, "response.data");
            str = new String(bArr2, Charsets.UTF_8);
        }
        com.kakao.adfit.common.volley.g<j<T>> gVarA3 = com.kakao.adfit.common.volley.g.a(d(str), com.kakao.adfit.n.e.a(response));
        Intrinsics.checkNotNullExpressionValue(gVarA3, "{\n            val data =…ders(response))\n        }");
        return gVarA3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kakao.adfit.common.volley.e
    public void a(j<T> response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.onResponse.invoke(response);
    }
}
