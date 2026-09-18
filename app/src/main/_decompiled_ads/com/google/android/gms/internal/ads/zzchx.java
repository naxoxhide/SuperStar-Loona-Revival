package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzchx {
    private zzcaz zza;
    private Context zzb;
    private WeakReference zzc;

    public final zzchx zzc(Context context) {
        this.zzc = new WeakReference(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }

    public final zzchx zzd(zzcaz zzcazVar) {
        this.zza = zzcazVar;
        return this;
    }
}
