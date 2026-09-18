package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcby implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzccg zzb;

    zzcby(zzccg zzccgVar, MediaPlayer mediaPlayer) {
        this.zzb = zzccgVar;
        this.zza = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccg.zzl(this.zzb, this.zza);
        zzccg zzccgVar = this.zzb;
        if (zzccgVar.zzq != null) {
            zzccgVar.zzq.zzf();
        }
    }
}
