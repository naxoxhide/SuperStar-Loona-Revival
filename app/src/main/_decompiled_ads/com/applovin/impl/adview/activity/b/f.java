package com.applovin.impl.adview.activity.b;

import android.R;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
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
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.h;
import com.applovin.impl.adview.k;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.w;
import com.applovin.impl.adview.x;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.applovin.impl.adview.activity.b.a implements AppLovinCommunicatorSubscriber {
    protected final ProgressBar agb;
    private final Handler ajA;
    protected final k ajB;
    protected boolean ajC;
    private final AtomicBoolean ajD;
    private long ajE;
    private long ajF;
    private MediaPlayer ajL;
    protected final AppLovinVideoView ajM;
    private final b ajN;
    private final a ajO;
    private int ajP;
    private final com.applovin.impl.adview.activity.a.c ajt;
    protected final com.applovin.impl.adview.a aju;
    protected final n ajv;
    protected h ajw;
    protected w ajx;
    protected ProgressBar ajy;
    private final Handler countdownHandler;
    protected final k countdownManager;
    protected ImageView industryIconImageView;
    protected boolean isVideoMuted;
    private final boolean isVideoStream;
    private final AtomicBoolean mediaErrorHandled;
    protected final ImageView muteButtonImageView;
    private int savedVideoPercentViewed;
    protected long videoDurationMillis;
    private boolean videoWasCompleted;

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    public f(com.applovin.impl.sdk.ad.e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.ajt = new com.applovin.impl.adview.activity.a.c(this.aiL, this.ahM, this.sdk);
        this.industryIconImageView = null;
        b bVar = new b();
        this.ajN = bVar;
        a aVar = new a();
        this.ajO = aVar;
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
        this.ajP = -1;
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
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
        this.ajM = appLovinVideoView;
        appLovinVideoView.setOnPreparedListener(bVar);
        appLovinVideoView.setOnCompletionListener(bVar);
        appLovinVideoView.setOnErrorListener(bVar);
        appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(nVar, com.applovin.impl.sdk.c.b.aLh, activity, bVar));
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
            kVar.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1L), new k.a() { // from class: com.applovin.impl.adview.activity.b.f.1
                @Override // com.applovin.impl.adview.k.a
                public void rB() {
                    if (f.this.ajw != null) {
                        long seconds = ((long) iSC) - TimeUnit.MILLISECONDS.toSeconds(f.this.ajM.getCurrentPosition());
                        if (seconds <= 0) {
                            f.this.aja = true;
                        } else if (f.this.tg()) {
                            f.this.ajw.setProgress((int) seconds);
                        }
                    }
                }

                @Override // com.applovin.impl.adview.k.a
                public boolean rC() {
                    return f.this.tg();
                }
            });
        }
        if (eVar.GA()) {
            Long l = (Long) nVar.a(com.applovin.impl.sdk.c.b.aNh);
            final Integer num = (Integer) nVar.a(com.applovin.impl.sdk.c.b.aNi);
            ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
            this.agb = progressBar;
            a(progressBar, eVar.GB(), num.intValue());
            kVar.a("PROGRESS_BAR", l.longValue(), new k.a() { // from class: com.applovin.impl.adview.activity.b.f.2
                @Override // com.applovin.impl.adview.k.a
                public void rB() {
                    if (f.this.ajC) {
                        f.this.agb.setVisibility(8);
                    } else {
                        f.this.agb.setProgress((int) ((f.this.ajM.getCurrentPosition() / f.this.videoDurationMillis) * num.intValue()));
                    }
                }

                @Override // com.applovin.impl.adview.k.a
                public boolean rC() {
                    return !f.this.ajC;
                }
            });
            return;
        }
        this.agb = null;
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void sA() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void a(ViewGroup viewGroup) {
        String str;
        this.ajt.a(this.muteButtonImageView, this.ajv, this.ajx, this.aju, this.agb, this.ajw, this.ajM, this.aiQ, this.agn, this.industryIconImageView, viewGroup);
        if (com.applovin.impl.sdk.utils.h.KY() && (str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.AUDIO_FOCUS_REQUEST)) != null) {
            this.ajM.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (!u.a(com.applovin.impl.sdk.c.b.aLW, this.sdk)) {
            checkCachedAdResourcesImmediately(!this.isVideoStream);
        }
        this.ajM.setVideoURI(this.aiL.FG());
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        if (this.aiL.Ha()) {
            this.ajh.a(this.aiL, new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$0YUVY_aYv15wzUO8LPHoKNtBAqk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.sX();
                }
            });
        }
        if (this.agn != null) {
            this.agn.sg();
        }
        this.ajM.start();
        if (this.isVideoStream) {
            sZ();
        }
        this.aiQ.renderAd(this.aiL);
        this.agj.bT(this.isVideoStream ? 1L : 0L);
        if (this.ajv != null) {
            this.sdk.BM().a(new ab(this.sdk, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$Bfcab0kfYYKQoLJZz7bS0yXjw64
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

    /* JADX INFO: Access modifiers changed from: private */
    public void te() {
        if (this.ajD.compareAndSet(false, true)) {
            a(this.ajv, this.aiL.Ga(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$QfAXQLXUC0_n4pl0vu-S_nRxBWM
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
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQH)).booleanValue()) {
                com.applovin.impl.sdk.utils.x.m(this.ajx);
                this.ajx = null;
            }
            if (this.isVideoStream) {
                AppLovinCommunicator.getInstance(this.ahM).unsubscribe(this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.ajM;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.ajM.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.ajL;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.x.e("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.onDestroy();
    }

    protected void a(MotionEvent motionEvent, Bundle bundle) {
        if (this.aiL.Go()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri uriFJ = this.aiL.FJ();
            if (uriFJ != null) {
                this.sdk.BB().trackAndLaunchVideoClick(this.aiL, uriFJ, motionEvent, bundle, this, this.aiQ != null ? this.aiQ.getContext() : com.applovin.impl.sdk.n.getApplicationContext());
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
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$mZZzVSSMwNF2idO-RmJbtUV3DzY
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
        return (this.aja || this.ajC || !this.ajM.isPlaying()) ? false : true;
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
        this.ajP = this.ajM.getCurrentPosition();
        this.ajM.pause();
        this.countdownManager.W();
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Paused video at position " + this.ajP + "ms");
        }
    }

    private void aw(boolean z) {
        this.savedVideoPercentViewed = getVideoPercentViewed();
        if (z) {
            this.ajM.pause();
        } else {
            this.ajM.stopPlayback();
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void bE(long j) {
        a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$zIvNo4sCaAVQMZ9fGCU3Fy4AJP0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tj();
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
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
        if (this.ajP >= 0) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Resuming video at position " + this.ajP + "ms for MediaPlayer: " + this.ajL);
            }
            this.ajM.seekTo(this.ajP);
            this.ajM.start();
            this.countdownManager.start();
            this.ajP = -1;
            a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$g7kVbrju0hzAlQed2HO4q7ssFs0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.tr();
                }
            }, 250L);
            return;
        }
        com.applovin.impl.sdk.x xVar4 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Invalid last video position");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tr() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
            final com.applovin.impl.adview.a aVar2 = this.aju;
            Objects.requireNonNull(aVar2);
            a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$_wS7gqHPbBpDiYuTZrDVfrSg9JQ
                @Override // java.lang.Runnable
                public final void run() {
                    aVar2.qO();
                }
            }, 2000L);
        }
    }

    protected void sZ() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$-YsExS40VBtOt1ElCt7-ip8hrFw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tq() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
    }

    protected void ta() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$I_O9qibtbuTc6LUYVJLKRoiPuVU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tp() {
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
        return getVideoPercentViewed() >= this.aiL.GC();
    }

    protected int getVideoPercentViewed() {
        long currentPosition = this.ajM.getCurrentPosition();
        if (this.videoWasCompleted) {
            return 100;
        }
        if (currentPosition > 0) {
            return (int) ((currentPosition / this.videoDurationMillis) * 100.0f);
        }
        return this.savedVideoPercentViewed;
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected boolean sJ() {
        return sK() && !sI();
    }

    public void tc() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Showing postitial...");
        }
        aw(this.aiL.Hw());
        final long jGF = this.aiL.GF();
        if (jGF > 0) {
            this.aiW = 0L;
            final Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNq);
            final Integer num = (Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNt);
            ProgressBar progressBar = new ProgressBar(this.ahM, null, R.attr.progressBarStyleHorizontal);
            this.ajy = progressBar;
            a(progressBar, this.aiL.GE(), num.intValue());
            this.ajB.a("POSTITIAL_PROGRESS_BAR", l.longValue(), new k.a() { // from class: com.applovin.impl.adview.activity.b.f.3
                @Override // com.applovin.impl.adview.k.a
                public void rB() {
                    f.this.ajy.setProgress((int) ((f.this.aiW / jGF) * num.intValue()));
                    f.this.aiW += l.longValue();
                }

                @Override // com.applovin.impl.adview.k.a
                public boolean rC() {
                    return f.this.aiW < jGF;
                }
            });
            this.ajB.start();
        }
        this.ajt.a(this.aiR, this.agn, this.aiQ, this.ajy);
        d("javascript:al_onPoststitialShow(" + this.ajd + "," + this.aje + ");", this.aiL.GG());
        if (this.aiR != null) {
            if (this.aiL.Gc() >= 0) {
                a(this.aiR, this.aiL.Gc(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$f$LwBYIACYLpKMKoiku1x4Dc-1lm0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.to();
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
    public /* synthetic */ void to() {
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

    private void av(boolean z) {
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
        MediaPlayer mediaPlayer = this.ajL;
        if (mediaPlayer == null) {
            return;
        }
        try {
            float f = !this.isVideoMuted ? 0 : 1;
            mediaPlayer.setVolume(f, f);
            boolean z = this.isVideoMuted ? false : true;
            this.isVideoMuted = z;
            av(z);
            d(this.isVideoMuted, 0L);
        } catch (Throwable unused) {
        }
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
                if ((string == null && i >= 200 && i < 300) || this.videoWasCompleted || this.ajM.isPlaying()) {
                    return;
                }
                handleMediaError("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
            }
        }
    }

    private class b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            f.this.ajL = mediaPlayer;
            mediaPlayer.setOnInfoListener(f.this.ajN);
            mediaPlayer.setOnErrorListener(f.this.ajN);
            float f = !f.this.isVideoMuted ? 1 : 0;
            mediaPlayer.setVolume(f, f);
            f.this.aiZ = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());
            f.this.bG(mediaPlayer.getDuration());
            f.this.sL();
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "MediaPlayer prepared: " + f.this.ajL);
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            }
            if (i == 701) {
                f.this.sZ();
                f.this.agj.JP();
                return false;
            }
            if (i != 3) {
                if (i != 702) {
                    return false;
                }
                f.this.ta();
                return false;
            }
            f.this.countdownManager.start();
            if (f.this.ajv != null) {
                f.this.te();
            }
            f.this.ta();
            if (!f.this.ajh.Jw()) {
                return false;
            }
            f.this.pauseVideo();
            return false;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            f.this.handleMediaError("Video view error (" + i + "," + i2 + ")");
            f.this.ajM.start();
            return true;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Video completed");
            }
            f.this.videoWasCompleted = true;
            if (!f.this.aiY) {
                f.this.tc();
            } else if (f.this.sK()) {
                f.this.sT();
            }
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            f.this.a(motionEvent, (Bundle) null);
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.ajv) {
                f.this.th();
                return;
            }
            if (view == f.this.muteButtonImageView) {
                f.this.tb();
                return;
            }
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    private class a implements x.a {
        private a() {
        }

        @Override // com.applovin.impl.adview.x.a
        public void a(w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            f.this.a(wVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.adview.x.a
        public void b(w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            f.this.dismiss();
        }

        @Override // com.applovin.impl.adview.x.a
        public void c(w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            f.this.th();
        }

        @Override // com.applovin.impl.adview.x.a
        public void a(w wVar, Bundle bundle) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            f.this.a(wVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.adview.x.a
        public void a(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            s.a(uri, f.this.aiQ.getController(), f.this.sdk);
        }

        @Override // com.applovin.impl.adview.x.a
        public void b(Uri uri, w wVar) {
            com.applovin.impl.sdk.x xVar = f.this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                f.this.logger.f("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            s.b(uri, f.this.aiQ.getController().getCurrentAd(), f.this.sdk);
        }
    }
}
