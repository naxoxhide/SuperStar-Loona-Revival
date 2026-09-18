package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrl implements com.google.android.gms.ads.internal.overlay.zzo {
    final /* synthetic */ zzbrn zza;

    zzbrl(zzbrn zzbrnVar) {
        this.zza = zzbrnVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbL() {
        zzcat.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbo() {
        zzcat.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbu() {
        zzcat.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbv() {
        zzcat.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbrn zzbrnVar = this.zza;
        zzbrnVar.zzb.onAdOpened(zzbrnVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbx() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzby(int i) {
        zzcat.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbrn zzbrnVar = this.zza;
        zzbrnVar.zzb.onAdClosed(zzbrnVar);
    }
}
