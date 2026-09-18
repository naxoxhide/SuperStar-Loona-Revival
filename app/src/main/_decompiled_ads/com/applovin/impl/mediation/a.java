package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.sdk.utils.a {
    private boolean GL;
    private final com.applovin.impl.sdk.a akM;
    private final String akN = u.ad(n.getApplicationContext());
    private InterfaceC0115a akO;
    private com.applovin.impl.mediation.b.c akP;
    private boolean akQ;
    private int akR;
    private final x logger;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.a$a, reason: collision with other inner class name */
    public interface InterfaceC0115a {
        void a(com.applovin.impl.mediation.b.c cVar);
    }

    public void ay(boolean z) {
        this.akQ = z;
    }

    a(n nVar) {
        this.logger = nVar.BL();
        this.akM = nVar.BK();
    }

    public void a(com.applovin.impl.mediation.b.c cVar, InterfaceC0115a interfaceC0115a) {
        if (x.Fk()) {
            this.logger.f("AdActivityObserver", "Starting for ad " + cVar.getAdUnitId() + "...");
        }
        W();
        this.akO = interfaceC0115a;
        this.akP = cVar;
        this.akM.a(this);
    }

    public void W() {
        if (x.Fk()) {
            this.logger.f("AdActivityObserver", "Cancelling...");
        }
        this.akM.b(this);
        this.akO = null;
        this.akP = null;
        this.akR = 0;
        this.GL = false;
    }

    @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getClass().getName().equals(this.akN) && (this.akP.xX() || this.akQ)) {
            if (x.Fk()) {
                this.logger.f("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
            }
            if (this.akO != null) {
                if (x.Fk()) {
                    this.logger.f("AdActivityObserver", "Invoking callback...");
                }
                this.akO.a(this.akP);
            }
            W();
            return;
        }
        if (!this.GL) {
            this.GL = true;
        }
        this.akR++;
        if (x.Fk()) {
            this.logger.f("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.akR);
        }
    }

    @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.GL) {
            this.akR--;
            if (x.Fk()) {
                this.logger.f("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.akR);
            }
            if (this.akR <= 0) {
                if (x.Fk()) {
                    this.logger.f("AdActivityObserver", "Last ad Activity destroyed");
                }
                if (this.akO != null) {
                    if (x.Fk()) {
                        this.logger.f("AdActivityObserver", "Invoking callback...");
                    }
                    this.akO.a(this.akP);
                }
                W();
            }
        }
    }
}
