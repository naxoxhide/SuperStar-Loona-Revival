package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwq {
    private final zzgad zza;
    private final zzgad zzb;
    private final zzdxx zzc;
    private final zzhaw zzd;

    public zzdwq(zzgad zzgadVar, zzgad zzgadVar2, zzdxx zzdxxVar, zzhaw zzhawVar) {
        this.zza = zzgadVar;
        this.zzb = zzgadVar2;
        this.zzc = zzdxxVar;
        this.zzd = zzhawVar;
    }

    final /* synthetic */ ListenableFuture zza(zzbvg zzbvgVar, int i, zzdyo zzdyoVar) throws Exception {
        return ((zzeav) this.zzd.zzb()).zzc(zzbvgVar, i);
    }

    public final ListenableFuture zzb(final zzbvg zzbvgVar) {
        ListenableFuture listenableFutureZzf;
        String str = zzbvgVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzf = zzfzt.zzg(new zzdyo(1));
        } else {
            listenableFutureZzf = zzfzt.zzf(this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwn
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc(zzbvgVar);
                }
            }), ExecutionException.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdwo
                @Override // com.google.android.gms.internal.ads.zzfza
                public final ListenableFuture zza(Object obj) {
                    return zzfzt.zzg(((ExecutionException) obj).getCause());
                }
            }, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzfzt.zzf(listenableFutureZzf, zzdyo.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdwp
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zza(zzbvgVar, callingUid, (zzdyo) obj);
            }
        }, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream zzc(zzbvg zzbvgVar) throws Exception {
        zzcbl zzcblVar;
        final zzdxx zzdxxVar = this.zzc;
        synchronized (zzdxxVar.zzb) {
            if (zzdxxVar.zzc) {
                zzcblVar = zzdxxVar.zza;
            } else {
                zzdxxVar.zzc = true;
                zzdxxVar.zze = zzbvgVar;
                zzdxxVar.zzf.checkAvailabilityAndConnect();
                zzdxxVar.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdxxVar.zza();
                    }
                }, zzcbg.zzf);
                zzcblVar = zzdxxVar.zza;
            }
        }
        return (InputStream) zzcblVar.get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfu)).intValue(), TimeUnit.SECONDS);
    }
}
