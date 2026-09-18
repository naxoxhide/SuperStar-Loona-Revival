package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqf extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzqi zza;
    final /* synthetic */ zzqg zzb;

    zzqf(zzqg zzqgVar, zzqi zzqiVar) {
        this.zzb = zzqgVar;
        this.zza = zzqiVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzqi zzqiVar = this.zzb.zza;
            if (zzqiVar.zzp == null || !zzqiVar.zzQ) {
                return;
            }
            zzqiVar.zzp.zzb();
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzqi zzqiVar = this.zzb.zza;
            if (zzqiVar.zzp == null || !zzqiVar.zzQ) {
                return;
            }
            zzqiVar.zzp.zzb();
        }
    }
}
