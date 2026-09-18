package b.b.a.a.f.a.q;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Serializable, Comparable<b> {
    static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset e = Charset.forName("UTF-8");
    public static final b f = a(new byte[0]);
    final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient int f160b;
    transient String c;

    b(byte[] bArr) {
        this.a = bArr;
    }

    public static b a(byte... bArr) {
        if (bArr != null) {
            return new b((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String b() {
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

    public int c() {
        return this.a.length;
    }

    public String d() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.a, e);
        this.c = str2;
        return str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int iC = bVar.c();
            byte[] bArr = this.a;
            if (iC == bArr.length && bVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f160b;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.a);
        this.f160b = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (this.a.length == 0) {
            return "[size=0]";
        }
        String strD = d();
        int iA = a(strD, 64);
        if (iA == -1) {
            return this.a.length <= 64 ? "[hex=" + b() + "]" : "[size=" + this.a.length + " hex=" + a(0, 64).b() + "…]";
        }
        String strReplace = strD.substring(0, iA).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return (iA < strD.length() ? new StringBuilder().append("[size=").append(this.a.length).append(" text=").append(strReplace).append("…]") : new StringBuilder().append("[text=").append(strReplace).append("]")).toString();
    }

    public b a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.a;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.a.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new b(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte a(int i) {
        return this.a[i];
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && f.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        int iC = c();
        int iC2 = bVar.c();
        int iMin = Math.min(iC, iC2);
        for (int i = 0; i < iMin; i++) {
            int iA = a(i) & 255;
            int iA2 = bVar.a(i) & 255;
            if (iA != iA2) {
                return iA < iA2 ? -1 : 1;
            }
        }
        if (iC == iC2) {
            return 0;
        }
        return iC < iC2 ? -1 : 1;
    }

    static int a(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
