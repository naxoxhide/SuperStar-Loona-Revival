package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqn implements zzpf {
    final /* synthetic */ zzqo zza;

    /* synthetic */ zzqn(zzqo zzqoVar, zzqm zzqmVar) {
        this.zza = zzqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final void zza(Exception exc) {
        zzer.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final void zzb() {
        zzqo zzqoVar = this.zza;
        if (zzqoVar.zzl != null) {
            zzqoVar.zzl.zzb();
        }
    }
}
