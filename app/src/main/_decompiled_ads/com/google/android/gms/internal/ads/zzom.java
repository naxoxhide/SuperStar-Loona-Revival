package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzom {
    private static final AudioAttributes zza = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int zza(int i, int i2) {
        for (int i3 = 10; i3 > 0; i3--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(zzfk.zzg(i3)).build(), zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static zzfvs<Integer> zzb() {
        zzfvp zzfvpVar = new zzfvp();
        zzfxs it = zzon.zzc.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (zzfk.zza >= zzfk.zzf(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zza)) {
                zzfvpVar.zzf(Integer.valueOf(iIntValue));
            }
        }
        zzfvpVar.zzf((Object) 2);
        return zzfvpVar.zzi();
    }
}
