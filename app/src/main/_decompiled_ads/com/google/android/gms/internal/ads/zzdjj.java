package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.tapjoy.TapjoyConstants;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjj {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzdq zzb;
    private zzbfg zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzel zzg;
    private Bundle zzh;
    private zzcgb zzi;
    private zzcgb zzj;
    private zzcgb zzk;
    private zzfkc zzl;
    private ListenableFuture zzm;
    private zzcbl zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbfo zzs;
    private zzbfo zzt;
    private String zzu;
    private float zzx;
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.emptyList();

    public static zzdjj zzag(zzbpi zzbpiVar) {
        try {
            zzdji zzdjiVarZzak = zzak(zzbpiVar.zzg(), null);
            zzbfg zzbfgVarZzh = zzbpiVar.zzh();
            View view = (View) zzam(zzbpiVar.zzj());
            String strZzo = zzbpiVar.zzo();
            List listZzr = zzbpiVar.zzr();
            String strZzm = zzbpiVar.zzm();
            Bundle bundleZzf = zzbpiVar.zzf();
            String strZzn = zzbpiVar.zzn();
            View view2 = (View) zzam(zzbpiVar.zzk());
            IObjectWrapper iObjectWrapperZzl = zzbpiVar.zzl();
            String strZzq = zzbpiVar.zzq();
            String strZzp = zzbpiVar.zzp();
            double dZze = zzbpiVar.zze();
            zzbfo zzbfoVarZzi = zzbpiVar.zzi();
            zzdjj zzdjjVar = new zzdjj();
            zzdjjVar.zza = 2;
            zzdjjVar.zzb = zzdjiVarZzak;
            zzdjjVar.zzc = zzbfgVarZzh;
            zzdjjVar.zzd = view;
            zzdjjVar.zzZ("headline", strZzo);
            zzdjjVar.zze = listZzr;
            zzdjjVar.zzZ("body", strZzm);
            zzdjjVar.zzh = bundleZzf;
            zzdjjVar.zzZ("call_to_action", strZzn);
            zzdjjVar.zzo = view2;
            zzdjjVar.zzq = iObjectWrapperZzl;
            zzdjjVar.zzZ(TapjoyConstants.TJC_STORE, strZzq);
            zzdjjVar.zzZ("price", strZzp);
            zzdjjVar.zzr = dZze;
            zzdjjVar.zzs = zzbfoVarZzi;
            return zzdjjVar;
        } catch (RemoteException e) {
            zzcat.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdjj zzah(zzbpj zzbpjVar) {
        try {
            zzdji zzdjiVarZzak = zzak(zzbpjVar.zzf(), null);
            zzbfg zzbfgVarZzg = zzbpjVar.zzg();
            View view = (View) zzam(zzbpjVar.zzi());
            String strZzo = zzbpjVar.zzo();
            List listZzp = zzbpjVar.zzp();
            String strZzm = zzbpjVar.zzm();
            Bundle bundleZze = zzbpjVar.zze();
            String strZzn = zzbpjVar.zzn();
            View view2 = (View) zzam(zzbpjVar.zzj());
            IObjectWrapper iObjectWrapperZzk = zzbpjVar.zzk();
            String strZzl = zzbpjVar.zzl();
            zzbfo zzbfoVarZzh = zzbpjVar.zzh();
            zzdjj zzdjjVar = new zzdjj();
            zzdjjVar.zza = 1;
            zzdjjVar.zzb = zzdjiVarZzak;
            zzdjjVar.zzc = zzbfgVarZzg;
            zzdjjVar.zzd = view;
            zzdjjVar.zzZ("headline", strZzo);
            zzdjjVar.zze = listZzp;
            zzdjjVar.zzZ("body", strZzm);
            zzdjjVar.zzh = bundleZze;
            zzdjjVar.zzZ("call_to_action", strZzn);
            zzdjjVar.zzo = view2;
            zzdjjVar.zzq = iObjectWrapperZzk;
            zzdjjVar.zzZ("advertiser", strZzl);
            zzdjjVar.zzt = zzbfoVarZzh;
            return zzdjjVar;
        } catch (RemoteException e) {
            zzcat.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdjj zzai(zzbpi zzbpiVar) {
        try {
            return zzal(zzak(zzbpiVar.zzg(), null), zzbpiVar.zzh(), (View) zzam(zzbpiVar.zzj()), zzbpiVar.zzo(), zzbpiVar.zzr(), zzbpiVar.zzm(), zzbpiVar.zzf(), zzbpiVar.zzn(), (View) zzam(zzbpiVar.zzk()), zzbpiVar.zzl(), zzbpiVar.zzq(), zzbpiVar.zzp(), zzbpiVar.zze(), zzbpiVar.zzi(), null, 0.0f);
        } catch (RemoteException e) {
            zzcat.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdjj zzaj(zzbpj zzbpjVar) {
        try {
            return zzal(zzak(zzbpjVar.zzf(), null), zzbpjVar.zzg(), (View) zzam(zzbpjVar.zzi()), zzbpjVar.zzo(), zzbpjVar.zzp(), zzbpjVar.zzm(), zzbpjVar.zze(), zzbpjVar.zzn(), (View) zzam(zzbpjVar.zzj()), zzbpjVar.zzk(), null, null, -1.0d, zzbpjVar.zzh(), zzbpjVar.zzl(), 0.0f);
        } catch (RemoteException e) {
            zzcat.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdji zzak(com.google.android.gms.ads.internal.client.zzdq zzdqVar, zzbpm zzbpmVar) {
        if (zzdqVar == null) {
            return null;
        }
        return new zzdji(zzdqVar, zzbpmVar);
    }

    private static zzdjj zzal(com.google.android.gms.ads.internal.client.zzdq zzdqVar, zzbfg zzbfgVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbfo zzbfoVar, String str6, float f) {
        zzdjj zzdjjVar = new zzdjj();
        zzdjjVar.zza = 6;
        zzdjjVar.zzb = zzdqVar;
        zzdjjVar.zzc = zzbfgVar;
        zzdjjVar.zzd = view;
        zzdjjVar.zzZ("headline", str);
        zzdjjVar.zze = list;
        zzdjjVar.zzZ("body", str2);
        zzdjjVar.zzh = bundle;
        zzdjjVar.zzZ("call_to_action", str3);
        zzdjjVar.zzo = view2;
        zzdjjVar.zzq = iObjectWrapper;
        zzdjjVar.zzZ(TapjoyConstants.TJC_STORE, str4);
        zzdjjVar.zzZ("price", str5);
        zzdjjVar.zzr = d;
        zzdjjVar.zzs = zzbfoVar;
        zzdjjVar.zzZ("advertiser", str6);
        zzdjjVar.zzR(f);
        return zzdjjVar;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdjj zzt(zzbpm zzbpmVar) {
        try {
            return zzal(zzak(zzbpmVar.zzj(), zzbpmVar), zzbpmVar.zzk(), (View) zzam(zzbpmVar.zzm()), zzbpmVar.zzs(), zzbpmVar.zzv(), zzbpmVar.zzq(), zzbpmVar.zzi(), zzbpmVar.zzr(), (View) zzam(zzbpmVar.zzn()), zzbpmVar.zzo(), zzbpmVar.zzu(), zzbpmVar.zzt(), zzbpmVar.zze(), zzbpmVar.zzl(), zzbpmVar.zzp(), zzbpmVar.zzf());
        } catch (RemoteException e) {
            zzcat.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF("price");
    }

    public final synchronized String zzE() {
        return zzF(TapjoyConstants.TJC_STORE);
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzcgb zzcgbVar = this.zzi;
        if (zzcgbVar != null) {
            zzcgbVar.destroy();
            this.zzi = null;
        }
        zzcgb zzcgbVar2 = this.zzj;
        if (zzcgbVar2 != null) {
            zzcgbVar2.destroy();
            this.zzj = null;
        }
        zzcgb zzcgbVar3 = this.zzk;
        if (zzcgbVar3 != null) {
            zzcgbVar3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzcbl zzcblVar = this.zzn;
        if (zzcblVar != null) {
            zzcblVar.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbfg zzbfgVar) {
        this.zzc = zzbfgVar;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(com.google.android.gms.ads.internal.client.zzel zzelVar) {
        this.zzg = zzelVar;
    }

    public final synchronized void zzM(zzbfo zzbfoVar) {
        this.zzs = zzbfoVar;
    }

    public final synchronized void zzN(String str, zzbfa zzbfaVar) {
        try {
            if (zzbfaVar == null) {
                this.zzv.remove(str);
            } else {
                this.zzv.put(str, zzbfaVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzO(zzcgb zzcgbVar) {
        this.zzj = zzcgbVar;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbfo zzbfoVar) {
        this.zzt = zzbfoVar;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcgb zzcgbVar) {
        this.zzk = zzcgbVar;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzfkc zzfkcVar) {
        this.zzl = zzfkcVar;
    }

    public final synchronized void zzX(zzcbl zzcblVar) {
        this.zzn = zzcblVar;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        try {
            if (str2 == null) {
                this.zzw.remove(str);
            } else {
                this.zzw.put(str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzb = zzdqVar;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcgb zzcgbVar) {
        this.zzi = zzcgbVar;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzdq zzj() {
        return this.zzb;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbfg zzl() {
        return this.zzc;
    }

    public final zzbfo zzm() {
        List list = this.zze;
        if (list != null && !list.isEmpty()) {
            Object obj = this.zze.get(0);
            if (obj instanceof IBinder) {
                return zzbfn.zzg((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized zzbfo zzn() {
        return this.zzs;
    }

    public final synchronized zzbfo zzo() {
        return this.zzt;
    }

    public final synchronized zzcbl zzp() {
        return this.zzn;
    }

    public final synchronized zzcgb zzq() {
        return this.zzj;
    }

    public final synchronized zzcgb zzr() {
        return this.zzk;
    }

    public final synchronized zzcgb zzs() {
        return this.zzi;
    }

    public final synchronized zzfkc zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
