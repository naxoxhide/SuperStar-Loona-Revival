package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesx implements zzetw {
    final String zza;
    private final zzgad zzb;
    private final ScheduledExecutorService zzc;
    private final zzelg zzd;
    private final Context zze;
    private final zzfdn zzf;
    private final zzelc zzg;
    private final zzdqj zzh;
    private final zzdut zzi;

    zzesx(zzgad zzgadVar, ScheduledExecutorService scheduledExecutorService, String str, zzelg zzelgVar, Context context, zzfdn zzfdnVar, zzelc zzelcVar, zzdqj zzdqjVar, zzdut zzdutVar) {
        this.zzb = zzgadVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzelgVar;
        this.zze = context;
        this.zzf = zzfdnVar;
        this.zzg = zzelcVar;
        this.zzh = zzdqjVar;
        this.zzi = zzdutVar;
    }

    public static /* synthetic */ ListenableFuture zzc(zzesx zzesxVar) {
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjX)).booleanValue() ? zzesxVar.zzf.zzf.toLowerCase(Locale.ROOT) : zzesxVar.zzf.zzf;
        final Bundle bundleZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbB)).booleanValue() ? zzesxVar.zzi.zzg() : new Bundle();
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbK)).booleanValue()) {
            zzesxVar.zzi(arrayList, zzesxVar.zzd.zza(zzesxVar.zza, lowerCase));
        } else {
            for (Map.Entry entry : ((zzfvv) zzesxVar.zzd.zzb(zzesxVar.zza, lowerCase)).entrySet()) {
                String str = (String) entry.getKey();
                arrayList.add(zzesxVar.zzg(str, (List) entry.getValue(), zzesxVar.zzf(str), true, true));
            }
            zzesxVar.zzi(arrayList, zzesxVar.zzd.zzc());
        }
        return zzfzt.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzess
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                JSONArray jSONArray = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray.put(listenableFuture.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzesy(jSONArray.toString(), bundleZzg);
            }
        }, zzesxVar.zzb);
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzfzk zzg(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzfzk zzfzkVarZzu = zzfzk.zzu(zzfzt.zzk(new zzfyz() { // from class: com.google.android.gms.internal.ads.zzesu
            @Override // com.google.android.gms.internal.ads.zzfyz
            public final ListenableFuture zza() {
                return this.zza.zzd(str, list, bundle, z, z2);
            }
        }, this.zzb));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbx)).booleanValue()) {
            zzfzkVarZzu = (zzfzk) zzfzt.zzo(zzfzkVarZzu, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbq)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzfzk) zzfzt.zze(zzfzkVarZzu, Throwable.class, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzesv
            @Override // com.google.android.gms.internal.ads.zzfsk
            public final Object apply(Object obj) {
                zzcat.zzg("Error calling adapter: ".concat(String.valueOf(str)));
                return null;
            }
        }, this.zzb);
    }

    private final void zzh(zzbqv zzbqvVar, Bundle bundle, List list, zzelj zzeljVar) throws RemoteException {
        zzbqvVar.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzeljVar);
    }

    private final void zzi(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzelk zzelkVar = (zzelk) ((Map.Entry) it.next()).getValue();
            String str = zzelkVar.zza;
            list.add(zzg(str, Collections.singletonList(zzelkVar.zze), zzf(str), zzelkVar.zzb, zzelkVar.zzc));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        zzfdn zzfdnVar = this.zzf;
        if (zzfdnVar.zzq) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbD)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zza(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(zzfdnVar.zzd)))) {
                return zzfzt.zzh(new zzesy(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzfzt.zzk(new zzfyz() { // from class: com.google.android.gms.internal.ads.zzesr
            @Override // com.google.android.gms.internal.ads.zzfyz
            public final ListenableFuture zza() {
                return zzesx.zzc(this.zza);
            }
        }, this.zzb);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final /* synthetic */ ListenableFuture zzd(String str, final List list, final Bundle bundle, boolean z, boolean z2) throws Exception {
        zzbqv zzbqvVarZzb;
        final zzcbl zzcblVar = new zzcbl();
        if (z2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbC)).booleanValue()) {
                try {
                    zzbqvVarZzb = this.zzh.zzb(str);
                } catch (RemoteException e) {
                    zzcat.zzh("Couldn't create RTB adapter : ", e);
                    zzbqvVarZzb = null;
                }
            } else {
                this.zzg.zzb(str);
                zzbqvVarZzb = this.zzg.zza(str);
            }
        } else {
            zzbqvVarZzb = this.zzh.zzb(str);
        }
        if (zzbqvVarZzb == null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbs)).booleanValue()) {
                throw null;
            }
            zzelj.zzb(str, zzcblVar);
        } else {
            final zzelj zzeljVar = new zzelj(str, zzbqvVarZzb, zzcblVar, com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbx)).booleanValue()) {
                this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzesw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeljVar.zzc();
                    }
                }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbq)).longValue(), TimeUnit.MILLISECONDS);
            }
            if (z) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbE)).booleanValue()) {
                    final zzbqv zzbqvVar = zzbqvVarZzb;
                    this.zzb.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzest
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze(zzbqvVar, bundle, list, zzeljVar, zzcblVar);
                        }
                    });
                } else {
                    zzh(zzbqvVarZzb, bundle, list, zzeljVar);
                }
            } else {
                zzeljVar.zzd();
            }
        }
        return zzcblVar;
    }

    final /* synthetic */ void zze(zzbqv zzbqvVar, Bundle bundle, List list, zzelj zzeljVar, zzcbl zzcblVar) {
        try {
            zzh(zzbqvVar, bundle, list, zzeljVar);
        } catch (RemoteException e) {
            zzcblVar.zzd(e);
        }
    }
}
