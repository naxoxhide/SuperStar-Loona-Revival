package com.kakao.adfit.d;

import android.content.Context;
import android.view.View;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.common.inappbrowser.activity.IABActivity;
import com.kakao.adfit.k.a0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ViewBindings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014R\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/kakao/adfit/d/d;", "Lcom/kakao/adfit/d/y;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "", "url", "", "a", "Landroid/view/View;", "v", "onClick", "g", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "view", "c", "Ljava/lang/String;", "Lkotlin/Function1;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lkotlin/jvm/functions/Function1;", "handleOpenLandingPage", "<init>", "(Landroid/view/View;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class d extends y implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View view;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String url;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Function1<String, Boolean> handleOpenLandingPage;

    /* JADX WARN: Multi-variable type inference failed */
    public d(View view, String str, Function1<? super String, Boolean> handleOpenLandingPage) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handleOpenLandingPage, "handleOpenLandingPage");
        this.view = view;
        this.url = str;
        this.handleOpenLandingPage = handleOpenLandingPage;
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription == null || StringsKt.isBlank(contentDescription)) {
            view.setContentDescription(view.getResources().getString(R.string.adfit_ad_info_description));
        }
        view.setClickable(true);
        view.setOnClickListener(this);
        view.setAccessibilityDelegate(com.kakao.adfit.k.a.a.a());
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

    @Override // com.kakao.adfit.d.y
    protected void g() {
        this.view.setOnClickListener(null);
        this.view.setAccessibilityDelegate(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (!getIsBinding() || this.url == null) {
            return;
        }
        Context context = v.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        a(context, this.url);
    }
}
