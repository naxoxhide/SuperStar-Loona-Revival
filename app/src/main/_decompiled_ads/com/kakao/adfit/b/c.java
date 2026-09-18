package com.kakao.adfit.b;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.a.n;
import com.kakao.adfit.k.f0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BannerAdContract.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J(\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&R\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/kakao/adfit/b/c;", "", "Lcom/kakao/adfit/b/a;", "bannerAd", "", "a", "g", "Lcom/kakao/adfit/a/n;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lkotlin/Function0;", "onViewable", "Lcom/kakao/adfit/k/f0;", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "", "c", "()I", "width", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "height", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "isAttached", "isVisible", InneractiveMediationDefs.GENDER_FEMALE, "isWindowVisible", "hasWindowFocus", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public interface c {
    f0 a(a bannerAd, n options, Function0<Unit> onViewable);

    void a(a bannerAd);

    boolean a();

    boolean b();

    int c();

    int d();

    Context e();

    boolean f();

    void g();

    boolean isVisible();
}
