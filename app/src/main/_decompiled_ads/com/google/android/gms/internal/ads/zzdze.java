package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdze {
    private final zzgad zza;
    private final zzgad zzb;
    private final zzdzz zzc;
    private final zzhaw zzd;

    zzdze(zzgad zzgadVar, zzgad zzgadVar2, zzdzz zzdzzVar, zzhaw zzhawVar) {
        this.zza = zzgadVar;
        this.zzb = zzgadVar2;
        this.zzc = zzdzzVar;
        this.zzd = zzhawVar;
    }

    final /* synthetic */ ListenableFuture zza(zzbuo zzbuoVar) throws Exception {
        return this.zzc.zza(zzbuoVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzkB)).longValue());
    }

    final /* synthetic */ ListenableFuture zzb(zzbuo zzbuoVar, int i, zzdyo zzdyoVar) throws Exception {
        return ((zzebf) this.zzd.zzb()).zzb(zzbuoVar, i);
    }

    public final ListenableFuture zzc(final zzbuo zzbuoVar) {
        ListenableFuture listenableFutureZzf;
        String str = zzbuoVar.zzf;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzf = zzfzt.zzg(new zzdyo(1, "Ads service proxy force local"));
        } else {
            listenableFutureZzf = zzfzt.zzf(zzfzt.zzk(new zzfyz() { // from class: com.google.android.gms.internal.ads.zzdzb
                @Override // com.google.android.gms.internal.ads.zzfyz
                public final ListenableFuture zza() {
                    return this.zza.zza(zzbuoVar);
                }
            }, this.zza), ExecutionException.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzc
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
        final int callingUid = Binder.getCallingUid();
        return zzfzt.zzf(listenableFutureZzf, zzdyo.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdzd
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzbuoVar, callingUid, (zzdyo) obj);
            }
        }, this.zzb);
    }
}
