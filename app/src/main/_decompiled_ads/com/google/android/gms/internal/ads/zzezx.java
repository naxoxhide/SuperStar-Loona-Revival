package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezx implements zzfai {
    private zzcws zza;

    @Override // com.google.android.gms.internal.ads.zzfai
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcws zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfai
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfaj zzfajVar, zzfah zzfahVar, Object obj) {
        return zzb(zzfajVar, zzfahVar, null);
    }

    public final synchronized ListenableFuture zzb(zzfaj zzfajVar, zzfah zzfahVar, zzcws zzcwsVar) {
        zzcue zzcueVarZzb;
        try {
            if (zzcwsVar != null) {
                this.zza = zzcwsVar;
            } else {
                this.zza = (zzcws) zzfahVar.zza(zzfajVar.zzb).zzh();
            }
            zzcueVarZzb = this.zza.zzb();
        } catch (Throwable th) {
            throw th;
        }
        return zzcueVarZzb.zzi(zzcueVarZzb.zzj());
    }
}
