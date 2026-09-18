package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.applovin.impl.b.k;
import com.applovin.impl.b.l;
import com.applovin.impl.b.m;
import com.applovin.impl.b.o;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {
    private final com.applovin.impl.b.a ajq;
    private final Set<k> videoProgressTrackers;

    public c(com.applovin.impl.sdk.ad.e eVar, Activity activity, Map<String, Object> map, n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.videoProgressTrackers = hashSet;
        com.applovin.impl.b.a aVar = (com.applovin.impl.b.a) eVar;
        this.ajq = aVar;
        hashSet.addAll(aVar.a(com.applovin.impl.b.a.c.VIDEO, l.aXQ));
        maybeFireTrackers(com.applovin.impl.b.a.c.IMPRESSION);
        maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, "creativeView");
        aVar.getAdEventTracker().IJ();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void onPause() {
        super.onPause();
        maybeFireTrackers(this.ajC ? com.applovin.impl.b.a.c.COMPANION : com.applovin.impl.b.a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        this.ajq.getAdEventTracker().IZ();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void onResume() {
        super.onResume();
        maybeFireTrackers(this.ajC ? com.applovin.impl.b.a.c.COMPANION : com.applovin.impl.b.a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        this.ajq.getAdEventTracker().Ja();
    }

    @Override // com.applovin.impl.adview.activity.b.e, com.applovin.impl.adview.activity.b.a
    public void dismiss() {
        if (this.ajq != null) {
            maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, "close");
            maybeFireTrackers(com.applovin.impl.b.a.c.COMPANION, "close");
        }
        super.dismiss();
    }

    @Override // com.applovin.impl.adview.activity.b.e, com.applovin.impl.adview.activity.b.a
    public void sA() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.adview.activity.b.e, com.applovin.impl.adview.activity.b.a
    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.countdownManager.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1L), new com.applovin.impl.adview.k.a() { // from class: com.applovin.impl.adview.activity.b.c.1
            @Override // com.applovin.impl.adview.k.a
            public void rB() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(c.this.videoDurationMillis - (c.this.mediaPlayer.aM() - c.this.mediaPlayer.aN()));
                int videoPercentViewed = c.this.getVideoPercentViewed();
                HashSet hashSet = new HashSet();
                for (k kVar : new HashSet(c.this.videoProgressTrackers)) {
                    if (kVar.h(seconds, videoPercentViewed)) {
                        hashSet.add(kVar);
                        c.this.videoProgressTrackers.remove(kVar);
                    }
                }
                c.this.maybeFireTrackers(hashSet);
                if (videoPercentViewed >= 25 && videoPercentViewed < 50) {
                    c.this.ajq.getAdEventTracker().IV();
                    return;
                }
                if (videoPercentViewed >= 50 && videoPercentViewed < 75) {
                    c.this.ajq.getAdEventTracker().IW();
                } else if (videoPercentViewed >= 75) {
                    c.this.ajq.getAdEventTracker().IX();
                }
            }

            @Override // com.applovin.impl.adview.k.a
            public boolean rC() {
                return !c.this.ajC;
            }
        });
        ArrayList arrayList = new ArrayList();
        if (this.aju != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.aju, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        if (this.ajv != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajv, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        if (this.ajw != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajw, FriendlyObstructionPurpose.OTHER, "countdown clock"));
        }
        if (this.agb != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agb, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        if (this.ajy != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajy, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        if (this.muteButtonImageView != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.muteButtonImageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        if (this.ajx != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.ajx, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        this.ajq.getAdEventTracker().a(this.videoView, arrayList);
    }

    @Override // com.applovin.impl.adview.activity.b.e
    protected void bG(long j) {
        super.bG(j);
        this.ajq.getAdEventTracker().b(TimeUnit.MILLISECONDS.toSeconds(j), u.P(this.sdk));
    }

    @Override // com.applovin.impl.adview.activity.b.e
    public void a(MotionEvent motionEvent, Bundle bundle) {
        maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO_CLICK);
        this.ajq.getAdEventTracker().Je();
        super.a(motionEvent, bundle);
    }

    @Override // com.applovin.impl.adview.activity.b.e, com.applovin.impl.adview.activity.b.a
    public void pauseVideo() {
        this.countdownManager.W();
        super.pauseVideo();
    }

    @Override // com.applovin.impl.adview.activity.b.e
    public void sY() {
        maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, "skip");
        this.ajq.getAdEventTracker().Jd();
        super.sY();
    }

    @Override // com.applovin.impl.adview.activity.b.e
    protected void sZ() {
        super.sZ();
        com.applovin.impl.b.a aVar = this.ajq;
        if (aVar != null) {
            aVar.getAdEventTracker().Jb();
        }
    }

    @Override // com.applovin.impl.adview.activity.b.e
    protected void ta() {
        super.ta();
        com.applovin.impl.b.a aVar = this.ajq;
        if (aVar != null) {
            aVar.getAdEventTracker().Jc();
        }
    }

    @Override // com.applovin.impl.adview.activity.b.e
    public void handleMediaError(String str) {
        maybeFireTrackers(com.applovin.impl.b.a.c.ERROR, com.applovin.impl.b.f.MEDIA_FILE_ERROR);
        this.ajq.getAdEventTracker().dn(str);
        super.handleMediaError(str);
    }

    @Override // com.applovin.impl.adview.activity.b.e
    public void tb() {
        super.tb();
        maybeFireTrackers(com.applovin.impl.b.a.c.VIDEO, this.isVideoMuted ? CampaignEx.JSON_NATIVE_VIDEO_MUTE : CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        this.ajq.getAdEventTracker().bc(this.isVideoMuted);
    }

    @Override // com.applovin.impl.adview.activity.b.e
    public void tc() {
        maybeFireRemainingCompletionTrackers();
        if (m.c(this.ajq)) {
            if (this.ajC) {
                return;
            }
            maybeFireTrackers(com.applovin.impl.b.a.c.COMPANION, "creativeView");
            this.ajq.getAdEventTracker().IY();
            super.tc();
            return;
        }
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
        }
        dismiss();
    }

    private void maybeFireRemainingCompletionTrackers() {
        if (!sI() || this.videoProgressTrackers.isEmpty()) {
            return;
        }
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.h("AppLovinFullscreenActivity", "Firing " + this.videoProgressTrackers.size() + " un-fired video progress trackers when video was completed.");
        }
        maybeFireTrackers(this.videoProgressTrackers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFireTrackers(Set<k> set) {
        maybeFireTrackers(set, com.applovin.impl.b.f.UNSPECIFIED);
    }

    private void maybeFireTrackers(com.applovin.impl.b.a.c cVar) {
        maybeFireTrackers(cVar, com.applovin.impl.b.f.UNSPECIFIED);
    }

    private void maybeFireTrackers(com.applovin.impl.b.a.c cVar, String str) {
        maybeFireTrackers(cVar, str, com.applovin.impl.b.f.UNSPECIFIED);
    }

    private void maybeFireTrackers(com.applovin.impl.b.a.c cVar, com.applovin.impl.b.f fVar) {
        maybeFireTrackers(cVar, "", fVar);
    }

    private void maybeFireTrackers(com.applovin.impl.b.a.c cVar, String str, com.applovin.impl.b.f fVar) {
        maybeFireTrackers(this.ajq.a(cVar, str), fVar);
    }

    private void maybeFireTrackers(Set<k> set, com.applovin.impl.b.f fVar) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.mediaPlayer.aN());
        o oVarLT = this.ajq.LT();
        Uri uriMG = oVarLT != null ? oVarLT.MG() : null;
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Firing " + set.size() + " tracker(s): " + set);
        }
        m.a(set, seconds, uriMG, fVar, this.sdk);
    }

    @Override // com.applovin.impl.adview.activity.b.e, com.applovin.impl.adview.activity.b.a
    protected void sL() {
        long jGS;
        int iGc;
        long millis = 0;
        if (this.ajq.GR() >= 0 || this.ajq.GS() >= 0) {
            if (this.ajq.GR() >= 0) {
                jGS = this.ajq.GR();
            } else {
                com.applovin.impl.b.a aVar = this.ajq;
                com.applovin.impl.b.n nVarLS = aVar.LS();
                if (nVarLS != null && nVarLS.MF() > 0) {
                    millis = 0 + TimeUnit.SECONDS.toMillis(nVarLS.MF());
                } else if (this.videoDurationMillis > 0) {
                    millis = 0 + this.videoDurationMillis;
                }
                if (aVar.GT() && (iGc = (int) aVar.Gc()) > 0) {
                    millis += TimeUnit.SECONDS.toMillis(iGc);
                }
                jGS = (long) (millis * (((double) this.ajq.GS()) / 100.0d));
            }
            bF(jGS);
        }
    }
}
