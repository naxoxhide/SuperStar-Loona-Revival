package com.kakao.adfit.d;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.view.Surface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.media.NativeAdVideoPlayPolicy;
import com.kakao.adfit.l.VastMediaFile;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: VideoTypeMediaAdViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020%\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b[\u0010\\J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R$\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00104R.\u0010=\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001068\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b\u0006\u0010<R$\u0010@\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0012\u0010>\u001a\u0004\b.\u0010?R$\u0010B\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\bA\u0010?R$\u0010D\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bC\u0010>\u001a\u0004\b\u0006\u0010?R$\u0010E\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u0019\u0010>\u001a\u0004\b8\u0010?R*\u0010I\u001a\u00020\t2\u0006\u00107\u001a\u00020\t8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010F\u001a\u0004\b)\u0010G\"\u0004\b\u0006\u0010HR$\u0010M\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bA\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010NR\u0016\u0010P\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010JR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010RR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010JR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010XR\u0016\u0010Z\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010J¨\u0006]"}, d2 = {"Lcom/kakao/adfit/d/x;", "Lcom/kakao/adfit/d/m;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "", "Lcom/kakao/adfit/l/d;", "files", "a", "Lcom/kakao/adfit/d/j;", CampaignEx.JSON_KEY_AD_Q, "", TapjoyConstants.TJC_VOLUME, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "t", "s", "p", "Landroid/view/Surface;", "surface", "h", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, CampaignEx.JSON_KEY_AD_R, "i", "c", "l", CampaignEx.JSON_KEY_AD_K, "", "isViewable", "", "focusChange", "onAudioFocusChange", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/kakao/adfit/d/k;", "Lcom/kakao/adfit/d/k;", "view", "Lcom/kakao/adfit/d/p$k;", "Lcom/kakao/adfit/d/p$k;", "video", "Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;", "policy", "Lcom/kakao/adfit/d/l$a;", "<set-?>", "e", "Lcom/kakao/adfit/d/l$a;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/kakao/adfit/d/l$a;", "viewState", "", "Ljava/lang/String;", "videoPath", "Landroid/graphics/drawable/Drawable;", "value", "g", "Landroid/graphics/drawable/Drawable;", "o", "()Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "videoImage", "I", "()I", TJAdUnitConstants.String.VIDEO_WIDTH, InneractiveMediationDefs.GENDER_MALE, TJAdUnitConstants.String.VIDEO_HEIGHT, "j", TJAdUnitConstants.String.VIDEO_DURATION, "videoPosition", "F", "()F", "(F)V", "videoVolume", "Z", "n", "()Z", "isAudioTrackPrepared", "Lcom/kakao/adfit/d/j;", "player", "playWhenAvailable", "Lcom/kakao/adfit/l/c;", "Lcom/kakao/adfit/l/c;", "vastEventTracker", "Landroid/media/AudioManager;", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioFocusRequest;", "Landroid/media/AudioFocusRequest;", "audioFocusRequest", "isAudioFocusGained", "<init>", "(Landroid/content/Context;Lcom/kakao/adfit/d/k;Lcom/kakao/adfit/d/p$k;Lcom/kakao/adfit/ads/media/NativeAdVideoPlayPolicy;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class x implements m, AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final k view;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final p.k video;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final NativeAdVideoPlayPolicy policy;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private l.a viewState;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final String videoPath;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private Drawable videoImage;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private int videoWidth;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private int videoHeight;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private int videoDuration;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private int videoPosition;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private float videoVolume;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private boolean isAudioTrackPrepared;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private j player;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private boolean playWhenAvailable;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final com.kakao.adfit.l.c vastEventTracker;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private boolean isViewable;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final AudioManager audioManager;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private AudioFocusRequest audioFocusRequest;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private boolean isAudioFocusGained;

    /* JADX INFO: compiled from: VideoTypeMediaAdViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/kakao/adfit/d/j;", "<anonymous parameter 0>", "Lcom/kakao/adfit/d/j$c;", "playerState", "", "a", "(Lcom/kakao/adfit/d/j;Lcom/kakao/adfit/d/j$c;)V"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function2<j, j.c, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f1770b;

        /* JADX INFO: renamed from: com.kakao.adfit.d.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VideoTypeMediaAdViewModel.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class C0455a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[j.c.values().length];
                iArr[j.c.PREPARED.ordinal()] = 1;
                iArr[j.c.STARTED.ordinal()] = 2;
                iArr[j.c.PAUSED.ordinal()] = 3;
                iArr[j.c.STOPPED.ordinal()] = 4;
                iArr[j.c.COMPLETED.ordinal()] = 5;
                iArr[j.c.ERROR.ordinal()] = 6;
                iArr[j.c.IDLE.ordinal()] = 7;
                iArr[j.c.INITIALIZED.ordinal()] = 8;
                iArr[j.c.PREPARING.ordinal()] = 9;
                iArr[j.c.RELEASED.ordinal()] = 10;
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(w wVar) {
            super(2);
            this.f1770b = wVar;
        }

        public final void a(j jVar, j.c playerState) {
            l.a aVar;
            Intrinsics.checkNotNullParameter(jVar, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(playerState, "playerState");
            if (x.this.isAudioFocusGained && playerState != j.c.STARTED) {
                this.f1770b.setVolume(0.0f);
                x.this.p();
            }
            if (x.this.getIsAudioTrackPrepared() && !this.f1770b.d()) {
                x.this.isAudioTrackPrepared = false;
            }
            int[] iArr = C0455a.a;
            switch (iArr[playerState.ordinal()]) {
                case 1:
                    if (this.f1770b.d()) {
                        x.this.videoWidth = this.f1770b.n();
                        x.this.videoHeight = this.f1770b.m();
                        x.this.view.updateVideoAdSize();
                        x.this.isAudioTrackPrepared = this.f1770b.g();
                        if (!x.this.isAudioFocusGained && x.this.getVideoVolume() > 0.0f) {
                            x.this.t();
                        }
                        int iF = this.f1770b.f();
                        if (x.this.getVideoDuration() != iF) {
                            x.this.videoDuration = iF;
                            x.this.video.a(iF);
                            x.this.vastEventTracker.a(iF);
                            x.this.view.updateVideoAdProgress();
                        }
                        int videoPosition = x.this.getVideoPosition();
                        if (videoPosition > 0) {
                            this.f1770b.a(videoPosition);
                        }
                        if (x.this.playWhenAvailable) {
                            x.this.play();
                        }
                    }
                    break;
                case 2:
                    if (!x.this.vastEventTracker.getIsStarted()) {
                        x.this.vastEventTracker.i();
                    } else {
                        x.this.vastEventTracker.h();
                    }
                    break;
                case 3:
                case 4:
                    x.this.vastEventTracker.f();
                    break;
                case 5:
                    x.this.video.b(0);
                    x.this.vastEventTracker.c();
                    break;
                case 6:
                    x.this.vastEventTracker.d();
                    break;
            }
            x xVar = x.this;
            switch (iArr[playerState.ordinal()]) {
                case 1:
                    aVar = !x.this.playWhenAvailable ? l.a.PAUSED : l.a.LOADING;
                    break;
                case 2:
                    aVar = l.a.PLAYING;
                    break;
                case 3:
                    aVar = l.a.PAUSED;
                    break;
                case 4:
                case 5:
                case 10:
                    aVar = l.a.COMPLETED;
                    break;
                case 6:
                    aVar = l.a.ERROR;
                    break;
                case 7:
                case 8:
                    aVar = l.a.INITIALIZED;
                    break;
                case 9:
                    aVar = l.a.LOADING;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            xVar.viewState = aVar;
            x.this.view.updateVideoAdViewState();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(j jVar, j.c cVar) {
            a(jVar, cVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: VideoTypeMediaAdViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/kakao/adfit/d/j;", "<anonymous parameter 0>", "", "position", "", "a", "(Lcom/kakao/adfit/d/j;I)V"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function2<j, Integer, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f1771b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(w wVar) {
            super(2);
            this.f1771b = wVar;
        }

        public final void a(j jVar, int i) {
            Intrinsics.checkNotNullParameter(jVar, "<anonymous parameter 0>");
            x.this.videoPosition = i;
            if (this.f1771b.getState() != j.c.COMPLETED) {
                x.this.video.b(i);
            }
            x.this.vastEventTracker.b(i);
            x.this.view.updateVideoAdProgress();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(j jVar, Integer num) {
            a(jVar, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: VideoTypeMediaAdViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0})
    static final class c extends Lambda implements Function1<String, Unit> {
        c() {
            super(1);
        }

        public final void a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.kakao.adfit.a.g.a(x.this.context).a(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    public x(Context context, k view, p.k video, NativeAdVideoPlayPolicy policy) {
        String url;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.context = context;
        this.view = view;
        this.video = video;
        this.policy = policy;
        this.viewState = l.a.INITIALIZED;
        VastMediaFile vastMediaFileA = a(video.getVast().c());
        this.videoPath = (vastMediaFileA == null || (url = vastMediaFileA.getUrl()) == null) ? "" : url;
        this.videoWidth = 16;
        this.videoHeight = 9;
        this.videoDuration = video.getDuration();
        this.videoPosition = video.getProgress();
        this.videoVolume = video.getCom.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_MUTE java.lang.String() ? 0.0f : 1.0f;
        this.player = q();
        com.kakao.adfit.l.c cVar = new com.kakao.adfit.l.c(video, new c());
        this.vastEventTracker = cVar;
        Object systemService = context.getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        if (cVar.getIsStarted() && cVar.getIsCompleted()) {
            cVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (this.isAudioFocusGained) {
            this.isAudioFocusGained = false;
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
                    if (audioFocusRequest != null) {
                        this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
                    }
                } else {
                    this.audioManager.abandonAudioFocus(this);
                }
            } catch (Exception e) {
                com.kakao.adfit.k.f.b("Failed to abandon audio focus. : " + e);
                com.kakao.adfit.e.f.a.a(e);
            }
        }
    }

    private final j q() {
        w wVar = new w(this.videoPath);
        wVar.b(new a(wVar));
        wVar.a(new b(wVar));
        return wVar;
    }

    private final void s() {
        if (this.isAudioFocusGained) {
            return;
        }
        this.isAudioFocusGained = true;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequestBuild = this.audioFocusRequest;
                if (audioFocusRequestBuild == null) {
                    audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this).build();
                    Intrinsics.checkNotNull(audioFocusRequestBuild);
                }
                if (this.audioManager.requestAudioFocus(audioFocusRequestBuild) != 1) {
                    com.kakao.adfit.k.f.e("Failed to request audio focus.");
                    this.isAudioFocusGained = false;
                }
            } else if (this.audioManager.requestAudioFocus(this, 3, 2) != 1) {
                com.kakao.adfit.k.f.e("Failed to request audio focus.");
                this.isAudioFocusGained = false;
            }
        } catch (Exception e) {
            this.isAudioFocusGained = false;
            com.kakao.adfit.k.f.b("Failed to request audio focus. : " + e);
            com.kakao.adfit.e.f.a.a(e);
        }
        if (this.isAudioFocusGained) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
                if (audioFocusRequest != null) {
                    this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
                }
            } else {
                this.audioManager.abandonAudioFocus(this);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        a(0.0f);
        this.player.setVolume(0.0f);
        p();
        this.view.updateVideoAdVolume();
    }

    @Override // com.kakao.adfit.d.l
    public void i() {
        this.vastEventTracker.g();
    }

    @Override // com.kakao.adfit.d.i
    public int j() {
        return m.a.a(this);
    }

    @Override // com.kakao.adfit.d.l
    public void k() {
        if (this.player.getState() != j.c.ERROR) {
            return;
        }
        Surface surface = this.player.getSurface();
        this.player.a((Surface) null);
        this.player.b(null);
        this.player.a((Function2<? super j, ? super Integer, Unit>) null);
        this.player.a();
        j jVarQ = q();
        this.player = jVarQ;
        jVarQ.a(surface);
        play();
    }

    @Override // com.kakao.adfit.d.l
    public void l() {
        this.vastEventTracker.e();
        t();
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: m, reason: from getter */
    public int getVideoHeight() {
        return this.videoHeight;
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: n, reason: from getter */
    public boolean getIsAudioTrackPrepared() {
        return this.isAudioTrackPrepared;
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: o, reason: from getter */
    public Drawable getVideoImage() {
        return this.videoImage;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange == -3) {
            if (this.isAudioFocusGained) {
                this.player.setVolume(getVideoVolume() * 0.1f);
            }
        } else {
            if (focusChange == -2 || focusChange == -1) {
                if (this.isAudioFocusGained && this.player.b()) {
                    pause();
                    return;
                } else {
                    this.player.setVolume(0.0f);
                    return;
                }
            }
            if ((focusChange == 1 || focusChange == 2 || focusChange == 3) && this.isAudioFocusGained) {
                this.player.setVolume(getVideoVolume());
            }
        }
    }

    @Override // com.kakao.adfit.d.l
    public void pause() {
        if (this.playWhenAvailable) {
            this.playWhenAvailable = false;
            if (getViewState() == l.a.LOADING && this.player.getState() != j.c.PREPARING) {
                this.viewState = l.a.PAUSED;
                this.view.updateVideoAdViewState();
            }
        }
        this.player.pause();
    }

    @Override // com.kakao.adfit.d.l
    public void play() {
        boolean z = true;
        if (!this.player.d()) {
            this.player.c();
            this.playWhenAvailable = true;
            return;
        }
        Surface surface = this.player.getSurface();
        if (!(surface != null && surface.isValid())) {
            this.playWhenAvailable = true;
            l.a viewState = getViewState();
            if (viewState != l.a.INITIALIZED && viewState != l.a.PAUSED) {
                z = false;
            }
            if (z) {
                this.viewState = l.a.LOADING;
                this.view.updateVideoAdViewState();
                return;
            }
            return;
        }
        if (!this.isViewable) {
            this.playWhenAvailable = true;
            l.a viewState2 = getViewState();
            if (viewState2 != l.a.INITIALIZED && viewState2 != l.a.PAUSED) {
                z = false;
            }
            if (z) {
                this.viewState = l.a.LOADING;
                this.view.updateVideoAdViewState();
                return;
            }
            return;
        }
        if (getVideoVolume() <= 0.0f) {
            this.player.setVolume(0.0f);
        } else if (getIsAudioTrackPrepared()) {
            if (!this.isAudioFocusGained) {
                s();
            }
            if (this.isAudioFocusGained) {
                this.player.setVolume(1.0f);
            } else {
                t();
            }
        } else {
            t();
        }
        this.player.play();
    }

    public void r() {
        this.player.a();
        this.player.b(null);
        this.player.a((Function2<? super j, ? super Integer, Unit>) null);
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: e, reason: from getter */
    public int getVideoWidth() {
        return this.videoWidth;
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: f, reason: from getter */
    public l.a getViewState() {
        return this.viewState;
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: g, reason: from getter */
    public int getVideoPosition() {
        return this.videoPosition;
    }

    @Override // com.kakao.adfit.d.l
    public void h() {
        this.player.a((Surface) null);
        this.player.pause();
    }

    @Override // com.kakao.adfit.d.l
    public void b() {
        pause();
    }

    @Override // com.kakao.adfit.d.l
    public void c() {
        this.vastEventTracker.j();
        a(this, 0.0f, 1, null);
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: d, reason: from getter */
    public float getVideoVolume() {
        return this.videoVolume;
    }

    private final void b(float volume) {
        a(volume);
        if (this.player.d()) {
            if (!getIsAudioTrackPrepared()) {
                t();
                return;
            } else if (this.player.b()) {
                if (!this.isAudioFocusGained) {
                    s();
                    if (!this.isAudioFocusGained) {
                        t();
                        return;
                    }
                }
                this.player.setVolume(volume);
            }
        }
        this.view.updateVideoAdVolume();
    }

    public void a(Drawable drawable) {
        if (Intrinsics.areEqual(this.videoImage, drawable)) {
            return;
        }
        this.videoImage = drawable;
        this.view.updateVideoAdImage();
    }

    @Override // com.kakao.adfit.d.l
    /* JADX INFO: renamed from: a, reason: from getter */
    public int getVideoDuration() {
        return this.videoDuration;
    }

    @Override // com.kakao.adfit.d.l
    public void a(float f) {
        if (this.videoVolume == f) {
            return;
        }
        this.videoVolume = f;
        if (f > 0.0f) {
            this.video.a(false);
            b(f);
        } else {
            this.video.a(true);
            t();
        }
    }

    private final VastMediaFile a(List<VastMediaFile> files) {
        VastMediaFile vastMediaFile;
        int width;
        int width2;
        if (files == null || (vastMediaFile = (VastMediaFile) CollectionsKt.firstOrNull((List) files)) == null) {
            return null;
        }
        if (files.size() == 1) {
            return vastMediaFile;
        }
        if (!com.kakao.adfit.k.t.d(this.context)) {
            for (VastMediaFile vastMediaFile2 : files) {
                int width3 = vastMediaFile.getWidth() * vastMediaFile.getHeight();
                int width4 = vastMediaFile2.getWidth() * vastMediaFile2.getHeight();
                if (width3 > width4 || (width3 == width4 && vastMediaFile.getBitrate() > vastMediaFile2.getBitrate())) {
                    vastMediaFile = vastMediaFile2;
                }
            }
            return vastMediaFile;
        }
        Point pointA = com.kakao.adfit.k.j.a(com.kakao.adfit.k.j.a(this.context), null, 2, null);
        int iB = com.kakao.adfit.k.j.b(this.context, Math.min(pointA.x, pointA.y));
        for (VastMediaFile vastMediaFile3 : files) {
            int iAbs = Math.abs(iB - vastMediaFile.getWidth());
            int iAbs2 = Math.abs(iB - vastMediaFile3.getWidth());
            if (iAbs > iAbs2 || (iAbs == iAbs2 && ((width = vastMediaFile.getWidth() * vastMediaFile.getHeight()) < (width2 = vastMediaFile3.getWidth() * vastMediaFile3.getHeight()) || (width == width2 && vastMediaFile.getBitrate() < vastMediaFile3.getBitrate())))) {
                vastMediaFile = vastMediaFile3;
            }
        }
        return vastMediaFile;
    }

    @Override // com.kakao.adfit.d.l
    public void a(Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.player.a(surface);
        if (this.playWhenAvailable) {
            play();
        }
    }

    static /* synthetic */ void a(x xVar, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        xVar.b(f);
    }

    public void a(boolean isViewable) {
        if (this.isViewable == isViewable) {
            return;
        }
        this.isViewable = isViewable;
        if (isViewable) {
            if (this.playWhenAvailable) {
                play();
                return;
            }
            if (this.policy.getAutoPlayEnabled() || (this.policy.getWifiAutoPlayEnabled() && com.kakao.adfit.k.t.d(this.context))) {
                if (!this.player.b() && getVideoVolume() > 0.0f) {
                    t();
                }
                play();
                return;
            }
            return;
        }
        pause();
    }
}
