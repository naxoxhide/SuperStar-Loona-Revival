package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
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
public class b extends a {
    private final com.applovin.impl.adview.activity.a.b ajm;
    private com.applovin.impl.sdk.utils.f ajn;
    private long ajo;
    private final AtomicBoolean ajp;

    @Override // com.applovin.impl.adview.activity.b.a
    public void bE(long j) {
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void pauseVideo() {
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected boolean sJ() {
        return false;
    }

    @Override // com.applovin.impl.sdk.b.b.a
    public void sR() {
    }

    @Override // com.applovin.impl.sdk.b.b.a
    public void sS() {
    }

    public b(com.applovin.impl.sdk.ad.e eVar, Activity activity, Map<String, Object> map, n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.ajm = new com.applovin.impl.adview.activity.a.b(this.aiL, this.ahM, this.sdk);
        this.ajp = new AtomicBoolean();
        if (u.a(com.applovin.impl.sdk.c.b.aLW, nVar)) {
            checkCachedAdResourcesAsync(false);
        }
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void sA() {
        a(null);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void a(ViewGroup viewGroup) {
        this.ajm.a(this.aiR, this.agn, this.aiQ, viewGroup);
        if (!u.a(com.applovin.impl.sdk.c.b.aLW, this.sdk)) {
            checkCachedAdResourcesImmediately(false);
        }
        if (this.agn != null) {
            this.agn.sg();
        }
        this.aiQ.renderAd(this.aiL);
        d("javascript:al_onPoststitialShow();", this.aiL.GG());
        if (sK()) {
            long jSU = sU();
            this.ajo = jSU;
            if (jSU > 0) {
                x xVar = this.logger;
                if (x.Fk()) {
                    this.logger.f("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.ajo + "ms...");
                }
                this.ajn = com.applovin.impl.sdk.utils.f.a(this.ajo, this.sdk, new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$b$SHtJy0u2gbjf2r8s_q3d1EenJDc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.sX();
                    }
                });
            }
        }
        if (this.aiR != null) {
            if (this.aiL.Gc() >= 0) {
                a(this.aiR, this.aiL.Gc(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$b$d_RgPgEqPwdqAi68qv8JPBsBVFQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.sW();
                    }
                });
            } else {
                this.aiR.setVisibility(0);
            }
        }
        sL();
        this.sdk.BM().a(new ab(this.sdk, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$b$XiipkkNhlHr0cmDhSn2HAEGLGp0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.sV();
            }
        }), q.b.MAIN, TimeUnit.SECONDS.toMillis(1L));
        sM();
        super.au(u.P(this.sdk));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sX() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.ajp.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sW() {
        this.aiV = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sV() {
        ArrayList arrayList = new ArrayList();
        if (this.aiR != null) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.aiR, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        if (this.agn != null && this.agn.sh()) {
            arrayList.add(new com.applovin.impl.sdk.a.d(this.agn, FriendlyObstructionPurpose.NOT_VISIBLE, this.agn.getIdentifier()));
        }
        this.aiL.getAdEventTracker().a(this.aiQ, arrayList);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    public void dismiss() {
        sD();
        com.applovin.impl.sdk.utils.f fVar = this.ajn;
        if (fVar != null) {
            fVar.tT();
            this.ajn = null;
        }
        super.dismiss();
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected boolean sI() {
        if (sK()) {
            return this.ajp.get();
        }
        return true;
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected void sD() {
        com.applovin.impl.sdk.utils.f fVar;
        boolean zSI = sI();
        int iMin = 100;
        if (sK()) {
            if (!zSI && (fVar = this.ajn) != null) {
                iMin = (int) Math.min(100.0d, ((this.ajo - fVar.AF()) / this.ajo) * 100.0d);
            }
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Ad engaged at " + iMin + "%");
            }
        }
        super.a(iMin, false, zSI, -2L);
    }

    @Override // com.applovin.impl.adview.activity.b.a
    protected void sL() {
        long jGS;
        long millis;
        long j = 0;
        if (this.aiL.GR() >= 0 || this.aiL.GS() >= 0) {
            if (this.aiL.GR() >= 0) {
                jGS = this.aiL.GR();
            } else {
                if (this.aiL.GT()) {
                    int iFK = (int) ((com.applovin.impl.sdk.ad.a) this.aiL).FK();
                    if (iFK > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iFK);
                    } else {
                        int iGc = (int) this.aiL.Gc();
                        if (iGc > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iGc);
                        }
                    }
                    j = 0 + millis;
                }
                jGS = (long) (j * (((double) this.aiL.GS()) / 100.0d));
            }
            bF(jGS);
        }
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
        this.ajm.a(this.aiS);
        this.aiV = SystemClock.elapsedRealtime();
        this.ajp.set(true);
    }

    private long sU() {
        if (!(this.aiL instanceof com.applovin.impl.sdk.ad.a)) {
            return 0L;
        }
        float fFK = ((com.applovin.impl.sdk.ad.a) this.aiL).FK();
        if (fFK <= 0.0f) {
            fFK = this.aiL.Gc();
        }
        return (long) (u.C(fFK) * (((double) this.aiL.GD()) / 100.0d));
    }
}
