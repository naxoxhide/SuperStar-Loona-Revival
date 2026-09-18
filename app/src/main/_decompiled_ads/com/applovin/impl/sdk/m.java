package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class m implements l.a, AppLovinWebViewActivity.EventListener {
    private static final AtomicBoolean aAt = new AtomicBoolean();
    private static WeakReference<AppLovinWebViewActivity> aAu;
    private AppLovinUserService.OnConsentDialogDismissListener aAv;
    private l aAw;
    private AtomicBoolean aAx = new AtomicBoolean();
    private com.applovin.impl.sdk.utils.a aiO;
    private WeakReference<Activity> aiy;
    private final x logger;
    private final n sdk;

    @Override // com.applovin.impl.sdk.l.a
    public void Bd() {
    }

    m(n nVar) {
        this.aiy = new WeakReference<>(null);
        this.sdk = nVar;
        this.logger = nVar.BL();
        if (nVar.BI() != null) {
            this.aiy = new WeakReference<>(nVar.BI());
        }
        n.E(n.getApplicationContext()).a(new com.applovin.impl.sdk.utils.a() { // from class: com.applovin.impl.sdk.m.1
            @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                m.this.aiy = new WeakReference(activity);
            }
        });
        this.aAw = new l(this, nVar);
    }

    public void preloadConsentDialog() {
        if (this.aAx.getAndSet(true)) {
            return;
        }
        final String str = (String) this.sdk.a(com.applovin.impl.sdk.c.b.aKO);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$m$xc53g8ktG1gDvHyNiG3Yp9mLpK8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.cC(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void cC(String str) {
        WebView webViewA = com.applovin.impl.sdk.utils.u.a(n.getApplicationContext(), "preloading consent dialog", true);
        if (webViewA == null) {
            return;
        }
        webViewA.loadUrl(str);
    }

    public void a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$m$rb3Uh8_aGZWlM3yHT1hEp-uzDfA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(onConsentDialogDismissListener, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener, Activity activity) {
        if (!p(this.sdk) || aAt.getAndSet(true)) {
            if (onConsentDialogDismissListener != null) {
                onConsentDialogDismissListener.onDismiss();
                return;
            }
            return;
        }
        this.aiy = new WeakReference<>(activity);
        this.aAv = onConsentDialogDismissListener;
        this.aiO = new com.applovin.impl.sdk.utils.a() { // from class: com.applovin.impl.sdk.m.2
            @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity2) {
                if (activity2 instanceof AppLovinWebViewActivity) {
                    if (!m.this.Be() || m.aAu.get() != activity2) {
                        AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity2;
                        WeakReference unused = m.aAu = new WeakReference(appLovinWebViewActivity);
                        appLovinWebViewActivity.loadUrl((String) m.this.sdk.a(com.applovin.impl.sdk.c.b.aKO), m.this);
                    }
                    m.aAt.set(false);
                }
            }
        };
        this.sdk.BK().a(this.aiO);
        Intent intent = new Intent(activity, (Class<?>) AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) this.sdk.a(com.applovin.impl.sdk.c.b.aKP));
        activity.startActivity(intent);
    }

    public void bL(final long j) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$m$ok0QgkGFhcB-GQxyN60itPTJ8RI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.bM(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bM(long j) {
        if (x.Fk()) {
            this.logger.f("ConsentDialogManager", "Scheduling repeating consent alert");
        }
        this.aAw.a(j, this.sdk, this);
    }

    @Override // com.applovin.sdk.AppLovinWebViewActivity.EventListener
    public void onReceivedEvent(String str) {
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, n.getApplicationContext());
            Bf();
        } else if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, n.getApplicationContext());
            f(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKR)).booleanValue(), ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKW)).longValue());
        } else if ("closed".equalsIgnoreCase(str)) {
            f(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKS)).booleanValue(), ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKX)).longValue());
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            f(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKT)).booleanValue(), ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKY)).longValue());
        }
    }

    private void f(boolean z, long j) {
        Bf();
        if (z) {
            bL(j);
        }
    }

    @Override // com.applovin.impl.sdk.l.a
    public void Bc() {
        final Activity activity = this.aiy.get();
        if (activity != null) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$m$9vGi13RxyrIuxrGIIR_nIfvoTs8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.h(activity);
                }
            }, ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aKQ)).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Activity activity) {
        a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
    }

    boolean Be() {
        WeakReference<AppLovinWebViewActivity> weakReference = aAu;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private boolean p(n nVar) {
        if (Be()) {
            x.H("AppLovinSdk", "Consent dialog already showing");
            return false;
        }
        if (!com.applovin.impl.sdk.utils.i.Y(n.getApplicationContext())) {
            x.H("AppLovinSdk", "No internet available, skip showing of consent dialog");
            return false;
        }
        if (!((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aKN)).booleanValue()) {
            if (x.Fk()) {
                this.logger.i("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            }
            return false;
        }
        if (StringUtils.isValidString((String) nVar.a(com.applovin.impl.sdk.c.b.aKO))) {
            return true;
        }
        if (x.Fk()) {
            this.logger.i("ConsentDialogManager", "AdServer returned empty consent dialog URL");
        }
        return false;
    }

    private void Bf() {
        this.sdk.BK().b(this.aiO);
        if (Be()) {
            AppLovinWebViewActivity appLovinWebViewActivity = aAu.get();
            aAu = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.aAv;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.aAv = null;
                }
            }
        }
    }
}
