package com.applovin.impl.sdk.d;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private long aSD;
    private long aSE;
    private boolean aSF;
    private long aSG;
    private long aSH;
    private int aSI;
    private Throwable aSJ;

    public void bW(long j) {
        this.aSD += j;
    }

    public void bX(long j) {
        this.aSE += j;
    }

    public void JQ() {
        this.aSF = true;
    }

    public void JR() {
        this.aSG++;
    }

    public void JS() {
        this.aSH++;
    }

    public void p(Throwable th) {
        this.aSJ = th;
    }

    public void gM(int i) {
        this.aSI = i;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.aSD + ", totalCachedBytes=" + this.aSE + ", isHTMLCachingCancelled=" + this.aSF + ", htmlResourceCacheSuccessCount=" + this.aSG + ", htmlResourceCacheFailureCount=" + this.aSH + '}';
    }
}
