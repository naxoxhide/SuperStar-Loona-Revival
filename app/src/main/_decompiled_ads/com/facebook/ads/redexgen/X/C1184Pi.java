package com.facebook.ads.redexgen.X;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1184Pi extends ContentObserver {
    public final C1190Po A00;

    public C1184Pi(Handler handler, C1190Po c1190Po) {
        super(handler);
        this.A00 = c1190Po;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.A00.A0Z();
    }
}
