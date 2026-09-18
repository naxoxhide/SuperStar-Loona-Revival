package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;

/* JADX INFO: loaded from: classes2.dex */
public class b0 extends p<com.fyber.inneractive.sdk.response.f> {
    public IAmraidWebViewController i;

    public b0(com.fyber.inneractive.sdk.config.b0 b0Var, com.fyber.inneractive.sdk.config.global.s sVar) {
        super(b0Var, sVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public void a() {
        if (this.g != null && e()) {
            this.g.a();
            this.g = null;
        }
        IAmraidWebViewController iAmraidWebViewController = this.i;
        if (iAmraidWebViewController != null) {
            com.fyber.inneractive.sdk.measurement.a.InterfaceC0271a interfaceC0271a = iAmraidWebViewController.I;
            if (interfaceC0271a != null) {
                ((com.fyber.inneractive.sdk.measurement.tracker.c) interfaceC0271a).a(false);
            }
            this.i.c();
            this.i = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public boolean e() {
        com.fyber.inneractive.sdk.config.b0 b0Var = this.d;
        if (b0Var == null) {
            return false;
        }
        com.fyber.inneractive.sdk.config.a0 a0Var = (com.fyber.inneractive.sdk.config.a0) b0Var;
        if (a0Var.c == null || a0Var.c.f899b == null) {
            return false;
        }
        return a0Var.c.f899b.isFullscreenUnit();
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public boolean g() {
        IAmraidWebViewController iAmraidWebViewController = this.i;
        if (iAmraidWebViewController != null) {
            if (iAmraidWebViewController.f1358b != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public boolean isVideoAd() {
        return false;
    }
}
