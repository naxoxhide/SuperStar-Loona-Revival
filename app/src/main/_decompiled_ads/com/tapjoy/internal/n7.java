package com.tapjoy.internal;

import android.os.SystemClock;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class n7 implements Observer, TJPlacementListener {
    public final Object a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ma f2787b;
    public volatile boolean c;
    public TJPlacement d;
    public final /* synthetic */ o7 e;

    public n7(o7 o7Var, ma maVar) {
        this.e = o7Var;
        this.f2787b = maVar;
    }

    public final void a() {
        boolean z;
        synchronized (this) {
            if (this.c) {
                return;
            }
            ma maVar = this.f2787b;
            maVar.getClass();
            try {
                z = SystemClock.elapsedRealtime() - maVar.f2784b > maVar.a;
            } catch (NullPointerException unused) {
            }
            if (z) {
                a("Timed out");
                return;
            }
            if (!TapjoyConnectCore.isConnected()) {
                j3 j3Var = k3.a;
                j3Var.addObserver(this);
                if (!TapjoyConnectCore.isConnected()) {
                    return;
                } else {
                    j3Var.deleteObserver(this);
                }
            }
            TJPlacement tJPlacement = this.d;
            if (tJPlacement == null) {
                if (!this.e.a()) {
                    a("Cannot request");
                    return;
                }
                TJPlacement tJPlacementA = this.e.a(TapjoyConnectCore.getContext(), this, this.a);
                this.d = tJPlacementA;
                tJPlacementA.requestContent();
                return;
            }
            if (tJPlacement.isContentReady()) {
                if (this.e.a((Observer) this)) {
                    this.d.showContent();
                    a(null);
                }
            }
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onClick(TJPlacement tJPlacement) {
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onContentDismiss(TJPlacement tJPlacement) {
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onContentReady(TJPlacement tJPlacement) {
        a();
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onContentShow(TJPlacement tJPlacement) {
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
        a(tJError.message);
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onRequestSuccess(TJPlacement tJPlacement) {
    }

    @Override // com.tapjoy.TJPlacementListener
    public final void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        a();
    }

    public final void a(String str) {
        synchronized (this) {
            String strA = this.e.a(this.a);
            if (str == null) {
                TapjoyLog.i("SystemPlacement", "Placement " + strA + " is presented now");
            } else {
                TapjoyLog.i("SystemPlacement", "Cannot show placement " + strA + " now (" + str + ")");
            }
            this.c = true;
            this.d = null;
            k3.a.deleteObserver(this);
            k3.e.deleteObserver(this);
            k3.c.deleteObserver(this);
        }
        this.e.a(this);
    }
}
