package com.kakao.adfit.d;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.common.inappbrowser.activity.IABActivity;
import com.kakao.adfit.k.a0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ViewBindings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\nH\u0014R\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/kakao/adfit/d/e;", "Lcom/kakao/adfit/d/y;", "Landroid/view/View$OnClickListener;", "", "url", "Landroid/view/View;", "v", "a", "Landroid/content/Context;", "context", "", "onClick", "g", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "view", "c", "Ljava/lang/String;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Ljava/util/List;", "clickTrackers", "Lkotlin/Function1;", "", "e", "Lkotlin/jvm/functions/Function1;", "handleOpenLandingPage", InneractiveMediationDefs.GENDER_FEMALE, "notifyOnClick", "<init>", "(Landroid/view/View;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class e extends y implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View view;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String url;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<String> clickTrackers;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Function1<String, Boolean> handleOpenLandingPage;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Function1<View, Unit> notifyOnClick;

    /* JADX WARN: Multi-variable type inference failed */
    public e(View view, String url, List<String> clickTrackers, Function1<? super String, Boolean> handleOpenLandingPage, Function1<? super View, Unit> notifyOnClick) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(clickTrackers, "clickTrackers");
        Intrinsics.checkNotNullParameter(handleOpenLandingPage, "handleOpenLandingPage");
        Intrinsics.checkNotNullParameter(notifyOnClick, "notifyOnClick");
        this.view = view;
        this.url = url;
        this.clickTrackers = clickTrackers;
        this.handleOpenLandingPage = handleOpenLandingPage;
        this.notifyOnClick = notifyOnClick;
        view.setClickable(true);
        view.setOnClickListener(this);
        view.setAccessibilityDelegate(com.kakao.adfit.k.a.a.a());
    }

    private final String a(String url, View v) {
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "analytics.ad.daum.net", false, 2, (Object) null)) {
            try {
                String string = Uri.parse(url).buildUpon().appendQueryParameter(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, v.isShown() ? "F" : "B").appendQueryParameter(CampaignEx.JSON_KEY_AD_R, com.kakao.adfit.k.y.c(v.getContext()) ? "R" : "N").build().toString();
                Intrinsics.checkNotNullExpressionValue(string, "parse(url)\n             …              .toString()");
                return string;
            } catch (Exception e) {
                com.kakao.adfit.k.f.b("Failed to append query parameters. [error = " + e + ']');
            }
        }
        return url;
    }

    @Override // com.kakao.adfit.d.y
    protected void g() {
        this.view.setOnClickListener(null);
        this.view.setAccessibilityDelegate(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (getIsBinding()) {
            Context context = v.getContext();
            String strA = a(this.url, v);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a(context, strA);
            a(context);
            this.notifyOnClick.invoke(v);
        }
    }

    private final void a(Context context, String url) {
        if (a0.a.a(context, url) || this.handleOpenLandingPage.invoke(url).booleanValue()) {
            return;
        }
        try {
            context.startActivity(IABActivity.INSTANCE.a(context, url));
        } catch (Exception e) {
            com.kakao.adfit.k.f.b("Failed to start IABActivity. [error = " + e + ']');
        }
    }

    private final void a(Context context) {
        com.kakao.adfit.a.g.a(context).a(this.clickTrackers);
    }
}
