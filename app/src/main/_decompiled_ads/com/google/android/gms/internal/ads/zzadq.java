package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadq extends zzaay {
    public zzadq(final zzabz zzabzVar, int i, long j, long j2) {
        long j3;
        zzaav zzaavVar = new zzaav() { // from class: com.google.android.gms.internal.ads.zzadn
            @Override // com.google.android.gms.internal.ads.zzaav
            public final long zza(long j4) {
                return zzabzVar.zzb(j4);
            }
        };
        zzadp zzadpVar = new zzadp(zzabzVar, i, null);
        long jZza = zzabzVar.zza();
        long j4 = zzabzVar.zzj;
        int i2 = zzabzVar.zzd;
        if (i2 > 0) {
            j3 = ((((long) i2) + ((long) zzabzVar.zzc)) / 2) + 1;
        } else {
            int i3 = zzabzVar.zza;
            int i4 = zzabzVar.zzb;
            long j5 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            if (i3 == i4 && i3 > 0) {
                j5 = i3;
            }
            j3 = (((j5 * ((long) zzabzVar.zzg)) * ((long) zzabzVar.zzh)) / 8) + 64;
        }
        super(zzaavVar, zzadpVar, jZza, 0L, j4, j, j2, j3, Math.max(6, zzabzVar.zzc));
    }
}
