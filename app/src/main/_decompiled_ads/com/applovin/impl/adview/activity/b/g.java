package com.applovin.impl.adview.activity.b;

import android.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.applovin.impl.adview.n;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.applovin.impl.adview.activity.b.a implements com.applovin.impl.adview.g {
    private final AtomicBoolean ajD;
    private long ajE;
    private long ajF;
    private final com.applovin.impl.adview.activity.a.d ajR;
    private double ajS;
    private double ajT;
    private final AtomicBoolean ajU;
    private final com.applovin.impl.adview.a aju;
    private final n ajv;
    private boolean isVideoMuted;
    private final boolean isVideoStream;
    private final ImageView muteButtonImageView;

    @Override // com.applovin.impl.adview.activity.b.a
    public void bE(long j) {
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void pauseVideo() {
    }

    public g(com.applovin.impl.sdk.ad.e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.ajR = new com.applovin.impl.adview.activity.a.d(this.aiL, this.ahM, this.sdk);
        boolean zFD = this.aiL.FD();
        this.isVideoStream = zFD;
        this.ajU = new AtomicBoolean();
        this.ajD = new AtomicBoolean();
        this.isVideoMuted = u.P(this.sdk);
        this.ajE = -2L;
        this.ajF = 0L;
        if (u.a(com.applovin.impl.sdk.c.b.aLW, nVar)) {
            checkCachedAdResourcesAsync(false);
        }
        a aVar = new a();
        if (eVar.Ga() >= 0) {
            n nVar2 = new n(eVar.Gh(), activity);
            this.ajv = nVar2;
            nVar2.setVisibility(8);
            nVar2.setOnClickListener(aVar);
        } else {
            this.ajv = null;
        }
        if (a(this.isVideoMuted, nVar)) {
            ImageView imageView = new ImageView(activity);
            this.muteButtonImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(aVar);
            av(this.isVideoMuted);
        } else {
            this.muteButtonImageView = null;
        }
        if (zFD) {
            com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNk)).intValue(), R.attr.progressBarStyleLarge);
            this.aju = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            return;
        }
        this.aju = null;
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void sA() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void a(ViewGroup viewGroup) {
        this.ajR.a(this.muteButtonImageView, this.ajv, this.aiR, this.aju, this.agn, this.aiQ, viewGroup);
        this.aiQ.getController().a(this);
        if (!u.a(com.applovin.impl.sdk.c.b.aLW, this.sdk)) {
            checkCachedAdResourcesImmediately(false);
        }
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
        if (this.agn != null) {
            this.agn.sg();
        }
        this.aiQ.renderAd(this.aiL);
        if (this.ajv != null) {
            this.sdk.BM().a(new ab(this.sdk, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$g$hxUjUYz6_0FdVh7xFbTjK5TB-1M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.te();
                }
            }), q.b.MAIN, this.aiL.Gb(), true);
        }
        this.sdk.BM().a(new ab(this.sdk, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$g$vQPPisuNdVOxMSyWsz_ndthdMjI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.sX();
            }
        }), q.b.MAIN, 500L);
        super.au(this.isVideoMuted);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sX() {
        ArrayList arrayList = new ArrayList();
        if (this.aiR != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.aiR, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        this.aiL.getAdEventTracker().a(this.aiQ, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te() {
        if (this.ajD.compareAndSet(false, true)) {
            a(this.ajv, this.aiL.Ga(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$g$pEunfw0t3JT9GHSbpVEfW8KXZA4
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

    public void th() {
        this.ajE = SystemClock.elapsedRealtime() - this.ajF;
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.ajE + "ms");
        }
        if (sJ()) {
            sG();
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
            }
            this.ajh.Jv();
            return;
        }
        sY();
    }

    private void sY() {
        this.ajd++;
        this.agj.JO();
        if (this.aiL.Gi()) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            dismiss();
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video...");
        }
        tc();
    }

    public void tc() {
        if (this.ajU.compareAndSet(false, true)) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Showing postitial...");
            }
            bu("javascript:al_showPostitial();");
            n nVar = this.ajv;
            if (nVar != null) {
                nVar.setVisibility(8);
            }
            ImageView imageView = this.muteButtonImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            com.applovin.impl.adview.a aVar = this.aju;
            if (aVar != null) {
                aVar.qO();
            }
            if (this.aiR != null) {
                if (this.aiL.Gc() >= 0) {
                    a(this.aiR, this.aiL.Gc(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$g$3uZtQUV08MEqP6HlXvF1ToQqWIw
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.ts();
                        }
                    });
                } else {
                    this.aiR.setVisibility(0);
                }
            }
            this.aiQ.getController().qW();
            sM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ts() {
        this.aiV = SystemClock.elapsedRealtime();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void sN() {
        super.sN();
        sT();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void rl() {
        super.rl();
        sT();
    }

    private void sT() {
        this.ajR.a(this.aiS);
        this.aiV = SystemClock.elapsedRealtime();
        this.ajS = 100.0d;
    }

    @Override // com.applovin.impl.adview.g
    public void a(double d) {
        bu("javascript:al_setVideoMuted(" + this.isVideoMuted + ");");
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qO();
        }
        if (this.ajv != null) {
            te();
        }
        this.aiQ.getController().qV();
        this.ajT = d;
        sL();
        if (this.aiL.Ha()) {
            this.ajh.a(this.aiL, null);
        }
    }

    @Override // com.applovin.impl.adview.g
    public void ru() {
        tc();
    }

    @Override // com.applovin.impl.adview.g
    public void b(double d) {
        this.ajS = d;
    }

    @Override // com.applovin.impl.adview.g
    public void rv() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qN();
        }
    }

    @Override // com.applovin.impl.adview.g
    public void rw() {
        com.applovin.impl.adview.a aVar = this.aju;
        if (aVar != null) {
            aVar.qO();
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void dismiss() {
        sD();
        super.dismiss();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected boolean sJ() {
        return sK() && !sI();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected boolean sI() {
        return this.ajS >= ((double) this.aiL.GC());
    }

    @Override // com.applovin.impl.sdk.b.b.a
    public void sR() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    @Override // com.applovin.impl.sdk.b.b.a
    public void sS() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        sY();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected void sD() {
        super.a((int) this.ajS, this.isVideoStream, sI(), this.ajE);
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
                long millis2 = this.ajT > 0.0d ? 0 + TimeUnit.SECONDS.toMillis((long) this.ajT) : 0L;
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
                    millis2 += millis;
                }
                jGS = (long) (millis2 * (((double) this.aiL.GS()) / 100.0d));
            }
            bF(jGS);
        }
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
        if (h.KV()) {
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
        this.isVideoMuted = !this.isVideoMuted;
        bu("javascript:al_setVideoMuted(" + this.isVideoMuted + ");");
        av(this.isVideoMuted);
        d(this.isVideoMuted, 0L);
    }

    private class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != g.this.ajv) {
                if (view == g.this.muteButtonImageView) {
                    g.this.tb();
                    return;
                }
                x xVar = g.this.logger;
                if (x.Fk()) {
                    g.this.logger.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                    return;
                }
                return;
            }
            g.this.th();
        }
    }
}
