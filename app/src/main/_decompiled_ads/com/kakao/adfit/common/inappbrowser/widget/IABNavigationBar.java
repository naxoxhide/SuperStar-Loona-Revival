package com.kakao.adfit.common.inappbrowser.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.kakao.adfit.ads.R;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IABNavigationBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0018\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/kakao/adfit/common/inappbrowser/widget/IABNavigationBar;", "Landroid/widget/LinearLayout;", "", "c", "Landroid/view/View;", "menuLayout", "", "a", "", "url", "Lcom/kakao/adfit/common/inappbrowser/widget/IABNavigationBar$a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemClickListener", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "title", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/webkit/WebView;", "webView", "Landroid/view/View;", "closeButton", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "addressView", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "backButton", "e", "forwardButton", InneractiveMediationDefs.GENDER_FEMALE, "moreButton", "g", "Lcom/kakao/adfit/common/inappbrowser/widget/IABNavigationBar$a;", "itemClickListener", "Landroid/widget/PopupWindow;", "h", "Landroid/widget/PopupWindow;", "popupView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class IABNavigationBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private View closeButton;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private TextView addressView;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private View backButton;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private View forwardButton;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private View moreButton;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private a itemClickListener;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private PopupWindow popupView;

    /* JADX INFO: compiled from: IABNavigationBar.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/common/inappbrowser/widget/IABNavigationBar$a;", "", "", "a", "e", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, InneractiveMediationDefs.GENDER_FEMALE, "g", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IABNavigationBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IABNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ IABNavigationBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(IABNavigationBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        a();
        this.popupView = null;
    }

    public final void setOnItemClickListener(a listener) {
        this.itemClickListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IABNavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.adfit_web_layout_navigation, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R.id.webview_navi_close_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.webview_navi_close_button)");
        this.closeButton = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.webview_navi_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.webview_navi_title)");
        this.titleView = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.webview_navi_address);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.webview_navi_address)");
        this.addressView = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.webview_navi_back_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.webview_navi_back_button)");
        this.backButton = viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.webview_navi_forward_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.webview_navi_forward_button)");
        this.forwardButton = viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.webview_navi_more_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(R.id.webview_navi_more_button)");
        this.moreButton = viewFindViewById6;
        this.closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$hxIzA_SFcWQxKXSd3-cWvTIpuZE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IABNavigationBar.a(this.f$0, view);
            }
        });
        this.backButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$qVUP1psk-WP-ZMsdcmBN_uF5mW8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IABNavigationBar.b(this.f$0, view);
            }
        });
        this.backButton.setEnabled(false);
        this.forwardButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$JndWs-TaSwVb0yKjerAk7Rm5_CU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IABNavigationBar.c(this.f$0, view);
            }
        });
        this.forwardButton.setEnabled(false);
        this.moreButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$4d614NBx04lkB-nbuQulv3wHHL8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IABNavigationBar.d(this.f$0, view);
            }
        });
    }

    private final int a(View menuLayout) {
        menuLayout.measure(View.MeasureSpec.makeMeasureSpec(menuLayout.getResources().getDimensionPixelSize(R.dimen.adfit_webview_menu_max_width), Integer.MIN_VALUE), 0);
        return menuLayout.getMeasuredWidth();
    }

    private final void c() {
        PopupWindow popupWindow = this.popupView;
        if (popupWindow == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.adfit_web_popup_layout, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…t_web_popup_layout, null)");
            viewInflate.findViewById(R.id.menu_copy).setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$LgQ-3mFI7x15NBcZ1BKlHhJy1d4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IABNavigationBar.e(this.f$0, view);
                }
            });
            viewInflate.findViewById(R.id.menu_share).setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$1Tvdx1pS767jeCHmTdHVbpRLdUY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IABNavigationBar.f(this.f$0, view);
                }
            });
            viewInflate.findViewById(R.id.menu_open_web).setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$c-H2bWCHccaQFkS5bUt-NLj0GsY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IABNavigationBar.g(this.f$0, view);
                }
            });
            viewInflate.findViewById(R.id.menu_reload).setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABNavigationBar$dHFw1dhCGUgfFJC1-61Zl71OJwU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IABNavigationBar.h(this.f$0, view);
                }
            });
            PopupWindow popupWindow2 = new PopupWindow(getContext());
            popupWindow2.setElevation(getResources().getDimension(R.dimen.adfit_webview_menu_popup_elevation));
            popupWindow2.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.adfit_inapp_popup_window_bg));
            popupWindow2.setWidth(a(viewInflate) + getResources().getDimensionPixelSize(R.dimen.adfit_webview_menu_popup_bg_padding));
            popupWindow2.setHeight(-2);
            popupWindow2.setContentView(viewInflate);
            popupWindow2.setFocusable(true);
            popupWindow2.setOutsideTouchable(true);
            this.popupView = popupWindow2;
            popupWindow = popupWindow2;
        }
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        popupWindow.showAsDropDown(this, rect.width() - (popupWindow.getWidth() + getResources().getDimensionPixelSize(R.dimen.adfit_webview_menu_popup_offset_x)), getResources().getDimensionPixelOffset(R.dimen.adfit_webview_menu_popup_offset_y));
    }

    public final void b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.addressView.setVisibility(0);
        this.addressView.setText(a(url));
    }

    public final void b() {
        this.addressView.setVisibility(8);
    }

    private final void a() {
        PopupWindow popupWindow = this.popupView;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.backButton.setEnabled(webView.canGoBack());
        this.forwardButton.setEnabled(webView.canGoForward());
    }

    private final String a(String url) {
        try {
            String host = new URL(url).getHost();
            Intrinsics.checkNotNullExpressionValue(host, "URL(url).host");
            return host;
        } catch (MalformedURLException unused) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) url, "://", 0, false, 6, (Object) null);
            if (iIndexOf$default > 0) {
                url = url.substring(iIndexOf$default + 3);
                Intrinsics.checkNotNullExpressionValue(url, "this as java.lang.String).substring(startIndex)");
            }
            int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) url, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null);
            if (iIndexOf$default2 <= 0) {
                return url;
            }
            String strSubstring = url.substring(0, iIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
    }

    public final void c(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.titleView.setText(title);
    }
}
