package com.tapjoy.internal;

import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class d8 implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tapjoy.c f2744b;

    public d8(com.tapjoy.c cVar, boolean z) {
        this.f2744b = cVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitActivity tJAdUnitActivity = this.f2744b.a.d;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setCloseButtonVisibility(this.a);
        } else {
            TapjoyLog.d("TJAdUnit", "Cannot setCloseButtonVisible -- TJAdUnitActivity is null");
        }
    }
}
