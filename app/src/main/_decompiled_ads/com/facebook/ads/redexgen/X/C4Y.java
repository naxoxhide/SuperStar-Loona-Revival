package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4Y {
    public static byte[] A06;
    public static String[] A07 = {"wCFFy4v0UHolBGzubHhtaTK0KlaK5TU8", "WXL", "veTi", "n3", "rW28yUWMMTgiQlEcIz6smwE3e87Fn5Ax", "QU5acghFPGL2KQJts4swUt9W5A9MK8iM", "qIZlYUWuFA6tmX766BSANKSPkXlWbMWT", "RhPzJuizv3JTUr3AZhw4zLdz5ZpO"};
    public C4W A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{85, 84, 123, 84, 83, 87, 91, 78, 83, 85, 84, 73, 124, 83, 84, 83, 73, 82, 95, 94};
    }

    public abstract boolean A0E(AbstractC06894u abstractC06894u, C4X c4x, C4X c4x2);

    public abstract boolean A0F(AbstractC06894u abstractC06894u, C4X c4x, C4X c4x2);

    public abstract boolean A0G(AbstractC06894u abstractC06894u, C4X c4x, C4X c4x2);

    public abstract boolean A0H(AbstractC06894u abstractC06894u, AbstractC06894u abstractC06894u2, C4X c4x, C4X c4x2);

    public abstract void A0I();

    public abstract void A0J();

    public abstract void A0K(AbstractC06894u abstractC06894u);

    public abstract boolean A0L();

    static {
        A03();
    }

    public static int A00(AbstractC06894u abstractC06894u) {
        int i = abstractC06894u.A0C & 14;
        if (abstractC06894u.A0b()) {
            return 4;
        }
        int flags = i & 4;
        if (flags == 0) {
            int iA0J = abstractC06894u.A0J();
            int iA0G = abstractC06894u.A0G();
            String[] strArr = A07;
            String str = strArr[3];
            String str2 = strArr[1];
            int oldPos = str.length();
            int flags2 = str2.length();
            if (oldPos == flags2) {
                throw new RuntimeException();
            }
            A07[0] = "z6mPnscAmNwlAliMzxZ9cFQDVALsWjfG";
            if (iA0J != -1 && iA0G != -1 && iA0J != iA0G) {
                return i | 2048;
            }
            return i;
        }
        return i;
    }

    private final C4X A01() {
        return new C4X();
    }

    public final long A04() {
        return this.A00;
    }

    public final long A05() {
        return this.A01;
    }

    public final long A06() {
        return this.A02;
    }

    public final long A07() {
        return this.A03;
    }

    public final C4X A08(C06864r c06864r, AbstractC06894u abstractC06894u) {
        return A01().A01(abstractC06894u);
    }

    public final C4X A09(C06864r c06864r, AbstractC06894u abstractC06894u, int i, List<Object> payloads) {
        return A01().A01(abstractC06894u);
    }

    public final void A0A() {
        int count = this.A05.size();
        if (0 < count) {
            this.A05.get(0);
            throw new NullPointerException(A02(0, 20, 16));
        }
        this.A05.clear();
    }

    public final void A0B(C4W c4w) {
        this.A04 = c4w;
    }

    public final void A0C(AbstractC06894u abstractC06894u) {
        C4W c4w = this.A04;
        if (c4w != null) {
            c4w.AAU(abstractC06894u);
        }
    }

    public boolean A0D(AbstractC06894u abstractC06894u) {
        return true;
    }

    public boolean A0M(AbstractC06894u abstractC06894u, List<Object> payloads) {
        return A0D(abstractC06894u);
    }
}
