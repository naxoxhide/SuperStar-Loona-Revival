package com.tapjoy.internal;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class p2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f2794b;
    public o2 c;
    public final byte[] a = new byte[256];
    public int d = 0;

    public final int[] a(int i) {
        int[] iArr;
        byte[] bArr = new byte[i * 3];
        try {
            this.f2794b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i2 + 1;
                    iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                    i3 = i6;
                    i2 = i7;
                } catch (BufferUnderflowException unused) {
                    this.c.f2789b = 1;
                    return iArr;
                }
            }
        } catch (BufferUnderflowException unused2) {
            iArr = null;
        }
        return iArr;
    }

    public final o2 b() {
        int iC;
        int iC2;
        int iC3;
        int iC4;
        int iC5;
        if (this.f2794b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.c;
        }
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) c());
        }
        if (str.startsWith("GIF")) {
            this.c.f = this.f2794b.getShort();
            this.c.g = this.f2794b.getShort();
            int iC6 = c();
            o2 o2Var = this.c;
            o2Var.h = (iC6 & 128) != 0;
            o2Var.i = 2 << (iC6 & 7);
            o2Var.j = c();
            o2 o2Var2 = this.c;
            c();
            o2Var2.getClass();
            if (this.c.h && !a()) {
                o2 o2Var3 = this.c;
                o2Var3.a = a(o2Var3.i);
                o2 o2Var4 = this.c;
                o2Var4.k = o2Var4.a[o2Var4.j];
            }
        } else {
            this.c.f2789b = 1;
        }
        if (!a()) {
            boolean z = false;
            while (!z && !a() && this.c.c <= Integer.MAX_VALUE) {
                int iC7 = c();
                if (iC7 == 33) {
                    int iC8 = c();
                    if (iC8 == 1) {
                        do {
                            iC5 = c();
                            ByteBuffer byteBuffer = this.f2794b;
                            byteBuffer.position(byteBuffer.position() + iC5);
                        } while (iC5 > 0);
                    } else if (iC8 == 249) {
                        this.c.d = new n2();
                        c();
                        int iC9 = c();
                        n2 n2Var = this.c.d;
                        int i2 = (iC9 & 28) >> 2;
                        n2Var.g = i2;
                        if (i2 == 0) {
                            n2Var.g = 1;
                        }
                        n2Var.f = (iC9 & 1) != 0;
                        short s = this.f2794b.getShort();
                        if (s < 2) {
                            s = 10;
                        }
                        n2 n2Var2 = this.c.d;
                        n2Var2.i = s * 10;
                        n2Var2.h = c();
                        c();
                    } else if (iC8 == 254) {
                        do {
                            iC4 = c();
                            ByteBuffer byteBuffer2 = this.f2794b;
                            byteBuffer2.position(byteBuffer2.position() + iC4);
                        } while (iC4 > 0);
                    } else if (iC8 != 255) {
                        do {
                            try {
                                iC3 = c();
                                ByteBuffer byteBuffer3 = this.f2794b;
                                byteBuffer3.position(byteBuffer3.position() + iC3);
                            } catch (IllegalArgumentException unused) {
                            }
                        } while (iC3 > 0);
                    } else {
                        int iC10 = c();
                        this.d = iC10;
                        if (iC10 > 0) {
                            int i3 = 0;
                            while (true) {
                                try {
                                    int i4 = this.d;
                                    if (i3 >= i4) {
                                        break;
                                    }
                                    int i5 = i4 - i3;
                                    this.f2794b.get(this.a, i3, i5);
                                    i3 += i5;
                                } catch (Exception unused2) {
                                    this.c.f2789b = 1;
                                }
                            }
                        }
                        String str2 = "";
                        for (int i6 = 0; i6 < 11; i6++) {
                            str2 = str2 + ((char) this.a[i6]);
                        }
                        if (str2.equals("NETSCAPE2.0")) {
                            do {
                                int iC11 = c();
                                this.d = iC11;
                                if (iC11 > 0) {
                                    int i7 = 0;
                                    while (true) {
                                        try {
                                            int i8 = this.d;
                                            if (i7 >= i8) {
                                                break;
                                            }
                                            int i9 = i8 - i7;
                                            this.f2794b.get(this.a, i7, i9);
                                            i7 += i9;
                                        } catch (Exception unused3) {
                                            this.c.f2789b = 1;
                                        }
                                    }
                                }
                                byte[] bArr = this.a;
                                if (bArr[0] == 1) {
                                    int i10 = bArr[1] & 255;
                                    int i11 = bArr[2] & 255;
                                    o2 o2Var5 = this.c;
                                    int i12 = (i11 << 8) | i10;
                                    o2Var5.l = i12;
                                    if (i12 == 0) {
                                        o2Var5.l = -1;
                                    }
                                }
                                if (this.d <= 0) {
                                    break;
                                }
                            } while (!a());
                        } else {
                            do {
                                iC2 = c();
                                ByteBuffer byteBuffer4 = this.f2794b;
                                byteBuffer4.position(byteBuffer4.position() + iC2);
                            } while (iC2 > 0);
                        }
                    }
                } else if (iC7 == 44) {
                    o2 o2Var6 = this.c;
                    if (o2Var6.d == null) {
                        o2Var6.d = new n2();
                    }
                    o2Var6.d.a = this.f2794b.getShort();
                    this.c.d.f2785b = this.f2794b.getShort();
                    this.c.d.c = this.f2794b.getShort();
                    this.c.d.d = this.f2794b.getShort();
                    int iC12 = c();
                    boolean z2 = (iC12 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iC12 & 7) + 1);
                    n2 n2Var3 = this.c.d;
                    n2Var3.e = (iC12 & 64) != 0;
                    if (z2) {
                        n2Var3.k = a(iPow);
                    } else {
                        n2Var3.k = null;
                    }
                    this.c.d.j = this.f2794b.position();
                    c();
                    do {
                        try {
                            iC = c();
                            ByteBuffer byteBuffer5 = this.f2794b;
                            byteBuffer5.position(byteBuffer5.position() + iC);
                        } catch (IllegalArgumentException unused4) {
                        }
                    } while (iC > 0);
                    if (!a()) {
                        o2 o2Var7 = this.c;
                        o2Var7.c++;
                        o2Var7.e.add(o2Var7.d);
                    }
                } else if (iC7 != 59) {
                    this.c.f2789b = 1;
                } else {
                    z = true;
                }
            }
            o2 o2Var8 = this.c;
            if (o2Var8.c < 0) {
                o2Var8.f2789b = 1;
            }
        }
        return this.c;
    }

    public final int c() {
        try {
            return this.f2794b.get() & 255;
        } catch (Exception unused) {
            this.c.f2789b = 1;
            return 0;
        }
    }

    public final boolean a() {
        return this.c.f2789b != 0;
    }
}
