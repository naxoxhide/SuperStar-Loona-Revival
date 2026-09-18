package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzbzh;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzdst;
import com.google.android.gms.internal.ads.zzfit;
import com.google.android.gms.internal.ads.zzfje;
import com.google.android.gms.internal.ads.zzfzp;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzw implements zzfzp {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzbzo zzb;
    final /* synthetic */ zzbzh zzc;
    final /* synthetic */ zzfit zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzaa zzf;

    zzw(zzaa zzaaVar, ListenableFuture listenableFuture, zzbzo zzbzoVar, zzbzh zzbzhVar, zzfit zzfitVar, long j) {
        this.zzf = zzaaVar;
        this.zza = listenableFuture;
        this.zzb = zzbzoVar;
        this.zzc = zzbzhVar;
        this.zzd = zzfitVar;
        this.zze = j;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final void zza(Throwable th) {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zze;
        String message = th.getMessage();
        com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "SignalGeneratorImpl.generateSignals");
        zzaa zzaaVar = this.zzf;
        zzf.zzc(zzaaVar.zzr, zzaaVar.zzj, "sgf", new Pair("sgf_reason", message), new Pair("tqgt", String.valueOf(jCurrentTimeMillis)));
        zzfje zzfjeVarZzr = zzaa.zzr(this.zza, this.zzb);
        if (((Boolean) zzbdu.zze.zze()).booleanValue() && zzfjeVarZzr != null) {
            zzfit zzfitVar = this.zzd;
            zzfitVar.zzg(th);
            zzfitVar.zzf(false);
            zzfjeVarZzr.zza(zzfitVar);
            zzfjeVarZzr.zzg();
        }
        try {
            this.zzc.zzb("Internal error. " + message);
        } catch (RemoteException e) {
            zzcat.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzam zzamVar = (zzam) obj;
        zzfje zzfjeVarZzr = zzaa.zzr(this.zza, this.zzb);
        if (!((Boolean) zzba.zzc().zzb(zzbci.zzhz)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zzcat.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (!((Boolean) zzbdu.zze.zze()).booleanValue() || zzfjeVarZzr == null) {
                return;
            }
            zzfit zzfitVar = this.zzd;
            zzfitVar.zzc("QueryInfo generation has been disabled.");
            zzfitVar.zzf(false);
            zzfjeVarZzr.zza(zzfitVar);
            zzfjeVarZzr.zzg();
            return;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zze;
        try {
            if (zzamVar == null) {
                this.zzc.zzc(null, null, null);
                zzaa zzaaVar = this.zzf;
                zzf.zzc(zzaaVar.zzr, zzaaVar.zzj, "sgs", new Pair("rid", "-1"));
                this.zzd.zzf(true);
                if (!((Boolean) zzbdu.zze.zze()).booleanValue() || zzfjeVarZzr == null) {
                    return;
                }
                zzfjeVarZzr.zza(this.zzd);
                zzfjeVarZzr.zzg();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(zzamVar.zzb);
                String strOptString = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
                if (TextUtils.isEmpty(strOptString)) {
                    zzcat.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzaa zzaaVar2 = this.zzf;
                    zzf.zzc(zzaaVar2.zzr, zzaaVar2.zzj, "sgf", new Pair("sgf_reason", "rid_missing"));
                    zzfit zzfitVar2 = this.zzd;
                    zzfitVar2.zzc("Request ID empty");
                    zzfitVar2.zzf(false);
                    if (!((Boolean) zzbdu.zze.zze()).booleanValue() || zzfjeVarZzr == null) {
                        return;
                    }
                    zzfjeVarZzr.zza(this.zzd);
                    zzfjeVarZzr.zzg();
                    return;
                }
                zzaa zzaaVar3 = this.zzf;
                zzaa.zzG(zzaaVar3, strOptString, zzamVar.zzb, zzaaVar3.zzj);
                Bundle bundle = zzamVar.zzc;
                zzaa zzaaVar4 = this.zzf;
                if (zzaaVar4.zzw && bundle != null && bundle.getInt(zzaaVar4.zzy, -1) == -1) {
                    zzaa zzaaVar5 = this.zzf;
                    bundle.putInt(zzaaVar5.zzy, zzaaVar5.zzz.get());
                }
                zzaa zzaaVar6 = this.zzf;
                if (zzaaVar6.zzv && bundle != null && TextUtils.isEmpty(bundle.getString(zzaaVar6.zzx))) {
                    if (TextUtils.isEmpty(this.zzf.zzB)) {
                        zzaa zzaaVar7 = this.zzf;
                        com.google.android.gms.ads.internal.util.zzt zztVarZzp = com.google.android.gms.ads.internal.zzt.zzp();
                        zzaa zzaaVar8 = this.zzf;
                        zzaaVar7.zzB = zztVarZzp.zzc(zzaaVar8.zzg, zzaaVar8.zzA.zza);
                    }
                    zzaa zzaaVar9 = this.zzf;
                    bundle.putString(zzaaVar9.zzx, zzaaVar9.zzB);
                }
                this.zzc.zzc(zzamVar.zza, zzamVar.zzb, bundle);
                zzaa zzaaVar10 = this.zzf;
                zzdst zzdstVar = zzaaVar10.zzr;
                zzdsj zzdsjVar = zzaaVar10.zzj;
                Pair[] pairArr = new Pair[2];
                pairArr[0] = new Pair("tqgt", String.valueOf(jCurrentTimeMillis));
                String str = "na";
                if (((Boolean) zzba.zzc().zzb(zzbci.zzjm)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e2) {
                        zzcat.zzh("Error retrieving JSONObject from the requestJson, ", e2);
                    }
                }
                pairArr[1] = new Pair("tpc", str);
                zzf.zzc(zzdstVar, zzdsjVar, "sgs", pairArr);
                this.zzd.zzf(true);
                if (!((Boolean) zzbdu.zze.zze()).booleanValue() || zzfjeVarZzr == null) {
                    return;
                }
                zzfjeVarZzr.zza(this.zzd);
                zzfjeVarZzr.zzg();
            } catch (JSONException e3) {
                zzcat.zzj("Failed to create JSON object from the request string.");
                this.zzc.zzb("Internal error for request JSON: " + e3.toString());
                zzaa zzaaVar11 = this.zzf;
                zzf.zzc(zzaaVar11.zzr, zzaaVar11.zzj, "sgf", new Pair("sgf_reason", "request_invalid"));
                zzfit zzfitVar3 = this.zzd;
                zzfitVar3.zzg(e3);
                zzfitVar3.zzf(false);
                com.google.android.gms.ads.internal.zzt.zzo().zzu(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbdu.zze.zze()).booleanValue() || zzfjeVarZzr == null) {
                    return;
                }
                zzfjeVarZzr.zza(this.zzd);
                zzfjeVarZzr.zzg();
            }
        } catch (RemoteException e4) {
            zzfit zzfitVar4 = this.zzd;
            zzfitVar4.zzg(e4);
            zzfitVar4.zzf(false);
            zzcat.zzh("", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "SignalGeneratorImpl.generateSignals.onSuccess");
        } finally {
            if (((Boolean) zzbdu.zze.zze()).booleanValue() && zzfjeVarZzr != null) {
                zzfjeVarZzr.zza(this.zzd);
                zzfjeVarZzr.zzg();
            }
        }
    }
}
