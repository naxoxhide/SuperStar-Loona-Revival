package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbyz {
    static zzbyz zza;

    public static synchronized zzbyz zzd(Context context) {
        zzbyz zzbyzVar = zza;
        if (zzbyzVar != null) {
            return zzbyzVar;
        }
        Context applicationContext = context.getApplicationContext();
        zzbci.zza(applicationContext);
        com.google.android.gms.ads.internal.util.zzg zzgVarZzh = com.google.android.gms.ads.internal.zzt.zzo().zzh();
        zzgVarZzh.zzr(applicationContext);
        zzbyd zzbydVar = new zzbyd(null);
        zzbydVar.zzb(applicationContext);
        zzbydVar.zzc(com.google.android.gms.ads.internal.zzt.zzB());
        zzbydVar.zza(zzgVarZzh);
        zzbydVar.zzd(com.google.android.gms.ads.internal.zzt.zzn());
        zzbyz zzbyzVarZze = zzbydVar.zze();
        zza = zzbyzVarZze;
        zzbyzVarZze.zza().zza();
        zza.zzb().zzc();
        zzbzd zzbzdVarZzc = zza.zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzaq)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            Map mapZzu = com.google.android.gms.ads.internal.util.zzt.zzu((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzas));
            Iterator it = mapZzu.keySet().iterator();
            while (it.hasNext()) {
                zzbzdVarZzc.zzc((String) it.next());
            }
            zzbzdVarZzc.zzd(new zzbzb(zzbzdVarZzc, mapZzu));
        }
        return zza;
    }

    abstract zzbxw zza();

    abstract zzbya zzb();

    abstract zzbzd zzc();
}
