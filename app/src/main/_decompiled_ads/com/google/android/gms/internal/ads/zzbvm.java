package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbvm implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvo zzb;

    zzbvm(zzbvo zzbvoVar, Context context) {
        this.zzb = zzbvoVar;
        this.zza = context;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x003a  */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbvl zzbvlVarZza;
        zzbvn zzbvnVar = (zzbvn) this.zzb.zza.get(this.zza);
        if (zzbvnVar != null) {
            if (zzbvnVar.zza + ((Long) zzbdr.zza.zze()).longValue() < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()) {
                zzbvlVarZza = new zzbvk(this.zza).zza();
            } else {
                zzbvlVarZza = new zzbvk(this.zza, zzbvnVar.zzb).zza();
            }
        } else {
            zzbvlVarZza = new zzbvk(this.zza).zza();
        }
        zzbvo zzbvoVar = this.zzb;
        zzbvoVar.zza.put(this.zza, new zzbvn(zzbvoVar, zzbvlVarZza));
        return zzbvlVarZza;
    }
}
