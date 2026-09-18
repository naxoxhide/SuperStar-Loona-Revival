package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdua implements zzdto {
    private final long zza;
    private final zzems zzb;

    zzdua(long j, Context context, zzdtt zzdttVar, zzchw zzchwVar, String str) {
        this.zza = j;
        zzfaw zzfawVarZzu = zzchwVar.zzu();
        zzfawVarZzu.zzc(context);
        zzfawVarZzu.zza(new com.google.android.gms.ads.internal.client.zzq());
        zzfawVarZzu.zzb(str);
        zzems zzemsVarZza = zzfawVarZzu.zzd().zza();
        this.zzb = zzemsVarZza;
        zzemsVarZza.zzD(new zzdtz(this, zzdttVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdto
    public final void zza() {
        this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzdto
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zzb.zzaa(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdto
    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
