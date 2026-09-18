package com.google.android.play.core.internal;

import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.play:core@@1.10.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzav implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ com.google.android.play.core.splitinstall.zzf zzb;
    final /* synthetic */ zzaw zzc;

    zzav(zzaw zzawVar, List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        this.zzc = zzawVar;
        this.zza = list;
        this.zzb = zzfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzc.zzc.zzb(this.zza)) {
                zzaw.zzc(this.zzc, this.zzb);
            } else {
                zzaw.zzb(this.zzc, this.zza, this.zzb);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.zzb.zzb(-11);
        }
    }
}
