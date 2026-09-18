package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfql extends zzfre {
    private String zza;
    private String zzb;

    zzfql() {
    }

    @Override // com.google.android.gms.internal.ads.zzfre
    public final zzfre zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfre
    public final zzfre zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfre
    public final zzfrf zzc() {
        return new zzfqn(this.zza, this.zzb, null);
    }
}
