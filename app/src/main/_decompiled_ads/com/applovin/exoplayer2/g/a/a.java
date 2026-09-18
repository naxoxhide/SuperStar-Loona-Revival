package com.applovin.exoplayer2.g.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.applovin.exoplayer2.g.a.InterfaceC0095a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.applovin.exoplayer2.g.a.a.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel.readInt(), (String) com.applovin.exoplayer2.l.a.checkNotNull(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dg, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public final int Ji;
    public final String Jj;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a(int i, String str) {
        this.Ji = i;
        this.Jj = str;
    }

    public String toString() {
        return "Ait(controlCode=" + this.Ji + ",url=" + this.Jj + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jj);
        parcel.writeInt(this.Ji);
    }
}
