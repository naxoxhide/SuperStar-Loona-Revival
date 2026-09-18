package com.applovin.exoplayer2.g.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.y;

/* JADX INFO: loaded from: classes.dex */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.applovin.exoplayer2.g.g.g.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dI, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i) {
            return new g[i];
        }
    };
    public final long KK;
    public final long KL;

    private g(long j, long j2) {
        this.KK = j;
        this.KL = j2;
    }

    static g b(y yVar, long j, ag agVar) {
        long jE = e(yVar, j);
        return new g(jE, agVar.br(jE));
    }

    static long e(y yVar, long j) {
        long jPo = yVar.po();
        if ((128 & jPo) != 0) {
            return 8589934591L & ((((jPo & 1) << 32) | yVar.pv()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.KK);
        parcel.writeLong(this.KL);
    }
}
