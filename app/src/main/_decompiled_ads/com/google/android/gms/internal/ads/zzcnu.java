package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcnu implements zzcnl {
    private final zzees zza;

    zzcnu(zzees zzeesVar) {
        this.zza = zzeesVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnl
    public final void zza(Map map) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzjC)).booleanValue()) {
            zzfzt.zzf(zzfzk.zzu(this.zza.zza(true)), Throwable.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzcnt
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzu((Throwable) obj, "GetTopicsApiWithRecordObservationActionHandler");
                    return zzfzt.zzh(new GetTopicsResponse(zzfvs.zzl()));
                }
            }, zzcbg.zza);
        }
    }
}
