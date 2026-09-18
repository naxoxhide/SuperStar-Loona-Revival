package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import com.applovin.sdk.AppLovinUserSegment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n {
    public static n aAA;
    private static final boolean aAC;
    private static volatile a aAD;
    public static n aAz;
    protected static Context hr;
    private String aAF;
    private WeakReference<Activity> aAG;
    private long aAH;
    private boolean aAI;
    private long aAJ;
    private boolean aAL;
    private AppLovinSdkSettings aAM;
    private AppLovinUserSegment aAN;
    private AppLovinTargetingData aAO;
    private String aAP;
    private volatile AppLovinNativeAdService aAR;
    private volatile EventServiceImpl aAT;
    private volatile UserServiceImpl aAV;
    private volatile CmpServiceImpl aAX;
    private volatile AppLovinSdk aAZ;
    private volatile b aBA;
    private volatile t aBC;
    private volatile com.applovin.impl.sdk.d.c aBE;
    private volatile SessionTracker aBG;
    private volatile u aBI;
    private volatile ae aBK;
    private volatile com.applovin.impl.sdk.network.d aBM;
    private volatile k aBO;
    private volatile com.applovin.impl.sdk.utils.q aBQ;
    private volatile i aBS;
    private volatile com.applovin.impl.privacy.a.c aBU;
    private volatile com.applovin.impl.privacy.b.b aBW;
    private volatile com.applovin.impl.a.a.a aBY;
    private volatile com.applovin.impl.sdk.e.q aBb;
    private volatile com.applovin.impl.sdk.c.c aBd;
    private volatile com.applovin.impl.sdk.network.b aBf;
    private volatile com.applovin.impl.sdk.d.g aBh;
    private volatile q aBj;
    private volatile o aBl;
    private volatile p aBn;
    private volatile Boolean aBp;
    private volatile aa aBq;
    private volatile com.applovin.impl.sdk.c.e aBs;
    private volatile m aBu;
    private volatile com.applovin.impl.sdk.utils.t aBw;
    private volatile d aBy;
    private volatile y aCA;
    private volatile com.applovin.impl.mediation.d aCC;
    private volatile com.applovin.impl.mediation.debugger.ui.testmode.c aCE;
    private List<MaxAdFormat> aCG;
    private String aCP;
    private AppLovinSdk.SdkInitializationListener aCQ;
    private AppLovinSdk.SdkInitializationListener aCR;
    private AppLovinSdkConfiguration aCS;
    private volatile com.applovin.impl.sdk.a.f aCa;
    private volatile w aCc;
    private volatile ArrayService aCe;
    private volatile r aCg;
    private volatile PostbackServiceImpl aCi;
    private volatile com.applovin.impl.sdk.network.f aCk;
    private volatile f aCm;
    private volatile com.applovin.impl.mediation.f aCo;
    private volatile com.applovin.impl.mediation.e aCq;
    private volatile MediationServiceImpl aCs;
    private volatile com.applovin.impl.mediation.a.d aCu;
    private volatile com.applovin.impl.mediation.h aCw;
    private volatile com.applovin.impl.mediation.debugger.b aCy;
    private volatile AppLovinAdServiceImpl age;
    private volatile x logger;
    private static final Object aAE = new Object();
    private static final long aAB = System.currentTimeMillis();
    private final AtomicBoolean aAK = new AtomicBoolean();
    private final Object aAQ = new Object();
    private final Object aAS = new Object();
    private final Object aAU = new Object();
    private final Object aAW = new Object();
    private final Object aAY = new Object();
    private final Object aBa = new Object();
    private final Object aBc = new Object();
    private final Object aBe = new Object();
    private final Object aBg = new Object();
    private final Object aBi = new Object();
    private final Object aBk = new Object();
    private final Object aBm = new Object();
    private final Object aBo = new Object();
    private final Object aBr = new Object();
    private final Object aBt = new Object();
    private final Object aBv = new Object();
    private final Object aBx = new Object();
    private final Object aBz = new Object();
    private final Object aBB = new Object();
    private final Object aBD = new Object();
    private final Object aBF = new Object();
    private final Object aBH = new Object();
    private final Object aBJ = new Object();
    private final Object aBL = new Object();
    private final Object aBN = new Object();
    private final Object aBP = new Object();
    private final Object aBR = new Object();
    private final Object aBT = new Object();
    private final Object aBV = new Object();
    private final Object aBX = new Object();
    private final Object aBZ = new Object();
    private final Object aCb = new Object();
    private final Object aCd = new Object();
    private final Object aCf = new Object();
    private final Object aCh = new Object();
    private final Object aCj = new Object();
    private final Object aCl = new Object();
    private final Object aCn = new Object();
    private final Object aCp = new Object();
    private final Object aCr = new Object();
    private final Object aCt = new Object();
    private final Object aCv = new Object();
    private final Object aCx = new Object();
    private final Object aCz = new Object();
    private final Object aCB = new Object();
    private final Object aCD = new Object();
    private final Object aCF = new Object();
    private final Object aCH = new Object();
    private final AtomicBoolean aCI = new AtomicBoolean(true);
    private final AtomicBoolean aCJ = new AtomicBoolean();
    private boolean aCK = false;
    private boolean iV = false;
    private boolean aCL = false;
    private boolean aCM = false;
    private boolean aCN = false;
    private int aCO = 0;

    public static Context getApplicationContext() {
        return hr;
    }

    public static long CE() {
        return aAB;
    }

    public static boolean CF() {
        return aAC;
    }

    static {
        boolean z;
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$qz7aurlMTAAqpLyZ_qmigKZtOio
                @Override // java.lang.Runnable
                public final void run() {
                    com.applovin.impl.sdk.utils.u.LE();
                }
            });
            z = true;
        } catch (Throwable unused) {
            z = false;
            try {
                x.H("AppLovinSdk", "Running on older Java version.");
            } finally {
                aAC = false;
            }
        }
    }

    public String getSdkKey() {
        return this.aAF;
    }

    public long CG() {
        return this.aAH;
    }

    public AppLovinSdkSettings getSettings() {
        return this.aAM;
    }

    public AppLovinUserSegment getUserSegment() {
        return this.aAN;
    }

    public AppLovinSdk getWrappingSdk() {
        return this.aAZ;
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.aAZ = appLovinSdk;
    }

    public boolean CH() {
        return this.aCL;
    }

    public String CI() {
        return this.aCP;
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.aCS;
    }

    public void initializeSdk(final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!isEnabled()) {
            this.aCQ = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$WYX664yyaJaWwyEo2USHmr83coI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(sdkInitializationListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.aCS);
    }

    public void a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.aAF = str;
        this.aAH = System.currentTimeMillis();
        this.aCK = true;
        this.aAM = appLovinSdkSettings;
        this.aAN = new h();
        this.aAO = new AppLovinTargetingDataImpl();
        this.aCS = new SdkConfigurationImpl(null, this);
        hr = context.getApplicationContext();
        if (!CF()) {
            throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://dash.applovin.com/documentation/mediation/android/getting-started/integration");
        }
        if (context instanceof Activity) {
            this.aAG = new WeakReference<>((Activity) context);
        }
        if ("HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(str)) {
            this.aAI = true;
            aAA = this;
        } else if (aAz == null) {
            aAz = this;
        } else {
            x.H("AppLovinSdk", "Multiple SDK instances detected");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        boolean z = context.getSharedPreferences("com.applovin.sdk.1", 0).getBoolean("com.applovin.sdk." + com.applovin.impl.sdk.utils.u.dH(str) + ".lisvib", false);
        this.aAL = z;
        if (!z) {
            Bh();
            Bi();
        } else {
            com.applovin.impl.sdk.utils.u.k(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$HERPtZHGwfYrdcBRRy0t2MUV_kQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Bi();
                }
            });
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    private void Bh() {
        this.aBs = new com.applovin.impl.sdk.c.e(this);
        this.aBd = new com.applovin.impl.sdk.c.c(this);
        this.logger = new x(this);
        this.aBC = new t(this);
        this.aBy = new d(this);
        this.aBA = new b(this);
        this.aAT = new EventServiceImpl(this);
        this.aAV = new UserServiceImpl(this);
        this.aBE = new com.applovin.impl.sdk.d.c(this);
        this.aBb = new com.applovin.impl.sdk.e.q(this);
        this.aBf = new com.applovin.impl.sdk.network.b(this);
        this.aBh = new com.applovin.impl.sdk.d.g(this);
        this.aCa = new com.applovin.impl.sdk.a.f(this);
        this.aBQ = new com.applovin.impl.sdk.utils.q(this);
        if (((Boolean) a(com.applovin.impl.sdk.c.b.aOj)).booleanValue()) {
            this.aBj = new q(this);
            this.aBn = new p(this);
        } else {
            this.aBl = new o(this);
        }
        if (com.applovin.impl.sdk.utils.h.Le()) {
            this.aBq = new aa(this);
        }
        this.age = new AppLovinAdServiceImpl(this);
        this.aAR = new AppLovinNativeAdService(this);
        this.aBG = new SessionTracker(this);
        this.aBI = new u(this);
        this.aBK = new ae(this);
        this.aCi = new PostbackServiceImpl(this);
        this.aCm = new f(this);
        this.aCo = new com.applovin.impl.mediation.f(this);
        this.aCq = new com.applovin.impl.mediation.e(this);
        this.aCs = new MediationServiceImpl(this);
        this.aCu = new com.applovin.impl.mediation.a.d(this);
        this.aCA = new y(this);
        this.aCy = new com.applovin.impl.mediation.debugger.b(this);
        this.aCw = new com.applovin.impl.mediation.h();
        this.aCC = new com.applovin.impl.mediation.d(this);
        this.aBu = new m(this);
        this.aBS = new i(this);
        this.aCE = new com.applovin.impl.mediation.debugger.ui.testmode.c(this);
        this.aBU = new com.applovin.impl.privacy.a.c(this);
        this.aBW = new com.applovin.impl.privacy.b.b(this);
        this.aBY = new com.applovin.impl.a.a.a(this);
        this.aCc = new w(this);
        this.aCe = new ArrayService(this);
        this.aCg = new r(this);
        this.aCk = new com.applovin.impl.sdk.network.f(this);
        this.aBO = new k(this);
        this.aBw = new com.applovin.impl.sdk.utils.t(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi() {
        Context context = hr;
        final x xVarBL = BL();
        com.applovin.impl.sdk.c.e eVarBV = BV();
        com.applovin.impl.sdk.e.q qVarBM = BM();
        final com.applovin.impl.privacy.a.c cVarCj = Cj();
        E(context);
        Cc();
        Ct();
        Cp();
        Cv().a(MaxAdapter.InitializationStatus.INITIALIZING);
        if (this.aAM.isExceptionHandlerEnabled() && ((Boolean) a(com.applovin.impl.sdk.c.b.aKw)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        if (((Boolean) a(com.applovin.impl.sdk.c.b.aNR)).booleanValue()) {
            this.aBM = new com.applovin.impl.sdk.network.d(context);
        }
        if (TextUtils.isEmpty(this.aAF)) {
            x.H("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            x.H("AppLovinSdk", "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        if (this.aAF.length() != 86 && com.applovin.impl.sdk.utils.u.b(context, this)) {
            x.H("AppLovinSdk", "Please double-check that you entered your SDK key correctly (" + this.aAF + ") : " + Log.getStackTraceString(new Throwable("")));
        }
        if (com.applovin.impl.sdk.utils.u.LB()) {
            x.H("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!com.applovin.impl.sdk.utils.u.O(this)) {
            x.H("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (com.applovin.impl.sdk.utils.u.ac(context)) {
            this.aAM.setVerboseLogging(true);
        }
        BN().a(com.applovin.impl.sdk.c.b.aKm, Boolean.valueOf(this.aAM.isVerboseLoggingEnabled()));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (TextUtils.isEmpty((String) eVarBV.b(com.applovin.impl.sdk.c.d.aRc, (Object) null, defaultSharedPreferences))) {
            this.aCL = true;
            eVarBV.a(com.applovin.impl.sdk.c.d.aRc, Boolean.toString(true), defaultSharedPreferences);
        } else {
            eVarBV.a(com.applovin.impl.sdk.c.d.aRc, Boolean.toString(false), defaultSharedPreferences);
        }
        if (((Boolean) eVarBV.b(com.applovin.impl.sdk.c.d.aRd, false)).booleanValue()) {
            if (x.Fk()) {
                xVarBL.f("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.aCM = true;
        } else {
            if (x.Fk()) {
                xVarBL.f("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            eVarBV.a(com.applovin.impl.sdk.c.d.aRd, true);
            eVarBV.a(com.applovin.impl.sdk.c.d.aRo, Boolean.valueOf(cVarCj.isEnabled()));
        }
        String str = (String) eVarBV.b(com.applovin.impl.sdk.c.d.aRe, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE > com.applovin.impl.sdk.utils.u.dK(str)) {
                eVarBV.a(com.applovin.impl.sdk.c.d.aRe, AppLovinSdk.VERSION);
            }
        } else {
            eVarBV.a(com.applovin.impl.sdk.c.d.aRe, AppLovinSdk.VERSION);
        }
        final boolean zY = com.applovin.impl.sdk.utils.i.Y(getApplicationContext());
        long j = StringUtils.parseInt(this.aAM.getExtraParameters().get(AppLovinSdkExtraParameterKey.INITIALIZATION_DELAY_MILLIS), ((Integer) a(com.applovin.impl.sdk.c.b.aOU)).intValue());
        qVarBM.a(new com.applovin.impl.sdk.e.ab(this, true, "scheduleAdLoadIntegrationError", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$H7Q6vV1w6HD_IiWzlAyRl5GH9Rs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.CM();
            }
        }), com.applovin.impl.sdk.e.q.b.MAIN, j);
        qVarBM.a(new com.applovin.impl.sdk.e.ab(this, true, "sdkInit", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$7eEyVyFfNyibNxEc8G0jIijM1R8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(zY, xVarBL, cVarCj);
            }
        }), com.applovin.impl.sdk.e.q.b.MAIN, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void CM() {
        if (!Bp() || Bo()) {
            return;
        }
        v.w(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, x xVar, com.applovin.impl.privacy.a.c cVar) {
        synchronized (this.aCH) {
            if (!((Boolean) a(com.applovin.impl.sdk.c.b.aNS)).booleanValue() || z) {
                Bk();
            }
            if (((Boolean) a(com.applovin.impl.sdk.c.b.aNR)).booleanValue() && !z) {
                if (x.Fk()) {
                    xVar.g("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                Bu();
            }
            if (cVar.zV() == com.applovin.impl.privacy.a.d.a.TERMS) {
                if (Bp()) {
                    if (x.Fk()) {
                        xVar.f("AppLovinSdk", "MAX mediation detected... Generating consent flow...");
                    }
                    cVar.zY();
                    cVar.a(CD(), new com.applovin.impl.privacy.a.c.a() { // from class: com.applovin.impl.sdk.n.1
                        @Override // com.applovin.impl.privacy.a.c.a
                        public void onFlowCompleted(com.applovin.impl.privacy.a.a aVar) {
                        }
                    });
                } else if (x.Fk()) {
                    xVar.f("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + this.aAP);
                }
            }
        }
    }

    public void aK(boolean z) {
        synchronized (this.aCH) {
            this.aCK = false;
            this.iV = z;
        }
        if (z) {
            List<String> listB = b(com.applovin.impl.sdk.c.a.aJa);
            if (listB.isEmpty()) {
                BM().KK();
                Bt();
                return;
            }
            Long l = (Long) a(com.applovin.impl.sdk.c.a.aJb);
            com.applovin.impl.sdk.e.ab abVar = new com.applovin.impl.sdk.e.ab(this, true, "timeoutInitAdapters", new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$-goW7hRfusdyrEoSbUY2ypqbeUk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.CL();
                }
            });
            BL();
            if (x.Fk()) {
                BL().f("AppLovinSdk", "Waiting for required adapters to init: " + listB + " - timing out in " + l + "ms...");
            }
            BM().a(abVar, com.applovin.impl.sdk.e.q.b.MEDIATION_TIMEOUT, l.longValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void CL() {
        if (BM().isInitialized()) {
            return;
        }
        BL();
        if (x.Fk()) {
            BL().f("AppLovinSdk", "Timing out adapters init...");
        }
        BM().KK();
        Bt();
    }

    public void e(com.applovin.impl.mediation.b.f fVar) {
        if (BM().isInitialized()) {
            return;
        }
        List<String> listB = b(com.applovin.impl.sdk.c.a.aJa);
        if (listB.size() <= 0 || !Cv().tV().keySet().containsAll(listB)) {
            return;
        }
        BL();
        if (x.Fk()) {
            BL().f("AppLovinSdk", "All required adapters initialized");
        }
        BM().KK();
        Bt();
    }

    public void Bj() {
        synchronized (this.aCH) {
            if (!this.aCK && !this.iV) {
                Bk();
            }
        }
    }

    public void Bk() {
        synchronized (this.aCH) {
            this.aCK = true;
            BM().KJ();
            Bl();
        }
    }

    private void Bl() {
        com.applovin.impl.sdk.e.q qVarBM = BM();
        int i = this.aCO + 1;
        this.aCO = i;
        qVarBM.a(new com.applovin.impl.sdk.e.l(i, this, new com.applovin.impl.sdk.e.l.a() { // from class: com.applovin.impl.sdk.n.2
            @Override // com.applovin.impl.sdk.e.l.a
            public void G(JSONObject jSONObject) {
                boolean z = jSONObject != null && jSONObject.length() > 0;
                n.this.D(jSONObject);
                g.o(n.this);
                com.applovin.impl.sdk.utils.i.a(jSONObject, z, n.this);
                n.this.Cz().h(JsonUtils.getBoolean(jSONObject, "smd", false).booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
                n nVar = n.this;
                nVar.aCG = nVar.F(jSONObject);
                if (z) {
                    n.this.aCS = new SdkConfigurationImpl(CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", "")), n.this);
                }
                n.this.CC().f(jSONObject);
                n.this.E(jSONObject);
                com.applovin.impl.sdk.utils.m.bj(((Boolean) n.this.a(com.applovin.impl.sdk.c.b.aQI)).booleanValue());
                com.applovin.impl.sdk.utils.m.bk(((Boolean) n.this.a(com.applovin.impl.sdk.c.b.aQJ)).booleanValue());
                if (n.this.Bo() || !n.this.Bp()) {
                    n.this.cD("Initializing SDK in non-MAX environment...");
                } else if (n.this.Cj().zV() != com.applovin.impl.privacy.a.d.a.UNIFIED) {
                    n.this.cD("Initializing SDK in MAX environment...");
                } else {
                    Activity activityCD = n.this.CD();
                    if (!n.this.aCJ.compareAndSet(false, true)) {
                        n.this.cD("Initializing SDK in MAX environment...");
                    } else {
                        n.this.Cj().zY();
                        n.this.Cj().a(activityCD, new com.applovin.impl.privacy.a.c.a() { // from class: com.applovin.impl.sdk.n.2.1
                            @Override // com.applovin.impl.privacy.a.c.a
                            public void onFlowCompleted(com.applovin.impl.privacy.a.a aVar) {
                                n.this.cD("Initializing SDK in MAX environment...");
                            }
                        });
                    }
                }
                if (!((Boolean) n.this.a(com.applovin.impl.sdk.c.b.aNR)).booleanValue() || z || !com.applovin.impl.sdk.utils.i.Y(n.getApplicationContext())) {
                    n.this.Bm();
                    return;
                }
                n.this.BL();
                if (x.Fk()) {
                    n.this.BL().g("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                n.this.Bu();
            }
        }), com.applovin.impl.sdk.e.q.b.MAIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm() {
        Long l = (Long) a(com.applovin.impl.sdk.c.b.aOa);
        if (l.longValue() >= 0 && this.aAK.compareAndSet(false, true)) {
            com.applovin.impl.sdk.utils.w.a(l.longValue(), false, this, new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$RkQczewLYn3uw5Ap6BV9B5SLSBM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.CK();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void CK() {
        com.applovin.impl.sdk.e.q qVarBM = BM();
        int i = this.aCO + 1;
        this.aCO = i;
        qVarBM.a(new com.applovin.impl.sdk.e.l(i, this, new com.applovin.impl.sdk.e.l.a() { // from class: com.applovin.impl.sdk.n.3
            @Override // com.applovin.impl.sdk.e.l.a
            public void G(JSONObject jSONObject) {
                if (jSONObject != null && jSONObject.length() > 0) {
                    n.this.D(jSONObject);
                }
                n.this.aAK.set(false);
                n.this.Bm();
            }
        }), com.applovin.impl.sdk.e.q.b.MAIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(JSONObject jSONObject) {
        this.aAJ = System.currentTimeMillis();
        com.applovin.impl.sdk.utils.i.j(jSONObject, this);
        com.applovin.impl.sdk.utils.i.i(jSONObject, this);
        com.applovin.impl.sdk.utils.i.k(jSONObject, this);
        com.applovin.impl.mediation.e.b.d(jSONObject, this);
        com.applovin.impl.mediation.e.b.e(jSONObject, this);
        com.applovin.impl.mediation.e.b.f(jSONObject, this);
        com.applovin.impl.mediation.e.b.z(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(String str) {
        BL();
        if (x.Fk()) {
            BL().f("AppLovinSdk", str);
        }
        BM().b(new com.applovin.impl.sdk.e.p(this));
    }

    public boolean Bn() {
        boolean z;
        synchronized (this.aCH) {
            z = this.aCK;
        }
        return z;
    }

    public boolean isEnabled() {
        boolean z;
        synchronized (this.aCH) {
            z = this.iV;
        }
        return z;
    }

    public boolean Bo() {
        return this.aAI;
    }

    public boolean Bp() {
        return StringUtils.containsIgnoreCase(getMediationProvider(), "max");
    }

    public boolean Bq() {
        return com.applovin.impl.sdk.utils.u.dI("com.unity3d.player.UnityPlayerActivity");
    }

    public void Br() {
        String str = (String) BV().b(com.applovin.impl.sdk.c.d.aRe, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE < com.applovin.impl.sdk.utils.u.dK(str)) {
                x.H("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
            }
        }
    }

    public void Bs() {
        Cf().Bb();
    }

    public void Bt() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if ((Cj().zW() && Cj().zV() == com.applovin.impl.privacy.a.d.a.UNIFIED) || (sdkInitializationListener = this.aCQ) == null) {
            return;
        }
        if (isEnabled()) {
            this.aCQ = null;
            this.aCR = null;
            Cv().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
        } else {
            if (this.aCR == sdkInitializationListener) {
                return;
            }
            Cv().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
            if (((Boolean) a(com.applovin.impl.sdk.c.b.aKs)).booleanValue()) {
                this.aCQ = null;
            } else {
                this.aCR = sdkInitializationListener;
            }
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$2-T4Tez6jvYg6SkYuxsnA6LteiM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(sdkInitializationListener);
            }
        }, Math.max(0L, ((Long) a(com.applovin.impl.sdk.c.b.aKt)).longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        BL();
        if (x.Fk()) {
            BL().f("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.aCS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu() {
        final com.applovin.impl.sdk.network.d dVarG = G(hr);
        dVarG.a(new com.applovin.impl.sdk.network.d.a() { // from class: com.applovin.impl.sdk.n.4
            @Override // com.applovin.impl.sdk.network.d.a
            public void CO() {
            }

            @Override // com.applovin.impl.sdk.network.d.a
            public void CN() {
                n.this.BL();
                if (x.Fk()) {
                    n.this.BL().g("AppLovinSdk", "Connected to internet - re-initializing SDK");
                }
                synchronized (n.this.aCH) {
                    if (!n.this.aCK) {
                        n.this.Bk();
                    }
                }
                dVarG.b(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(JSONObject jSONObject) {
        Iterator it = JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList()).iterator();
        while (it.hasNext()) {
            x.H("AppLovinSdk", (String) it.next());
        }
    }

    public void Bv() {
        x.H("AppLovinSdk", "Resetting SDK state...");
        long jB = BP().b(com.applovin.impl.sdk.d.f.aSV);
        BN().JF();
        BN().JD();
        BP().JU();
        BP().b(com.applovin.impl.sdk.d.f.aSV, jB + 1);
        if (this.aCI.compareAndSet(true, false)) {
            Bk();
        } else {
            this.aCI.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<MaxAdFormat> F(JSONObject jSONObject) {
        List listAsList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            MaxAdFormat fromString = MaxAdFormat.formatFromString((String) it.next());
            if (fromString != null) {
                arrayList.add(fromString);
            }
        }
        return arrayList;
    }

    public <T> T a(com.applovin.impl.sdk.c.b<T> bVar) {
        return (T) BN().a(bVar);
    }

    public List<String> b(com.applovin.impl.sdk.c.b<String> bVar) {
        return BN().b(bVar);
    }

    public List<MaxAdFormat> c(com.applovin.impl.sdk.c.b<String> bVar) {
        return BN().c(bVar);
    }

    public boolean a(com.applovin.impl.sdk.c.b<String> bVar, MaxAdFormat maxAdFormat) {
        return c(bVar).contains(maxAdFormat);
    }

    public <T> void a(com.applovin.impl.sdk.c.d<T> dVar, T t) {
        BV().a(dVar, t);
    }

    public <T> void a(com.applovin.impl.sdk.c.d<T> dVar, T t, SharedPreferences sharedPreferences) {
        BV().a(dVar, t, sharedPreferences);
    }

    public <T> void a(String str, T t, SharedPreferences.Editor editor) {
        BV().a(str, t, editor);
    }

    public <T> T a(com.applovin.impl.sdk.c.d<T> dVar) {
        return (T) b(dVar, (Object) null);
    }

    public <T> T b(com.applovin.impl.sdk.c.d<T> dVar, T t) {
        return (T) BV().b(dVar, t);
    }

    public <T> T b(com.applovin.impl.sdk.c.d<T> dVar, T t, SharedPreferences sharedPreferences) {
        return (T) BV().b(dVar, t, sharedPreferences);
    }

    public <T> T a(String str, T t, Class<?> cls, SharedPreferences sharedPreferences) {
        return (T) com.applovin.impl.sdk.c.e.a(str, t, cls, sharedPreferences);
    }

    public <T> void b(com.applovin.impl.sdk.c.d<T> dVar) {
        BV().b(dVar);
    }

    public void a(SharedPreferences sharedPreferences) {
        BV().a(sharedPreferences);
    }

    public static String cl(String str) {
        return b(str, (List<String>) null);
    }

    public static String gy(int i) {
        return c(i, (List<String>) null);
    }

    public static String b(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context applicationContext = getApplicationContext();
        return c(applicationContext.getResources().getIdentifier(str, "string", applicationContext.getPackageName()), list);
    }

    public static String c(int i, List<String> list) {
        String string = getApplicationContext().getResources().getString(i);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    public boolean g(MaxAdFormat maxAdFormat) {
        List<MaxAdFormat> list = this.aCG;
        return (list == null || list.size() <= 0 || this.aCG.contains(maxAdFormat)) ? false : true;
    }

    public void showMediationDebugger() {
        showMediationDebugger(null);
    }

    public void showMediationDebugger(Map<String, List<?>> map) {
        Cz().showMediationDebugger(map);
    }

    public void showCreativeDebugger() {
        Cm().showCreativeDebugger();
    }

    public void bN(long j) {
        BW().bL(j);
    }

    public long Bw() {
        if (this.aAJ == 0) {
            return -1L;
        }
        return System.currentTimeMillis() - this.aAJ;
    }

    public void setPluginVersion(final String str) {
        x.D("AppLovinSdk", "Setting plugin version: " + str);
        if (com.applovin.impl.sdk.utils.u.Lv() && this.aAL) {
            com.applovin.impl.sdk.utils.u.k(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$wrkIK1vtEDO9j_TBOlkcg6CnLFs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.cG(str);
                }
            });
        } else {
            BN().a(com.applovin.impl.sdk.c.b.aOy, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void cG(String str) {
        BN().a(com.applovin.impl.sdk.c.b.aOy, str);
    }

    public void cE(final String str) {
        BL();
        if (x.Fk()) {
            BL().f("AppLovinSdk", "Setting user id: " + str);
        }
        if (StringUtils.isValidString(str) && str.length() > com.applovin.impl.sdk.utils.u.gV(8)) {
            x.H("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + com.applovin.impl.sdk.utils.u.gV(8) + " maximum)");
        }
        if (com.applovin.impl.sdk.utils.u.Lv() && this.aAL) {
            com.applovin.impl.sdk.utils.u.k(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$NJJY6qf0iQiWSKwfw77dJYTuzrg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.cF(str);
                }
            });
        } else {
            BX().cE(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void cF(String str) {
        BX().cE(str);
    }

    public String Bx() {
        return BX().Bx();
    }

    public String By() {
        return BX().By();
    }

    public String Bz() {
        return BX().Lt();
    }

    public AppLovinTargetingDataImpl BA() {
        return (AppLovinTargetingDataImpl) this.aAO;
    }

    public void setMediationProvider(String str) {
        BL();
        if (x.Fk()) {
            BL().f("AppLovinSdk", "setMediationProvider(mediationProvider=" + str + ")");
        }
        if (str != null && (str.isEmpty() || str.length() > 64 || !StringUtils.isAlphaNumeric(str))) {
            x.H("AppLovinSdk", "Mediation provider set to invalid value: " + str + ". Please use a valid mediation provider (e.g., AppLovinMediationProvider.MAX)");
            return;
        }
        this.aAP = str;
        if (com.applovin.impl.sdk.utils.u.Lv() && this.aAL) {
            com.applovin.impl.sdk.utils.u.k(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$n$G_5bG_V0eNBkF6PLU-MLzbr-ijc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.CJ();
                }
            });
        } else {
            b(com.applovin.impl.sdk.c.d.aRI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void CJ() {
        b(com.applovin.impl.sdk.c.d.aRI);
    }

    public String getMediationProvider() {
        String str = (String) a(com.applovin.impl.sdk.c.d.aRI);
        return StringUtils.isValidString(str) ? str : this.aAP;
    }

    public static a E(Context context) {
        if (aAD == null) {
            synchronized (aAE) {
                if (aAD == null) {
                    aAD = new a(context);
                }
            }
        }
        return aAD;
    }

    public static void F(Context context) {
        if (context == null) {
            return;
        }
        hr = context.getApplicationContext();
    }

    public AppLovinAdServiceImpl BB() {
        if (this.age == null) {
            synchronized (this.aAQ) {
                if (this.age == null) {
                    this.age = new AppLovinAdServiceImpl(this);
                }
            }
        }
        return this.age;
    }

    public AppLovinNativeAdService BC() {
        if (this.aAR == null) {
            synchronized (this.aAS) {
                if (this.aAR == null) {
                    this.aAR = new AppLovinNativeAdService(this);
                }
            }
        }
        return this.aAR;
    }

    public EventServiceImpl BD() {
        if (this.aAT == null) {
            synchronized (this.aAU) {
                if (this.aAT == null) {
                    this.aAT = new EventServiceImpl(this);
                }
            }
        }
        return this.aAT;
    }

    public UserServiceImpl BE() {
        if (this.aAV == null) {
            synchronized (this.aAW) {
                if (this.aAV == null) {
                    this.aAV = new UserServiceImpl(this);
                }
            }
        }
        return this.aAV;
    }

    public void BF() {
        if (StringUtils.isValidString(this.aCP)) {
            return;
        }
        this.aCP = "max";
        BL();
        if (x.Fk()) {
            BL().f("AppLovinSdk", "Detected mediation provider: MAX");
        }
    }

    public String BG() {
        boolean z;
        if (StringUtils.isValidString(this.aCP)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Map<String, String> mapBH = BH();
        List<String> listB = b(com.applovin.impl.sdk.c.b.aOX);
        Boolean bool = (Boolean) a(com.applovin.impl.sdk.c.b.aOY);
        if (mapBH.isEmpty() && !bool.booleanValue()) {
            return null;
        }
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Integer numValueOf = (Integer) a(com.applovin.impl.sdk.c.b.aOW);
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (numValueOf.intValue() <= 0) {
                    break;
                }
                String className = stackTraceElement.getClassName();
                Iterator<String> it = listB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (className.startsWith(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    for (Map.Entry<String, String> entry : mapBH.entrySet()) {
                        if (className.startsWith(entry.getKey())) {
                            this.aCP = entry.getValue();
                            BL();
                            if (x.Fk()) {
                                BL().f("AppLovinSdk", "Detected mediation provider: " + this.aCP);
                            }
                            return null;
                        }
                    }
                    if (bool.booleanValue()) {
                        arrayList.add(className);
                    }
                    numValueOf = Integer.valueOf(numValueOf.intValue() - 1);
                }
            }
        } catch (Throwable th) {
            Cq().d("AppLovinSdk", "detectMediationProvider", th);
        }
        this.aCP = "unknown";
        BL();
        if (x.Fk()) {
            BL().h("AppLovinSdk", "Unable to detect mediation provider");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return StringUtils.join(",", arrayList);
    }

    private Map<String, String> BH() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(com.applovin.impl.sdk.c.b.aOV)));
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    public Activity BI() {
        WeakReference<Activity> weakReference = this.aAG;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean BJ() {
        return this.aCM;
    }

    public a BK() {
        return E(hr);
    }

    public x BL() {
        if (this.logger == null) {
            synchronized (this.aBa) {
                if (this.logger == null) {
                    this.logger = new x(this);
                }
            }
        }
        return this.logger;
    }

    public com.applovin.impl.sdk.e.q BM() {
        if (this.aBb == null) {
            synchronized (this.aBc) {
                if (this.aBb == null) {
                    this.aBb = new com.applovin.impl.sdk.e.q(this);
                }
            }
        }
        return this.aBb;
    }

    public com.applovin.impl.sdk.c.c BN() {
        if (this.aBd == null) {
            synchronized (this.aBe) {
                if (this.aBd == null) {
                    this.aBd = new com.applovin.impl.sdk.c.c(this);
                }
            }
        }
        return this.aBd;
    }

    public com.applovin.impl.sdk.network.b BO() {
        if (this.aBf == null) {
            synchronized (this.aBg) {
                if (this.aBf == null) {
                    this.aBf = new com.applovin.impl.sdk.network.b(this);
                }
            }
        }
        return this.aBf;
    }

    public com.applovin.impl.sdk.d.g BP() {
        if (this.aBh == null) {
            synchronized (this.aBi) {
                if (this.aBh == null) {
                    this.aBh = new com.applovin.impl.sdk.d.g(this);
                }
            }
        }
        return this.aBh;
    }

    public o BQ() {
        if (this.aBl == null) {
            synchronized (this.aBm) {
                if (this.aBl == null) {
                    this.aBl = new o(this);
                }
            }
        }
        return this.aBl;
    }

    private boolean BR() {
        if (this.aBp == null) {
            this.aBp = (Boolean) a(com.applovin.impl.sdk.c.b.aOj);
        }
        return Boolean.TRUE.equals(this.aBp);
    }

    public q BS() {
        if (BR() && this.aBj == null) {
            synchronized (this.aBk) {
                if (this.aBj == null) {
                    this.aBj = new q(this);
                }
            }
        }
        return this.aBj;
    }

    public p BT() {
        if (BR() && this.aBn == null) {
            synchronized (this.aBo) {
                if (this.aBn == null) {
                    this.aBn = new p(this);
                }
            }
        }
        return this.aBn;
    }

    public aa BU() {
        if (this.aBq == null && com.applovin.impl.sdk.utils.h.Le()) {
            synchronized (this.aBr) {
                if (this.aBq == null) {
                    this.aBq = new aa(this);
                }
            }
        }
        return this.aBq;
    }

    public com.applovin.impl.sdk.c.e BV() {
        if (this.aBs == null) {
            synchronized (this.aBt) {
                if (this.aBs == null) {
                    this.aBs = new com.applovin.impl.sdk.c.e(this);
                }
            }
        }
        return this.aBs;
    }

    public m BW() {
        if (this.aBu == null) {
            synchronized (this.aBv) {
                if (this.aBu == null) {
                    this.aBu = new m(this);
                }
            }
        }
        return this.aBu;
    }

    public com.applovin.impl.sdk.utils.t BX() {
        if (this.aBw == null) {
            synchronized (this.aBx) {
                if (this.aBw == null) {
                    this.aBw = new com.applovin.impl.sdk.utils.t(this);
                }
            }
        }
        return this.aBw;
    }

    public d BY() {
        if (this.aBy == null) {
            synchronized (this.aBz) {
                if (this.aBy == null) {
                    this.aBy = new d(this);
                }
            }
        }
        return this.aBy;
    }

    public b BZ() {
        if (this.aBA == null) {
            synchronized (this.aBB) {
                if (this.aBA == null) {
                    this.aBA = new b(this);
                }
            }
        }
        return this.aBA;
    }

    public t Ca() {
        if (this.aBC == null) {
            synchronized (this.aBD) {
                if (this.aBC == null) {
                    this.aBC = new t(this);
                }
            }
        }
        return this.aBC;
    }

    public com.applovin.impl.sdk.d.c Cb() {
        if (this.aBE == null) {
            synchronized (this.aBF) {
                if (this.aBE == null) {
                    this.aBE = new com.applovin.impl.sdk.d.c(this);
                }
            }
        }
        return this.aBE;
    }

    public SessionTracker Cc() {
        if (this.aBG == null) {
            synchronized (this.aBH) {
                if (this.aBG == null) {
                    this.aBG = new SessionTracker(this);
                }
            }
        }
        return this.aBG;
    }

    public u Cd() {
        if (this.aBI == null) {
            synchronized (this.aBJ) {
                if (this.aBI == null) {
                    this.aBI = new u(this);
                }
            }
        }
        return this.aBI;
    }

    public ae Ce() {
        if (this.aBK == null) {
            synchronized (this.aBL) {
                if (this.aBK == null) {
                    this.aBK = new ae(this);
                }
            }
        }
        return this.aBK;
    }

    public com.applovin.impl.sdk.network.d G(Context context) {
        if (this.aBM == null) {
            synchronized (this.aBN) {
                if (this.aBM == null) {
                    this.aBM = new com.applovin.impl.sdk.network.d(context);
                }
            }
        }
        return this.aBM;
    }

    public k Cf() {
        if (this.aBO == null) {
            synchronized (this.aBP) {
                if (this.aBO == null) {
                    this.aBO = new k(this);
                }
            }
        }
        return this.aBO;
    }

    public com.applovin.impl.sdk.utils.q Cg() {
        if (this.aBQ == null) {
            synchronized (this.aBR) {
                if (this.aBQ == null) {
                    this.aBQ = new com.applovin.impl.sdk.utils.q(this);
                }
            }
        }
        return this.aBQ;
    }

    public i Ch() {
        if (this.aBS == null) {
            synchronized (this.aBT) {
                if (this.aBS == null) {
                    this.aBS = new i(this);
                }
            }
        }
        return this.aBS;
    }

    public AppLovinSdkSettings.TermsAndPrivacyPolicyFlowSettings Ci() {
        return getSettings().getBackingConsentFlowSettings();
    }

    public com.applovin.impl.privacy.a.c Cj() {
        if (this.aBU == null) {
            synchronized (this.aBV) {
                if (this.aBU == null) {
                    this.aBU = new com.applovin.impl.privacy.a.c(this);
                }
            }
        }
        return this.aBU;
    }

    public com.applovin.impl.privacy.b.b Ck() {
        if (this.aBW == null) {
            synchronized (this.aBX) {
                if (this.aBW == null) {
                    this.aBW = new com.applovin.impl.privacy.b.b(this);
                }
            }
        }
        return this.aBW;
    }

    public CmpServiceImpl Cl() {
        if (this.aAX == null) {
            synchronized (this.aAY) {
                if (this.aAX == null) {
                    this.aAX = new CmpServiceImpl(this);
                }
            }
        }
        return this.aAX;
    }

    public com.applovin.impl.a.a.a Cm() {
        if (this.aBY == null) {
            synchronized (this.aBZ) {
                if (this.aBY == null) {
                    this.aBY = new com.applovin.impl.a.a.a(this);
                }
            }
        }
        return this.aBY;
    }

    public com.applovin.impl.sdk.a.f Cn() {
        if (this.aCa == null) {
            synchronized (this.aCb) {
                if (this.aCa == null) {
                    this.aCa = new com.applovin.impl.sdk.a.f(this);
                }
            }
        }
        return this.aCa;
    }

    public w Co() {
        if (this.aCc == null) {
            synchronized (this.aCd) {
                if (this.aCc == null) {
                    this.aCc = new w(this);
                }
            }
        }
        return this.aCc;
    }

    public ArrayService Cp() {
        if (this.aCe == null) {
            synchronized (this.aCf) {
                if (this.aCe == null) {
                    this.aCe = new ArrayService(this);
                }
            }
        }
        return this.aCe;
    }

    public r Cq() {
        if (this.aCg == null) {
            synchronized (this.aCh) {
                if (this.aCg == null) {
                    this.aCg = new r(this);
                }
            }
        }
        return this.aCg;
    }

    public PostbackServiceImpl Cr() {
        if (this.aCi == null) {
            synchronized (this.aCj) {
                if (this.aCi == null) {
                    this.aCi = new PostbackServiceImpl(this);
                }
            }
        }
        return this.aCi;
    }

    public com.applovin.impl.sdk.network.f Cs() {
        if (this.aCk == null) {
            synchronized (this.aCl) {
                if (this.aCk == null) {
                    this.aCk = new com.applovin.impl.sdk.network.f(this);
                }
            }
        }
        return this.aCk;
    }

    public f Ct() {
        if (this.aCm == null) {
            synchronized (this.aCn) {
                if (this.aCm == null) {
                    this.aCm = new f(this);
                }
            }
        }
        return this.aCm;
    }

    public com.applovin.impl.mediation.f Cu() {
        if (this.aCo == null) {
            synchronized (this.aCp) {
                if (this.aCo == null) {
                    this.aCo = new com.applovin.impl.mediation.f(this);
                }
            }
        }
        return this.aCo;
    }

    public com.applovin.impl.mediation.e Cv() {
        if (this.aCq == null) {
            synchronized (this.aCr) {
                if (this.aCq == null) {
                    this.aCq = new com.applovin.impl.mediation.e(this);
                }
            }
        }
        return this.aCq;
    }

    public MediationServiceImpl Cw() {
        if (this.aCs == null) {
            synchronized (this.aCt) {
                if (this.aCs == null) {
                    this.aCs = new MediationServiceImpl(this);
                }
            }
        }
        return this.aCs;
    }

    public com.applovin.impl.mediation.a.d Cx() {
        if (this.aCu == null) {
            synchronized (this.aCv) {
                if (this.aCu == null) {
                    this.aCu = new com.applovin.impl.mediation.a.d(this);
                }
            }
        }
        return this.aCu;
    }

    public com.applovin.impl.mediation.h Cy() {
        if (this.aCw == null) {
            synchronized (this.aCx) {
                if (this.aCw == null) {
                    this.aCw = new com.applovin.impl.mediation.h();
                }
            }
        }
        return this.aCw;
    }

    public com.applovin.impl.mediation.debugger.b Cz() {
        if (this.aCy == null) {
            synchronized (this.aCz) {
                if (this.aCy == null) {
                    this.aCy = new com.applovin.impl.mediation.debugger.b(this);
                }
            }
        }
        return this.aCy;
    }

    public y CA() {
        if (this.aCA == null) {
            synchronized (this.aCB) {
                if (this.aCA == null) {
                    this.aCA = new y(this);
                }
            }
        }
        return this.aCA;
    }

    public com.applovin.impl.mediation.d CB() {
        if (this.aCC == null) {
            synchronized (this.aCD) {
                if (this.aCC == null) {
                    this.aCC = new com.applovin.impl.mediation.d(this);
                }
            }
        }
        return this.aCC;
    }

    public com.applovin.impl.mediation.debugger.ui.testmode.c CC() {
        if (this.aCE == null) {
            synchronized (this.aCF) {
                if (this.aCE == null) {
                    this.aCE = new com.applovin.impl.mediation.debugger.ui.testmode.c(this);
                }
            }
        }
        return this.aCE;
    }

    public Activity CD() {
        Activity activityAx = E(getApplicationContext()).Ax();
        return activityAx != null ? activityAx : BI();
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.aAF + "', enabled=" + this.iV + ", isFirstSession=" + this.aCL + '}';
    }
}
