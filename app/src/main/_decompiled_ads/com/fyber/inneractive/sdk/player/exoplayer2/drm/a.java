package com.fyber.inneractive.sdk.player.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparator<b>, Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0283a();
    public final b[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1053b;
    public final int c;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.drm.a$a, reason: collision with other inner class name */
    public class C0283a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(boolean z, b... bVarArr) {
        bVarArr = z ? (b[]) bVarArr.clone() : bVarArr;
        Arrays.sort(bVarArr, this);
        for (int i = 1; i < bVarArr.length; i++) {
            if (bVarArr[i - 1].f1054b.equals(bVarArr[i].f1054b)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + bVarArr[i].f1054b);
            }
        }
        this.a = bVarArr;
        this.c = bVarArr.length;
    }

    @Override // java.util.Comparator
    public int compare(b bVar, b bVar2) {
        b bVar3 = bVar;
        b bVar4 = bVar2;
        UUID uuid = com.fyber.inneractive.sdk.player.exoplayer2.b.f1048b;
        if (uuid.equals(bVar3.f1054b)) {
            return uuid.equals(bVar4.f1054b) ? 0 : 1;
        }
        return bVar3.f1054b.compareTo(bVar4.f1054b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((a) obj).a);
    }

    public int hashCode() {
        if (this.f1053b == 0) {
            this.f1053b = Arrays.hashCode(this.a);
        }
        return this.f1053b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.a, 0);
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new C0284a();
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f1054b;
        public final String c;
        public final byte[] d;
        public final boolean e;

        /* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b$a, reason: collision with other inner class name */
        public class C0284a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f1054b = (UUID) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(uuid);
            this.c = (String) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(str);
            this.d = (byte[]) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(bArr);
            this.e = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return this.c.equals(bVar.c) && u.a(this.f1054b, bVar.f1054b) && Arrays.equals(this.d, bVar.d);
        }

        public int hashCode() {
            if (this.a == 0) {
                this.a = (((this.f1054b.hashCode() * 31) + this.c.hashCode()) * 31) + Arrays.hashCode(this.d);
            }
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f1054b.getMostSignificantBits());
            parcel.writeLong(this.f1054b.getLeastSignificantBits());
            parcel.writeString(this.c);
            parcel.writeByteArray(this.d);
            parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        }

        public b(Parcel parcel) {
            this.f1054b = new UUID(parcel.readLong(), parcel.readLong());
            this.c = parcel.readString();
            this.d = parcel.createByteArray();
            this.e = parcel.readByte() != 0;
        }
    }

    public a(Parcel parcel) {
        b[] bVarArr = (b[]) parcel.createTypedArray(b.CREATOR);
        this.a = bVarArr;
        this.c = bVarArr.length;
    }
}
