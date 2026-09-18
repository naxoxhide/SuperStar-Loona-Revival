package b.b.a.a.f.a.q;

import com.facebook.internal.security.CertificateUtil;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final Charset a = Charset.forName("UTF-8");

    public static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static int b(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int c(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static int a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static boolean b(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String a(String str) {
        InetAddress inetAddressA;
        if (str.contains(CertificateUtil.DELIMITER)) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressA = a(str, 1, str.length() - 1);
            } else {
                inetAddressA = a(str, 0, str.length());
            }
            if (inetAddressA == null) {
                return null;
            }
            byte[] address = inetAddressA.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || b(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x004f  */
    /* JADX WARN: Code duplicated, block: B:34:0x005a A[LOOP:1: B:30:0x004d->B:34:0x005a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0060 A[EDGE_INSN: B:59:0x0060->B:35:0x0060 BREAK  A[LOOP:1: B:30:0x004d->B:34:0x005a], SYNTHETIC] */
    private static InetAddress a(String str, int i, int i2) {
        int i3;
        int i4;
        int iA;
        byte[] bArr = new byte[16];
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (i < i2) {
            if (i7 == 16) {
                return null;
            }
            int i8 = i + 2;
            if (i8 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                if (i5 != -1) {
                    return null;
                }
                i7 += 2;
                i5 = i7;
                if (i8 == i2) {
                    break;
                }
                i6 = i8;
                i3 = 0;
                i = i6;
                while (i < i2) {
                    iA = a(str.charAt(i));
                    if (iA == -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iA;
                    i++;
                }
                i4 = i - i6;
                if (i4 != 0) {
                }
                return null;
            }
            if (i7 != 0) {
                if (!str.regionMatches(i, CertificateUtil.DELIMITER, 0, 1)) {
                    if (!str.regionMatches(i, ".", 0, 1) || !a(str, i6, i2, bArr, i7 - 2)) {
                        return null;
                    }
                    i7 += 2;
                    break;
                }
                i++;
            }
            i6 = i;
            i3 = 0;
            i = i6;
            while (i < i2) {
                iA = a(str.charAt(i));
                if (iA == -1) {
                    break;
                }
                i3 = (i3 << 4) + iA;
                i++;
            }
            i4 = i - i6;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            int i9 = i7 + 1;
            bArr[i7] = (byte) ((i3 >>> 8) & 255);
            i7 = i9 + 1;
            bArr[i9] = (byte) (i3 & 255);
        }
        if (i7 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i10 = i7 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i5, (16 - i7) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static String a(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        a aVar = new a();
        while (i < bArr.length) {
            if (i == i2) {
                aVar.c(58);
                i += i4;
                if (i == 16) {
                    aVar.c(58);
                }
            } else {
                if (i > 0) {
                    aVar.c(58);
                }
                aVar.b(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                i += 2;
            }
        }
        return aVar.e();
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
