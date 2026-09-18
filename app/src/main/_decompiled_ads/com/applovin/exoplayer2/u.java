package com.applovin.exoplayer2;

/* JADX INFO: loaded from: classes.dex */
public final class u extends RuntimeException {
    public final int dm;

    private static String A(int i) {
        if (i == 1) {
            return "Player release timed out.";
        }
        if (i != 2) {
            return i != 3 ? "Undefined timeout." : "Detaching surface timed out.";
        }
        return "Setting foreground mode timed out.";
    }

    public u(int i) {
        super(A(i));
        this.dm = i;
    }
}
