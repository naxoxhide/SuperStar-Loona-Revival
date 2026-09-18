package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrx implements zzdcd, com.google.android.gms.ads.internal.client.zza, zzcyf, zzcxp {
    private final Context zza;
    private final zzfed zzb;
    private final zzdso zzc;
    private final zzfde zzd;
    private final zzfcr zze;
    private final zzedo zzf;
    private Boolean zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgN)).booleanValue();

    public zzdrx(Context context, zzfed zzfedVar, zzdso zzdsoVar, zzfde zzfdeVar, zzfcr zzfcrVar, zzedo zzedoVar) {
        this.zza = context;
        this.zzb = zzfedVar;
        this.zzc = zzdsoVar;
        this.zzd = zzfdeVar;
        this.zze = zzfcrVar;
        this.zzf = zzedoVar;
    }

    private final zzdsn zzd(String str) {
        zzdsn zzdsnVarZza = this.zzc.zza();
        zzdsnVarZza.zze(this.zzd.zzb.zzb);
        zzdsnVarZza.zzd(this.zze);
        zzdsnVarZza.zzb("action", str);
        if (!this.zze.zzv.isEmpty()) {
            zzdsnVarZza.zzb("ancn", (String) this.zze.zzv.get(0));
        }
        if (this.zze.zzak) {
            zzdsnVarZza.zzb("device_connectivity", true != com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zzdsnVarZza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzdsnVarZza.zzb("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzgW)).booleanValue()) {
            boolean z = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(this.zzd.zza.zza) != 1;
            zzdsnVarZza.zzb("scar", String.valueOf(z));
            if (z) {
                com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzd.zza.zza.zzd;
                zzdsnVarZza.zzc("ragent", zzlVar.zzp);
                zzdsnVarZza.zzc("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzf.zza(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(zzlVar)));
            }
        }
        return zzdsnVarZza;
    }

    private final void zze(zzdsn zzdsnVar) {
        if (!this.zze.zzak) {
            zzdsnVar.zzg();
            return;
        }
        this.zzf.zzd(new zzedq(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdsnVar.zzf(), 2));
    }

    private final boolean zzf() {
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
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
                    this.zzg = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zze.zzak) {
            zze(zzd("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzh) {
            zzdsn zzdsnVarZzd = zzd("ifts");
            zzdsnVarZzd.zzb("reason", "adapter");
            int i = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            if (i >= 0) {
                zzdsnVarZzd.zzb("arec", String.valueOf(i));
            }
            String strZza = this.zzb.zza(str);
            if (strZza != null) {
                zzdsnVarZzd.zzb("areec", strZza);
            }
            zzdsnVarZzd.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzb() {
        if (this.zzh) {
            zzdsn zzdsnVarZzd = zzd("ifts");
            zzdsnVarZzd.zzb("reason", "blocked");
            zzdsnVarZzd.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzc(zzdhe zzdheVar) {
        if (this.zzh) {
            zzdsn zzdsnVarZzd = zzd("ifts");
            zzdsnVarZzd.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdheVar.getMessage())) {
                zzdsnVarZzd.zzb("msg", zzdheVar.getMessage());
            }
            zzdsnVarZzd.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzj() {
        if (zzf()) {
            zzd("adapter_impression").zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyf
    public final void zzq() {
        if (zzf() || this.zze.zzak) {
            zze(zzd("impression"));
        }
    }
}
