package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqc extends zzfqo {
    private String zza;
    private String zzb;

    zzfqc() {
    }

    @Override // com.google.android.gms.internal.ads.zzfqo
    public final zzfqo zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqo
    public final zzfqo zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqo
    public final zzfqp zzc() {
        return new zzfqe(this.zza, this.zzb, null);
    }
}
