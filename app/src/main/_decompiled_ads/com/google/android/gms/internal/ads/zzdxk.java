package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxk {
    private final ScheduledExecutorService zza;
    private final zzgad zzb;
    private final zzgad zzc;
    private final zzdyb zzd;
    private final zzhaw zze;

    public zzdxk(ScheduledExecutorService scheduledExecutorService, zzgad zzgadVar, zzgad zzgadVar2, zzdyb zzdybVar, zzhaw zzhawVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgadVar;
        this.zzc = zzgadVar2;
        this.zzd = zzdybVar;
        this.zze = zzhawVar;
    }

    final /* synthetic */ ListenableFuture zza(zzbvg zzbvgVar, int i, Throwable th) throws Exception {
        return ((zzeav) this.zze.zzb()).zzd(zzbvgVar, i);
    }

    public final ListenableFuture zzb(final zzbvg zzbvgVar) {
        ListenableFuture listenableFutureZzb;
        String str = zzbvgVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzb = zzfzt.zzg(new zzdyo(1));
        } else {
            listenableFutureZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzhx)).booleanValue() ? this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxi
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc(zzbvgVar);
                }
            }) : this.zzd.zzb(zzbvgVar);
        }
        final int callingUid = Binder.getCallingUid();
        return zzfzt.zzf((zzfzk) zzfzt.zzo(zzfzk.zzu(listenableFutureZzb), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfu)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzfza() { // from class: com.google.android.gms.internal.ads.zzdxj
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return this.zza.zza(zzbvgVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream zzc(zzbvg zzbvgVar) throws Exception {
        return (InputStream) this.zzd.zzb(zzbvgVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzfu)).intValue(), TimeUnit.SECONDS);
    }
}
