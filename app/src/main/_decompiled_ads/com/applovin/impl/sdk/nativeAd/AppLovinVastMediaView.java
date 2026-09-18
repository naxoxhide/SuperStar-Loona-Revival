package com.applovin.impl.sdk.nativeAd;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.aw;
import com.applovin.exoplayer2.k.p;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.ui.g;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.k;
import com.applovin.impl.b.f;
import com.applovin.impl.b.l;
import com.applovin.impl.b.m;
import com.applovin.impl.b.o;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class AppLovinVastMediaView extends AppLovinMediaView implements AppLovinCommunicatorSubscriber, u.a {
    private static final String COUNTDOWN_IDENTIFIER_PROGRESS_TRACKING = "PROGRESS_TRACKING";
    private static final long FADE_ANIMATION_DURATION_MILLIS = 250;
    private static final String TAG = "AppLovinVastMediaView";
    private final AtomicBoolean automaticPauseHandled;
    private final AtomicBoolean automaticResumeHandled;
    private final Handler countdownHandler;
    private final k countdownManager;
    private ImageView industryIconImageView;
    private final AtomicBoolean initialOnAttachedToWindowHandled;
    private boolean isVideoMuted;
    private boolean isVideoPausedByUser;
    private final boolean isVideoStream;
    private long lastVideoPositionFromPauseMillis;
    private final com.applovin.impl.sdk.utils.a lifecycleCallbacksAdapter;
    private final AtomicBoolean mediaErrorHandled;
    private final aw mediaPlayer;
    private ImageView muteButtonImageView;
    private ImageView playPauseButtonImageView;
    private FrameLayout replayIconContainer;
    private int savedVideoPercentViewed;
    private long startTimeMillis;
    private final com.applovin.impl.b.a vastAd;
    private long videoDurationMillis;
    private final AtomicBoolean videoEndListenerNotified;
    private final Set<com.applovin.impl.b.k> videoProgressTrackers;
    private final g videoView;
    private boolean videoWasCompleted;
    private LinearLayout videoWidgetLinearLayout;
    private Activity viewActivity;

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return TAG;
    }

    public AppLovinVastMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, n nVar, Context context) {
        int iDpToPx;
        super(appLovinNativeAdImpl, nVar, context);
        Handler handler = new Handler(Looper.getMainLooper());
        this.countdownHandler = handler;
        this.countdownManager = new k(handler, this.sdk);
        this.videoEndListenerNotified = new AtomicBoolean();
        this.mediaErrorHandled = new AtomicBoolean();
        this.initialOnAttachedToWindowHandled = new AtomicBoolean();
        this.automaticPauseHandled = new AtomicBoolean();
        this.automaticResumeHandled = new AtomicBoolean();
        this.isVideoMuted = true;
        this.lastVideoPositionFromPauseMillis = -1L;
        HashSet hashSet = new HashSet();
        this.videoProgressTrackers = hashSet;
        this.lifecycleCallbacksAdapter = new com.applovin.impl.sdk.utils.a() { // from class: com.applovin.impl.sdk.nativeAd.AppLovinVastMediaView.1
            @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (!activity.equals(AppLovinVastMediaView.this.viewActivity) || AppLovinVastMediaView.this.isVideoPausedByUser) {
                    return;
                }
                AppLovinVastMediaView.this.maybeHandleResume();
            }

            @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (activity.equals(AppLovinVastMediaView.this.viewActivity)) {
                    AppLovinVastMediaView.this.maybeHandlePause();
                }
            }
        };
        com.applovin.impl.b.a vastAd = appLovinNativeAdImpl.getVastAd();
        this.vastAd = vastAd;
        boolean zFD = vastAd.FD();
        this.isVideoStream = zFD;
        if (u.a(com.applovin.impl.sdk.c.b.aLW, nVar)) {
            checkCachedAdResourcesAsync(!zFD);
        }
        if (zFD) {
            AppLovinCommunicator.getInstance(context).subscribe(this, "video_caching_failed");
        }
        if (vastAd.LX()) {
            this.industryIconImageView = com.applovin.impl.b.g.b(vastAd.LW().Mt(), context, nVar);
            int iDpToPx2 = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPu)).intValue());
            this.industryIconImageView.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx2, iDpToPx2, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPw)).intValue()));
            this.industryIconImageView.setOnClickListener(new a());
            addView(this.industryIconImageView);
        }
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aPB)).booleanValue()) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.videoWidgetLinearLayout = linearLayout;
            linearLayout.setOrientation(0);
            this.videoWidgetLinearLayout.setBackgroundResource(R.drawable.applovin_rounded_black_background);
            this.videoWidgetLinearLayout.setAlpha(((Float) nVar.a(com.applovin.impl.sdk.c.b.aPA)).floatValue());
            ImageView imageView = new ImageView(context);
            this.playPauseButtonImageView = imageView;
            imageView.setClickable(true);
            d dVar = new d();
            this.playPauseButtonImageView.setOnClickListener(dVar);
            int iDpToPx3 = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPy)).intValue());
            this.playPauseButtonImageView.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx3, iDpToPx3));
            populatePlayPauseImage(false);
            this.videoWidgetLinearLayout.addView(this.playPauseButtonImageView);
            this.muteButtonImageView = new ImageView(context);
            if (populateMuteImage(this.isVideoMuted)) {
                iDpToPx = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPx)).intValue());
                this.muteButtonImageView.setClickable(true);
                this.muteButtonImageView.setOnClickListener(dVar);
                this.muteButtonImageView.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx, iDpToPx));
                this.videoWidgetLinearLayout.addView(this.muteButtonImageView);
            } else {
                iDpToPx = 0;
            }
            int iDpToPx4 = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPz)).intValue());
            this.videoWidgetLinearLayout.setPadding(iDpToPx4, iDpToPx4, iDpToPx4, iDpToPx4);
            int i = iDpToPx4 * 2;
            this.videoWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx3 + iDpToPx + i, Math.max(iDpToPx3, iDpToPx) + i, 8388691));
            addView(this.videoWidgetLinearLayout);
        }
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aPC)).booleanValue()) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.replayIconContainer = frameLayout;
            frameLayout.setBackgroundColor(-16777216);
            this.replayIconContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.replayIconContainer.setVisibility(4);
            this.replayIconContainer.setOnClickListener(new d());
            ImageView imageView2 = new ImageView(getContext());
            int iDpToPx5 = AppLovinSdkUtils.dpToPx(context, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aPD)).intValue());
            imageView2.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx5, iDpToPx5, 17));
            imageView2.setImageResource(R.drawable.applovin_ic_replay_icon);
            imageView2.setAdjustViewBounds(true);
            imageView2.setMaxHeight(this.replayIconContainer.getHeight());
            imageView2.setMaxWidth(this.replayIconContainer.getWidth());
            this.replayIconContainer.addView(imageView2);
            addView(this.replayIconContainer);
        }
        aw awVarCY = new aw.a(getContext()).cY();
        this.mediaPlayer = awVarCY;
        c cVar = new c();
        awVarCY.f(cVar);
        awVarCY.u(0);
        g gVar = new g(getContext());
        this.videoView = gVar;
        gVar.nG();
        gVar.setControllerVisibilityListener(cVar);
        gVar.setPlayer(awVarCY);
        gVar.setOnTouchListener(new AppLovinTouchToClickListener(nVar, com.applovin.impl.sdk.c.b.aLi, getContext(), new b(appLovinNativeAdImpl)));
        addView(gVar);
        bringChildToFront(this.industryIconImageView);
        bringChildToFront(this.videoWidgetLinearLayout);
        prepareMediaPlayer();
        appLovinNativeAdImpl.setVideoView(gVar);
        hashSet.addAll(vastAd.a(com.applovin.impl.b.a.c.VIDEO, l.aXQ));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeHandleOnAttachedToWindow();
        if (this.isVideoPausedByUser) {
            return;
        }
        maybeHandleResume();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        maybeHandlePause();
        super.onDetachedFromWindow();
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinMediaView
    public void destroy() {
        finishVideo();
        ImageView imageView = this.industryIconImageView;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.playPauseButtonImageView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
        ImageView imageView3 = this.muteButtonImageView;
        if (imageView3 != null) {
            imageView3.setOnClickListener(null);
        }
        FrameLayout frameLayout = this.replayIconContainer;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(null);
        }
        this.videoView.setOnTouchListener(null);
        this.viewActivity = null;
        this.mediaPlayer.release();
        this.vastAd.getAdEventTracker().IK();
        this.countdownManager.rA();
        this.countdownHandler.removeCallbacksAndMessages(null);
        if (this.isVideoStream) {
            AppLovinCommunicator.getInstance(getContext()).unsubscribe(this, "video_caching_failed");
        }
        super.destroy();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.vastAd.getAdIdNumber() && this.isVideoStream) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i >= 200 && i < 300) || this.videoWasCompleted || this.mediaPlayer.v()) {
                    return;
                }
                handleMediaError("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
            }
        }
    }

    private void prepareMediaPlayer() {
        if (!u.a(com.applovin.impl.sdk.c.b.aLW, this.sdk)) {
            checkCachedAdResourcesImmediately(!this.isVideoStream);
        }
        com.applovin.exoplayer2.h.u uVarC = new com.applovin.exoplayer2.h.u.a(new p(getContext(), ai.a(getContext(), AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN))).c(ab.a(this.vastAd.FG()));
        this.mediaPlayer.h(!this.isVideoMuted ? 1 : 0);
        this.mediaPlayer.a(uVarC);
        this.mediaPlayer.aD();
        this.mediaPlayer.k(false);
    }

    private void maybeHandleOnAttachedToWindow() {
        if (this.initialOnAttachedToWindowHandled.compareAndSet(false, true)) {
            if (this.industryIconImageView != null && this.vastAd.LX()) {
                maybeFireTrackers(com.applovin.impl.b.a.c.INDUSTRY_ICON_IMPRESSION);
                this.industryIconImageView.setVisibility(0);
            }
            this.startTimeMillis = SystemClock.elapsedRealtime();
            maybeFireTrackers(com.applovin.impl.b.a.c.IMPRESSION);
            maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, "creativeView");
            this.vastAd.getAdEventTracker().IJ();
            this.vastAd.setHasShown(true);
            this.sdk.BB().trackImpression(this.vastAd);
            this.viewActivity = com.applovin.impl.sdk.utils.b.y(u.A(this));
            this.sdk.BK().a(this.lifecycleCallbacksAdapter);
            this.mediaPlayer.k(true);
            this.countdownManager.a(COUNTDOWN_IDENTIFIER_PROGRESS_TRACKING, TimeUnit.SECONDS.toMillis(1L), new k.a() { // from class: com.applovin.impl.sdk.nativeAd.AppLovinVastMediaView.2
                @Override // com.applovin.impl.adview.k.a
                public void rB() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(AppLovinVastMediaView.this.videoDurationMillis - (AppLovinVastMediaView.this.mediaPlayer.aM() - AppLovinVastMediaView.this.mediaPlayer.aN()));
                    int videoPercentViewed = AppLovinVastMediaView.this.getVideoPercentViewed();
                    HashSet hashSet = new HashSet();
                    for (com.applovin.impl.b.k kVar : new HashSet(AppLovinVastMediaView.this.videoProgressTrackers)) {
                        if (kVar.h(seconds, videoPercentViewed)) {
                            hashSet.add(kVar);
                            AppLovinVastMediaView.this.videoProgressTrackers.remove(kVar);
                        }
                    }
                    AppLovinVastMediaView.this.maybeFireTrackers(hashSet);
                    if (videoPercentViewed >= 25 && videoPercentViewed < 50) {
                        AppLovinVastMediaView.this.vastAd.getAdEventTracker().IV();
                        return;
                    }
                    if (videoPercentViewed >= 50 && videoPercentViewed < 75) {
                        AppLovinVastMediaView.this.vastAd.getAdEventTracker().IW();
                    } else if (videoPercentViewed >= 75) {
                        AppLovinVastMediaView.this.vastAd.getAdEventTracker().IX();
                    }
                }

                @Override // com.applovin.impl.adview.k.a
                public boolean rC() {
                    return !AppLovinVastMediaView.this.videoWasCompleted;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeHandlePause() {
        if (this.automaticPauseHandled.compareAndSet(false, true)) {
            maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
            this.vastAd.getAdEventTracker().IZ();
            pauseVideo();
            populatePlayPauseImage(true);
            this.automaticResumeHandled.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeHandleResume() {
        if (this.automaticResumeHandled.compareAndSet(false, true)) {
            maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_RESUME);
            this.vastAd.getAdEventTracker().Ja();
            if (this.lastVideoPositionFromPauseMillis >= 0) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f(TAG, "Resuming video at position " + this.lastVideoPositionFromPauseMillis);
                }
                this.mediaPlayer.k(true);
                this.countdownManager.start();
                this.lastVideoPositionFromPauseMillis = -1L;
            } else {
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.f(TAG, "Invalid last video position, isVideoPlaying=" + this.mediaPlayer.v());
                }
            }
            populatePlayPauseImage(false);
            this.automaticPauseHandled.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishVideo() {
        maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, "close");
        maybeHandlePause();
        this.sdk.BK().b(this.lifecycleCallbacksAdapter);
        if (this.videoWasCompleted) {
            maybeFireRemainingCompletionTrackers();
            this.vastAd.getAdEventTracker().IY();
        }
        if (this.videoEndListenerNotified.compareAndSet(false, true)) {
            this.sdk.BB().trackVideoEnd(this.vastAd, TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.startTimeMillis), getVideoPercentViewed(), this.isVideoStream);
        }
    }

    private void pauseVideo() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(TAG, "Pausing video");
        }
        this.savedVideoPercentViewed = getVideoPercentViewed();
        this.lastVideoPositionFromPauseMillis = this.mediaPlayer.aN();
        this.mediaPlayer.k(false);
        this.countdownManager.W();
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(TAG, "Paused video at position " + this.lastVideoPositionFromPauseMillis + " ms");
        }
    }

    private void checkCachedAdResourcesImmediately(boolean z) {
        if (u.a(z, this.vastAd, this.sdk, getContext()).isEmpty()) {
            return;
        }
        handleUnavailableCachedResources();
    }

    private void checkCachedAdResourcesAsync(boolean z) {
        u.a(z, this.vastAd, this.sdk, n.getApplicationContext(), this);
    }

    @Override // com.applovin.impl.sdk.utils.u.a
    public void onCachedResourcesChecked(boolean z) {
        if (z) {
            return;
        }
        handleUnavailableCachedResources();
    }

    private void handleUnavailableCachedResources() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.i(TAG, "Video failed due to unavailable resources");
        }
        finishVideo();
        showMediaImageView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMediaError(String str) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.i(TAG, str);
        }
        maybeFireTrackers(com.applovin.impl.b.a.c.ERROR, f.MEDIA_FILE_ERROR);
        this.vastAd.getAdEventTracker().dn(str);
        if (this.mediaErrorHandled.compareAndSet(false, true)) {
            finishVideo();
            showMediaImageView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMediaImageView() {
        if (this.imageView.getDrawable() == null) {
            return;
        }
        this.imageView.setVisibility(0);
        this.videoView.setVisibility(8);
        LinearLayout linearLayout = this.videoWidgetLinearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView = this.industryIconImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void maybeFireRemainingCompletionTrackers() {
        if (getVideoPercentViewed() < this.vastAd.GC() || this.videoProgressTrackers.isEmpty()) {
            return;
        }
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.h(TAG, "Firing " + this.videoProgressTrackers.size() + " un-fired video progress trackers when video was completed.");
        }
        maybeFireTrackers(this.videoProgressTrackers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getVideoPercentViewed() {
        long jAN = this.mediaPlayer.aN();
        if (this.videoWasCompleted) {
            return 100;
        }
        if (jAN > 0) {
            return (int) ((jAN / this.videoDurationMillis) * 100.0f);
        }
        return this.savedVideoPercentViewed;
    }

    private void populatePlayPauseImage(boolean z) {
        if (this.playPauseButtonImageView == null) {
            return;
        }
        com.applovin.impl.b.a aVar = this.vastAd;
        Uri uriHr = z ? aVar.Hr() : aVar.Hs();
        if (uriHr != null) {
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.playPauseButtonImageView.setImageURI(uriHr);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return;
        }
        this.playPauseButtonImageView.setImageResource(z ? R.drawable.applovin_ic_play_icon : R.drawable.applovin_ic_pause_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean populateMuteImage(boolean z) {
        if (this.muteButtonImageView == null) {
            return false;
        }
        com.applovin.impl.b.a aVar = this.vastAd;
        Uri uriHt = z ? aVar.Ht() : aVar.Hu();
        if (uriHt != null) {
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.muteButtonImageView.setImageURI(uriHt);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return true;
        }
        if (!h.KV()) {
            return false;
        }
        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getContext().getDrawable(z ? R.drawable.applovin_ic_unmute_to_mute : R.drawable.applovin_ic_mute_to_unmute);
        if (animatedVectorDrawable == null) {
            return false;
        }
        this.muteButtonImageView.setImageDrawable(animatedVectorDrawable);
        animatedVectorDrawable.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFireTrackers(Set<com.applovin.impl.b.k> set) {
        maybeFireTrackers(set, f.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFireTrackers(com.applovin.impl.b.a.c cVar) {
        maybeFireTrackers(cVar, f.UNSPECIFIED);
    }

    private void maybeFireTrackers(com.applovin.impl.b.a.c cVar, String str) {
        maybeFireTrackers(cVar, str, f.UNSPECIFIED);
    }

    private void maybeFireTrackers(com.applovin.impl.b.a.c cVar, f fVar) {
        maybeFireTrackers(cVar, "", fVar);
    }

    private void maybeFireTrackers(com.applovin.impl.b.a.c cVar, String str, f fVar) {
        maybeFireTrackers(this.vastAd.a(cVar, str), fVar);
    }

    private void maybeFireTrackers(Set<com.applovin.impl.b.k> set, f fVar) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.mediaPlayer.aN());
        o oVarLT = this.vastAd.LT();
        Uri uriMG = oVarLT != null ? oVarLT.MG() : null;
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(TAG, "Firing " + set.size() + " tracker(s): " + set);
        }
        m.a(set, seconds, uriMG, fVar, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c implements an.b, com.applovin.exoplayer2.ui.f.d {
        private c() {
        }

        @Override // com.applovin.exoplayer2.an.b
        public void Z(int i) {
            x xVar = AppLovinVastMediaView.this.logger;
            if (x.Fk()) {
                AppLovinVastMediaView.this.logger.f(AppLovinVastMediaView.TAG, "Player state changed to state " + i + " and will play when ready: " + AppLovinVastMediaView.this.mediaPlayer.aE());
            }
            if (i == 3) {
                AppLovinVastMediaView.this.mediaPlayer.h(!AppLovinVastMediaView.this.isVideoMuted ? 1 : 0);
                AppLovinVastMediaView appLovinVastMediaView = AppLovinVastMediaView.this;
                appLovinVastMediaView.videoDurationMillis = appLovinVastMediaView.mediaPlayer.aM();
                AppLovinVastMediaView.this.vastAd.getAdEventTracker().b(TimeUnit.MILLISECONDS.toSeconds(AppLovinVastMediaView.this.videoDurationMillis), u.P(AppLovinVastMediaView.this.sdk));
                x xVar2 = AppLovinVastMediaView.this.logger;
                if (x.Fk()) {
                    AppLovinVastMediaView.this.logger.f(AppLovinVastMediaView.TAG, "MediaPlayer prepared: " + AppLovinVastMediaView.this.mediaPlayer);
                }
                AppLovinVastMediaView.this.countdownManager.start();
                return;
            }
            if (i == 4) {
                x xVar3 = AppLovinVastMediaView.this.logger;
                if (x.Fk()) {
                    AppLovinVastMediaView.this.logger.f(AppLovinVastMediaView.TAG, "Video completed");
                }
                AppLovinVastMediaView.this.videoWasCompleted = true;
                AppLovinVastMediaView.this.finishVideo();
                if (AppLovinVastMediaView.this.replayIconContainer != null) {
                    v.a(AppLovinVastMediaView.this.replayIconContainer, AppLovinVastMediaView.FADE_ANIMATION_DURATION_MILLIS, new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.-$$Lambda$AppLovinVastMediaView$c$jfTKkbj9eYRFimQvftPLzojTk4g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.HF();
                        }
                    });
                } else {
                    AppLovinVastMediaView.this.showMediaImageView();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void HF() {
            AppLovinVastMediaView.this.mediaPlayer.b(0L);
        }

        @Override // com.applovin.exoplayer2.an.b
        public void a(ak akVar) {
            AppLovinVastMediaView.this.handleMediaError("Video view error (" + u.a(akVar, AppLovinVastMediaView.this.sdk) + ")");
        }

        @Override // com.applovin.exoplayer2.ui.f.d
        public void eZ(int i) {
            if (i == 0) {
                AppLovinVastMediaView.this.videoView.nG();
            }
        }
    }

    private class b implements AppLovinTouchToClickListener.OnClickListener {
        private final AppLovinNativeAdImpl aHd;

        public b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.aHd = appLovinNativeAdImpl;
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            Uri uriFJ;
            AppLovinVastMediaView.this.maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO_CLICK);
            AppLovinVastMediaView.this.vastAd.getAdEventTracker().Je();
            if (AppLovinVastMediaView.this.vastAd.Go() && (uriFJ = AppLovinVastMediaView.this.vastAd.FJ()) != null) {
                x xVar = AppLovinVastMediaView.this.logger;
                if (x.Fk()) {
                    AppLovinVastMediaView.this.logger.f(AppLovinVastMediaView.TAG, "Clicking through video");
                }
                AppLovinVastMediaView.this.sdk.BB().maybeSubmitPersistentPostbacks(AppLovinVastMediaView.this.vastAd.a(motionEvent, false));
                this.aHd.handleNativeAdClick(uriFJ, null, motionEvent, AppLovinVastMediaView.this.getContext());
            }
        }
    }

    private class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Uri uriMu;
            com.applovin.impl.b.g gVarLW = AppLovinVastMediaView.this.vastAd.LW();
            if (gVarLW == null || (uriMu = gVarLW.Mu()) == null) {
                return;
            }
            x xVar = AppLovinVastMediaView.this.logger;
            if (x.Fk()) {
                AppLovinVastMediaView.this.logger.f(AppLovinVastMediaView.TAG, "Industry icon clicked, opening URL: " + uriMu);
            }
            AppLovinVastMediaView.this.maybeFireTrackers(com.applovin.impl.b.a.c.INDUSTRY_ICON_CLICK);
            s.a(uriMu, view.getContext(), AppLovinVastMediaView.this.sdk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class d implements View.OnClickListener {
        private d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == AppLovinVastMediaView.this.playPauseButtonImageView) {
                if (AppLovinVastMediaView.this.mediaPlayer.v()) {
                    AppLovinVastMediaView.this.isVideoPausedByUser = true;
                    AppLovinVastMediaView.this.maybeHandlePause();
                    return;
                } else {
                    AppLovinVastMediaView.this.isVideoPausedByUser = false;
                    AppLovinVastMediaView.this.maybeHandleResume();
                    return;
                }
            }
            if (view == AppLovinVastMediaView.this.muteButtonImageView) {
                boolean z = !AppLovinVastMediaView.this.isVideoMuted;
                AppLovinVastMediaView.this.isVideoMuted = z;
                AppLovinVastMediaView.this.mediaPlayer.h(!z ? 1 : 0);
                AppLovinVastMediaView.this.populateMuteImage(z);
                return;
            }
            if (view == AppLovinVastMediaView.this.replayIconContainer) {
                v.b(AppLovinVastMediaView.this.replayIconContainer, AppLovinVastMediaView.FADE_ANIMATION_DURATION_MILLIS, new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.-$$Lambda$AppLovinVastMediaView$d$aRexRIweCdW1wJI2YG5dN4IznDg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.sQ();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void sQ() {
            AppLovinVastMediaView.this.videoWasCompleted = false;
            AppLovinVastMediaView.this.automaticResumeHandled.set(false);
            AppLovinVastMediaView.this.sdk.BK().a(AppLovinVastMediaView.this.lifecycleCallbacksAdapter);
            AppLovinVastMediaView.this.maybeHandleResume();
        }
    }
}
