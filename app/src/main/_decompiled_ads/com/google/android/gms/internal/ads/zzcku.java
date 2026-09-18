package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcku implements zzdtp {
    private final zzcjs zza;
    private final zzcla zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzcku(zzcjs zzcjsVar, zzcla zzclaVar, zzckt zzcktVar) {
        this.zza = zzcjsVar;
        this.zzb = zzclaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtp
    public final /* synthetic */ zzdtp zza(String str) {
        Objects.requireNonNull(str);
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtp
    public final /* bridge */ /* synthetic */ zzdtp zzb(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtp
    public final zzdtq zzc() {
        zzhbk.zzc(this.zzc, Long.class);
        zzhbk.zzc(this.zzd, String.class);
        return new zzckw(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
