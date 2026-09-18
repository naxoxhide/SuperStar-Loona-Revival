package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements Iterable<Byte>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f1293b = new h(y.f1314b);
    public static final e c;
    public int a = 0;

    public class a extends b {
        public int a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1294b;

        public a() {
            this.f1294b = i.this.size();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i.f
        public byte a() {
            int i = this.a;
            if (i >= this.f1294b) {
                throw new NoSuchElementException();
            }
            this.a = i + 1;
            return i.this.d(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.f1294b;
        }
    }

    public static abstract class b implements f {
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class c implements e {
        @Override // com.fyber.inneractive.sdk.protobuf.i.e
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public static final class d extends h {
        private static final long serialVersionUID = 1;
        public final int e;
        public final int f;

        public d(byte[] bArr, int i, int i2) {
            super(bArr);
            i.a(i, i + i2, bArr.length);
            this.e = i;
            this.f = i2;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i.h, com.fyber.inneractive.sdk.protobuf.i
        public void a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.d, this.e + i, bArr, i2, i3);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i.h, com.fyber.inneractive.sdk.protobuf.i
        public byte c(int i) {
            i.a(i, this.f);
            return this.d[this.e + i];
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i.h, com.fyber.inneractive.sdk.protobuf.i
        public byte d(int i) {
            return this.d[this.e + i];
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i.h
        public int j() {
            return this.e;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i.h, com.fyber.inneractive.sdk.protobuf.i
        public int size() {
            return this.f;
        }

        public Object writeReplace() {
            return new h(h());
        }
    }

    public interface e {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public interface f extends Iterator<Byte> {
        byte a();
    }

    public static abstract class g extends i {
        @Override // com.fyber.inneractive.sdk.protobuf.i, java.lang.Iterable
        public Iterator<Byte> iterator() {
            return new a();
        }
    }

    public static class h extends g {
        private static final long serialVersionUID = 1;
        public final byte[] d;

        public h(byte[] bArr) {
            bArr.getClass();
            this.d = bArr;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public void a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.d, i, bArr, i2, i3);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public final i b(int i, int i2) {
            int iA = i.a(i, i2, size());
            return iA == 0 ? i.f1293b : new d(this.d, j() + i, iA);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public byte c(int i) {
            return this.d[i];
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public byte d(int i) {
            return this.d[i];
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public final boolean e() {
            int iJ = j();
            return q1.b(this.d, iJ, size() + iJ);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i) || size() != ((i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof h)) {
                return obj.equals(this);
            }
            h hVar = (h) obj;
            int i = this.a;
            int i2 = hVar.a;
            if (i == 0 || i2 == 0 || i == i2) {
                return a(hVar, 0, size());
            }
            return false;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public final j g() {
            return j.a(this.d, j(), size(), true);
        }

        public int j() {
            return 0;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public int size() {
            return this.d.length;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public final void a(com.fyber.inneractive.sdk.protobuf.h hVar) throws IOException {
            hVar.a(this.d, j(), size());
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public final String a(Charset charset) {
            return new String(this.d, j(), size(), charset);
        }

        public final boolean a(i iVar, int i, int i2) {
            if (i2 <= iVar.size()) {
                int i3 = i + i2;
                if (i3 <= iVar.size()) {
                    if (iVar instanceof h) {
                        h hVar = (h) iVar;
                        byte[] bArr = this.d;
                        byte[] bArr2 = hVar.d;
                        int iJ = j() + i2;
                        int iJ2 = j();
                        int iJ3 = hVar.j() + i;
                        while (iJ2 < iJ) {
                            if (bArr[iJ2] != bArr2[iJ3]) {
                                return false;
                            }
                            iJ2++;
                            iJ3++;
                        }
                        return true;
                    }
                    return iVar.b(i, i3).equals(b(0, i2));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + iVar.size());
            }
            throw new IllegalArgumentException("Length too large: " + i2 + size());
        }

        @Override // com.fyber.inneractive.sdk.protobuf.i
        public final int b(int i, int i2, int i3) {
            byte[] bArr = this.d;
            int iJ = j() + i2;
            Charset charset = y.a;
            for (int i4 = iJ; i4 < iJ + i3; i4++) {
                i = (i * 31) + bArr[i4];
            }
            return i;
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.i$i, reason: collision with other inner class name */
    public static final class C0302i implements e {
        @Override // com.fyber.inneractive.sdk.protobuf.i.e
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    static {
        c = com.fyber.inneractive.sdk.protobuf.d.a() ? new C0302i() : new c();
    }

    public static i a(byte[] bArr, int i, int i2) {
        a(i, i + i2, bArr.length);
        return new h(c.a(bArr, i, i2));
    }

    public abstract String a(Charset charset);

    public abstract void a(com.fyber.inneractive.sdk.protobuf.h hVar) throws IOException;

    public abstract void a(byte[] bArr, int i, int i2, int i3);

    public abstract int b(int i, int i2, int i3);

    public abstract i b(int i, int i2);

    public abstract byte c(int i);

    public abstract byte d(int i);

    public abstract boolean e();

    public abstract boolean equals(Object obj);

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public f iterator() {
        return new a();
    }

    public abstract j g();

    public final byte[] h() {
        int size = size();
        if (size == 0) {
            return y.f1314b;
        }
        byte[] bArr = new byte[size];
        a(bArr, 0, 0, size);
        return bArr;
    }

    public final int hashCode() {
        int iB = this.a;
        if (iB == 0) {
            int size = size();
            iB = b(size, 0, size);
            if (iB == 0) {
                iB = 1;
            }
            this.a = iB;
        }
        return iB;
    }

    public final String i() {
        return size() == 0 ? "" : a(y.a);
    }

    public abstract int size();

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? i1.a(this) : i1.a(b(0, 47)) + "...";
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public static i a(String str) {
        return new h(str.getBytes(y.a));
    }

    public static void a(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    public static int a(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
