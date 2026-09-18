package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebp implements zzdcd, com.google.android.gms.ads.internal.client.zza, zzcyf, zzcxp {
    private final Context zza;
    private final zzfed zzb;
    private final zzfde zzc;
    private final zzfcr zzd;
    private final zzedo zze;
    private Boolean zzf;
    private final boolean zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgN)).booleanValue();
    private final zzfib zzh;
    private final String zzi;

    public zzebp(Context context, zzfed zzfedVar, zzfde zzfdeVar, zzfcr zzfcrVar, zzedo zzedoVar, zzfib zzfibVar, String str) {
        this.zza = context;
        this.zzb = zzfedVar;
        this.zzc = zzfdeVar;
        this.zzd = zzfcrVar;
        this.zze = zzedoVar;
        this.zzh = zzfibVar;
        this.zzi = str;
    }

    private final zzfia zzd(String str) {
        zzfia zzfiaVarZzb = zzfia.zzb(str);
        zzfiaVarZzb.zzh(this.zzc, null);
        zzfiaVarZzb.zzf(this.zzd);
        zzfiaVarZzb.zza(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zzi);
        if (!this.zzd.zzv.isEmpty()) {
            zzfiaVarZzb.zza("ancn", (String) this.zzd.zzv.get(0));
        }
        if (this.zzd.zzak) {
            zzfiaVarZzb.zza("device_connectivity", true != com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zzfiaVarZzb.zza("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzfiaVarZzb.zza("offline_ad", "1");
        }
        return zzfiaVarZzb;
    }

    private final void zze(zzfia zzfiaVar) {
        if (!this.zzd.zzak) {
            this.zzh.zzb(zzfiaVar);
            return;
        }
        this.zze.zzd(new zzedq(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zza(zzfiaVar), 2));
    }

    private final boolean zzf() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbr);
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String strZzp = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
                    boolean zMatches = false;
                    if (str != null && strZzp != null) {
                        try {
                            zMatches = Pattern.matches(str, strZzp);
                        } catch (RuntimeException e) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzf = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zzd.zzak) {
            zze(zzd("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzg) {
            int i = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            String strZza = this.zzb.zza(str);
            zzfia zzfiaVarZzd = zzd("ifts");
            zzfiaVarZzd.zza("reason", "adapter");
            if (i >= 0) {
                zzfiaVarZzd.zza("arec", String.valueOf(i));
            }
            if (strZza != null) {
                zzfiaVarZzd.zza("areec", strZza);
            }
            this.zzh.zzb(zzfiaVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzb() {
        if (this.zzg) {
            zzfib zzfibVar = this.zzh;
            zzfia zzfiaVarZzd = zzd("ifts");
            zzfiaVarZzd.zza("reason", "blocked");
            zzfibVar.zzb(zzfiaVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzc(zzdhe zzdheVar) {
        if (this.zzg) {
            zzfia zzfiaVarZzd = zzd("ifts");
            zzfiaVarZzd.zza("reason", "exception");
            if (!TextUtils.isEmpty(zzdheVar.getMessage())) {
                zzfiaVarZzd.zza("msg", zzdheVar.getMessage());
            }
            this.zzh.zzb(zzfiaVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzi() {
        if (zzf()) {
            this.zzh.zzb(zzd("adapter_shown"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzj() {
        if (zzf()) {
            this.zzh.zzb(zzd("adapter_impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyf
    public final void zzq() {
        if (zzf() || this.zzd.zzak) {
            zze(zzd("impression"));
        }
    }
}
