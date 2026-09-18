package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class z9 extends TJConnectListener {
    public final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJConnectListener f2843b;
    public final /* synthetic */ com.tapjoy.e0 c;

    public z9(com.tapjoy.e0 e0Var, Context context, fa faVar) {
        this.c = e0Var;
        this.a = context;
        this.f2843b = faVar;
    }

    @Override // com.tapjoy.TJConnectListener, com.tapjoy.TJConnectInterface
    public final void onConnectFailure(int i, String str) {
        TJConnectListener tJConnectListener = this.f2843b;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure(i, str);
            this.f2843b.onConnectFailure();
        }
    }

    @Override // com.tapjoy.TJConnectListener, com.tapjoy.TJConnectInterface
    public final void onConnectSuccess() {
        this.c.e = new TJCurrency(this.a);
        com.tapjoy.e0 e0Var = this.c;
        new TapjoyCache(this.a);
        e0Var.getClass();
        try {
            TJEventOptimizer.init(this.a);
            this.c.a = true;
            TJConnectListener tJConnectListener = this.f2843b;
            if (tJConnectListener != null) {
                tJConnectListener.onConnectSuccess();
            }
        } catch (InterruptedException e) {
            onConnectFailure(2, e.getMessage());
        } catch (RuntimeException e2) {
            TapjoyLog.w("TapjoyAPI", e2.getMessage());
            onConnectFailure(2, e2.getMessage());
        }
    }
}
