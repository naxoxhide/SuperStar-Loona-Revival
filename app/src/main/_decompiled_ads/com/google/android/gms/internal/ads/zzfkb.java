package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkb {
    private boolean zza;

    final void zza(Context context) {
        zzfls.zzb(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzflb.zzb().zzd(context);
        zzfkt.zza().zzd(context);
        zzflm.zzb(context);
        zzfln.zzd(context);
        zzflq.zza(context);
        zzfky.zzb().zzc(context);
        zzfks.zza().zzd(context);
    }

    final boolean zzb() {
        return this.zza;
    }
}
