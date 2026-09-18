package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzasx implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzasy zza;

    zzasx(zzasy zzasyVar) {
        this.zza = zzasyVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzasy zzasyVar = this.zza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zzasyVar.zzc > 0) {
            zzasy zzasyVar2 = this.zza;
            if (jCurrentTimeMillis >= zzasyVar2.zzc) {
                zzasyVar2.zzd = jCurrentTimeMillis - zzasyVar2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
