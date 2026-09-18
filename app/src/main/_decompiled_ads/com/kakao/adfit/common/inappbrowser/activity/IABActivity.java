package com.kakao.adfit.common.inappbrowser.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.common.inappbrowser.widget.IABLayout;
import com.kakao.adfit.k.f;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IABActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\bH\u0003J\f\u0010\u0005\u001a\u00020\u0006*\u00020\bH\u0003J\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0003J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/kakao/adfit/common/inappbrowser/activity/IABActivity;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/Window;", "toLightColor", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "finish", "onNewIntent", "outState", "onSaveInstanceState", "onRestoreInstanceState", "onBackPressed", "onPause", "onResume", "onDestroy", "Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout;", "Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout;", "webLayout", "", "J", "startTime", "", "c", "Ljava/lang/String;", "landingUrl", "<init>", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class IABActivity extends FragmentActivity {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private IABLayout webLayout;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String landingUrl;

    /* JADX INFO: renamed from: com.kakao.adfit.common.inappbrowser.activity.IABActivity$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: IABActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/kakao/adfit/common/inappbrowser/activity/IABActivity$a;", "", "Landroid/content/Context;", "context", "", "url", "Landroid/content/Intent;", "a", "EXTRA_IAB_URL", "Ljava/lang/String;", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Intent a(Context context, String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent(context, (Class<?>) IABActivity.class);
            intent.addFlags(872415232);
            intent.putExtra("inAppBrowserUrl", url);
            return intent;
        }
    }

    /* JADX INFO: compiled from: IABActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/kakao/adfit/common/inappbrowser/activity/IABActivity$b", "Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout$d;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "c", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class b implements IABLayout.d {
        b() {
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABLayout.d
        public void a() {
            Window window;
            if (Build.VERSION.SDK_INT < 23 || (window = IABActivity.this.getWindow()) == null) {
                return;
            }
            IABActivity.this.b(window);
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABLayout.d
        public void b() {
            Window window;
            if (Build.VERSION.SDK_INT < 23 || (window = IABActivity.this.getWindow()) == null) {
                return;
            }
            IABActivity.this.a(window);
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABLayout.d
        public void c() {
            IABActivity.this.finish();
        }
    }

    @JvmStatic
    public static final Intent a(Context context, String str) {
        return INSTANCE.a(context, str);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.adfit_activity_hold, R.anim.adfit_activity_slide_out_to_bottom);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IABLayout iABLayout = this.webLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        if (iABLayout.d()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.adfit_activity_slide_in_from_bottom, R.anim.adfit_activity_hold);
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            b(window);
        }
        setContentView(R.layout.adfit_inapp_browser);
        View viewFindViewById = findViewById(R.id.webview_content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.webview_content)");
        IABLayout iABLayout = (IABLayout) viewFindViewById;
        this.webLayout = iABLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        iABLayout.setOnEventListener(new b());
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        if (a(intent) && savedInstanceState == null) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            b(intent2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        IABLayout iABLayout = this.webLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        iABLayout.e();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (a(intent)) {
            f.d("Reload InAppBrowser");
            IABLayout iABLayout = this.webLayout;
            if (iABLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webLayout");
                iABLayout = null;
            }
            iABLayout.a();
            setIntent(intent);
            b(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        IABLayout iABLayout = this.webLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        iABLayout.f();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        IABLayout iABLayout = this.webLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        iABLayout.a(savedInstanceState);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        IABLayout iABLayout = this.webLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        iABLayout.g();
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        IABLayout iABLayout = this.webLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        iABLayout.b(outState);
    }

    private final boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("inAppBrowserUrl");
        if (stringExtra == null || StringsKt.isBlank(stringExtra)) {
            return false;
        }
        return !Intrinsics.areEqual(stringExtra, this.landingUrl) || SystemClock.elapsedRealtime() - this.startTime > 1000;
    }

    private final void b(Intent intent) {
        this.landingUrl = intent.getStringExtra("inAppBrowserUrl");
        this.startTime = SystemClock.elapsedRealtime();
        IABLayout iABLayout = this.webLayout;
        if (iABLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webLayout");
            iABLayout = null;
        }
        iABLayout.c(this.landingUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Window window) {
        a(window, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Window window) {
        a(window, false);
    }

    private final void a(Window window, boolean z) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        if (z) {
            window.setStatusBarColor(-1);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        } else {
            window.setStatusBarColor(-16777216);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
    }
}
