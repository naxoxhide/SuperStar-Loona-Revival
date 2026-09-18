package com.tnkfactory.ad.pub.a;

import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.InterstitialAdItem;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 implements j0 {
    public final /* synthetic */ h0 a;

    public i0(h0 h0Var) {
        this.a = h0Var;
    }

    @Override // com.tnkfactory.ad.pub.a.j0
    public final void a() {
        h0 h0Var = this.a;
        h0Var.a(h0Var.f);
    }

    @Override // com.tnkfactory.ad.pub.a.j0
    public final void b() {
        h0 h0Var = this.a;
        h0Var.c(h0Var.f);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tnkfactory.ad.pub.a.t>] */
    @Override // com.tnkfactory.ad.pub.a.j0
    public final void a(int i) {
        h0 h0Var = this.a;
        h0Var.d = 0;
        com.tnkfactory.ad.pub.a aVar = h0Var.e;
        if (aVar != null) {
            aVar.d0.clear();
            h0Var.e = null;
        }
        h0 h0Var2 = this.a;
        InterstitialAdItem interstitialAdItem = h0Var2.f;
        AdListener adListener = h0Var2.f2886b;
        if (adListener != null) {
            adListener.onClose(interstitialAdItem, i);
        }
    }

    @Override // com.tnkfactory.ad.pub.a.j0
    public final void b(int i) {
        h0 h0Var = this.a;
        InterstitialAdItem interstitialAdItem = h0Var.f;
        AdListener adListener = h0Var.f2886b;
        if (adListener != null) {
            adListener.onVideoCompletion(interstitialAdItem, i);
        }
    }
}
