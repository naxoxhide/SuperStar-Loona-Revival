package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzpx {
    public final zzam zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzdn zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;

    public zzpx(zzam zzamVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, zzdn zzdnVar, boolean z, boolean z2) {
        this.zza = zzamVar;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzdnVar;
    }

    public final AudioTrack zza(boolean z, zzk zzkVar, int i) throws zzpe {
        AudioTrack audioTrack;
        try {
            if (zzfk.zza >= 29) {
                audioTrack = new AudioTrack.Builder().setAudioAttributes(zzkVar.zza().zza).setAudioFormat(zzfk.zzu(this.zze, this.zzf, this.zzg)).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i).setOffloadedPlayback(this.zzc == 1).build();
            } else if (zzfk.zza >= 21) {
                audioTrack = new AudioTrack(zzkVar.zza().zza, zzfk.zzu(this.zze, this.zzf, this.zzg), this.zzh, 1, i);
            } else {
                int i2 = zzkVar.zzc;
                audioTrack = i == 0 ? new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1) : new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzpe(state, this.zze, this.zzf, this.zzh, this.zza, zzb(), null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzpe(0, this.zze, this.zzf, this.zzh, this.zza, zzb(), e);
        }
    }

    public final boolean zzb() {
        return this.zzc == 1;
    }
}
