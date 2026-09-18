package com.kakao.adfit.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.kakao.adfit.ads.R;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonPanelView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0003\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/kakao/adfit/c/a;", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getPlayButton", "()Landroid/widget/ImageView;", "playButton", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getSoundButton", "soundButton", "Landroid/widget/ProgressBar;", "c", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "getLoadingProgressBar", "loadingProgressBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ImageView playButton;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ImageView soundButton;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ProgressBar progressBar;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ProgressBar loadingProgressBar;

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final ProgressBar getLoadingProgressBar() {
        return this.loadingProgressBar;
    }

    public final ImageView getPlayButton() {
        return this.playButton;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final ImageView getSoundButton() {
        return this.soundButton;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.adfit_video_panel_view, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R.id.videoPlayButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.videoPlayButton)");
        this.playButton = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.videoSoundButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.videoSoundButton)");
        this.soundButton = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.videoProgressBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.videoProgressBar)");
        this.progressBar = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.videoLoadingProgressBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.videoLoadingProgressBar)");
        this.loadingProgressBar = (ProgressBar) viewFindViewById4;
    }
}
