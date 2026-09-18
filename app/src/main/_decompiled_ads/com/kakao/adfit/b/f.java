package com.kakao.adfit.b;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakao.adfit.a.j;
import com.kakao.adfit.a.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: compiled from: BannerAdRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012'\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/kakao/adfit/b/f;", "Lcom/kakao/adfit/a/h;", "Lcom/kakao/adfit/b/a;", "", "url", "", "count", "Lkotlin/Function1;", "Lcom/kakao/adfit/a/j;", "Lkotlin/ParameterName;", "name", "response", "", "onResponse", "Lkotlin/Function3;", "errorCode", "message", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "onError", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class f extends com.kakao.adfit.a.h<com.kakao.adfit.b.a> {

    /* JADX INFO: compiled from: BannerAdRequester.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/json/JSONObject;", "it", "Lcom/kakao/adfit/b/a;", "a", "(Lorg/json/JSONObject;)Lcom/kakao/adfit/b/a;"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function1<JSONObject, com.kakao.adfit.b.a> {
        public static final a a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.kakao.adfit.b.a invoke(JSONObject it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return d.a(it);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String url, int i, Function1<? super j<com.kakao.adfit.b.a>, Unit> onResponse, Function3<? super Integer, ? super String, ? super n, Unit> onError) {
        super(url, a.a, i, onResponse, onError);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        Intrinsics.checkNotNullParameter(onError, "onError");
    }
}
