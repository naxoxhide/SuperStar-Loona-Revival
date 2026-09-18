package com.applovin.exoplayer2;

/* JADX INFO: loaded from: classes.dex */
public interface as {
    static int a(int i, int i2, int i3) {
        return i | i2 | i3;
    }

    static int af(int i) {
        return i & 7;
    }

    static int ag(int i) {
        return i & 32;
    }

    int M();

    int Z() throws p;

    int b(v vVar) throws p;

    String getName();

    static int ae(int i) {
        return a(i, 0, 0);
    }
}
