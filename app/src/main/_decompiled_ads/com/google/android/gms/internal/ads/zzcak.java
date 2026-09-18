package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcak extends Thread {
    final /* synthetic */ String zza;

    zzcak(zzcam zzcamVar, String str) {
        this.zza = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzcay(null).zza(this.zza);
    }
}
