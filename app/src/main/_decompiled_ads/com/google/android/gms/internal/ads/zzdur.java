package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdur {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdqj zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdsy zzl;
    private final zzcaz zzm;
    private final zzdeg zzo;
    private final zzfjh zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzcbl zze = new zzcbl();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();

    public zzdur(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdqj zzdqjVar, ScheduledExecutorService scheduledExecutorService, zzdsy zzdsyVar, zzcaz zzcazVar, zzdeg zzdegVar, zzfjh zzfjhVar) {
        this.zzh = zzdqjVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdsyVar;
        this.zzm = zzcazVar;
        this.zzo = zzdegVar;
        this.zzp = zzfjhVar;
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* bridge */ /* synthetic */ void zzj(final zzdur zzdurVar, String str) {
        int i = 5;
        final zzfit zzfitVarZza = zzfis.zza(zzdurVar.zzf, 5);
        zzfitVarZza.zzh();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final zzfit zzfitVarZza2 = zzfis.zza(zzdurVar.zzf, i);
                zzfitVarZza2.zzh();
                zzfitVarZza2.zzd(next);
                final Object obj = new Object();
                final zzcbl zzcblVar = new zzcbl();
                ListenableFuture listenableFutureZzo = zzfzt.zzo(zzcblVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbM)).longValue(), TimeUnit.SECONDS, zzdurVar.zzk);
                zzdurVar.zzl.zzc(next);
                zzdurVar.zzo.zzc(next);
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                listenableFutureZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdui
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzq(obj, zzcblVar, next, jElapsedRealtime, zzfitVarZza2);
                    }
                }, zzdurVar.zzi);
                arrayList.add(listenableFutureZzo);
                final zzduq zzduqVar = new zzduq(zzdurVar, obj, next, jElapsedRealtime, zzfitVarZza2, zzcblVar);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (jSONObjectOptJSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String strOptString = jSONObject2.optString("format", "");
                            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzblq(strOptString, bundle));
                            i2++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdurVar.zzv(next, false, "", 0);
                try {
                    try {
                        final zzfej zzfejVarZzc = zzdurVar.zzh.zzc(next, new JSONObject());
                        zzdurVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdum
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzn(next, zzduqVar, zzfejVarZzc, arrayList2);
                            }
                        });
                    } catch (zzfds unused2) {
                        zzduqVar.zze("Failed to create Adapter.");
                    }
                } catch (RemoteException e) {
                    zzcat.zzh("", e);
                }
                i = 5;
            }
            zzfzt.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzduj
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.zza.zzf(zzfitVarZza);
                    return null;
                }
            }, zzdurVar.zzi);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e2);
            zzdurVar.zzo.zza("MalformedJson");
            zzdurVar.zzl.zza("MalformedJson");
            zzdurVar.zze.zzd(e2);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e2, "AdapterInitializer.updateAdapterStatus");
            zzfjh zzfjhVar = zzdurVar.zzp;
            zzfitVarZza.zzg(e2);
            zzfitVarZza.zzf(false);
            zzfjhVar.zzb(zzfitVarZza.zzl());
        }
    }

    private final synchronized ListenableFuture zzu() {
        String strZzc = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzc();
        if (!TextUtils.isEmpty(strZzc)) {
            return zzfzt.zzh(strZzc);
        }
        final zzcbl zzcblVar = new zzcbl();
        com.google.android.gms.ads.internal.zzt.zzo().zzh().zzq(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo(zzcblVar);
            }
        });
        return zzcblVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzblg(str, z, i, str2));
    }

    final /* synthetic */ Object zzf(zzfit zzfitVar) throws Exception {
        this.zze.zzc(true);
        zzfitVar.zzf(true);
        this.zzp.zzb(zzfitVar.zzl());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzblg zzblgVar = (zzblg) this.zzn.get(str);
            arrayList.add(new zzblg(str, zzblgVar.zzb, zzblgVar.zzc, zzblgVar.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    final /* synthetic */ void zzm() {
        synchronized (this) {
            if (this.zzc) {
                return;
            }
            zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzd));
            this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zze.zzd(new Exception());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
    
        if (r2.equals("com.google.ads.mediation.admob.AdMobAdapter") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zzn(java.lang.String r2, com.google.android.gms.internal.ads.zzblk r3, com.google.android.gms.internal.ads.zzfej r4, java.util.List r5) {
        /*
            r1 = this;
            java.lang.String r0 = "com.google.ads.mediation.admob.AdMobAdapter"
            if (r2 == r0) goto L1d
            if (r2 == 0) goto Lc
            boolean r0 = r2.equals(r0)     // Catch: android.os.RemoteException -> L21 com.google.android.gms.internal.ads.zzfds -> L28
            if (r0 != 0) goto L1d
        Lc:
            java.lang.ref.WeakReference r0 = r1.zzg     // Catch: android.os.RemoteException -> L21 com.google.android.gms.internal.ads.zzfds -> L28
            java.lang.Object r0 = r0.get()     // Catch: android.os.RemoteException -> L21 com.google.android.gms.internal.ads.zzfds -> L28
            android.content.Context r0 = (android.content.Context) r0     // Catch: android.os.RemoteException -> L21 com.google.android.gms.internal.ads.zzfds -> L28
            if (r0 == 0) goto L17
            goto L19
        L17:
            android.content.Context r0 = r1.zzf     // Catch: android.os.RemoteException -> L21 com.google.android.gms.internal.ads.zzfds -> L28
        L19:
            r4.zzi(r0, r3, r5)     // Catch: android.os.RemoteException -> L21 com.google.android.gms.internal.ads.zzfds -> L28
            return
        L1d:
            r3.zzf()     // Catch: android.os.RemoteException -> L21 com.google.android.gms.internal.ads.zzfds -> L28
            return
        L21:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzftr r3 = new com.google.android.gms.internal.ads.zzftr
            r3.<init>(r2)
            throw r3
        L28:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: android.os.RemoteException -> L42
            r4.<init>()     // Catch: android.os.RemoteException -> L42
            java.lang.String r5 = "Failed to initialize adapter. "
            r4.append(r5)     // Catch: android.os.RemoteException -> L42
            r4.append(r2)     // Catch: android.os.RemoteException -> L42
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch: android.os.RemoteException -> L42
            java.lang.String r2 = r4.toString()     // Catch: android.os.RemoteException -> L42
            r3.zze(r2)     // Catch: android.os.RemoteException -> L42
            return
        L42:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzcat.zzh(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdur.zzn(java.lang.String, com.google.android.gms.internal.ads.zzblk, com.google.android.gms.internal.ads.zzfej, java.util.List):void");
    }

    final /* synthetic */ void zzo(final zzcbl zzcblVar) {
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduh
            @Override // java.lang.Runnable
            public final void run() {
                String strZzc = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzc();
                boolean zIsEmpty = TextUtils.isEmpty(strZzc);
                zzcbl zzcblVar2 = zzcblVar;
                if (zIsEmpty) {
                    zzcblVar2.zzd(new Exception());
                } else {
                    zzcblVar2.zzc(strZzc);
                }
            }
        });
    }

    final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    final /* synthetic */ void zzq(Object obj, zzcbl zzcblVar, String str, long j, zzfit zzfitVar) {
        synchronized (obj) {
            if (!zzcblVar.isDone()) {
                zzv(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfjh zzfjhVar = this.zzp;
                zzfitVar.zzc("Timeout");
                zzfitVar.zzf(false);
                zzfjhVar.zzb(zzfitVar.zzl());
                zzcblVar.zzc(false);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbeh.zza.zze()).booleanValue()) {
            if (this.zzm.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbL)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    if (this.zza) {
                        return;
                    }
                    this.zzl.zzf();
                    this.zzo.zzf();
                    this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdun
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzp();
                        }
                    }, this.zzi);
                    this.zza = true;
                    ListenableFuture listenableFutureZzu = zzu();
                    this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdug
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzm();
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbN)).longValue(), TimeUnit.SECONDS);
                    zzfzt.zzr(listenableFutureZzu, new zzdup(this), this.zzi);
                    return;
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(false);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzbln zzblnVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdul
            @Override // java.lang.Runnable
            public final void run() {
                zzdur zzdurVar = this.zza;
                try {
                    zzblnVar.zzb(zzdurVar.zzg());
                } catch (RemoteException e) {
                    zzcat.zzh("", e);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
