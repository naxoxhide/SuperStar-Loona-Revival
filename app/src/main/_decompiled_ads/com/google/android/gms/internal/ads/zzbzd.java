package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbzd {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbya zzd;

    zzbzd(Context context, zzbya zzbyaVar) {
        this.zzc = context;
        this.zzd = zzbyaVar;
    }

    final /* synthetic */ void zzb(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zze();
        }
    }

    final synchronized void zzc(String str) {
        if (this.zza.containsKey(str)) {
            return;
        }
        SharedPreferences defaultSharedPreferences = (str == "__default__" || (str != null && str.equals("__default__"))) ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
        zzbzc zzbzcVar = new zzbzc(this, str);
        this.zza.put(str, zzbzcVar);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzbzcVar);
    }

    final synchronized void zzd(zzbzb zzbzbVar) {
        this.zzb.add(zzbzbVar);
    }
}
