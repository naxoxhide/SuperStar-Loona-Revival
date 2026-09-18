package com.applovin.exoplayer2.g.f;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.applovin.exoplayer2.g.a.InterfaceC0095a {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.applovin.exoplayer2.g.f.d.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dD, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    public final float Km;
    public final int Kn;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public d(float f, int i) {
        this.Km = f;
        this.Kn = i;
    }

    private d(Parcel parcel) {
        this.Km = parcel.readFloat();
        this.Kn = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.Km == dVar.Km && this.Kn == dVar.Kn;
    }

    public int hashCode() {
        return ((527 + com.applovin.exoplayer2.common.b.b.n(this.Km)) * 31) + this.Kn;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.Km + ", svcTemporalLayerCount=" + this.Kn;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.Km);
        parcel.writeInt(this.Kn);
    }
}
