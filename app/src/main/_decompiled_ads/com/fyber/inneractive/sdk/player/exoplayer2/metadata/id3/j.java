package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1171b;
    public final String c;

    public class a implements Parcelable.Creator<j> {
        @Override // android.os.Parcelable.Creator
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public j[] newArray(int i) {
            return new j[i];
        }
    }

    public j(String str, String str2, String str3) {
        super(str);
        this.f1171b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.a.equals(jVar.a) && u.a(this.f1171b, jVar.f1171b) && u.a(this.c, jVar.c);
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() + 527) * 31;
        String str = this.f1171b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.f1171b);
        parcel.writeString(this.c);
    }

    public j(Parcel parcel) {
        super(parcel.readString());
        this.f1171b = parcel.readString();
        this.c = parcel.readString();
    }
}
