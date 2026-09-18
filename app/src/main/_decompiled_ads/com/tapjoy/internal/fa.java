package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;

/* JADX INFO: loaded from: classes4.dex */
public final class fa extends TJConnectListener {
    public final /* synthetic */ aa a;

    public fa(aa aaVar) {
        this.a = aaVar;
    }

    @Override // com.tapjoy.TJConnectListener, com.tapjoy.TJConnectInterface
    public final void onConnectFailure(int i, String str) {
        this.a.a(i, str);
    }

    @Override // com.tapjoy.TJConnectListener, com.tapjoy.TJConnectInterface
    public final void onConnectSuccess() {
        this.a.a(5);
        this.a.a();
    }
}
