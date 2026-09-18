package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0981Hi {
    public static String[] A04 = {"BtHKr", "GAfuq", "1TcIbYyYGpE6Ekv4glvvfZz9bC", "q9fmd3d0ImW5Daxca", "ooOXUvpeMSptobOLnq6qd7gNdq", "VwsWXVZM3brBJlmy9", "pSziVAe", "zUHU2CyO73eexnRwL2LOOWJW4Jr0bcWv"};
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    public C0981Hi(byte[] bArr, int i, int i2) {
        A08(bArr, i, i2);
    }

    private int A00() {
        int i = 0;
        while (!A0A()) {
            i++;
        }
        int i2 = (1 << i) - 1;
        int leadingZeros = i > 0 ? A05(i) : 0;
        return i2 + leadingZeros;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    private void A01() {
        boolean z;
        int i = this.A02;
        if (i >= 0) {
            int i2 = this.A01;
            if (A04[1].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "f06qvbC";
            strArr[0] = "HuIz9";
            if (i < i2 || (i == i2 && this.A00 == 0)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        HI.A04(z);
    }

    private boolean A02(int i) {
        if (2 <= i && i < this.A01) {
            byte[] bArr = this.A03;
            byte b2 = bArr[i];
            String[] strArr = A04;
            if (strArr[6].length() != strArr[0].length()) {
                String[] strArr2 = A04;
                strArr2[5] = "Jod3dkhqFQ8qWj2s5";
                strArr2[3] = "0zxF2BZpdiUX5xaGz";
                if (b2 == 3 && bArr[i - 2] == 0) {
                    byte b3 = bArr[i - 1];
                    String[] strArr3 = A04;
                    if (strArr3[6].length() != strArr3[0].length()) {
                        String[] strArr4 = A04;
                        strArr4[6] = "lQKXp2Z";
                        strArr4[0] = "Kosug";
                        if (b3 == 0) {
                            return true;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int A03() {
        int iA00 = A00();
        int codeNum = iA00 % 2;
        int i = codeNum == 0 ? -1 : 1;
        int codeNum2 = iA00 + 1;
        return i * (codeNum2 / 2);
    }

    public final int A04() {
        return A00();
    }

    public final int A05(int i) {
        int i2;
        int i3 = 0;
        int returnValue = this.A00;
        this.A00 = returnValue + i;
        while (true) {
            i2 = this.A00;
            int i4 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.A00 = i5;
            byte[] bArr = this.A03;
            int i6 = this.A02;
            int returnValue2 = bArr[i6];
            i3 |= (returnValue2 & 255) << i5;
            int returnValue3 = i6 + 1;
            if (!A02(returnValue3)) {
                i4 = 1;
            }
            this.A02 = i6 + i4;
        }
        byte[] bArr2 = this.A03;
        int i7 = this.A02;
        int returnValue4 = bArr2[i7];
        int i8 = returnValue4 & 255;
        String[] strArr = A04;
        String str = strArr[5];
        String str2 = strArr[3];
        int length = str.length();
        int returnValue5 = str2.length();
        if (length != returnValue5) {
            throw new RuntimeException();
        }
        A04[7] = "CI85ryy9UuGcWp4q0bXmx78DrLL4QG6i";
        int returnValue6 = 8 - i2;
        int i9 = i3 | (i8 >> returnValue6);
        int returnValue7 = (-1) >>> (32 - i);
        int i10 = i9 & returnValue7;
        if (i2 == 8) {
            this.A00 = 0;
            int returnValue8 = i7 + 1;
            this.A02 = i7 + (A02(returnValue8) ? 2 : 1);
        }
        A01();
        return i10;
    }

    public final void A06() {
        int i = this.A00 + 1;
        this.A00 = i;
        if (i == 8) {
            this.A00 = 0;
            int i2 = this.A02;
            this.A02 = i2 + (A02(i2 + 1) ? 2 : 1);
        }
        A01();
    }

    public final void A07(int i) {
        int i2 = this.A02;
        int oldByteOffset = i / 8;
        int numBytes = this.A02 + oldByteOffset;
        this.A02 = numBytes;
        int i3 = this.A00 + (i - (oldByteOffset * 8));
        this.A00 = i3;
        if (i3 > 7) {
            int i4 = numBytes + 1;
            String[] strArr = A04;
            if (strArr[2].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "WKnUhbHg5PXpVOXLjQbslPOixC";
            strArr2[4] = "5elOCNAU3UTje1WUqtoqjArHkZ";
            this.A02 = i4;
            this.A00 = i3 - 8;
        }
        int numBytes2 = i2 + 1;
        while (numBytes2 <= this.A02) {
            if (A02(numBytes2)) {
                this.A02++;
                numBytes2 += 2;
            }
            numBytes2++;
        }
        A01();
    }

    public final void A08(byte[] bArr, int i, int i2) {
        this.A03 = bArr;
        this.A02 = i;
        this.A01 = i2;
        this.A00 = 0;
        A01();
    }

    public final boolean A09() {
        int i = this.A02;
        int i2 = this.A00;
        int i3 = 0;
        while (initialBitOffset < initialByteOffset && !A0A()) {
            i3++;
        }
        int i4 = this.A02;
        int initialByteOffset = this.A01;
        int initialByteOffset2 = i4 == initialByteOffset ? 1 : 0;
        this.A02 = i;
        this.A00 = i2;
        if (initialByteOffset2 != 0) {
            return false;
        }
        int initialByteOffset3 = i3 * 2;
        return A0B(initialByteOffset3 + 1);
    }

    public final boolean A0A() {
        boolean returnValue = (this.A03[this.A02] & (128 >> this.A00)) != 0;
        A06();
        return returnValue;
    }

    public final boolean A0B(int i) {
        int numBytes = this.A02;
        int oldByteOffset = i / 8;
        int i2 = this.A02 + oldByteOffset;
        int newBitOffset = (this.A00 + i) - (oldByteOffset * 8);
        if (newBitOffset > 7) {
            i2++;
            newBitOffset -= 8;
        }
        int newByteOffset = numBytes + 1;
        while (newByteOffset <= i2 && i2 < this.A01) {
            if (A02(newByteOffset)) {
                i2++;
                newByteOffset += 2;
            }
            newByteOffset++;
        }
        int oldByteOffset2 = this.A01;
        if (i2 >= oldByteOffset2) {
            return i2 == oldByteOffset2 && newBitOffset == 0;
        }
        return true;
    }
}
