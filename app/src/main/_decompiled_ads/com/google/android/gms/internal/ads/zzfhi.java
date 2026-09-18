package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhi {
    final /* synthetic */ zzfhj zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    private zzfhi(zzfhj zzfhjVar, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        this.zza = zzfhjVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }

    public final zzfgw zza() {
        Object obj = this.zzb;
        String strZzf = this.zzc;
        if (strZzf == null) {
            strZzf = this.zza.zzf(obj);
        }
        final zzfgw zzfgwVar = new zzfgw(obj, strZzf, this.zzf);
        this.zza.zzd.zza(zzfgwVar);
        this.zzd.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfhf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zzd.zzc(zzfgwVar);
            }
        }, zzcbg.zzf);
        zzfzt.zzr(zzfgwVar, new zzfhg(this, zzfgwVar), zzcbg.zzf);
        return zzfgwVar;
    }

    public final zzfhi zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfhi zzc(Class cls, zzfza zzfzaVar) {
        return new zzfhi(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfzt.zzf(this.zzf, cls, zzfzaVar, this.zza.zzb));
    }

    public final zzfhi zzd(final ListenableFuture listenableFuture) {
        return zzg(new zzfza() { // from class: com.google.android.gms.internal.ads.zzfhe
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return listenableFuture;
            }
        }, zzcbg.zzf);
    }

    public final zzfhi zze(final zzfgu zzfguVar) {
        return zzf(new zzfza() { // from class: com.google.android.gms.internal.ads.zzfhd
            @Override // com.google.android.gms.internal.ads.zzfza
            public final ListenableFuture zza(Object obj) {
                return zzfzt.zzh(zzfguVar.zza(obj));
            }
        });
    }

    public final zzfhi zzf(zzfza zzfzaVar) {
        return zzg(zzfzaVar, this.zza.zzb);
    }

    public final zzfhi zzg(zzfza zzfzaVar, Executor executor) {
        return new zzfhi(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfzt.zzn(this.zzf, zzfzaVar, executor));
    }

    public final zzfhi zzh(String str) {
        return new zzfhi(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfhi zzi(long j, TimeUnit timeUnit) {
        return new zzfhi(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfzt.zzo(this.zzf, j, timeUnit, this.zza.zzc));
    }
}
