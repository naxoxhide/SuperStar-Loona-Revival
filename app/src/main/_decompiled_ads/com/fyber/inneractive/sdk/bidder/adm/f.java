package com.fyber.inneractive.sdk.bidder.adm;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.network.n;
import com.fyber.inneractive.sdk.network.n0;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.network.s0;
import com.fyber.inneractive.sdk.response.j;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.m;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class f implements j {
    public AdmParametersOuterClass$AdmParameters a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f846b;
    public String c;
    public final String d;

    public interface a {
    }

    public f(String str, String str2) {
        this.f846b = str;
        this.d = str2;
    }

    public static boolean a(f fVar, Exception exc) {
        fVar.getClass();
        return (exc instanceof s0) && ((s0) exc).a == 404;
    }

    public int b() {
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.a;
        return admParametersOuterClass$AdmParameters != null ? admParametersOuterClass$AdmParameters.getAdType().a() : AdmParametersOuterClass$AdmParameters.a.OTHER.a();
    }

    public static void a(f fVar, a aVar, s sVar) {
        int iA;
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = fVar.a;
        com.fyber.inneractive.sdk.response.e eVar = null;
        String markupUrl = (admParametersOuterClass$AdmParameters == null || !admParametersOuterClass$AdmParameters.hasMarkupUrl()) ? null : fVar.a.getMarkupUrl();
        if (!TextUtils.isEmpty(markupUrl)) {
            try {
                AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = fVar.a;
                if (admParametersOuterClass$AdmParameters2 != null) {
                    iA = admParametersOuterClass$AdmParameters2.getAdType().a();
                } else {
                    iA = AdmParametersOuterClass$AdmParameters.a.OTHER.a();
                }
                com.fyber.inneractive.sdk.response.a aVarA = com.fyber.inneractive.sdk.response.a.a(iA);
                if (aVarA == null) {
                    aVarA = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
                }
                com.fyber.inneractive.sdk.response.b bVarA = com.fyber.inneractive.sdk.factories.b.a.a.a(aVarA);
                if (bVarA != null) {
                    bVarA.a((n) null);
                    fVar.a(bVarA);
                    eVar = bVarA.a;
                } else {
                    IAlog.a("failed parse adm network request with no input stream - received ad type %s does not have an appropriate parser", Integer.valueOf(iA));
                }
            } catch (Exception e) {
                IAlog.a("failed parse adm network request with no input stream", e, new Object[0]);
            }
            com.fyber.inneractive.sdk.response.e eVar2 = eVar;
            n0 n0Var = new n0(new c(fVar, aVar, eVar2), markupUrl, fVar, sVar, eVar2);
            n0Var.d = new d(fVar);
            IAConfigManager.M.s.a.offer(n0Var);
            n0Var.a(q0.QUEUED);
            return;
        }
        m.f1343b.post(new e(fVar, aVar));
    }

    @Override // com.fyber.inneractive.sdk.response.j
    public void a(com.fyber.inneractive.sdk.response.b bVar) {
        long j;
        int i;
        bVar.a.B = true;
        IAConfigManager.M.x.e = true;
        ImpressionData impressionData = new ImpressionData();
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.a;
        if (admParametersOuterClass$AdmParameters == null) {
            return;
        }
        int iA = admParametersOuterClass$AdmParameters.getAdType().a();
        if (this.a.hasErrorMessage()) {
            this.a.getErrorMessage();
        }
        String sessionId = this.a.hasSessionId() ? this.a.getSessionId() : null;
        Long lValueOf = this.a.hasContentId() ? Long.valueOf(this.a.getContentId()) : null;
        if (this.a.hasPublisherId()) {
            this.a.getPublisherId();
        }
        Integer numValueOf = this.a.hasAdWidth() ? Integer.valueOf(this.a.getAdWidth()) : null;
        Integer numValueOf2 = this.a.hasAdHeight() ? Integer.valueOf(this.a.getAdHeight()) : null;
        String sdkImpressionUrl = this.a.hasSdkImpressionUrl() ? this.a.getSdkImpressionUrl() : null;
        String sdkClickUrl = this.a.hasSdkClickUrl() ? this.a.getSdkClickUrl() : null;
        Integer numValueOf3 = this.a.hasAdExpirationInterval() ? Integer.valueOf(this.a.getAdExpirationInterval()) : null;
        String adCompletionUrl = this.a.hasAdCompletionUrl() ? this.a.getAdCompletionUrl() : null;
        bVar.f1319b = this.a.hasAdUnitId() ? this.a.getAdUnitId() : null;
        this.a.getAdUnitType().name().toLowerCase();
        String lowerCase = this.a.hasAdUnitId() ? this.a.getAdUnitDisplayType().name().toLowerCase() : null;
        String adNetworkName = this.a.hasAdNetworkName() ? this.a.getAdNetworkName() : null;
        Long lValueOf2 = this.a.hasAdNetworkId() ? Long.valueOf(this.a.getAdNetworkId()) : null;
        String creativeId = this.a.hasCreativeId() ? this.a.getCreativeId() : null;
        String adDomain = this.a.hasAdDomain() ? this.a.getAdDomain() : null;
        String appBundleId = this.a.hasAppBundleId() ? this.a.getAppBundleId() : null;
        String campaignId = this.a.hasCampaignId() ? this.a.getCampaignId() : null;
        String string = this.a.hasPricingValue() ? Double.toString(this.a.getPricingValue()) : null;
        String strValueOf = this.a.hasSpotId() ? String.valueOf(this.a.getSpotId()) : null;
        impressionData.setCpmValue(string);
        impressionData.setCurrency("USD");
        if (this.a.hasMrcData()) {
            int pixelPercent = this.a.getMrcData().hasPixelPercent() ? this.a.getMrcData().getPixelPercent() : 0;
            int pixelDuration = this.a.getMrcData().hasPixelDuration() ? this.a.getMrcData().getPixelDuration() : -1;
            String pixelImpressionUrl = this.a.getMrcData().hasPixelImpressionUrl() ? this.a.getMrcData().getPixelImpressionUrl() : null;
            com.fyber.inneractive.sdk.response.e eVar = bVar.a;
            eVar.t = pixelPercent;
            eVar.u = pixelDuration;
            eVar.v = pixelImpressionUrl;
        } else {
            numValueOf2 = numValueOf2;
            sdkImpressionUrl = sdkImpressionUrl;
            sdkClickUrl = sdkClickUrl;
        }
        Boolean boolValueOf = this.a.hasSkipMode() ? Boolean.valueOf(this.a.getSkipMode()) : null;
        if (bVar.b()) {
            bVar.a.q = this.a.toString();
        }
        com.fyber.inneractive.sdk.response.e eVar2 = bVar.a;
        String string2 = numValueOf3 != null ? numValueOf3.toString() : "";
        eVar2.getClass();
        try {
            j = Long.parseLong(string2);
        } catch (NumberFormatException unused) {
            j = 20;
        }
        long j2 = j;
        eVar2.f1320b = j2;
        Integer num = numValueOf;
        Boolean bool = boolValueOf;
        eVar2.a = eVar2.c + TimeUnit.MINUTES.toMillis(j2);
        impressionData.setImpressionId(sessionId);
        impressionData.setDemandSource(adNetworkName);
        bVar.a.d = lValueOf != null ? lValueOf.toString() : "";
        bVar.a.getClass();
        bVar.a.getClass();
        com.fyber.inneractive.sdk.response.e eVar3 = bVar.a;
        eVar3.y = appBundleId;
        eVar3.z = this.d;
        eVar3.A = strValueOf;
        if (lValueOf2 != null) {
            impressionData.setDemandId(lValueOf2);
        }
        com.fyber.inneractive.sdk.response.e eVar4 = bVar.a;
        eVar4.g = iA;
        if (num != null) {
            eVar4.e = num.intValue();
        }
        if (numValueOf2 != null) {
            bVar.a.f = numValueOf2.intValue();
        }
        com.fyber.inneractive.sdk.response.e eVar5 = bVar.a;
        eVar5.k = sdkImpressionUrl;
        eVar5.l = sdkClickUrl;
        eVar5.o = adCompletionUrl;
        eVar5.m = bVar.f1319b;
        try {
            eVar5.n = UnitDisplayType.fromValue(lowerCase);
        } catch (IllegalArgumentException unused2) {
            bVar.a.n = UnitDisplayType.INTERSTITIAL;
        }
        if (!TextUtils.isEmpty(creativeId)) {
            impressionData.setCreativeId(creativeId);
        }
        if (!TextUtils.isEmpty(adDomain)) {
            impressionData.setAdvertiserDomain(adDomain);
        }
        if (!TextUtils.isEmpty(campaignId)) {
            impressionData.setCampaignId(campaignId);
        }
        impressionData.setCountry(com.fyber.inneractive.sdk.util.j.g());
        bVar.a.r = impressionData;
        if (bool == null) {
            i = -1;
        } else {
            i = bool.booleanValue() ? 1 : 0;
        }
        bVar.a.w = i;
        String igniteInstallUrl = this.a.hasIgniteInstallUrl() ? this.a.getIgniteInstallUrl() : null;
        if (!TextUtils.isEmpty(igniteInstallUrl)) {
            bVar.a.E = igniteInstallUrl;
        }
        com.fyber.inneractive.sdk.response.e eVar6 = bVar.a;
        k kVar = k.NONE;
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = this.a;
        if (admParametersOuterClass$AdmParameters2 != null) {
            AdmParametersOuterClass$AdmParameters.f igniteMode = admParametersOuterClass$AdmParameters2.hasIgniteMode() ? this.a.getIgniteMode() : null;
            if (igniteMode != null && !igniteMode.equals(AdmParametersOuterClass$AdmParameters.f.NONE)) {
                kVar = igniteMode.equals(AdmParametersOuterClass$AdmParameters.f.SINGLETAP) ? k.SINGLE_TAP : k.TRUE_SINGLE_TAP;
            }
        }
        eVar6.a(kVar);
        String igniteLauncherActivity = this.a.hasIgniteLauncherActivity() ? this.a.getIgniteLauncherActivity() : null;
        if (!TextUtils.isEmpty(igniteLauncherActivity)) {
            bVar.a.G = igniteLauncherActivity;
        }
        Boolean boolValueOf2 = this.a.hasBrandBidderDontShowEndcard() ? Boolean.valueOf(this.a.getBrandBidderDontShowEndcard()) : null;
        if (boolValueOf2 != null) {
            bVar.a.C = boolValueOf2.booleanValue() ? "1" : "0";
        }
        String brandBidderCtaText = this.a.getBrandBidderCtaText();
        if (!TextUtils.isEmpty(brandBidderCtaText)) {
            bVar.a.D = brandBidderCtaText;
        }
        Boolean boolValueOf3 = this.a.hasMraidVideoOMSignal() ? Boolean.valueOf(this.a.getMraidVideoOMSignal()) : null;
        if (boolValueOf3 != null) {
            bVar.a.H = boolValueOf3.booleanValue();
        }
    }

    @Override // com.fyber.inneractive.sdk.response.j
    public String a() {
        return this.c;
    }
}
