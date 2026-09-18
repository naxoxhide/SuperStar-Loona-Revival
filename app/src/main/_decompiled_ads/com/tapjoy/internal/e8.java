package com.tapjoy.internal;

import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class e8 implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tapjoy.c f2751b;

    public e8(com.tapjoy.c cVar, boolean z) {
        this.f2751b = cVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJAdUnitActivity tJAdUnitActivity = this.f2751b.a.d;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setCloseButtonClickable(this.a);
        } else {
            TapjoyLog.d("TJAdUnit", "Cannot setCloseButtonClickable -- TJAdUnitActivity is null");
        }
    }
}
