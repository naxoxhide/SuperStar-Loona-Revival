package com.applovin.impl.adview.activity.b;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.aw;
import com.applovin.exoplayer2.k.p;
import com.applovin.exoplayer2.l.ai;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.h;
import com.applovin.impl.adview.k;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.w;
import com.applovin.impl.adview.x;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.applovin.impl.adview.activity.b.a implements AppLovinCommunicatorSubscriber {
    protected final ProgressBar agb;
    private final Handler ajA;
    protected final k ajB;
    protected boolean ajC;
    private final AtomicBoolean ajD;
    private long ajE;
    private long ajF;
    private final com.applovin.impl.adview.activity.a.c ajt;
    protected final com.applovin.impl.adview.a aju;
    protected final n ajv;
    protected h ajw;
    protected w ajx;
    protected ProgressBar ajy;
    private final a ajz;
    private final Handler countdownHandler;
    protected final k countdownManager;
    protected boolean isVideoMuted;
    private final boolean isVideoStream;
    private long lastVideoPositionFromPauseMillis;
    private final AtomicBoolean mediaErrorHandled;
    protected final aw mediaPlayer;
    protected final ImageView muteButtonImageView;
    protected int savedVideoPercentViewed;
    protected long videoDurationMillis;
    protected final com.applovin.exoplayer2.ui.g videoView;
    protected boolean videoWasCompleted;

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    public e(com.applovin.impl.sdk.ad.e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.ajt = new com.applovin.impl.adview.activity.a.c(this.aiL, this.ahM, this.sdk);
        a aVar = new a();
        this.ajz = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.countdownHandler = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.ajA = handler2;
        k kVar = new k(handler, this.sdk);
        this.countdownManager = kVar;
        this.ajB = new k(handler2, this.sdk);
        boolean zFD = this.aiL.FD();
        this.isVideoStream = zFD;
        this.isVideoMuted = u.P(this.sdk);
        this.lastVideoPositionFromPauseMillis = -1L;
        this.mediaErrorHandled = new AtomicBoolean();
        this.ajD = new AtomicBoolean();
        this.ajE = -2L;
        this.ajF = 0L;
        if (!eVar.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        if (u.a(com.applovin.impl.sdk.c.b.aLW, nVar)) {
            checkCachedAdResourcesAsync(!zFD);
        }
        c cVar = new c();
        if (eVar.Ga() >= 0) {
            n nVar2 = new n(eVar.Gh(), activity);
            this.ajv = nVar2;
            nVar2.setVisibility(8);
            nVar2.setOnClickListener(cVar);
        } else {
            this.ajv = null;
        }
        if (a(this.isVideoMuted, nVar)) {
            ImageView imageView = new ImageView(activity);
            this.muteButtonImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(cVar);
            av(this.isVideoMuted);
        } else {
            this.muteButtonImageView = null;
        }
        String strGm = eVar.Gm();
        if (StringUtils.isValidString(strGm)) {
            x xVar = new x(nVar);
            xVar.a(new WeakReference<>(aVar));
            w wVar = new w(xVar, activity);
            this.ajx = wVar;
            wVar.bs(strGm);
        } else {
            this.ajx = null;
        }
        if (zFD) {
            com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNk)).intValue(), R.attr.progressBarStyleLarge);
            this.aju = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            AppLovinCommunicator.getInstance(activity).subscribe(this, "video_caching_failed");
        } else {
            this.aju = null;
        }
        final int iSC = sC();
        boolean z = ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aMU)).booleanValue() && iSC > 0;
        if (this.ajw == null && z) {
            this.ajw = new h(activity);
            int iGs = eVar.Gs();
            this.ajw.setTextColor(iGs);
            this.ajw.setTextSize(((Integer) nVar.a(com.applovin.impl.sdk.c.b.aMT)).intValue());
            this.ajw.setFinishedStrokeColor(iGs);
            this.ajw.setFinishedStrokeWidth(((Integer) nVar.a(com.applovin.impl.sdk.c.b.aMS)).intValue());
            this.ajw.setMax(iSC);
            this.ajw.setProgress(iSC);
            kVar.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1L), new k.a() { // from class: com.applovin.impl.adview.activity.b.e.1
                @Override // com.applovin.impl.adview.k.a
                public void rB() {
                    if (e.this.ajw != null) {
                        long seconds = ((long) iSC) - TimeUnit.MILLISECONDS.toSeconds(e.this.videoView.getPlayer().aN());
                        if (seconds <= 0) {
                            e.this.aja = true;
                        } else if (e.this.tg()) {
                            e.this.ajw.setProgress((int) seconds);
                        }
                    }
                }

                @Override // com.applovin.impl.adview.k.a
                public boolean rC() {
                    return e.this.tg();
                }
            });
        }
        if (eVar.GA()) {
            Long l = (Long) nVar.a(com.applovin.impl.sdk.c.b.aNh);
            final Integer num = (Integer) nVar.a(com.applovin.impl.sdk.c.b.aNi);
            ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
            this.agb = progressBar;
            a(progressBar, eVar.GB(), num.intValue());
            kVar.a("PROGRESS_BAR", l.longValue(), new k.a() { // from class: com.applovin.impl.adview.activity.b.e.2
                @Override // com.applovin.impl.adview.k.a
                public void rB() {
                    if (e.this.ajC) {
                        e.this.agb.setVisibility(8);
                    } else {
                        e.this.agb.setProgress((int) ((e.this.mediaPlayer.aN() / e.this.videoDurationMillis) * num.intValue()));
                    }
                }

                @Override // com.applovin.impl.adview.k.a
                public boolean rC() {
                    return !e.this.ajC;
                }
            });
        } else {
            this.agb = null;
        }
        aw awVarCY = new aw.a(activity).cY();
        this.mediaPlayer = awVarCY;
        b bVar = new b();
        awVarCY.f(bVar);
        awVarCY.u(0);
        com.applovin.exoplayer2.ui.g gVar = new com.applovin.exoplayer2.ui.g(activity);
        this.videoView = gVar;
        gVar.nG();
        gVar.setControllerVisibilityListener(bVar);
        gVar.setPlayer(awVarCY);
        gVar.setOnTouchListener(new AppLovinTouchToClickListener(nVar, com.applovin.impl.sdk.c.b.aLh, activity, bVar));
        prepareMediaPlayer();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void sA() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void a(ViewGroup viewGroup) {
        this.ajt.a(this.muteButtonImageView, this.ajv, this.ajx, this.aju, this.agb, this.ajw, this.videoView, this.aiQ, this.agn, null, viewGroup);
        if (this.agn != null) {
            this.agn.sg();
        }
        this.mediaPlayer.k(true);
        if (this.aiL.Ha()) {
            this.ajh.a(this.aiL, new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$e$iYVtyzcmawbZ3MgcuetqkmXg9LI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.sX();
                }
            });
        }
        if (this.isVideoStream) {
            sZ();
        }
        this.aiQ.renderAd(this.aiL);
        this.agj.bT(this.isVideoStream ? 1L : 0L);
        if (this.ajv != null) {
            this.sdk.BM().a(new ab(this.sdk, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$aYt7cmgHZ9D2eHOswA5dPXWxhB4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.te();
                }
            }), q.b.MAIN, this.aiL.Gb(), true);
        }
        super.au(this.isVideoMuted);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sX() {
        bE(250L);
    }

    protected void bG(long j) {
        this.videoDurationMillis = j;
    }

    protected void prepareMediaPlayer() {
        if (!u.a(com.applovin.impl.sdk.c.b.aLW, this.sdk)) {
            checkCachedAdResourcesImmediately(!this.isVideoStream);
        }
        com.applovin.exoplayer2.h.u uVarC = new com.applovin.exoplayer2.h.u.a(new p(this.ahM, ai.a(this.ahM, AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN))).c(com.applovin.exoplayer2.ab.a(this.aiL.FG()));
        this.mediaPlayer.h(!this.isVideoMuted ? 1 : 0);
        this.mediaPlayer.a(uVarC);
        this.mediaPlayer.aD();
        this.mediaPlayer.k(false);
    }

    protected void te() {
        if (this.ajD.compareAndSet(false, true)) {
            a(this.ajv, this.aiL.Ga(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$e$W1aWKnVb8feq_WfdamJuIHcDVfw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.tn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tn() {
        this.ajE = -1L;
        this.ajF = SystemClock.elapsedRealtime();
    }

    private void a(ProgressBar progressBar, int i, int i2) {
        progressBar.setMax(i2);
        progressBar.setPadding(0, 0, 0, 0);
        if (com.applovin.impl.sdk.utils.h.KV()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            bE(0L);
            if (this.ajC) {
                this.ajB.start();
                return;
            }
            return;
        }
        if (this.ajC) {
            this.ajB.W();
        } else {
            pauseVideo();
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void dismiss() {
        this.countdownManager.rA();
        this.ajB.rA();
        this.countdownHandler.removeCallbacksAndMessages(null);
        this.ajA.removeCallbacksAndMessages(null);
        sD();
        super.dismiss();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void onDestroy() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQH)).booleanValue()) {
            com.applovin.impl.sdk.utils.x.m(this.ajx);
            this.ajx = null;
        }
        this.mediaPlayer.release();
        if (this.isVideoStream) {
            AppLovinCommunicator.getInstance(this.ahM).unsubscribe(this, "video_caching_failed");
        }
        super.onDestroy();
    }

    protected void a(MotionEvent motionEvent, Bundle bundle) {
        Context applicationContext;
        if (this.aiL.Go()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri uriFJ = this.aiL.FJ();
            if (uriFJ != null) {
                if (this.aiQ != null) {
                    applicationContext = this.aiQ.getContext();
                } else {
                    com.applovin.impl.sdk.n nVar = this.sdk;
                    applicationContext = com.applovin.impl.sdk.n.getApplicationContext();
                }
                this.sdk.BB().trackAndLaunchVideoClick(this.aiL, uriFJ, motionEvent, bundle, this, applicationContext);
                m.a(this.agC, this.aiL);
                this.agj.JL();
                this.aje++;
                return;
            }
            return;
        }
        tf();
    }

    private void tf() {
        w wVar;
        com.applovin.impl.adview.u uVarGn = this.aiL.Gn();
        if (uVarGn == null || !uVarGn.sa() || this.ajC || (wVar = this.ajx) == null) {
            return;
        }
        final boolean z = wVar.getVisibility() == 4;
        final long jSb = uVarGn.sb();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$e$n8fFbsML4uSI_ki_slDYcqYjXNQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(z, jSb);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(boolean z, long j) {
        if (z) {
            v.a(this.ajx, j, null);
        } else {
            v.b(this.ajx, j, null);
        }
    }

    protected boolean tg() {
        return (this.aja || this.ajC || !this.videoView.getPlayer().v()) ? false : true;
    }

    public void th() {
        this.ajE = SystemClock.elapsedRealtime() - this.ajF;
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.ajE + "ms");
        }
        if (sJ()) {
            pauseVideo();
            sG();
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
            }
            this.ajh.Jv();
            return;
        }
        sY();
    }

    public void sY() {
        this.ajd++;
        this.agj.JO();
        if (this.aiL.Gi()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            dismiss();
            return;
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video...");
        }
        tc();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void pauseVideo() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Pausing video");
        }
        if (this.mediaPlayer.v()) {
            this.lastVideoPositionFromPauseMillis = this.mediaPlayer.aN();
            this.mediaPlayer.k(false);
            this.countdownManager.W();
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Paused video at position " + this.lastVideoPositionFromPauseMillis + "ms");
                return;
            }
            return;
        }
        com.applovin.impl.sdk.x xVar3 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Nothing to pause");
        }
    }

    protected void ti() {
        this.savedVideoPercentViewed = getVideoPercentViewed();
        this.mediaPlayer.k(false);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void bE(long j) {
        a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$zNw0C3aQqjhhRCym_E8sjIlfIoQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tj();
            }
        }, j);
    }

    protected void tj() {
        if (this.ajC) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.h("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
                return;
            }
            return;
        }
        if (this.sdk.Cc().isApplicationPaused()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.h("AppLovinFullscreenActivity", "Skip video resume - app paused");
                return;
            }
            return;
        }
        long j = this.lastVideoPositionFromPauseMillis;
        if (j >= 0) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Resuming video at position " + j + "ms for MediaPlayer: " + this.mediaPlayer);
            }
            this.mediaPlayer.k(true);
            this.countdownManager.start();
            this.lastVideoPositionFromPauseMillis = -1L;
            if (this.mediaPlayer.v()) {
                return;
            }
            sZ();
            return;
        }
        com.applovin.impl.sdk.x xVar4 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Invalid last video position, isVideoPlaying=" + this.mediaPlayer.v());
        }
    }

    protected void sZ() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$e$3X3IPsOQlIa-mPDRfunvwF5LMSw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tm();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tm() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
    }

    protected void ta() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$e$dBSufJRfPxkJ9FqVdXBxx9e2c8E
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tl() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qO();
        }
    }

    protected void handleMediaError(String str) {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.aiL);
        }
        if (this.mediaErrorHandled.compareAndSet(false, true)) {
            if (u.a(com.applovin.impl.sdk.c.b.aLQ, this.sdk)) {
                this.sdk.Ca().c(this.aiL, com.applovin.impl.sdk.n.getApplicationContext());
            }
            if (this.agA instanceof com.applovin.impl.sdk.ad.h) {
                ((com.applovin.impl.sdk.ad.h) this.agA).onAdDisplayFailed(str);
            }
            dismiss();
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected boolean sI() {
        return this.aiL != null && getVideoPercentViewed() >= this.aiL.GC();
    }

    protected int getVideoPercentViewed() {
        aw awVar = this.mediaPlayer;
        if (awVar == null) {
            return 0;
        }
        long jAN = awVar.aN();
        if (this.videoWasCompleted) {
            return 100;
        }
        if (jAN > 0) {
            return (int) ((jAN / this.videoDurationMillis) * 100.0f);
        }
        return this.savedVideoPercentViewed;
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected boolean sJ() {
        return sK() && !sI();
    }

    public void tc() {
        ti();
        final long jGF = this.aiL.GF();
        if (jGF > 0) {
            this.aiW = 0L;
            final Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNq);
            final Integer num = (Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNt);
            ProgressBar progressBar = new ProgressBar(this.ahM, null, R.attr.progressBarStyleHorizontal);
            this.ajy = progressBar;
            a(progressBar, this.aiL.GE(), num.intValue());
            this.ajB.a("POSTITIAL_PROGRESS_BAR", l.longValue(), new k.a() { // from class: com.applovin.impl.adview.activity.b.e.3
                @Override // com.applovin.impl.adview.k.a
                public void rB() {
                    e.this.ajy.setProgress((int) ((e.this.aiW / jGF) * num.intValue()));
                    e.this.aiW += l.longValue();
                }

                @Override // com.applovin.impl.adview.k.a
                public boolean rC() {
                    return e.this.aiW < jGF;
                }
            });
            this.ajB.start();
        }
        this.ajt.a(this.aiR, this.agn, this.aiQ, this.ajy);
        d("javascript:al_onPoststitialShow(" + this.ajd + "," + this.aje + ");", this.aiL.GG());
        if (this.aiR != null) {
            if (this.aiL.Gc() >= 0) {
                a(this.aiR, this.aiL.Gc(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$e$F_cWzJOmhaLua_-uxXnomvnOZAg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.tk();
                    }
                });
            } else {
                this.aiR.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.aiR != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.aiR, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        if (this.ajy != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajy, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        this.aiL.getAdEventTracker().a(this.aiQ, arrayList);
        sM();
        this.ajC = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tk() {
        this.aiV = SystemClock.elapsedRealtime();
    }

    private static boolean a(boolean z, com.applovin.impl.sdk.n nVar) {
        if (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aMZ)).booleanValue()) {
            return false;
        }
        if (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNa)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNc)).booleanValue();
    }

    protected void av(boolean z) {
        if (com.applovin.impl.sdk.utils.h.KV()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.ahM.getDrawable(z ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.muteButtonImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.muteButtonImageView.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri uriHt = z ? this.aiL.Ht() : this.aiL.Hu();
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.muteButtonImageView.setImageURI(uriHt);
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    protected void tb() {
        boolean z = !this.isVideoMuted;
        this.isVideoMuted = z;
        this.mediaPlayer.h(!z ? 1 : 0);
        av(this.isVideoMuted);
        d(this.isVideoMuted, 0L);
    }

    @Override // com.applovin.impl.sdk.b.b.a
    public void sR() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    @Override // com.applovin.impl.sdk.b.b.a
    public void sS() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        sY();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected void sD() {
        super.a(getVideoPercentViewed(), this.isVideoStream, sI(), this.ajE);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected void sL() {
        long jGS;
        long millis;
        if (this.aiL.GR() >= 0 || this.aiL.GS() >= 0) {
            if (this.aiL.GR() >= 0) {
                jGS = this.aiL.GR();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.aiL;
                long j = this.videoDurationMillis;
                long j2 = j > 0 ? 0 + j : 0L;
                if (aVar.GT()) {
                    int iFK = (int) ((com.applovin.impl.sdk.ad.a) this.aiL).FK();
                    if (iFK > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iFK);
                    } else {
                        int iGc = (int) aVar.Gc();
                        if (iGc > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iGc);
                        }
                    }
                    j2 += millis;
                }
                jGS = (long) (j2 * (((double) this.aiL.GS()) / 100.0d));
            }
            bF(jGS);
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void sN() {
        super.sN();
        this.ajt.k(this.ajx);
        this.ajt.k(this.ajv);
        if (!sK() || this.ajC) {
            sT();
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void rl() {
        super.rl();
        sT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sT() {
        this.ajt.a(this.aiS);
        this.aiV = SystemClock.elapsedRealtime();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.aiL.getAdIdNumber() && this.isVideoStream) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i >= 200 && i < 300) || this.videoWasCompleted || this.mediaPlayer.v()) {
                    return;
                }
                handleMediaError("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
            }
        }
    }

    private class b implements an.b, com.applovin.exoplayer2.ui.f.d, AppLovinTouchToClickListener.OnClickListener {
        private b() {
        }

        @Override // com.applovin.exoplayer2.an.b
        public void Z(int i) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Player state changed to state " + i + " and will play when ready: " + e.this.mediaPlayer.aE());
            }
            if (i == 2) {
                e.this.sZ();
                e.this.agj.JP();
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    com.applovin.impl.sdk.x xVar2 = e.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        e.this.logger.f("AppLovinFullscreenActivity", "Video completed");
                    }
                    e.this.videoWasCompleted = true;
                    if (!e.this.aiY) {
                        e.this.tc();
                        return;
                    } else {
                        if (e.this.sK()) {
                            e.this.sT();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            e.this.mediaPlayer.h(!e.this.isVideoMuted ? 1 : 0);
            e.this.aiZ = (int) TimeUnit.MILLISECONDS.toSeconds(e.this.mediaPlayer.aM());
            e eVar = e.this;
            eVar.bG(eVar.mediaPlayer.aM());
            e.this.sL();
            com.applovin.impl.sdk.x xVar3 = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "MediaPlayer prepared: " + e.this.mediaPlayer);
            }
            e.this.countdownManager.start();
            if (e.this.ajv != null) {
                e.this.te();
            }
            e.this.ta();
            if (e.this.ajh.Jw()) {
                e.this.pauseVideo();
            }
        }

        @Override // com.applovin.exoplayer2.an.b
        public void a(ak akVar) {
            e.this.handleMediaError("Video view error (" + u.a(akVar, e.this.sdk) + ")");
            e.this.dismiss();
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            e.this.a(motionEvent, (Bundle) null);
        }

        @Override // com.applovin.exoplayer2.ui.f.d
        public void eZ(int i) {
            if (i == 0) {
                e.this.videoView.nG();
            }
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.ajv) {
                e.this.th();
                return;
            }
            if (view == e.this.muteButtonImageView) {
                e.this.tb();
                return;
            }
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    private class a implements x.a {
        private a() {
        }

        @Override // com.applovin.impl.adview.x.a
        public void a(w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            e.this.a(wVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.adview.x.a
        public void b(w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            e.this.dismiss();
        }

        @Override // com.applovin.impl.adview.x.a
        public void c(w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            e.this.th();
        }

        @Override // com.applovin.impl.adview.x.a
        public void a(w wVar, Bundle bundle) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            e.this.a(wVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.adview.x.a
        public void a(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            s.a(uri, e.this.aiQ.getController(), e.this.sdk);
        }

        @Override // com.applovin.impl.adview.x.a
        public void b(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = e.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                e.this.logger.f("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            s.b(uri, e.this.aiQ.getController().getCurrentAd(), e.this.sdk);
        }
    }
}
