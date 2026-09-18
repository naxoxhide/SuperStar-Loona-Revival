package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YX implements InterfaceC06151v {
    public static byte[] A03;
    public C06955a A00;
    public YA A01;
    public final NativeAdBase.MediaCacheFlag A02;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{59, 52, 33, 60, 35, 48, 100, 127, 122, 127, 126, 102, 127};
    }

    public YX(C06955a c06955a, YA ya, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = c06955a;
        this.A01 = ya;
        this.A02 = mediaCacheFlag;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06151v
    public final void ABH(JG jg) {
        C1047Jz.A00(new C1406Ya(this, jg));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06151v
    public final void ACD(List<C1499ah> list) {
        C6Q manager = new C6Q(this.A01);
        String firstRequestId = A02(6, 7, 70);
        for (C1499ah c1499ah : list) {
            if (A02(6, 7, 70).equals(firstRequestId)) {
                firstRequestId = c1499ah.A0G();
            }
            if (this.A02.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                if (c1499ah.A0E().A0G() != null) {
                    manager.A0b(new C6O(c1499ah.A0E().A0G().getUrl(), c1499ah.A0E().A0G().getHeight(), c1499ah.A0E().A0G().getWidth(), c1499ah.A0G(), A02(0, 6, 2)));
                }
                if (c1499ah.A0E().A0F() != null) {
                    manager.A0b(new C6O(c1499ah.A0E().A0F().getUrl(), c1499ah.A0E().A0F().getHeight(), c1499ah.A0E().A0F().getWidth(), c1499ah.A0G(), A02(0, 6, 2)));
                }
                if (!TextUtils.isEmpty(c1499ah.A0E().A0d())) {
                    manager.A0a(new C6M(c1499ah.A0E().A0d(), c1499ah.A0G(), A02(0, 6, 2), c1499ah.A0E().A0A()));
                }
            }
        }
        manager.A0W(new YY(this, list), new C6J(firstRequestId, A02(0, 6, 2)));
    }
}
