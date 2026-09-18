package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.am;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface h {

    public interface c {
        void A(boolean z);

        default void E(long j) {
        }

        default void F(long j) {
        }

        default void b(Exception exc) {
        }

        void dQ();

        default void dR() {
        }

        void e(int i, long j, long j2);
    }

    long F(boolean z);

    void G(boolean z);

    void Y();

    void a(am amVar);

    void a(com.applovin.exoplayer2.b.d dVar);

    void a(c cVar);

    void a(k kVar);

    void a(com.applovin.exoplayer2.v vVar, int i, int[] iArr) throws a;

    boolean a(ByteBuffer byteBuffer, long j, int i) throws e, b;

    am av();

    void aw(int i);

    boolean cR();

    boolean d(com.applovin.exoplayer2.v vVar);

    void dI();

    void dJ();

    void dK();

    void dL() throws e;

    boolean dM();

    void dN();

    void dO();

    void dP();

    int e(com.applovin.exoplayer2.v vVar);

    void h(float f);

    void pause();

    public static final class a extends Exception {
        public final com.applovin.exoplayer2.v dU;

        public a(Throwable th, com.applovin.exoplayer2.v vVar) {
            super(th);
            this.dU = vVar;
        }

        public a(String str, com.applovin.exoplayer2.v vVar) {
            super(str);
            this.dU = vVar;
        }
    }

    public static final class b extends Exception {
        public final boolean by;
        public final com.applovin.exoplayer2.v dU;
        public final int jU;

        public b(int i, int i2, int i3, int i4, com.applovin.exoplayer2.v vVar, boolean z, Exception exc) {
            super("AudioTrack init failed " + i + " Config(" + i2 + ", " + i3 + ", " + i4 + ")" + (z ? " (recoverable)" : ""), exc);
            this.jU = i;
            this.by = z;
            this.dU = vVar;
        }
    }

    public static final class e extends Exception {
        public final boolean by;
        public final com.applovin.exoplayer2.v dU;
        public final int errorCode;

        public e(int i, com.applovin.exoplayer2.v vVar, boolean z) {
            super("AudioTrack write failed: " + i);
            this.by = z;
            this.errorCode = i;
            this.dU = vVar;
        }
    }

    public static final class d extends Exception {
        public final long jV;
        public final long jW;

        public d(long j, long j2) {
            super("Unexpected audio track timestamp discontinuity: expected " + j2 + ", got " + j);
            this.jV = j;
            this.jW = j2;
        }
    }
}
