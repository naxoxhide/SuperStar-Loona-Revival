package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebf extends zzbuv {
    private final Context zza;
    private final zzevk zzb;
    private final zzevi zzc;
    private final zzebn zzd;
    private final zzgad zze;
    private final zzebk zzf;
    private final zzbvs zzg;

    zzebf(Context context, zzevk zzevkVar, zzevi zzeviVar, zzebk zzebkVar, zzebn zzebnVar, zzgad zzgadVar, zzbvs zzbvsVar) {
        this.zza = context;
        this.zzb = zzevkVar;
        this.zzc = zzeviVar;
        this.zzf = zzebkVar;
        this.zzd = zzebnVar;
        this.zze = zzgadVar;
        this.zzg = zzbvsVar;
    }

    private final void zzc(ListenableFuture listenableFuture, zzbuz zzbuzVar) {
        zzfzt.zzr(zzfzt.zzn(zzfzk.zzu(listenableFuture), new zzfza() { // from class: com.google.android.gms.internal.ads.zzebc
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(zzfen.zza((InputStream) obj));
            }
        }, zzcbg.zza), new zzebe(this, zzbuzVar), zzcbg.zzf);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00a5  */
    public final ListenableFuture zzb(zzbuo zzbuoVar, int i) {
        ListenableFuture listenableFutureZzh;
        HashMap map = new HashMap();
        Bundle bundle = zzbuoVar.zzc;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (string != null) {
                    map.put(str, string);
                }
            }
        }
        final zzebh zzebhVar = new zzebh(zzbuoVar.zza, zzbuoVar.zzb, map, zzbuoVar.zzd, "", zzbuoVar.zze);
        zzevi zzeviVar = this.zzc;
        zzeviVar.zza(new zzewp(zzbuoVar));
        boolean z = zzebhVar.zzf;
        zzevj zzevjVarZzb = zzeviVar.zzb();
        if (z) {
            String str2 = zzbuoVar.zza;
            String str3 = (String) zzbei.zzb.zze();
            if (TextUtils.isEmpty(str3)) {
                listenableFutureZzh = zzfzt.zzh(zzebhVar);
            } else {
                String host = Uri.parse(str2).getHost();
                if (TextUtils.isEmpty(host)) {
                    listenableFutureZzh = zzfzt.zzh(zzebhVar);
                } else {
                    Iterator it = zzftj.zzc(zzfsh.zzc(';')).zzd(str3).iterator();
                    while (it.hasNext()) {
                        if (host.endsWith((String) it.next())) {
                            listenableFutureZzh = zzfzt.zzm(zzevjVarZzb.zza().zza(new JSONObject()), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzeax
                                @Override // com.google.android.gms.internal.ads.zzfsk
                                public final Object apply(Object obj) {
                                    zzebh zzebhVar2 = zzebhVar;
                                    zzebn.zza(zzebhVar2.zzc, (JSONObject) obj);
                                    return zzebhVar2;
                                }
                            }, this.zze);
                        }
                    }
                    listenableFutureZzh = zzfzt.zzh(zzebhVar);
                }
            }
        } else {
            listenableFutureZzh = zzfzt.zzh(zzebhVar);
        }
        zzfhr zzfhrVarZzb = zzevjVarZzb.zzb();
        return zzfzt.zzn(zzfhrVarZzb.zzb(zzfhl.HTTP, listenableFutureZzh).zze(new zzebj(this.zza, "", this.zzg, i)).zza(), new zzfza() { // from class: com.google.android.gms.internal.ads.zzeay
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) throws JSONException {
                zzebi zzebiVar = (zzebi) obj;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("response", zzebiVar.zza);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str4 : zzebiVar.zzb.keySet()) {
                        if (str4 != null) {
                            List<String> list = (List) zzebiVar.zzb.get(str4);
                            JSONArray jSONArray = new JSONArray();
                            for (String str5 : list) {
                                if (str5 != null) {
                                    jSONArray.put(str5);
                                }
                            }
                            jSONObject2.put(str4, jSONArray);
                        }
                    }
                    jSONObject.put("headers", jSONObject2);
                    Object obj2 = zzebiVar.zzc;
                    if (obj2 != null) {
                        jSONObject.put("body", obj2);
                    }
                    jSONObject.put("latency", zzebiVar.zzd);
                    return zzfzt.zzh(new ByteArrayInputStream(jSONObject.toString().getBytes(StandardCharsets.UTF_8)));
                } catch (JSONException e) {
                    zzcat.zzj("Error converting response to JSONObject: ".concat(String.valueOf(e.getMessage())));
                    throw new JSONException("Parsing HTTP Response: ".concat(String.valueOf(String.valueOf(e.getCause()))));
                }
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzbuw
    public final void zze(zzbuo zzbuoVar, zzbuz zzbuzVar) {
        zzc(zzb(zzbuoVar, Binder.getCallingUid()), zzbuzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuw
    public final void zzf(zzbuk zzbukVar, zzbuz zzbuzVar) {
        zzeuz zzeuzVar = new zzeuz(zzbukVar, Binder.getCallingUid());
        zzevk zzevkVar = this.zzb;
        zzevkVar.zza(zzeuzVar);
        final zzevl zzevlVarZzb = zzevkVar.zzb();
        zzfhr zzfhrVarZzb = zzevlVarZzb.zzb();
        zzfgw zzfgwVarZza = zzfhrVarZzb.zzb(zzfhl.GMS_SIGNALS, zzfzt.zzi()).zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzebb
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzevlVarZzb.zza().zza(new JSONObject());
            }
        }).zze(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzeba
            @Override // com.google.android.gms.internal.ads.zzfgu
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("GMS AdRequest Signals: ");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzeaz
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(new ByteArrayInputStream(((JSONObject) obj).toString().getBytes(StandardCharsets.UTF_8)));
            }
        }).zza();
        zzc(zzfgwVarZza, zzbuzVar);
        if (((Boolean) zzbeb.zzd.zze()).booleanValue()) {
            final zzebn zzebnVar = this.zzd;
            zzebnVar.getClass();
            zzfgwVarZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebd
                @Override // java.lang.Runnable
                public final void run() {
                    zzebnVar.zzb();
                }
            }, this.zze);
        }
    }
}
