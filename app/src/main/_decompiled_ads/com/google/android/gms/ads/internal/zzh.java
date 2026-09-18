package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfnt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzh implements zzfnt {
    final /* synthetic */ zzi zza;

    zzh(zzi zziVar) {
        this.zza = zziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfnt
    public final void zza(int i, long j) {
        this.zza.zzi.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfnt
    public final void zzb(int i, long j, String str) {
        this.zza.zzi.zze(i, System.currentTimeMillis() - j, str);
    }
}
