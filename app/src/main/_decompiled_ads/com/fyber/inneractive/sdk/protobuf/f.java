package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements c1 {

    public static final class b extends f {
        public final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f1282b;
        public int c;
        public int d;
        public int e;
        public int f;

        public b(ByteBuffer byteBuffer, boolean z) {
            super();
            this.a = z;
            this.f1282b = byteBuffer.array();
            this.c = byteBuffer.arrayOffset() + byteBuffer.position();
            this.d = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        public final int A() throws IOException {
            int i;
            int i2 = this.c;
            int i3 = this.d;
            if (i3 == i2) {
                throw z.i();
            }
            byte[] bArr = this.f1282b;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.c = i4;
                return b2;
            }
            if (i3 - i4 < 9) {
                return (int) C();
            }
            int i5 = i4 + 1;
            int i6 = b2 ^ (bArr[i4] << 7);
            if (i6 < 0) {
                i = i6 ^ (-128);
            } else {
                int i7 = i5 + 1;
                int i8 = i6 ^ (bArr[i5] << 14);
                if (i8 >= 0) {
                    i = i8 ^ 16256;
                } else {
                    i5 = i7 + 1;
                    int i9 = i8 ^ (bArr[i7] << 21);
                    if (i9 < 0) {
                        i = i9 ^ (-2080896);
                    } else {
                        i7 = i5 + 1;
                        byte b3 = bArr[i5];
                        i = (i9 ^ (b3 << 28)) ^ 266354560;
                        if (b3 < 0) {
                            i5 = i7 + 1;
                            if (bArr[i7] < 0) {
                                i7 = i5 + 1;
                                if (bArr[i5] < 0) {
                                    i5 = i7 + 1;
                                    if (bArr[i7] < 0) {
                                        i7 = i5 + 1;
                                        if (bArr[i5] < 0) {
                                            i5 = i7 + 1;
                                            if (bArr[i7] < 0) {
                                                throw z.e();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i5 = i7;
            }
            this.c = i5;
            return i;
        }

        public long B() throws IOException {
            long j;
            long j2;
            long j3;
            int i;
            int i2 = this.c;
            int i3 = this.d;
            if (i3 == i2) {
                throw z.i();
            }
            byte[] bArr = this.f1282b;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.c = i4;
                return b2;
            }
            if (i3 - i4 < 9) {
                return C();
            }
            int i5 = i4 + 1;
            int i6 = b2 ^ (bArr[i4] << 7);
            if (i6 >= 0) {
                int i7 = i5 + 1;
                int i8 = i6 ^ (bArr[i5] << 14);
                if (i8 >= 0) {
                    i5 = i7;
                    j = i8 ^ 16256;
                } else {
                    i5 = i7 + 1;
                    int i9 = i8 ^ (bArr[i7] << 21);
                    if (i9 < 0) {
                        i = i9 ^ (-2080896);
                    } else {
                        long j4 = i9;
                        int i10 = i5 + 1;
                        long j5 = j4 ^ (((long) bArr[i5]) << 28);
                        if (j5 >= 0) {
                            j3 = 266354560;
                        } else {
                            i5 = i10 + 1;
                            long j6 = j5 ^ (((long) bArr[i10]) << 35);
                            if (j6 < 0) {
                                j2 = -34093383808L;
                            } else {
                                i10 = i5 + 1;
                                j5 = j6 ^ (((long) bArr[i5]) << 42);
                                if (j5 >= 0) {
                                    j3 = 4363953127296L;
                                } else {
                                    i5 = i10 + 1;
                                    j6 = j5 ^ (((long) bArr[i10]) << 49);
                                    if (j6 < 0) {
                                        j2 = -558586000294016L;
                                    } else {
                                        int i11 = i5 + 1;
                                        long j7 = (j6 ^ (((long) bArr[i5]) << 56)) ^ 71499008037633920L;
                                        if (j7 < 0) {
                                            i5 = i11 + 1;
                                            if (bArr[i11] < 0) {
                                                throw z.e();
                                            }
                                        } else {
                                            i5 = i11;
                                        }
                                        j = j7;
                                    }
                                }
                            }
                            j = j6 ^ j2;
                        }
                        j = j5 ^ j3;
                        i5 = i10;
                    }
                }
                this.c = i5;
                return j;
            }
            i = i6 ^ (-128);
            j = i;
            this.c = i5;
            return j;
        }

        public final long C() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte bV = v();
                j |= ((long) (bV & 127)) << i;
                if ((bV & 128) == 0) {
                    return j;
                }
            }
            throw z.e();
        }

        public String a(boolean z) throws IOException {
            c(2);
            int iA = A();
            if (iA == 0) {
                return "";
            }
            a(iA);
            if (z) {
                byte[] bArr = this.f1282b;
                int i = this.c;
                if (!q1.b(bArr, i, i + iA)) {
                    throw z.c();
                }
            }
            String str = new String(this.f1282b, this.c, iA, y.a);
            this.c += iA;
            return str;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public <T> T b(Class<T> cls, q qVar) throws IOException {
            c(2);
            return (T) d(z0.c.a(cls), qVar);
        }

        public final <T> T c(d1<T> d1Var, q qVar) throws IOException {
            int i = this.f;
            int i2 = this.e;
            int i3 = r1.a;
            this.f = r1.a(i2 >>> 3, 4);
            try {
                T tA = d1Var.a();
                d1Var.a(tA, this, qVar);
                d1Var.c(tA);
                if (this.e != this.f) {
                    throw z.g();
                }
                this.f = i;
                return tA;
            } catch (Throwable th) {
                this.f = i;
                throw th;
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int d() throws IOException {
            c(0);
            return A();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int e() {
            return this.e;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public long f() throws IOException {
            c(0);
            return B();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public long g() throws IOException {
            c(1);
            return y();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public double h() throws IOException {
            c(1);
            return Double.longBitsToDouble(y());
        }

        /* JADX WARN: Code duplicated, block: B:44:0x007a  */
        /* JADX WARN: Code duplicated, block: B:47:0x0081 A[LOOP:2: B:43:0x0078->B:47:0x0081, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:57:0x0080 A[SYNTHETIC] */
        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public boolean i() throws IOException {
            int i;
            int i2;
            if (u() || (i = this.e) == (i2 = this.f)) {
                return false;
            }
            int i3 = r1.a;
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 == 1) {
                    d(8);
                    return true;
                }
                if (i4 == 2) {
                    d(A());
                    return true;
                }
                if (i4 != 3) {
                    if (i4 != 5) {
                        throw z.d();
                    }
                    d(4);
                    return true;
                }
                this.f = r1.a(i >>> 3, 4);
                while (s() != Integer.MAX_VALUE && i()) {
                }
                if (this.e != this.f) {
                    throw z.g();
                }
                this.f = i2;
                return true;
            }
            int i5 = this.d;
            int i6 = this.c;
            if (i5 - i6 < 10) {
                for (int i7 = 0; i7 < 10; i7++) {
                    if (v() >= 0) {
                    }
                }
                throw z.e();
            }
            byte[] bArr = this.f1282b;
            int i8 = 0;
            while (i8 < 10) {
                int i9 = i6 + 1;
                if (bArr[i6] >= 0) {
                    this.c = i9;
                } else {
                    i8++;
                    i6 = i9;
                }
            }
            while (i7 < 10) {
                if (v() >= 0) {
                }
            }
            throw z.e();
            return true;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int j() throws IOException {
            c(0);
            return j.b(A());
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public float k() throws IOException {
            c(5);
            return Float.intBitsToFloat(w());
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public long l() throws IOException {
            c(0);
            return j.a(B());
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int m() throws IOException {
            c(5);
            return w();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public String n() throws IOException {
            return a(false);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public long o() throws IOException {
            c(0);
            return B();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public String p() throws IOException {
            return a(true);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int q() throws IOException {
            c(5);
            return w();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public boolean r() throws IOException {
            c(0);
            return A() != 0;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int s() throws IOException {
            if (u()) {
                return Integer.MAX_VALUE;
            }
            int iA = A();
            this.e = iA;
            if (iA == this.f) {
                return Integer.MAX_VALUE;
            }
            int i = r1.a;
            return iA >>> 3;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public long t() throws IOException {
            c(1);
            return y();
        }

        public final boolean u() {
            return this.c == this.d;
        }

        public final byte v() throws IOException {
            int i = this.c;
            if (i == this.d) {
                throw z.i();
            }
            byte[] bArr = this.f1282b;
            this.c = i + 1;
            return bArr[i];
        }

        public final int w() throws IOException {
            a(4);
            return x();
        }

        public final int x() {
            int i = this.c;
            byte[] bArr = this.f1282b;
            this.c = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public final long y() throws IOException {
            a(8);
            return z();
        }

        public final long z() {
            int i = this.c;
            byte[] bArr = this.f1282b;
            this.c = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void e(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (!(list instanceof x)) {
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 2) {
                    int iA = A();
                    e(iA);
                    int i6 = this.c + iA;
                    while (this.c < i6) {
                        list.add(Integer.valueOf(x()));
                    }
                    return;
                }
                if (i5 != 5) {
                    throw z.d();
                }
                do {
                    list.add(Integer.valueOf(q()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            x xVar = (x) list;
            int i7 = this.e;
            int i8 = r1.a;
            int i9 = i7 & 7;
            if (i9 == 2) {
                int iA2 = A();
                e(iA2);
                int i10 = this.c + iA2;
                while (this.c < i10) {
                    xVar.c(x());
                }
                return;
            }
            if (i9 != 5) {
                throw z.d();
            }
            do {
                xVar.c(q());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (A() == this.e);
            this.c = i2;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void n(List<Long> list) throws IOException {
            int i;
            int i2;
            if (!(list instanceof f0)) {
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 1) {
                    do {
                        list.add(Long.valueOf(g()));
                        if (u()) {
                            return;
                        } else {
                            i = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i;
                    return;
                }
                if (i5 != 2) {
                    throw z.d();
                }
                int iA = A();
                f(iA);
                int i6 = this.c + iA;
                while (this.c < i6) {
                    list.add(Long.valueOf(z()));
                }
                return;
            }
            f0 f0Var = (f0) list;
            int i7 = this.e;
            int i8 = r1.a;
            int i9 = i7 & 7;
            if (i9 == 1) {
                do {
                    f0Var.a(g());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (A() == this.e);
                this.c = i2;
                return;
            }
            if (i9 != 2) {
                throw z.d();
            }
            int iA2 = A();
            f(iA2);
            int i10 = this.c + iA2;
            while (this.c < i10) {
                f0Var.a(z());
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void p(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (!(list instanceof x)) {
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 != 2) {
                        throw z.d();
                    }
                    int iA = this.c + A();
                    while (this.c < iA) {
                        list.add(Integer.valueOf(A()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(b()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            x xVar = (x) list;
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw z.d();
                }
                int iA2 = this.c + A();
                while (this.c < iA2) {
                    xVar.c(A());
                }
                return;
            }
            do {
                xVar.c(b());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (A() == this.e);
            this.c = i2;
        }

        public final <T> T d(d1<T> d1Var, q qVar) throws IOException {
            int iA = A();
            a(iA);
            int i = this.d;
            int i2 = this.c + iA;
            this.d = i2;
            try {
                T tA = d1Var.a();
                d1Var.a(tA, this, qVar);
                d1Var.c(tA);
                if (this.c == i2) {
                    this.d = i;
                    return tA;
                }
                throw z.g();
            } catch (Throwable th) {
                this.d = i;
                throw th;
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void f(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 2) {
                    int iA = A();
                    e(iA);
                    int i6 = this.c + iA;
                    while (this.c < i6) {
                        xVar.c(x());
                    }
                    return;
                }
                if (i5 == 5) {
                    do {
                        xVar.c(m());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                throw z.d();
            }
            int i7 = this.e;
            int i8 = r1.a;
            int i9 = i7 & 7;
            if (i9 == 2) {
                int iA2 = A();
                e(iA2);
                int i10 = this.c + iA2;
                while (this.c < i10) {
                    list.add(Integer.valueOf(x()));
                }
                return;
            }
            if (i9 == 5) {
                do {
                    list.add(Integer.valueOf(m()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void g(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 == 2) {
                        int iA = this.c + A();
                        while (this.c < iA) {
                            f0Var.a(j.a(B()));
                        }
                        return;
                    }
                    throw z.d();
                }
                do {
                    f0Var.a(l());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (A() == this.e);
                this.c = i2;
                return;
            }
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 == 2) {
                    int iA2 = this.c + A();
                    while (this.c < iA2) {
                        list.add(Long.valueOf(j.a(B())));
                    }
                    return;
                }
                throw z.d();
            }
            do {
                list.add(Long.valueOf(l()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (A() == this.e);
            this.c = i;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void h(List<i> list) throws IOException {
            int i;
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) == 2) {
                do {
                    list.add(a());
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void j(List<Double> list) throws IOException {
            int i;
            int i2;
            if (list instanceof n) {
                n nVar = (n) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 1) {
                    do {
                        nVar.a(h());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                if (i5 == 2) {
                    int iA = A();
                    f(iA);
                    int i6 = this.c + iA;
                    while (this.c < i6) {
                        nVar.a(Double.longBitsToDouble(z()));
                    }
                    return;
                }
                throw z.d();
            }
            int i7 = this.e;
            int i8 = r1.a;
            int i9 = i7 & 7;
            if (i9 == 1) {
                do {
                    list.add(Double.valueOf(h()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            if (i9 == 2) {
                int iA2 = A();
                f(iA2);
                int i10 = this.c + iA2;
                while (this.c < i10) {
                    list.add(Double.valueOf(Double.longBitsToDouble(z())));
                }
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void k(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        f0Var.a(o());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                if (i5 == 2) {
                    int iA = this.c + A();
                    while (this.c < iA) {
                        f0Var.a(B());
                    }
                    b(iA);
                    return;
                }
                throw z.d();
            }
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 == 0) {
                do {
                    list.add(Long.valueOf(o()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            if (i8 == 2) {
                int iA2 = this.c + A();
                while (this.c < iA2) {
                    list.add(Long.valueOf(B()));
                }
                b(iA2);
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void l(List<Boolean> list) throws IOException {
            int i;
            int i2;
            if (list instanceof g) {
                g gVar = (g) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 == 2) {
                        int iA = this.c + A();
                        while (this.c < iA) {
                            gVar.a(A() != 0);
                        }
                        b(iA);
                        return;
                    }
                    throw z.d();
                }
                do {
                    gVar.a(r());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (A() == this.e);
                this.c = i2;
                return;
            }
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 == 2) {
                    int iA2 = this.c + A();
                    while (this.c < iA2) {
                        list.add(Boolean.valueOf(A() != 0));
                    }
                    b(iA2);
                    return;
                }
                throw z.d();
            }
            do {
                list.add(Boolean.valueOf(r()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (A() == this.e);
            this.c = i;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void m(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 1) {
                    do {
                        f0Var.a(t());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                if (i5 == 2) {
                    int iA = A();
                    f(iA);
                    int i6 = this.c + iA;
                    while (this.c < i6) {
                        f0Var.a(z());
                    }
                    return;
                }
                throw z.d();
            }
            int i7 = this.e;
            int i8 = r1.a;
            int i9 = i7 & 7;
            if (i9 == 1) {
                do {
                    list.add(Long.valueOf(t()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            if (i9 == 2) {
                int iA2 = A();
                f(iA2);
                int i10 = this.c + iA2;
                while (this.c < i10) {
                    list.add(Long.valueOf(z()));
                }
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void o(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        xVar.c(d());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                if (i5 == 2) {
                    int iA = this.c + A();
                    while (this.c < iA) {
                        xVar.c(A());
                    }
                    b(iA);
                    return;
                }
                throw z.d();
            }
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 == 0) {
                do {
                    list.add(Integer.valueOf(d()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            if (i8 == 2) {
                int iA2 = this.c + A();
                while (this.c < iA2) {
                    list.add(Integer.valueOf(A()));
                }
                b(iA2);
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void q(List<String> list) throws IOException {
            a(list, false);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public <T> T b(d1<T> d1Var, q qVar) throws IOException {
            c(2);
            return (T) d(d1Var, qVar);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int b() throws IOException {
            c(0);
            return A();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void b(List<String> list) throws IOException {
            a(list, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public <T> void b(List<T> list, d1<T> d1Var, q qVar) throws IOException {
            int i;
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) == 2) {
                do {
                    list.add(d(d1Var, qVar));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == i2);
                this.c = i;
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public <T> T a(Class<T> cls, q qVar) throws IOException {
            c(3);
            return (T) c(z0.c.a(cls), qVar);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public <T> T a(d1<T> d1Var, q qVar) throws IOException {
            c(3);
            return (T) c(d1Var, qVar);
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public i a() throws IOException {
            i iVarA;
            c(2);
            int iA = A();
            if (iA == 0) {
                return i.f1293b;
            }
            a(iA);
            if (this.a) {
                byte[] bArr = this.f1282b;
                int i = this.c;
                i iVar = i.f1293b;
                iVarA = new i.d(bArr, i, iA);
            } else {
                iVarA = i.a(this.f1282b, this.c, iA);
            }
            this.c += iA;
            return iVarA;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public int c() throws IOException {
            c(0);
            return A();
        }

        public final void b(int i) throws IOException {
            if (this.c != i) {
                throw z.i();
            }
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void c(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 == 2) {
                        int iA = this.c + A();
                        while (this.c < iA) {
                            xVar.c(j.b(A()));
                        }
                        return;
                    }
                    throw z.d();
                }
                do {
                    xVar.c(j());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (A() == this.e);
                this.c = i2;
                return;
            }
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 == 2) {
                    int iA2 = this.c + A();
                    while (this.c < iA2) {
                        list.add(Integer.valueOf(j.b(A())));
                    }
                    return;
                }
                throw z.d();
            }
            do {
                list.add(Integer.valueOf(j()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (A() == this.e);
            this.c = i;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void a(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof f0) {
                f0 f0Var = (f0) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    do {
                        f0Var.a(f());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                if (i5 == 2) {
                    int iA = this.c + A();
                    while (this.c < iA) {
                        f0Var.a(B());
                    }
                    b(iA);
                    return;
                }
                throw z.d();
            }
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 == 0) {
                do {
                    list.add(Long.valueOf(f()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            if (i8 == 2) {
                int iA2 = this.c + A();
                while (this.c < iA2) {
                    list.add(Long.valueOf(B()));
                }
                b(iA2);
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void d(List<Float> list) throws IOException {
            int i;
            int i2;
            if (list instanceof v) {
                v vVar = (v) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 == 2) {
                    int iA = A();
                    e(iA);
                    int i6 = this.c + iA;
                    while (this.c < i6) {
                        vVar.a(Float.intBitsToFloat(x()));
                    }
                    return;
                }
                if (i5 == 5) {
                    do {
                        vVar.a(k());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                throw z.d();
            }
            int i7 = this.e;
            int i8 = r1.a;
            int i9 = i7 & 7;
            if (i9 == 2) {
                int iA2 = A();
                e(iA2);
                int i10 = this.c + iA2;
                while (this.c < i10) {
                    list.add(Float.valueOf(Float.intBitsToFloat(x())));
                }
                return;
            }
            if (i9 == 5) {
                do {
                    list.add(Float.valueOf(k()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public void i(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof x) {
                x xVar = (x) list;
                int i3 = this.e;
                int i4 = r1.a;
                int i5 = i3 & 7;
                if (i5 != 0) {
                    if (i5 == 2) {
                        int iA = this.c + A();
                        while (this.c < iA) {
                            xVar.c(A());
                        }
                        return;
                    }
                    throw z.d();
                }
                do {
                    xVar.c(c());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (A() == this.e);
                this.c = i2;
                return;
            }
            int i6 = this.e;
            int i7 = r1.a;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 == 2) {
                    int iA2 = this.c + A();
                    while (this.c < iA2) {
                        list.add(Integer.valueOf(A()));
                    }
                    return;
                }
                throw z.d();
            }
            do {
                list.add(Integer.valueOf(c()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (A() == this.e);
            this.c = i;
        }

        public final void e(int i) throws IOException {
            a(i);
            if ((i & 3) != 0) {
                throw z.g();
            }
        }

        public final void f(int i) throws IOException {
            a(i);
            if ((i & 7) != 0) {
                throw z.g();
            }
        }

        public final void c(int i) throws IOException {
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) != i) {
                throw z.d();
            }
        }

        public void a(List<String> list, boolean z) throws IOException {
            int i;
            int i2;
            int i3 = this.e;
            int i4 = r1.a;
            if ((i3 & 7) == 2) {
                if ((list instanceof d0) && !z) {
                    d0 d0Var = (d0) list;
                    do {
                        d0Var.a(a());
                        if (u()) {
                            return;
                        } else {
                            i2 = this.c;
                        }
                    } while (A() == this.e);
                    this.c = i2;
                    return;
                }
                do {
                    list.add(a(z));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == this.e);
                this.c = i;
                return;
            }
            throw z.d();
        }

        public final void d(int i) throws IOException {
            a(i);
            this.c += i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public <T> void a(List<T> list, d1<T> d1Var, q qVar) throws IOException {
            int i;
            int i2 = this.e;
            int i3 = r1.a;
            if ((i2 & 7) == 3) {
                do {
                    list.add(c(d1Var, qVar));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (A() == i2);
                this.c = i;
                return;
            }
            throw z.d();
        }

        @Override // com.fyber.inneractive.sdk.protobuf.c1
        public <K, V> void a(Map<K, V> map, h0.a<K, V> aVar, q qVar) throws IOException {
            c(2);
            int iA = A();
            a(iA);
            int i = this.d;
            this.d = this.c + iA;
            try {
                throw null;
            } catch (Throwable th) {
                this.d = i;
                throw th;
            }
        }

        public final void a(int i) throws IOException {
            if (i < 0 || i > this.d - this.c) {
                throw z.i();
            }
        }
    }

    public f() {
    }
}
