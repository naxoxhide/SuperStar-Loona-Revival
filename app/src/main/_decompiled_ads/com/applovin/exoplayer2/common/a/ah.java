package com.applovin.exoplayer2.common.a;

/* JADX INFO: loaded from: classes.dex */
public final class ah {
    public static <T> T[] c(T[] tArr, int i) {
        return (T[]) aj.c(tArr, i);
    }

    static Object[] f(Object... objArr) {
        return d(objArr, objArr.length);
    }

    static Object[] d(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            b(objArr[i2], i2);
        }
        return objArr;
    }

    static Object b(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}
