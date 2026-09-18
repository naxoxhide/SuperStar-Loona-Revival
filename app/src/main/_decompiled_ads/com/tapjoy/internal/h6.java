package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class h6 extends o7 {
    @Override // com.tapjoy.internal.o7
    public final boolean a() {
        return true;
    }

    @Override // com.tapjoy.internal.o7
    public final n7 b() {
        throw null;
    }

    @Override // com.tapjoy.internal.o7
    public final TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
        g6.a(obj);
        TapjoyConnectCore.getContext();
        throw null;
    }

    @Override // com.tapjoy.internal.o7
    public final /* bridge */ /* synthetic */ String a(Object obj) {
        g6.a(obj);
        return null;
    }

    @Override // com.tapjoy.internal.o7
    public final boolean a(Observer observer) {
        if (TapjoyConnectCore.isViewOpen()) {
            TJPlacementManager.dismissContentShowing(true);
        }
        return super.a(observer);
    }
}
