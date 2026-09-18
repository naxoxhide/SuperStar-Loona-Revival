package com.applovin.exoplayer2.m;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class e {
    private int adB;
    private boolean ady;
    private boolean adz;
    private a adw = new a();
    private a adx = new a();
    private long adA = -9223372036854775807L;

    public void Y() {
        this.adw.Y();
        this.adx.Y();
        this.ady = false;
        this.adA = -9223372036854775807L;
        this.adB = 0;
    }

    public void bw(long j) {
        this.adw.bw(j);
        if (this.adw.qd() && !this.adz) {
            this.ady = false;
        } else if (this.adA != -9223372036854775807L) {
            if (!this.ady || this.adx.qi()) {
                this.adx.Y();
                this.adx.bw(this.adA);
            }
            this.ady = true;
            this.adx.bw(j);
        }
        if (this.ady && this.adx.qd()) {
            a aVar = this.adw;
            this.adw = this.adx;
            this.adx = aVar;
            this.ady = false;
            this.adz = false;
        }
        this.adA = j;
        this.adB = this.adw.qd() ? 0 : this.adB + 1;
    }

    public boolean qd() {
        return this.adw.qd();
    }

    public int qe() {
        return this.adB;
    }

    public long qf() {
        if (qd()) {
            return this.adw.qf();
        }
        return -9223372036854775807L;
    }

    public long qg() {
        if (qd()) {
            return this.adw.qg();
        }
        return -9223372036854775807L;
    }

    public float qh() {
        if (qd()) {
            return (float) (1.0E9d / this.adw.qg());
        }
        return -1.0f;
    }

    private static final class a {
        private long adA;
        private long adC;
        private long adD;
        private long adE;
        private long adF;
        private long adG;
        private final boolean[] adH = new boolean[15];
        private int adI;

        public void Y() {
            this.adE = 0L;
            this.adF = 0L;
            this.adG = 0L;
            this.adI = 0;
            Arrays.fill(this.adH, false);
        }

        public boolean qd() {
            return this.adE > 15 && this.adI == 0;
        }

        public boolean qi() {
            long j = this.adE;
            if (j == 0) {
                return false;
            }
            return this.adH[bx(j - 1)];
        }

        public long qf() {
            return this.adG;
        }

        public long qg() {
            long j = this.adF;
            if (j == 0) {
                return 0L;
            }
            return this.adG / j;
        }

        public void bw(long j) {
            long j2 = this.adE;
            if (j2 == 0) {
                this.adC = j;
            } else if (j2 == 1) {
                long j3 = j - this.adC;
                this.adD = j3;
                this.adG = j3;
                this.adF = 1L;
            } else {
                long j4 = j - this.adA;
                int iBx = bx(j2);
                if (Math.abs(j4 - this.adD) <= 1000000) {
                    this.adF++;
                    this.adG += j4;
                    boolean[] zArr = this.adH;
                    if (zArr[iBx]) {
                        zArr[iBx] = false;
                        this.adI--;
                    }
                } else {
                    boolean[] zArr2 = this.adH;
                    if (!zArr2[iBx]) {
                        zArr2[iBx] = true;
                        this.adI++;
                    }
                }
            }
            this.adE++;
            this.adA = j;
        }

        private static int bx(long j) {
            return (int) (j % 15);
        }
    }
}
