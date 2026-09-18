package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzekq implements com.google.android.gms.ads.internal.zzf {
    final /* synthetic */ zzcbl zza;
    final /* synthetic */ zzfde zzb;
    final /* synthetic */ zzfcr zzc;
    final /* synthetic */ zzekw zzd;
    final /* synthetic */ zzekr zze;

    zzekq(zzekr zzekrVar, zzcbl zzcblVar, zzfde zzfdeVar, zzfcr zzfcrVar, zzekw zzekwVar) {
        this.zze = zzekrVar;
        this.zza = zzcblVar;
        this.zzb = zzfdeVar;
        this.zzc = zzfcrVar;
        this.zzd = zzekwVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zza(View view) {
        this.zza.zzc(this.zze.zzd.zza(this.zzb, this.zzc, view, this.zzd));
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
    }
}
