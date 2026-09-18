package com.kakao.adfit.ads.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.d.f;
import com.kakao.adfit.d.h;
import com.kakao.adfit.d.i;
import com.kakao.adfit.d.k;
import com.kakao.adfit.d.l;
import com.kakao.adfit.d.m;
import com.kakao.adfit.k.e0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaAdView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0017\b\u0007\u0018\u0000 \u009b\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u009b\u0001B.\b\u0007\u0012\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001\u0012\f\b\u0002\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u0001\u0012\t\b\u0003\u0010\u0098\u0001\u001a\u00020\u001b¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u00020\u0005*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\f\u0010\u0010\u001a\u00020\u0005*\u00020\u000fH\u0002J\f\u0010\u0011\u001a\u00020\u0005*\u00020\u000fH\u0002J\f\u0010\u0012\u001a\u00020\u0005*\u00020\u000fH\u0002J\f\u0010\u0013\u001a\u00020\u0005*\u00020\u000fH\u0002J\f\u0010\u0014\u001a\u00020\u0005*\u00020\u000fH\u0002J\u0014\u0010\u000b\u001a\u00020\u0005*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u000f\u0010\u000b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u000b\u0010\u0018J\f\u0010\u000b\u001a\u00020\u001a*\u00020\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ\u0016\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bJ\u0010\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001bH\u0014J \u00102\u001a\u00020\u00052\u0006\u00101\u001a\u0002002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J \u00103\u001a\u00020\u00052\u0006\u00101\u001a\u0002002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0016J\u0010\u00106\u001a\u0002052\u0006\u00101\u001a\u000200H\u0016J\u0006\u00107\u001a\u00020\u0005R$\u0010<\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010;R\u0017\u0010A\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b\u0007\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010KR$\u0010Q\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00198\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0017\u0010[\u001a\u00020V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0017\u0010a\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010g\u001a\u00020b8\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR$\u0010|\u001a\u0004\u0018\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{RF\u0010\u0086\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b~\u0012\b\bD\u0012\u0004\b\b(\u007f\u0012\u0004\u0012\u00020\u0005\u0018\u00010}8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001RG\u0010\u008b\u0001\u001a \u0012\u0014\u0012\u00120\u001b¢\u0006\r\b~\u0012\t\bD\u0012\u0005\b\b(\u0087\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010}8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0081\u0001\u001a\u0006\b\u0089\u0001\u0010\u0083\u0001\"\u0006\b\u008a\u0001\u0010\u0085\u0001R)\u0010\u0090\u0001\u001a\u00020\u001b2\u0007\u0010\u008c\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u008d\u0001\u0010;\"\u0006\b\u008e\u0001\u0010\u008f\u0001R)\u0010\u0093\u0001\u001a\u00020\u001b2\u0007\u0010\u008c\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0091\u0001\u0010;\"\u0006\b\u0092\u0001\u0010\u008f\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/kakao/adfit/ads/media/MediaAdView;", "Landroid/widget/FrameLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/kakao/adfit/d/f;", "Lcom/kakao/adfit/d/k;", "", InneractiveMediationDefs.GENDER_FEMALE, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "", "durationMillis", "a", "c", "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Landroid/widget/ImageView;", "setPlayButton", "setPauseButton", "setReplayButton", "setSoundOnButton", "setSoundOffButton", "Landroid/view/ViewGroup;", "v", "com/kakao/adfit/ads/media/MediaAdView$b", "()Lcom/kakao/adfit/ads/media/MediaAdView$b;", "Lcom/kakao/adfit/d/l$a;", "Lcom/kakao/adfit/ads/media/AdFitVideoAdController$State;", "", "width", "height", "setMediaSize", "widthPixel", "heightPixel", "setMediaMaxSize", "Lcom/kakao/adfit/d/i;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "setViewModel", "updateImageAdImage", "updateImageAdSize", "updateVideoAdViewState", "updateVideoAdImage", "updateVideoAdSize", "updateVideoAdProgress", "updateVideoAdVolume", "updateVideoAdSurface", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/SurfaceTexture;", "texture", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "", "onSurfaceTextureDestroyed", "onPlayButtonClicked", "<set-?>", "I", "getMediaType", "()I", "mediaType", "Lcom/kakao/adfit/ads/media/AdFitVideoAdController;", "Lcom/kakao/adfit/ads/media/AdFitVideoAdController;", "getVideoAdController", "()Lcom/kakao/adfit/ads/media/AdFitVideoAdController;", "videoAdController", "", "Ljava/lang/String;", "name", "Lcom/kakao/adfit/d/i;", "viewModel", "Lcom/kakao/adfit/d/h;", "Lcom/kakao/adfit/d/h;", "imageViewModel", "Lcom/kakao/adfit/d/m;", "Lcom/kakao/adfit/d/m;", "videoViewModel", "g", "Lcom/kakao/adfit/d/l$a;", "getVideoViewState$library_networkRelease", "()Lcom/kakao/adfit/d/l$a;", "videoViewState", "Landroid/view/Surface;", "h", "Landroid/view/Surface;", "surface", "Lcom/kakao/adfit/c/c;", "i", "Lcom/kakao/adfit/c/c;", "getTextureView", "()Lcom/kakao/adfit/c/c;", "textureView", "Lcom/kakao/adfit/c/b;", "j", "Lcom/kakao/adfit/c/b;", "getMainImageView", "()Lcom/kakao/adfit/c/b;", "mainImageView", "Lcom/kakao/adfit/c/a;", CampaignEx.JSON_KEY_AD_K, "Lcom/kakao/adfit/c/a;", "getVideoPanelView", "()Lcom/kakao/adfit/c/a;", "videoPanelView", "l", "Landroid/view/View;", "dimLayerView", InneractiveMediationDefs.GENDER_MALE, "errorLayout", "Lcom/kakao/adfit/k/e0;", "n", "Lcom/kakao/adfit/k/e0;", "measureSpecCalculator", "Ljava/lang/Runnable;", "o", "Ljava/lang/Runnable;", "hidePauseButtonAction", "Landroid/view/View$OnClickListener;", "p", "Landroid/view/View$OnClickListener;", "getOnVideoPlayButtonClickListener", "()Landroid/view/View$OnClickListener;", "setOnVideoPlayButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "onVideoPlayButtonClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "state", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/jvm/functions/Function1;", "getOnVideoAdStateChangedListener$library_networkRelease", "()Lkotlin/jvm/functions/Function1;", "setOnVideoAdStateChangedListener$library_networkRelease", "(Lkotlin/jvm/functions/Function1;)V", "onVideoAdStateChangedListener", "position", CampaignEx.JSON_KEY_AD_R, "getOnVideoAdProgressChangedListener$library_networkRelease", "setOnVideoAdProgressChangedListener$library_networkRelease", "onVideoAdProgressChangedListener", "value", "getMediaMaxWidth", "setMediaMaxWidth", "(I)V", "mediaMaxWidth", "getMediaMaxHeight", "setMediaMaxHeight", "mediaMaxHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class MediaAdView extends FrameLayout implements TextureView.SurfaceTextureListener, f, k {
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_VIDEO = 2;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int mediaType;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AdFitVideoAdController videoAdController;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private i viewModel;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private h imageViewModel;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private m videoViewModel;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private l.a videoViewState;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private Surface surface;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final com.kakao.adfit.c.c textureView;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final com.kakao.adfit.c.b mainImageView;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final com.kakao.adfit.c.a videoPanelView;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private View dimLayerView;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private View errorLayout;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final e0 measureSpecCalculator;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Runnable hidePauseButtonAction;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private View.OnClickListener onVideoPlayButtonClickListener;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private Function1<? super l.a, Unit> onVideoAdStateChangedListener;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private Function1<? super Integer, Unit> onVideoAdProgressChangedListener;

    /* JADX INFO: compiled from: MediaAdView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.a.values().length];
            iArr[l.a.LOADING.ordinal()] = 1;
            iArr[l.a.PLAYING.ordinal()] = 2;
            iArr[l.a.PAUSED.ordinal()] = 3;
            iArr[l.a.COMPLETED.ordinal()] = 4;
            iArr[l.a.ERROR.ordinal()] = 5;
            iArr[l.a.INITIALIZED.ordinal()] = 6;
            iArr[l.a.IDLE.ordinal()] = 7;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: MediaAdView.kt */
    @Metadata(bv = {}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R?\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR?\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR?\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"com/kakao/adfit/ads/media/MediaAdView$b", "Lcom/kakao/adfit/ads/media/AdFitVideoAdController;", "", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "Lkotlin/Function1;", "Lcom/kakao/adfit/ads/media/AdFitVideoAdController$State;", "Lkotlin/ParameterName;", "name", "state", "a", "Lkotlin/jvm/functions/Function1;", "getOnStateChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnStateChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onStateChangedListener", "", "position", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getOnProgressChangedListener", "setOnProgressChangedListener", "onProgressChangedListener", "", TapjoyConstants.TJC_VOLUME, "c", "getOnVolumeChangedListener", "setOnVolumeChangedListener", "onVolumeChangedListener", "getState", "()Lcom/kakao/adfit/ads/media/AdFitVideoAdController$State;", "getDuration", "()I", "duration", "getCurrentPosition", "currentPosition", "value", "getVolume", "()F", "setVolume", "(F)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class b implements AdFitVideoAdController {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private Function1<? super AdFitVideoAdController.State, Unit> onStateChangedListener;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Function1<? super Integer, Unit> onProgressChangedListener;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private Function1<? super Float, Unit> onVolumeChangedListener;

        b() {
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public int getCurrentPosition() {
            m mVar = MediaAdView.this.videoViewModel;
            if (mVar != null) {
                return mVar.g();
            }
            return 0;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public int getDuration() {
            m mVar = MediaAdView.this.videoViewModel;
            if (mVar != null) {
                return mVar.a();
            }
            return 0;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public Function1<Integer, Unit> getOnProgressChangedListener() {
            return this.onProgressChangedListener;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public Function1<AdFitVideoAdController.State, Unit> getOnStateChangedListener() {
            return this.onStateChangedListener;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public Function1<Float, Unit> getOnVolumeChangedListener() {
            return this.onVolumeChangedListener;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public AdFitVideoAdController.State getState() {
            MediaAdView mediaAdView = MediaAdView.this;
            return mediaAdView.a(mediaAdView.getVideoViewState());
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public float getVolume() {
            m mVar = MediaAdView.this.videoViewModel;
            if (mVar != null) {
                return mVar.d();
            }
            return 0.0f;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void mute() {
            AdFitVideoAdController.a.a(this);
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void pause() {
            m mVar = MediaAdView.this.videoViewModel;
            if (mVar != null) {
                mVar.pause();
            }
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void play() {
            m mVar = MediaAdView.this.videoViewModel;
            if (mVar != null) {
                mVar.play();
            }
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void setOnProgressChangedListener(Function1<? super Integer, Unit> function1) {
            this.onProgressChangedListener = function1;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void setOnStateChangedListener(Function1<? super AdFitVideoAdController.State, Unit> function1) {
            this.onStateChangedListener = function1;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void setOnVolumeChangedListener(Function1<? super Float, Unit> function1) {
            this.onVolumeChangedListener = function1;
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void setVolume(float f) {
            m mVar = MediaAdView.this.videoViewModel;
            if (mVar == null) {
                return;
            }
            mVar.a(f);
        }

        @Override // com.kakao.adfit.ads.media.AdFitVideoAdController
        public void unmute() {
            AdFitVideoAdController.a.b(this);
        }
    }

    /* JADX INFO: compiled from: MediaAdView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/kakao/adfit/ads/media/MediaAdView$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", TJAdUnitConstants.String.SPLIT_VIEW_ANIMATION, "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c implements Animation.AnimationListener {
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.a.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MediaAdView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MediaAdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    private final void b() {
        if (this.videoViewState != l.a.PLAYING) {
            return;
        }
        ImageView playButton = this.videoPanelView.getPlayButton();
        Object systemService = getContext().getSystemService("accessibility");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            this.videoPanelView.setClickable(false);
            this.videoPanelView.setOnClickListener(null);
            playButton.setVisibility(0);
        } else if (playButton.getVisibility() == 0) {
            b(playButton, 300L);
        }
    }

    private final void c() {
        m mVar = this.videoViewModel;
        if (mVar != null) {
            mVar.b();
        }
    }

    private final void d() {
        m mVar = this.videoViewModel;
        if (mVar != null) {
            mVar.l();
        }
    }

    private final void e() {
        m mVar = this.videoViewModel;
        if (mVar != null) {
            mVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MediaAdView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m mVar = this$0.videoViewModel;
        if (mVar != null) {
            mVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MediaAdView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    private final void setPauseButton(ImageView imageView) {
        imageView.setImageResource(R.drawable.adfit_video_pause_btn);
        imageView.setContentDescription(imageView.getResources().getText(R.string.adfit_pause_btn_description));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$52w5FnnLevqadxa9MFZmqYjp_xU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaAdView.a(this.f$0, view);
            }
        });
    }

    private final void setPlayButton(ImageView imageView) {
        imageView.setImageResource(R.drawable.adfit_video_play_btn);
        imageView.setContentDescription(imageView.getResources().getText(R.string.adfit_play_btn_description));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$KpQZnmeUUW1IYsrRO1RheXDEoA8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaAdView.b(this.f$0, view);
            }
        });
    }

    private final void setReplayButton(ImageView imageView) {
        imageView.setImageResource(R.drawable.adfit_video_replay_btn);
        imageView.setContentDescription(imageView.getResources().getText(R.string.adfit_replay_btn_description));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$2d5Hfe1QLlenSVtnl5AN3AGzbSM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaAdView.c(this.f$0, view);
            }
        });
    }

    private final void setSoundOffButton(ImageView imageView) {
        imageView.setImageResource(R.drawable.adfit_video_sound_on_btn);
        imageView.setContentDescription(imageView.getResources().getText(R.string.adfit_sound_off_description));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$LhyAgnjONbdTIc8WvnPm43-TL3I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaAdView.d(this.f$0, view);
            }
        });
    }

    private final void setSoundOnButton(ImageView imageView) {
        imageView.setImageResource(R.drawable.adfit_video_sound_off_btn);
        imageView.setContentDescription(imageView.getResources().getText(R.string.adfit_sound_on_description));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$4m4yHuoiprGYFMg-s-QuAsZcaM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaAdView.e(this.f$0, view);
            }
        });
    }

    public final com.kakao.adfit.c.b getMainImageView() {
        return this.mainImageView;
    }

    public final int getMediaMaxHeight() {
        return this.measureSpecCalculator.getMaxHeight();
    }

    public final int getMediaMaxWidth() {
        return this.measureSpecCalculator.getMaxWidth();
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final Function1<Integer, Unit> getOnVideoAdProgressChangedListener$library_networkRelease() {
        return this.onVideoAdProgressChangedListener;
    }

    public final Function1<l.a, Unit> getOnVideoAdStateChangedListener$library_networkRelease() {
        return this.onVideoAdStateChangedListener;
    }

    public final View.OnClickListener getOnVideoPlayButtonClickListener() {
        return this.onVideoPlayButtonClickListener;
    }

    public final com.kakao.adfit.c.c getTextureView() {
        return this.textureView;
    }

    public final AdFitVideoAdController getVideoAdController() {
        return this.videoAdController;
    }

    public final com.kakao.adfit.c.a getVideoPanelView() {
        return this.videoPanelView;
    }

    /* JADX INFO: renamed from: getVideoViewState$library_networkRelease, reason: from getter */
    public final l.a getVideoViewState() {
        return this.videoViewState;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        e0 e0Var = this.measureSpecCalculator;
        e0Var.a(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(e0Var.getWidthSpec(), e0Var.getHeightSpec());
    }

    public final void onPlayButtonClicked() {
        m mVar = this.videoViewModel;
        if (mVar == null) {
            return;
        }
        mVar.i();
        View.OnClickListener onClickListener = this.onVideoPlayButtonClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        } else {
            mVar.play();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture texture, int width, int height) {
        Intrinsics.checkNotNullParameter(texture, "texture");
        Surface surface = new Surface(texture);
        this.surface = surface;
        m mVar = this.videoViewModel;
        if (mVar != null) {
            mVar.a(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture texture) {
        Intrinsics.checkNotNullParameter(texture, "texture");
        m mVar = this.videoViewModel;
        if (mVar != null) {
            mVar.h();
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surface = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture texture, int width, int height) {
        Intrinsics.checkNotNullParameter(texture, "texture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture texture) {
        Intrinsics.checkNotNullParameter(texture, "texture");
    }

    public final void setMediaMaxHeight(int i) {
        this.measureSpecCalculator.a(i);
    }

    public final void setMediaMaxSize(int widthPixel, int heightPixel) {
        this.measureSpecCalculator.d(widthPixel, heightPixel);
    }

    public final void setMediaMaxWidth(int i) {
        this.measureSpecCalculator.b(i);
    }

    public final void setMediaSize(int width, int height) {
        float f = (width <= 0 || height <= 0) ? 0.0f : width / height;
        if (this.measureSpecCalculator.getAspectRatio() == f) {
            return;
        }
        this.textureView.setAspectRatio(f);
        this.mainImageView.setAspectRatio(f);
        this.measureSpecCalculator.a(f);
    }

    public final void setOnVideoAdProgressChangedListener$library_networkRelease(Function1<? super Integer, Unit> function1) {
        this.onVideoAdProgressChangedListener = function1;
    }

    public final void setOnVideoAdStateChangedListener$library_networkRelease(Function1<? super l.a, Unit> function1) {
        this.onVideoAdStateChangedListener = function1;
    }

    public final void setOnVideoPlayButtonClickListener(View.OnClickListener onClickListener) {
        this.onVideoPlayButtonClickListener = onClickListener;
    }

    public final void setViewModel(i model) {
        if (Intrinsics.areEqual(this.viewModel, model)) {
            return;
        }
        this.mediaType = model != null ? model.j() : 0;
        this.viewModel = model;
        if (model instanceof m) {
            if (this.imageViewModel != null) {
                this.imageViewModel = null;
                updateImageAdViewModel();
            }
            this.videoViewModel = (m) model;
            updateVideoAdViewModel();
            setBackgroundColor(-16777216);
            return;
        }
        if (model instanceof h) {
            if (this.videoViewModel != null) {
                this.videoViewModel = null;
                updateVideoAdViewModel();
            }
            this.imageViewModel = (h) model;
            updateImageAdViewModel();
            setBackgroundColor(0);
        }
    }

    @Override // com.kakao.adfit.d.f
    public void updateImageAdImage() {
        com.kakao.adfit.c.b bVar = this.mainImageView;
        h hVar = this.imageViewModel;
        bVar.setImageDrawable(hVar != null ? hVar.getImageDrawable() : null);
    }

    @Override // com.kakao.adfit.d.f
    public void updateImageAdSize() {
        h hVar = this.imageViewModel;
        if (hVar == null) {
            return;
        }
        setMediaSize(hVar.getImageWidth(), hVar.getImageHeight());
    }

    public void updateImageAdViewModel() {
        f.a.a(this);
    }

    @Override // com.kakao.adfit.d.k
    public void updateVideoAdImage() {
        com.kakao.adfit.c.b bVar = this.mainImageView;
        m mVar = this.videoViewModel;
        bVar.setImageDrawable(mVar != null ? mVar.o() : null);
    }

    @Override // com.kakao.adfit.d.k
    public void updateVideoAdProgress() {
        m mVar = this.videoViewModel;
        if (mVar == null) {
            return;
        }
        ProgressBar progressBar = this.videoPanelView.getProgressBar();
        progressBar.setMax(mVar.a());
        progressBar.setProgress(mVar.g());
        Function1<? super Integer, Unit> function1 = this.onVideoAdProgressChangedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(mVar.g()));
        }
        Function1<Integer, Unit> onProgressChangedListener = this.videoAdController.getOnProgressChangedListener();
        if (onProgressChangedListener != null) {
            onProgressChangedListener.invoke(Integer.valueOf(mVar.g()));
        }
    }

    @Override // com.kakao.adfit.d.k
    public void updateVideoAdSize() {
        m mVar = this.videoViewModel;
        if (mVar == null) {
            return;
        }
        setMediaSize(mVar.e(), mVar.m());
    }

    @Override // com.kakao.adfit.d.k
    public void updateVideoAdSurface() {
        m mVar;
        Surface surface = this.surface;
        if (surface != null) {
            if (!surface.isValid()) {
                surface = null;
            }
            if (surface == null || (mVar = this.videoViewModel) == null) {
                return;
            }
            mVar.a(surface);
        }
    }

    public void updateVideoAdViewModel() {
        k.a.a(this);
    }

    @Override // com.kakao.adfit.d.k
    public void updateVideoAdViewState() {
        l.a aVarF;
        l.a aVar = this.videoViewState;
        m mVar = this.videoViewModel;
        if (mVar == null || (aVarF = mVar.f()) == null) {
            aVarF = l.a.IDLE;
        }
        if (aVar == aVarF) {
            return;
        }
        this.videoViewState = aVarF;
        int[] iArr = a.a;
        int i = iArr[aVar.ordinal()];
        if (i == 1) {
            this.videoPanelView.getLoadingProgressBar().setVisibility(8);
        } else if (i == 2) {
            setKeepScreenOn(false);
            this.videoPanelView.setClickable(false);
            this.videoPanelView.setOnClickListener(null);
            this.videoPanelView.getPlayButton().clearAnimation();
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.hidePauseButtonAction);
            }
        } else if (i == 3) {
            this.videoPanelView.getPlayButton().clearAnimation();
        } else if (i == 4) {
            this.videoPanelView.getPlayButton().clearAnimation();
            this.videoPanelView.getSoundButton().clearAnimation();
            View view = this.dimLayerView;
            if (view != null) {
                a((ViewGroup) this, view);
                this.dimLayerView = null;
            }
        } else if (i == 5) {
            View view2 = this.errorLayout;
            if (view2 != null) {
                a((ViewGroup) this, view2);
                this.errorLayout = null;
            }
            updateVideoAdImage();
        }
        switch (iArr[aVarF.ordinal()]) {
            case 1:
                this.textureView.setVisibility(0);
                com.kakao.adfit.c.b bVar = this.mainImageView;
                int i2 = iArr[aVar.ordinal()];
                bVar.setVisibility((i2 == 2 || i2 == 3 || i2 == 4) ? 8 : 0);
                com.kakao.adfit.c.a aVar2 = this.videoPanelView;
                aVar2.setVisibility(0);
                aVar2.getLoadingProgressBar().setVisibility(0);
                aVar2.getPlayButton().setVisibility(8);
                aVar2.getSoundButton().setVisibility(iArr[aVar.ordinal()] == 6 ? 8 : 0);
                break;
            case 2:
                setKeepScreenOn(true);
                this.textureView.setVisibility(0);
                this.mainImageView.setVisibility(8);
                com.kakao.adfit.c.a aVar3 = this.videoPanelView;
                aVar3.setVisibility(0);
                aVar3.setClickable(true);
                aVar3.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$OPYS-11Hd43de2vFgGimNXMvjxY
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        MediaAdView.g(this.f$0, view3);
                    }
                });
                aVar3.getPlayButton().setVisibility(8);
                setPauseButton(aVar3.getPlayButton());
                aVar3.getSoundButton().setVisibility(0);
                Object systemService = aVar3.getContext().getSystemService("accessibility");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
                AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
                if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                    aVar3.setClickable(false);
                    aVar3.setOnClickListener(null);
                    aVar3.getPlayButton().setVisibility(0);
                }
                break;
            case 3:
                this.textureView.setVisibility(0);
                this.mainImageView.setVisibility(8);
                com.kakao.adfit.c.a aVar4 = this.videoPanelView;
                aVar4.setVisibility(0);
                if (aVar4.getPlayButton().getVisibility() != 0) {
                    aVar4.getPlayButton().setVisibility(0);
                    a(aVar4.getPlayButton(), 300L);
                }
                setPlayButton(aVar4.getPlayButton());
                aVar4.getSoundButton().setVisibility(0);
                break;
            case 4:
                this.textureView.setVisibility(0);
                this.mainImageView.setVisibility(0);
                com.kakao.adfit.c.a aVar5 = this.videoPanelView;
                aVar5.setVisibility(0);
                if (aVar5.getPlayButton().getVisibility() != 0) {
                    aVar5.getPlayButton().setVisibility(0);
                    a(aVar5.getPlayButton(), 200L);
                }
                setReplayButton(aVar5.getPlayButton());
                if (aVar5.getSoundButton().getVisibility() == 0) {
                    b(aVar5.getSoundButton(), 200L);
                }
                View view3 = this.dimLayerView;
                if (view3 == null) {
                    view3 = new View(getContext());
                    view3.setBackgroundColor(Color.argb(128, 0, 0, 0));
                    addView(view3, 2);
                    this.dimLayerView = view3;
                }
                a(view3, 200L);
                break;
            case 5:
                this.textureView.setVisibility(0);
                this.mainImageView.setVisibility(0);
                this.mainImageView.setImageResource(R.drawable.adfit_error_bg);
                this.videoPanelView.setVisibility(8);
                if (this.errorLayout == null) {
                    View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.adfit_error_layout, (ViewGroup) this, false);
                    viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$jE1zg5YD-_MTE4gHgAN2AMFO1_4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            MediaAdView.f(this.f$0, view4);
                        }
                    });
                    addView(viewInflate);
                    this.errorLayout = viewInflate;
                }
                break;
            case 6:
                this.textureView.setVisibility(0);
                this.mainImageView.setVisibility(0);
                com.kakao.adfit.c.a aVar6 = this.videoPanelView;
                aVar6.setVisibility(0);
                aVar6.getPlayButton().setVisibility(0);
                setPlayButton(aVar6.getPlayButton());
                aVar6.getSoundButton().setVisibility(8);
                break;
            case 7:
                this.textureView.setVisibility(8);
                this.mainImageView.setVisibility(0);
                this.videoPanelView.setVisibility(8);
                break;
        }
        m mVar2 = this.videoViewModel;
        if (!(mVar2 != null && mVar2.n())) {
            ImageView soundButton = this.videoPanelView.getSoundButton();
            if (soundButton.getVisibility() == 0) {
                soundButton.setVisibility(8);
            }
        }
        Function1<? super l.a, Unit> function1 = this.onVideoAdStateChangedListener;
        if (function1 != null) {
            function1.invoke(aVarF);
        }
        Function1<AdFitVideoAdController.State, Unit> onStateChangedListener = this.videoAdController.getOnStateChangedListener();
        if (onStateChangedListener != null) {
            onStateChangedListener.invoke(a(aVarF));
        }
    }

    @Override // com.kakao.adfit.d.k
    public void updateVideoAdVolume() {
        m mVar = this.videoViewModel;
        float fD = mVar != null ? mVar.d() : 0.0f;
        if (fD > 0.0f) {
            setSoundOffButton(this.videoPanelView.getSoundButton());
        } else {
            setSoundOnButton(this.videoPanelView.getSoundButton());
        }
        Function1<Float, Unit> onVolumeChangedListener = this.videoAdController.getOnVolumeChangedListener();
        if (onVolumeChangedListener != null) {
            onVolumeChangedListener.invoke(Float.valueOf(fD));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.videoAdController = a();
        this.name = "MediaAdView@" + hashCode();
        this.videoViewState = l.a.IDLE;
        com.kakao.adfit.c.c cVar = new com.kakao.adfit.c.c(context, null, 0, 6, null);
        cVar.setSurfaceTextureListener(this);
        cVar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        this.textureView = cVar;
        com.kakao.adfit.c.b bVar = new com.kakao.adfit.c.b(context, null, 0, 6, null);
        bVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        bVar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        this.mainImageView = bVar;
        com.kakao.adfit.c.a aVar = new com.kakao.adfit.c.a(context, null, 0, 6, null);
        aVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.videoPanelView = aVar;
        this.measureSpecCalculator = new e0(this, 1.7777778f, 0, 0, 12, null);
        this.hidePauseButtonAction = new Runnable() { // from class: com.kakao.adfit.ads.media.-$$Lambda$MediaAdView$JAhWsb5sM27jujZIokVzcBVmYCM
            @Override // java.lang.Runnable
            public final void run() {
                MediaAdView.a(this.f$0);
            }
        };
        addView(cVar);
        addView(bVar);
        addView(aVar);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MediaAdView, i, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…aAdView, defStyleAttr, 0)");
            try {
                setMediaMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MediaAdView_adfit_mediaMaxWidth, 0));
                setMediaMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MediaAdView_adfit_mediaMaxHeight, 0));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        cVar.setVisibility(8);
        bVar.setVisibility(0);
        aVar.setVisibility(8);
    }

    private final void a(View view, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MediaAdView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onPlayButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MediaAdView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MediaAdView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
    }

    private final void f() {
        if (this.videoViewState != l.a.PLAYING) {
            return;
        }
        ImageView playButton = this.videoPanelView.getPlayButton();
        if (playButton.getVisibility() != 0) {
            playButton.setVisibility(0);
            a(playButton, 300L);
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.hidePauseButtonAction);
            handler.postDelayed(this.hidePauseButtonAction, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MediaAdView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }

    private final void a(ViewGroup viewGroup, View view) {
        try {
            viewGroup.removeView(view);
        } catch (Exception unused) {
        }
    }

    private final b a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdFitVideoAdController.State a(l.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
                return AdFitVideoAdController.State.LOADING;
            case 2:
                return AdFitVideoAdController.State.PLAYING;
            case 3:
                return AdFitVideoAdController.State.PAUSED;
            case 4:
                return AdFitVideoAdController.State.COMPLETED;
            case 5:
                return AdFitVideoAdController.State.ERROR;
            case 6:
                return AdFitVideoAdController.State.INITIALIZED;
            case 7:
                return AdFitVideoAdController.State.IDLE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void b(View view, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new c(view));
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MediaAdView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onPlayButtonClicked();
    }
}
