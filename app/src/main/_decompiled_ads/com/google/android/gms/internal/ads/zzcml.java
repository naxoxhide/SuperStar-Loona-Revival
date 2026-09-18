package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcml extends com.google.android.gms.ads.internal.client.zzcn {
    private final Context zza;
    private final zzcaz zzb;
    private final zzdqj zzc;
    private final zzeew zzd;
    private final zzelg zze;
    private final zzdur zzf;
    private final zzbyy zzg;
    private final zzdqo zzh;
    private final zzdvm zzi;
    private final zzbev zzj;
    private final zzfjh zzk;
    private final zzfeh zzl;
    private final zzbcj zzm;
    private boolean zzn = false;

    zzcml(Context context, zzcaz zzcazVar, zzdqj zzdqjVar, zzeew zzeewVar, zzelg zzelgVar, zzdur zzdurVar, zzbyy zzbyyVar, zzdqo zzdqoVar, zzdvm zzdvmVar, zzbev zzbevVar, zzfjh zzfjhVar, zzfeh zzfehVar, zzbcj zzbcjVar) {
        this.zza = context;
        this.zzb = zzcazVar;
        this.zzc = zzdqjVar;
        this.zzd = zzeewVar;
        this.zze = zzelgVar;
        this.zzf = zzdurVar;
        this.zzg = zzbyyVar;
        this.zzh = zzdqoVar;
        this.zzi = zzdvmVar;
        this.zzj = zzbevVar;
        this.zzk = zzfjhVar;
        this.zzl = zzfehVar;
        this.zzm = zzbcjVar;
    }

    final void zzb() {
        if (com.google.android.gms.ads.internal.zzt.zzo().zzh().zzP()) {
            String strZzl = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzl();
            if (com.google.android.gms.ads.internal.zzt.zzs().zzj(this.zza, strZzl, this.zzb.zza)) {
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzo().zzh().zzB(false);
            com.google.android.gms.ads.internal.zzt.zzo().zzh().zzA("");
        }
    }

    final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map mapZze = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zze();
        if (mapZze.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzcat.zzk("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzc.zzd()) {
            HashMap map = new HashMap();
            Iterator it = mapZze.values().iterator();
            while (it.hasNext()) {
                for (zzbor zzborVar : ((zzbos) it.next()).zza) {
                    String str = zzborVar.zzk;
                    for (String str2 : zzborVar.zzc) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzeex zzeexVarZza = this.zzd.zza(str3, jSONObject);
                    if (zzeexVarZza != null) {
                        zzfej zzfejVar = (zzfej) zzeexVarZza.zzb;
                        if (!zzfejVar.zzC() && zzfejVar.zzB()) {
                            zzfejVar.zzj(this.zza, (zzegr) zzeexVarZza.zzc, (List) entry.getValue());
                            zzcat.zze("Initialized rewarded video mediation adapter " + str3);
                        }
                    }
                } catch (zzfds e) {
                    zzcat.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                }
            }
        }
    }

    final /* synthetic */ void zzd() {
        zzfer.zzb(this.zza, true);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized float zze() {
        return com.google.android.gms.ads.internal.zzt.zzr().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final String zzf() {
        return this.zzb.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzi() {
        this.zzf.zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzk() {
        if (this.zzn) {
            zzcat.zzj("Mobile ads is initialized already.");
            return;
        }
        zzbci.zza(this.zza);
        this.zzm.zza();
        com.google.android.gms.ads.internal.zzt.zzo().zzs(this.zza, this.zzb);
        com.google.android.gms.ads.internal.zzt.zzc().zzi(this.zza);
        this.zzn = true;
        this.zzf.zzr();
        this.zze.zze();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdP)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzg();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zziU)).booleanValue()) {
            zzcbg.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjZ)).booleanValue()) {
            zzcbg.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmi
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcD)).booleanValue()) {
            zzcbg.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
        String strZzp;
        Runnable runnable;
        zzbci.zza(this.zza);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdT)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            strZzp = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
        } else {
            strZzp = "";
        }
        boolean z = true;
        String str2 = true == TextUtils.isEmpty(strZzp) ? str : strZzp;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdN)).booleanValue() | ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaP)).booleanValue();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaP)).booleanValue()) {
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmj
                @Override // java.lang.Runnable
                public final void run() {
                    zzgad zzgadVar = zzcbg.zze;
                    final zzcml zzcmlVar = this.zza;
                    final Runnable runnable3 = runnable2;
                    zzgadVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmk
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcmlVar.zzc(runnable3);
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z = zBooleanValue;
        }
        Runnable runnable3 = runnable;
        if (z) {
            com.google.android.gms.ads.internal.zzt.zza().zza(this.zza, this.zzb, str2, runnable3, this.zzk);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzm(com.google.android.gms.ads.internal.client.zzda zzdaVar) throws RemoteException {
        this.zzi.zzh(zzdaVar, zzdvl.API);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzcat.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzcat.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
        zzauVar.zzn(str);
        zzauVar.zzo(this.zzb.zza);
        zzauVar.zzr();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzo(zzbox zzboxVar) throws RemoteException {
        this.zzl.zzf(zzboxVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzp(boolean z) {
        com.google.android.gms.ads.internal.zzt.zzr().zzc(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzq(float f) {
        com.google.android.gms.ads.internal.zzt.zzr().zzd(f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzr(String str) {
        zzbci.zza(this.zza);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzdN)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zza().zza(this.zza, this.zzb, str, null, this.zzk);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzs(zzbln zzblnVar) throws RemoteException {
        this.zzf.zzs(zzblnVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjf)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(str);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzu(com.google.android.gms.ads.internal.client.zzff zzffVar) throws RemoteException {
        this.zzg.zzq(this.zza, zzffVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized boolean zzv() {
        return com.google.android.gms.ads.internal.zzt.zzr().zze();
    }

    final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbud());
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzj(boolean z) throws RemoteException {
        try {
            zzfpx.zzi(this.zza).zzn(z);
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }
    }
}
