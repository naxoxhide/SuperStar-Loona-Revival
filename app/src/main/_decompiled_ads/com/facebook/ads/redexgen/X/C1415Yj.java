package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.NativeAd;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1415Yj implements OW {
    public final /* synthetic */ NativeAd A00;
    public final /* synthetic */ C1410Ye A01;
    public final /* synthetic */ UJ A02;

    public C1415Yj(C1410Ye c1410Ye, UJ uj, NativeAd nativeAd) {
        this.A01 = c1410Ye;
        this.A02 = uj;
        this.A00 = nativeAd;
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void A97() {
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void ABE(AnonymousClass95 anonymousClass95) {
        new Handler(Looper.getMainLooper()).postDelayed(new C1416Yk(this, anonymousClass95), 1L);
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void ABT() {
        if (this.A01.A0A != null) {
            this.A01.A0A.A08();
        }
    }

    @Override // com.facebook.ads.redexgen.X.OW
    public final void ADB(View view, MotionEvent motionEvent) throws Throwable {
        this.A02.A19().A06(this.A01.A07, motionEvent, view, view);
        if (motionEvent.getAction() == 1 && !this.A01.A0J(this.A00) && this.A02.A12() != null) {
            this.A02.A12().onClick(view);
        }
    }
}
