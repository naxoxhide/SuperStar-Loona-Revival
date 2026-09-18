package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzccp implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzccq zzb;

    zzccp(zzccq zzccqVar, boolean z) {
        this.zzb = zzccqVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
