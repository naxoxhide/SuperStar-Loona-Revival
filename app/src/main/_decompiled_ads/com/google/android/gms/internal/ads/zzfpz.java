package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfpz extends zzfyh {
    Object zza;

    zzfpz(Object obj) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    public final String zza() {
        Object obj = this.zza;
        return obj == null ? "" : obj.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    protected final void zzb() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    public final boolean zzc(Object obj) {
        return super.zzc(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfyh
    public final boolean zzd(Throwable th) {
        return super.zzd(th);
    }
}
