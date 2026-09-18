package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcca implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzccg zzc;

    zzcca(zzccg zzccgVar, String str, String str2) {
        this.zzc = zzccgVar;
        this.zza = str;
        this.zzb = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccg zzccgVar = this.zzc;
        if (zzccgVar.zzq != null) {
            zzccgVar.zzq.zzb(this.zza, this.zzb);
        }
    }
}
