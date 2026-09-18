package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafp extends zzafh {
    public static final Parcelable.Creator<zzafp> CREATOR = new zzafo();
    public final String zza;

    @Deprecated
    public final String zzb;
    public final zzfvs zzc;

    /* JADX WARN: Multi-variable type inference failed */
    public zzafp(String str, String str2, List list) {
        super(str);
        zzdx.zzd(!list.isEmpty());
        this.zza = str2;
        zzfvs zzfvsVarZzj = zzfvs.zzj(list);
        this.zzc = zzfvsVarZzj;
        this.zzb = (String) zzfvsVarZzj.get(0);
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzafp zzafpVar = (zzafp) obj;
            if (zzfk.zzE(this.zzf, zzafpVar.zzf) && zzfk.zzE(this.zza, zzafpVar.zza) && this.zzc.equals(zzafpVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzc.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzafh
    public final String toString() {
        return this.zzf + ": description=" + this.zza + ": values=" + String.valueOf(this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeStringArray((String[]) this.zzc.toArray(new String[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzafh, com.google.android.gms.internal.ads.zzbx
    public final void zza(zzbt zzbtVar) {
        switch (this.zzf) {
            case "TT2":
            case "TIT2":
                zzbtVar.zzq((CharSequence) this.zzc.get(0));
                break;
            case "TP1":
            case "TPE1":
                zzbtVar.zze((CharSequence) this.zzc.get(0));
                break;
            case "TP2":
            case "TPE2":
                zzbtVar.zzc((CharSequence) this.zzc.get(0));
                break;
            case "TAL":
            case "TALB":
                zzbtVar.zzd((CharSequence) this.zzc.get(0));
                break;
            case "TRK":
            case "TRCK":
                String str = (String) this.zzc.get(0);
                int i = zzfk.zza;
                String[] strArrSplit = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
                try {
                    int i2 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzbtVar.zzs(Integer.valueOf(i2));
                    zzbtVar.zzr(numValueOf);
                    break;
                } catch (NumberFormatException unused) {
                    return;
                }
                break;
            case "TYE":
            case "TYER":
                try {
                    zzbtVar.zzl(Integer.valueOf(Integer.parseInt((String) this.zzc.get(0))));
                    break;
                } catch (NumberFormatException unused2) {
                    return;
                }
                break;
            case "TDA":
            case "TDAT":
                try {
                    String str2 = (String) this.zzc.get(0);
                    int i3 = Integer.parseInt(str2.substring(2, 4));
                    int i4 = Integer.parseInt(str2.substring(0, 2));
                    zzbtVar.zzk(Integer.valueOf(i3));
                    zzbtVar.zzj(Integer.valueOf(i4));
                    break;
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
                break;
            case "TDRC":
                List listZzb = zzb((String) this.zzc.get(0));
                int size = listZzb.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size == 3) {
                            zzbtVar.zzj((Integer) listZzb.get(2));
                        }
                    }
                    zzbtVar.zzk((Integer) listZzb.get(1));
                }
                zzbtVar.zzl((Integer) listZzb.get(0));
                break;
            case "TDRL":
                List listZzb2 = zzb((String) this.zzc.get(0));
                int size2 = listZzb2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 == 3) {
                            zzbtVar.zzm((Integer) listZzb2.get(2));
                        }
                    }
                    zzbtVar.zzn((Integer) listZzb2.get(1));
                }
                zzbtVar.zzo((Integer) listZzb2.get(0));
                break;
            case "TCM":
            case "TCOM":
                zzbtVar.zzf((CharSequence) this.zzc.get(0));
                break;
            case "TP3":
            case "TPE3":
                zzbtVar.zzg((CharSequence) this.zzc.get(0));
                break;
            case "TXT":
            case "TEXT":
                zzbtVar.zzt((CharSequence) this.zzc.get(0));
                break;
        }
    }
}
