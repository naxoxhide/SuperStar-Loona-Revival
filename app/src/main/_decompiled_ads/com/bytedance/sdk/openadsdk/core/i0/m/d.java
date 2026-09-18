package com.bytedance.sdk.openadsdk.core.i0.m;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: VastUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final List<String> a = Arrays.asList("video/mp4", "video/3gpp");

    public static double a(int i, double d, int i2, int i3, int i4, String str) {
        double dA = a(i, d, i2, i3);
        return a(str) * (1.0d / ((dA + 1.0d) + a(i4)));
    }

    private static double a(int i, double d, int i2, int i3) {
        return (d > 0.0d ? Math.abs(d - (i3 > 0 ? ((double) i2) / ((double) i3) : 0.0d)) : 0.0d) + (i > 0 ? Math.abs((i - i2) / i) : 0.0d);
    }

    private static double a(int i) {
        int iMax = Math.max(i, 0);
        if (700 > iMax || iMax > 1500) {
            return Math.min(Math.abs(700 - iMax) / 700.0f, Math.abs(1500 - iMax) / 1500.0f);
        }
        return 0.0d;
    }

    private static double a(String str) {
        if (str == null) {
            str = "";
        }
        byte b2 = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != -1664118616) {
            if (iHashCode == 1331848029 && str.equals("video/mp4")) {
                b2 = 0;
            }
        } else if (str.equals("video/3gpp")) {
            b2 = 1;
        }
        return b2 != 0 ? 1.0d : 1.5d;
    }
}
