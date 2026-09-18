package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;

/* JADX INFO: loaded from: classes.dex */
public final class i extends h {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() { // from class: com.applovin.exoplayer2.g.e.i.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: du, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i) {
            return new i[i];
        }
    };
    public final String JN;
    public final String JU;
    public final String oc;

    public i(String str, String str2, String str3) {
        super("----");
        this.JU = str;
        this.oc = str2;
        this.JN = str3;
    }

    i(Parcel parcel) {
        super("----");
        this.JU = (String) ai.R(parcel.readString());
        this.oc = (String) ai.R(parcel.readString());
        this.JN = (String) ai.R(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return ai.r(this.oc, iVar.oc) && ai.r(this.JU, iVar.JU) && ai.r(this.JN, iVar.JN);
    }

    public int hashCode() {
        String str = this.JU;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.oc;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.JN;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.applovin.exoplayer2.g.e.h
    public String toString() {
        return this.f1do + ": domain=" + this.JU + ", description=" + this.oc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1do);
        parcel.writeString(this.JU);
        parcel.writeString(this.JN);
    }
}
