package com.google.android.gms.internal.ads;

import android.app.Activity;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzedg extends zzeeb {
    private final Activity zza;
    private final com.google.android.gms.ads.internal.overlay.zzl zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzedg(Activity activity, com.google.android.gms.ads.internal.overlay.zzl zzlVar, String str, String str2, zzedf zzedfVar) {
        this.zza = activity;
        this.zzb = zzlVar;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzeeb) {
            zzeeb zzeebVar = (zzeeb) obj;
            if (this.zza.equals(zzeebVar.zza()) && ((zzlVar = this.zzb) != null ? zzlVar.equals(zzeebVar.zzb()) : zzeebVar.zzb() == null) && ((str = this.zzc) != null ? str.equals(zzeebVar.zzc()) : zzeebVar.zzc() == null) && ((str2 = this.zzd) != null ? str2.equals(zzeebVar.zzd()) : zzeebVar.zzd() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzb;
        int iHashCode2 = ((iHashCode * 1000003) ^ (zzlVar == null ? 0 : zzlVar.hashCode())) * 1000003;
        String str = this.zzc;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzd;
        return iHashCode3 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzb;
        return "OfflineUtilsParams{activity=" + this.zza.toString() + ", adOverlay=" + String.valueOf(zzlVar) + ", gwsQueryId=" + this.zzc + ", uri=" + this.zzd + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzeeb
    public final Activity zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzeeb
    public final com.google.android.gms.ads.internal.overlay.zzl zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzeeb
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzeeb
    public final String zzd() {
        return this.zzd;
    }
}
