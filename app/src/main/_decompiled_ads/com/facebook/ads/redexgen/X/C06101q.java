package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C06101q {
    public static byte[] A00;
    public static String[] A01 = {"SZD1gnuwYC0ZDT5XCpN5wGg04vpvlXtv", "38Pkme0hctlwOycqXgIFmSt4EwGMsPu", "PZ5YSJhnqoOlFoXIJ", "MKZOkal4amZt32sY0duMnYWyMVrdvNv7", "PmMqC", "MtvBWYcgrX5nN2Ecp9gb0xGXALHF8kJ8", "836OSMulKGxVhnpon", "Ud77gBKi5ZcurXFgX0oEk2YfAMQgAhDP"};

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{25, 95, 67, 90, 91, 103, 96, 122, 107, 124, 125, 122, 103, 122, 103, 111, 98, 3, 20, 6, 16, 3, 21, 20, 21, 46, 7, 24, 21, 20, 30};
    }

    static {
        A01();
    }

    public static void A02(YA ya, C6Q c6q, C0921Ey c0921Ey) {
        c6q.A0c(new C6O(c0921Ey.A0z().A01(), PB.A04, PB.A04, c0921Ey.A0R(), A00(17, 14, 99)));
        boolean zA0k = c0921Ey.A0k();
        if (zA0k) {
            C6M c6m = new C6M(c0921Ey.A0L(), c0921Ey.A0R(), A00(17, 14, 99));
            c6m.A04 = true;
            c6m.A03 = A00(0, 5, 37);
            c6q.A0X(c6m);
        }
        boolean isDSL = QJ.A03();
        boolean zA2N = IP.A2N(ya, isDSL);
        C6M c6m2 = new C6M(c0921Ey.A0v().A0D().A08(), c0921Ey.A0R(), A00(17, 14, 99), c0921Ey.A0v().A0D().A05());
        if (zA0k && !zA2N) {
            c6q.A0X(c6m2);
        } else {
            c6q.A0a(c6m2);
        }
        c6q.A0c(new C6O(c0921Ey.A0v().A0D().A07(), C06051l.A00(c0921Ey.A0v().A0D()), C06051l.A01(c0921Ey.A0v().A0D()), c0921Ey.A0R(), A00(17, 14, 99)));
        Iterator<String> it = c0921Ey.A0v().A0G().A01().iterator();
        while (isDSL) {
            String url = it.next();
            c6q.A0c(new C6O(url, -1, -1, c0921Ey.A0R(), A00(17, 14, 99)));
        }
    }

    public static void A03(YA ya, C6Q c6q, C0921Ey c0921Ey) {
        int i = 0;
        for (C1D c1d : c0921Ey.A13()) {
            C6O c6o = new C6O(c1d.A0D().A07(), C06051l.A00(c1d.A0D()), C06051l.A01(c1d.A0D()), c0921Ey.A0R(), A00(5, 12, 28));
            if (i == 0) {
                c6q.A0b(c6o);
            } else {
                c6q.A0c(c6o);
            }
            Iterator<String> it = c1d.A0G().A01().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                String[] strArr = A01;
                if (strArr[2].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[0] = "d4OGgqInyGax2uUwuJ6rocUy9OK0g6RJ";
                strArr2[7] = "8ZRzgNChvbJeQD0ONiajCC1PQNrhJWUQ";
                if (zHasNext) {
                    c6q.A0c(new C6O(it.next(), -1, -1, c0921Ey.A0R(), A00(5, 12, 28)));
                }
            }
            if (!TextUtils.isEmpty(c1d.A0D().A08())) {
                new C6M(c1d.A0D().A08(), c0921Ey.A0R(), A00(5, 12, 28), c1d.A0D().A05()).A04 = false;
            }
            i++;
        }
    }
}
