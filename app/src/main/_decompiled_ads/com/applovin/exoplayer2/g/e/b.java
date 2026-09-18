package com.applovin.exoplayer2.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b extends h {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.applovin.exoplayer2.g.e.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dn, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public final byte[] tf;

    public b(String str, byte[] bArr) {
        super(str);
        this.tf = bArr;
    }

    b(Parcel parcel) {
        super((String) ai.R(parcel.readString()));
        this.tf = (byte[]) ai.R(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1do.equals(bVar.f1do) && Arrays.equals(this.tf, bVar.tf);
    }

    public int hashCode() {
        return ((527 + this.f1do.hashCode()) * 31) + Arrays.hashCode(this.tf);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1do);
        parcel.writeByteArray(this.tf);
    }
}
