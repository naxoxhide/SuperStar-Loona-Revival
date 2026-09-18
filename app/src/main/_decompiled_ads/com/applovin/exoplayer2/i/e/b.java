package com.applovin.exoplayer2.i.e;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
final class b {
    public final int RA;
    public final int RB;
    public final int Ry;
    public final int Rz;
    public final int fR;

    private b(int i, int i2, int i3, int i4, int i5) {
        this.Ry = i;
        this.Rz = i2;
        this.RA = i3;
        this.RB = i4;
        this.fR = i5;
    }

    public static b ac(String str) {
        com.applovin.exoplayer2.l.a.checkArgument(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String lowerCase = Ascii.toLowerCase(strArrSplit[i5].trim());
            lowerCase.hashCode();
            switch (lowerCase) {
                case "end":
                    i2 = i5;
                    break;
                case "text":
                    i4 = i5;
                    break;
                case "start":
                    i = i5;
                    break;
                case "style":
                    i3 = i5;
                    break;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new b(i, i2, i3, i4, strArrSplit.length);
    }
}
