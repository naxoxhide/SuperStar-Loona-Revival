package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.40, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass40 {
    public static byte[] A03;
    public static String[] A04 = {"QoGKHhEqLDc7cPbroRD", "LQzzwNJ4o6QHlfYkxXGOUA5ejYw8qpDj", "6ipC3ASGLl4rMOedI", "OPBJh0aCf", "l4bQelOwEyQeTpTSi", "DWBJmVB67PV4ItRyT2e9caL16z1NK91I", "0G1mJvoVA", "nRnK55wdJbrp31Rh0MWe0TNMbF4aeg8Y"};
    public final InterfaceC06693z A01;
    public final C06683y A00 = new C06683y();
    public final List<View> A02 = new ArrayList();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        A04[1] = "YzFnrN17WwgSKMGcQI3u7PJ5Pdf81qGi";
        A03 = new byte[]{-81, -93, -21, -20, -25, -25, -24, -15, -93, -17, -20, -10, -9, -67, -23, -25, -18, -34, -29, -36, -107, -23, -28, -107, -22, -29, -35, -34, -39, -38, -107, -42, -107, -21, -34, -38, -20, -107, -23, -35, -42, -23, -107, -20, -42, -24, -107, -29, -28, -23, -107, -35, -34, -39, -39, -38, -29, -35, -48, -52, -34, -121, -48, -38, -121, -43, -42, -37, -121, -56, -121, -54, -49, -48, -45, -53, -109, -121, -54, -56, -43, -43, -42, -37, -121, -49, -48, -53, -52, -121};
    }

    static {
        A02();
    }

    public AnonymousClass40(InterfaceC06693z interfaceC06693z) {
        this.A01 = interfaceC06693z;
    }

    private int A00(int i) {
        if (i < 0) {
            return -1;
        }
        int offset = this.A01.A6I();
        int limit = i;
        while (limit < offset) {
            int iA03 = i - (limit - this.A00.A03(limit));
            if (iA03 == 0) {
                while (this.A00.A08(limit)) {
                    limit++;
                }
                return limit;
            }
            limit += iA03;
        }
        return -1;
    }

    private void A03(View view) {
        this.A02.add(view);
        this.A01.ABG(view);
    }

    private boolean A04(View view) {
        if (this.A02.remove(view)) {
            this.A01.ABn(view);
            return true;
        }
        return false;
    }

    public final int A05() {
        return this.A01.A6I() - this.A02.size();
    }

    public final int A06() {
        return this.A01.A6I();
    }

    public final int A07(View view) {
        int iA8d = this.A01.A8d(view);
        if (iA8d == -1 || this.A00.A08(iA8d)) {
            return -1;
        }
        int index = this.A00.A03(iA8d);
        return iA8d - index;
    }

    public final View A08(int i) {
        int size = this.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.A02.get(i2);
            AbstractC06894u abstractC06894uA6L = this.A01.A6L(view);
            int count = abstractC06894uA6L.A0I();
            if (count == i && !abstractC06894uA6L.A0b() && !abstractC06894uA6L.A0c()) {
                return view;
            }
        }
        return null;
    }

    public final View A09(int i) {
        return this.A01.A6H(A00(i));
    }

    public final View A0A(int i) {
        return this.A01.A6H(i);
    }

    public final void A0B() {
        this.A00.A04();
        for (int size = this.A02.size() - 1; size >= 0; size--) {
            this.A01.ABn(this.A02.get(size));
            this.A02.remove(size);
        }
        this.A01.AEW();
    }

    public final void A0C(int i) {
        int iA00 = A00(i);
        this.A00.A09(iA00);
        this.A01.A52(iA00);
    }

    public final void A0D(int i) {
        int iA00 = A00(i);
        View view = this.A01.A6H(iA00);
        if (view == null) {
            return;
        }
        if (this.A00.A09(iA00)) {
            A04(view);
        }
        this.A01.AEa(iA00);
        if (A04[4].length() == 16) {
            throw new RuntimeException();
        }
        A04[7] = "KJlsfCUfVwwQNNRDjM0AzdkkAy1m1QjD";
    }

    public final void A0E(View view) {
        int iA8d = this.A01.A8d(view);
        if (iA8d >= 0) {
            this.A00.A06(iA8d);
            A03(view);
            return;
        }
        throw new IllegalArgumentException(A01(57, 33, 25) + view);
    }

    public final void A0F(View view) {
        int iA8d = this.A01.A8d(view);
        if (iA8d < 0) {
            return;
        }
        if (this.A00.A09(iA8d)) {
            A04(view);
        }
        this.A01.AEa(iA8d);
    }

    public final void A0G(View view) {
        int iA8d = this.A01.A8d(view);
        if (iA8d >= 0) {
            if (this.A00.A08(iA8d)) {
                this.A00.A05(iA8d);
                A04(view);
                return;
            }
            throw new RuntimeException(A01(14, 43, 39) + view);
        }
        throw new IllegalArgumentException(A01(57, 33, 25) + view);
    }

    public final void A0H(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iA00;
        if (i < 0) {
            iA00 = this.A01.A6I();
        } else {
            iA00 = A00(i);
        }
        C06683y c06683y = this.A00;
        if (A04[5].charAt(2) != 'B') {
            throw new RuntimeException();
        }
        A04[1] = "KHr0McsaN13zWmBdzhmfm62h5mt8zSB0";
        c06683y.A07(iA00, z);
        if (z) {
            A03(view);
        }
        this.A01.A3a(view, iA00, layoutParams);
    }

    public final void A0I(View view, int i, boolean z) {
        int iA00;
        if (i < 0) {
            iA00 = this.A01.A6I();
        } else {
            iA00 = A00(i);
        }
        this.A00.A07(iA00, z);
        if (z) {
            A03(view);
        }
        this.A01.addView(view, iA00);
    }

    public final void A0J(View view, boolean z) {
        A0I(view, -1, z);
    }

    public final boolean A0K(View view) {
        return this.A02.contains(view);
    }

    public final boolean A0L(View view) {
        int iA8d = this.A01.A8d(view);
        if (iA8d == -1) {
            A04(view);
            if (A04[5].charAt(2) != 'B') {
                throw new RuntimeException();
            }
            A04[0] = "HipCYWSrBpzIS13Odtj";
            return true;
        }
        if (this.A00.A08(iA8d)) {
            this.A00.A09(iA8d);
            A04(view);
            this.A01.AEa(iA8d);
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.A00.toString() + A01(0, 14, 53) + this.A02.size();
    }
}
