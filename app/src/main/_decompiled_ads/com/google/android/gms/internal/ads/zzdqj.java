package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqj {
    private final zzfeh zza;
    private final zzdqg zzb;

    zzdqj(zzfeh zzfehVar, zzdqg zzdqgVar) {
        this.zza = zzfehVar;
        this.zzb = zzdqgVar;
    }

    final zzbox zza() throws RemoteException {
        zzbox zzboxVarZzb = this.zza.zzb();
        if (zzboxVarZzb != null) {
            return zzboxVarZzb;
        }
        zzcat.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbqv zzb(String str) throws RemoteException {
        zzbqv zzbqvVarZzc = zza().zzc(str);
        this.zzb.zze(str, zzbqvVarZzc);
        return zzbqvVarZzc;
    }

    public final zzfej zzc(String str, JSONObject jSONObject) throws zzfds {
        zzbpa zzbpaVarZzb;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbpaVarZzb = new zzbpy(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbpaVarZzb = new zzbpy(new zzbrn());
            } else {
                zzbox zzboxVarZza = zza();
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        if (zzboxVarZza.zze(string)) {
                            zzbpaVarZzb = zzboxVarZza.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                        } else {
                            zzbpaVarZzb = zzboxVarZza.zzd(string) ? zzboxVarZza.zzb(string) : zzboxVarZza.zzb("com.google.ads.mediation.customevent.CustomEventAdapter");
                        }
                    } catch (JSONException e) {
                        zzcat.zzh("Invalid custom event.", e);
                        zzbpaVarZzb = zzboxVarZza.zzb(str);
                    }
                } else {
                    zzbpaVarZzb = zzboxVarZza.zzb(str);
                }
            }
            zzfej zzfejVar = new zzfej(zzbpaVarZzb);
            this.zzb.zzd(str, zzfejVar);
            return zzfejVar;
        } catch (Throwable th) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjc)).booleanValue()) {
                this.zzb.zzd(str, null);
            }
            throw new zzfds(th);
        }
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
