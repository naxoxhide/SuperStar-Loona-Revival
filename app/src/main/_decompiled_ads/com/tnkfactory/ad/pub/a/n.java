package com.tnkfactory.ad.pub.a;

import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.BannerAdView;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements j0 {
    public final /* synthetic */ m a;

    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.tnkfactory.ad.pub.a.j0
    public final void a() {
        m mVar = this.a;
        mVar.a((AdItem) mVar.f);
    }

    @Override // com.tnkfactory.ad.pub.a.j0
    public final void a(int i) {
    }

    @Override // com.tnkfactory.ad.pub.a.j0
    public final void b() {
        m mVar = this.a;
        mVar.c(mVar.f);
    }

    @Override // com.tnkfactory.ad.pub.a.j0
    public final void b(int i) {
        m mVar = this.a;
        BannerAdView bannerAdView = mVar.f;
        AdListener adListener = mVar.f2886b;
        if (adListener != null) {
            adListener.onVideoCompletion(bannerAdView, i);
        }
    }
}
