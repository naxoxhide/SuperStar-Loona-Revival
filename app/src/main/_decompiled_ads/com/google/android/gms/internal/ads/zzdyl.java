package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdyl implements zzdyn {
    private final Map zza;
    private final zzgad zzb;
    private final zzdae zzc;

    public zzdyl(Map map, zzgad zzgadVar, zzdae zzdaeVar) {
        this.zza = map;
        this.zzb = zzgadVar;
        this.zzc = zzdaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    public final ListenableFuture zzb(final zzbvg zzbvgVar) {
        this.zzc.zzbr(zzbvgVar);
        ListenableFuture listenableFutureZzg = zzfzt.zzg(new zzdwm(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhX)).split(",")) {
            final zzhbp zzhbpVar = (zzhbp) this.zza.get(str.trim());
            if (zzhbpVar != null) {
                listenableFutureZzg = zzfzt.zzf(listenableFutureZzg, zzdwm.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdyj
                    @Override // com.google.android.gms.internal.ads.zzfza
                    public final ListenableFuture zza(Object obj) {
                        return ((zzdyn) zzhbpVar.zzb()).zzb(zzbvgVar);
                    }
                }, this.zzb);
            }
        }
        zzfzt.zzr(listenableFutureZzg, new zzdyk(this), zzcbg.zzf);
        return listenableFutureZzg;
    }
}
