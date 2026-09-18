package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdva implements zzcxo, zzdag, zzczd {
    private final zzdvm zza;
    private final String zzb;
    private final String zzc;
    private zzcxe zzf;
    private com.google.android.gms.ads.internal.client.zze zzg;
    private JSONObject zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private int zzd = 0;
    private zzduz zze = zzduz.AD_REQUESTED;

    zzdva(zzdvm zzdvmVar, zzfdn zzfdnVar, String str) {
        this.zza = zzdvmVar;
        this.zzc = str;
        this.zzb = zzfdnVar.zzf;
    }

    private static JSONObject zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zzeVar.zzc);
        jSONObject.put("errorCode", zzeVar.zza);
        jSONObject.put("errorDescription", zzeVar.zzb);
        com.google.android.gms.ads.internal.client.zze zzeVar2 = zzeVar.zzd;
        jSONObject.put("underlyingError", zzeVar2 == null ? null : zzh(zzeVar2));
        return jSONObject;
    }

    private final JSONObject zzi(zzcxe zzcxeVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("winningAdapterClassName", zzcxeVar.zzg());
        jSONObject.put("responseSecsSinceEpoch", zzcxeVar.zzc());
        jSONObject.put("responseId", zzcxeVar.zzi());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziW)).booleanValue()) {
            String strZzd = zzcxeVar.zzd();
            if (!TextUtils.isEmpty(strZzd)) {
                zzcat.zze("Bidding data: ".concat(String.valueOf(strZzd)));
                jSONObject.put("biddingData", new JSONObject(strZzd));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject.put("postBody", this.zzi);
        }
        if (!TextUtils.isEmpty(this.zzj)) {
            jSONObject.put("adResponseBody", this.zzj);
        }
        Object obj = this.zzk;
        if (obj != null) {
            jSONObject.put("adResponseHeaders", obj);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziZ)).booleanValue()) {
            jSONObject.put("hasExceededMemoryLimit", this.zzn);
        }
        JSONArray jSONArray = new JSONArray();
        for (com.google.android.gms.ads.internal.client.zzu zzuVar : zzcxeVar.zzj()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adapterClassName", zzuVar.zza);
            jSONObject2.put("latencyMillis", zzuVar.zzb);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziX)).booleanValue()) {
                jSONObject2.put("credentials", com.google.android.gms.ads.internal.client.zzay.zzb().zzh(zzuVar.zzd));
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = zzuVar.zzc;
            jSONObject2.put("error", zzeVar == null ? null : zzh(zzeVar));
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("adNetworks", jSONArray);
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzczd
    public final void zza(zzcsx zzcsxVar) {
        if (this.zza.zzp()) {
            this.zzf = zzcsxVar.zzl();
            this.zze = zzduz.AD_LOADED;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjd)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzbF(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza.zzp()) {
            this.zze = zzduz.AD_LOAD_FAILED;
            this.zzg = zzeVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjd)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbr(zzbvg zzbvgVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjd)).booleanValue() || !this.zza.zzp()) {
            return;
        }
        this.zza.zzf(this.zzb, this);
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbs(zzfde zzfdeVar) {
        if (this.zza.zzp()) {
            if (!zzfdeVar.zzb.zza.isEmpty()) {
                this.zzd = ((zzfcr) zzfdeVar.zzb.zza.get(0)).zzb;
            }
            if (!TextUtils.isEmpty(zzfdeVar.zzb.zzb.zzk)) {
                this.zzh = zzfdeVar.zzb.zzb.zzk;
            }
            if (!TextUtils.isEmpty(zzfdeVar.zzb.zzb.zzl)) {
                this.zzi = zzfdeVar.zzb.zzb.zzl;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziZ)).booleanValue()) {
                if (!this.zza.zzr()) {
                    this.zzn = true;
                    return;
                }
                if (!TextUtils.isEmpty(zzfdeVar.zzb.zzb.zzm)) {
                    this.zzj = zzfdeVar.zzb.zzb.zzm;
                }
                if (zzfdeVar.zzb.zzb.zzn.length() > 0) {
                    this.zzk = zzfdeVar.zzb.zzb.zzn;
                }
                zzdvm zzdvmVar = this.zza;
                JSONObject jSONObject = this.zzk;
                int length = jSONObject != null ? jSONObject.toString().length() : 0;
                if (!TextUtils.isEmpty(this.zzj)) {
                    length += this.zzj.length();
                }
                zzdvmVar.zzj(length);
            }
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        IBinder iBinder;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", this.zze);
        jSONObject.put("format", zzfcr.zza(this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjd)).booleanValue()) {
            jSONObject.put("isOutOfContext", this.zzl);
            if (this.zzl) {
                jSONObject.put("shown", this.zzm);
            }
        }
        zzcxe zzcxeVar = this.zzf;
        JSONObject jSONObjectZzi = null;
        if (zzcxeVar != null) {
            jSONObjectZzi = zzi(zzcxeVar);
        } else {
            com.google.android.gms.ads.internal.client.zze zzeVar = this.zzg;
            if (zzeVar != null && (iBinder = zzeVar.zze) != null) {
                zzcxe zzcxeVar2 = (zzcxe) iBinder;
                jSONObjectZzi = zzi(zzcxeVar2);
                if (zzcxeVar2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObjectZzi.put("errors", jSONArray);
                }
            }
        }
        jSONObject.put("responseInfo", jSONObjectZzi);
        return jSONObject;
    }

    public final void zze() {
        this.zzl = true;
    }

    public final void zzf() {
        this.zzm = true;
    }

    public final boolean zzg() {
        return this.zze != zzduz.AD_REQUESTED;
    }
}
