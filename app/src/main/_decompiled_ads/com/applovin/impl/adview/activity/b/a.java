package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.n;
import com.applovin.impl.adview.o;
import com.applovin.impl.adview.p;
import com.applovin.impl.adview.q;
import com.applovin.impl.adview.v;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.i;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements AppLovinBroadcastManager.Receiver, com.applovin.impl.sdk.b.b.a, u.a {
    protected AppLovinAdDisplayListener agA;
    protected AppLovinAdClickListener agC;
    protected AppLovinAdVideoPlaybackListener agR;
    protected final com.applovin.impl.sdk.d.d agj;
    protected v agn;
    protected Activity ahM;
    protected final com.applovin.impl.sdk.ad.e aiL;
    private final com.applovin.impl.sdk.utils.a aiO;
    private final i.a aiP;
    protected AppLovinAdView aiQ;
    protected final n aiR;
    protected final n aiS;
    private long aiU;
    protected long aiW;
    private boolean aiX;
    protected boolean aiY;
    protected int aiZ;
    protected boolean aja;
    protected boolean ajg;
    protected final com.applovin.impl.sdk.b.b ajh;
    protected r aji;
    private final j ajj;
    protected final x logger;
    protected final com.applovin.impl.sdk.n sdk;
    private final Handler acG = new Handler(Looper.getMainLooper());
    protected final long startTimeMillis = SystemClock.elapsedRealtime();
    private final AtomicBoolean videoEndListenerNotified = new AtomicBoolean();
    private final AtomicBoolean aiT = new AtomicBoolean();
    protected long aiV = -1;
    private int ajb = 0;
    private final ArrayList<Long> ajc = new ArrayList<>();
    protected int ajd = 0;
    protected int aje = 0;
    protected int ajf = i.azY;
    private boolean ajk = false;

    /* JADX INFO: renamed from: com.applovin.impl.adview.activity.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0112a {
        void a(a aVar);

        void a(String str, Throwable th);
    }

    public abstract void a(ViewGroup viewGroup);

    public abstract void bE(long j);

    public abstract void pauseVideo();

    public abstract void sA();

    protected abstract void sD();

    protected abstract boolean sI();

    protected abstract boolean sJ();

    protected abstract void sL();

    static /* synthetic */ int c(a aVar) {
        int i = aVar.ajb;
        aVar.ajb = i + 1;
        return i;
    }

    public static void a(com.applovin.impl.sdk.ad.e eVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, Map<String, Object> map, com.applovin.impl.sdk.n nVar, Activity activity, InterfaceC0112a interfaceC0112a) {
        a bVar;
        boolean zHv = eVar.Hv();
        if (eVar instanceof com.applovin.impl.b.a) {
            if (zHv) {
                try {
                    bVar = new c(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th) {
                    nVar.BL();
                    if (x.Fk()) {
                        nVar.BL().b("AppLovinFullscreenActivity", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th);
                    }
                    try {
                        bVar = new d(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                    } catch (Throwable th2) {
                        interfaceC0112a.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + nVar + " and throwable: " + th2.getMessage(), th2);
                        return;
                    }
                }
            } else {
                try {
                    bVar = new d(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th3) {
                    interfaceC0112a.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + nVar + " and throwable: " + th3.getMessage(), th3);
                    return;
                }
            }
        } else if (eVar.hasVideoUrl()) {
            if (eVar.Hx()) {
                try {
                    bVar = new g(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th4) {
                    interfaceC0112a.a("Failed to create FullscreenWebVideoAdPresenter with sdk: " + nVar + " and throwable: " + th4.getMessage(), th4);
                    return;
                }
            } else if (zHv) {
                try {
                    bVar = new e(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th5) {
                    nVar.BL();
                    if (x.Fk()) {
                        nVar.BL().b("AppLovinFullscreenActivity", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th5);
                    }
                    try {
                        bVar = new f(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                    } catch (Throwable th6) {
                        interfaceC0112a.a("Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: " + nVar + " and throwable: " + th6.getMessage(), th6);
                        return;
                    }
                }
            } else {
                try {
                    bVar = new f(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th7) {
                    interfaceC0112a.a("Failed to create FullscreenVideoAdPresenter with sdk: " + nVar + " and throwable: " + th7.getMessage(), th7);
                    return;
                }
            }
        } else {
            try {
                bVar = new com.applovin.impl.adview.activity.b.b(eVar, activity, map, nVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th8) {
                interfaceC0112a.a("Failed to create FullscreenGraphicAdPresenter with sdk: " + nVar + " and throwable: " + th8.getMessage(), th8);
                return;
            }
        }
        bVar.sz();
        interfaceC0112a.a(bVar);
    }

    a(com.applovin.impl.sdk.ad.e eVar, Activity activity, Map<String, Object> map, com.applovin.impl.sdk.n nVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.aiL = eVar;
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.ahM = activity;
        this.agC = appLovinAdClickListener;
        this.agA = appLovinAdDisplayListener;
        this.agR = appLovinAdVideoPlaybackListener;
        com.applovin.impl.sdk.b.b bVar = new com.applovin.impl.sdk.b.b(activity, nVar);
        this.ajh = bVar;
        bVar.a(this);
        com.applovin.impl.sdk.d.d dVar = new com.applovin.impl.sdk.d.d(eVar, nVar);
        this.agj = dVar;
        this.ajj = new j(nVar);
        b bVar2 = new b();
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNo)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
        }
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNv)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.al_onPoststitialShow_undefined"));
        }
        o oVar = new o(nVar.getWrappingSdk(), AppLovinAdSize.INTERSTITIAL, activity);
        this.aiQ = oVar;
        oVar.setAdClickListener(bVar2);
        this.aiQ.setAdDisplayListener(new AppLovinAdDisplayListener() { // from class: com.applovin.impl.adview.activity.b.a.1
            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adDisplayed(AppLovinAd appLovinAd) {
                x xVar = a.this.logger;
                if (x.Fk()) {
                    a.this.logger.f("AppLovinFullscreenActivity", "Web content rendered");
                }
            }

            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adHidden(AppLovinAd appLovinAd) {
                x xVar = a.this.logger;
                if (x.Fk()) {
                    a.this.logger.f("AppLovinFullscreenActivity", "Closing from WebView");
                }
                a.this.dismiss();
            }
        });
        this.aiQ.getController().setStatsManagerHelper(dVar);
        p pVar = new p(map, nVar);
        if (pVar.rN()) {
            this.agn = new v(pVar, activity);
        }
        nVar.BB().trackImpression(eVar);
        List<Integer> listGd = eVar.Gd();
        if (eVar.Gc() >= 0 || listGd != null) {
            n nVar2 = new n(eVar.Ge(), activity);
            this.aiR = nVar2;
            nVar2.setVisibility(8);
            nVar2.setOnClickListener(bVar2);
        } else {
            this.aiR = null;
        }
        n nVar3 = new n(com.applovin.impl.adview.j.a.WHITE_ON_TRANSPARENT, activity);
        this.aiS = nVar3;
        nVar3.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$S_b9rwgLzajc-FX8jJezp-8D75w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m(view);
            }
        });
        if (eVar.GZ()) {
            this.aiP = new i.a() { // from class: com.applovin.impl.adview.activity.b.a.2
                @Override // com.applovin.impl.sdk.i.a
                public void ge(int i) {
                    if (a.this.ajf != i.azY) {
                        a.this.ajg = true;
                    }
                    com.applovin.impl.adview.d dVarQZ = a.this.aiQ.getController().qZ();
                    if (i.gv(i) && !i.gv(a.this.ajf)) {
                        dVarQZ.bq("javascript:al_muteSwitchOn();");
                    } else if (i == 2) {
                        dVarQZ.bq("javascript:al_muteSwitchOff();");
                    }
                    a.this.ajf = i;
                }
            };
        } else {
            this.aiP = null;
        }
        this.aiO = new AnonymousClass3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: com.applovin.impl.adview.activity.b.a$3, reason: invalid class name */
    class AnonymousClass3 extends com.applovin.impl.sdk.utils.a {
        AnonymousClass3() {
        }

        @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (a.this.aiT.get()) {
                return;
            }
            if (activity.getClass().getName().equals(u.ad(activity.getApplicationContext()))) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$3$8XVCh1rbSUMemYxKyuShr6Bmw7g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.sP();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void sP() {
            x.H("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
            try {
                a.this.dismiss();
            } catch (Throwable th) {
                x.e("AppLovinFullscreenActivity", "Failed to dismiss ad.", th);
                try {
                    a.this.sE();
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void sz() {
        if (this.aiP != null) {
            this.sdk.Ch().a(this.aiP);
        }
        if (this.aiO != null) {
            this.sdk.BK().a(this.aiO);
        }
    }

    protected void checkCachedAdResourcesImmediately(boolean z) {
        List<Uri> listA = u.a(z, this.aiL, this.sdk, this.ahM);
        if (listA.isEmpty()) {
            return;
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQm)).booleanValue()) {
            if (x.Fk()) {
                this.logger.i("AppLovinFullscreenActivity", "Dismissing ad due to missing resources: " + listA);
            }
            q.a(this.aiL, this.agA, "Missing ad resources", null, null);
            dismiss();
            return;
        }
        if (x.Fk()) {
            this.logger.i("AppLovinFullscreenActivity", "Streaming ad due to missing ad resources: " + listA);
        }
        this.aiL.Fy();
    }

    protected void checkCachedAdResourcesAsync(boolean z) {
        u.a(z, this.aiL, this.sdk, com.applovin.impl.sdk.n.getApplicationContext(), this);
    }

    @Override // com.applovin.impl.sdk.utils.u.a
    public void onCachedResourcesChecked(boolean z) {
        if (z) {
            return;
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQm)).booleanValue()) {
            if (x.Fk()) {
                this.logger.i("AppLovinFullscreenActivity", "Dismissing ad due to unavailable resources");
            }
            q.a(this.aiL, this.agA, "Unavailable ad resources", null, null);
            dismiss();
            return;
        }
        if (x.Fk()) {
            this.logger.i("AppLovinFullscreenActivity", "Streaming ad due to unavailable ad resources");
        }
        this.aiL.Fy();
    }

    protected void au(boolean z) {
        d(z, ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aNm)).longValue());
        m.a(this.agA, this.aiL);
        this.sdk.Cd().ab(this.aiL);
        if (this.aiL.hasVideoUrl() || sK()) {
            m.a(this.agR, this.aiL);
        }
        new com.applovin.impl.adview.activity.b(this.ahM).c(this.aiL);
        this.agj.JK();
        this.aiL.setHasShown(true);
    }

    public void onResume() {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "onResume()");
        }
        this.agj.bV(SystemClock.elapsedRealtime() - this.aiU);
        bt("javascript:al_onAppResumed();");
        sH();
        if (this.ajh.Jw()) {
            this.ajh.Ju();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z);
        }
        bt("javascript:al_onWindowFocusChanged( " + z + " );");
    }

    public void onPause() {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "onPause()");
        }
        this.aiU = SystemClock.elapsedRealtime();
        bt("javascript:al_onAppPaused();");
        if (this.ajh.Jw()) {
            this.ajh.Ju();
        }
        sG();
    }

    public void dismiss() {
        this.aiX = true;
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "dismiss()");
        }
        com.applovin.impl.sdk.ad.e eVar = this.aiL;
        if (eVar != null) {
            eVar.getAdEventTracker().IK();
        }
        this.acG.removeCallbacksAndMessages(null);
        d("javascript:al_onPoststitialDismiss();", this.aiL.GH());
        sE();
        this.agj.rb();
        this.ajj.AW();
        if (this.aiP != null) {
            this.sdk.Ch().b(this.aiP);
        }
        if (this.aiO != null) {
            this.sdk.BK().b(this.aiO);
        }
        if (sF()) {
            this.ahM.finish();
            return;
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        onDestroy();
    }

    public boolean sB() {
        return this.aiX;
    }

    public void onStop() {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public void onDestroy() {
        AppLovinAdView appLovinAdView = this.aiQ;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.aiQ.destroy();
            this.aiQ = null;
            if ((parent instanceof ViewGroup) && sF()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        sD();
        sE();
        this.agC = null;
        this.agA = null;
        this.agR = null;
        this.ahM = null;
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    public void a(int i, KeyEvent keyEvent) {
        if (this.logger == null || !x.Fk()) {
            return;
        }
        this.logger.g("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i + ", " + keyEvent);
    }

    public void onBackPressed() {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.ajk) {
            dismiss();
        }
        if (this.aiL.GJ()) {
            bu("javascript:onBackPressed();");
        }
    }

    protected void bt(String str) {
        if (this.aiL.GK()) {
            d(str, 0L);
        }
    }

    protected void bu(String str) {
        d(str, 0L);
    }

    protected void d(final String str, long j) {
        if (j >= 0) {
            a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$0tEU0bU_D5slsfKxN6jGtlEjxvo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.bv(str);
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bv(String str) {
        AppLovinAdView appLovinAdView;
        com.applovin.impl.adview.d dVarQZ;
        if (!StringUtils.isValidString(str) || (appLovinAdView = this.aiQ) == null || (dVarQZ = appLovinAdView.getController().qZ()) == null) {
            return;
        }
        dVarQZ.bq(str);
    }

    protected void a(final n nVar, long j, final Runnable runnable) {
        if (j >= ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aMW)).longValue()) {
            return;
        }
        this.sdk.BM().a(new ab(this.sdk, "fadeInCloseButton", new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$TIoRNeuM24dVAW50oez7op7i538
            @Override // java.lang.Runnable
            public final void run() {
                a.a(nVar, runnable);
            }
        }), com.applovin.impl.sdk.e.q.b.MAIN, TimeUnit.SECONDS.toMillis(j), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(final n nVar, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$hlzV9uPFs7d8rvpPlgSoEyZdxRs
            @Override // java.lang.Runnable
            public final void run() {
                a.b(nVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final n nVar, final Runnable runnable) {
        com.applovin.impl.sdk.utils.v.a(nVar, 400L, new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$-8eKr1ql-6Ognx2_DgjaO8skH74
            @Override // java.lang.Runnable
            public final void run() {
                a.c(nVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(n nVar, Runnable runnable) {
        nVar.bringToFront();
        runnable.run();
    }

    protected int sC() {
        int iGr = this.aiL.Gr();
        return (iGr <= 0 && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNl)).booleanValue()) ? this.aiZ + 1 : iGr;
    }

    protected void a(int i, boolean z, boolean z2, long j) {
        if (this.videoEndListenerNotified.compareAndSet(false, true)) {
            if (this.aiL.hasVideoUrl() || sK()) {
                m.a(this.agR, this.aiL, i, z2);
            }
            if (this.aiL.hasVideoUrl()) {
                this.agj.bU(i);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
            this.sdk.BB().trackVideoEnd(this.aiL, TimeUnit.MILLISECONDS.toSeconds(jElapsedRealtime), i, z);
            long jElapsedRealtime2 = this.aiV != -1 ? SystemClock.elapsedRealtime() - this.aiV : -1L;
            this.sdk.BB().trackFullScreenAdClosed(this.aiL, jElapsedRealtime2, this.ajc, j, this.ajg, this.ajf);
            if (x.Fk()) {
                this.logger.f("AppLovinFullscreenActivity", "Video ad ended at percent: " + i + "%, elapsedTime: " + jElapsedRealtime + "ms, skipTimeMillis: " + j + "ms, closeTimeMillis: " + jElapsedRealtime2 + "ms");
            }
        }
    }

    protected void sE() {
        if (this.aiT.compareAndSet(false, true)) {
            m.b(this.agA, this.aiL);
            this.sdk.Cd().ac(this.aiL);
        }
    }

    protected boolean sF() {
        return this.ahM instanceof AppLovinFullscreenActivity;
    }

    protected void sG() {
        r rVar = this.aji;
        if (rVar != null) {
            rVar.pause();
        }
    }

    protected void sH() {
        r rVar = this.aji;
        if (rVar != null) {
            rVar.resume();
        }
    }

    protected boolean sK() {
        return AppLovinAdType.INCENTIVIZED == this.aiL.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.aiL.getType();
    }

    protected void bF(long j) {
        if (x.Fk()) {
            this.logger.f("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j) + " seconds...");
        }
        this.aji = r.b(j, this.sdk, new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$kUkv8h_7n4pzVcMIo9iMoNuRnxY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.sO();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sO() {
        if (this.aiL.GU().getAndSet(true)) {
            return;
        }
        this.sdk.BM().a(new com.applovin.impl.sdk.e.x(this.aiL, this.sdk), com.applovin.impl.sdk.e.q.b.REWARD);
    }

    protected void d(boolean z, long j) {
        if (this.aiL.GI()) {
            d(z ? "javascript:al_mute();" : "javascript:al_unmute();", j);
        }
    }

    protected void sM() {
        com.applovin.impl.adview.d dVarQZ;
        if (this.aiQ == null || !this.aiL.Gq() || (dVarQZ = this.aiQ.getController().qZ()) == null) {
            return;
        }
        this.ajj.a(dVarQZ, new j.a() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$e0ov97CsfODWeqdf_-Q3jwK4QK8
            @Override // com.applovin.impl.sdk.j.a
            public final void onBlackViewDetected(View view) {
                this.f$0.l(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        n nVar;
        if (u.a(com.applovin.impl.sdk.c.b.aLR, this.sdk)) {
            this.sdk.Ca().b(this.aiL, com.applovin.impl.sdk.n.getApplicationContext());
        }
        this.sdk.Cq().a(com.applovin.impl.sdk.r.a.BLACK_VIEW, CollectionUtils.map("clcode", this.aiL.getClCode()));
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQA)).booleanValue()) {
            dismiss();
            return;
        }
        this.ajk = ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQB)).booleanValue();
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQC)).booleanValue() || (nVar = this.aiR) == null) {
            return;
        }
        nVar.setVisibility(0);
    }

    public void sN() {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "Handling render process crash");
        }
        this.aiY = true;
    }

    public void rl() {
        if (x.Fk()) {
            this.logger.g("AppLovinFullscreenActivity", "Handling al_onPoststitialShow undefined");
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction()) && !this.aiY) {
            sN();
        } else if ("com.applovin.al_onPoststitialShow_undefined".equals(intent.getAction())) {
            rl();
        }
    }

    protected void a(Runnable runnable, long j) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j, this.acG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements View.OnClickListener, AppLovinAdClickListener {
        private b() {
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            x xVar = a.this.logger;
            if (x.Fk()) {
                a.this.logger.f("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            m.a(a.this.agC, appLovinAd);
            a.this.agj.JL();
            a.this.aje++;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aiR && ((Boolean) a.this.sdk.a(com.applovin.impl.sdk.c.b.aMX)).booleanValue()) {
                a.c(a.this);
                if (a.this.aiL.GJ()) {
                    a.this.bu("javascript:al_onCloseButtonTapped(" + a.this.ajb + "," + a.this.ajd + "," + a.this.aje + ");");
                }
                List<Integer> listGd = a.this.aiL.Gd();
                x xVar = a.this.logger;
                if (x.Fk()) {
                    a.this.logger.f("AppLovinFullscreenActivity", "Handling close button tap " + a.this.ajb + " with multi close delay: " + listGd);
                }
                if (listGd != null && listGd.size() > a.this.ajb) {
                    a.this.ajc.add(Long.valueOf(SystemClock.elapsedRealtime() - a.this.aiV));
                    List<com.applovin.impl.adview.j.a> listGf = a.this.aiL.Gf();
                    if (listGf != null && listGf.size() > a.this.ajb) {
                        a.this.aiR.b(listGf.get(a.this.ajb));
                    }
                    x xVar2 = a.this.logger;
                    if (x.Fk()) {
                        a.this.logger.f("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + listGd.get(a.this.ajb));
                    }
                    a.this.aiR.setVisibility(8);
                    a aVar = a.this;
                    aVar.a(aVar.aiR, listGd.get(a.this.ajb).intValue(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.-$$Lambda$a$b$sYz6yeD9B40mlsLLIAsATomlykw
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.sQ();
                        }
                    });
                    return;
                }
                a.this.dismiss();
                return;
            }
            x xVar3 = a.this.logger;
            if (x.Fk()) {
                a.this.logger.i("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void sQ() {
            a.this.aiV = SystemClock.elapsedRealtime();
        }
    }
}
