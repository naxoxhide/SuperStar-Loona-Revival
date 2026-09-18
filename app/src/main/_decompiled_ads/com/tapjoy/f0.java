package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2725b;

    public f0(int i, String str) {
        this.a = i;
        this.f2725b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TJConnectListener tJConnectListener = TapjoyConnectCore.g;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure(this.a, this.f2725b);
            TapjoyConnectCore.g.onConnectFailure();
        }
    }
}
