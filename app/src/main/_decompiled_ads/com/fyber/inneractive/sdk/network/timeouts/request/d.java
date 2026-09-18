package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.util.IAlog;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {
    public double m;

    public d(String str, j jVar, String str2) {
        super(str, jVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public int a(j jVar, String str) {
        return jVar.b(str, this.l);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public int b(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String strA = j.a(str, "min", "rat", "bidding", j.i(str2));
        String strA2 = j.a(str, "min", "rat", "bidding", "all_mediators");
        jVar.h(str);
        return jVar.a(strA, jVar.a(strA2, 5000));
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public int c(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String strA = j.a(str, "rat", "bidding", "perc", j.i(str2));
        String strA2 = j.a(str, "rat", "bidding", "perc", "all_mediators");
        "read".equalsIgnoreCase(str);
        return jVar.a(strA, jVar.a(strA2, 15));
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public void d(j jVar, String str) {
        super.d(jVar, str);
        this.g = jVar.a("reverse_retries", true);
        int iA = jVar.a(j.a("retry_interval", "rat", "bidding"), jVar.a(j.a("retry_interval", "all_mediators"), 100));
        this.e = iA;
        this.c = (this.i + this.h) - (iA + this.f);
        this.d = jVar.a(j.a("bidding", "irat", j.i(this.l)), jVar.a(j.a("bidding", "irat", "all_mediators"), 10000));
        this.m = ((double) Math.min(this.k, this.j)) / ((double) Math.max(this.k, this.j));
        b(this.d);
        this.a = Math.max(0, a());
        if (this.g) {
            IAlog.a("%s : RequestBiddingAdTimeout shouldReverseRetries - reversing timeouts", IAlog.a(this));
            a(0);
        }
        IAlog.a("%s : RequestBiddingAdTimeout init timeouts, total retries: %d", IAlog.a(this), Integer.valueOf(this.a));
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public int a(j jVar) {
        String str = this.l;
        jVar.getClass();
        return jVar.a(j.a("timeout", "threshold", "rat", "bidding", j.i(str)), jVar.a(j.a("timeout", "threshold", "rat", "bidding", "all_mediators"), ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO));
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public int a(int i) {
        if (this.g) {
            i = this.a - i;
        }
        int i2 = this.d + (this.f995b * i);
        IAlog.a("%s : RequestBiddingAdTimeout resolveTimeoutForRetry, timeout: %d ms for retry: %d", IAlog.a(this), Integer.valueOf(i2), Integer.valueOf(i));
        b(i2);
        return i2;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public int b() {
        return this.a;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public int c() {
        return this.e;
    }

    public void b(int i) {
        double d = this.m;
        if (d == 1.0d || d == 0.0d) {
            IAlog.a("%s : RequestBiddingAdTimeout Ratio: %f, connection and read timeouts should be divided in equal proportions", IAlog.a(this), Double.valueOf(this.m));
            this.m = 0.5d;
        }
        int i2 = (int) (((double) i) * this.m);
        this.h = i2;
        this.i = i - i2;
        IAlog.a("%s : RequestBiddingAdTimeout Update timeouts connection: %d read: %d", IAlog.a(this), Integer.valueOf(this.i), Integer.valueOf(this.h));
    }
}
