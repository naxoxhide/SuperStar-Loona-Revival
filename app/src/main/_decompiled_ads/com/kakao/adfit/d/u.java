package com.kakao.adfit.d;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAdRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0096\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052'\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072M\u0010\u0014\u001aI\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000eH\u0016¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/d/u;", "Lcom/kakao/adfit/a/i;", "Lcom/kakao/adfit/d/p;", "Lcom/kakao/adfit/d/q;", "config", "", "count", "Lkotlin/Function1;", "Lcom/kakao/adfit/a/j;", "Lkotlin/ParameterName;", "name", "response", "", "onResponse", "Lkotlin/Function3;", "errorCode", "", "message", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "onError", "Lcom/kakao/adfit/a/h;", "a", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class u extends com.kakao.adfit.a.i<p, q> {
    @Override // com.kakao.adfit.a.i
    public /* bridge */ /* synthetic */ com.kakao.adfit.a.h a(com.kakao.adfit.a.b bVar, int i, Function1 function1, Function3 function3) {
        return a((q) bVar, i, (Function1<? super com.kakao.adfit.a.j<p>, Unit>) function1, (Function3<? super Integer, ? super String, ? super com.kakao.adfit.a.n, Unit>) function3);
    }

    public com.kakao.adfit.a.h<p> a(q config, int count, Function1<? super com.kakao.adfit.a.j<p>, Unit> onResponse, Function3<? super Integer, ? super String, ? super com.kakao.adfit.a.n, Unit> onError) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        Intrinsics.checkNotNullParameter(onError, "onError");
        com.kakao.adfit.a.k kVar = new com.kakao.adfit.a.k(config);
        kVar.a(count);
        return new t(kVar.a(), count, onResponse, onError);
    }
}
