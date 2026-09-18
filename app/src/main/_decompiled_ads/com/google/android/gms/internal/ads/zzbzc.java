package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbzc implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbzd zza;
    private final String zzb;

    public zzbzc(zzbzd zzbzdVar, String str) {
        this.zza = zzbzdVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzbzb zzbzbVar : this.zza.zzb) {
                zzbzbVar.zza.zzb(zzbzbVar.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
