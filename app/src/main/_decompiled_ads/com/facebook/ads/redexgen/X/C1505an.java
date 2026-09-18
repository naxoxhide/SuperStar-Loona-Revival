package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.an, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1505an implements OW {
    public final /* synthetic */ C1502ak A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.OW
    public final void A97() {
        String strA00 = this.A00.A02.A0z().A00();
        if (TextUtils.isEmpty(strA00)) {
            return;
        }
        KZ.A0L(new KZ(), this.A00.A03, C1050Kc.A00(strA00), this.A00.A6N());
    }

    public C1505an(C1502ak c1502ak) {
        this.A00 = c1502ak;
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void ABE(AnonymousClass95 anonymousClass95) {
        new Handler(Looper.getMainLooper()).postDelayed(new C1506ao(this, anonymousClass95), 1L);
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void ABT() {
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void ADB(View view, MotionEvent motionEvent) {
    }
}
