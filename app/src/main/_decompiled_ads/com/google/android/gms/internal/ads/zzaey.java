package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaey extends zzafh {
    public static final Parcelable.Creator<zzaey> CREATOR = new zzaex();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzafh[] zze;

    zzaey(Parcel parcel) {
        super("CTOC");
        String string = parcel.readString();
        int i = zzfk.zza;
        this.zza = string;
        this.zzb = parcel.readByte() != 0;
        this.zzc = parcel.readByte() != 0;
        this.zzd = parcel.createStringArray();
        int i2 = parcel.readInt();
        this.zze = new zzafh[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.zze[i3] = (zzafh) parcel.readParcelable(zzafh.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaey zzaeyVar = (zzaey) obj;
            if (this.zzb == zzaeyVar.zzb && this.zzc == zzaeyVar.zzc && zzfk.zzE(this.zza, zzaeyVar.zza) && Arrays.equals(this.zzd, zzaeyVar.zzd) && Arrays.equals(this.zze, zzaeyVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return (((((this.zzb ? 1 : 0) + 527) * 31) + (this.zzc ? 1 : 0)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByte(this.zzb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zzc ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        for (zzafh zzafhVar : this.zze) {
            parcel.writeParcelable(zzafhVar, 0);
        }
    }

    public zzaey(String str, boolean z, boolean z2, String[] strArr, zzafh[] zzafhVarArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = strArr;
        this.zze = zzafhVarArr;
    }
}
