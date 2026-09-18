package com.applovin.impl.sdk.a;

import android.view.View;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.security.CertificateUtil;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    protected final AppLovinAdBase aIu;
    protected boolean aIv;
    protected AdSession aIw;
    protected AdEvents aIx;
    protected final x logger;
    protected final n sdk;
    protected final String tag;

    protected abstract AdSessionConfiguration IG();

    protected void a(AdSession adSession) {
    }

    protected abstract AdSessionContext j(WebView webView);

    public b(AppLovinAdBase appLovinAdBase) {
        this.aIu = appLovinAdBase;
        this.sdk = appLovinAdBase.getSdk();
        this.logger = appLovinAdBase.getSdk().BL();
        String str = "AdEventTracker:" + appLovinAdBase.getAdIdNumber();
        this.tag = StringUtils.isValidString(appLovinAdBase.getDspName()) ? str + CertificateUtil.DELIMITER + appLovinAdBase.getDspName() : str;
    }

    public void IH() {
        k(null);
    }

    public void k(final WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$b$0R-9LPBQmKn4qpr8ploH7OdrrUI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.l(webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(WebView webView) {
        AdSessionContext adSessionContextJ;
        if (!this.aIu.isOpenMeasurementEnabled()) {
            if (x.Fk()) {
                this.logger.g(this.tag, "Skip starting session - Open Measurement disabled");
                return;
            }
            return;
        }
        if (this.aIw != null) {
            if (x.Fk()) {
                this.logger.h(this.tag, "Attempting to start session again for ad: " + this.aIu);
                return;
            }
            return;
        }
        if (x.Fk()) {
            this.logger.f(this.tag, "Starting session");
        }
        AdSessionConfiguration adSessionConfigurationIG = IG();
        if (adSessionConfigurationIG == null || (adSessionContextJ = j(webView)) == null) {
            return;
        }
        try {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationIG, adSessionContextJ);
            this.aIw = adSessionCreateAdSession;
            try {
                this.aIx = AdEvents.createAdEvents(adSessionCreateAdSession);
                a(this.aIw);
                this.aIw.start();
                this.aIv = true;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Session started");
                }
            } catch (Throwable th) {
                if (x.Fk()) {
                    this.logger.c(this.tag, "Failed to create ad events", th);
                }
            }
        } catch (Throwable th2) {
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to create session", th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void IN() {
        this.aIx.loaded();
    }

    public void II() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$b$mc_0QnfcO8azyrDXbm0DlV_lgec
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.IN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void IM() {
        this.aIx.impressionOccurred();
    }

    public void IJ() {
        b("track impression event", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$b$5JkuoygMJ4geU2W-8Q6Pfu3qcx0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.IM();
            }
        });
    }

    public void x(View view) {
        a(view, Collections.emptyList());
    }

    public void a(final View view, final List<d> list) {
        b("update main view: " + view, new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$b$z8ly5aPk5WDiFa3B3CypB85DhRU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(view, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view, List list) {
        this.aIw.registerAdView(view);
        this.aIw.removeAllFriendlyObstructions();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.IO() != null) {
                try {
                    this.aIw.addFriendlyObstruction(dVar.IO(), dVar.IP(), dVar.IQ());
                } catch (Throwable th) {
                    if (x.Fk()) {
                        this.logger.c(this.tag, "Failed to add friendly obstruction (" + dVar + ")", th);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public /* synthetic */ void m143do(String str) {
        this.aIw.error(ErrorType.VIDEO, str);
    }

    public void dn(final String str) {
        b("track error", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$b$zwD7u9BDnMtTpIR7ybokeZmcvl8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m143do(str);
            }
        });
    }

    public void IK() {
        b("stop session", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$b$2hVLMGJ3pXefH9RpHBHSP2txMEo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.IL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void IL() {
        this.aIv = false;
        this.aIw.finish();
        this.aIw = null;
        this.aIx = null;
    }

    protected void b(final String str, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$b$2RAeXQlKn7hw39FDJZZqiImUhWc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(str, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str, Runnable runnable) {
        try {
            if (this.aIv) {
                if (x.Fk()) {
                    this.logger.f(this.tag, "Running operation: " + str);
                }
                runnable.run();
            }
        } catch (Throwable th) {
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to run operation: " + str, th);
            }
        }
    }
}
