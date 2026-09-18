package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfnb {
    private final Context zza;
    private final Looper zzb;

    public zzfnb(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfnp zzfnpVarZza = zzfnr.zza();
        zzfnpVarZza.zza(this.zza.getPackageName());
        zzfnpVarZza.zzc(2);
        zzfnm zzfnmVarZza = zzfnn.zza();
        zzfnmVarZza.zza(str);
        zzfnmVarZza.zzb(2);
        zzfnpVarZza.zzb(zzfnmVarZza);
        new zzfnc(this.zza, this.zzb, (zzfnr) zzfnpVarZza.zzal()).zza();
    }
}
