package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2O, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2O extends ED {
    public C2O(YA ya) {
        super(ya);
        setCarouselLayoutManager(ya);
    }

    public C1253Rz getFullscreenCarouselRecyclerViewAdapter() {
        if (getAdapter() instanceof C1253Rz) {
            return (C1253Rz) getAdapter();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.ED
    public ZC getLayoutManager() {
        return (ZC) super.getLayoutManager();
    }

    public AbstractC06774h getOnScrollListener() {
        return new C1289Tk(this);
    }

    private void setCarouselLayoutManager(YA ya) {
        ZC zc = new ZC(ya, 0, false);
        if (Build.VERSION.SDK_INT >= 24) {
            zc.A1V(true);
        }
        super.setLayoutManager(zc);
    }

    @Override // com.facebook.ads.redexgen.X.ED
    public void setLayoutManager(AbstractC06724c abstractC06724c) {
    }
}
