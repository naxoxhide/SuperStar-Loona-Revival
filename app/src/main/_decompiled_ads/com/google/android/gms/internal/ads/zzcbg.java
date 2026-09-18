package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcbg {
    public static final zzgad zza;
    public static final zzgad zzb;
    public static final zzgad zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzgad zze;
    public static final zzgad zzf;

    static {
        Executor threadPoolExecutor;
        ExecutorService executorServiceZzc;
        ExecutorService executorServiceZzb;
        if (ClientLibraryUtils.isPackageSide()) {
            zzfpr.zza();
            threadPoolExecutor = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzcbc("Default")));
        } else {
            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcbc("Default"));
        }
        zzcbe zzcbeVar = null;
        zza = new zzcbf(threadPoolExecutor, zzcbeVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZzc = zzfpr.zza().zzc(5, new zzcbc("Loader"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcbc("Loader"));
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            executorServiceZzc = threadPoolExecutor2;
        }
        zzb = new zzcbf(executorServiceZzc, zzcbeVar);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZzb = zzfpr.zza().zzb(new zzcbc("Activeview"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcbc("Activeview"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            executorServiceZzb = threadPoolExecutor3;
        }
        zzc = new zzcbf(executorServiceZzb, zzcbeVar);
        zzd = new zzcbb(3, new zzcbc(AppEventsConstants.EVENT_NAME_SCHEDULE));
        zze = new zzcbf(new zzcbd(), zzcbeVar);
        zzf = new zzcbf(zzgaj.zzb(), zzcbeVar);
    }
}
