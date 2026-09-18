package com.applovin.exoplayer2.d;

import com.applovin.exoplayer2.l.ai;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class n implements com.applovin.exoplayer2.c.b {
    public static final boolean to;
    public final UUID ey;
    public final byte[] su;
    public final boolean tp;

    static {
        to = "Amazon".equals(ai.acX) && ("AFTM".equals(ai.acY) || "AFTB".equals(ai.acY));
    }

    public n(UUID uuid, byte[] bArr, boolean z) {
        this.ey = uuid;
        this.su = bArr;
        this.tp = z;
    }
}
