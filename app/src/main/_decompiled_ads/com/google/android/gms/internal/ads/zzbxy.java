package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbxy {
    private final Clock zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzbyy zzc;

    zzbxy(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbyy zzbyyVar) {
        this.zza = clock;
        this.zzb = zzgVar;
        this.zzc = zzbyyVar;
    }

    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaq)).booleanValue()) {
            this.zzc.zzt();
        }
    }

    public final void zzb(int i, long j) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzap)).booleanValue()) {
            return;
        }
        if (j - this.zzb.zzf() < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaq)).booleanValue()) {
            this.zzb.zzL(i);
            this.zzb.zzM(j);
        } else {
            this.zzb.zzL(-1);
            this.zzb.zzM(j);
        }
        zza();
    }
}
