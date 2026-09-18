package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C08089v {
    public static final C08089v A02;
    public static final C08089v A03;
    public static final C08089v A04;
    public static final C08089v A05;
    public static final C08089v A06;
    public final long A00;
    public final long A01;

    static {
        C08089v c08089v = new C08089v(0L, 0L);
        A04 = c08089v;
        A02 = new C08089v(Long.MAX_VALUE, Long.MAX_VALUE);
        A06 = new C08089v(Long.MAX_VALUE, 0L);
        A05 = new C08089v(0L, Long.MAX_VALUE);
        A03 = c08089v;
    }

    public C08089v(long j, long j2) {
        HI.A03(j >= 0);
        HI.A03(j2 >= 0);
        this.A01 = j;
        this.A00 = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C08089v c08089v = (C08089v) obj;
        return this.A01 == c08089v.A01 && this.A00 == c08089v.A00;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}
