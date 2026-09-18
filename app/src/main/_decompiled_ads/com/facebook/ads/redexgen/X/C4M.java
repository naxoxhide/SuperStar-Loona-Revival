package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4M {
    public static byte[] A03;
    public int A00;
    public final Rect A01;
    public final AbstractC06724c A02;

    static {
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{84, 83, 75, 92, 81, 84, 89, 29, 82, 79, 84, 88, 83, 73, 92, 73, 84, 82, 83};
    }

    public abstract int A06();

    public abstract int A07();

    public abstract int A08();

    public abstract int A09();

    public abstract int A0A();

    public abstract int A0B();

    public abstract int A0C(View view);

    public abstract int A0D(View view);

    public abstract int A0E(View view);

    public abstract int A0F(View view);

    public abstract int A0G(View view);

    public abstract int A0H(View view);

    public abstract void A0J(int i);

    public C4M(AbstractC06724c abstractC06724c) {
        this.A00 = Integer.MIN_VALUE;
        this.A01 = new Rect();
        this.A02 = abstractC06724c;
    }

    public /* synthetic */ C4M(AbstractC06724c abstractC06724c, ZA za) {
        this(abstractC06724c);
    }

    public static ZA A00(AbstractC06724c abstractC06724c) {
        return new ZA(abstractC06724c);
    }

    public static Z9 A01(AbstractC06724c abstractC06724c) {
        return new Z9(abstractC06724c);
    }

    public static C4M A02(AbstractC06724c abstractC06724c, int i) {
        switch (i) {
            case 0:
                return A00(abstractC06724c);
            case 1:
                return A01(abstractC06724c);
            default:
                throw new IllegalArgumentException(A03(0, 19, 11));
        }
    }

    public final int A05() {
        if (Integer.MIN_VALUE == this.A00) {
            return 0;
        }
        return A0B() - this.A00;
    }

    public final void A0I() {
        this.A00 = A0B();
    }
}
