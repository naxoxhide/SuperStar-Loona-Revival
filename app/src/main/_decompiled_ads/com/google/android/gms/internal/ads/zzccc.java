package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzccc implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzccg zzc;

    zzccc(zzccg zzccgVar, int i, int i2) {
        this.zzc = zzccgVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccg zzccgVar = this.zzc;
        if (zzccgVar.zzq != null) {
            zzccgVar.zzq.zzj(this.zza, this.zzb);
        }
    }
}
