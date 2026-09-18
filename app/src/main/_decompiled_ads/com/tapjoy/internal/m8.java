package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;
import com.tapjoy.TJCacheListener;
import com.tapjoy.TJCorePlacement;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class m8 implements TJCacheListener {
    public final /* synthetic */ com.tapjoy.t a;

    public m8(com.tapjoy.t tVar) {
        this.a = tVar;
    }

    @Override // com.tapjoy.TJCacheListener
    public final void onCachingComplete(int i) {
        if (i8.e) {
            this.a.e.h.getTjBeacon().a("load", (HashMap) null);
        }
        TJCorePlacement tJCorePlacement = this.a.e;
        TJAdUnit adUnit = tJCorePlacement.getAdUnit();
        TJCorePlacement tJCorePlacement2 = this.a.e;
        tJCorePlacement.j = adUnit.preload(tJCorePlacement2.d, tJCorePlacement2.f2688b);
    }
}
