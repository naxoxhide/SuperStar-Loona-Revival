package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbxp implements zzbxu {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzgyd zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzbxr zzi;
    private final zzbxq zzn;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbxp(Context context, zzcaz zzcazVar, zzbxr zzbxrVar, String str, zzbxq zzbxqVar) {
        Preconditions.checkNotNull(zzbxrVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzn = zzbxqVar;
        this.zzi = zzbxrVar;
        Iterator it = zzbxrVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzgyd zzgydVarZza = zzgzy.zza();
        zzgydVarZza.zzn(9);
        zzgydVarZza.zzj(str);
        zzgydVarZza.zzh(str);
        zzgye zzgyeVarZza = zzgyf.zza();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzgyeVarZza.zza(str2);
        }
        zzgydVarZza.zzg((zzgyf) zzgyeVarZza.zzal());
        zzgzs zzgzsVarZza = zzgzt.zza();
        zzgzsVarZza.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = zzcazVar.zza;
        if (str3 != null) {
            zzgzsVarZza.zza(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzgzsVarZza.zzb(apkVersion);
        }
        zzgydVarZza.zzf((zzgzt) zzgzsVarZza.zzal());
        this.zzd = zzgydVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbxu
    public final zzbxr zza() {
        return this.zzi;
    }

    final /* synthetic */ ListenableFuture zzb(Map map) throws Exception {
        zzgzq zzgzqVar;
        ListenableFuture listenableFutureZzm;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        synchronized (this.zzj) {
                            int length = jSONArrayOptJSONArray.length();
                            synchronized (this.zzj) {
                                try {
                                    zzgzqVar = (zzgzq) this.zze.get(str);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (zzgzqVar == null) {
                                zzbxt.zza("Cannot find the corresponding resource object for " + str);
                            } else {
                                for (int i = 0; i < length; i++) {
                                    zzgzqVar.zza(jSONArrayOptJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                this.zza = (length > 0) | this.zza;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzbej.zzb.zze()).booleanValue()) {
                    zzcat.zzf("Failed to get SafeBrowsing metadata", e);
                }
                return zzfzt.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z = this.zza;
        if (!(z && this.zzi.zzg) && (!(this.zzm && this.zzi.zzf) && (z || !this.zzi.zzd))) {
            return zzfzt.zzh(null);
        }
        synchronized (this.zzj) {
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                this.zzd.zzc((zzgzr) ((zzgzq) it.next()).zzal());
            }
            this.zzd.zza(this.zzf);
            this.zzd.zzb(this.zzg);
            if (zzbxt.zzb()) {
                StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + this.zzd.zzl() + "\n  clickUrl: " + this.zzd.zzk() + "\n  resources: \n");
                for (zzgzr zzgzrVar : this.zzd.zzm()) {
                    sb.append("    [");
                    sb.append(zzgzrVar.zza());
                    sb.append("] ");
                    sb.append(zzgzrVar.zze());
                }
                zzbxt.zza(sb.toString());
            }
            ListenableFuture listenableFutureZzb = new com.google.android.gms.ads.internal.util.zzbq(this.zzh).zzb(1, this.zzi.zzb, null, ((zzgzy) this.zzd.zzal()).zzax());
            if (zzbxt.zzb()) {
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxm
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbxt.zza("Pinged SB successfully.");
                    }
                }, zzcbg.zza);
            }
            listenableFutureZzm = zzfzt.zzm(listenableFutureZzb, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzbxn
                @Override // com.google.android.gms.internal.ads.zzfsk
                public final Object apply(Object obj) {
                    int i2 = zzbxp.zzb;
                    return null;
                }
            }, zzcbg.zzf);
        }
        return listenableFutureZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzbxu
    public final void zzd(String str, Map map, int i) {
        synchronized (this.zzj) {
            if (i == 3) {
                this.zzm = true;
            }
            if (this.zze.containsKey(str)) {
                if (i == 3) {
                    ((zzgzq) this.zze.get(str)).zze(4);
                }
                return;
            }
            zzgzq zzgzqVarZzc = zzgzr.zzc();
            int iZza = zzgzp.zza(i);
            if (iZza != 0) {
                zzgzqVarZzc.zze(iZza);
            }
            zzgzqVarZzc.zzb(this.zze.size());
            zzgzqVarZzc.zzd(str);
            zzgyq zzgyqVarZza = zzgyt.zza();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzgyo zzgyoVarZza = zzgyp.zza();
                        zzgyoVarZza.zza(zzgsr.zzw(str2));
                        zzgyoVarZza.zzb(zzgsr.zzw(str3));
                        zzgyqVarZza.zza((zzgyp) zzgyoVarZza.zzal());
                    }
                }
            }
            zzgzqVarZzc.zzc((zzgyt) zzgyqVarZza.zzal());
            this.zze.put(str, zzgzqVarZzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxu
    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            ListenableFuture listenableFutureZzn = zzfzt.zzn(zzfzt.zzh(Collections.emptyMap()), new zzfza() { // from class: com.google.android.gms.internal.ads.zzbxk
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzb((Map) obj);
                }
            }, zzcbg.zzf);
            ListenableFuture listenableFutureZzo = zzfzt.zzo(listenableFutureZzn, 10L, TimeUnit.SECONDS, zzcbg.zzd);
            zzfzt.zzr(listenableFutureZzn, new zzbxo(this, listenableFutureZzo), zzcbg.zzf);
            zzc.add(listenableFutureZzo);
        }
    }

    final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgso zzgsoVarZzt = zzgsr.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzgsoVarZzt);
        synchronized (this.zzj) {
            zzgyd zzgydVar = this.zzd;
            zzgzj zzgzjVarZza = zzgzl.zza();
            zzgzjVarZza.zza(zzgsoVarZzt.zzb());
            zzgzjVarZza.zzb("image/png");
            zzgzjVarZza.zzc(2);
            zzgydVar.zzi((zzgzl) zzgzjVarZza.zzal());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxu
    public final void zzg(View view) {
        Bitmap bitmapCreateBitmap;
        if (this.zzi.zzc && !this.zzl) {
            com.google.android.gms.ads.internal.zzt.zzp();
            final Bitmap bitmap = null;
            if (view != null) {
                try {
                    boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                    try {
                        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
                    } catch (RuntimeException e) {
                        e = e;
                        zzcat.zzh("Fail to capture the web view", e);
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    bitmapCreateBitmap = null;
                }
                if (bitmapCreateBitmap == null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width == 0 || height == 0) {
                            zzcat.zzj("Width or height of view is zero");
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(bitmapCreateBitmap2);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap = bitmapCreateBitmap2;
                        }
                    } catch (RuntimeException e3) {
                        zzcat.zzh("Fail to capture the webview", e3);
                    }
                } else {
                    bitmap = bitmapCreateBitmap;
                }
            }
            if (bitmap == null) {
                zzbxt.zza("Failed to capture the webview bitmap.");
                return;
            }
            this.zzl = true;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf(bitmap);
                }
            };
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                runnable.run();
            } else {
                zzcbg.zza.execute(runnable);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxu
    public final void zzh(String str) {
        synchronized (this.zzj) {
            try {
                if (str == null) {
                    this.zzd.zzd();
                } else {
                    this.zzd.zze(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxu
    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
