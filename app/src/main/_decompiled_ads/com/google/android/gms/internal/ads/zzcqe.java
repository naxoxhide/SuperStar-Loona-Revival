package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcqe {
    private final zzfib zza;
    private final zzdso zzb;
    private final zzfde zzc;

    public zzcqe(zzdso zzdsoVar, zzfde zzfdeVar, zzfib zzfibVar) {
        this.zza = zzfibVar;
        this.zzb = zzdsoVar;
        this.zzc = zzfdeVar;
    }

    private static String zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return "h";
        }
        if (i2 == 1) {
            return "bb";
        }
        if (i2 == 2) {
            return "cc";
        }
        if (i2 != 3) {
            return i2 != 4 ? "u" : "ac";
        }
        return "cb";
    }

    public final void zza(long j, int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzir)).booleanValue()) {
            zzfib zzfibVar = this.zza;
            zzfde zzfdeVar = this.zzc;
            zzfia zzfiaVarZzb = zzfia.zzb("ad_closed");
            zzfiaVarZzb.zzg(zzfdeVar.zzb.zzb);
            zzfiaVarZzb.zza("show_time", String.valueOf(j));
            zzfiaVarZzb.zza(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
            zzfiaVarZzb.zza("acr", zzb(i));
            zzfibVar.zzb(zzfiaVarZzb);
            return;
        }
        zzdso zzdsoVar = this.zzb;
        zzfde zzfdeVar2 = this.zzc;
        zzdsn zzdsnVarZza = zzdsoVar.zza();
        zzdsnVarZza.zze(zzfdeVar2.zzb.zzb);
        zzdsnVarZza.zzb("action", "ad_closed");
        zzdsnVarZza.zzb("show_time", String.valueOf(j));
        zzdsnVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        zzdsnVarZza.zzb("acr", zzb(i));
        zzdsnVarZza.zzg();
    }
}
