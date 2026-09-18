package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdpf implements zzhbc {
    private final zzhbp zza;

    public zzdpf(zzhbp zzhbpVar) {
        this.zza = zzhbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbp
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzayf zzayfVar = ((zzcxc) this.zza).zza().zzo.zza == 3 ? zzayf.REWARDED_INTERSTITIAL : zzayf.REWARD_BASED_VIDEO_AD;
        zzhbk.zzb(zzayfVar);
        return zzayfVar;
    }
}
