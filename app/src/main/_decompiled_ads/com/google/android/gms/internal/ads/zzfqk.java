package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqk extends zzfrc {
    private final int zza;
    private final String zzb;

    /* synthetic */ zzfqk(int i, String str, zzfqj zzfqjVar) {
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfrc) {
            zzfrc zzfrcVar = (zzfrc) obj;
            if (this.zza == zzfrcVar.zza() && ((str = this.zzb) != null ? str.equals(zzfrcVar.zzb()) : zzfrcVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "OverlayDisplayState{statusCode=" + this.zza + ", sessionToken=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfrc
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfrc
    public final String zzb() {
        return this.zzb;
    }
}
