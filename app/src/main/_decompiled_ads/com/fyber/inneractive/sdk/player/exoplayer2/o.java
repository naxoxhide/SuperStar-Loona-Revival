package com.fyber.inneractive.sdk.player.exoplayer2;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f1173b = new o(0);
    public final int a;

    public o(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && o.class == obj.getClass() && this.a == ((o) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
