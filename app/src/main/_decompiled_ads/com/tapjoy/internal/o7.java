package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o7 {
    public volatile n7 a;

    public abstract TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj);

    public abstract String a(Object obj);

    public boolean a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    public n7 b() {
        return new n7(this, new ma(10000L));
    }

    public final boolean c() {
        if (!a()) {
            return false;
        }
        n7 n7VarB = null;
        synchronized (this) {
            if (this.a == null) {
                n7VarB = b();
                this.a = n7VarB;
            }
        }
        if (n7VarB == null) {
            return false;
        }
        n7VarB.a();
        return true;
    }

    public boolean a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            j3 j3Var = k3.e;
            j3Var.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            j3Var.deleteObserver(observer);
        }
        v1 v1Var = v1.m;
        y6 y6Var = v1Var.g;
        if (!(y6Var != null && y6Var.f2834b.get())) {
            j3 j3Var2 = k3.c;
            j3Var2.addObserver(observer);
            y6 y6Var2 = v1Var.g;
            if (!(y6Var2 != null && y6Var2.f2834b.get())) {
                return false;
            }
            j3Var2.deleteObserver(observer);
        }
        return true;
    }

    public final void a(n7 n7Var) {
        synchronized (this) {
            if (this.a == n7Var) {
                this.a = null;
            }
        }
    }
}
