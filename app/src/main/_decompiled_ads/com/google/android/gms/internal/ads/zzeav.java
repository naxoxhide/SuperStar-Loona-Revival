package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeav extends zzbur {
    private final Context zza;
    private final zzgad zzb;
    private final zzebn zzc;
    private final zzcni zzd;
    private final ArrayDeque zze;
    private final zzfjh zzf;
    private final zzbvs zzg;
    private final zzebk zzh;

    public zzeav(Context context, zzgad zzgadVar, zzbvs zzbvsVar, zzcni zzcniVar, zzebn zzebnVar, ArrayDeque arrayDeque, zzebk zzebkVar, zzfjh zzfjhVar) {
        zzbci.zza(context);
        this.zza = context;
        this.zzb = zzgadVar;
        this.zzg = zzbvsVar;
        this.zzc = zzebnVar;
        this.zzd = zzcniVar;
        this.zze = arrayDeque;
        this.zzh = zzebkVar;
        this.zzf = zzfjhVar;
    }

    private final synchronized zzeas zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzeas zzeasVar = (zzeas) it.next();
            if (zzeasVar.zzc.equals(str)) {
                it.remove();
                return zzeasVar;
            }
        }
        return null;
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, zzfhr zzfhrVar, zzboa zzboaVar, zzfje zzfjeVar, zzfit zzfitVar) {
        zzbnq zzbnqVarZza = zzboaVar.zza("AFMA_getAdDictionary", zzbnx.zza, new zzbns() { // from class: com.google.android.gms.internal.ads.zzeao
            @Override // com.google.android.gms.internal.ads.zzbns
            public final Object zza(JSONObject jSONObject) {
                return new zzbvj(jSONObject);
            }
        });
        zzfjd.zzd(listenableFuture, zzfitVar);
        zzfgw zzfgwVarZza = zzfhrVar.zzb(zzfhl.BUILD_URL, listenableFuture).zzf(zzbnqVarZza).zza();
        zzfjd.zzc(zzfgwVarZza, zzfjeVar, zzfitVar);
        return zzfgwVarZza;
    }

    private static ListenableFuture zzm(zzbvg zzbvgVar, zzfhr zzfhrVar, final zzeuu zzeuuVar) {
        zzfza zzfzaVar = new zzfza() { // from class: com.google.android.gms.internal.ads.zzeai
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzeuuVar.zzb().zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        };
        return zzfhrVar.zzb(zzfhl.GMS_SIGNALS, zzfzt.zzh(zzbvgVar.zza)).zzf(zzfzaVar).zze(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzeaj
            @Override // com.google.android.gms.internal.ads.zzfgu
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzn(zzeas zzeasVar) {
        zzo();
        this.zze.addLast(zzeasVar);
    }

    private final synchronized void zzo() {
        int iIntValue = ((Long) zzbei.zzc.zze()).intValue();
        while (this.zze.size() >= iIntValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(ListenableFuture listenableFuture, zzbvc zzbvcVar) {
        zzfzt.zzr(zzfzt.zzn(listenableFuture, new zzfza() { // from class: com.google.android.gms.internal.ads.zzeag
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(zzfen.zza((InputStream) obj));
            }
        }, zzcbg.zza), new zzear(this, zzbvcVar), zzcbg.zzf);
    }

    public final ListenableFuture zzb(final zzbvg zzbvgVar, int i) {
        if (!((Boolean) zzbei.zza.zze()).booleanValue()) {
            return zzfzt.zzg(new Exception("Split request is disabled."));
        }
        zzffh zzffhVar = zzbvgVar.zzi;
        if (zzffhVar == null) {
            return zzfzt.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzffhVar.zzc == 0 || zzffhVar.zzd == 0) {
            return zzfzt.zzg(new Exception("Caching is disabled."));
        }
        zzboa zzboaVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcaz.zza(), this.zzf);
        zzeuu zzeuuVarZzq = this.zzd.zzq(zzbvgVar, i);
        zzfhr zzfhrVarZzc = zzeuuVarZzq.zzc();
        final ListenableFuture listenableFutureZzm = zzm(zzbvgVar, zzfhrVarZzc, zzeuuVarZzq);
        zzfje zzfjeVarZzd = zzeuuVarZzq.zzd();
        final zzfit zzfitVarZza = zzfis.zza(this.zza, 9);
        final ListenableFuture listenableFutureZzl = zzl(listenableFutureZzm, zzfhrVarZzc, zzboaVarZzb, zzfjeVarZzd, zzfitVarZza);
        return zzfhrVarZzc.zza(zzfhl.GET_URL_AND_CACHE_KEY, listenableFutureZzm, listenableFutureZzl).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeam
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzj(listenableFutureZzl, listenableFutureZzm, zzbvgVar, zzfitVarZza);
            }
        }).zza();
    }

    public final ListenableFuture zzc(zzbvg zzbvgVar, int i) {
        zzfgw zzfgwVarZza;
        zzboa zzboaVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcaz.zza(), this.zzf);
        zzeuu zzeuuVarZzq = this.zzd.zzq(zzbvgVar, i);
        zzbnq zzbnqVarZza = zzboaVarZzb.zza("google.afma.response.normalize", zzeau.zza, zzbnx.zzb);
        zzeas zzeasVarZzk = null;
        if (((Boolean) zzbei.zza.zze()).booleanValue()) {
            zzeasVarZzk = zzk(zzbvgVar.zzh);
            if (zzeasVarZzk == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbvgVar.zzj;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzfit zzfitVarZza = zzeasVarZzk == null ? zzfis.zza(this.zza, 9) : zzeasVarZzk.zze;
        zzfje zzfjeVarZzd = zzeuuVarZzq.zzd();
        zzfjeVarZzd.zzd(zzbvgVar.zza.getStringArrayList("ad_types"));
        zzebm zzebmVar = new zzebm(zzbvgVar.zzg, zzfjeVarZzd, zzfitVarZza);
        zzebj zzebjVar = new zzebj(this.zza, zzbvgVar.zzb.zza, this.zzg, i);
        zzfhr zzfhrVarZzc = zzeuuVarZzq.zzc();
        zzfit zzfitVarZza2 = zzfis.zza(this.zza, 11);
        if (zzeasVarZzk == null) {
            final ListenableFuture listenableFutureZzm = zzm(zzbvgVar, zzfhrVarZzc, zzeuuVarZzq);
            final ListenableFuture listenableFutureZzl = zzl(listenableFutureZzm, zzfhrVarZzc, zzboaVarZzb, zzfjeVarZzd, zzfitVarZza);
            zzfit zzfitVarZza3 = zzfis.zza(this.zza, 10);
            final zzfgw zzfgwVarZza2 = zzfhrVarZzc.zza(zzfhl.HTTP, listenableFutureZzl, listenableFutureZzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeak
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzebl((JSONObject) listenableFutureZzm.get(), (zzbvj) listenableFutureZzl.get());
                }
            }).zze(zzebmVar).zze(new zzfiz(zzfitVarZza3)).zze(zzebjVar).zza();
            zzfjd.zza(zzfgwVarZza2, zzfjeVarZzd, zzfitVarZza3);
            zzfjd.zzd(zzfgwVarZza2, zzfitVarZza2);
            zzfgwVarZza = zzfhrVarZzc.zza(zzfhl.PRE_PROCESS, listenableFutureZzm, listenableFutureZzl, zzfgwVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeal
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzeau((zzebi) zzfgwVarZza2.get(), (JSONObject) listenableFutureZzm.get(), (zzbvj) listenableFutureZzl.get());
                }
            }).zzf(zzbnqVarZza).zza();
        } else {
            zzebl zzeblVar = new zzebl(zzeasVarZzk.zzb, zzeasVarZzk.zza);
            zzfit zzfitVarZza4 = zzfis.zza(this.zza, 10);
            final zzfgw zzfgwVarZza3 = zzfhrVarZzc.zzb(zzfhl.HTTP, zzfzt.zzh(zzeblVar)).zze(zzebmVar).zze(new zzfiz(zzfitVarZza4)).zze(zzebjVar).zza();
            zzfjd.zza(zzfgwVarZza3, zzfjeVarZzd, zzfitVarZza4);
            final ListenableFuture listenableFutureZzh = zzfzt.zzh(zzeasVarZzk);
            zzfjd.zzd(zzfgwVarZza3, zzfitVarZza2);
            zzfgwVarZza = zzfhrVarZzc.zza(zzfhl.PRE_PROCESS, zzfgwVarZza3, listenableFutureZzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeah
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzebi zzebiVar = (zzebi) zzfgwVarZza3.get();
                    ListenableFuture listenableFuture = listenableFutureZzh;
                    return new zzeau(zzebiVar, ((zzeas) listenableFuture.get()).zzb, ((zzeas) listenableFuture.get()).zza);
                }
            }).zzf(zzbnqVarZza).zza();
        }
        zzfjd.zza(zzfgwVarZza, zzfjeVarZzd, zzfitVarZza2);
        return zzfgwVarZza;
    }

    public final ListenableFuture zzd(zzbvg zzbvgVar, int i) {
        zzboa zzboaVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcaz.zza(), this.zzf);
        if (!((Boolean) zzben.zza.zze()).booleanValue()) {
            return zzfzt.zzg(new Exception("Signal collection disabled."));
        }
        zzeuu zzeuuVarZzq = this.zzd.zzq(zzbvgVar, i);
        final zzetz zzetzVarZza = zzeuuVarZzq.zza();
        zzbnq zzbnqVarZza = zzboaVarZzb.zza("google.afma.request.getSignals", zzbnx.zza, zzbnx.zzb);
        zzfit zzfitVarZza = zzfis.zza(this.zza, 22);
        zzfgw zzfgwVarZza = zzeuuVarZzq.zzc().zzb(zzfhl.GET_SIGNALS, zzfzt.zzh(zzbvgVar.zza)).zze(new zzfiz(zzfitVarZza)).zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzeap
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) throws JSONException {
                return zzetzVarZza.zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        }).zzb(zzfhl.JS_SIGNALS).zzf(zzbnqVarZza).zza();
        zzfje zzfjeVarZzd = zzeuuVarZzq.zzd();
        zzfjeVarZzd.zzd(zzbvgVar.zza.getStringArrayList("ad_types"));
        zzfjd.zzb(zzfgwVarZza, zzfjeVarZzd, zzfitVarZza);
        if (((Boolean) zzbeb.zze.zze()).booleanValue()) {
            zzebn zzebnVar = this.zzc;
            zzebnVar.getClass();
            zzfgwVarZza.addListener(new zzean(zzebnVar), this.zzb);
        }
        return zzfgwVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zze(zzbvg zzbvgVar, zzbvc zzbvcVar) {
        zzp(zzb(zzbvgVar, Binder.getCallingUid()), zzbvcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzf(zzbvg zzbvgVar, zzbvc zzbvcVar) {
        zzp(zzd(zzbvgVar, Binder.getCallingUid()), zzbvcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzg(zzbvg zzbvgVar, zzbvc zzbvcVar) {
        ListenableFuture listenableFutureZzc = zzc(zzbvgVar, Binder.getCallingUid());
        zzp(listenableFutureZzc, zzbvcVar);
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            zzebn zzebnVar = this.zzc;
            zzebnVar.getClass();
            listenableFutureZzc.addListener(new zzean(zzebnVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzh(String str, zzbvc zzbvcVar) {
        zzp(zzi(str), zzbvcVar);
    }

    public final ListenableFuture zzi(String str) {
        if (((Boolean) zzbei.zza.zze()).booleanValue()) {
            return zzk(str) == null ? zzfzt.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzfzt.zzh(new zzeaq(this));
        }
        return zzfzt.zzg(new Exception("Split request is disabled."));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream zzj(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbvg zzbvgVar, zzfit zzfitVar) throws Exception {
        String strZzc = ((zzbvj) listenableFuture.get()).zzc();
        zzn(new zzeas((zzbvj) listenableFuture.get(), (JSONObject) listenableFuture2.get(), zzbvgVar.zzh, strZzc, zzfitVar));
        return new ByteArrayInputStream(strZzc.getBytes(zzfsi.zzc));
    }
}
