package com.applovin.impl.sdk.e;

import android.app.Activity;
import com.applovin.impl.sdk.af;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class p extends d {
    private final com.applovin.impl.sdk.n sdk;

    public p(com.applovin.impl.sdk.n nVar) {
        super("TaskInitializeSdk", nVar, true);
        this.sdk = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.x xVar;
        String str;
        StringBuilder sbAppend;
        String str2 = AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Initializing AppLovin SDK v" + AppLovinSdk.VERSION + "...");
        }
        try {
            this.sdk.BP().JX();
            this.sdk.BP().c(com.applovin.impl.sdk.d.f.aSR);
            this.sdk.BP().c(com.applovin.impl.sdk.d.f.aSS);
            this.sdk.Ca().H(rQ());
            this.sdk.Ca().L(rQ());
            this.sdk.BM().a(new e(this.sdk), q.b.MAIN);
            if (this.sdk.BT() != null) {
                this.sdk.BT().DD();
            } else {
                this.sdk.BQ().CT();
            }
            this.sdk.Cg().Lo();
            this.sdk.Cm().tv();
            if (com.applovin.impl.sdk.utils.u.b(rQ(), this.sdk)) {
                this.sdk.Br();
            }
            this.sdk.Cp().collectAppHubData();
            KE();
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOT)).booleanValue()) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.e.-$$Lambda$p$vCoy04IH1Dl701phXn4UaE5RkIY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.zH();
                    }
                });
            }
            KD();
            this.sdk.aK(true);
            this.sdk.Cs().Io();
            this.sdk.BD().maybeTrackAppOpenEvent();
            if ((this.sdk.Cz().uC() && !this.sdk.Bo()) || (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJh)).booleanValue() && com.applovin.impl.sdk.utils.u.b(com.applovin.impl.sdk.n.getApplicationContext(), this.sdk) && this.sdk.Bp())) {
                this.sdk.Cz().uB();
            }
            if (this.sdk.BU() != null) {
                this.sdk.BU().cP((String) this.sdk.a(com.applovin.impl.sdk.c.b.aKH));
            }
            this.sdk.Cn().uB();
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKU)).booleanValue()) {
                this.sdk.bN(((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKV)).longValue());
            }
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                xVar = this.logger;
                str = this.tag;
                sbAppend = new StringBuilder().append("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
                if (!this.sdk.isEnabled()) {
                    str2 = "failed";
                }
                xVar.f(str, sbAppend.append(str2).append(" in ").append(System.currentTimeMillis() - jCurrentTimeMillis).append("ms").toString());
            }
        } catch (Throwable th) {
            try {
                com.applovin.impl.sdk.x.e("AppLovinSdk", "Failed to initialize SDK!", th);
                this.sdk.aK(false);
                q(th);
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKj)).booleanValue()) {
                    this.sdk.Bv();
                }
                if (this.sdk.BU() != null) {
                    this.sdk.BU().cP((String) this.sdk.a(com.applovin.impl.sdk.c.b.aKH));
                }
                this.sdk.Cn().uB();
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKU)).booleanValue()) {
                    this.sdk.bN(((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKV)).longValue());
                }
                com.applovin.impl.sdk.x xVar4 = this.logger;
                if (!com.applovin.impl.sdk.x.Fk()) {
                    return;
                }
                xVar = this.logger;
                str = this.tag;
                sbAppend = new StringBuilder().append("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
                if (!this.sdk.isEnabled()) {
                }
            } catch (Throwable th2) {
                if (this.sdk.BU() != null) {
                    this.sdk.BU().cP((String) this.sdk.a(com.applovin.impl.sdk.c.b.aKH));
                }
                this.sdk.Cn().uB();
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKU)).booleanValue()) {
                    this.sdk.bN(((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKV)).longValue());
                }
                com.applovin.impl.sdk.x xVar5 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    com.applovin.impl.sdk.x xVar6 = this.logger;
                    String str3 = this.tag;
                    StringBuilder sbAppend2 = new StringBuilder().append("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
                    if (!this.sdk.isEnabled()) {
                        str2 = "failed";
                    }
                    xVar6.f(str3, sbAppend2.append(str2).append(" in ").append(System.currentTimeMillis() - jCurrentTimeMillis).append("ms").toString());
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zH() {
        af.z(this.sdk);
    }

    private void KD() {
        if (this.sdk.Cv().isInitialized()) {
            return;
        }
        Activity activityCD = this.sdk.CD();
        if (activityCD != null) {
            this.sdk.Cv().b(activityCD);
        } else {
            this.sdk.BM().a(new ab(this.sdk, true, "initializeAdapters", new Runnable() { // from class: com.applovin.impl.sdk.e.-$$Lambda$p$DA20TfHfOYwMkxPLkAdXDRoTdU8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.KF();
                }
            }), q.b.MAIN, TimeUnit.SECONDS.toMillis(1L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void KF() {
        this.sdk.Cv().b(this.sdk.BK().Ax());
    }

    private void KE() {
        String str;
        Map<String, Object> mapCS;
        Map<String, Object> mapCR;
        if (this.sdk.Bo()) {
            return;
        }
        boolean zIsVerboseLoggingEnabled = this.sdk.BN().isVerboseLoggingEnabled();
        if (this.sdk.BT() != null) {
            str = zIsVerboseLoggingEnabled ? this.sdk.BS().DJ().KP() + " (use this for test devices)" : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            mapCS = this.sdk.BT().CS();
            mapCR = this.sdk.BT().CR();
        } else {
            str = zIsVerboseLoggingEnabled ? this.sdk.BQ().Df().KP() + " (use this for test devices)" : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
            mapCS = this.sdk.BQ().CS();
            mapCR = this.sdk.BQ().CR();
        }
        com.applovin.impl.sdk.utils.n nVar = new com.applovin.impl.sdk.utils.n();
        nVar.Lm().dD("=====AppLovin SDK=====");
        nVar.dD("===SDK Versions===").e("Version", AppLovinSdk.VERSION).e("Plugin Version", this.sdk.a(com.applovin.impl.sdk.c.b.aOy)).e("Ad Review Version", com.applovin.impl.sdk.f.getVersion()).e("OM SDK Version", this.sdk.Cn().getSdkVersion());
        nVar.dD("===Device Info===").e("OS", com.applovin.impl.sdk.utils.u.Lz()).e("GAID", str).e("Model", mapCS.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)).e("Locale", mapCS.get("locale")).e("Emulator", mapCS.get("sim")).e("Tablet", mapCS.get("is_tablet"));
        nVar.dD("===App Info===").e("Application ID", mapCR.get(CampaignEx.JSON_KEY_PACKAGE_NAME)).e("Target SDK", mapCR.get("target_sdk")).e("ExoPlayer Version", Integer.valueOf(com.applovin.impl.sdk.utils.u.LA()));
        nVar.dD("===SDK Settings===").e("SDK Key", this.sdk.getSdkKey()).e("Mediation Provider", this.sdk.getMediationProvider()).e("TG", com.applovin.impl.sdk.utils.t.M(this.sdk)).e("AEI", this.sdk.a(com.applovin.impl.sdk.c.b.aKy)).e("MEI", this.sdk.a(com.applovin.impl.sdk.c.b.aKz)).e("Test Mode On", Boolean.valueOf(this.sdk.CC().isEnabled())).e("Verbose Logging On", Boolean.valueOf(zIsVerboseLoggingEnabled));
        nVar.dD("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").dD(com.applovin.impl.privacy.a.A(rQ()));
        com.applovin.impl.privacy.a.c cVarCj = this.sdk.Cj();
        nVar.dD("===MAX Terms Flow===").e("Enabled", Boolean.valueOf(cVarCj.isEnabled()));
        if (cVarCj.isEnabled()) {
            nVar.e("Flow Type", cVarCj.zV() == com.applovin.impl.privacy.a.d.a.TERMS ? "MAX Terms Flow" : "MAX Terms and Privacy Policy Flow");
        }
        nVar.e("Privacy Policy URI", cVarCj.getPrivacyPolicyUri()).e("Terms of Service URI", cVarCj.getTermsOfServiceUri());
        this.sdk.Ck();
        nVar.dD("===CMP (CONSENT MANAGEMENT PLATFORM)===").dD(this.sdk.Ck().uI());
        nVar.Lm();
        com.applovin.impl.sdk.x.D("AppLovinSdk", nVar.toString());
    }
}
