package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvm implements zzdwk, zzdux {
    private final zzdvu zza;
    private final zzdwl zzb;
    private final zzduy zzc;
    private final zzdvh zzd;
    private final zzduw zze;
    private final zzdwg zzf;
    private final String zzg;

    @Nullable
    private final String zzh;
    private JSONObject zzm;
    private boolean zzp;
    private int zzq;
    private boolean zzr;
    private final Map zzi = new HashMap();
    private final Map zzj = new HashMap();
    private final Map zzk = new HashMap();
    private String zzl = JsonUtils.EMPTY_JSON;
    private long zzn = Long.MAX_VALUE;
    private zzdvi zzo = zzdvi.NONE;
    private zzdvl zzs = zzdvl.UNKNOWN;
    private long zzt = 0;

    zzdvm(zzdvu zzdvuVar, zzdwl zzdwlVar, zzduy zzduyVar, Context context, zzcaz zzcazVar, zzdvh zzdvhVar, zzdwg zzdwgVar, @Nullable String str) {
        this.zza = zzdvuVar;
        this.zzb = zzdwlVar;
        this.zzc = zzduyVar;
        this.zze = new zzduw(context);
        this.zzg = zzcazVar.zza;
        this.zzh = str;
        this.zzd = zzdvhVar;
        this.zzf = zzdwgVar;
        com.google.android.gms.ads.internal.zzt.zzs().zzg(this);
    }

    private final synchronized JSONObject zzs() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : this.zzi.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzdva zzdvaVar : (List) entry.getValue()) {
                if (zzdvaVar.zzg()) {
                    jSONArray.put(zzdvaVar.zzd());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzt() {
        this.zzr = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzc(this);
        this.zzc.zzc(this);
        this.zzf.zzf(this);
        zzz(com.google.android.gms.ads.internal.zzt.zzo().zzh().zzo());
    }

    private final void zzu() {
        com.google.android.gms.ads.internal.zzt.zzo().zzh().zzG(zzd());
    }

    private final synchronized void zzv(zzdvi zzdviVar, boolean z) {
        if (this.zzo == zzdviVar) {
            return;
        }
        if (zzp()) {
            zzx();
        }
        this.zzo = zzdviVar;
        if (zzp()) {
            zzy();
        }
        if (z) {
            zzu();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x000b, B:11:0x001d, B:13:0x0027, B:18:0x0036, B:14:0x002b, B:16:0x0031), top: B:26:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0031 A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x000b, B:11:0x001d, B:13:0x0027, B:18:0x0036, B:14:0x002b, B:16:0x0031), top: B:26:0x0001 }] */
    private final synchronized void zzw(boolean z, boolean z2) {
        if (this.zzp == z) {
            return;
        }
        this.zzp = z;
        if (z) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziU)).booleanValue() || !com.google.android.gms.ads.internal.zzt.zzs().zzl()) {
                zzy();
            } else if (!zzp()) {
                zzx();
            }
        } else if (!zzp()) {
            zzx();
        }
        if (z2) {
            zzu();
        }
    }

    private final synchronized void zzx() {
        zzdvi zzdviVar = zzdvi.NONE;
        int iOrdinal = this.zzo.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zza();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zza();
        }
    }

    private final synchronized void zzy() {
        zzdvi zzdviVar = zzdvi.NONE;
        int iOrdinal = this.zzo.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzb();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzb();
        }
    }

    private final synchronized void zzz(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzw(jSONObject.optBoolean("isTestMode", false), false);
            zzv((zzdvi) Enum.valueOf(zzdvi.class, jSONObject.optString("gesture", "NONE")), false);
            this.zzl = jSONObject.optString("networkExtras", JsonUtils.EMPTY_JSON);
            this.zzn = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    public final zzdvi zza() {
        return this.zzo;
    }

    public final synchronized ListenableFuture zzb(String str) {
        zzcbl zzcblVar;
        zzcblVar = new zzcbl();
        if (this.zzj.containsKey(str)) {
            zzcblVar.zzc((zzdva) this.zzj.get(str));
        } else {
            if (!this.zzk.containsKey(str)) {
                this.zzk.put(str, new ArrayList());
            }
            ((List) this.zzk.get(str)).add(zzcblVar);
        }
        return zzcblVar;
    }

    public final synchronized String zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue() && zzp()) {
            if (this.zzn < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                this.zzl = JsonUtils.EMPTY_JSON;
                this.zzn = Long.MAX_VALUE;
                return "";
            }
            if (this.zzl.equals(JsonUtils.EMPTY_JSON)) {
                return "";
            }
            return this.zzl;
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzp);
            jSONObject.put("gesture", this.zzo);
            if (this.zzn > com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzl);
                jSONObject.put("networkExtrasExpirationSecs", this.zzn);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(TapjoyConstants.TJC_PLATFORM, "ANDROID");
            if (!TextUtils.isEmpty(this.zzh)) {
                jSONObject.put("sdkVersion", "afma-sdk-a-v" + this.zzh);
            }
            jSONObject.put("internalSdkVersion", this.zzg);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("adapters", this.zzd.zza());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjf)).booleanValue()) {
                String strZzm = com.google.android.gms.ads.internal.zzt.zzo().zzm();
                if (!TextUtils.isEmpty(strZzm)) {
                    jSONObject.put(TapjoyConstants.TJC_PLUGIN, strZzm);
                }
            }
            if (this.zzn < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                this.zzl = JsonUtils.EMPTY_JSON;
            }
            jSONObject.put("networkExtras", this.zzl);
            jSONObject.put("adSlots", zzs());
            jSONObject.put("appInfo", this.zze.zza());
            String strZzc = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzc();
            if (!TextUtils.isEmpty(strZzc)) {
                jSONObject.put("cld", new JSONObject(strZzc));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziV)).booleanValue() && (jSONObject2 = this.zzm) != null) {
                zzcat.zze("Server data: " + jSONObject2.toString());
                jSONObject.put("serverData", this.zzm);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziU)).booleanValue()) {
                jSONObject.put("openAction", this.zzs);
                jSONObject.put("gesture", this.zzo);
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "Inspector.toJson");
            zzcat.zzk("Ad inspector encountered an error", e);
        }
        return jSONObject;
    }

    public final synchronized void zzf(String str, zzdva zzdvaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue() && zzp()) {
            if (this.zzq >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziH)).intValue()) {
                zzcat.zzj("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            if (!this.zzi.containsKey(str)) {
                this.zzi.put(str, new ArrayList());
            }
            this.zzq++;
            ((List) this.zzi.get(str)).add(zzdvaVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjd)).booleanValue()) {
                String strZzc = zzdvaVar.zzc();
                this.zzj.put(strZzc, zzdvaVar);
                if (this.zzk.containsKey(strZzc)) {
                    List list = (List) this.zzk.get(strZzc);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzcbl) it.next()).zzc(zzdvaVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final void zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziU)).booleanValue() && com.google.android.gms.ads.internal.zzt.zzo().zzh().zzP()) {
                zzt();
                return;
            }
            String strZzo = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzo();
            if (TextUtils.isEmpty(strZzo)) {
                return;
            }
            try {
                if (new JSONObject(strZzo).optBoolean("isTestMode", false)) {
                    zzt();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzda zzdaVar, zzdvl zzdvlVar) {
        if (!zzp()) {
            try {
                zzdaVar.zze(zzfeo.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                zzcat.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziF)).booleanValue()) {
            this.zzs = zzdvlVar;
            this.zza.zzj(zzdaVar, new zzbkc(this), new zzbjv(this.zzf));
            return;
        } else {
            try {
                zzdaVar.zze(zzfeo.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                zzcat.zzj("Ad inspector had an internal error.");
                return;
            }
        }
        throw th;
    }

    public final synchronized void zzi(String str, long j) {
        this.zzl = str;
        this.zzn = j;
        zzu();
    }

    public final synchronized void zzj(long j) {
        this.zzt += j;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    public final void zzk(boolean z) {
        if (this.zzr) {
            if (z) {
                if (!this.zzp) {
                    zzy();
                    return;
                }
            }
        } else if (z) {
            zzt();
            if (!this.zzp) {
                zzy();
                return;
            }
        }
        if (zzp()) {
            return;
        }
        zzx();
    }

    public final void zzl(zzdvi zzdviVar) {
        zzv(zzdviVar, true);
    }

    public final synchronized void zzm(JSONObject jSONObject) {
        this.zzm = jSONObject;
    }

    public final void zzn(boolean z) {
        if (!this.zzr && z) {
            zzt();
        }
        zzw(z, true);
    }

    public final boolean zzo() {
        return this.zzm != null;
    }

    public final synchronized boolean zzp() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziU)).booleanValue()) {
            return this.zzp || com.google.android.gms.ads.internal.zzt.zzs().zzl();
        }
        return this.zzp;
    }

    public final synchronized boolean zzq() {
        return this.zzp;
    }

    public final boolean zzr() {
        return this.zzt < ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzja)).longValue();
    }
}
