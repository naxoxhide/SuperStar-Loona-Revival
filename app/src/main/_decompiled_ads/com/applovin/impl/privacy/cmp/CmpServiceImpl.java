package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinCmpService;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes.dex */
public class CmpServiceImpl implements com.applovin.impl.privacy.cmp.b.a, AppLovinCmpService {
    private final com.applovin.impl.privacy.cmp.a axs;
    private com.applovin.impl.privacy.cmp.b axt = zP();
    private a axu;
    private b axv;
    private final n sdk;

    public interface a {
        void c(AppLovinCmpError appLovinCmpError);
    }

    public interface b {
        void d(AppLovinCmpError appLovinCmpError);
    }

    public String toString() {
        return "[CmpService]";
    }

    public CmpServiceImpl(n nVar) {
        this.sdk = nVar;
        this.axs = new com.applovin.impl.privacy.cmp.a(nVar.Cj().getDebugUserGeography());
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public void showCmpForExistingUser(final Activity activity, final AppLovinCmpService.OnCompletedListener onCompletedListener) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppLovinCmpService", "showCmpForExistingUser(activity=" + activity + ", completedListener=" + onCompletedListener + ")");
        }
        if (!hasSupportedCmp()) {
            onCompletedListener.onCompleted(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
        } else {
            zQ();
            loadCmp(activity, new a() { // from class: com.applovin.impl.privacy.cmp.CmpServiceImpl.1
                @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.a
                public void c(AppLovinCmpError appLovinCmpError) {
                    if (appLovinCmpError != null) {
                        onCompletedListener.onCompleted(appLovinCmpError);
                    } else {
                        CmpServiceImpl.this.showCmp(activity, new b() { // from class: com.applovin.impl.privacy.cmp.CmpServiceImpl.1.1
                            @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.b
                            public void d(AppLovinCmpError appLovinCmpError2) {
                                onCompletedListener.onCompleted(appLovinCmpError2);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public boolean hasSupportedCmp() {
        return this.axt != null;
    }

    public void loadCmp(final Activity activity, a aVar) {
        if (!hasSupportedCmp()) {
            aVar.c(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
            return;
        }
        this.axu = aVar;
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.privacy.cmp.CmpServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                CmpServiceImpl.this.axt.a(activity, CmpServiceImpl.this.axs, CmpServiceImpl.this);
            }
        };
        if (this.axt.zS()) {
            AppLovinSdkUtils.runOnUiThread(runnable);
        } else {
            runnable.run();
        }
    }

    public void showCmp(final Activity activity, b bVar) {
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.privacy.cmp.CmpServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                CmpServiceImpl.this.axt.b(activity, CmpServiceImpl.this.axs, CmpServiceImpl.this);
            }
        };
        this.axv = bVar;
        if (this.axt.zT()) {
            AppLovinSdkUtils.runOnUiThread(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.applovin.impl.privacy.cmp.b.a
    public void onFlowLoaded(Bundle bundle) {
        a((AppLovinCmpError) null);
    }

    @Override // com.applovin.impl.privacy.cmp.b.a
    public void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl) {
        a(cmpErrorImpl);
        zR();
    }

    @Override // com.applovin.impl.privacy.cmp.b.a
    public void onFlowShowFailed(CmpErrorImpl cmpErrorImpl) {
        b(cmpErrorImpl);
        zR();
    }

    @Override // com.applovin.impl.privacy.cmp.b.a
    public void onFlowHidden(Bundle bundle) {
        b((AppLovinCmpError) null);
        zR();
    }

    private void a(AppLovinCmpError appLovinCmpError) {
        a aVar = this.axu;
        if (aVar == null) {
            return;
        }
        aVar.c(appLovinCmpError);
        this.axu = null;
    }

    private void b(AppLovinCmpError appLovinCmpError) {
        b bVar = this.axv;
        if (bVar == null) {
            return;
        }
        bVar.d(appLovinCmpError);
        this.axv = null;
    }

    private com.applovin.impl.privacy.cmp.b zP() {
        if (u.dI("com.google.android.ump.ConsentForm")) {
            return new com.applovin.impl.privacy.cmp.b(this.sdk);
        }
        if (!this.sdk.Cj().isEnabled() || this.sdk.Cj().zV() != d.a.UNIFIED) {
            return null;
        }
        x.H("AppLovinSdk", "Could not load Google UMP. Please add the Google User Messaging Platform SDK into your application. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
        return null;
    }

    private void zQ() {
        if (hasSupportedCmp()) {
            this.axt.zQ();
        }
    }

    private void zR() {
        com.applovin.impl.privacy.cmp.b bVar = this.axt;
        if (bVar == null) {
            return;
        }
        bVar.destroy();
    }
}
