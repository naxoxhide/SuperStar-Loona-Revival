package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxr {
    public final int zza;
    public final zzlu[] zzb;
    public final zzxk[] zzc;
    public final zzdg zzd;
    public final Object zze;

    public zzxr(zzlu[] zzluVarArr, zzxk[] zzxkVarArr, zzdg zzdgVar, Object obj) {
        this.zzb = zzluVarArr;
        this.zzc = (zzxk[]) zzxkVarArr.clone();
        this.zzd = zzdgVar;
        this.zze = obj;
        this.zza = zzluVarArr.length;
    }

    public final boolean zza(zzxr zzxrVar, int i) {
        return zzxrVar != null && zzfk.zzE(this.zzb[i], zzxrVar.zzb[i]) && zzfk.zzE(this.zzc[i], zzxrVar.zzc[i]);
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}
