package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdyh implements zzdag {
    private final Context zza;
    private final zzbyy zzb;

    zzdyh(Context context, zzbyy zzbyyVar) {
        this.zza = context;
        this.zzb = zzbyyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbr(zzbvg zzbvgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzbs(zzfde zzfdeVar) {
        if (TextUtils.isEmpty(zzfdeVar.zzb.zzb.zzd)) {
            return;
        }
        this.zzb.zzp(this.zza, zzfdeVar.zza.zza.zzd);
        this.zzb.zzl(this.zza, zzfdeVar.zzb.zzb.zzd);
    }
}
