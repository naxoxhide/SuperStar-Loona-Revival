package com.applovin.impl.mediation.d;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.sdk.e.d {
    private final Activity ahM;
    private final List<com.applovin.impl.mediation.b.f> alY;

    public a(List<com.applovin.impl.mediation.b.f> list, Activity activity, n nVar) {
        super("TaskAutoInitAdapters", nVar, true);
        this.alY = list;
        this.ahM = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.alY.size() > 0) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Auto-initing " + this.alY.size() + " adapters" + (this.sdk.CC().isEnabled() ? " in test mode" : "") + "...");
            }
            if (TextUtils.isEmpty(this.sdk.getMediationProvider())) {
                this.sdk.setMediationProvider("max");
            } else if (!this.sdk.Bp()) {
                x.H("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.sdk.getMediationProvider());
            }
            if (this.ahM == null) {
                x.H("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
            }
            for (final com.applovin.impl.mediation.b.f fVar : this.alY) {
                this.sdk.BM().h(new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$a$hMCke52W_mVfmKJCPx8LBPEFMBA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(fVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(com.applovin.impl.mediation.b.f fVar) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Auto-initing adapter: " + fVar);
        }
        this.sdk.Cv().a(fVar, this.ahM);
    }
}
