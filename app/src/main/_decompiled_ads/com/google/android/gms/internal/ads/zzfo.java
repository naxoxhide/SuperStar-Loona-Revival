package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfo implements zzbx {
    public static final Parcelable.Creator<zzfo> CREATOR = new zzfm();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* synthetic */ zzfo(Parcel parcel, zzfn zzfnVar) {
        String string = parcel.readString();
        int i = zzfk.zza;
        this.zza = string;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzfo(String str, byte[] bArr, int i, int i2) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzfo zzfoVar = (zzfo) obj;
            if (this.zza.equals(zzfoVar.zza) && Arrays.equals(this.zzb, zzfoVar.zzb) && this.zzc == zzfoVar.zzc && this.zzd == zzfoVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }

    public final String toString() {
        String str;
        int i = this.zzd;
        if (i != 1) {
            if (i == 23) {
                byte[] bArr = this.zzb;
                int i2 = zzfk.zza;
                zzdx.zzd(bArr.length == 4);
                str = String.valueOf(Float.intBitsToFloat((bArr[3] & 255) | ((bArr[1] & 255) << 16) | (bArr[0] << 24) | ((bArr[2] & 255) << 8)));
            } else if (i != 67) {
                byte[] bArr2 = this.zzb;
                int length = bArr2.length;
                StringBuilder sb = new StringBuilder(length + length);
                for (int i3 = 0; i3 < bArr2.length; i3++) {
                    sb.append(Character.forDigit((bArr2[i3] >> 4) & 15, 16));
                    sb.append(Character.forDigit(bArr2[i3] & 15, 16));
                }
                str = sb.toString();
            } else {
                byte[] bArr3 = this.zzb;
                int i4 = zzfk.zza;
                zzdx.zzd(bArr3.length == 4);
                str = String.valueOf(bArr3[3] | (bArr3[1] << 16) | (bArr3[0] << 24) | (bArr3[2] << 8));
            }
        } else {
            str = new String(this.zzb, zzfsi.zzc);
        }
        return "mdta: key=" + this.zza + ", value=" + str;
    }
}
