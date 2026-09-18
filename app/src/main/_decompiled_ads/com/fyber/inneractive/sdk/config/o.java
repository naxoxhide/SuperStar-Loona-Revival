package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.network.s0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes2.dex */
public class o implements com.fyber.inneractive.sdk.network.w<IAConfigManager.c> {
    public final /* synthetic */ IAConfigManager a;

    public o(IAConfigManager iAConfigManager) {
        this.a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.network.w
    public void a(IAConfigManager.c cVar, Exception exc, boolean z) {
        int i;
        IAConfigManager.c cVar2 = cVar;
        boolean z2 = false;
        if (cVar2 != null) {
            if (z) {
                IAConfigManager iAConfigManager = this.a;
                IAConfigManager iAConfigManager2 = IAConfigManager.M;
                iAConfigManager.getClass();
                iAConfigManager.e = cVar2.c;
                iAConfigManager.d = cVar2.f865b;
                iAConfigManager.a = cVar2.d;
                iAConfigManager.f864b = cVar2.e;
            } else {
                IAConfigManager.N = System.currentTimeMillis();
                IAConfigManager iAConfigManager3 = this.a;
                iAConfigManager3.getClass();
                IAlog.a("Got new remote configuration from server:", new Object[0]);
                iAConfigManager3.e = cVar2.c;
                iAConfigManager3.d = cVar2.f865b;
                iAConfigManager3.a = cVar2.d;
                iAConfigManager3.f864b = cVar2.e;
            }
        } else if (exc instanceof com.fyber.inneractive.sdk.network.f) {
            IAConfigManager.N = System.currentTimeMillis();
        }
        if (z) {
            return;
        }
        IAConfigManager iAConfigManager4 = this.a;
        boolean zH = IAConfigManager.h();
        iAConfigManager4.getClass();
        if (zH) {
            iAConfigManager4.a((Exception) null);
        } else {
            if ((exc instanceof InvalidAppIdException) || (exc instanceof FileNotFoundException) || (!(exc instanceof s0) ? TextUtils.isEmpty(iAConfigManager4.c.trim()) : !((i = ((s0) exc).a) < 400 || i >= 500))) {
                z2 = true;
            }
            if (z2) {
                iAConfigManager4.a(new InvalidAppIdException());
            } else if (exc instanceof com.fyber.inneractive.sdk.network.b) {
                iAConfigManager4.a(exc);
            } else {
                iAConfigManager4.a(new IAConfigManager.d());
            }
        }
        if (IAConfigManager.h()) {
            IAConfigManager iAConfigManager5 = this.a;
            if (iAConfigManager5.C == null) {
                iAConfigManager5.C = new com.fyber.inneractive.sdk.network.g0(new q(iAConfigManager5), iAConfigManager5.f, new com.fyber.inneractive.sdk.config.global.m());
            }
            q0 q0VarP = iAConfigManager5.C.p();
            if (q0VarP == q0.RUNNING || q0VarP == q0.QUEUED) {
                return;
            }
            iAConfigManager5.s.b(iAConfigManager5.C);
        }
    }
}
