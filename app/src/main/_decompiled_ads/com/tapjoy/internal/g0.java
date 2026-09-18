package com.tapjoy.internal;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class g0 implements Serializable, Comparable {
    public static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final g0 e = new g0((byte[]) new byte[0].clone());
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f2757b;
    public transient String c;

    public g0(byte[] bArr) {
        this.a = bArr;
    }

    public String a() {
        byte[] bArr = this.a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = d;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int b() {
        return this.a.length;
    }

    public g0 c() {
        byte[] bArr = this.a;
        if (64 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.a.length + ")");
        }
        if (64 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, 64);
        return new g0(bArr2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x002d A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g0 g0Var = (g0) obj;
        int iB = b();
        int iB2 = g0Var.b();
        int iMin = Math.min(iB, iB2);
        for (int i = 0; i < iMin; i++) {
            int iA = a(i) & 255;
            int iA2 = g0Var.a(i) & 255;
            if (iA != iA2) {
                if (iA < iA2) {
                    return -1;
                }
                return 1;
            }
        }
        if (iB == iB2) {
            return 0;
        }
        if (iB < iB2) {
            return -1;
        }
        return 1;
    }

    public String d() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.a, sa.a);
        this.c = str2;
        return str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            int iB = g0Var.b();
            byte[] bArr = this.a;
            if (iB == bArr.length && g0Var.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f2757b;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.a);
        this.f2757b = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (this.a.length == 0) {
            return "[size=0]";
        }
        String strD = d();
        int length = strD.length();
        int length2 = 0;
        int i = 0;
        while (true) {
            if (length2 >= length) {
                length2 = strD.length();
                break;
            }
            if (i != 64) {
                int iCodePointAt = strD.codePointAt(length2);
                if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                    length2 = -1;
                    break;
                }
                i++;
                length2 += Character.charCount(iCodePointAt);
            } else {
                break;
            }
        }
        if (length2 == -1) {
            return this.a.length <= 64 ? "[hex=" + a() + "]" : "[size=" + this.a.length + " hex=" + c().a() + "…]";
        }
        String strReplace = strD.substring(0, length2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return (length2 < strD.length() ? new StringBuilder("[size=").append(this.a.length).append(" text=").append(strReplace).append("…]") : new StringBuilder("[text=").append(strReplace).append("]")).toString();
    }

    public byte a(int i) {
        return this.a[i];
    }

    public void a(b0 b0Var) {
        byte[] bArr = this.a;
        b0Var.a(bArr, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        boolean z;
        if (i >= 0) {
            byte[] bArr2 = this.a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
                Charset charset = sa.a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z = true;
                        break;
                    }
                    if (bArr2[i4 + i] != bArr[i4 + i2]) {
                        z = false;
                        break;
                    }
                    i4++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }
}
