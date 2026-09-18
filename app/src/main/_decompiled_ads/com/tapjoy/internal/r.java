package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;

/* JADX INFO: loaded from: classes4.dex */
public final class r extends o7 {
    @Override // com.tapjoy.internal.o7
    public final TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
        return TJPlacementManager.createPlacement(context, "AppLaunch", true, tJPlacementListener);
    }

    @Override // com.tapjoy.internal.o7
    public final /* bridge */ /* synthetic */ String a(Object obj) {
        return "AppLaunch";
    }

    @Override // com.tapjoy.internal.o7
    public final boolean a() {
        if (super.a()) {
            f6 f6Var = f6.a;
            if (!(f6Var != null && f6Var.a())) {
                return true;
            }
        }
        return false;
    }
}
