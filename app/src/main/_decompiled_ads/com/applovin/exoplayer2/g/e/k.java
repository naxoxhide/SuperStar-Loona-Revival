package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() { // from class: com.applovin.exoplayer2.g.e.k.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dw, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    };
    public final byte[] Ka;
    public final String owner;

    public k(String str, byte[] bArr) {
        super("PRIV");
        this.owner = str;
        this.Ka = bArr;
    }

    k(Parcel parcel) {
        super("PRIV");
        this.owner = (String) ai.R(parcel.readString());
        this.Ka = (byte[]) ai.R(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return ai.r(this.owner, kVar.owner) && Arrays.equals(this.Ka, kVar.Ka);
    }

    public int hashCode() {
        String str = this.owner;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.Ka);
    }

    @Override // com.applovin.exoplayer2.g.e.h
    public String toString() {
        return this.f1do + ": owner=" + this.owner;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.owner);
        parcel.writeByteArray(this.Ka);
    }
}
