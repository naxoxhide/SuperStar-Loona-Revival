package com.tapjoy.internal;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public final class v5 {
    public final d0 a;
    public int d;
    public int h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2825b = 0;
    public long c = Long.MAX_VALUE;
    public int e = 2;
    public int f = -1;
    public long g = -1;

    public v5(b0 b0Var) {
        this.a = b0Var;
    }

    public final void a(long j) throws IOException {
        if (this.e != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.d - 1;
        this.d = i;
        if (i < 0 || this.g != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.f2825b != this.c && i != 0) {
            throw new IOException("Expected to end at " + this.c + " but was " + this.f2825b);
        }
        this.c = j;
    }

    public final long b() throws IOException {
        if (this.e != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.d + 1;
        this.d = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.g;
        this.g = -1L;
        this.e = 6;
        return j;
    }

    public final int c() throws ProtocolException {
        int i;
        this.f2825b++;
        byte b2 = ((b0) this.a).b();
        if (b2 >= 0) {
            return b2;
        }
        int i2 = b2 & 127;
        this.f2825b++;
        byte b3 = ((b0) this.a).b();
        if (b3 >= 0) {
            i = b3 << 7;
        } else {
            i2 |= (b3 & 127) << 7;
            this.f2825b++;
            byte b4 = ((b0) this.a).b();
            if (b4 >= 0) {
                i = b4 << 14;
            } else {
                i2 |= (b4 & 127) << 14;
                this.f2825b++;
                byte b5 = ((b0) this.a).b();
                if (b5 < 0) {
                    int i3 = i2 | ((b5 & 127) << 21);
                    this.f2825b++;
                    byte b6 = ((b0) this.a).b();
                    int i4 = i3 | (b6 << 28);
                    if (b6 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.f2825b++;
                        if (((b0) this.a).b() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i = b5 << 21;
            }
        }
        return i2 | i;
    }

    public final int d() throws IOException {
        int i = this.e;
        if (i == 7) {
            this.e = 2;
            return this.f;
        }
        if (i != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.f2825b < this.c) {
            if (((b0) this.a).f2731b == 0) {
                return -1;
            }
            int iC = c();
            if (iC == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iC >> 3;
            this.f = i2;
            int i3 = iC & 7;
            if (i3 == 0) {
                this.h = 1;
                this.e = 0;
                return i2;
            }
            if (i3 == 1) {
                this.h = 2;
                this.e = 1;
                return i2;
            }
            if (i3 == 2) {
                this.h = 3;
                this.e = 2;
                int iC2 = c();
                if (iC2 < 0) {
                    throw new ProtocolException("Negative length: " + iC2);
                }
                if (this.g != -1) {
                    throw new IllegalStateException();
                }
                long j = this.c;
                this.g = j;
                long j2 = this.f2825b + ((long) iC2);
                this.c = j2;
                if (j2 <= j) {
                    return this.f;
                }
                throw new EOFException();
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i3 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i3);
                }
                this.h = 4;
                this.e = 5;
                return i2;
            }
            b(i2);
        }
        return -1;
    }

    public final int e() throws IOException {
        int i = this.e;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.e);
        }
        b0 b0Var = (b0) this.a;
        if (b0Var.f2731b < 4) {
            throw new EOFException();
        }
        this.f2825b += 4;
        int iD = b0Var.d();
        Charset charset = sa.a;
        int i2 = ((iD & 255) << 24) | (((-16777216) & iD) >>> 24) | ((16711680 & iD) >>> 8) | ((65280 & iD) << 8);
        a(5);
        return i2;
    }

    public final long f() throws IOException {
        long jD;
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.e);
        }
        b0 b0Var = (b0) this.a;
        if (b0Var.f2731b < 8) {
            throw new EOFException();
        }
        this.f2825b += 8;
        long j = b0Var.f2731b;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + b0Var.f2731b);
        }
        u6 u6Var = b0Var.a;
        int i2 = u6Var.f2820b;
        int i3 = u6Var.c;
        if (i3 - i2 < 8) {
            jD = ((((long) b0Var.d()) & 4294967295L) << 32) | (4294967295L & ((long) b0Var.d()));
        } else {
            byte[] bArr = u6Var.a;
            int i4 = i2 + 1;
            long j2 = (((long) bArr[i2]) & 255) << 56;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            long j3 = ((((long) bArr[i4]) & 255) << 48) | j2 | ((((long) bArr[i5]) & 255) << 40);
            int i7 = i6 + 1;
            long j4 = j3 | ((((long) bArr[i6]) & 255) << 32);
            int i8 = i7 + 1;
            long j5 = j4 | ((((long) bArr[i7]) & 255) << 24);
            int i9 = i8 + 1;
            long j6 = j5 | ((((long) bArr[i8]) & 255) << 16);
            int i10 = i9 + 1;
            long j7 = j6 | ((((long) bArr[i9]) & 255) << 8);
            int i11 = i10 + 1;
            jD = j7 | (((long) bArr[i10]) & 255);
            b0Var.f2731b = j - 8;
            if (i11 == i3) {
                b0Var.a = u6Var.a();
                v6.a(u6Var);
            } else {
                u6Var.f2820b = i11;
            }
        }
        long jA = sa.a(jD);
        a(1);
        return jA;
    }

    public final int g() {
        int i = this.e;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
        }
        int iC = c();
        a(0);
        return iC;
    }

    public final long h() throws IOException {
        int i = this.e;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.f2825b++;
            byte b2 = ((b0) this.a).b();
            j |= ((long) (b2 & 127)) << i2;
            if ((b2 & 128) == 0) {
                a(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final void a(int i) throws IOException {
        if (this.e == i) {
            this.e = 6;
            return;
        }
        long j = this.f2825b;
        long j2 = this.c;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.c + " but was " + this.f2825b);
        }
        if (j == j2) {
            this.c = this.g;
            this.g = -1L;
            this.e = 6;
            return;
        }
        this.e = 7;
    }

    public final void b(int i) throws IOException {
        while (this.f2825b < this.c) {
            if (((b0) this.a).f2731b == 0) {
                break;
            }
            int iC = c();
            if (iC == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = iC >> 3;
            int i3 = iC & 7;
            if (i3 == 0) {
                this.e = 0;
                h();
            } else if (i3 == 1) {
                this.e = 1;
                f();
            } else if (i3 == 2) {
                long jC = c();
                this.f2825b += jC;
                b0 b0Var = (b0) this.a;
                while (jC > 0) {
                    u6 u6Var = b0Var.a;
                    if (u6Var != null) {
                        int iMin = (int) Math.min(jC, u6Var.c - u6Var.f2820b);
                        long j = iMin;
                        b0Var.f2731b -= j;
                        jC -= j;
                        u6 u6Var2 = b0Var.a;
                        int i4 = u6Var2.f2820b + iMin;
                        u6Var2.f2820b = i4;
                        if (i4 == u6Var2.c) {
                            b0Var.a = u6Var2.a();
                            v6.a(u6Var2);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                b0Var.getClass();
            } else if (i3 == 3) {
                b(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else {
                if (i3 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i3);
                }
                this.e = 5;
                e();
            }
        }
        throw new EOFException();
    }

    public final long a() throws ProtocolException, EOFException {
        if (this.e == 2) {
            long j = this.c;
            long j2 = j - this.f2825b;
            if (((b0) this.a).f2731b >= j2) {
                this.e = 6;
                this.f2825b = j;
                this.c = this.g;
                this.g = -1L;
                return j2;
            }
            throw new EOFException();
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.e);
    }
}
