package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdlz {
    private final zzgad zza;
    private final zzdmm zzb;
    private final zzdmr zzc;

    public zzdlz(zzgad zzgadVar, zzdmm zzdmmVar, zzdmr zzdmrVar) {
        this.zza = zzgadVar;
        this.zzb = zzdmmVar;
        this.zzc = zzdmrVar;
    }

    public final ListenableFuture zza(final zzfde zzfdeVar, final zzfcr zzfcrVar, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        ListenableFuture listenableFutureZzn;
        final ListenableFuture listenableFutureZzb = this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdlx
            @Override // java.util.concurrent.Callable
            public final Object call() throws zzeir {
                zzdjj zzdjjVar = new zzdjj();
                JSONObject jSONObject2 = jSONObject;
                zzdjjVar.zzaa(jSONObject2.optInt("template_id", -1));
                zzdjjVar.zzK(jSONObject2.optString("custom_template_id"));
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("omid_partner_name") : null;
                zzfde zzfdeVar2 = zzfdeVar;
                zzdjjVar.zzV(strOptString);
                zzfdn zzfdnVar = zzfdeVar2.zza.zza;
                if (!zzfdnVar.zzg.contains(Integer.toString(zzdjjVar.zzc()))) {
                    throw new zzeir(1, "Invalid template ID: " + zzdjjVar.zzc());
                }
                if (zzdjjVar.zzc() == 3) {
                    if (zzdjjVar.zzA() == null) {
                        throw new zzeir(1, "No custom template id for custom template ad response.");
                    }
                    if (!zzfdnVar.zzh.contains(zzdjjVar.zzA())) {
                        throw new zzeir(1, "Unexpected custom template id in the response.");
                    }
                }
                zzfcr zzfcrVar2 = zzfcrVar;
                zzdjjVar.zzY(jSONObject2.optDouble(CampaignEx.JSON_KEY_STAR, -1.0d));
                String strOptString2 = jSONObject2.optString("headline", null);
                if (zzfcrVar2.zzO) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    strOptString2 = com.google.android.gms.ads.internal.util.zzt.zzx() + " : " + strOptString2;
                }
                zzdjjVar.zzZ("headline", strOptString2);
                zzdjjVar.zzZ("body", jSONObject2.optString("body", null));
                zzdjjVar.zzZ("call_to_action", jSONObject2.optString("call_to_action", null));
                zzdjjVar.zzZ(TapjoyConstants.TJC_STORE, jSONObject2.optString(TapjoyConstants.TJC_STORE, null));
                zzdjjVar.zzZ("price", jSONObject2.optString("price", null));
                zzdjjVar.zzZ("advertiser", jSONObject2.optString("advertiser", null));
                return zzdjjVar;
            }
        });
        final ListenableFuture listenableFutureZzf = this.zzb.zzf(jSONObject, "images");
        zzfcv zzfcvVar = zzfdeVar.zzb.zzb;
        zzdmm zzdmmVar = this.zzb;
        final ListenableFuture listenableFutureZzg = zzdmmVar.zzg(jSONObject, "images", zzfcrVar, zzfcvVar);
        final ListenableFuture listenableFutureZze = zzdmmVar.zze(jSONObject, "secondary_image");
        final ListenableFuture listenableFutureZze2 = zzdmmVar.zze(jSONObject, "app_icon");
        final ListenableFuture listenableFutureZzd = zzdmmVar.zzd(jSONObject, "attribution");
        final ListenableFuture listenableFutureZzh = this.zzb.zzh(jSONObject, zzfcrVar, zzfdeVar.zzb.zzb);
        final ListenableFuture listenableFutureZza = this.zzc.zza(jSONObject, "custom_assets");
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            if (TextUtils.isEmpty(strOptString)) {
                listenableFutureZzn = zzfzt.zzh(null);
            } else {
                final zzdmm zzdmmVar2 = this.zzb;
                listenableFutureZzn = zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzdmb
                    @Override // com.google.android.gms.internal.ads.zzfza
                    public final ListenableFuture zza(Object obj) {
                        return zzdmmVar2.zzc(strOptString, obj);
                    }
                }, zzcbg.zze);
            }
        } else {
            listenableFutureZzn = zzfzt.zzh(null);
        }
        final ListenableFuture listenableFuture = listenableFutureZzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(listenableFutureZzb);
        arrayList.add(listenableFutureZzf);
        arrayList.add(listenableFutureZzg);
        arrayList.add(listenableFutureZze);
        arrayList.add(listenableFutureZze2);
        arrayList.add(listenableFutureZzd);
        arrayList.add(listenableFutureZzh);
        arrayList.add(listenableFutureZza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeY)).booleanValue()) {
            arrayList.add(listenableFuture);
        }
        return zzfzt.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdly
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdjj zzdjjVar = (zzdjj) listenableFutureZzb.get();
                zzdjjVar.zzP((List) listenableFutureZzf.get());
                zzdjjVar.zzM((zzbfo) listenableFutureZze2.get());
                zzdjjVar.zzQ((zzbfo) listenableFutureZze.get());
                zzdjjVar.zzJ((zzbfg) listenableFutureZzd.get());
                JSONObject jSONObject2 = jSONObject;
                zzdjjVar.zzS(zzdmm.zzj(jSONObject2));
                zzdjjVar.zzL(zzdmm.zzi(jSONObject2));
                zzcgb zzcgbVar = (zzcgb) listenableFutureZzh.get();
                if (zzcgbVar != null) {
                    zzdjjVar.zzad(zzcgbVar);
                    zzdjjVar.zzac(zzcgbVar.zzF());
                    zzdjjVar.zzab(zzcgbVar.zzq());
                }
                zzcgb zzcgbVar2 = (zzcgb) listenableFutureZzg.get();
                if (zzcgbVar2 != null) {
                    zzdjjVar.zzO(zzcgbVar2);
                    zzdjjVar.zzae(zzcgbVar2.zzF());
                }
                ListenableFuture listenableFuture2 = listenableFuture;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeY)).booleanValue()) {
                    zzdjjVar.zzU(listenableFuture2);
                    zzdjjVar.zzX(new zzcbl());
                } else {
                    zzcgb zzcgbVar3 = (zzcgb) listenableFuture2.get();
                    if (zzcgbVar3 != null) {
                        zzdjjVar.zzT(zzcgbVar3);
                    }
                }
                for (zzdmq zzdmqVar : (List) listenableFutureZza.get()) {
                    if (zzdmqVar.zza != 1) {
                        zzdjjVar.zzN(zzdmqVar.zzb, zzdmqVar.zzd);
                    } else {
                        zzdjjVar.zzZ(zzdmqVar.zzb, zzdmqVar.zzc);
                    }
                }
                return zzdjjVar;
            }
        }, this.zza);
    }
}
