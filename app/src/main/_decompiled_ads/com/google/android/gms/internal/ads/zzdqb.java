package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqb implements zzcyg {
    private final zzcgb zza;

    zzdqb(zzcgb zzcgbVar) {
        this.zza = zzcgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyg
    public final void zzbn(Context context) {
        zzcgb zzcgbVar = this.zza;
        if (zzcgbVar != null) {
            zzcgbVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyg
    public final void zzbp(Context context) {
        zzcgb zzcgbVar = this.zza;
        if (zzcgbVar != null) {
            zzcgbVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyg
    public final void zzbq(Context context) {
        zzcgb zzcgbVar = this.zza;
        if (zzcgbVar != null) {
            zzcgbVar.onResume();
        }
    }
}
