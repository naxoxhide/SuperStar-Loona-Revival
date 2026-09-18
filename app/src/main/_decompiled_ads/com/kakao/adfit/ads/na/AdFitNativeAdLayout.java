package com.kakao.adfit.ads.na;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdFitNativeAdLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0001,BY\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\fR$\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R.\u0010)\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001d8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "a", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "getContainerView", "()Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "containerView", "Landroid/view/View;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "getTitleView", "()Landroid/view/View;", "titleView", "c", "getBodyView", "bodyView", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getCallToActionButton", "callToActionButton", "e", "getProfileIconView", "profileIconView", InneractiveMediationDefs.GENDER_FEMALE, "getProfileNameView", "profileNameView", "g", "getMediaView", "mediaView", "", "<set-?>", "h", "Ljava/lang/String;", "getName$library_networkRelease", "()Ljava/lang/String;", "name", "value", "i", "getAdUnitId$library_networkRelease", "setAdUnitId$library_networkRelease", "(Ljava/lang/String;)V", "adUnitId", "<init>", "(Lcom/kakao/adfit/ads/na/AdFitNativeAdView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "Builder", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class AdFitNativeAdLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final AdFitNativeAdView containerView;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View titleView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final View bodyView;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final View callToActionButton;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final View profileIconView;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final View profileNameView;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final View mediaView;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private String name;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private String adUnitId;

    /* JADX INFO: compiled from: AdFitNativeAdLayout.kt */
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout$Builder;", "", "Landroid/widget/TextView;", "view", "setTitleView", "setBodyView", "Landroid/widget/Button;", "setCallToActionButton", "Landroid/widget/ImageView;", "setProfileIconView", "setProfileNameView", "Lcom/kakao/adfit/ads/na/AdFitMediaView;", "setMediaView", "Lcom/kakao/adfit/ads/na/AdFitNativeAdLayout;", "build", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "a", "Lcom/kakao/adfit/ads/na/AdFitNativeAdView;", "containerView", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/widget/TextView;", "titleView", "c", "bodyView", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Landroid/widget/Button;", "callToActionButton", "e", "Landroid/widget/ImageView;", "profileIconView", InneractiveMediationDefs.GENDER_FEMALE, "profileNameView", "g", "Lcom/kakao/adfit/ads/na/AdFitMediaView;", "mediaView", "<init>", "(Lcom/kakao/adfit/ads/na/AdFitNativeAdView;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final AdFitNativeAdView containerView;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private TextView titleView;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private TextView bodyView;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private Button callToActionButton;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private ImageView profileIconView;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private TextView profileNameView;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        private AdFitMediaView mediaView;

        public Builder(AdFitNativeAdView containerView) {
            Intrinsics.checkNotNullParameter(containerView, "containerView");
            this.containerView = containerView;
        }

        public final AdFitNativeAdLayout build() {
            return new AdFitNativeAdLayout(this.containerView, this.titleView, this.bodyView, this.callToActionButton, this.profileIconView, this.profileNameView, this.mediaView, null);
        }

        public final Builder setBodyView(TextView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.bodyView = view;
            return this;
        }

        public final Builder setCallToActionButton(Button view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.callToActionButton = view;
            return this;
        }

        public final Builder setMediaView(AdFitMediaView view) {
            this.mediaView = view;
            return this;
        }

        public final Builder setProfileIconView(ImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.profileIconView = view;
            return this;
        }

        public final Builder setProfileNameView(TextView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.profileNameView = view;
            return this;
        }

        public final Builder setTitleView(TextView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.titleView = view;
            return this;
        }
    }

    private AdFitNativeAdLayout(AdFitNativeAdView adFitNativeAdView, View view, View view2, View view3, View view4, View view5, View view6) {
        this.containerView = adFitNativeAdView;
        this.titleView = view;
        this.bodyView = view2;
        this.callToActionButton = view3;
        this.profileIconView = view4;
        this.profileNameView = view5;
        this.mediaView = view6;
        this.name = "AdFitNativeAdLayout@" + adFitNativeAdView.hashCode();
        if (view == null && view2 == null && view3 == null && view4 == null && view5 == null && view6 == null) {
            throw new IllegalArgumentException("AdFitNativeAdLayout is empty");
        }
    }

    public /* synthetic */ AdFitNativeAdLayout(AdFitNativeAdView adFitNativeAdView, View view, View view2, View view3, View view4, View view5, View view6, DefaultConstructorMarker defaultConstructorMarker) {
        this(adFitNativeAdView, view, view2, view3, view4, view5, view6);
    }

    /* JADX INFO: renamed from: getAdUnitId$library_networkRelease, reason: from getter */
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final View getBodyView() {
        return this.bodyView;
    }

    public final View getCallToActionButton() {
        return this.callToActionButton;
    }

    public final AdFitNativeAdView getContainerView() {
        return this.containerView;
    }

    public final View getMediaView() {
        return this.mediaView;
    }

    /* JADX INFO: renamed from: getName$library_networkRelease, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final View getProfileIconView() {
        return this.profileIconView;
    }

    public final View getProfileNameView() {
        return this.profileNameView;
    }

    public final View getTitleView() {
        return this.titleView;
    }

    public final void setAdUnitId$library_networkRelease(String str) {
        if (Intrinsics.areEqual(this.adUnitId, str)) {
            return;
        }
        this.adUnitId = str;
        StringBuilder sbAppend = new StringBuilder().append("AdFitNativeAdLayout(\"");
        if (str == null) {
            str = "unknown";
        }
        this.name = sbAppend.append(str).append("\")@").append(this.containerView.hashCode()).toString();
    }
}
