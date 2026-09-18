package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1118Mu implements View.OnClickListener {
    public static byte[] A02;
    public final /* synthetic */ YA A00;
    public final /* synthetic */ C1120Mw A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, 20, 33, 18, 20, 22, 39, 28, 41, 28, 39, 44, -60, -47, -57, -43, -46, -52, -57, -111, -52, -47, -41, -56, -47, -41, -111, -60, -58, -41, -52, -46, -47, -111, -71, -84, -88, -70};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.A01.A06) && !A00(0, 11, 35).equals(this.A01.A06)) {
                Intent intent = new Intent(A00(22, 26, 33), C1050Kc.A00(this.A01.A06));
                intent.addFlags(268435456);
                this.A00.A0E().A8W();
                try {
                    KN.A0B(this.A00, intent);
                } catch (KL e) {
                    Throwable cause = e.getCause();
                    KL cause2 = e;
                    if (cause != null) {
                        cause2 = e.getCause();
                    }
                    this.A00.A07().A9M(A00(11, 11, 113), C07597x.A00, new C07607y(cause2));
                }
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }

    public ViewOnClickListenerC1118Mu(C1120Mw c1120Mw, YA ya) {
        this.A01 = c1120Mw;
        this.A00 = ya;
    }
}
