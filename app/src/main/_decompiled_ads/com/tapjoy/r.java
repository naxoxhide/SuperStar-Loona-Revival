package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements TJAdUnit.TJAdUnitWebViewListener {
    public final /* synthetic */ TJCorePlacement a;

    public r(TJCorePlacement tJCorePlacement) {
        this.a = tJCorePlacement;
    }

    @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
    public final void onClick() {
        TJCorePlacement tJCorePlacement = this.a;
        TJPlacement tJPlacementA = tJCorePlacement.a("SHOW");
        TapjoyLog.i("TJCorePlacement", "Handle onClick for placement " + tJCorePlacement.d.getPlacementName());
        if (tJPlacementA == null || tJPlacementA.getListener() == null) {
            return;
        }
        tJPlacementA.getListener().onClick(tJPlacementA);
    }

    @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
    public final void onClosed() {
        if (this.a.i) {
            TJPlacementManager.decrementPlacementCacheCount();
            this.a.i = false;
        }
        if (this.a.j) {
            TJPlacementManager.decrementPlacementPreRenderCount();
            this.a.j = false;
        }
    }

    @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
    public final void onContentReady() {
        this.a.a();
    }
}
