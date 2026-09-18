package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzcbg;
import com.google.android.gms.internal.ads.zzcgb;
import com.google.android.gms.internal.ads.zzfqo;
import com.google.android.gms.internal.ads.zzfqp;
import com.google.android.gms.internal.ads.zzfqq;
import com.google.android.gms.internal.ads.zzfqr;
import com.google.android.gms.internal.ads.zzfra;
import com.google.android.gms.internal.ads.zzfrc;
import com.google.android.gms.internal.ads.zzfrd;
import com.google.android.gms.internal.ads.zzfre;
import com.google.android.gms.internal.ads.zzfrf;
import com.google.android.gms.internal.ads.zzfrz;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzw {
    private zzfrd zzf;
    private zzcgb zzc = null;
    private boolean zze = false;
    private String zza = null;
    private zzfqq zzd = null;
    private String zzb = null;

    private final zzfrf zzl() {
        zzfre zzfreVarZzc = zzfrf.zzc();
        if (!((Boolean) zzba.zzc().zzb(zzbci.zzkv)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzfreVarZzc.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfreVarZzc.zza(this.zzb);
        }
        return zzfreVarZzc.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzv(this);
        }
    }

    public final synchronized void zza(zzcgb zzcgbVar, Context context) {
        this.zzc = zzcgbVar;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap map = new HashMap();
        map.put("action", "fetch_completed");
        zze("on_play_store_bind", map);
    }

    public final void zzb() {
        zzfqq zzfqqVar;
        if (!this.zze || (zzfqqVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzfqqVar.zza(zzl(), this.zzf);
            zzd("onLMDOverlayCollapse");
        }
    }

    public final void zzc() {
        zzfqq zzfqqVar;
        if (!this.zze || (zzfqqVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfqo zzfqoVarZzc = zzfqp.zzc();
        if (!((Boolean) zzba.zzc().zzb(zzbci.zzkv)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzfqoVarZzc.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfqoVarZzc.zza(this.zzb);
        }
        zzfqqVar.zzb(zzfqoVarZzc.zzc(), this.zzf);
    }

    final void zzd(String str) {
        zze(str, new HashMap());
    }

    final void zze(final String str, final Map map) {
        zzcbg.zze.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(str, map);
            }
        });
    }

    final void zzf(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.zza(str);
        if (this.zzc != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            zze("onError", map);
        }
    }

    public final void zzg() {
        zzfqq zzfqqVar;
        if (!this.zze || (zzfqqVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzfqqVar.zzc(zzl(), this.zzf);
            zzd("onLMDOverlayExpand");
        }
    }

    final /* synthetic */ void zzh(String str, Map map) {
        zzcgb zzcgbVar = this.zzc;
        if (zzcgbVar != null) {
            zzcgbVar.zzd(str, map);
        }
    }

    final void zzi(zzfrc zzfrcVar) {
        if (!TextUtils.isEmpty(zzfrcVar.zzb())) {
            if (!((Boolean) zzba.zzc().zzb(zzbci.zzkv)).booleanValue()) {
                this.zza = zzfrcVar.zzb();
            }
        }
        switch (zzfrcVar.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                break;
            case 8153:
                zzd("onLMDOverlayClicked");
                break;
            case 8155:
                zzd("onLMDOverlayClose");
                break;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzfrcVar.zza()));
                zze("onLMDOverlayFailedToOpen", map);
                break;
        }
    }

    public final void zzj(zzcgb zzcgbVar, zzfra zzfraVar) {
        if (zzcgbVar == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcgbVar;
        if (!this.zze && !zzk(zzcgbVar.getContext())) {
            zzf("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbci.zzkv)).booleanValue()) {
            this.zzb = zzfraVar.zzg();
        }
        zzm();
        zzfqq zzfqqVar = this.zzd;
        if (zzfqqVar != null) {
            zzfqqVar.zzd(zzfraVar, this.zzf);
        }
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfrz.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfqr.zza(context);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
