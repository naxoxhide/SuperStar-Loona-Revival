package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 implements m0 {
    public final o0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1277b;
    public final Object[] c;
    public final int d;

    public b1(o0 o0Var, String str, Object[] objArr) {
        char cCharAt;
        this.a = o0Var;
        this.f1277b = str;
        this.c = objArr;
        int i = 1;
        try {
            cCharAt = str.charAt(0);
        } catch (StringIndexOutOfBoundsException unused) {
            char[] charArray = str.toCharArray();
            String str2 = new String(charArray);
            try {
                try {
                    cCharAt = str2.charAt(0);
                    str = str2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    e = e;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e);
                } catch (StringIndexOutOfBoundsException e2) {
                    e = e2;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e);
                }
            } catch (StringIndexOutOfBoundsException unused2) {
                char[] cArr = new char[str2.length()];
                str2.getChars(0, str2.length(), cArr, 0);
                String str3 = new String(cArr);
                try {
                    cCharAt = str3.charAt(0);
                    str = str3;
                } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e3) {
                    e = e3;
                    str2 = str3;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e);
                }
            }
        }
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        while (true) {
            int i4 = i + 1;
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 55296) {
                this.d = (cCharAt2 << i3) | i2;
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i = i4;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.m0
    public y0 a() {
        return (this.d & 1) == 1 ? y0.PROTO2 : y0.PROTO3;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.m0
    public o0 b() {
        return this.a;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.m0
    public boolean c() {
        return (this.d & 2) == 2;
    }
}
