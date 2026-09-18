package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A05' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EnumC05941a {
    public static byte[] A01;
    public static final /* synthetic */ EnumC05941a[] A02;
    public static final EnumC05941a A03;
    public static final EnumC05941a A04;
    public static final EnumC05941a A05;
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{24, 23, 18, 27, 1, 14, 12, 27, 29, 31, 29, 22, 27, 3, 1, 28, 11, 10, 12, 3, 1, 22, 16, 18, 16, 27, 22, 119, 101, 98, 118, 105, 101, 119, 127, 112, 114, 101, 99, 97, 99, 104, 101};
    }

    static {
        A02();
        String strA01 = A01(27, 16, 0);
        EnumC05941a enumC05941a = new EnumC05941a(strA01, 0, strA01);
        A05 = enumC05941a;
        String strA02 = A01(13, 14, 115);
        EnumC05941a enumC05941a2 = new EnumC05941a(strA02, 1, strA02);
        A04 = enumC05941a2;
        String strA03 = A01(0, 13, 126);
        EnumC05941a enumC05941a3 = new EnumC05941a(strA03, 2, strA03);
        A03 = enumC05941a3;
        A02 = new EnumC05941a[]{enumC05941a, enumC05941a2, enumC05941a3};
    }

    public EnumC05941a(String str, int i, String str2) {
        super(str, i);
        this.A00 = str2;
    }

    public static EnumC05941a A00(String str) {
        for (EnumC05941a enumC05941a : values()) {
            if (enumC05941a.A00.equalsIgnoreCase(str)) {
                return enumC05941a;
            }
        }
        return A03;
    }

    public static EnumC05941a valueOf(String str) {
        return (EnumC05941a) Enum.valueOf(EnumC05941a.class, str);
    }

    public static EnumC05941a[] values() {
        return (EnumC05941a[]) A02.clone();
    }
}
