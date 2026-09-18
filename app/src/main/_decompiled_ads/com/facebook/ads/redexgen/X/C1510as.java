package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.as, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1510as extends K8 {
    public static byte[] A02;
    public final /* synthetic */ C05890v A00;
    public final /* synthetic */ JSONObject A01;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{7, 19, 4, 16, 20, 4, 15, 2, 24, 62, 2, 0, 17, 17, 8, 15, 6};
    }

    public C1510as(C05890v c05890v, JSONObject jSONObject) {
        this.A00 = c05890v;
        this.A01 = jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        try {
            this.A00.A05.await();
            synchronized (this.A00.A02) {
                try {
                    this.A00.A02.A0B(this.A01);
                    this.A00.A06.countDown();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (InterruptedException e) {
            this.A00.A03.A07().A9M(A00(0, 17, 116), C07597x.A1B, new C07607y(e));
        } catch (JSONException e2) {
            this.A00.A0M();
            this.A00.A03.A07().A9M(A00(0, 17, 116), C07597x.A1A, new C07607y(e2));
        }
    }
}
