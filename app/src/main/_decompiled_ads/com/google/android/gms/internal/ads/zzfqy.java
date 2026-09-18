package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqy {
    private static final zzfrl zzb = new zzfrl("OverlayDisplayService");
    private static final Intent zzc = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzfrw zza;
    private final String zzd;

    zzfqy(Context context) {
        if (zzfrz.zza(context)) {
            this.zza = new zzfrw(context.getApplicationContext(), zzb, "OverlayDisplayService", zzc, zzfqt.zza, null);
        } else {
            this.zza = null;
        }
        this.zzd = context.getPackageName();
    }

    final void zzc() {
        if (this.zza == null) {
            return;
        }
        zzb.zzc("unbind LMD display overlay service", new Object[0]);
        this.zza.zzu();
    }

    final void zzd(zzfqp zzfqpVar, zzfrd zzfrdVar) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfqv(this, taskCompletionSource, zzfqpVar, zzfrdVar, taskCompletionSource), taskCompletionSource);
        }
    }

    final void zze(zzfra zzfraVar, zzfrd zzfrdVar) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        if (zzfraVar.zzg() != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfqu(this, taskCompletionSource, zzfraVar, zzfrdVar, taskCompletionSource), taskCompletionSource);
        } else {
            zzb.zza("Failed to convert OverlayDisplayShowRequest when to create a new session: appId cannot be null.", new Object[0]);
            zzfrb zzfrbVarZzc = zzfrc.zzc();
            zzfrbVarZzc.zzb(8160);
            zzfrdVar.zza(zzfrbVarZzc.zzc());
        }
    }

    final void zzf(zzfrf zzfrfVar, zzfrd zzfrdVar, int i) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfqw(this, taskCompletionSource, zzfrfVar, i, zzfrdVar, taskCompletionSource), taskCompletionSource);
        }
    }
}
