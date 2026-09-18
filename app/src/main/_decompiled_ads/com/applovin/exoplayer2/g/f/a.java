package com.applovin.exoplayer2.g.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.applovin.exoplayer2.g.a.InterfaceC0095a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.applovin.exoplayer2.g.f.a.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dz, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public final String Jx;
    public final byte[] Kb;
    public final int Kc;
    public final int Kd;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a(String str, byte[] bArr, int i, int i2) {
        this.Jx = str;
        this.Kb = bArr;
        this.Kc = i;
        this.Kd = i2;
    }

    private a(Parcel parcel) {
        this.Jx = (String) ai.R(parcel.readString());
        this.Kb = (byte[]) ai.R(parcel.createByteArray());
        this.Kc = parcel.readInt();
        this.Kd = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.Jx.equals(aVar.Jx) && Arrays.equals(this.Kb, aVar.Kb) && this.Kc == aVar.Kc && this.Kd == aVar.Kd;
    }

    public int hashCode() {
        return ((((((527 + this.Jx.hashCode()) * 31) + Arrays.hashCode(this.Kb)) * 31) + this.Kc) * 31) + this.Kd;
    }

    public String toString() {
        return "mdta: key=" + this.Jx;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jx);
        parcel.writeByteArray(this.Kb);
        parcel.writeInt(this.Kc);
        parcel.writeInt(this.Kd);
    }
}
