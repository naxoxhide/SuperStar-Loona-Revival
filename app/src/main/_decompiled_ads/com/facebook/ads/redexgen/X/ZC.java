package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZC extends AbstractC06724c implements InterfaceC06834o {
    public static byte[] A0F;
    public static String[] A0G = {"VKH6HNPW", "5SG7ZkmA1SrYT5HpW6e3lHPIEdQjCnoY", "GUFAcNFlkHbDslOxTlAKu2zM5da70L8W", "8EarDdUd0wjX", "ogiAdIZLqFL2ODTGKcli7xbzAuQZVFku", "k0c9canuweazyFazM74f3pFcokchiBr", "yJQv9VjGutzUoxdr6", "vBYUiSK7FkagYmvZS"};
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public C4M A04;
    public boolean A05;
    public int A06;
    public C4H A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C4F A0D;
    public final C4G A0E;

    public static String A0T(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0V() {
        A0F = new byte[]{30, 25, 1, 22, 27, 30, 19, 87, 24, 5, 30, 18, 25, 3, 22, 3, 30, 24, 25, 77};
    }

    static {
        A0V();
    }

    public ZC(Context context) {
        this(context, 1, false);
    }

    public ZC(Context context, int i, boolean z) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C4F(this);
        this.A0E = new C4G();
        this.A06 = 2;
        A2E(i);
        A0h(z);
        A1V(true);
    }

    private final int A04(int i, C06794k c06794k, C06864r c06864r) {
        if (A0W() == 0 || i == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A2D();
        int absDy = i > 0 ? 1 : -1;
        int consumed = Math.abs(i);
        A0Y(absDy, consumed, true, c06864r);
        int i2 = this.A07.A07;
        int layoutDirection = A08(c06794k, this.A07, c06864r, false);
        int i3 = i2 + layoutDirection;
        if (i3 < 0) {
            return 0;
        }
        int absDy2 = consumed > i3 ? absDy * i3 : i;
        int layoutDirection2 = -absDy2;
        this.A04.A0J(layoutDirection2);
        this.A07.A04 = absDy2;
        return absDy2;
    }

    private int A05(int i, C06794k c06794k, C06864r c06864r, boolean z) {
        int gap = this.A04.A07() - i;
        if (gap > 0) {
            int i2 = -A04(-gap, c06794k, c06864r);
            int i3 = i + i2;
            if (z) {
                int iA07 = this.A04.A07();
                int fixOffset = A0G[0].length();
                if (fixOffset == 7) {
                    throw new RuntimeException();
                }
                A0G[0] = "DiKLRwr5Jced9h1IWYQQBSe";
                int i4 = iA07 - i3;
                if (i4 > 0) {
                    this.A04.A0J(i4);
                    return i4 + i2;
                }
            }
            return i2;
        }
        return 0;
    }

    private int A06(int i, C06794k c06794k, C06864r c06864r, boolean z) {
        int iA0A;
        int gap = i - this.A04.A0A();
        if (gap > 0) {
            int i2 = -A04(gap, c06794k, c06864r);
            int i3 = i + i2;
            if (z && (iA0A = i3 - this.A04.A0A()) > 0) {
                this.A04.A0J(-iA0A);
                return i2 - iA0A;
            }
            return i2;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:41:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0033 A[EDGE_INSN: B:47:0x0033->B:16:0x0033 BREAK  A[LOOP:0: B:9:0x001d->B:48:0x001d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x001d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x001d A[SYNTHETIC] */
    private final int A08(C06794k c06794k, C4H c4h, C06864r c06864r, boolean z) {
        boolean z2;
        int remainingSpace;
        int i = c4h.A00;
        int start = c4h.A07;
        if (start != Integer.MIN_VALUE) {
            int start2 = c4h.A00;
            if (start2 < 0) {
                int i2 = c4h.A07;
                int start3 = c4h.A00;
                c4h.A07 = i2 + start3;
            }
            A0e(c06794k, c4h);
        }
        int i3 = c4h.A00;
        int start4 = c4h.A02;
        int i4 = i3 + start4;
        C4G c4g = this.A0E;
        while (true) {
            if ((!c4h.A09 && i4 <= 0) || !c4h.A05(c06864r)) {
                break;
            }
            c4g.A00();
            A2H(c06794k, c06864r, c4h, c4g);
            if (c4g.A01) {
                break;
            }
            int i5 = c4h.A06;
            int remainingSpace2 = c4g.A00;
            int start5 = c4h.A05;
            c4h.A06 = i5 + (remainingSpace2 * start5);
            if (!c4g.A03 || this.A07.A08 != null || !c06864r.A07()) {
                int remainingSpace3 = c4h.A00;
                int start6 = c4g.A00;
                c4h.A00 = remainingSpace3 - start6;
                int start7 = c4g.A00;
                i4 -= start7;
            }
            int start8 = c4h.A07;
            if (start8 != Integer.MIN_VALUE) {
                int remainingSpace4 = c4h.A07;
                int start9 = c4g.A00;
                c4h.A07 = remainingSpace4 + start9;
                int start10 = c4h.A00;
                if (start10 < 0) {
                    int i6 = c4h.A07;
                    int i7 = c4h.A00;
                    int remainingSpace5 = A0G[0].length();
                    if (remainingSpace5 != 7) {
                        A0G[5] = "4Yaap7YPoeEmBfNVznjneaOXF1T3Chf";
                        c4h.A07 = i6 + i7;
                    }
                }
                A0e(c06794k, c4h);
                if (z) {
                    z2 = c4g.A02;
                    remainingSpace = A0G[0].length();
                    if (remainingSpace != 7) {
                        A0G[1] = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov";
                        if (z2) {
                            break;
                        }
                    }
                }
            } else if (z) {
                z2 = c4g.A02;
                remainingSpace = A0G[0].length();
                if (remainingSpace != 7) {
                    A0G[1] = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov";
                    if (z2) {
                        break;
                        break;
                    }
                }
            }
            throw new RuntimeException();
        }
        int start11 = c4h.A00;
        return i - start11;
    }

    private int A09(C06864r c06864r) {
        if (A0W() != 0) {
            A2D();
            return C06904v.A00(c06864r, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        }
        if (A0G[5].length() != 31) {
            throw new RuntimeException();
        }
        A0G[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
        return 0;
    }

    private int A0A(C06864r c06864r) {
        if (A0W() == 0) {
            return 0;
        }
        A2D();
        return C06904v.A02(c06864r, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B, this.A05);
    }

    private int A0B(C06864r c06864r) {
        if (A0W() != 0) {
            A2D();
            return C06904v.A01(c06864r, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[2] = "SnDsIEYZVkVP365fclIsQ2wSHS1GnuqA";
        strArr2[4] = "cd1sjhoNq3y2dBxKlbos6To2J3BafTHs";
        return 0;
    }

    private final int A0C(C06864r c06864r) {
        if (c06864r.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0D() {
        return A0H(0, A0W());
    }

    private View A0E() {
        return A0H(A0W() - 1, -1);
    }

    private View A0F() {
        return A0t(this.A05 ? 0 : A0W() - 1);
    }

    private View A0G() {
        return A0t(this.A05 ? A0W() - 1 : 0);
    }

    private final View A0H(int i, int i2) {
        int next;
        int acceptableBoundsFlag;
        int preferredBoundsFlag;
        A2D();
        if (i2 > i) {
            next = 1;
        } else {
            next = i2 < i ? -1 : 0;
        }
        if (next == 0) {
            View viewA0t = A0t(i);
            String[] strArr = A0G;
            String str = strArr[6];
            String str2 = strArr[7];
            int length = str.length();
            int next2 = str2.length();
            if (length != next2) {
                throw new RuntimeException();
            }
            A0G[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            return viewA0t;
        }
        int preferredBoundsFlag2 = this.A04.A0F(A0t(i));
        int next3 = this.A04.A0A();
        if (preferredBoundsFlag2 < next3) {
            acceptableBoundsFlag = 16644;
            preferredBoundsFlag = 16388;
        } else {
            acceptableBoundsFlag = 4161;
            preferredBoundsFlag = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        int next4 = this.A00;
        if (next4 == 0) {
            return super.A04.A00(i, i2, acceptableBoundsFlag, preferredBoundsFlag);
        }
        return super.A05.A00(i, i2, acceptableBoundsFlag, preferredBoundsFlag);
    }

    private final View A0J(int i, int i2, boolean z, boolean z2) {
        int i3;
        A2D();
        int i4 = 0;
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (z2) {
            i4 = 320;
        }
        int i5 = this.A00;
        int acceptableBoundsFlag = A0G[1].charAt(30);
        if (acceptableBoundsFlag != 111) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "NnwW0AnvRBQDKBAe7Vp9NN4SqY6y39Zg";
        strArr[4] = "snWQRfIRwdJNOSPMdDWVpUmegwlUrdsl";
        if (i5 == 0) {
            return super.A04.A00(i, i2, i3, i4);
        }
        return super.A05.A00(i, i2, i3, i4);
    }

    private View A0K(C06794k c06794k, C06864r c06864r) {
        return A2C(c06794k, c06864r, 0, A0W(), c06864r.A03());
    }

    private View A0L(C06794k c06794k, C06864r c06864r) {
        return A2C(c06794k, c06864r, A0W() - 1, -1, c06864r.A03());
    }

    private View A0M(C06794k c06794k, C06864r c06864r) {
        return this.A05 ? A0D() : A0E();
    }

    private View A0N(C06794k c06794k, C06864r c06864r) {
        return this.A05 ? A0E() : A0D();
    }

    private View A0O(C06794k c06794k, C06864r c06864r) {
        return this.A05 ? A0K(c06794k, c06864r) : A0L(c06794k, c06864r);
    }

    private View A0P(C06794k c06794k, C06864r c06864r) {
        return this.A05 ? A0L(c06794k, c06864r) : A0K(c06794k, c06864r);
    }

    private View A0Q(boolean z, boolean z2) {
        if (this.A05) {
            return A0J(0, A0W(), z, z2);
        }
        return A0J(A0W() - 1, -1, z, z2);
    }

    private View A0R(boolean z, boolean z2) {
        if (this.A05) {
            return A0J(A0W() - 1, -1, z, z2);
        }
        return A0J(0, A0W(), z, z2);
    }

    private final C4H A0S() {
        return new C4H();
    }

    private void A0U() {
        if (this.A00 == 1 || !A2J()) {
            this.A05 = this.A0A;
            return;
        }
        boolean z = !this.A0A;
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[6] = "rvopS3hSB7itRsuyG";
        strArr2[7] = "9RTUShXs4ZXrU4n03";
        this.A05 = z;
    }

    private void A0W(int i, int i2) {
        this.A07.A00 = this.A04.A07() - i2;
        this.A07.A03 = this.A05 ? -1 : 1;
        this.A07.A01 = i;
        this.A07.A05 = 1;
        this.A07.A06 = i2;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0X(int i, int i2) {
        this.A07.A00 = i2 - this.A04.A0A();
        this.A07.A01 = i;
        this.A07.A03 = this.A05 ? 1 : -1;
        this.A07.A05 = -1;
        this.A07.A06 = i2;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0Y(int i, int i2, boolean z, C06864r c06864r) {
        int iA0A;
        this.A07.A09 = A0i();
        this.A07.A02 = A0C(c06864r);
        this.A07.A05 = i;
        int i3 = -1;
        if (i == 1) {
            this.A07.A02 += this.A04.A08();
            View viewA0F = A0F();
            C4H c4h = this.A07;
            if (!this.A05) {
                i3 = 1;
            }
            c4h.A03 = i3;
            this.A07.A01 = A0p(viewA0F) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(viewA0F);
            iA0A = this.A04.A0C(viewA0F) - this.A04.A07();
        } else {
            View viewA0G = A0G();
            this.A07.A02 += this.A04.A0A();
            this.A07.A03 = this.A05 ? 1 : -1;
            this.A07.A01 = A0p(viewA0G) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(viewA0G);
            iA0A = (-this.A04.A0F(viewA0G)) + this.A04.A0A();
        }
        this.A07.A00 = i2;
        if (z) {
            C4H c4h2 = this.A07;
            int scrollingOffset = c4h2.A00;
            c4h2.A00 = scrollingOffset - iA0A;
        }
        this.A07.A07 = iA0A;
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        A0G[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
    }

    private void A0Z(C4F c4f) {
        A0W(c4f.A01, c4f.A00);
    }

    private void A0a(C4F c4f) {
        A0X(c4f.A01, c4f.A00);
    }

    private void A0b(C06794k c06794k, int i) {
        int iA0W = A0W();
        if (i < 0) {
            return;
        }
        int iA06 = this.A04.A06() - i;
        if (this.A05) {
            for (int i2 = 0; i2 < iA0W; i2++) {
                View viewA0t = A0t(i2);
                int childCount = this.A04.A0F(viewA0t);
                if (childCount >= iA06) {
                    int childCount2 = this.A04.A0H(viewA0t);
                    if (childCount2 >= iA06) {
                    }
                }
                A0d(c06794k, 0, i2);
                return;
            }
            return;
        }
        for (int i3 = iA0W - 1; i3 >= 0; i3--) {
            View viewA0t2 = A0t(i3);
            int childCount3 = this.A04.A0F(viewA0t2);
            if (childCount3 >= iA06) {
                int childCount4 = this.A04.A0H(viewA0t2);
                if (childCount4 >= iA06) {
                }
            }
            int childCount5 = iA0W - 1;
            A0d(c06794k, childCount5, i3);
            return;
        }
    }

    private void A0c(C06794k c06794k, int i) {
        if (i < 0) {
            return;
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[0] = "66";
        int iA0W = A0W();
        if (this.A05) {
            for (int i2 = iA0W - 1; i2 >= 0; i2--) {
                View viewA0t = A0t(i2);
                int limit = this.A04.A0C(viewA0t);
                if (limit <= i) {
                    C4M c4m = this.A04;
                    String[] strArr2 = A0G;
                    String str = strArr2[6];
                    String str2 = strArr2[7];
                    int childCount = str.length();
                    int limit2 = str2.length();
                    if (childCount != limit2) {
                        int limit3 = c4m.A0G(viewA0t);
                        if (limit3 <= i) {
                        }
                    } else {
                        A0G[3] = "uDZbJl3GZvnd0";
                        int limit4 = c4m.A0G(viewA0t);
                        if (limit4 <= i) {
                        }
                    }
                }
                int limit5 = iA0W - 1;
                A0d(c06794k, limit5, i2);
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < iA0W; i3++) {
            View viewA0t2 = A0t(i3);
            int iA0C = this.A04.A0C(viewA0t2);
            int childCount2 = A0G[3].length();
            if (childCount2 == 28) {
                throw new RuntimeException();
            }
            A0G[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
            if (iA0C <= i) {
                int limit6 = this.A04.A0G(viewA0t2);
                if (limit6 <= i) {
                }
            }
            A0d(c06794k, 0, i3);
            return;
        }
    }

    private void A0d(C06794k c06794k, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 > i) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                A14(i3, c06794k);
            }
            return;
        }
        while (i > i2) {
            A14(i, c06794k);
            i--;
        }
    }

    private void A0e(C06794k c06794k, C4H c4h) {
        if (!c4h.A0B || c4h.A09) {
            return;
        }
        int i = c4h.A05;
        String[] strArr = A0G;
        if (strArr[6].length() == strArr[7].length()) {
            String[] strArr2 = A0G;
            strArr2[2] = "M7iaeQoExhHh03f7x1XNzmreS2Lq1zJK";
            strArr2[4] = "3weclwG7n9RXAySrMV3Jn51LrKgutG4n";
            if (i == -1) {
                int i2 = c4h.A07;
                if (A0G[1].charAt(30) == 'o') {
                    A0G[3] = "CiNTyTfZO3PW6tP";
                    A0b(c06794k, i2);
                    return;
                }
            } else {
                A0c(c06794k, c4h.A07);
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A0f(C06794k c06794k, C06864r c06864r, int scrapExtraEnd, int scrapExtraEnd2) {
        if (!c06864r.A08() || A0W() == 0 || c06864r.A07() || !A26()) {
            return;
        }
        int iA0D = 0;
        int scrapExtraStart = 0;
        List<AbstractC06894u> listA0J = c06794k.A0J();
        int i = listA0J.size();
        int iA0p = A0p(A0t(0));
        for (int scrapSize = 0; scrapSize < i; scrapSize++) {
            AbstractC06894u abstractC06894u = listA0J.get(scrapSize);
            if (!abstractC06894u.A0c()) {
                int direction = 1;
                if ((abstractC06894u.A0I() < iA0p) != this.A05) {
                    direction = -1;
                }
                if (direction == -1) {
                    iA0D += this.A04.A0D(abstractC06894u.A0H);
                } else {
                    scrapExtraStart += this.A04.A0D(abstractC06894u.A0H);
                }
            }
        }
        this.A07.A08 = listA0J;
        if (iA0D > 0) {
            A0X(A0p(A0G()), scrapExtraEnd);
            this.A07.A02 = iA0D;
            this.A07.A00 = 0;
            this.A07.A04();
            A08(c06794k, this.A07, c06864r, false);
        }
        if (scrapExtraStart > 0) {
            A0W(A0p(A0F()), scrapExtraEnd2);
            this.A07.A02 = scrapExtraStart;
            this.A07.A00 = 0;
            this.A07.A04();
            A08(c06794k, this.A07, c06864r, false);
        }
        this.A07.A08 = null;
    }

    private void A0g(C06794k c06794k, C06864r c06864r, C4F c4f) {
        if (A0k(c06864r, c4f)) {
            return;
        }
        boolean zA0j = A0j(c06794k, c06864r, c4f);
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[3] = "XDJ2jDWhUW9a7iN";
        if (zA0j) {
            return;
        }
        c4f.A02();
        c4f.A01 = this.A0C ? c06864r.A03() - 1 : 0;
    }

    private final void A0h(boolean z) {
        A22(null);
        if (z == this.A0A) {
            return;
        }
        this.A0A = z;
        A0y();
    }

    private final boolean A0i() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0j(C06794k c06794k, C06864r c06864r, C4F c4f) {
        View viewA0P;
        int iA0A;
        if (A0W() == 0) {
            return false;
        }
        View viewA0s = A0s();
        if (viewA0s != null && c4f.A06(viewA0s, c06864r)) {
            c4f.A05(viewA0s);
            return true;
        }
        if (this.A08 != this.A0C) {
            return false;
        }
        if (c4f.A02) {
            viewA0P = A0O(c06794k, c06864r);
        } else {
            viewA0P = A0P(c06794k, c06864r);
        }
        if (viewA0P == null) {
            return false;
        }
        c4f.A04(viewA0P);
        if (!c06864r.A07() && A26()) {
            if (this.A04.A0F(viewA0P) >= this.A04.A07() || this.A04.A0C(viewA0P) < this.A04.A0A()) {
                if (c4f.A02) {
                    iA0A = this.A04.A07();
                } else {
                    iA0A = this.A04.A0A();
                }
                c4f.A00 = iA0A;
            }
        }
        return true;
    }

    private boolean A0k(C06864r c06864r, C4F c4f) {
        int i;
        int startGap;
        if (c06864r.A07() || (i = this.A01) == -1) {
            return false;
        }
        if (i < 0 || i >= c06864r.A03()) {
            this.A01 = -1;
            this.A02 = Integer.MIN_VALUE;
            return false;
        }
        c4f.A01 = this.A01;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState == null || !linearLayoutManager$SavedState.A01()) {
            if (this.A02 == Integer.MIN_VALUE) {
                View viewA1q = A1q(this.A01);
                if (viewA1q != null) {
                    if (this.A04.A0D(viewA1q) > this.A04.A0B()) {
                        c4f.A02();
                        return true;
                    }
                    if (this.A04.A0F(viewA1q) - this.A04.A0A() < 0) {
                        c4f.A00 = this.A04.A0A();
                        c4f.A02 = false;
                        return true;
                    }
                    int endGap = this.A04.A07() - this.A04.A0C(viewA1q);
                    if (endGap < 0) {
                        c4f.A00 = this.A04.A07();
                        c4f.A02 = true;
                        return true;
                    }
                    if (c4f.A02) {
                        int startGap2 = this.A04.A0C(viewA1q);
                        C4M c4m = this.A04;
                        String[] strArr = A0G;
                        String str = strArr[2];
                        String str2 = strArr[4];
                        int endGap2 = str.charAt(4);
                        if (endGap2 == str2.charAt(4)) {
                            throw new RuntimeException();
                        }
                        A0G[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                        startGap = startGap2 + c4m.A05();
                    } else {
                        startGap = this.A04.A0F(viewA1q);
                    }
                    c4f.A00 = startGap;
                } else {
                    if (A0W() > 0) {
                        View child = A0t(0);
                        int endGap3 = A0p(child);
                        boolean z = this.A01 < endGap3;
                        boolean z2 = this.A05;
                        int endGap4 = A0G[1].charAt(30);
                        if (endGap4 != 111) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0G;
                        strArr2[2] = "1tNDA9T9nSDYektAgKE77gOe81bMFJSk";
                        strArr2[4] = "TZYqXNdWGZVKxzfIQyf7YZEk7yb7IRTm";
                        c4f.A02 = z == z2;
                    }
                    c4f.A02();
                }
                return true;
            }
            c4f.A02 = this.A05;
            if (this.A05) {
                c4f.A00 = this.A04.A07() - this.A02;
            } else {
                c4f.A00 = this.A04.A0A() + this.A02;
            }
            return true;
        }
        c4f.A02 = this.A03.A02;
        if (c4f.A02) {
            c4f.A00 = this.A04.A07() - this.A03.A00;
        } else {
            c4f.A00 = this.A04.A0A() + this.A03.A00;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public int A1h(int i, C06794k c06794k, C06864r c06864r) {
        if (this.A00 == 1) {
            return 0;
        }
        return A04(i, c06794k, c06864r);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public int A1i(int i, C06794k c06794k, C06864r c06864r) {
        if (this.A00 == 0) {
            return 0;
        }
        int iA04 = A04(i, c06794k, c06864r);
        String[] strArr = A0G;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A0G[3] = "CDnF1shpb";
        return iA04;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final int A1j(C06864r c06864r) {
        return A09(c06864r);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final int A1k(C06864r c06864r) {
        return A0A(c06864r);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final int A1l(C06864r c06864r) {
        return A0B(c06864r);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final int A1m(C06864r c06864r) {
        return A09(c06864r);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final int A1n(C06864r c06864r) {
        return A0A(c06864r);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final int A1o(C06864r c06864r) {
        return A0B(c06864r);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final Parcelable A1p() {
        if (this.A03 != null) {
            return new WrappedParcelable(new LinearLayoutManager$SavedState(this.A03));
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        if (A0W() > 0) {
            A2D();
            boolean didLayoutFromEnd = this.A08 ^ this.A05;
            linearLayoutManager$SavedState.A02 = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View refChild = A0F();
                linearLayoutManager$SavedState.A00 = this.A04.A07() - this.A04.A0C(refChild);
                linearLayoutManager$SavedState.A01 = A0p(refChild);
            } else {
                View viewA0G = A0G();
                linearLayoutManager$SavedState.A01 = A0p(viewA0G);
                linearLayoutManager$SavedState.A00 = this.A04.A0F(viewA0G) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState.A00();
        }
        return new WrappedParcelable(linearLayoutManager$SavedState);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final View A1q(int i) {
        int firstChild = A0W();
        if (firstChild == 0) {
            return null;
        }
        int childCount = i - A0p(A0t(0));
        if (childCount >= 0 && childCount < firstChild) {
            View viewA0t = A0t(childCount);
            if (A0p(viewA0t) == i) {
                return viewA0t;
            }
        }
        return super.A1q(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public View A1r(View view, int i, C06794k c06794k, C06864r c06864r) {
        int iA2B;
        View viewA0M;
        View nextCandidate;
        A0U();
        if (A0W() == 0 || (iA2B = A2B(i)) == Integer.MIN_VALUE) {
            return null;
        }
        A2D();
        A2D();
        int layoutDir = this.A04.A0B();
        A0Y(iA2B, (int) (layoutDir * 0.33333334f), false, c06864r);
        this.A07.A07 = Integer.MIN_VALUE;
        this.A07.A0B = false;
        A08(c06794k, this.A07, c06864r, true);
        if (iA2B == -1) {
            viewA0M = A0N(c06794k, c06864r);
        } else {
            viewA0M = A0M(c06794k, c06864r);
        }
        if (iA2B == -1) {
            nextCandidate = A0G();
        } else {
            nextCandidate = A0F();
        }
        boolean zHasFocusable = nextCandidate.hasFocusable();
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "JGtMOr7ZHjmwUVfbInfaZmEhr0nxGN38";
        strArr[4] = "jCrgpf8bwQbyd1C9u6FfAt5OnK6gBhSa";
        if (zHasFocusable) {
            if (viewA0M == null) {
                return null;
            }
            return nextCandidate;
        }
        return viewA0M;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public C06734d A1s() {
        return new C06734d(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public void A1t(int i) {
        this.A01 = i;
        this.A02 = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A1u(int i, int i2, C06864r c06864r, InterfaceC06704a interfaceC06704a) {
        if (this.A00 != 0) {
            i = i2;
        }
        int delta = A0W();
        if (delta == 0 || i == 0) {
            return;
        }
        A2D();
        int i3 = i > 0 ? 1 : -1;
        int delta2 = Math.abs(i);
        A0Y(i3, delta2, true, c06864r);
        A2I(c06864r, this.A07, interfaceC06704a);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A1v(int i, InterfaceC06704a interfaceC06704a) {
        boolean z;
        int direction;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.A01()) {
            z = this.A03.A02;
            direction = this.A03.A01;
        } else {
            A0U();
            z = this.A05;
            int i2 = this.A01;
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0G[1] = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM";
            if (i2 == -1) {
                direction = z ? i - 1 : 0;
            } else {
                direction = this.A01;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.A06 && direction >= 0 && direction < i; i4++) {
            interfaceC06704a.A3O(direction, 0);
            direction += i3;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A1w(Parcelable parcelable) {
        if (!(parcelable instanceof WrappedParcelable)) {
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (A0G[1].charAt(30) == 'o') {
            A0G[1] = "tHEWx5U9TGfOm0s3U2zrO5nR7UMaVIoI";
            if (classLoader == null) {
                return;
            }
            if (A0G[5].length() == 31) {
                A0G[3] = "tm";
                Parcelable state = ((WrappedParcelable) parcelable).unwrap(classLoader);
                if (state instanceof LinearLayoutManager$SavedState) {
                    this.A03 = (LinearLayoutManager$SavedState) state;
                    A0y();
                    return;
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A1x(AccessibilityEvent accessibilityEvent) {
        super.A1x(accessibilityEvent);
        if (A0W() > 0) {
            accessibilityEvent.setFromIndex(A28());
            int iA29 = A29();
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            A0G[3] = "9E5bhv9RVKulu";
            accessibilityEvent.setToIndex(iA29);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:79:0x0208  */
    /* JADX WARN: Code duplicated, block: B:80:0x020b  */
    /* JADX WARN: Code duplicated, block: B:81:0x021c  */
    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public void A1y(C06794k c06794k, C06864r c06864r) {
        int extraForStart;
        int extraForEnd;
        int extraForStart2;
        View viewA1q;
        int current;
        int current2;
        String[] strArr;
        int i = -1;
        if ((this.A03 != null || this.A01 != -1) && c06864r.A03() == 0) {
            A1I(c06794k);
            return;
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.A01()) {
            this.A01 = this.A03.A01;
        }
        A2D();
        this.A07.A0B = false;
        A0U();
        View viewA0s = A0s();
        if (!this.A0D.A03 || this.A01 != -1 || this.A03 != null) {
            this.A0D.A03();
            this.A0D.A02 = this.A05 ^ this.A0C;
            A0g(c06794k, c06864r, this.A0D);
            C4F c4f = this.A0D;
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            A0G[0] = "pP9DXN24lJAGcvrzmJLzNvbz";
            c4f.A03 = true;
        } else if (viewA0s != null && (this.A04.A0F(viewA0s) >= this.A04.A07() || this.A04.A0C(viewA0s) <= this.A04.A0A())) {
            this.A0D.A05(viewA0s);
        }
        int lastElement = A0C(c06864r);
        if (this.A07.A04 >= 0) {
            extraForStart = 0;
        } else {
            extraForStart = lastElement;
            lastElement = 0;
        }
        int extraForStart3 = extraForStart + this.A04.A0A();
        int startOffset = lastElement + this.A04.A08();
        if (c06864r.A07()) {
            int current3 = this.A01;
            String[] strArr2 = A0G;
            if (strArr2[6].length() != strArr2[7].length()) {
                A0G[1] = "HnPzY03honFOjhYT25K5WFAFMhFIclok";
                if (current3 != -1) {
                    if (this.A02 != Integer.MIN_VALUE && (viewA1q = A1q(current3)) != null) {
                        if (this.A05) {
                            current2 = this.A04.A07() - this.A04.A0C(viewA1q);
                            strArr = A0G;
                            if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
                                A0G[5] = "r3FnQil1r32czyLALUutLd0XCkxYZ4G";
                                current = current2 - this.A02;
                            } else {
                                String[] strArr3 = A0G;
                                strArr3[2] = "sdmiyO1ExKOYMO2wbr6XNnW0K6t4WoaH";
                                strArr3[4] = "ty9AfnxQn4ghzZPCSImQPyrccPhuEwJu";
                                current = current2 - this.A02;
                            }
                        } else {
                            current = this.A02 - (this.A04.A0F(viewA1q) - this.A04.A0A());
                        }
                        if (current > 0) {
                            extraForStart3 += current;
                        } else {
                            startOffset -= current;
                        }
                    }
                }
            } else {
                String[] strArr4 = A0G;
                strArr4[2] = "wwbDuuRcKwQkcLvBFtW9wuMbOUuGYFzY";
                strArr4[4] = "YequbpJjhMyIl9uyXvP2gytASLo9xZ7L";
                if (current3 != -1) {
                    if (this.A02 != Integer.MIN_VALUE) {
                        if (this.A05) {
                            current2 = this.A04.A07() - this.A04.A0C(viewA1q);
                            strArr = A0G;
                            if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
                                A0G[5] = "r3FnQil1r32czyLALUutLd0XCkxYZ4G";
                                current = current2 - this.A02;
                            } else {
                                String[] strArr5 = A0G;
                                strArr5[2] = "sdmiyO1ExKOYMO2wbr6XNnW0K6t4WoaH";
                                strArr5[4] = "ty9AfnxQn4ghzZPCSImQPyrccPhuEwJu";
                                current = current2 - this.A02;
                            }
                        } else {
                            current = this.A02 - (this.A04.A0F(viewA1q) - this.A04.A0A());
                        }
                        if (current > 0) {
                            extraForStart3 += current;
                        } else {
                            startOffset -= current;
                        }
                    }
                }
            }
        }
        if (this.A0D.A02) {
            if (this.A05) {
                i = 1;
            }
        } else if (!this.A05) {
            i = 1;
        }
        A2G(c06794k, c06864r, this.A0D, i);
        A1H(c06794k);
        this.A07.A09 = A0i();
        this.A07.A0A = c06864r.A07();
        if (this.A0D.A02) {
            A0a(this.A0D);
            this.A07.A02 = extraForStart3;
            A08(c06794k, this.A07, c06864r, false);
            extraForStart2 = this.A07.A06;
            int i2 = this.A07.A01;
            if (this.A07.A00 > 0) {
                startOffset += this.A07.A00;
            }
            A0Z(this.A0D);
            this.A07.A02 = startOffset;
            this.A07.A01 += this.A07.A03;
            A08(c06794k, this.A07, c06864r, false);
            extraForEnd = this.A07.A06;
            if (this.A07.A00 > 0) {
                int i3 = this.A07.A00;
                A0X(i2, extraForStart2);
                this.A07.A02 = i3;
                A08(c06794k, this.A07, c06864r, false);
                extraForStart2 = this.A07.A06;
            }
        } else {
            A0Z(this.A0D);
            this.A07.A02 = startOffset;
            A08(c06794k, this.A07, c06864r, false);
            extraForEnd = this.A07.A06;
            int i4 = this.A07.A01;
            if (this.A07.A00 > 0) {
                extraForStart3 += this.A07.A00;
            }
            A0a(this.A0D);
            this.A07.A02 = extraForStart3;
            this.A07.A01 += this.A07.A03;
            A08(c06794k, this.A07, c06864r, false);
            extraForStart2 = this.A07.A06;
            if (this.A07.A00 > 0) {
                int i5 = this.A07.A00;
                A0W(i4, extraForEnd);
                this.A07.A02 = i5;
                A08(c06794k, this.A07, c06864r, false);
                extraForEnd = this.A07.A06;
            }
        }
        if (A0W() > 0) {
            if (this.A05 ^ this.A0C) {
                int iA05 = A05(extraForEnd, c06794k, c06864r, true);
                int extraForStart4 = extraForStart2 + iA05;
                int extraForEnd2 = extraForEnd + iA05;
                int iA06 = A06(extraForStart4, c06794k, c06864r, false);
                extraForStart2 = extraForStart4 + iA06;
                extraForEnd = extraForEnd2 + iA06;
            } else {
                int iA07 = A06(extraForStart2, c06794k, c06864r, true);
                int extraForStart5 = extraForStart2 + iA07;
                int extraForEnd3 = extraForEnd + iA07;
                int iA08 = A05(extraForEnd3, c06794k, c06864r, false);
                extraForStart2 = extraForStart5 + iA08;
                extraForEnd = extraForEnd3 + iA08;
            }
        }
        A0f(c06794k, c06864r, extraForStart2, extraForEnd);
        if (!c06864r.A07()) {
            this.A04.A0I();
        } else {
            this.A0D.A03();
        }
        this.A08 = this.A0C;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public void A1z(C06864r c06864r) {
        super.A1z(c06864r);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A20(ED ed, C06794k c06794k) {
        super.A20(ed, c06794k);
        if (this.A09) {
            A1I(c06794k);
            c06794k.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public void A21(ED ed, C06864r c06864r, int i) {
        ZB linearSmoothScroller = new ZB(ed.getContext());
        linearSmoothScroller.A0A(i);
        A1L(linearSmoothScroller);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A22(String str) {
        if (this.A03 == null) {
            super.A22(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final boolean A23() {
        if (A0Y() != 1073741824 && A0i() != 1073741824) {
            boolean zA1W = A1W();
            if (A0G[0].length() == 7) {
                throw new RuntimeException();
            }
            A0G[0] = "ZYU5Lu8KJdo1W8";
            if (zA1W) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final boolean A24() {
        return this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final boolean A25() {
        return this.A00 == 1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public boolean A26() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A27() {
        View child = A0J(0, A0W(), true, false);
        if (child == null) {
            return -1;
        }
        return A0p(child);
    }

    public final int A28() {
        View child = A0J(0, A0W(), false, true);
        if (child == null) {
            return -1;
        }
        return A0p(child);
    }

    public final int A29() {
        View child = A0J(A0W() - 1, -1, false, true);
        if (child == null) {
            return -1;
        }
        return A0p(child);
    }

    public final int A2A() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r3 == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (A2J() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
    
        if (r3 == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A2B(int r8) {
        /*
            r7 = this;
            r6 = -1
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1
            switch(r8) {
                case 1: goto L8;
                case 2: goto L31;
                case 17: goto L3e;
                case 33: goto L46;
                case 66: goto L4e;
                case 130: goto L54;
                default: goto L7;
            }
        L7:
            return r5
        L8:
            int r3 = r7.A00
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ZC.A0G
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L1f
            if (r3 != r4) goto L29
        L1e:
            return r6
        L1f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ZC.A0G
            java.lang.String r1 = "tdW2fzf"
            r0 = 3
            r2[r0] = r1
            if (r3 != r4) goto L29
            goto L1e
        L29:
            boolean r0 = r7.A2J()
            if (r0 == 0) goto L30
            return r4
        L30:
            return r6
        L31:
            int r0 = r7.A00
            if (r0 != r4) goto L36
            return r4
        L36:
            boolean r0 = r7.A2J()
            if (r0 == 0) goto L3d
            return r6
        L3d:
            return r4
        L3e:
            int r0 = r7.A00
            if (r0 != 0) goto L43
        L42:
            return r6
        L43:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L42
        L46:
            int r0 = r7.A00
            if (r0 != r4) goto L4b
        L4a:
            return r6
        L4b:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L4a
        L4e:
            int r0 = r7.A00
            if (r0 != 0) goto L53
            r5 = 1
        L53:
            return r5
        L54:
            int r3 = r7.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.ZC.A0G
            r0 = 1
            r1 = r1[r0]
            r0 = 30
            char r1 = r1.charAt(r0)
            r0 = 111(0x6f, float:1.56E-43)
            if (r1 == r0) goto L6b
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L6b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ZC.A0G
            java.lang.String r1 = "6DQtaB3lJkGKNvmH8s9QQc68TsOBLDE"
            r0 = 3
            r2[r0] = r1
            if (r3 != r4) goto L75
            r5 = 1
        L75:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZC.A2B(int):int");
    }

    public View A2C(C06794k c06794k, C06864r c06864r, int i, int i2, int i3) {
        A2D();
        View view = null;
        View view2 = null;
        int iA0A = this.A04.A0A();
        int boundsEnd = this.A04.A07();
        int boundsStart = i2 > i ? 1 : -1;
        while (i != i2) {
            View outOfBoundsMatch = A0t(i);
            int iA0p = A0p(outOfBoundsMatch);
            if (iA0p >= 0 && iA0p < i3) {
                if (((C06734d) outOfBoundsMatch.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = outOfBoundsMatch;
                    }
                } else if (this.A04.A0F(outOfBoundsMatch) >= boundsEnd || this.A04.A0C(outOfBoundsMatch) < iA0A) {
                    if (view2 == null) {
                        view2 = outOfBoundsMatch;
                    }
                } else {
                    return outOfBoundsMatch;
                }
            }
            i += boundsStart;
        }
        return view2 != null ? view2 : view;
    }

    public final void A2D() {
        if (this.A07 == null) {
            this.A07 = A0S();
        }
        if (this.A04 == null) {
            this.A04 = C4M.A02(this, this.A00);
        }
    }

    public final void A2E(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(A0T(0, 20, 1) + i);
        }
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        A0G[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
        A22(null);
        if (i == this.A00) {
            return;
        }
        this.A00 = i;
        this.A04 = null;
        A0y();
    }

    public final void A2F(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        A0G[3] = "tDl3kZGUKMTs";
    }

    public void A2G(C06794k c06794k, C06864r c06864r, C4F c4f, int i) {
    }

    public void A2H(C06794k c06794k, C06864r c06864r, C4H c4h, C4G c4g) {
        int iA0g;
        int right;
        int iA0e;
        int iA0E;
        View viewA03 = c4h.A03(c06794k);
        if (viewA03 == null) {
            c4g.A01 = true;
            return;
        }
        C06734d c06734d = (C06734d) viewA03.getLayoutParams();
        if (c4h.A08 == null) {
            if (this.A05 == (c4h.A05 == -1)) {
                A17(viewA03);
            } else {
                A19(viewA03, 0);
            }
        } else {
            boolean z = this.A05;
            int bottom = c4h.A05;
            if (z == (bottom == -1)) {
                A16(viewA03);
            } else {
                A18(viewA03, 0);
            }
        }
        A1A(viewA03, 0, 0);
        c4g.A00 = this.A04.A0D(viewA03);
        if (this.A00 == 1) {
            if (A2J()) {
                iA0E = A0h() - A0f();
                iA0e = iA0E - this.A04.A0E(viewA03);
            } else {
                iA0e = A0e();
                iA0E = this.A04.A0E(viewA03) + iA0e;
            }
            if (c4h.A05 == -1) {
                right = c4h.A06;
                iA0g = c4h.A06 - c4g.A00;
            } else {
                iA0g = c4h.A06;
                right = c4h.A06 + c4g.A00;
            }
        } else {
            iA0g = A0g();
            right = this.A04.A0E(viewA03) + iA0g;
            int bottom2 = c4h.A05;
            if (bottom2 == -1) {
                iA0E = c4h.A06;
                int i = c4h.A06;
                int bottom3 = c4g.A00;
                iA0e = i - bottom3;
            } else {
                iA0e = c4h.A06;
                int i2 = c4h.A06;
                int bottom4 = c4g.A00;
                iA0E = i2 + bottom4;
            }
        }
        A1B(viewA03, iA0e, iA0g, iA0E, right);
        if (c06734d.A02() || c06734d.A01()) {
            c4g.A03 = true;
        }
        c4g.A02 = viewA03.hasFocusable();
    }

    public void A2I(C06864r c06864r, C4H c4h, InterfaceC06704a interfaceC06704a) {
        int i = c4h.A01;
        if (i >= 0) {
            int pos = c06864r.A03();
            if (i < pos) {
                int pos2 = c4h.A07;
                interfaceC06704a.A3O(i, Math.max(0, pos2));
            }
        }
    }

    public final boolean A2J() {
        return A0a() == 1;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06834o
    public final PointF A4L(int i) {
        if (A0W() == 0) {
            return null;
        }
        int i2 = (i < A0p(A0t(0))) != this.A05 ? -1 : 1;
        int i3 = this.A00;
        int firstChildPos = A0G[0].length();
        if (firstChildPos == 7) {
            throw new RuntimeException();
        }
        A0G[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
        if (i3 == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }
}
