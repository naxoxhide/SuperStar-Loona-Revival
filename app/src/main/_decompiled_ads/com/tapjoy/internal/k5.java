package com.tapjoy.internal;

import java.io.EOFException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes4.dex */
public final class k5 extends u5 {
    public k5() {
        super(3, String.class);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws ProtocolException, EOFException {
        return ((b0) v5Var.a).b(v5Var.a());
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        char cCharAt;
        String str = (String) obj;
        b0 b0Var = (b0) w5Var.a;
        b0Var.getClass();
        int length = str.length();
        if (length >= 0) {
            if (length > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
            }
            int i = 0;
            while (i < length) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 128) {
                    u6 u6VarA = b0Var.a(1);
                    byte[] bArr = u6VarA.a;
                    int i2 = u6VarA.c - i;
                    int iMin = Math.min(length, 8192 - i2);
                    int i3 = i + 1;
                    bArr[i + i2] = (byte) cCharAt2;
                    while (true) {
                        i = i3;
                        if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i3 = i + 1;
                        bArr[i + i2] = (byte) cCharAt;
                    }
                    int i4 = u6VarA.c;
                    int i5 = (i2 + i) - i4;
                    u6VarA.c = i4 + i5;
                    b0Var.f2731b += (long) i5;
                } else {
                    if (cCharAt2 < 2048) {
                        b0Var.b((cCharAt2 >> 6) | 192);
                        b0Var.b((cCharAt2 & '?') | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i6 = i + 1;
                        char cCharAt3 = i6 < length ? str.charAt(i6) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i7 = (((cCharAt2 & (-55297)) << 10) | ((-56321) & cCharAt3)) + 65536;
                            b0Var.b((i7 >> 18) | 240);
                            b0Var.b(((i7 >> 12) & 63) | 128);
                            b0Var.b(((i7 >> 6) & 63) | 128);
                            b0Var.b((i7 & 63) | 128);
                            i += 2;
                        } else {
                            b0Var.b(63);
                            i = i6;
                        }
                    } else {
                        b0Var.b((cCharAt2 >> '\f') | 224);
                        b0Var.b(((cCharAt2 >> 6) & 63) | 128);
                        b0Var.b((cCharAt2 & '?') | 128);
                    }
                    i++;
                }
            }
            return;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0041  */
    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        int i;
        String str = (String) obj;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                i3++;
            } else if (cCharAt < 2048) {
                i3 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i3 += 3;
            } else if (cCharAt > 56319 || (i = i2 + 1) >= length || str.charAt(i) < 56320 || str.charAt(i) > 57343) {
                i3++;
            } else {
                i3 += 4;
                i2 = i;
            }
            i2++;
        }
        return i3;
    }
}
