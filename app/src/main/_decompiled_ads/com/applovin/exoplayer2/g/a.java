package com.applovin.exoplayer2.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.v;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.applovin.exoplayer2.g.a.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: df, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private final InterfaceC0095a[] IZ;

    /* JADX INFO: renamed from: com.applovin.exoplayer2.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0095a extends Parcelable {
        default void F(ac.a aVar) {
        }

        default v kE() {
            return null;
        }

        default byte[] kF() {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a(InterfaceC0095a... interfaceC0095aArr) {
        this.IZ = interfaceC0095aArr;
    }

    public a(List<? extends InterfaceC0095a> list) {
        this.IZ = (InterfaceC0095a[]) list.toArray(new InterfaceC0095a[0]);
    }

    a(Parcel parcel) {
        this.IZ = new InterfaceC0095a[parcel.readInt()];
        int i = 0;
        while (true) {
            InterfaceC0095a[] interfaceC0095aArr = this.IZ;
            if (i >= interfaceC0095aArr.length) {
                return;
            }
            interfaceC0095aArr[i] = (InterfaceC0095a) parcel.readParcelable(InterfaceC0095a.class.getClassLoader());
            i++;
        }
    }

    public int kD() {
        return this.IZ.length;
    }

    public InterfaceC0095a de(int i) {
        return this.IZ[i];
    }

    public a g(a aVar) {
        return aVar == null ? this : b(aVar.IZ);
    }

    public a b(InterfaceC0095a... interfaceC0095aArr) {
        return interfaceC0095aArr.length == 0 ? this : new a((InterfaceC0095a[]) ai.a(this.IZ, interfaceC0095aArr));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.IZ, ((a) obj).IZ);
    }

    public int hashCode() {
        return Arrays.hashCode(this.IZ);
    }

    public String toString() {
        return "entries=" + Arrays.toString(this.IZ);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.IZ.length);
        for (InterfaceC0095a interfaceC0095a : this.IZ) {
            parcel.writeParcelable(interfaceC0095a, 0);
        }
    }
}
