package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TW implements InterfaceC1060Km {
    public static byte[] A01;
    public static String[] A02 = {"XQ6pDaA1rZEM", "XoeGOYiSv0w2M1U1qXC2kK0WxpTFbq6C", "goNPtYs5sZFfNSJyOgs171oDuCl7t69H", "IBRmsKraW8ihcuaNuynFKjmRlH", "udOMyB", "k9bLdXox5SSCuqwZoRmzAy5kJm", "rLCACxpviKCtWgunDsmekf59Ef0kXw8R", "IiDilnQTvcIperbA6lCpmy3utrrmGEhT"};
    public final /* synthetic */ TU A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-32, -8, -22, -24, -8, -30};
    }

    static {
        A01();
    }

    public TW(TU tu) {
        this.A00 = tu;
    }

    public /* synthetic */ TW(TU tu, C1282Tc c1282Tc) {
        this(tu);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1060Km
    public final void AAv() {
        this.A00.A0Y.setToolbarActionMessage(A00(0, 0, 7));
        this.A00.A0J();
        if (this.A00.A0V && this.A00.A0Y()) {
            this.A00.A0Y.setToolbarActionMode(1);
        } else {
            this.A00.A0Y.setToolbarActionMode(0);
        }
        boolean z = this.A00.A0W;
        if (A02[4].length() != 6) {
            throw new RuntimeException();
        }
        A02[4] = "RNuzR8";
        if (!z) {
            LV.A0U(this.A00, 500);
            if (this.A00.A06 != null) {
                LV.A0N(this.A00.A06, 0);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1060Km
    public final void ACZ(float f) {
        float fA03;
        this.A00.A0Q((int) f);
        if (!this.A00.A0X) {
            float percentage = 1.0f - (f / this.A00.A0H.A07());
            this.A00.A0Y.setProgress(100.0f * percentage);
            return;
        }
        if (this.A00.A0C) {
            fA03 = 1.0f - (f / this.A00.A0G.A0v().A0D().A02());
            if (this.A00.A0F || fA03 < 1.0f) {
                this.A00.A0F = false;
                String strA02 = this.A00.A0G.A10().A02();
                String[] strArr = A02;
                if (strArr[1].charAt(20) != strArr[6].charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[0] = "16sMGD3KF8iI";
                strArr2[5] = "yItCOMUcMHVXea4ql8lykvs7qx";
                String rewardMessage = strA02.replace(A00(0, 6, 65), String.valueOf((int) f));
                this.A00.A0Y.setToolbarActionMessage(rewardMessage);
            } else {
                this.A00.A0F = true;
                this.A00.A0Y.setToolbarActionMessage(A00(0, 0, 7));
            }
        } else {
            fA03 = 1.0f - (f / this.A00.A0G.A0v().A0D().A03());
        }
        this.A00.A0Y.setProgress(100.0f * fA03);
        float fA02 = this.A00.A0G.A0v().A0D().A02() - f;
        float percentageOfReward = this.A00.A0G.A0v().A0D().A03();
        boolean z = fA02 >= percentageOfReward;
        if (!this.A00.A0F && z) {
            this.A00.A0Y.setToolbarActionMode(1);
        }
    }
}
