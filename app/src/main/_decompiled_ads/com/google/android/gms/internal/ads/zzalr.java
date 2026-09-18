package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalr implements Runnable {
    final /* synthetic */ zzamg zza;
    final /* synthetic */ zzals zzb;

    zzalr(zzals zzalsVar, zzamg zzamgVar) {
        this.zzb = zzalsVar;
        this.zza = zzamgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
