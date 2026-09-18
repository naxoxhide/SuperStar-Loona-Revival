package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaew extends zzafh {
    public static final Parcelable.Creator<zzaew> CREATOR = new zzaev();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzafh[] zzg;

    zzaew(Parcel parcel) {
        super("CHAP");
        String string = parcel.readString();
        int i = zzfk.zza;
        this.zza = string;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int i2 = parcel.readInt();
        this.zzg = new zzafh[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.zzg[i3] = (zzafh) parcel.readParcelable(zzafh.class.getClassLoader());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafh, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaew zzaewVar = (zzaew) obj;
            if (this.zzb == zzaewVar.zzb && this.zzc == zzaewVar.zzc && this.zzd == zzaewVar.zzd && this.zze == zzaewVar.zze && zzfk.zzE(this.zza, zzaewVar.zza) && Arrays.equals(this.zzg, zzaewVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return ((((((((this.zzb + 527) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzafh zzafhVar : this.zzg) {
            parcel.writeParcelable(zzafhVar, 0);
        }
    }

    public zzaew(String str, int i, int i2, long j, long j2, zzafh[] zzafhVarArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = j2;
        this.zzg = zzafhVarArr;
    }
}
