package com.fyber.inneractive.sdk.bidder;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.fyber.inneractive.sdk.cache.session.h;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite;
import com.fyber.inneractive.sdk.util.l;
import com.fyber.inneractive.sdk.util.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements d, f0.a {
    public static final a h = new a();
    public final TokenParametersOuterClass$TokenParameters.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.serverapi.b f842b;
    public final c c;
    public e d;
    public final AtomicReference<String> e = new AtomicReference<>(null);
    public final AtomicBoolean f = new AtomicBoolean(false);
    public final Object g = new Object();

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.bidder.a$a, reason: collision with other inner class name */
    public class RunnableC0256a implements Runnable {
        public RunnableC0256a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    public a() {
        com.fyber.inneractive.sdk.serverapi.b bVar = new com.fyber.inneractive.sdk.serverapi.b(s.b());
        this.f842b = bVar;
        c cVar = new c(bVar);
        this.c = cVar;
        this.a = TokenParametersOuterClass$TokenParameters.newBuilder();
        IAConfigManager.e().a(this);
        c();
        if (IAConfigManager.c().a().a("bidding_token_wait_for_ua", true)) {
            IAConfigManager.f().d();
            cVar.a(IAConfigManager.f().a());
        }
    }

    public final void a() {
        TokenParametersOuterClass$TokenParameters.n nVar;
        if (!this.f.compareAndSet(false, true)) {
            return;
        }
        TokenParametersOuterClass$TokenParameters.b bVar = this.a;
        bVar.f1272b = (MessageType) bVar.f1272b.dynamicMethod(GeneratedMessageLite.f.NEW_MUTABLE_INSTANCE);
        TokenParametersOuterClass$TokenParameters.b bVar2 = this.a;
        this.c.getClass();
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC = f.c("1.2");
        bVar2.c();
        ((TokenParametersOuterClass$TokenParameters) bVar2.f1272b).setVersion(nullableStringC);
        if (this.e.get() != null) {
            this.c.a();
        }
        TokenParametersOuterClass$TokenParameters.b bVar3 = this.a;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC2 = f.c(this.c.f847b);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setUserAgent(nullableStringC2);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC3 = f.c(this.c.c);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setSdkVersion(nullableStringC3);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC4 = f.c(this.c.d);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setBundleID(nullableStringC4);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC5 = f.c(this.c.e);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setDeviceModel(nullableStringC5);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC6 = f.c(this.c.f);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setAppVersion(nullableStringC6);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC7 = f.c("Android");
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setDeviceOS(nullableStringC7);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A = f.a(Build.VERSION.SDK_INT);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setDeviceApi(nullableUInt32A);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC8 = f.c(Build.VERSION.RELEASE);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setOsVersion(nullableStringC8);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC9 = f.c(this.c.g);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setDeviceLanguage(nullableStringC9);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC10 = f.c(this.c.h);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setCountryCode(nullableStringC10);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC11 = f.c(this.c.i);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setCarrierName(nullableStringC11);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC12 = f.c(this.c.j);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setMobileCountryCode(nullableStringC12);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC13 = f.c(this.c.k);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setMobileNetworkCode(nullableStringC13);
        Long l = this.c.l;
        TokenParametersOuterClass$TokenParameters.NullableSInt32.a aVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableSInt32.newBuilder();
        if (l != null) {
            int iIntValue = l.intValue();
            aVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableSInt32) aVarNewBuilder.f1272b).setData(iIntValue);
        }
        TokenParametersOuterClass$TokenParameters.NullableSInt32 nullableSInt32A = aVarNewBuilder.a();
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setOffsetFromGMT(nullableSInt32A);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC14 = f.c(IAConfigManager.g());
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setUserID(nullableStringC14);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A2 = f.a(this.c.m);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setDeviceWidth(nullableUInt32A2);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A3 = f.a(this.c.n);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setDeviceHeight(nullableUInt32A3);
        TokenParametersOuterClass$TokenParameters.d dVar = this.c.o;
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setFrameworkName(dVar);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC15 = f.c(this.c.p);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setInputLanguages(nullableStringC15);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC16 = f.c(this.c.I);
        bVar3.c();
        ((TokenParametersOuterClass$TokenParameters) bVar3.f1272b).setMediationType(nullableStringC16);
        IAConfigManager iAConfigManager = IAConfigManager.M;
        com.fyber.inneractive.sdk.config.d dVar2 = iAConfigManager.D;
        if (dVar2 != null) {
            TokenParametersOuterClass$TokenParameters.b bVar4 = this.a;
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringC17 = f.c(l.a == null ? null : dVar2.f869b);
            bVar4.c();
            ((TokenParametersOuterClass$TokenParameters) bVar4.f1272b).setGdprString(nullableStringC17);
            TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA = f.a(dVar2.a());
            bVar4.c();
            ((TokenParametersOuterClass$TokenParameters) bVar4.f1272b).setGdprConsent(nullableBoolA);
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringC18 = f.c(l.a == null ? null : dVar2.e);
            bVar4.c();
            ((TokenParametersOuterClass$TokenParameters) bVar4.f1272b).setCcpaString(nullableStringC18);
            TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA2 = f.a(l.a == null ? null : dVar2.f);
            bVar4.c();
            ((TokenParametersOuterClass$TokenParameters) bVar4.f1272b).setLgpdConsent(nullableBoolA2);
            Boolean bool = dVar2.g;
            if (bool != null && bool.booleanValue()) {
                TokenParametersOuterClass$TokenParameters.b bVar5 = this.a;
                TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA3 = f.a(bool);
                bVar5.c();
                ((TokenParametersOuterClass$TokenParameters) bVar5.f1272b).setCoppaApplies(nullableBoolA3);
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            TokenParametersOuterClass$TokenParameters.b bVar6 = this.a;
            boolean zC = com.fyber.inneractive.sdk.config.l.c();
            bVar6.c();
            ((TokenParametersOuterClass$TokenParameters) bVar6.f1272b).setDnt(zC);
        }
        TokenParametersOuterClass$TokenParameters.b bVar7 = this.a;
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC19 = f.c(this.c.q);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setNetwork(nullableStringC19);
        TokenParametersOuterClass$TokenParameters.h hVar = this.c.r;
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setSecureContent(hVar);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA4 = f.a(this.c.B);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setBatteryCharging(nullableBoolA4);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA5 = f.a(this.c.s);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setHeadsetPlugged(nullableBoolA5);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA6 = f.a(this.c.t);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setBluetoothPlugged(nullableBoolA6);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA7 = f.a(this.c.u);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setLowPowerMode(nullableBoolA7);
        boolean z = this.c.v;
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setDarkMode(z);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA8 = f.a(this.c.w);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setAirplaneMode(nullableBoolA8);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA9 = f.a(this.c.x);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setDndMode(nullableBoolA9);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA10 = f.a(this.c.y);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setIsRingMuted(nullableBoolA10);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A4 = f.a(this.c.z);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setSessionDuration(nullableUInt32A4);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32B = f.b(this.c.C);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setBatteryLevel(nullableUInt32B);
        TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA11 = f.a(Boolean.valueOf(TextUtils.equals(iAConfigManager.x.a(UnitDisplayType.INTERSTITIAL, "LAST_VAST_SKIPED"), "1")));
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setPriorSkip(nullableBoolA11);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC20 = f.c(this.c.D);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setKeywords(nullableStringC20);
        TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32A5 = f.a(this.c.E);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setUserAge(nullableUInt32A5);
        InneractiveUserConfig.Gender gender = this.c.F;
        TokenParametersOuterClass$TokenParameters.l lVar = gender == InneractiveUserConfig.Gender.FEMALE ? TokenParametersOuterClass$TokenParameters.l.FEMALE : gender == InneractiveUserConfig.Gender.MALE ? TokenParametersOuterClass$TokenParameters.l.MALE : TokenParametersOuterClass$TokenParameters.l.UNKNOWN;
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setUserGender(lVar);
        TokenParametersOuterClass$TokenParameters.NullableString nullableStringC21 = f.c(this.c.H);
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setZipCode(nullableStringC21);
        boolean z2 = this.c.G;
        bVar7.c();
        ((TokenParametersOuterClass$TokenParameters) bVar7.f1272b).setMuteAudio(z2);
        if (com.fyber.inneractive.sdk.config.l.b()) {
            TokenParametersOuterClass$TokenParameters.b bVar8 = this.a;
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringC22 = f.c(this.c.A);
            bVar8.c();
            ((TokenParametersOuterClass$TokenParameters) bVar8.f1272b).setAmazonId(nullableStringC22);
        } else {
            TokenParametersOuterClass$TokenParameters.b bVar9 = this.a;
            TokenParametersOuterClass$TokenParameters.NullableString nullableStringC23 = f.c(this.c.A);
            bVar9.c();
            ((TokenParametersOuterClass$TokenParameters) bVar9.f1272b).setAaid(nullableStringC23);
        }
        UnitDisplayType[] unitDisplayTypeArrValues = UnitDisplayType.values();
        int length = unitDisplayTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                com.fyber.inneractive.sdk.serverapi.b bVar10 = this.f842b;
                bVar10.getClass();
                s sVarB = s.b();
                bVar10.a = sVarB;
                sVarB.a("", false);
                s sVar = this.f842b.a;
                JSONArray jSONArrayD = sVar != null ? sVar.d() : null;
                if (jSONArrayD != null) {
                    for (int i2 = 0; i2 < jSONArrayD.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayD.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null) {
                            TokenParametersOuterClass$TokenParameters.Experiment.a aVarNewBuilder2 = TokenParametersOuterClass$TokenParameters.Experiment.newBuilder();
                            String strOptString = jSONObjectOptJSONObject.optString("id");
                            aVarNewBuilder2.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) aVarNewBuilder2.f1272b).setIdentifier(strOptString);
                            String strOptString2 = jSONObjectOptJSONObject.optString("v");
                            aVarNewBuilder2.c();
                            ((TokenParametersOuterClass$TokenParameters.Experiment) aVarNewBuilder2.f1272b).setVariant(strOptString2);
                            TokenParametersOuterClass$TokenParameters.b bVar11 = this.a;
                            TokenParametersOuterClass$TokenParameters.Experiment experimentA = aVarNewBuilder2.a();
                            bVar11.c();
                            ((TokenParametersOuterClass$TokenParameters) bVar11.f1272b).addAbExperiments(experimentA);
                        }
                    }
                }
                TokenParametersOuterClass$TokenParameters.b bVar12 = this.a;
                int i3 = com.fyber.inneractive.sdk.config.f.a;
                TokenParametersOuterClass$TokenParameters.NullableUInt32 nullableUInt32B2 = f.b(System.getProperty("ia.testEnvironmentConfiguration.number"));
                bVar12.c();
                ((TokenParametersOuterClass$TokenParameters) bVar12.f1272b).setPortal(nullableUInt32B2);
                TokenParametersOuterClass$TokenParameters.b bVar13 = this.a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringC24 = f.c(System.getProperty("ia.testEnvironmentConfiguration.response"));
                bVar13.c();
                ((TokenParametersOuterClass$TokenParameters) bVar13.f1272b).setMockResponseId(nullableStringC24);
                TokenParametersOuterClass$TokenParameters.b bVar14 = this.a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringC25 = f.c(this.c.J);
                bVar14.c();
                ((TokenParametersOuterClass$TokenParameters) bVar14.f1272b).setIgniteVersion(nullableStringC25);
                TokenParametersOuterClass$TokenParameters.b bVar15 = this.a;
                TokenParametersOuterClass$TokenParameters.NullableString nullableStringC26 = f.c(this.c.K);
                bVar15.c();
                ((TokenParametersOuterClass$TokenParameters) bVar15.f1272b).setIgnitePackageName(nullableStringC26);
                if (this.c.L) {
                    TokenParametersOuterClass$TokenParameters.b bVar16 = this.a;
                    TokenParametersOuterClass$TokenParameters.NullableBool nullableBoolA12 = f.a(Boolean.TRUE);
                    bVar16.c();
                    ((TokenParametersOuterClass$TokenParameters) bVar16.f1272b).setChildMode(nullableBoolA12);
                }
                this.e.set(Base64.encodeToString(this.a.a().toByteArray(), 2));
                this.f.set(false);
                return;
            }
            UnitDisplayType unitDisplayType = unitDisplayTypeArrValues[i];
            if (!unitDisplayType.isDeprecated()) {
                TokenParametersOuterClass$TokenParameters.k kVarA = f.a(unitDisplayType);
                HashMap<String, Integer> map = com.fyber.inneractive.sdk.serverapi.a.a;
                IAConfigManager iAConfigManager2 = IAConfigManager.M;
                String strA = iAConfigManager2.x.a(unitDisplayType, "LAST_DOMAIN_SHOWED");
                if (!TextUtils.isEmpty(strA) && strA.contains(",")) {
                    strA = strA.split(",")[0];
                }
                if (!TextUtils.isEmpty(strA)) {
                    TokenParametersOuterClass$TokenParameters.b bVar17 = this.a;
                    TokenParametersOuterClass$TokenParameters.LastAdomain.a aVarNewBuilder3 = TokenParametersOuterClass$TokenParameters.LastAdomain.newBuilder();
                    aVarNewBuilder3.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) aVarNewBuilder3.f1272b).setAdomain(strA);
                    aVarNewBuilder3.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdomain) aVarNewBuilder3.f1272b).setType(kVarA);
                    TokenParametersOuterClass$TokenParameters.LastAdomain lastAdomainA = aVarNewBuilder3.a();
                    bVar17.c();
                    ((TokenParametersOuterClass$TokenParameters) bVar17.f1272b).addLastAdomains(lastAdomainA);
                }
                String strA2 = iAConfigManager2.x.a(unitDisplayType, "LAST_APP_BUNDLE_ID");
                if (!TextUtils.isEmpty(strA2)) {
                    TokenParametersOuterClass$TokenParameters.b bVar18 = this.a;
                    TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle.a aVarNewBuilder4 = TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle.newBuilder();
                    aVarNewBuilder4.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) aVarNewBuilder4.f1272b).setLastBundle(strA2);
                    aVarNewBuilder4.c();
                    ((TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle) aVarNewBuilder4.f1272b).setType(kVarA);
                    TokenParametersOuterClass$TokenParameters.LastAdvertisedBundle lastAdvertisedBundleA = aVarNewBuilder4.a();
                    bVar18.c();
                    ((TokenParametersOuterClass$TokenParameters) bVar18.f1272b).addLastAdvertisedBundles(lastAdvertisedBundleA);
                }
                if (TextUtils.equals(iAConfigManager2.x.a(unitDisplayType, "LAST_CLICKED"), "1")) {
                    TokenParametersOuterClass$TokenParameters.b bVar19 = this.a;
                    TokenParametersOuterClass$TokenParameters.k kVarA2 = f.a(unitDisplayType);
                    bVar19.c();
                    ((TokenParametersOuterClass$TokenParameters) bVar19.f1272b).addPriorClicks(kVarA2);
                }
                a("display", unitDisplayType, kVarA);
                if (unitDisplayType.isFullscreenUnit()) {
                    a("video", unitDisplayType, kVarA);
                    String strA3 = iAConfigManager2.x.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE");
                    if (!TextUtils.isEmpty(strA3)) {
                        TokenParametersOuterClass$TokenParameters.b bVar20 = this.a;
                        TokenParametersOuterClass$TokenParameters.PriorVideoClickType.a aVarNewBuilder5 = TokenParametersOuterClass$TokenParameters.PriorVideoClickType.newBuilder();
                        strA3.getClass();
                        strA3.hashCode();
                        switch (strA3) {
                            case "1":
                                nVar = TokenParametersOuterClass$TokenParameters.n.CTABUTTON;
                                break;
                            case "2":
                                nVar = TokenParametersOuterClass$TokenParameters.n.COMPANION;
                                break;
                            case "3":
                                nVar = TokenParametersOuterClass$TokenParameters.n.VIDEOVIEW;
                                break;
                            default:
                                nVar = TokenParametersOuterClass$TokenParameters.n.NOCLICK;
                                break;
                        }
                        aVarNewBuilder5.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) aVarNewBuilder5.f1272b).setClickType(nVar);
                        aVarNewBuilder5.c();
                        ((TokenParametersOuterClass$TokenParameters.PriorVideoClickType) aVarNewBuilder5.f1272b).setType(kVarA);
                        TokenParametersOuterClass$TokenParameters.PriorVideoClickType priorVideoClickTypeA = aVarNewBuilder5.a();
                        bVar20.c();
                        ((TokenParametersOuterClass$TokenParameters) bVar20.f1272b).addPriorClickTypes(priorVideoClickTypeA);
                    }
                }
            }
            i++;
        }
    }

    public void b() {
        m.a(new RunnableC0256a());
    }

    public final void c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) l.a.getSystemService("connectivity");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && !InneractiveAdManager.isCurrentUserAChild()) {
            connectivityManager.registerDefaultNetworkCallback(new b(this));
        }
        e eVar = new e(this);
        this.d = eVar;
        l.a.registerReceiver(eVar, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        l.a.registerReceiver(eVar, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (i >= 23) {
            l.a.registerReceiver(eVar, new IntentFilter("android.app.action.INTERRUPTION_FILTER_CHANGED"));
        }
        if (i >= 21) {
            l.a.registerReceiver(eVar, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        }
        if (i >= 17) {
            l.a.registerReceiver(eVar, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
        }
        if (l.b("android.permission.BLUETOOTH")) {
            l.a.registerReceiver(eVar, new IntentFilter("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"));
            l.a.registerReceiver(eVar, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public final void a(String str, UnitDisplayType unitDisplayType, TokenParametersOuterClass$TokenParameters.k kVar) {
        ArrayList<com.fyber.inneractive.sdk.cache.session.e> arrayList;
        TokenParametersOuterClass$TokenParameters.j jVar;
        com.fyber.inneractive.sdk.cache.session.d dVar = IAConfigManager.M.x.a;
        if (dVar != null) {
            h hVar = dVar.f853b.get(com.fyber.inneractive.sdk.cache.session.enums.b.a(unitDisplayType.value(), str));
            TokenParametersOuterClass$TokenParameters.UserSession userSessionA = null;
            if (hVar != null) {
                ArrayList arrayList2 = new ArrayList(hVar);
                Collections.sort(arrayList2, new com.fyber.inneractive.sdk.cache.session.g(hVar));
                arrayList = new ArrayList(arrayList2);
            } else {
                arrayList = null;
            }
            int iA = dVar.a();
            if (iA > 0 && arrayList != null && arrayList.size() >= iA) {
                if (str.equals("video")) {
                    jVar = TokenParametersOuterClass$TokenParameters.j.VIDEO;
                } else if (!str.equals("display")) {
                    jVar = TokenParametersOuterClass$TokenParameters.j.UNITCONTENTTYPEUNKNOWN;
                } else {
                    jVar = TokenParametersOuterClass$TokenParameters.j.DISPLAY;
                }
                TokenParametersOuterClass$TokenParameters.UserSession.a aVarNewBuilder = TokenParametersOuterClass$TokenParameters.UserSession.newBuilder();
                aVarNewBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) aVarNewBuilder.f1272b).setSubType(jVar);
                int i = 0;
                for (com.fyber.inneractive.sdk.cache.session.e eVar : arrayList) {
                    TokenParametersOuterClass$TokenParameters.SessionData.a aVarNewBuilder2 = TokenParametersOuterClass$TokenParameters.SessionData.newBuilder();
                    int i2 = eVar.f854b;
                    aVarNewBuilder2.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) aVarNewBuilder2.f1272b).setClicks(i2);
                    int i3 = eVar.a;
                    aVarNewBuilder2.c();
                    ((TokenParametersOuterClass$TokenParameters.SessionData) aVarNewBuilder2.f1272b).setImpressions(i3);
                    if (str.equals("video") || kVar.equals(TokenParametersOuterClass$TokenParameters.k.REWARDED)) {
                        int i4 = eVar.c;
                        aVarNewBuilder2.c();
                        ((TokenParametersOuterClass$TokenParameters.SessionData) aVarNewBuilder2.f1272b).setCompletions(i4);
                    }
                    TokenParametersOuterClass$TokenParameters.SessionData sessionDataA = aVarNewBuilder2.a();
                    aVarNewBuilder.c();
                    ((TokenParametersOuterClass$TokenParameters.UserSession) aVarNewBuilder.f1272b).addSessionDataItems(sessionDataA);
                    i++;
                    if (i >= iA) {
                        break;
                    }
                }
                aVarNewBuilder.c();
                ((TokenParametersOuterClass$TokenParameters.UserSession) aVarNewBuilder.f1272b).setType(kVar);
                userSessionA = aVarNewBuilder.a();
            }
            if (userSessionA == null || userSessionA.getSessionDataItemsList().size() <= 0) {
                return;
            }
            TokenParametersOuterClass$TokenParameters.b bVar = this.a;
            bVar.c();
            ((TokenParametersOuterClass$TokenParameters) bVar.f1272b).addUserSessions(userSessionA);
        }
    }
}
