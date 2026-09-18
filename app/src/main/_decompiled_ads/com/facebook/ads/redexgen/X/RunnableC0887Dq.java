package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0887Dq implements Runnable {
    public static byte[] A02;
    public final /* synthetic */ C0895Dy A00;
    public final /* synthetic */ DownloadAction[] A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{30, 53, 45, 52, 54, 53, 59, 62, 23, 59, 52, 59, Base64.padSymbol, 63, 40, 105, 92, 75, 74, 80, 74, 77, 80, 87, 94, 25, 88, 90, 77, 80, 86, 87, 74, 25, 95, 88, 80, 85, 92, 93, 23};
    }

    public RunnableC0887Dq(C0895Dy c0895Dy, DownloadAction[] downloadActionArr) {
        this.A00 = c0895Dy;
        this.A01 = downloadActionArr;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            try {
                this.A00.A09.A02(this.A01);
            } catch (IOException e) {
                Log.e(A00(0, 15, 36), A00(15, 26, 71), e);
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
