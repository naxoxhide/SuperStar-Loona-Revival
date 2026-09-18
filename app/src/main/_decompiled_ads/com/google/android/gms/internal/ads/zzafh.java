package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzafh implements zzbx {
    public final String zzf;

    public zzafh(String str) {
        this.zzf = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
