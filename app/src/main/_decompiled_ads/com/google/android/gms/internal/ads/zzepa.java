package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepa implements zzetw {
    final zzcac zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgad zzd;
    private final Context zze;

    zzepa(Context context, zzcac zzcacVar, ScheduledExecutorService scheduledExecutorService, zzgad zzgadVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcD)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzcacVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzetw
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcz)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcE)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcA)).booleanValue()) {
                    return zzfzt.zzm(zzfqa.zza(this.zzb.getAppSetIdInfo()), new zzfsk() { // from class: com.google.android.gms.internal.ads.zzeox
                        @Override // com.google.android.gms.internal.ads.zzfsk
                        public final Object apply(Object obj) {
                            AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                            return new zzepb(appSetIdInfo.getId(), appSetIdInfo.getScope());
                        }
                    }, zzcbg.zzf);
                }
                Task<AppSetIdInfo> taskZza = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcD)).booleanValue() ? zzfer.zza(this.zze) : this.zzb.getAppSetIdInfo();
                if (taskZza == null) {
                    return zzfzt.zzh(new zzepb(null, -1));
                }
                ListenableFuture listenableFutureZzn = zzfzt.zzn(zzfqa.zza(taskZza), new zzfza() { // from class: com.google.android.gms.internal.ads.zzeoy
                    @Override // com.google.android.gms.internal.ads.zzfza
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzfzt.zzh(new zzepb(null, -1)) : zzfzt.zzh(new zzepb(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, zzcbg.zzf);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcB)).booleanValue()) {
                    listenableFutureZzn = zzfzt.zzo(listenableFutureZzn, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzcC)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzfzt.zze(listenableFutureZzn, Exception.class, new zzfsk() { // from class: com.google.android.gms.internal.ads.zzeoz
                    @Override // com.google.android.gms.internal.ads.zzfsk
                    public final Object apply(Object obj) {
                        this.zza.zza.zzu((Exception) obj, "AppSetIdInfoSignal");
                        return new zzepb(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzfzt.zzh(new zzepb(null, -1));
    }
}
