package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends h {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1166b;
    public final String c;
    public final String d;

    public class a implements Parcelable.Creator<e> {
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f1166b = str;
        this.c = str2;
        this.d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return u.a(this.c, eVar.c) && u.a(this.f1166b, eVar.f1166b) && u.a(this.d, eVar.d);
    }

    public int hashCode() {
        String str = this.f1166b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.f1166b);
        parcel.writeString(this.d);
    }

    public e(Parcel parcel) {
        super("COMM");
        this.f1166b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
