package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import com.google.common.util.concurrent.ListenableFuture;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmm {
    private final Context zza;
    private final zzdlv zzb;
    private final zzaro zzc;
    private final zzcaz zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzaxv zzf;
    private final Executor zzg;
    private final zzbfc zzh;
    private final zzdne zzi;
    private final zzdpt zzj;
    private final ScheduledExecutorService zzk;
    private final zzdoo zzl;
    private final zzdso zzm;
    private final zzfib zzn;
    private final zzfjx zzo;
    private final zzedo zzp;
    private final zzedz zzq;

    public zzdmm(Context context, zzdlv zzdlvVar, zzaro zzaroVar, zzcaz zzcazVar, com.google.android.gms.ads.internal.zza zzaVar, zzaxv zzaxvVar, Executor executor, zzfdn zzfdnVar, zzdne zzdneVar, zzdpt zzdptVar, ScheduledExecutorService scheduledExecutorService, zzdso zzdsoVar, zzfib zzfibVar, zzfjx zzfjxVar, zzedo zzedoVar, zzdoo zzdooVar, zzedz zzedzVar) {
        this.zza = context;
        this.zzb = zzdlvVar;
        this.zzc = zzaroVar;
        this.zzd = zzcazVar;
        this.zze = zzaVar;
        this.zzf = zzaxvVar;
        this.zzg = executor;
        this.zzh = zzfdnVar.zzi;
        this.zzi = zzdneVar;
        this.zzj = zzdptVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdsoVar;
        this.zzn = zzfibVar;
        this.zzo = zzfjxVar;
        this.zzp = zzedoVar;
        this.zzl = zzdooVar;
        this.zzq = zzedzVar;
    }

    public static final com.google.android.gms.ads.internal.client.zzel zzi(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(jSONObjectOptJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (jSONObjectOptJSONObject == null) {
            return zzfvs.zzl();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzfvs.zzl();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            com.google.android.gms.ads.internal.client.zzel zzelVarZzr = zzr(jSONArrayOptJSONArray.optJSONObject(i));
            if (zzelVarZzr != null) {
                arrayList.add(zzelVarZzr);
            }
        }
        return zzfvs.zzj(arrayList);
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, Object obj) {
        final Object obj2 = null;
        return zzfzt.zzf(listenableFuture, Exception.class, new zzfza(obj2) { // from class: com.google.android.gms.internal.ads.zzdmk
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzfzt.zzh(null);
            }
        }, zzcbg.zzf);
    }

    private static ListenableFuture zzm(boolean z, final ListenableFuture listenableFuture, Object obj) {
        return z ? zzfzt.zzn(listenableFuture, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdml
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj2) {
                return obj2 != null ? listenableFuture : zzfzt.zzg(new zzeir(1, "Retrieve required value in native ad response failed."));
            }
        }, zzcbg.zzf) : zzl(listenableFuture, null);
    }

    private final ListenableFuture zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzfzt.zzh(null);
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            return zzfzt.zzh(null);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt("width", -1);
        final int iOptInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzfzt.zzh(new zzbfa(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzfzt.zzm(this.zzb.zzb(strOptString, dOptDouble, zOptBoolean), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdmc
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return new zzbfa(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2);
            }
        }, this.zzg), null);
    }

    private final ListenableFuture zzo(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzfzt.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z));
        }
        return zzfzt.zzm(zzfzt.zzd(arrayList), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdmh
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzbfa zzbfaVar : (List) obj) {
                    if (zzbfaVar != null) {
                        arrayList2.add(zzbfaVar);
                    }
                }
                return arrayList2;
            }
        }, this.zzg);
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzfcr zzfcrVar, zzfcv zzfcvVar) {
        final ListenableFuture listenableFutureZzb = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString(TJAdUnitConstants.String.HTML), zzfcrVar, zzfcvVar, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzfzt.zzn(listenableFutureZzb, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdmd
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) throws zzeir {
                zzcgb zzcgbVar = (zzcgb) obj;
                if (zzcgbVar == null || zzcgbVar.zzq() == null) {
                    throw new zzeir(1, "Retrieve video view in html5 ad response failed.");
                }
                return listenableFutureZzb;
            }
        }, zzcbg.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt(CampaignEx.JSON_KEY_AD_R), jSONObject2.getInt("g"), jSONObject2.getInt(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final com.google.android.gms.ads.internal.client.zzel zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzel(strOptString, strOptString2);
    }

    final /* synthetic */ zzbex zza(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString("text");
        Integer numZzq = zzq(jSONObject, "bg_color");
        Integer numZzq2 = zzq(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzbex(strOptString, list, numZzq, numZzq2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.zzh.zze, zOptBoolean);
    }

    final /* synthetic */ ListenableFuture zzb(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfcr zzfcrVar, zzfcv zzfcvVar, String str, String str2, Object obj) throws Exception {
        zzcgb zzcgbVarZza = this.zzj.zza(zzqVar, zzfcrVar, zzfcvVar);
        final zzcbk zzcbkVarZza = zzcbk.zza(zzcgbVarZza);
        zzdol zzdolVarZzb = this.zzl.zzb();
        zzcgbVarZza.zzN().zzM(zzdolVarZzb, zzdolVarZzb, zzdolVarZzb, zzdolVarZzb, zzdolVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(this.zza, null, null), null, null, this.zzp, this.zzo, this.zzm, this.zzn, null, zzdolVarZzb, null, null, null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdC)).booleanValue()) {
            zzcgbVarZza.zzad("/getNativeAdViewSignals", zzbji.zzs);
        }
        zzcgbVarZza.zzad("/getNativeClickMeta", zzbji.zzt);
        zzcgbVarZza.zzN().zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzdmg
            @Override // com.google.android.gms.internal.ads.zzchm
            public final void zza(boolean z, int i, String str3, String str4) {
                zzcbk zzcbkVar = zzcbkVarZza;
                if (z) {
                    zzcbkVar.zzb();
                    return;
                }
                zzcbkVar.zzd(new zzeir(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcgbVarZza.zzab(str, str2, null);
        return zzcbkVarZza;
    }

    final /* synthetic */ ListenableFuture zzc(String str, Object obj) throws Exception {
        com.google.android.gms.ads.internal.zzt.zzz();
        zzcgb zzcgbVarZza = zzcgn.zza(this.zza, zzchq.zza(), "native-omid", false, false, this.zzc, null, this.zzd, null, null, this.zze, this.zzf, null, null, this.zzq);
        final zzcbk zzcbkVarZza = zzcbk.zza(zzcgbVarZza);
        zzcgbVarZza.zzN().zzA(new zzchm() { // from class: com.google.android.gms.internal.ads.zzdmi
            @Override // com.google.android.gms.internal.ads.zzchm
            public final void zza(boolean z, int i, String str2, String str3) {
                zzcbkVarZza.zzb();
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzeV)).booleanValue()) {
            zzcgbVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        } else {
            zzcgbVarZza.loadData(str, "text/html", "UTF-8");
        }
        return zzcbkVarZza;
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return zzfzt.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzm(jSONObjectOptJSONObject.optBoolean("require"), zzfzt.zzm(zzo(jSONArrayOptJSONArray, false, true), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzdmj
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                return this.zza.zza(jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str) {
        zzbfc zzbfcVar = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbfcVar.zzb, zzbfcVar.zzd);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, final zzfcr zzfcrVar, final zzfcv zzfcvVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjt)).booleanValue()) {
            return zzfzt.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzfzt.zzh(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzfzt.zzh(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString(TJAdUnitConstants.String.HTML);
        final com.google.android.gms.ads.internal.client.zzq zzqVarZzk = zzk(jSONObjectOptJSONObject.optInt("width", 0), jSONObjectOptJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzfzt.zzh(null);
        }
        final ListenableFuture listenableFutureZzn = zzfzt.zzn(zzfzt.zzh(null), new zzfza() { // from class: com.google.android.gms.internal.ads.zzdme
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzqVarZzk, zzfcrVar, zzfcvVar, strOptString, strOptString2, obj);
            }
        }, zzcbg.zze);
        return zzfzt.zzn(listenableFutureZzn, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdmf
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) throws zzeir {
                if (((zzcgb) obj) != null) {
                    return listenableFutureZzn;
                }
                throw new zzeir(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzcbg.zzf);
    }

    public final ListenableFuture zzh(JSONObject jSONObject, zzfcr zzfcrVar, zzfcv zzfcvVar) {
        ListenableFuture listenableFutureZza;
        JSONObject jSONObjectZzg = com.google.android.gms.ads.internal.util.zzbw.zzg(jSONObject, "html_containers", "instream");
        if (jSONObjectZzg != null) {
            return zzp(jSONObjectZzg, zzfcrVar, zzfcvVar);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return zzfzt.zzh(null);
        }
        String strOptString = jSONObjectOptJSONObject.optString("vast_xml");
        boolean z = false;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjs)).booleanValue() && jSONObjectOptJSONObject.has(TJAdUnitConstants.String.HTML)) {
            z = true;
        }
        if (!TextUtils.isEmpty(strOptString)) {
            if (!z) {
                listenableFutureZza = this.zzi.zza(jSONObjectOptJSONObject);
            }
            return zzl(zzfzt.zzo(listenableFutureZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdD)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        if (!z) {
            zzcat.zzj("Required field 'vast_xml' or 'html' is missing");
            return zzfzt.zzh(null);
        }
        listenableFutureZza = zzp(jSONObjectOptJSONObject, zzfcrVar, zzfcvVar);
        return zzl(zzfzt.zzo(listenableFutureZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdD)).intValue(), TimeUnit.SECONDS, this.zzk), null);
    }

    private final com.google.android.gms.ads.internal.client.zzq zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return com.google.android.gms.ads.internal.client.zzq.zzc();
            }
            i = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzq(this.zza, new AdSize(i, i2));
    }
}
