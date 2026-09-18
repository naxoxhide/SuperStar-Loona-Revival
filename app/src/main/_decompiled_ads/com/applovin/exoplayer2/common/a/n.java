package com.applovin.exoplayer2.common.a;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    private static final n pW = new n() { // from class: com.applovin.exoplayer2.common.a.n.1
        @Override // com.applovin.exoplayer2.common.a.n
        public int fQ() {
            return 0;
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public <T> n a(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
            return bf(comparator.compare(t, t2));
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n r(int i, int i2) {
            return bf(com.applovin.exoplayer2.common.b.c.w(i, i2));
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n i(long j, long j2) {
            return bf(com.applovin.exoplayer2.common.b.d.j(j, j2));
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n c(boolean z, boolean z2) {
            return bf(com.applovin.exoplayer2.common.b.a.e(z2, z));
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n d(boolean z, boolean z2) {
            return bf(com.applovin.exoplayer2.common.b.a.e(z, z2));
        }

        n bf(int i) {
            if (i < 0) {
                return n.pX;
            }
            return i > 0 ? n.pY : n.pW;
        }
    };
    private static final n pX = new a(-1);
    private static final n pY = new a(1);

    public abstract <T> n a(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    public abstract n c(boolean z, boolean z2);

    public abstract n d(boolean z, boolean z2);

    public abstract int fQ();

    public abstract n i(long j, long j2);

    public abstract n r(int i, int i2);

    private n() {
    }

    public static n fP() {
        return pW;
    }

    private static final class a extends n {
        final int pZ;

        @Override // com.applovin.exoplayer2.common.a.n
        public <T> n a(@NullableDecl T t, @NullableDecl T t2, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n c(boolean z, boolean z2) {
            return this;
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n d(boolean z, boolean z2) {
            return this;
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n i(long j, long j2) {
            return this;
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public n r(int i, int i2) {
            return this;
        }

        a(int i) {
            super();
            this.pZ = i;
        }

        @Override // com.applovin.exoplayer2.common.a.n
        public int fQ() {
            return this.pZ;
        }
    }
}
