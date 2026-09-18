package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class zzaeo implements zzbx {
    public static final Parcelable.Creator<zzaeo> CREATOR = new zzaen();
    public final String zza;
    public final String zzb;

    protected zzaeo(Parcel parcel) {
        String string = parcel.readString();
        int i = zzfk.zza;
        this.zza = string;
        this.zzb = parcel.readString();
    }

    public zzaeo(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
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
            zzaeo zzaeoVar = (zzaeo) obj;
            if (this.zza.equals(zzaeoVar.zza) && this.zzb.equals(zzaeoVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() + 527) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return "VC: " + this.zza + "=" + this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    @Override // com.google.android.gms.internal.ads.zzbx
    public final void zza(zzbt zzbtVar) {
        byte b2;
        switch (this.zza) {
            case "ALBUM":
                b2 = 2;
                break;
            case "TITLE":
                b2 = 0;
                break;
            case "DESCRIPTION":
                b2 = 4;
                break;
            case "ALBUMARTIST":
                b2 = 3;
                break;
            case "ARTIST":
                b2 = 1;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0) {
            zzbtVar.zzq(this.zzb);
            return;
        }
        if (b2 == 1) {
            zzbtVar.zze(this.zzb);
            return;
        }
        if (b2 == 2) {
            zzbtVar.zzd(this.zzb);
        } else if (b2 == 3) {
            zzbtVar.zzc(this.zzb);
        } else {
            if (b2 != 4) {
                return;
            }
            zzbtVar.zzh(this.zzb);
        }
    }
}
