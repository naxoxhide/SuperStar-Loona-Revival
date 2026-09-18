package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbcg implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();

    private final void zzf() {
        if (this.zze == null) {
            return;
        }
        try {
            this.zzh = new JSONObject((String) zzbcn.zza(new zzftm() { // from class: com.google.android.gms.internal.ads.zzbce
                @Override // com.google.android.gms.internal.ads.zzftm
                public final Object zza() {
                    return this.zza.zzd();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzf();
        }
    }

    public final Object zzb(final zzbca zzbcaVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null) {
                }
                return zzbcaVar.zzm();
            }
        }
        if (zzbcaVar.zze() != 2) {
            return (zzbcaVar.zze() == 1 && this.zzh.has(zzbcaVar.zzn())) ? zzbcaVar.zza(this.zzh) : zzbcn.zza(new zzftm() { // from class: com.google.android.gms.internal.ads.zzbcd
                @Override // com.google.android.gms.internal.ads.zzftm
                public final Object zza() {
                    return this.zza.zzc(zzbcaVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbcaVar.zzm() : zzbcaVar.zzb(bundle);
    }

    final /* synthetic */ Object zzc(zzbca zzbcaVar) {
        return zzbcaVar.zzc(this.zze);
    }

    final /* synthetic */ String zzd() {
        return this.zze.getString("flag_configuration", JsonUtils.EMPTY_JSON);
    }

    public final void zze(Context context) {
        if (this.zzd) {
            return;
        }
        synchronized (this.zzb) {
            if (this.zzd) {
                return;
            }
            if (!this.zza) {
                this.zza = true;
            }
            Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
            this.zzg = applicationContext;
            try {
                this.zzf = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext != null || context == null || (remoteContext = context.getApplicationContext()) != null) {
                    context = remoteContext;
                }
                if (context == null) {
                    this.zza = false;
                    this.zzc.open();
                    return;
                }
                com.google.android.gms.ads.internal.client.zzba.zzb();
                SharedPreferences sharedPreferencesZza = zzbcc.zza(context);
                this.zze = sharedPreferencesZza;
                if (sharedPreferencesZza != null) {
                    sharedPreferencesZza.registerOnSharedPreferenceChangeListener(this);
                }
                zzbet.zzc(new zzbcf(this));
                zzf();
                this.zzd = true;
                this.zza = false;
                this.zzc.open();
            } catch (Throwable th) {
                this.zza = false;
                this.zzc.open();
                throw th;
            }
        }
    }
}
