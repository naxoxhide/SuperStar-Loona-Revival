package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class r7 implements Runnable {
    public final /* synthetic */ TJAdUnit a;

    public r7(TJAdUnit tJAdUnit) {
        this.a = tJAdUnit;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int streamVolume = this.a.p.getStreamVolume(3);
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit.q != streamVolume) {
            tJAdUnit.q = streamVolume;
            tJAdUnit.e.onVolumeChanged();
        }
    }
}
