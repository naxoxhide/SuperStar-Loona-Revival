package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaem implements zzbx {
    public static final Parcelable.Creator<zzaem> CREATOR = new zzael();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzaem(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    zzaem(Parcel parcel) {
        this.zza = parcel.readInt();
        String string = parcel.readString();
        int i = zzfk.zza;
        this.zzb = string;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.createByteArray();
    }

    public static zzaem zzb(zzfb zzfbVar) {
        int iZzf = zzfbVar.zzf();
        String strZzy = zzfbVar.zzy(zzfbVar.zzf(), zzfsi.zza);
        String strZzy2 = zzfbVar.zzy(zzfbVar.zzf(), zzfsi.zzc);
        int iZzf2 = zzfbVar.zzf();
        int iZzf3 = zzfbVar.zzf();
        int iZzf4 = zzfbVar.zzf();
        int iZzf5 = zzfbVar.zzf();
        int iZzf6 = zzfbVar.zzf();
        byte[] bArr = new byte[iZzf6];
        zzfbVar.zzC(bArr, 0, iZzf6);
        return new zzaem(iZzf, strZzy, strZzy2, iZzf2, iZzf3, iZzf4, iZzf5, bArr);
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
            zzaem zzaemVar = (zzaem) obj;
            if (this.zza == zzaemVar.zza && this.zzb.equals(zzaemVar.zzb) && this.zzc.equals(zzaemVar.zzc) && this.zzd == zzaemVar.zzd && this.zze == zzaemVar.zze && this.zzf == zzaemVar.zzf && this.zzg == zzaemVar.zzg && Arrays.equals(this.zzh, zzaemVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.zzb + ", description=" + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final void zza(zzbt zzbtVar) {
        zzbtVar.zza(this.zzh, this.zza);
    }
}
