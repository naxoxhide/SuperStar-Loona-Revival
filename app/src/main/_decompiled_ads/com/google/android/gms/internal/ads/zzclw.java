package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzclw implements com.google.android.gms.ads.nonagon.signalgeneration.zzg {
    private final zzcjs zza;
    private zzcwv zzb;
    private com.google.android.gms.ads.nonagon.signalgeneration.zzae zzc;

    /* synthetic */ zzclw(zzcjs zzcjsVar, zzclv zzclvVar) {
        this.zza = zzcjsVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzg
    public final /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzg zza(zzcwv zzcwvVar) {
        this.zzb = zzcwvVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzg
    public final /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzg zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzae zzaeVar) {
        this.zzc = zzaeVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzg
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzh zzc() {
        zzhbk.zzc(this.zzb, zzcwv.class);
        zzhbk.zzc(this.zzc, com.google.android.gms.ads.nonagon.signalgeneration.zzae.class);
        return new zzcly(this.zza, this.zzc, new zzcug(), new zzdtc(), this.zzb, null, null, null);
    }
}
