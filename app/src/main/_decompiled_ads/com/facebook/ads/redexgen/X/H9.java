package com.facebook.ads.redexgen.X;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class H9 {
    public static byte[] A05;
    public static String[] A06 = {"j9EfDvchdu1KqySqOAnBSG3JWHZdS12U", "q23SQ5AypNqS8oaKOX4z", "zGl30nZzPzoLIdVG6oXXe73jwI6SvYzS", "XO0PMOb8qpQh9emdWW7Vnqfuo5cp8yJy", "hg0Ynef21ksm7drJYvbGXc6C6VdsLqYq", "sq8Z8cDX36Rb5yN4ZHuInHWL1DTNPmF7", "lpBmIRRiri9NKyd9o68rlNPCbyzvIw2I", "eicGPlwUgu"};
    public boolean A01;
    public final int A02;
    public final String A03;
    public C1328Ux A00 = C1328Ux.A04;
    public final TreeSet<C1326Uv> A04 = new TreeSet<>();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A06[6].charAt(21) != 'N') {
                throw new RuntimeException();
            }
            A06[6] = "ipIPz5SC6v0GmkIAozZhwN70MrudeMSU";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 100);
            i4++;
        }
    }

    public static void A02() {
        byte[] bArr = {-79, -9, -14, -6, -3, -10, -11, -65, -77, 7, 2, -77, 42, Base64.padSymbol, 70, 57, 69, 65, 70, 63, -8, 71, 62, -8};
        String[] strArr = A06;
        if (strArr[4].charAt(2) != strArr[3].charAt(2)) {
            throw new RuntimeException();
        }
        A06[5] = "8leR2nWms8A7PmFgrtQ6nLfJYqb68GHr";
        A05 = bArr;
    }

    static {
        A02();
    }

    public H9(int i, String str) {
        this.A02 = i;
        this.A03 = str;
    }

    public static H9 A00(int i, DataInputStream dataInputStream) throws IOException {
        H9 h9 = new H9(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i < 2) {
            long j = dataInputStream.readLong();
            HE he = new HE();
            HD.A05(he, j);
            h9.A0F(he);
        } else {
            h9.A00 = C1328Ux.A00(dataInputStream);
        }
        return h9;
    }

    public final int A03(int i) {
        int result = this.A02;
        int i2 = result * 31;
        int result2 = this.A03.hashCode();
        int result3 = i2 + result2;
        if (i < 2) {
            long jA00 = HD.A00(this.A00);
            return (result3 * 31) + ((int) ((jA00 >>> 32) ^ jA00));
        }
        return (result3 * 31) + this.A00.hashCode();
    }

    public final long A04(long j, long j2) {
        C1326Uv c1326UvA06 = A06(j);
        if (c1326UvA06.A01()) {
            return -Math.min(c1326UvA06.A02() ? Long.MAX_VALUE : c1326UvA06.A01, j2);
        }
        long j3 = j + j2;
        long queryEndPosition = c1326UvA06.A02 + c1326UvA06.A01;
        if (queryEndPosition < j3) {
            TreeSet<C1326Uv> treeSet = this.A04;
            if (A06[1].length() != 20) {
                throw new RuntimeException();
            }
            A06[1] = "RgZ5bXDLk5KqdLdfFSHI";
            for (C1326Uv c1326Uv : treeSet.tailSet(c1326UvA06, false)) {
                long currentEndPosition = c1326Uv.A02;
                if (currentEndPosition > queryEndPosition) {
                    break;
                }
                long currentEndPosition2 = c1326Uv.A02;
                queryEndPosition = Math.max(queryEndPosition, currentEndPosition2 + c1326Uv.A01);
                if (queryEndPosition >= j3) {
                    break;
                }
            }
        }
        return Math.min(queryEndPosition - j, j2);
    }

    public final C1328Ux A05() {
        return this.A00;
    }

    public final C1326Uv A06(long j) {
        C1326Uv c1326UvA01 = C1326Uv.A01(this.A03, j);
        C1326Uv c1326UvFloor = this.A04.floor(c1326UvA01);
        if (c1326UvFloor != null && c1326UvFloor.A02 + c1326UvFloor.A01 > j) {
            return c1326UvFloor;
        }
        TreeSet<C1326Uv> treeSet = this.A04;
        String[] strArr = A06;
        if (strArr[2].charAt(22) != strArr[0].charAt(22)) {
            throw new RuntimeException();
        }
        A06[6] = "nd2bgBSeUAsM9albd5et6NmdTACtd3AP";
        C1326Uv lookupSpan = treeSet.ceiling(c1326UvA01);
        if (lookupSpan == null) {
            return C1326Uv.A02(this.A03, j);
        }
        return C1326Uv.A03(this.A03, j, lookupSpan.A02 - j);
    }

    public final C1326Uv A07(C1326Uv c1326Uv) throws H0 {
        HI.A04(this.A04.remove(c1326Uv));
        C1326Uv c1326UvA08 = c1326Uv.A08(this.A02);
        if (c1326Uv.A03.renameTo(c1326UvA08.A03)) {
            this.A04.add(c1326UvA08);
            return c1326UvA08;
        }
        throw new H0(A01(12, 12, 116) + c1326Uv.A03 + A01(8, 4, 47) + c1326UvA08.A03 + A01(0, 8, 45));
    }

    public final TreeSet<C1326Uv> A08() {
        return this.A04;
    }

    public final void A09(C1326Uv c1326Uv) {
        this.A04.add(c1326Uv);
    }

    public final void A0A(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A02);
        dataOutputStream.writeUTF(this.A03);
        this.A00.A09(dataOutputStream);
    }

    public final void A0B(boolean z) {
        this.A01 = z;
    }

    public final boolean A0C() {
        return this.A04.isEmpty();
    }

    public final boolean A0D() {
        return this.A01;
    }

    public final boolean A0E(H6 h6) {
        if (this.A04.remove(h6)) {
            h6.A03.delete();
            return true;
        }
        return false;
    }

    public final boolean A0F(HE he) {
        C1328Ux c1328Ux = this.A00;
        C1328Ux oldMetadata = this.A00.A08(he);
        this.A00 = oldMetadata;
        return !oldMetadata.equals(c1328Ux);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        H9 h9 = (H9) obj;
        if (this.A02 == h9.A02 && this.A03.equals(h9.A03) && this.A04.equals(h9.A04) && this.A00.equals(h9.A00)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = A03(Integer.MAX_VALUE);
        int i = result * 31;
        int result2 = this.A04.hashCode();
        return i + result2;
    }
}
