package com.fyber.inneractive.sdk.player;

import android.app.Application;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.util.l;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public f0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0275a f1001b;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.a$a, reason: collision with other inner class name */
    public interface InterfaceC0275a {
    }

    public a(f0 f0Var) {
        this.a = f0Var;
    }

    public InterfaceC0275a a() throws Throwable {
        c0 c0Var;
        UnitDisplayType unitDisplayType;
        if (this.f1001b == null) {
            Application application = l.a;
            f0 f0Var = this.a;
            com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) f0Var.f927b;
            b0 b0Var = f0Var.d;
            InneractiveAdRequest inneractiveAdRequest = f0Var.a;
            com.fyber.inneractive.sdk.measurement.a aVar = null;
            if (f0Var != null && b0Var != null && ((com.fyber.inneractive.sdk.config.global.features.l) f0Var.c.a(com.fyber.inneractive.sdk.config.global.features.l.class)).d() && (c0Var = ((a0) this.a.d).f) != null && ((unitDisplayType = c0Var.j) == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED)) {
                aVar = IAConfigManager.M.J;
            }
            this.f1001b = new e(application, gVar, b0Var, inneractiveAdRequest, f0Var, aVar);
        }
        return this.f1001b;
    }
}
