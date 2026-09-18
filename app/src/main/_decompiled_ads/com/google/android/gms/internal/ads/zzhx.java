package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhx {
    private final Context zza;
    private final zzhv zzb;

    public zzhx(Context context, Handler handler, zzhw zzhwVar) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzhv(this, handler, zzhwVar);
    }
}
