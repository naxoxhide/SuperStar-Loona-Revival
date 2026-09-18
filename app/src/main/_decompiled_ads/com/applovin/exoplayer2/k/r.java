package com.applovin.exoplayer2.k;

import com.applovin.exoplayer2.ai;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class r implements v {
    private final int aaH;

    public r() {
        this(-1);
    }

    public r(int i) {
        this.aaH = i;
    }

    @Override // com.applovin.exoplayer2.k.v
    public long a(v.a aVar) {
        IOException iOException = aVar.aaU;
        if ((iOException instanceof ai) || (iOException instanceof FileNotFoundException) || (iOException instanceof t.a) || (iOException instanceof w.g) || j.a(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((aVar.sE - 1) * 1000, 5000);
    }

    @Override // com.applovin.exoplayer2.k.v
    public int fl(int i) {
        int i2 = this.aaH;
        if (i2 == -1) {
            return i == 7 ? 6 : 3;
        }
        return i2;
    }
}
