package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezy implements zzfai {
    private final zzfai zza;
    private zzcws zzb;

    public zzezy(zzfai zzfaiVar) {
        this.zza = zzfaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcws zzd() {
        return this.zzb;
    }

    public final synchronized ListenableFuture zzb(zzfaj zzfajVar, zzfah zzfahVar, zzcws zzcwsVar) {
        this.zzb = zzcwsVar;
        if (zzfajVar.zza == null) {
            return ((zzezx) this.zza).zzb(zzfajVar, zzfahVar, zzcwsVar);
        }
        zzcue zzcueVarZzb = this.zzb.zzb();
        return zzcueVarZzb.zzi(zzcueVarZzb.zzk(zzfzt.zzh(zzfajVar.zza)));
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfaj zzfajVar, zzfah zzfahVar, Object obj) {
        return zzb(zzfajVar, zzfahVar, null);
    }
}
