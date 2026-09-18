package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzk {
    private final zzgad zza;
    private final zzgad zzb;
    private final zzeac zzc;

    zzdzk(zzgad zzgadVar, zzgad zzgadVar2, zzeac zzeacVar) {
        this.zza = zzgadVar;
        this.zzb = zzgadVar2;
        this.zzc = zzeacVar;
    }

    final /* synthetic */ ListenableFuture zza(zzbuk zzbukVar) throws Exception {
        return this.zzc.zza(zzbukVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkA)).longValue());
    }

    public final ListenableFuture zzb(final zzbuk zzbukVar) {
        ListenableFuture listenableFutureZzf;
        String str = zzbukVar.zzb;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzf = zzfzt.zzg(new zzdyo(1, "Ads signal service force local"));
        } else {
            listenableFutureZzf = zzfzt.zzf(zzfzt.zzk(new zzfyz() { // from class: com.google.android.gms.internal.ads.zzdzg
                @Override // com.google.android.gms.internal.ads.zzfyz
                public final ListenableFuture zza() {
                    return this.zza.zza(zzbukVar);
                }
            }, this.zza), ExecutionException.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzh
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    ExecutionException executionException = (ExecutionException) obj;
                    Throwable cause = executionException.getCause();
                    ExecutionException cause2 = executionException;
                    if (cause != null) {
                        cause2 = executionException.getCause();
                    }
                    return zzfzt.zzg(cause2);
                }
            }, this.zzb);
        }
        return zzfzt.zzn(zzfzt.zzf(zzfzk.zzu(listenableFutureZzf), zzdyo.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzi
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(null);
            }
        }, this.zzb), new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzj
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                InputStream inputStream = (InputStream) obj;
                JSONObject jSONObject = new JSONObject();
                if (inputStream == null) {
                    return zzfzt.zzh(jSONObject);
                }
                try {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    jSONObject = new JSONObject(com.google.android.gms.ads.internal.util.zzt.zzM(new InputStreamReader(inputStream)));
                } catch (IOException | JSONException e) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzu(e, "AdsServiceSignalTask.startAdsServiceSignalTask");
                }
                return zzfzt.zzh(jSONObject);
            }
        }, this.zzb);
    }
}
