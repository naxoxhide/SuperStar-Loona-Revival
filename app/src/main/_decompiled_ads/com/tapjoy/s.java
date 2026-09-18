package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements TJAdUnit.TJAdUnitVideoListener {
    public final /* synthetic */ TJCorePlacement a;

    public s(TJCorePlacement tJCorePlacement) {
        this.a = tJCorePlacement;
    }

    @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
    public final void onVideoCompleted() {
        TJPlacement tJPlacementA = this.a.a("SHOW");
        if (tJPlacementA == null || tJPlacementA.getVideoListener() == null) {
            return;
        }
        tJPlacementA.getVideoListener().onVideoComplete(tJPlacementA);
    }

    @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
    public final void onVideoError(String str) {
        TJPlacement tJPlacementA = this.a.a("SHOW");
        if (tJPlacementA == null || tJPlacementA.getVideoListener() == null) {
            return;
        }
        tJPlacementA.getVideoListener().onVideoError(tJPlacementA, str);
    }

    @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
    public final void onVideoStart() {
        TJPlacement tJPlacementA = this.a.a("SHOW");
        if (tJPlacementA == null || tJPlacementA.getVideoListener() == null) {
            return;
        }
        tJPlacementA.getVideoListener().onVideoStart(tJPlacementA);
    }
}
