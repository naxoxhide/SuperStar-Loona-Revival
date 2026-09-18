package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class w8 implements Runnable {
    public final /* synthetic */ Context a;

    public w8(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            TJEventOptimizer.f2692b = new TJEventOptimizer(this.a);
        } catch (Exception e) {
            TapjoyLog.w("TJEventOptimizer", e.getMessage());
        }
        TJEventOptimizer.c.countDown();
    }
}
