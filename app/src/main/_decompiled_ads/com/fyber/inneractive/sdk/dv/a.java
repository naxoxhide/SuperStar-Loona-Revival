package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.flow.q;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends q<f> {
    public d g;
    public com.fyber.inneractive.sdk.dv.banner.b h;
    public T i;

    public a(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar);
        a(fVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public void a() {
        this.g = null;
        this.i = null;
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public com.fyber.inneractive.sdk.response.e d() {
        return (f) this.f927b;
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public boolean g() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.q
    public boolean isVideoAd() {
        return false;
    }

    public void a(AdRequest adRequest, d dVar) {
        this.g = dVar;
    }
}
