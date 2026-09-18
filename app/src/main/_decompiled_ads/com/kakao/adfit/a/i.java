package com.kakao.adfit.a;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.RequestConfiguration;
import com.kakao.adfit.a.a;
import com.kakao.adfit.a.b;
import com.kakao.adfit.ads.AdException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b&\u0010'J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002J\u009d\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u00102'\u0010\u0017\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u00122M\u0010\u001d\u001aI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\u0018H&¢\u0006\u0004\b\f\u0010\u001fJ¾\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u00102'\u0010!\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u00122'\u0010\u0017\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u00122M\u0010\u001d\u001aI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0004\b\f\u0010\"J\u001d\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010$J\u001d\u0010%\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0004\b%\u0010$J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010$¨\u0006("}, d2 = {"Lcom/kakao/adfit/a/i;", "Lcom/kakao/adfit/a/a;", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "Lcom/kakao/adfit/a/b;", "Config", "", "Landroid/content/Context;", "context", "", "", "urls", "", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "config", "", "count", "Lkotlin/Function1;", "Lcom/kakao/adfit/a/j;", "Lkotlin/ParameterName;", "name", "response", "onResponse", "Lkotlin/Function3;", "errorCode", "message", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "onError", "Lcom/kakao/adfit/a/h;", "(Lcom/kakao/adfit/a/b;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Lcom/kakao/adfit/a/h;", "request", "onRequest", "(Lcom/kakao/adfit/a/b;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "ad", "(Landroid/content/Context;Lcom/kakao/adfit/a/a;)V", "c", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public abstract class i<T extends a, Config extends b> {
    public abstract h<T> a(Config config, int count, Function1<? super j<T>, Unit> onResponse, Function3<? super Integer, ? super String, ? super n, Unit> onError);

    public final void a(Config config, int count, Function1<? super h<T>, Unit> onRequest, Function1<? super j<T>, Unit> onResponse, Function3<? super Integer, ? super String, ? super n, Unit> onError) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onRequest, "onRequest");
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        Intrinsics.checkNotNullParameter(onError, "onError");
        try {
            h<T> hVarA = a(config, count, onResponse, onError);
            g.a(config.getContext()).a(hVarA);
            onRequest.invoke(hVarA);
        } catch (AdException e) {
            onError.invoke(Integer.valueOf(e.a().getErrorCode()), "request error[" + e.a().getErrorCode() + ']', null);
        } catch (Exception e2) {
            com.kakao.adfit.e.f.a.a(e2);
        }
    }

    public final void b(Context context, T ad) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
        b(context, ad.c());
    }

    public final void c(Context context, T ad) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
        b(context, ad.b());
    }

    private final void b(Context context, List<String> urls) {
        g.a(context).a(urls);
        urls.clear();
    }

    public final void a(Context context, T ad) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
        a(context, ad.d());
    }

    private final void a(Context context, List<String> urls) {
        g.a(context).a(urls);
    }
}
