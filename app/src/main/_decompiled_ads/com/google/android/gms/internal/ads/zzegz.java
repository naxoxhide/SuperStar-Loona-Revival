package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegz implements zzdhf {
    private final zzfcr zza;
    private final zzbqv zzb;
    private final AdFormat zzc;
    private zzcyd zzd = null;

    zzegz(zzfcr zzfcrVar, zzbqv zzbqvVar, AdFormat adFormat) {
        this.zza = zzfcrVar;
        this.zzb = zzbqvVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdhf
    public final void zza(boolean z, Context context, zzcxy zzcxyVar) throws zzdhe {
        boolean zZzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 6) {
                        zZzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                    }
                    throw new zzdhe("Adapter failed to show.");
                }
                zZzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (zZzs) {
                if (this.zzd == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzbu)).booleanValue() || this.zza.zzaa != 2) {
                    return;
                }
                this.zzd.zza();
                return;
            }
            throw new zzdhe("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdhe(th);
        }
    }

    public final void zzb(zzcyd zzcydVar) {
        this.zzd = zzcydVar;
    }
}
