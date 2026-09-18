package com.applovin.exoplayer2.l;

/* JADX INFO: loaded from: classes.dex */
public final class ag {
    private long CD;
    private long acS;
    private long acT;
    private final ThreadLocal<Long> acU = new ThreadLocal<>();

    public ag(long j) {
        aI(j);
    }

    public synchronized long pS() {
        long j;
        j = this.CD;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long pT() {
        long jPS;
        long j = this.acT;
        if (j != -9223372036854775807L) {
            jPS = j + this.acS;
        } else {
            jPS = pS();
        }
        return jPS;
    }

    public synchronized long pU() {
        return this.acS;
    }

    public synchronized void aI(long j) {
        this.CD = j;
        this.acS = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.acT = -9223372036854775807L;
    }

    public synchronized long br(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.acT;
        if (j2 != -9223372036854775807L) {
            long jBu = bu(j2);
            long j3 = (4294967296L + jBu) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - jBu) < Math.abs(j - jBu)) {
                j = j4;
            }
        }
        return bs(bt(j));
    }

    public synchronized long bs(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.acS == -9223372036854775807L) {
            long jLongValue = this.CD;
            if (jLongValue == 9223372036854775806L) {
                jLongValue = ((Long) a.checkNotNull(this.acU.get())).longValue();
            }
            this.acS = jLongValue - j;
            notifyAll();
        }
        this.acT = j;
        return j + this.acS;
    }

    public static long bt(long j) {
        return (j * 1000000) / 90000;
    }

    public static long bu(long j) {
        return (j * 90000) / 1000000;
    }
}
