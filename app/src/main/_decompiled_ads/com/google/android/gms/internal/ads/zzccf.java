package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzccf implements Runnable {
    final /* synthetic */ zzccg zza;

    zzccf(zzccg zzccgVar) {
        this.zza = zzccgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccg zzccgVar = this.zza;
        if (zzccgVar.zzq != null) {
            zzccgVar.zzq.zzd();
        }
    }
}
