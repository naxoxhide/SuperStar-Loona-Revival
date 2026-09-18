package com.applovin.exoplayer2.g.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.a.n;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements com.applovin.exoplayer2.g.a.InterfaceC0095a {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.applovin.exoplayer2.g.f.c.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, a.class.getClassLoader());
            return new c(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dB, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    public final List<a> Ki;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static final class a implements Parcelable {
        public final long Kk;
        public final int Kl;
        public final long sC;
        public static final Comparator<a> Kj = new Comparator() { // from class: com.applovin.exoplayer2.g.f.-$$Lambda$c$a$51MQjm-ay7wV6RIbk1pIzRio-RY
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.a.a((c.a) obj, (c.a) obj2);
            }
        };
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.applovin.exoplayer2.g.f.c.a.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: dC, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(a aVar, a aVar2) {
            return n.fP().i(aVar.sC, aVar2.sC).i(aVar.Kk, aVar2.Kk).r(aVar.Kl, aVar2.Kl).fQ();
        }

        public a(long j, long j2, int i) {
            com.applovin.exoplayer2.l.a.checkArgument(j < j2);
            this.sC = j;
            this.Kk = j2;
            this.Kl = i;
        }

        public String toString() {
            return ai.a("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.sC), Long.valueOf(this.Kk), Integer.valueOf(this.Kl));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.sC == aVar.sC && this.Kk == aVar.Kk && this.Kl == aVar.Kl;
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.sC), Long.valueOf(this.Kk), Integer.valueOf(this.Kl));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.sC);
            parcel.writeLong(this.Kk);
            parcel.writeInt(this.Kl);
        }
    }

    public c(List<a> list) {
        this.Ki = list;
        com.applovin.exoplayer2.l.a.checkArgument(!j(list));
    }

    public String toString() {
        return "SlowMotion: segments=" + this.Ki;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.Ki.equals(((c) obj).Ki);
    }

    public int hashCode() {
        return this.Ki.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.Ki);
    }

    private static boolean j(List<a> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j = list.get(0).Kk;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).sC < j) {
                return true;
            }
            j = list.get(i).Kk;
        }
        return false;
    }
}
