package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeho implements zzehi {
    private final zzdht zza;
    private final zzgad zzb;
    private final zzdlz zzc;
    private final zzfek zzd;
    private final zzdoo zze;

    public zzeho(zzdht zzdhtVar, zzgad zzgadVar, zzdlz zzdlzVar, zzfek zzfekVar, zzdoo zzdooVar) {
        this.zza = zzdhtVar;
        this.zzb = zzgadVar;
        this.zzc = zzdlzVar;
        this.zzd = zzfekVar;
        this.zze = zzdooVar;
    }

    private final ListenableFuture zzg(final zzfde zzfdeVar, final zzfcr zzfcrVar, final JSONObject jSONObject) {
        zzdlz zzdlzVar = this.zzc;
        final ListenableFuture listenableFutureZza = this.zzd.zza();
        final ListenableFuture listenableFutureZza2 = zzdlzVar.zza(zzfdeVar, zzfcrVar, jSONObject);
        return zzfzt.zzc(listenableFutureZza, listenableFutureZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzehj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(listenableFutureZza2, listenableFutureZza, zzfdeVar, zzfcrVar, jSONObject);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final ListenableFuture zza(final zzfde zzfdeVar, final zzfcr zzfcrVar) {
        return zzfzt.zzn(zzfzt.zzn(this.zzd.zza(), new zzfza() { // from class: com.google.android.gms.internal.ads.zzehl
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zze(zzfcrVar, (zzdoi) obj);
            }
        }, this.zzb), new zzfza() { // from class: com.google.android.gms.internal.ads.zzehm
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzf(zzfdeVar, zzfcrVar, (JSONArray) obj);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeeu
    public final boolean zzb(zzfde zzfdeVar, zzfcr zzfcrVar) {
        zzfcx zzfcxVar = zzfcrVar.zzu;
        return (zzfcxVar == null || zzfcxVar.zzc == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzdje zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfde zzfdeVar, zzfcr zzfcrVar, JSONObject jSONObject) throws Exception {
        zzdjj zzdjjVar = (zzdjj) listenableFuture.get();
        zzdoi zzdoiVar = (zzdoi) listenableFuture2.get();
        zzdjk zzdjkVarZzd = this.zza.zzd(new zzctm(zzfdeVar, zzfcrVar, null), new zzdjv(zzdjjVar), new zzdii(jSONObject, zzdoiVar));
        zzdjkVarZzd.zzh().zzb();
        zzdjkVarZzd.zzk().zza(zzdoiVar);
        zzdjkVarZzd.zzg().zza(zzdjjVar.zzs());
        zzdjkVarZzd.zzl().zza(this.zze);
        return zzdjkVarZzd.zza();
    }

    final /* synthetic */ ListenableFuture zzd(zzdoi zzdoiVar, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzfzt.zzh(zzdoiVar));
        if (jSONObject.optBoolean("success")) {
            return zzfzt.zzh(jSONObject.getJSONObject("json").getJSONArray(CampaignUnit.JSON_KEY_ADS));
        }
        throw new zzbnp("process json failed");
    }

    final /* synthetic */ ListenableFuture zze(zzfcr zzfcrVar, final zzdoi zzdoiVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzio)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfcrVar.zzu.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzfzt.zzn(zzdoiVar.zzd("google.afma.nativeAds.preProcessJson", jSONObject2), new zzfza() { // from class: com.google.android.gms.internal.ads.zzehk
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzd(zzdoiVar, (JSONObject) obj);
            }
        }, this.zzb);
    }

    final /* synthetic */ ListenableFuture zzf(zzfde zzfdeVar, zzfcr zzfcrVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzfzt.zzg(new zzdwm(3));
        }
        if (zzfdeVar.zza.zza.zzk <= 1) {
            return zzfzt.zzm(zzg(zzfdeVar, zzfcrVar, jSONArray.getJSONObject(0)), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzehn
                @Override // com.google.android.gms.internal.ads.zzfsk
                public final Object apply(Object obj) {
                    return Collections.singletonList(zzfzt.zzh((zzdje) obj));
                }
            }, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfdeVar.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfdeVar.zza.zza.zzk);
        for (int i = 0; i < zzfdeVar.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzfdeVar, zzfcrVar, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzfzt.zzg(new zzdwm(3)));
            }
        }
        return zzfzt.zzh(arrayList);
    }
}
