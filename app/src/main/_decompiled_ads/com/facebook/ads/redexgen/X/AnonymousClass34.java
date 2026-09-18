package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.34, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass34 extends BP {
    public static byte[] A05;
    public static String[] A06 = {"qvo0GMLMlCI9r2KvubgW", "xANfLU", "vfLxBByg2WxKhxozFOdEyd4oNWbI2yKZ", "M6AXkYe8VdVGq", "jqpt9kLQVEpjtzmdo0kCC28NolZOOofM", "wQfQ1ikODVE5", "8nxGlLt3aQnzE5X", "LzSrLgRmD2ZM4QoK2ANM"};
    public static final Pattern A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public final boolean A04;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{7, 81, 70, 67, 81, 37, 29, 82, 80, 67, 80, 70, 81, 37, 29, 82, 80, 67, 81, 37, 29, 82, 80, 81, 70, 67, 67, 5, 37, 87, 80, 81, 37, 29, 82, 80, 49, 108, 65, 73, 68, 71, 79, 93, 77, 18, 8, 67, 106, 119, 104, 100, 113, 63, 37, 76, 116, 118, 111, 111, 118, 113, 120, 63, 123, 118, 126, 115, 112, 120, 106, 122, 63, 115, 118, 113, 122, 63, 125, 122, 121, 112, 109, 122, 63, 124, 112, 114, 111, 115, 122, 107, 122, 63, 121, 112, 109, 114, 126, 107, 37, 63, 32, 24, 26, 3, 3, 26, 29, 20, 83, 23, 26, 18, 31, 28, 20, 6, 22, 83, 31, 26, 29, 22, 83, 4, 26, 7, 27, 83, 21, 22, 4, 22, 1, 83, 16, 28, 31, 6, 30, 29, 0, 83, 7, 27, 18, 29, 83, 21, 28, 1, 30, 18, 7, 73, 83, 8, 48, 50, 43, 43, 50, 53, 60, 123, 50, 53, 45, 58, 55, 50, 63, 123, 47, 50, 54, 50, 53, 60, 97, 123, 65, 97, 115, 86, 119, 113, 125, 118, 119, 96, 26, 4, 55, 36, 47, 53, 50, 28, 70, 70, 84, 90, 90, 104, 85, 114, 39, 35, 54, 85, 116, 110, 101, 111, 102, 97, 116, 103, 97, 18, 3, 30, 18};
    }

    static {
        A03();
        A07 = Pattern.compile(A02(1, 35, 77));
    }

    public AnonymousClass34() {
        this(null);
    }

    public AnonymousClass34(List<byte[]> list) {
        super(A02(182, 10, 38));
        if (list != null && !list.isEmpty()) {
            this.A04 = true;
            String strA0Q = C0996Hx.A0Q(list.get(0));
            String formatLine = A02(47, 8, 49);
            HI.A03(strA0Q.startsWith(formatLine));
            A06(strA0Q);
            A04(new C0980Hh(list.get(1)));
            return;
        }
        this.A04 = false;
    }

    public static long A00(String str) {
        Matcher matcher = A07.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.BP
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final VW A0b(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        HX hx = new HX();
        C0980Hh c0980Hh = new C0980Hh(bArr, i);
        if (!this.A04) {
            A04(c0980Hh);
        }
        A05(c0980Hh, arrayList, hx);
        FV[] fvArr = new FV[arrayList.size()];
        arrayList.toArray(fvArr);
        return new VW(fvArr, hx.A05());
    }

    private void A04(C0980Hh c0980Hh) {
        String strA0P;
        do {
            strA0P = c0980Hh.A0P();
            if (strA0P == null) {
                return;
            }
        } while (!strA0P.startsWith(A02(192, 8, 117)));
    }

    private void A05(C0980Hh c0980Hh, List<FV> list, HX hx) {
        while (true) {
            String strA0P = c0980Hh.A0P();
            if (strA0P != null) {
                if (!this.A04 && strA0P.startsWith(A02(47, 8, 49))) {
                    A06(strA0P);
                } else if (strA0P.startsWith(A02(37, 10, 28))) {
                    A07(strA0P, list, hx);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0040  */
    private void A06(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(A02(47, 8, 49).length()), A02(36, 1, 41));
        this.A01 = strArrSplit.length;
        this.A02 = -1;
        this.A00 = -1;
        this.A03 = -1;
        int i = 0;
        while (true) {
            byte b2 = 0;
            if (i >= this.A01) {
                if (this.A02 == -1 || this.A00 == -1 || this.A03 == -1) {
                    this.A01 = 0;
                    return;
                }
                return;
            }
            String strA0M = C0996Hx.A0M(strArrSplit[i].trim());
            switch (strA0M.hashCode()) {
                case 100571:
                    if (!strA0M.equals(A02(213, 3, 63))) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 3556653:
                    if (!strA0M.equals(A02(221, 4, 82))) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 109757538:
                    if (!strA0M.equals(A02(216, 5, 33))) {
                        b2 = -1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    this.A02 = i;
                    break;
                case 1:
                    this.A00 = i;
                    break;
                case 2:
                    this.A03 = i;
                    break;
            }
            i++;
        }
    }

    private void A07(String str, List<FV> list, HX hx) {
        int i = this.A01;
        String strA02 = A02(182, 10, 38);
        if (i == 0) {
            Log.w(strA02, A02(55, 47, 43) + str);
            return;
        }
        String[] strArrSplit = str.substring(A02(37, 10, 28).length()).split(A02(36, 1, 41), this.A01);
        if (strArrSplit.length != this.A01) {
            Log.w(strA02, A02(102, 55, 71) + str);
            return;
        }
        long startTimeUs = A00(strArrSplit[this.A02]);
        String strA03 = A02(157, 25, 111);
        if (startTimeUs == -9223372036854775807L) {
            Log.w(strA02, strA03 + str);
            return;
        }
        long jA00 = -9223372036854775807L;
        String str2 = strArrSplit[this.A00];
        if (!str2.trim().isEmpty()) {
            jA00 = A00(str2);
            if (jA00 == -9223372036854775807L) {
                Log.w(strA02, strA03 + str);
                return;
            }
        }
        String endTimeString = strArrSplit[this.A03].replaceAll(A02(206, 7, 61), A02(0, 0, 97));
        String strA04 = A02(200, 3, 46);
        String strA05 = A02(0, 1, 57);
        list.add(new FV(endTimeString.replaceAll(strA04, strA05).replaceAll(A02(203, 3, 50), strA05)));
        hx.A04(startTimeUs);
        if (jA00 != -9223372036854775807L) {
            list.add(null);
            String[] strArr = A06;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "QluocDWeuHRDa";
            strArr2[6] = "JZgOBObbaiMn4tK";
            hx.A04(jA00);
        }
    }
}
