package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$Parameters;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GF implements Comparable<GF> {
    public static String[] A07 = {"eb8CGYK3prt3t", "dQfQVH0VaiNJA", "r8fXA", "r3rHNRtipUDB7ufPa7P3AvdqyjlNLgla", "2m", "YPC8s", "obzEXxZAmH6P4FrObF", "ImIsZWaiqjX9J"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final DefaultTrackSelector$Parameters A06;

    public GF(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int i) {
        this.A06 = defaultTrackSelector$Parameters;
        this.A05 = C0836Ay.A0H(i, false) ? 1 : 0;
        this.A03 = C0836Ay.A0K(format, defaultTrackSelector$Parameters.A07) ? 1 : 0;
        this.A02 = (format.A0D & 1) != 0 ? 1 : 0;
        this.A01 = format.A05;
        this.A04 = format.A0C;
        this.A00 = format.A04;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(GF gf) {
        int i = this.A05;
        int i2 = gf.A05;
        if (i != i2) {
            return C0836Ay.A01(i, i2);
        }
        int i3 = this.A03;
        int i4 = gf.A03;
        if (i3 != i4) {
            return C0836Ay.A01(i3, i4);
        }
        int i5 = this.A02;
        int i6 = gf.A02;
        if (i5 != i6) {
            return C0836Ay.A01(i5, i6);
        }
        if (this.A06.A0D) {
            return C0836Ay.A01(gf.A00, this.A00);
        }
        int i7 = this.A05 != 1 ? -1 : 1;
        int i8 = this.A01;
        int resultSign = gf.A01;
        if (i8 != resultSign) {
            int iA01 = C0836Ay.A01(i8, resultSign) * i7;
            String[] strArr = A07;
            if (strArr[4].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "P8pKjaXeFiun6";
            strArr2[0] = "9cxjYqXmdfp1O";
            return iA01;
        }
        int i9 = this.A04;
        int resultSign2 = gf.A04;
        return i9 != resultSign2 ? C0836Ay.A01(i9, resultSign2) * i7 : C0836Ay.A01(this.A00, gf.A00) * i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GF gf = (GF) obj;
        if (this.A05 == gf.A05 && this.A03 == gf.A03 && this.A02 == gf.A02 && this.A01 == gf.A01) {
            int i = this.A04;
            if (A07[3].charAt(10) != 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[5] = "D3QBn";
            strArr[2] = "QopBq";
            if (i == gf.A04 && this.A00 == gf.A00) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A05;
        int i = result * 31;
        int result2 = this.A03;
        int result3 = (((i + result2) * 31) + this.A02) * 31;
        int result4 = this.A01;
        int result5 = (((result3 + result4) * 31) + this.A04) * 31;
        int result6 = this.A00;
        return result5 + result6;
    }
}
