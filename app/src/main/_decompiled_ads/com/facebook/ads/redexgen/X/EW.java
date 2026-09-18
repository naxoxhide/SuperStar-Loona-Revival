package com.facebook.ads.redexgen.X;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EW {
    public static String[] A04 = {"TJGXeByBmTHQPhxlQWaLs9WTuhAPsvDn", "cTyjqlp8UNOQyLJMZAg4XzmxFMTsV66P", "jpK43NGJIXClE5ie7D0g7Fa1Rpa7kANX", "QOLMQ2OzOpXdQRVqr", "8HaEwRmcLljD6jWZTmAaPx2QrUAiOCOo", "DwqRJ6bMYzXyiD2Eugn3dkRE0I23BFLv", "IP6wvLF5I09xjY7fYX", "9PCiAf0"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;

    public EW(int i) {
        this(i, -1L);
    }

    public EW(int i, int i2, int i3, long j) {
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
        this.A03 = j;
    }

    public EW(int i, long j) {
        this(i, -1, -1, j);
    }

    public final EW A00(int i) {
        if (this.A02 == i) {
            return this;
        }
        return new EW(i, this.A00, this.A01, this.A03);
    }

    public final boolean A01() {
        return this.A00 != -1;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056 A[ORIG_RETURN, RETURN] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EW ew = (EW) obj;
        int i = this.A02;
        int i2 = ew.A02;
        if (A04[5].charAt(6) == 'n') {
            throw new RuntimeException();
        }
        A04[5] = "1RYqQKBI4tHo2l91LJlKc5yEyLaxvrL0";
        if (i == i2 && this.A00 == ew.A00) {
            int i3 = this.A01;
            if (A04[6].length() != 3) {
                A04[3] = "Mb83VhRFw0YfLpvsGxQ6UEzyZMUp7";
                if (i3 == ew.A01) {
                    if (this.A03 == ew.A03) {
                        return true;
                    }
                }
            } else if (i3 == ew.A01) {
                if (this.A03 == ew.A03) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A02;
        int result2 = ((((17 * 31) + result) * 31) + this.A00) * 31;
        int result3 = this.A01;
        return ((result2 + result3) * 31) + ((int) this.A03);
    }
}
