package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;

/* JADX INFO: loaded from: classes.dex */
public final class m extends h {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>() { // from class: com.applovin.exoplayer2.g.e.m.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dy, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i) {
            return new m[i];
        }
    };
    public final String Jj;
    public final String oc;

    public m(String str, String str2, String str3) {
        super(str);
        this.oc = str2;
        this.Jj = str3;
    }

    m(Parcel parcel) {
        super((String) ai.R(parcel.readString()));
        this.oc = parcel.readString();
        this.Jj = (String) ai.R(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f1do.equals(mVar.f1do) && ai.r(this.oc, mVar.oc) && ai.r(this.Jj, mVar.Jj);
    }

    public int hashCode() {
        int iHashCode = (527 + this.f1do.hashCode()) * 31;
        String str = this.oc;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Jj;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.applovin.exoplayer2.g.e.h
    public String toString() {
        return this.f1do + ": url=" + this.Jj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1do);
        parcel.writeString(this.oc);
        parcel.writeString(this.Jj);
    }
}
