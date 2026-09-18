package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbca;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbnq;
import com.google.android.gms.internal.ads.zzbnx;
import com.google.android.gms.internal.ads.zzbzw;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzcaz;
import com.google.android.gms.internal.ads.zzcbg;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzfis;
import com.google.android.gms.internal.ads.zzfit;
import com.google.android.gms.internal.ads.zzfjh;
import com.google.android.gms.internal.ads.zzfza;
import com.google.android.gms.internal.ads.zzfzt;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
@ParametersAreNonnullByDefault
public final class zze {
    private Context zza;
    private long zzb = 0;

    public final void zza(Context context, zzcaz zzcazVar, String str, Runnable runnable, zzfjh zzfjhVar) {
        zzb(context, zzcazVar, true, null, str, null, runnable, zzfjhVar);
    }

    final void zzb(Context context, zzcaz zzcazVar, boolean z, zzbzw zzbzwVar, String str, String str2, Runnable runnable, final zzfjh zzfjhVar) {
        PackageInfo packageInfo;
        if (zzt.zzB().elapsedRealtime() - this.zzb < 5000) {
            zzcat.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzB().elapsedRealtime();
        if (zzbzwVar != null && !TextUtils.isEmpty(zzbzwVar.zzc())) {
            if (zzt.zzB().currentTimeMillis() - zzbzwVar.zza() <= ((Long) zzba.zzc().zzb(zzbci.zzdU)).longValue() && zzbzwVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzcat.zzj("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            zzcat.zzj("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.zza = applicationContext;
        final zzfit zzfitVarZza = zzfis.zza(context, 4);
        zzfitVarZza.zzh();
        zzbnq zzbnqVarZza = zzt.zzf().zza(this.zza, zzcazVar, zzfjhVar).zza("google.afma.config.fetchAppSettings", zzbnx.zza, zzbnx.zza);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z);
            jSONObject.put("pn", context.getPackageName());
            zzbca zzbcaVar = zzbci.zza;
            jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
            jSONObject.put("js", zzcazVar.zza);
            try {
                ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
            }
            ListenableFuture listenableFutureZzb = zzbnqVarZza.zzb(jSONObject);
            ListenableFuture listenableFutureZzn = zzfzt.zzn(listenableFutureZzb, new zzfza() { // from class: com.google.android.gms.ads.internal.zzd
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) throws JSONException {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    boolean zOptBoolean = jSONObject2.optBoolean("isSuccessful", false);
                    if (zOptBoolean) {
                        zzt.zzo().zzh().zzu(jSONObject2.getString("appSettingsJson"));
                    }
                    zzfit zzfitVar = zzfitVarZza;
                    zzfjh zzfjhVar2 = zzfjhVar;
                    zzfitVar.zzf(zOptBoolean);
                    zzfjhVar2.zzb(zzfitVar.zzl());
                    return zzfzt.zzh(null);
                }
            }, zzcbg.zzf);
            if (runnable != null) {
                listenableFutureZzb.addListener(runnable, zzcbg.zzf);
            }
            zzcbj.zza(listenableFutureZzn, "ConfigLoader.maybeFetchNewAppSettings");
        } catch (Exception e) {
            zzcat.zzh("Error requesting application settings", e);
            zzfitVarZza.zzg(e);
            zzfitVarZza.zzf(false);
            zzfjhVar.zzb(zzfitVarZza.zzl());
        }
    }

    public final void zzc(Context context, zzcaz zzcazVar, String str, zzbzw zzbzwVar, zzfjh zzfjhVar) {
        zzb(context, zzcazVar, false, zzbzwVar, zzbzwVar != null ? zzbzwVar.zzb() : null, str, null, zzfjhVar);
    }
}
