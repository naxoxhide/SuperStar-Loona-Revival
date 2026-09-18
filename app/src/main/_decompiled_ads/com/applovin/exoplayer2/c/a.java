package com.applovin.exoplayer2.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    private int jF;

    public void clear() {
        this.jF = 0;
    }

    public final boolean gX() {
        return bv(Integer.MIN_VALUE);
    }

    public final boolean gY() {
        return bv(4);
    }

    public final boolean gZ() {
        return bv(1);
    }

    public final boolean ha() {
        return bv(268435456);
    }

    public final void bs(int i) {
        this.jF = i;
    }

    public final void bt(int i) {
        this.jF = i | this.jF;
    }

    public final void bu(int i) {
        this.jF = (~i) & this.jF;
    }

    protected final boolean bv(int i) {
        return (this.jF & i) == i;
    }
}
