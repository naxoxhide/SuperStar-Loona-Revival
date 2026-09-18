package com.applovin.exoplayer2.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.l.ai;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.applovin.exoplayer2.g.a.InterfaceC0095a {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.applovin.exoplayer2.g.c.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dj, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public final String Jn;
    public final String Jx;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b(String str, String str2) {
        this.Jx = str;
        this.Jn = str2;
    }

    b(Parcel parcel) {
        this.Jx = (String) ai.R(parcel.readString());
        this.Jn = (String) ai.R(parcel.readString());
    }

    @Override // com.applovin.exoplayer2.g.a.InterfaceC0095a
    public void F(ac.a aVar) {
        String str = this.Jx;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                aVar.c(this.Jn);
                break;
            case "TITLE":
                aVar.a(this.Jn);
                break;
            case "DESCRIPTION":
                aVar.g(this.Jn);
                break;
            case "ALBUMARTIST":
                aVar.d(this.Jn);
                break;
            case "ARTIST":
                aVar.b(this.Jn);
                break;
        }
    }

    public String toString() {
        return "VC: " + this.Jx + "=" + this.Jn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.Jx.equals(bVar.Jx) && this.Jn.equals(bVar.Jn);
    }

    public int hashCode() {
        return ((527 + this.Jx.hashCode()) * 31) + this.Jn.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jx);
        parcel.writeString(this.Jn);
    }
}
